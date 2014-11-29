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

	// ����ı��ʽ

	private AbstractExpression expression;

	// ���캯������,������

	public Client(String expStr) {

		// ����һ����ջ������������Ⱥ�˳��

		Stack<AbstractExpression> stack = new Stack<AbstractExpression>();

		// ���ʽ���Ϊ�ַ�����

		 List<Token>  tokenList =(List<Token>) fsmx.getTokenList();

		// ����

		AbstractExpression left = null;

		AbstractExpression right = null;

		for (int i = 0; i < tokenList.size(); i++) {
		  Token tk=	tokenList.get(i);
			switch (tk.value) {

//			case "=": //    eq 
//
//				// �ӷ�����ŵ���ջ��
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

			default: // var in gonsi ��ʽ�еı���
				AbstractExpression 	left2 = new CommaItemExpression( new AttrNameExpression(tokenList.get(++i).value),new EqxlExpression(tokenList.get(++i).value),new AttValExpression(tokenList.get(++i).value) );

				stack.push(left2);

			}

		}

		// ���������׳���

		this.expression = stack.pop();

	}

	// start calc��ʼ����

	public Object run() {

		return this.expression.interpret(this.ctx);

	}

}