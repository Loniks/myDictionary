package myDictionary.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain class representing a {@link Word} instance.
 *
 * @author Dmytro Bondar
 */
@Entity
@Table(name="words")
public class Word {

    @Id
    @Column(name="word")
    @NotBlank
    private String word;

    @Column(name="meaning")
    @NotBlank
    private String meaning;

    @Column(name="rating")
    private int rating;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Word "+this.getWord()+" is meaning "+this.getMeaning()+
                " with rating "+this.getRating();
    }

}

