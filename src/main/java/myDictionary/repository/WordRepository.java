package myDictionary.repository;

import myDictionary.domain.User;
import myDictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * CRUD Repository to manage {@link Word} instances. The interface declared to use Spring Data Rest
 * by {@code @RepositoryRestResource} with this repository.
 *
 * @author Dmytro Bondar
 */
@RepositoryRestResource
public interface WordRepository extends JpaRepository<Word, String> {

    /**
     * Returns all {@link Word}s in DataBase with sorted by their {@code rating} descending.
     *
     * @return
     */
    @RestResource(path = "findAll", rel = "findAll")
    List<Word> findAllByOrderByRatingDesc();

    @RestResource(path = "findUsers", rel = "findUsers")
    @Query(value = "select * from words where user_id = :id order by rating desc",nativeQuery=true)
    List<Word> findByUserIdOrderByRatingDesc(@Param("id") Integer id);
}
