package myDictionary.repository;

import myDictionary.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * CRUD Repository to manage {@link Word} instances. The interface declared to use Spring Data Rest
 * by {@code @RepositoryRestResource} with this repository.
 *
 * @author Dmytro Bondar
 */
@RepositoryRestResource
public interface WordRepository extends CrudRepository<Word, String> {

    /**
     * Returns all {@link Word}s in DataBase with sorted by their {@code rating} descending.
     *
     * @return
     */
    List<Word> findAllByOrderByRatingDesc();
}
