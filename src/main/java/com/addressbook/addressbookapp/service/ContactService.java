package com.addressbook.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.addressbook.addressbookapp.exception.ContactNotFoundException;
import com.addressbook.addressbookapp.exception.DuplicateContactException;
import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	
	List<Contact> addressBookList = new ArrayList<>();
	
	//Create contact
	public Contact createContact(Contact contact) {
		//validate email or phone number duplicate or not
		if(contactRepository.existsByEmail(contact.getEmail())) {
			throw new DuplicateContactException("Duplicate email found!");		
		}
		if(contactRepository.existsByPhoneNumber(contact.getPhoneNumber())) {
			throw new DuplicateContactException("Duplicate number found!");
		}		
		return contactRepository.save(contact);
	}
	
	//Get all contacts
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	//Get specific contact
	public Contact getById(Long id){
		return contactRepository.findById(id)
							.orElseThrow(()-> new ContactNotFoundException("Contact not found with id: "+id));
	}
	
//	//update by id
//	public Contact updateById(Long id, Contact contact) {
//		Contact contactData = addressBookList.stream()
//				.filter(x->Objects.equals(x.getUserId(), id))
//				.findFirst()
//				.orElse(null);
//		
//		if(contactData==null) {
//			throw new ContactNotFoundException("Contact not found with id: "+id);
//		}
//		
//		userData.setFirstName(contact.getFirstName());
//		userData.setLastName(contact.getLastName());
//		userData.setAddress(contact.getAddress());
//		userData.setCity(contact.getCity());
//		userData.setState(contact.getState());
//		userData.setZip(contact.getZip());
//		userData.setPhoneNumber(contact.getPhoneNumber());
//		userData.setEmail(contact.getEmail());
//		return userData;
//	}
//	
//	//delete by id 
//	public String deleteById(Long id) {
//		Contact userData = addressBookList.stream()
//				.filter(x->Objects.equals(x.getUserId(), id))
//				.findFirst()
//				.orElse(null);
//		
//		if(userData==null) {
//			throw new ContactNotFoundException("Contact not found with id: "+id);
//		}
//		
//		addressBookList.remove(userData);
//		return "Contact deleted with id: "+id;
//	}
}