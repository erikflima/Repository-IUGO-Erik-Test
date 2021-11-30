package com.erik.project.controllers;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erik.project.dto.ScoreDto;
import com.erik.project.dto.ScoreDtoResponse;
import com.erik.project.entities.Score;
import com.erik.project.entities.User;
import com.erik.project.response.StandardizedResponse;
import com.erik.project.service.ScoreService;
import com.erik.project.service.UserService;


@RestController
@RequestMapping(value="/api/test-iugo/score", produces="application/json")
@CrossOrigin(origins = "*")
public class ScoreController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	ScoreService scoreService;


	private static final Logger log = LoggerFactory.getLogger( ScoreController.class );


	public ScoreController() {
	}


	@PostMapping("/scorePost")
	public ResponseEntity< StandardizedResponse<ScoreDtoResponse> > transactionRecording( @Valid @RequestBody ScoreDto      scoreDto,
			                                                                                                  BindingResult bindingResult ) throws NoSuchAlgorithmException {
		
		log.info("\nEndpoint: /api/test-iugo/score/scorePost");

		StandardizedResponse<ScoreDtoResponse> standardizedResponse = new StandardizedResponse<ScoreDtoResponse>();
		
		ScoreDtoResponse scoreDtoResponse = new ScoreDtoResponse();

		//--
				
		//Checking the validation of input data made automatically by Hibernate, based on the annotations made in the class.
		if ( bindingResult.hasErrors() ) {
			
			List<ObjectError> errorlist = bindingResult.getAllErrors();
			
			
			for( ObjectError auxiliary : errorlist  ){
				
				String extractedErrormessage = auxiliary.getDefaultMessage();
						
				standardizedResponse.getErrors().add(extractedErrormessage);
			}

			return ResponseEntity.badRequest().body( standardizedResponse );
		}	

		//--

		//I check if the user I received exists in the database.
		User user = userService.findById( scoreDto.getUserId() );
		if(user == null){

			standardizedResponse.getErrors().add("The user informed does not exist.");
			
			return ResponseEntity.badRequest().body( standardizedResponse );			
		}

		//--
			
		 //Verificar se o LeaderboardId esta vinculado ao usuario certo
		 // Se no achar nada no banco, significa que o user ainda no tem nenhum score
		 
		
		Score score = scoreService.findById( scoreDto.getLeaderboardId() );
		if( score == null){
			
			//Pessoa nao tem score, e vou salvar um novo.
			score = new Score();
			//score.setLeaderboardId(leaderboardId);
			
			
			
			
		}else{
			
			//Se achar, pego o id do user e comparo com o id do user que recebi no dto
			
			
			
			
			
			
			
			 //Verificar se o score que esta sendo eviado é maior que que o highestScoreEverMade
		}



		 
		 
		//--


		
		//
		/*

		 

		 

		   
		  

		*/
		
		//--

		
		standardizedResponse.setResponseContent( scoreDtoResponse );
		
		return ResponseEntity.ok().body( standardizedResponse );
	}	
	
/*
 Grava pontuacoes de um usuario	
e
Calcula classificação na "tabela de pontuação"	
	
Atualizar a pontuação do usuario se:
 - Se a pontuação foi enviado pelo proprio usuario
 - LeaderboardId was HIGHER than all previous scores posted for that UserId
	
	if the score posted for that UserId and 
	Postado pelo proprio usuario
	
	LeaderboardId was HIGHER than all previous scores posted for that UserId and 
	Se o valor postado for o maior ja postado anteriormente pra aquele usuario
	
	LeaderboardId combination (higher scores are better,and ranks should start at 1).
	
*/	
	
	
	
	
	
	
	
	//------------------------------------------------------------//	
	
	
}