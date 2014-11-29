package com.attilax.interpreter.fsm;

public class iniState implements State {

 

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
	    char curchar=ctt.curchar;
	    
		  System.out.println(sampleParameter);
		
	}

}
