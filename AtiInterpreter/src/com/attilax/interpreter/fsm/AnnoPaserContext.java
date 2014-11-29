package com.attilax.interpreter.fsm;

import java.util.ArrayList;
import java.util.List;

 

public class AnnoPaserContext  extends Context {
	 //持有一个State类型的对象实例
    public State state;
    public State lastKeystate; 
	public Object rzt;
	public Token curToken=new Token();
	public List<Token> tokenList=new ArrayList<Token>();
	public char curchar;
	public char[] charArr;
	public int   curcharIndex;
    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
    	state=new NormalState();
    	if(curcharIndex>=sampleParameter.length())
    	{
    		state=new FinishState();
    	 	 state.handle(sampleParameter, this);
    		 return;
    		
    	}
    	 
    	curchar=charArr[curcharIndex];
    	//def todox if to swithc oao
    	
    	if(curchar=='@')
    		state=new AtState();
    	if(curchar=='(')
    		state=new LeftBrackt();
    	if(curchar==')')
    		state=new RightBrackt();
    	if(curchar=='=')
    		state=new EqxState();
    	if(curchar=='"')
    		state=new DoubleQuoeState();
     	if(curchar==',')
    	 	state=new commaState();
     
    	
        //转调state来处理
        state.handle(sampleParameter, this);
    }
}
