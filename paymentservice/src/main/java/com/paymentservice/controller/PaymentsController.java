package com.paymentservice.controller;

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

import com.paymentservice.entity.Payments;
import com.paymentservice.service.PaymentsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/payments")
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;

//	@Autowired
//	private PaymentsRepository paymentsRepository;

	@PostMapping(path = "/add")
	public ResponseEntity<Payments> save(@RequestBody Payments payments) {
		// log.info("Saving patient {}", payments);
		System.out.println("saving");
		paymentsService.save(payments);

		ResponseEntity<Payments> responseEntity = new ResponseEntity<>(payments, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "/{paymentId}")
	public ResponseEntity<Payments> getPatient(@PathVariable Long paymentId) {
		//log.info("Fetching payments {}", paymentId);
		Payments payments = paymentsService.get(paymentId);
		System.out.print("payments getted successfully");
		ResponseEntity<Payments> responseEntity = new ResponseEntity<>(payments,
				HttpStatus.OK);
		System.out.println("payments getted successfully1");
		return responseEntity;
		
	}
	
	
	@DeleteMapping(path="/{paymentId}")
	
	public String deletePatient(@PathVariable Long paymentId)
	
	{
		
		Payments payments = paymentsService.deleteById(paymentId);
		System.out.print("payments getted successfully");
		ResponseEntity<Payments> responseEntity = new ResponseEntity<>(payments,
				HttpStatus.OK);
		
		return "record deleted";
		
	}
	
//	@PutMapping(path="/update/{paymentId}")
//	public ResponseEntity<Payments> updateById(@RequestBody Payments payments) {
//		// log.info("Saving patient {}", payments);
//		System.out.println("updated successfully");
//		paymentsService.update(payments);
//
//		ResponseEntity<Payments> responseEntity = new ResponseEntity<>(payments, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	
	@PutMapping("/update/{paymentId}")
    public void updateEntity(@PathVariable Long paymentId, @RequestParam String paymentMode) {
        // Perform validation or error handling as needed

		
		
		paymentsService.updateEntity(paymentId, paymentMode);

       
    }
	
	
	
	


}
