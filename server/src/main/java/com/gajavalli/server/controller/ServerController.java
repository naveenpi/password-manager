package com.gajavalli.server.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gajavalli.server.exceptions.ResourceNotFoundException;
import com.gajavalli.server.model.ServerModel;
import com.gajavalli.server.repository.ServerRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServerController {

	 @Autowired
	 private ServerRepository repository;

	 
	 ServerModel model=new ServerModel();
	
	 @GetMapping("/keys")
	 public List<ServerModel> keys() {
		
		List<ServerModel> list = repository.findAll();
		return list;
    
	 }
	 
	 @GetMapping("/hello")
	 public String hello() {
	
		return "welcome";
    
	 }
	 
	 @GetMapping("/keys/{id}")
	 public Optional<ServerModel> keyById(@PathVariable(value = "id") int id) {
		
		Optional<ServerModel> list = repository.findById(id);
		return list;
    
	 }
	 
	 @PostMapping("/create")
	 public String create(@RequestBody ServerModel fromWeb) {

		 repository.save(fromWeb);
		 return fromWeb.toString();
		
	 }
	 
	 @DeleteMapping("/keys/{id}")
		public Map<String, Boolean> deleteCredentials(@PathVariable(value = "id") int id)
				throws ResourceNotFoundException {
			ServerModel credentials = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Credentials not found for this id :: " + id));

			repository.delete(credentials);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	 }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<ServerModel> updateCredentials(@PathVariable(value = "id") int id,
	        @RequestBody ServerModel details) throws ResourceNotFoundException {
	        ServerModel sm = repository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Credentials not found for this id :: " + id));
	        System.out.println(details.toString());
	        sm.setUsername(details.getUsername());
	        sm.setPassword(details.getPassword());
	        sm.setUrl(details.getUrl());
	        final ServerModel smUpdated = repository.save(sm);
	        System.out.println(smUpdated.toString());
	        return ResponseEntity.ok(smUpdated);
	    }
	 
	 

}
