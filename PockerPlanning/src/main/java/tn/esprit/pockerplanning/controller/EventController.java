package tn.esprit.pockerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pockerplanning.entities.Evenement;
import tn.esprit.pockerplanning.service.EventService;

import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
	
	@Autowired
	EventService sevent;

	//http://localhost:8080/pidev/event/add
		@PostMapping("/add")
		public Evenement addEvent(@RequestBody Evenement e){
			String image = e.getImage();

			e.setImage(image.substring(12));
			return sevent.addEvent(e);
		}
	@GetMapping("/paged")
	public Page<Evenement> getEventsPaged(@RequestParam(defaultValue = "1") int page,
										  @RequestParam(defaultValue = "10") int pageSize) {
		return sevent.getEvents(page, pageSize);
	}


		//http://localhost:8080/pidev/event/update
		@PutMapping("/update/{id}")
		public Evenement updateEvent(@RequestBody Evenement e,@PathVariable("id")Long id){

			return sevent.updateEvent(e,id);
		}
		
		//http://localhost:8080/pidev/event/delete/{id}
		 @DeleteMapping("/delete/{id}")
		 public String deleteEvent(@PathVariable("id")Long id ){
			 sevent.deleteEvent(id);
			 return "this event was deleted with success";
		 }
	@PutMapping("/updateRating/{id}")
	public Evenement updateEventRating(@PathVariable("id") Long id, @RequestParam("rating") int rating) {
		return sevent.updateEventRating(id, rating);
	}
		//http://localhost:8080/pidev/event/getbyid/{id}
		  @GetMapping("/getbyid/{id}")
		  public Evenement getEvent(@PathVariable("id")Long id){
			  return sevent.getEvent(id);
		  }
		  
		//http://localhost:8080/pidev/event/getall
		  @GetMapping("/getall")
		  public List<Evenement> getEvents(){
			  return sevent.getEvents();
		  }

}



