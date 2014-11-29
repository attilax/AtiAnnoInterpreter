package com.attilax.interpreter.fsm;

import com.attilax.designpatter.statepatter.ConcreteStateB;
import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;

public class fsmx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "@QueryAdptr(sqlwhere=\" clo1='@p' \",prop2=\"v2\") @Nofilt";
		// 创建环境
		AnnoPaserContext context = new AnnoPaserContext();
		// 将状态设置到环境中
		// 创建状态
		com.attilax.interpreter.fsm.State state = new iniState();
		context.setState(state);
		context.lastKeystate=new iniState();
		context.charArr=s.toCharArray();
		context.curcharIndex=0;
		 
		int n=0;
		while(!( context.state instanceof FinishState))
		{
		//	System.out.println(n);
		// 请求
		context.request(s);
		n++;
		if(n>200)
			break;
		}
		
		for (Token tk : context.tokenList) {
			if(tk.value.trim().length()>0)
			System.out.println(tk.value+"   || ");
		}
	//	System.out.println(context.rzt );
	}

}
