package com.attilax.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.attilax.interpreter.exam.AbstractExpression;

public class Context {
	
	Stack<AbstractExpression> stack = new Stack<AbstractExpression>();
	public List<Anno> annoList=new ArrayList<Anno>();
	public Anno  curAnno=new Anno();
	// private HashMap map = new HashMap();
	public List<Attr> curAnno_AttrList=new ArrayList<Attr>();

//     public void assign(String key, String value) {
//
//         //往环境类中设值
//
//     }

//public String  lookup(String key) {
//	return key;
//
//         //获取存储在环境类中的值
//
//     }
}
