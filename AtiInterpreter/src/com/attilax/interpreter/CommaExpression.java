package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

/**
 * non termina exp
 * @author Administrator
 *
 */
public class CommaExpression  extends  AbstractExpression {

	 private  AbstractExpression left;

     private  AbstractExpression right;
     public  CommaExpression(AbstractExpression left,AbstractExpression right) {

         this.left=left;

         this.right=right;

  }
	@Override
	public Object interpret(Context ctx) {
		// (
		 left.interpret(ctx);
		 return right.interpret(ctx);
		
	}

}
