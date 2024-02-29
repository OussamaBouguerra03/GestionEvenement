package tn.esprit.pockerplanning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pockerplanning.entities.Supplier;
import tn.esprit.pockerplanning.service.SupplierService;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
	
	@Autowired
	SupplierService fserv;
	
	//http://localhost:8080/pidev/fournisseur/add
			@PostMapping("/add")
			public Supplier addSupplier(@RequestBody Supplier f){
				return fserv.addSupplier(f);
			}

			//http://localhost:8080/pidev/fournisseur/update
			@PutMapping("/update/{id}")
			public Supplier updateSupplier(@RequestBody Supplier f, @PathVariable("id")Long id){
				return fserv.updateSupplier(f,id);
			}
			
			//http://localhost:8080/pidev/fournisseur/delete/{id}
			 @DeleteMapping("/delete/{id}")
			 public String deleteSupplier(@PathVariable("id")Long id ){
				 fserv.deleteSupplier(id);
				 return "this supplier was deleted with success";
			 }
			 
			//http://localhost:8080/pidev/fournisseur/getbyid/{id}
			  @GetMapping("/getbyid/{id}")
			  public Supplier getSupplier(@PathVariable("id")Long id){
				  return fserv.getSupplier(id);
			  }
			  
			//http://localhost:8080/pidev/fournisseur/getall
			  @GetMapping("/getall")
			  public List<Supplier> getSuppliers(){
				  return fserv.getSuppliers();
			  }


}
