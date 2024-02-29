package tn.esprit.pockerplanning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pockerplanning.entities.Participation;
import tn.esprit.pockerplanning.service.ParticipationService;

import java.util.List;


@RestController
@RequestMapping("/participation")
@CrossOrigin(origins = "http://localhost:4200")
public class ParticipationController {

	@Autowired
	ParticipationService spart;
	
	//http://localhost:8080/pidev/participation/add

	@PostMapping("/add/{eventId}")
	public Participation addParticipation(@PathVariable ("eventId") Long eventId, @RequestBody Participation p){

		return spart.addParticipation( p,eventId);
	}

		//http://localhost:8080/pidev/participation/update
		@PutMapping("/update/{id}")
		public Participation updateParticipation(@RequestBody Participation p,@PathVariable("id")Long id){
			return spart.updateParticipation(p,id);
		}
		
		//http://localhost:8080/pidev/participation/delete/{id}
		 @DeleteMapping("/delete/{id}")
		 public String deleteParticipation(@PathVariable("id")Long id ){
			 spart.deleteParticipation(id);
			 return "this participation was deleted with success";
		 }
		 
		//http://localhost:8080/pidev/participation/getbyid/{id}
		  @GetMapping("/getbyid/{id}")
		  public Participation getParticipation(@PathVariable("id")Long id){
			  return spart.getParticipation(id);
		  }
		  
		//http://localhost:8080/pidev/participation/getall
		  @GetMapping("/getall")
		  public List<Participation> getParticipations(){
			  return spart.getParticipations();
		  }

}
