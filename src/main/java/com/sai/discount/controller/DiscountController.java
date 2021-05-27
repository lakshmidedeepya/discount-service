package com.sai.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.discount.config.DiscountConfigMap;
import com.sai.discount.model.DiscountRequest;
import com.sai.discount.model.DiscountResponse;

@RestController("/discount")
@RefreshScope
public class DiscountController {
@Autowired
public DiscountConfigMap configmap;
	
@PostMapping("/cal")
public DiscountResponse calculateDiscount(@RequestBody DiscountRequest req) {
	double fixedCategoryDiscount=configmap.map.get(req.category);
	double onSpotDiscount=Math.floor(Math.random()*10);
	double dicper=fixedCategoryDiscount+onSpotDiscount;
	double Finalprice=Math.ceil(req.mrp-((dicper/100)*req.mrp));
	DiscountResponse res=new DiscountResponse();
	res.mrp=req.mrp;
	res.fixedCategoryDiscount=fixedCategoryDiscount;
	res.onSpotDiscount=onSpotDiscount;
	res.drp=Finalprice;
	
	//DiscountResponse res=new DiscountResponse(req.mrp,Finalprice,fixedCategoryDiscount,onSpotDiscount);
	return res;
	
	
}
}
