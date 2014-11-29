package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class AttrNameExpression  extends AbstractExpression{

	public String attname;
	public AttrNameExpression(String value) {
		attname=value;
	}
	@Override
	public Object interpret(Context ctx) {
		return attname;
		 
		
	}

}
