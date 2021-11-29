package com.erik.project.controllers;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erik.project.dto.TimestampDto;
import com.erik.project.response.StandardizedResponse;


@RestController
@RequestMapping(value="/api/test-iugo/time", produces="application/json")
@CrossOrigin(origins = "*")
public class TimeController {

	
	private static final Logger log = LoggerFactory.getLogger( TimeController.class );


	public TimeController() {
	}


	@GetMapping(value = "/timestamp") 
	public ResponseEntity< StandardizedResponse< TimestampDto > > getTimeStamp() throws NoSuchAlgorithmException {
		
		log.info("\nEndpoint: /api/test-iugo/time/timestamp");

		StandardizedResponse< TimestampDto >  standardizedResponse = new StandardizedResponse< TimestampDto >();

		//--
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // EX: 2021-03-24 16:34:26.666	
        TimestampDto timestampDto = new TimestampDto( timestamp );
		//--
        
		standardizedResponse.setResponseContent( timestampDto );
		
		return ResponseEntity.ok().body( standardizedResponse );
	}
	
}	
	