package com.attilax.interpreter.fsm;

public class EqxState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt = (AnnoPaserContext) context;
		char curchar = ctt.curchar;

		if (ctt.lastKeystate instanceof LeftBrackt || ctt.lastKeystate instanceof commaState) {
			Token tk = new Token();
			tk.value = ctt.curToken.value;
			ctt.tokenList.add(tk);
			ctt.tokenList.add(new Token() {
				{
					this.value = "=";
				}
			});
			ctt.curToken = new Token();
		} else
			ctt.curToken.value += curchar;
		ctt.curcharIndex++;

	}

}
