package tn.esprit.pockerplanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pockerplanning.entities.Supplier;
import tn.esprit.pockerplanning.repositories.SupplierRepository;

import java.util.List;


@Service
public class SupplierService implements ISupplier {

	@Autowired
	SupplierRepository frepo;
	@Override
	public Supplier addSupplier(Supplier f) {
		// TODO Auto-generated method stub
		return frepo.save(f);
	}

	@Override
	public Supplier updateSupplier(Supplier f, Long id) {
		// TODO Auto-generated method stub
		Supplier ff = frepo.findById(id).get();
		ff.setAdress(f.getAdress());
		ff.setDateDelivery(f.getDateDelivery());
		ff.setHourDelivery(f.getHourDelivery());
		ff.setName(f.getName());
		ff.setNumPhone(f.getNumPhone());
		return frepo.save(ff);
	}

	@Override
	public void deleteSupplier(Long id) {
		// TODO Auto-generated method stub
		frepo.deleteById(id);
		
	}

	@Override
	public Supplier getSupplier(Long id) {
		// TODO Auto-generated method stub
		return frepo.findById(id).get();
	}

	@Override
	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return frepo.findAll();
	}

}
