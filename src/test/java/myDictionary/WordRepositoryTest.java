package myDictionary;

import myDictionary.domain.Word;
import myDictionary.repository.WordRepository;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Integration test for {@link WordRepository}.
 *
 * @author Dmytro Bondar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyDictionaryApplication.class)
public class WordRepositoryTest {

    @Autowired
    WordRepository repository;
    Word word = new Word();
    Iterable<Word> beforeList;

    @Before
    @Rollback(value = false)
    public void setDictionary(){
        beforeList = repository.findAll();
        repository.deleteAll();
        word.setWord("apple");
        word.setMeaning("a round fruit with firm, white flesh and a green, red, or yellow skin");
        repository.save(word);
        word.setWord("banana");
        word.setMeaning("a long, curved fruit with a yellow skin and soft, sweet, white flesh inside");
        word.setRating(15);
        repository.save(word);
        word.setWord("orange");
        word.setRating(0);
        word.setMeaning("a round sweet fruit that has a thick orange skin and an orange centre divided into many parts");
        repository.save(word);
    }

    @Test
    public void addWord()
    {
        word.setWord("dog");
        word.setMeaning("Animal what say woof");
        repository.save(word);
        assertNotNull(repository.findOne(word.getWord()));
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test()
    public void addNull()
    {
        word = null;
        thrown.expectCause(IsInstanceOf.<Throwable>instanceOf(IllegalArgumentException.class));
        repository.save(word);
    }

    @Test()
    public void addEmptyWord() {
        word.setWord("");
        word.setMeaning("meaning");
        thrown.expect(TransactionSystemException.class);
        repository.save(word);
    }

    @Test()
    public void addEmptyMeaning()
    {
        word.setWord("word");
        word.setMeaning("");
        thrown.expect(TransactionSystemException.class);
        repository.save(word);
    }

    @Test
    public void checkNotExistingWord(){
        word.setWord("cat");
        word.setMeaning("Animal what say meow");
        assertNull(repository.findOne(word.getWord()));
    }

    @Test
    public void checkDefaultRatingInWord(){
        word.setWord("cat");
        word.setMeaning("Animal what say meow");
        repository.save(word);
        assertEquals(0, word.getRating());
    }

    @Test
    public void updateRatingInWord(){
        word = repository.findOne("banana");
        word.setRating(10);
        repository.save(word);
        assertEquals(10, repository.findOne("banana").getRating());
    }

    @Test
    public void isOneWordEquals(){
        assertEquals(repository.findOne("banana").toString(),repository.findOne("banana").toString());
    }

    @Test
    public void isTwoWordEquals(){
        assertNotEquals(repository.findOne("apple").toString(), repository.findOne("banana").toString());
    }

    @Test
    public void getListOfWordByRating() {
        List<Word> list = new LinkedList<>();
        list.add(repository.findOne("banana"));
        list.add(repository.findOne("apple"));
        list.add(repository.findOne("orange"));
        assertEquals(list.toString(), repository.findAllByOrderByRatingDesc().toString());
    }

    @After
    public void restoreDB(){
        repository.deleteAll();
        for(Word word: beforeList){
            repository.save(word);
        }
    }

}
