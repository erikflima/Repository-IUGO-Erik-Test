package com.erik.project.response;
import java.util.ArrayList;
import java.util.List;



//-----Class that serves to be the answer of my services of rest. Serve as a default answer.-----//
public class StandardizedResponse<ReceivedClass> {

	
	private ReceivedClass responseContent;
	private List<String>   errors;

	
	public StandardizedResponse(){
	}

	
	//-------------------------Getters and Setters----------------------//	

	public ReceivedClass getConteudoDoResponse() {
		
		return responseContent;
	}

	public void setConteudoDoResponse(ReceivedClass responseContent) {
		
		this.responseContent = responseContent;
	}
	
	
	public List<String> getErrors() {
		
		if (this.errors == null) {
			
			//Nao retorna "null", e sim um objeto vazio.
			this.errors = new ArrayList<String>();
		}
		
		return errors;
	}

	public void setErrors( List<String> errors ) {
		
		this.errors = errors;
	}

}