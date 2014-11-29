package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class AttValExpression  extends AbstractExpression{

	public String val;
	public AttValExpression(String value) {
		val=value;
	}
	@Override
	public Object interpret(Context ctx) {
		return val;
		 
		
	}

}
