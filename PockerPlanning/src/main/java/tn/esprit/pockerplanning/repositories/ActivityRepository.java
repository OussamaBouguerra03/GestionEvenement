package tn.esprit.pockerplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.pockerplanning.entities.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("SELECT a FROM Activity a INNER JOIN Evenement e ON a.event = e.idEvent WHERE e.idEvent = :eventId")
    List<Activity> findActivitiesByEventId(@Param("eventId") Long eventId);

}