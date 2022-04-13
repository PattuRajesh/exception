package com.example.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.example.Exception.RecordNotFoundException;
import com.example.Model.SearchVehicle;
import com.example.Response.ResponseHandler;
import com.example.Response.SucessResponse;
import com.example.Service.SearchVehicleService;

@Controller
public class SearchVehicleController {
	
	@Autowired
	 private SearchVehicleService searchService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<SearchVehicle> Vehicles = searchService.listAll();
	    model.addAttribute("listSearchVehicles", Vehicles);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewVehiclePage(Model model) {
	  SearchVehicle search = new SearchVehicle();
	    model.addAttribute("search", search);
	      return "new_search";
	}
	  @GetMapping("/vehicle/edit/{regNo}")
	    public String EditVehicleDetail(@PathVariable Long regNo ,Model model) {
	       model.addAttribute("vehicle",searchService.get(regNo));
	       return "edit_search";
	    }
	  
	  @PostMapping("/save")
	    public String saveProduct(@ModelAttribute("search") SearchVehicle  search) {
	        searchService.saveVehicle(search);
	        return "redirect:/";
	    }
	
	  
	@RequestMapping("/delete/{regNo}")
	public String deleteProduct(@PathVariable(name = "regNo") Long regNo) {
	    searchService.delete(regNo);
	    return "redirect:/";       
	}
	

	  @GetMapping("/search")
	    public ResponseEntity<Object> Get(){
	        try {
	            List<SearchVehicle> result = searchService. getSearchVehicle();
//	            if(result==null){
//	                throw new RecordNotFoundException("Record_Not_Found");
//	            }
	            return  SucessResponse.generateResponse("Successfully retrieved all Data's!",HttpStatus.OK,result);
	        }catch(Exception e){

	        	return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
	        }
} 
	  
	  @GetMapping("/search/{regNo}")
	  public ResponseEntity<Object> Get(@PathVariable Long regNo) {
		  try{
		    SearchVehicle result = searchService. getSearchVehicleById(regNo);
		      if(result==null){
		          throw new RecordNotFoundException("Record_Not_Found");
		      }
		      return  SucessResponse.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
		  }catch(Exception e){
			  throw new RecordNotFoundException ("Record_Not_Found");
	            
		  }
}
	  @PostMapping("/search")
		 public  ResponseEntity<Object> saveVehicle( @RequestBody List<SearchVehicle> search){
			 try {
		        	 List<SearchVehicle> result =(List<SearchVehicle>) searchService.saveAll(search);
	            if(result==null){
		           throw new RecordNotFoundException("Record_Not_Found");
		            }
	  return  ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK);
	  }catch(Exception e){
		  throw new RecordNotFoundException ("Record_Not_Found");
            
	  }
}
}
	  
	 
