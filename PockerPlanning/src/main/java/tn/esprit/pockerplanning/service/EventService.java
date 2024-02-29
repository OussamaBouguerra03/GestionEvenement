package tn.esprit.pockerplanning.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import tn.esprit.pockerplanning.entities.Activity;
import tn.esprit.pockerplanning.entities.Evenement;
import tn.esprit.pockerplanning.entities.Supplier;
import tn.esprit.pockerplanning.repositories.ActivityRepository;
import tn.esprit.pockerplanning.repositories.EvenementRepository;
import tn.esprit.pockerplanning.repositories.SupplierRepository;
 import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EventService implements IEvent {

	@Autowired
	EvenementRepository erepo;
	@Autowired
	SupplierRepository srepo;
	@Autowired
	ActivityRepository arepo;

	@Override
	public Evenement addEvent(Evenement e) {
		// TODO Auto-generated method stub
		return erepo.save(e);
	}








	@Override
	public Evenement updateEvent(Evenement e, Long id) {
		Evenement ee= erepo.findById(id).get();
		ee.setAddress(e.getAddress());
		ee.setEventDate(e.getEventDate());
		ee.setHour(e.getHour());
 		ee.setNbPlace(e.getNbPlace());
		ee.setName(e.getName());
		ee.setDescription(e.getDescription());
		ee.setPrice(e.getPrice());
		ee.setImage(e.getImage().substring(12));
		return erepo.save(ee);
	}

	public Evenement updateEventRating(Long id, int rating) {
		Evenement event = erepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Event not found"));

 		event.setRating(rating);

 		return erepo.save(event);
	}
	@Override
	public void deleteEvent(Long id) {
		// TODO Auto-generated method stub
	    erepo.deleteById(id);
		
	}

	@Override
	public Evenement getEvent(Long id) {
		// TODO Auto-generated method stub
		return erepo.findById(id).get();
	}

	@Override
	public List<Evenement> getEvents() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}
	public Page<Evenement> getEvents(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return erepo.findAll(pageable);
	}
}
