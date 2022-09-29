package com.scii.util;

import java.util.List;

import com.scii.model.Product;

public interface CalculationUtil {
  
	public static void blogic(Product p) {
		Double cost = p.getProdCost();
		p.setProdDisc(cost*12/100);
		p.setProdgst(cost*18/100);
		
	}
}
