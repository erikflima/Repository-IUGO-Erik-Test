package com.erik.project.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/test-iugo/transaction", produces="application/json")
@CrossOrigin(origins = "*")
public class TransactionController {

	
	private static final Logger log = LoggerFactory.getLogger( TransactionController.class );


	public TransactionController() {
	}


	/*
	@GetMapping(value = "/timestamp") 
	public ResponseEntity< StandardizedResponse< TimestampDto > > getTimeStamp() throws NoSuchAlgorithmException {
		
		log.info("\nEndpoint: /api/test-iugo/time/timestamp");

		StandardizedResponse< TimestampDto >  standardizedResponse = new StandardizedResponse< TimestampDto >();

		//--
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // EX: 2021-03-24 16:34:26.666	
        TimestampDto timestampDto = new TimestampDto( timestamp );
		//--
        
		standardizedResponse.setConteudoDoResponse( timestampDto );
		
		return ResponseEntity.ok().body( standardizedResponse );
	}
	*/
	
}	
	