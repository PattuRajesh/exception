package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.exception.ResponseHandler;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {
	
	@Autowired
	 private ProductService productService;
	  @GetMapping("/products")
	    public ResponseEntity<Object> Get(){
	        try {
	            List<Product> result = (List<Product>) productService.getProducts();
	            if(result==null){
	                throw new RecordNotFoundException("Record_Not_Found");
	            }
	            return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
	        }catch(Exception e){

	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	        }
}  

	  
	  
	 @PostMapping("/products")
	  public ResponseEntity<Object> Post(@RequestBody Product product){
	     // try{
	       Product result = productService.saveProduct(product);
	       if(result==null) {
	    	        throw new RecordNotFoundException("Record_Not_Found");
	       }
	  
	       else {
	    	   productService.saveProduct(product);
	       }
	     // }catch (Exception e){
	       return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
	      //    return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	     // }
	  }
	  @PutMapping("/update")
	    public ResponseEntity<Object> Update(@RequestBody Product product){
	        
	           Product result = productService.saveProduct(product);
	           // if(result==null){
	            //    throw new RecordNotFoundException("Record_Not_Found");
	           // }
	            return ResponseHandler.generateResponse("updated",HttpStatus.OK,result);
	        }
	            //return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
	        //}
	    //}
	  
	  
	   @DeleteMapping("/delete/{acm_sys_id}")
	    public ResponseEntity<Object> Delete(@PathVariable int acm_sys_id){
	        try{
	            String result = productService.deleteProduct(acm_sys_id);
	            if(result==null){
	                throw new RecordNotFoundException("Record_Not_Found");
	            }
	            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
	        }catch (Exception e){
	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	            
	        }
	    }
	  
	  @GetMapping("/products/{acm_sys_id}")
	  public ResponseEntity<Object> Get(@PathVariable int acm_sys_id) {
		  try{
		      Product result =  productService.getProductByAcm_sys_id(acm_sys_id);
		      if(result==null){
		          throw new RecordNotFoundException("Record_Not_Found");
		      }
		      return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
		  }catch(Exception e){
			  return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	            
		  }
}
}
