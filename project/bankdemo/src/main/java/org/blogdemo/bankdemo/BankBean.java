package org.blogdemo.bankdemo;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.camel.Exchange;

public class BankBean {
	int countError=0;
	
	public static final int DIAMOND_FEE = 1;
	public static final int GOLD_FEE = 2;
	public static final int NORMAL_FEE = 3;
	
	public void transfer(Exchange oldExchange, Exchange newExchange)throws Exception{
		Integer amtDeduct = ((Integer)newExchange.getIn().getHeader("amt",Integer.class));
		newExchange.getIn().setHeader("amt", amtDeduct * -1);
	}
	
	public void doBalance(Exchange oldExchange, Exchange newExchange)throws Exception{
		
		ArrayList<HashMap<String, Object>> balanceList =(ArrayList<HashMap<String, Object>>) newExchange.getIn().getBody(ArrayList.class);	
		HashMap<String, Object> result = balanceList.get(0);
		Integer newBalance = ((Integer)result.get("BALANCE")) +((Integer)newExchange.getIn().getHeader("amt",Integer.class));
		
		if("Diamond".equalsIgnoreCase(newExchange.getIn().getHeader("amt",String.class))){
			newBalance -= DIAMOND_FEE;
		}else if("Gold".equalsIgnoreCase(newExchange.getIn().getHeader("amt",String.class))){
			newBalance -= GOLD_FEE;
		}else{
			newBalance -= NORMAL_FEE;
		}
		
		if(newBalance < 0){
			throw new Exception("NOT ENOUGH BALANCE");
		}
		
		newExchange.getIn().setBody(newBalance);
		System.out.println( "--->newBalance :["+newBalance+"]" );
	} 
	
	public void doBalanceWithoutFee(Exchange oldExchange, Exchange newExchange)throws Exception{
		
		ArrayList<HashMap<String, Object>> balanceList =(ArrayList<HashMap<String, Object>>) newExchange.getIn().getBody(ArrayList.class);	
		HashMap<String, Object> result = balanceList.get(0);
		Integer newBalance = ((Integer)result.get("BALANCE")) +((Integer)newExchange.getIn().getHeader("amt",Integer.class));
		
		
		if(newBalance < 0){
			throw new Exception("NOT ENOUGH BALANCE");
		}
		
		newExchange.getIn().setBody(newBalance);
		System.out.println( "--->newBalance :["+newBalance+"] countError:["+countError+"]" );
		
	} 	
	

}
