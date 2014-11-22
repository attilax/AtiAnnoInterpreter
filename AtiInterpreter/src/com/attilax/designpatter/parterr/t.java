package com.attilax.designpatter.parterr;

import java.util.List;

import com.attilax.json.JsonUtil4jackjson;
import com.attilax.review.AlreadyReviewPassedEx;
import com.attilax.review.IReview;
import com.attilax.review.ReviewX;

public class t implements IReview {
	
	public t()
	{
		this.ReltDataCheckX1=new IReltDataCheckX() {

			@Override
			public void checkRelt_shouldBeNoRelt(int i) throws HasReltDataEx {
				if (i == 5)
					throw new HasReltDataEx("HasReltDataEx");
				
			}
		};
//		this.revChkX=new IReviewCheckX() {
//			
//			@Override
//			public void reviewPassedCheck_shouldBeYetNoReviewOrBack(int i) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
	}
   
	IReltDataCheckX  ReltDataCheckX1;
//	IReviewCheckX   revChkX;
	public static void main(String[] args) {
		System.out.println(new t().multiDel_byDwr());
	}

	private String multiDel_byDwr()
	{
	try {
		return	multiDel();
	} catch (PartProcessErrEx e) {
		e.setTypex("PartProcessErrEx");
		return toJsonStr( e);
	}
	//	return toJsonStr(new PartProcessErrEx(pex.li, "PartProcessErrEx"));
	
	
	}
	
	private String multiDel() throws PartProcessErrEx {
		PartErrX pex = new PartErrX();
		for (int i = 0; i < 10; i++) {
			try {
				del(i);
			 
			} catch (Exception e) {
				ErrorItem ei = new ErrorItem();
				ei.id = String.valueOf(i);
				ei.msg = e.getMessage();
				pex.add(ei);
				 
			}
		}
		if (pex.li.size() == 0)
			return "ok";

		throw  (new PartProcessErrEx( JsonUtil4jackjson.buildNormalBinder().toJson(pex.li) ));

	}

	private String toJsonStr(Object obj) {

		return JsonUtil4jackjson.buildNormalBinder().toJson(obj);
	}

	private void del(int i) throws HasReltDataEx, AlreadyReviewPassedEx {
		ReviewX.reviewPassedCheck_shouldBeYetNoReviewOrBack(i);
		ReltDataCheckX1.checkRelt_shouldBeNoRelt(i);
		
		if (i == 8)
			throw new RuntimeException("unkk");
		 
			

	}
	
	public void editAftSave(int i)
	{
		
	}

	@Override
	public boolean reviewPassed(Object obj) {
		return false;
//		int id=(int) obj;
//		if (i == 5)
//			throw new 
	}

}
