package com.addressbook.addressbookapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.addressbookapp.dto.User;

@RequestMapping("/v1/api")
@RestController
public class AddressBookController {
	
	List<User> addressBookList = new ArrayList<>();
	
	
	//POST: Create contact
	@PostMapping("/contacts")
	public User creaetContact(@RequestBody User user) {
		addressBookList.add(user);
		return user;
	}
	
	//GET: Get all contacts
	@GetMapping("/contacts")
	public List<User> getAllContacts(){
		return addressBookList;
	}
	
	//GET by ID: Get specific contact
	@GetMapping("/contacts/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		User userData = addressBookList.stream()
										.filter(x-> x.getUserId()==id)
										.findFirst()
										.orElse(null);
		if(userData==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userData);
	}
	
	//PUT: Update contact by ID
	@PutMapping("/contacts/{id}")
	public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User user){
		User userData = addressBookList.stream()
										.filter(x->Objects.equals(x.getUserId(), id))
										.findFirst()
										.orElse(null);
		if(userData==null) {
			return ResponseEntity.notFound().build();
		}
		userData.setFirstName(user.getFirstName());
		userData.setLastName(user.getLastName());
		userData.setAddress(user.getAddress());
		userData.setCity(user.getCity());
		userData.setState(user.getState());
		userData.setZIP(user.getZIP());
		userData.setNumber(user.getNumber());
		userData.setEmail(user.getEmail());
		return ResponseEntity.ok(userData);
	}
	
	//DELETE: Delete contact
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id){
		User userData = addressBookList.stream()
										.filter(x-> x.getUserId()==id)
										.findFirst()
										.orElse(null);
		if(userData==null) {
			return ResponseEntity.notFound().build();
		}
		addressBookList.remove(userData);
		return ResponseEntity.ok(userData);
	}
}