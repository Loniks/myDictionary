package myDictionary.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Domain class representing a {@link Word} instance.
 *
 * @author Dmytro Bondar
 */
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Integer wordId;

    @Column(name = "word")
    private String word;

    @Column(name = "meaning")
    private String meaning;

    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="user_id")
    private User user;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Word " + this.getWord() + " is meaning " + this.getMeaning() +
                " with rating " + this.getRating();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        if (getRating() != word1.getRating()) return false;
        if (!getWord().equals(word1.getWord())) return false;
        return getMeaning().equals(word1.getMeaning());

    }

    @Override
    public int hashCode() {
        int result = getWord().hashCode();
        result = 31 * result + getMeaning().hashCode();
        result = 31 * result + getRating();
        return result;
    }

}

