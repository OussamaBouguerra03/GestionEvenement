package tn.esprit.pockerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pockerplanning.entities.Activity;
import tn.esprit.pockerplanning.entities.Evenement;
import tn.esprit.pockerplanning.repositories.ActivityRepository;
import tn.esprit.pockerplanning.service.ActivityService;

import java.util.List;


@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

	@Autowired
	ActivityService sact;
	@Autowired
	ActivityRepository actrepo;


	// http://localhost:8080/activity/add
	@PostMapping("/add")
	public Activity addActivity(@RequestBody Activity a) {
		String picture = a.getPicture();

		a.setPicture(picture.substring(12));
		return sact.addActivity(a);
	}
	@GetMapping("/byEvent/{eventId}")
	public List<Activity> getActivitiesByEventId(@PathVariable("eventId") Long eventId) {
		return actrepo.findActivitiesByEventId(eventId);
	}

	//http://localhost:8080/pidev/event/add

	// http://localhost:8080/pidev/activity/update
	@PutMapping("/update/{id}")
	public Activity updateActivity(@RequestBody Activity a, @PathVariable("id") Long id) {
		return sact.updateActivity(a, id);
	}

	// http://localhost:8080/pidev/activity/delete/{id}
	@DeleteMapping("/delete/{id}")
	public String deleteActivity(@PathVariable("id") Long id) {
		sact.deleteActivity(id);
		return " this activity was deleted with success";
	}

	// http://localhost:8080/pidev/activity/getbyid/{id}
	@GetMapping("/getbyid/{id}")
	public Activity getActivity(@PathVariable("id") Long id) {
		return sact.getActivity(id);
	}

	// http://localhost:8080/pidev/activity/getall
	@GetMapping("/getall")
	public List<Activity> getActivities() {
		return sact.getActivities();
	}

	// ActivityService.java


	@GetMapping("/pagedd")
	public Page<Activity> getEventsPaged(@RequestParam(defaultValue = "1") int page,
										  @RequestParam(defaultValue = "10") int pageSize) {
		return sact.getActs(page, pageSize);
	}

}
