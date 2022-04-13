package com.example.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Model.SearchVehicle;
import com.example.Repository.SearchVehicleRepository;

@Service
public  class SearchVehicleService {
	
	@Autowired
	private SearchVehicleRepository searchRepo;

	public SearchVehicle getSearchVehicleById(Long regNo) {
		return searchRepo.findById(regNo).orElse(null);
	}

	public List<SearchVehicle> getSearchVehicle() {
				return searchRepo.findAll();
	}
	public List<SearchVehicle> saveAll(List<SearchVehicle> search) {
		 return (List<SearchVehicle>) searchRepo.saveAll(search);
	}

	   public SearchVehicle saveVehicle(SearchVehicle search) {
	        return searchRepo.save(search);
	    }
	
	public List<SearchVehicle> listAll() {
		  return searchRepo.findAll();
	}

	public SearchVehicle get(Long regNo) {
		 return searchRepo.findById(regNo).get();
	}

	public void delete(Long regNo) {
		searchRepo.deleteById(regNo);
		
	}
	
   

}