package com.attilax.interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.exam.VarExpression;
import com.attilax.interpreter.fsm.Token;
import com.attilax.interpreter.fsm.fsmx;

public class Client {
	
public	Context ctx;

	// 定义的表达式

	private AbstractExpression expression;

	// 构造函数传参,并解析

	public Client(String expStr) {

		// 定义一个堆栈，安排运算的先后顺序

		Stack<AbstractExpression> stack = new Stack<AbstractExpression>();

		// 表达式拆分为字符数组

		 List<Token>  tokenList =(List<Token>) fsmx.getTokenList();

		// 运算

		AbstractExpression left = null;

		AbstractExpression right = null;

		for (int i = 0; i < tokenList.size(); i++) {
		  Token tk=	tokenList.get(i);
			switch (tk.value) {

//			case "=": //    eq 
//
//				// 加法结果放到堆栈中
//
//				left = stack.pop();
//
//				right = new VarExpression(String.valueOf(tk.value));
//
//				stack.push(new EqxlExpression(left, right));
//
//				break;
			case ",": //  comma exp 

	 			left = stack.pop();

				right = new CommaItemExpression( new AttrNameExpression(tokenList.get(++i).value),new EqxlExpression(tokenList.get(++i).value),new AttValExpression(tokenList.get(++i).value) );

				stack.push(new CommaExpression(left, right));

				break;

//			case '-':
//
//				left = stack.pop();
//
//				right = new VarExpression(String.valueOf(tokenList[++i]));
//
//				stack.push(new SubExpression(left, right));
//
//				break;

			default: // var in gonsi 公式中的变量
				AbstractExpression 	left2 = new CommaItemExpression( new AttrNameExpression(tokenList.get(++i).value),new EqxlExpression(tokenList.get(++i).value),new AttValExpression(tokenList.get(++i).value) );

				stack.push(left2);

			}

		}

		// 把运算结果抛出来

		this.expression = stack.pop();

	}

	// start calc开始运算

	public Object run() {

		return this.expression.interpret(this.ctx);

	}

}