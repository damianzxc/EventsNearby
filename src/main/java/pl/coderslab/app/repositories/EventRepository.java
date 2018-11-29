package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> getEventsByCategoryId(Long id);

//    @Query("select e from Event e where e.name like :name")
    List<Event> getEventsByNameLikeOrderByStartDate(String name);

    @Query("select e from Event e where e.category = :category")
    List<Event> getEventsByCategoryName(String category);

    @Query("select e from Event e order by e.startDate")
    List<Event> getAllOrderByEndDate();

    List<Event> getEventsByUserId(Long id);

}
