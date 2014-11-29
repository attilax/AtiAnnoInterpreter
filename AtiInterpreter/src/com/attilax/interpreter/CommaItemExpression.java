package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

/**
 * non termina exp
 * @author Administrator
 *
 */
public class CommaItemExpression  extends  AbstractExpression {

	 

      public AttrNameExpression  attNameExp;
  	public EqxlExpression  eqExp;
  	public AttValExpression  attValExp;

    
	public CommaItemExpression(AttrNameExpression attrNameExpression,
			EqxlExpression eqxlExpression, AttValExpression attValExpression) {
		attNameExp =attrNameExpression;
		eqExp=eqxlExpression;attValExp=attValExpression;
	}


	@Override
	public Object interpret(Context ctx) {
		// (
			Attr a=new Attr();
			a.key=(String) attNameExp.interpret(ctx);
			a.val=(String) attValExp.interpret(ctx);
	 	  ctx.curAnno_AttrList.add(a);
	 	 return a;
		
	}

}
