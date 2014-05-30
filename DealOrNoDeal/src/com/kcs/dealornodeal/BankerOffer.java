package com.kcs.dealornodeal;

import java.util.ArrayList;
import java.util.Hashtable;

public class BankerOffer {
	
	Hashtable<Integer, Integer> numberAmounts = new Hashtable<Integer,Integer>(){{
	    put(0, 100);
	    put(1, 250);
	    put(2, 500);
	    put(3, 750);
	    put(4, 1000);
	    put(5, 2500);
	    put(6, 5000);
	    put(7, 7500);
	    put(8, 10000);
	    put(9, 25000);
	    put(10, 50000);
	    put(11, 75000);
	    put(12, 100000);
	    put(13, 250000);
	    put(14, 500000);
	    put(15, 750000);
	    put(16, 1000000);
	    
	}};
	
	private int sum = 0;
	ArrayList<Integer> amountAvailable = new ArrayList<Integer>();
	
	
	public String getOffer(ArrayList<Integer> csn){
		
		for(int i=0; i <numberAmounts.size();i++){
			
			if(!csn.contains(i)){
				amountAvailable.add(numberAmounts.get(i));
				sum = sum + numberAmounts.get(i);
				//System.out.println("numberAmounts.get(" + i + ")" + numberAmounts.get(i));
				
			}
		}
		//System.out.println("csn size " + csn.size());
		//for(int a=0; a <csn.size();a++){
			//System.out.println("csn.get(" + a + ")"+ csn.get(a));
			//}
		System.out.println("sum" + sum);
		System.out.println("amountAvailable size " + amountAvailable.size());
		String stringsum = "" + sum/amountAvailable.size();				
		return stringsum;
	}
}
