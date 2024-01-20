package com.membershipservice.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.membershipservice.entity.Membership;
import com.membershipservice.service.MembershipService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Membership")
public class MembershipController {

	@Autowired
	private MembershipService MembershipService;

//	@Autowired
//	private MembershipRepository MembershipRepository;

	@PostMapping(path = "/add")
	public ResponseEntity<Membership> save(@RequestBody Membership Membership) {
		// log.info("Saving patient {}", Membership);
		System.out.println("saving");
		MembershipService.save(Membership);

		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(Membership, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "/{paymentId}")
	public ResponseEntity<Membership> getPatient(@PathVariable Long paymentId) {
		//log.info("Fetching Membership {}", paymentId);
		Membership Membership = MembershipService.get(paymentId);
		System.out.print("Membership getted successfully");
		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(Membership,
				HttpStatus.OK);
		System.out.println("Membership getted successfully1");
		return responseEntity;
		
	}
	
	
	@DeleteMapping(path="/{paymentId}")
	
	public String deletePatient(@PathVariable Long paymentId)
	
	{
		
		Membership Membership = MembershipService.deleteById(paymentId);
		System.out.print("Membership getted successfully");
		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(Membership,
				HttpStatus.OK);
		
		return "record deleted";
		
	}
	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<Membership> updateById(@RequestBody Membership Membership) {
//		// log.info("Saving patient {}", Membership);
//		System.out.println("updated successfully");
//		MembershipService.update(Membership);
//
//		ResponseEntity<Membership> responseEntity = new ResponseEntity<>(Membership, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@PutMapping("/update/{paymentId}")
    public void updateEntity(@PathVariable Long paymentId, @RequestParam String paymentMode) {
        // Perform validation or error handling as needed

		
		
		MembershipService.updateEntity(paymentId, paymentMode);

       
    }
	
	
	
	


}
