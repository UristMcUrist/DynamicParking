package researchproject;

import java.sql.Time;
import java.util.HashMap;

import org.jfree.data.time.Day;

public class SimplePricing implements PricingModel {

	private Price[] price = new Price[7];
	private double standartprice;
	
	@Override
	public double getPrice(int day, int start, int end) {
		// TODO Auto-generated method stub
		
			return price[day].getPrice(start, end);
	
	}

	@Override
	public void updateModel(Knowledge k, Knowledge oldk,ParkingAgent p,int cycle) {
		double[] revenueold = oldk.getRevenue(p);
		double[] currentrevenue = k.getRevenue(p);
		for(int i = 0; i< 7;i++)
		{
			double change = currentrevenue[i]-revenueold[i];
			price[i].updatePrice(change,cycle);
			
		}
		
	}
	public String toString()
	{
		String s="";
		for(int i = 0; i<price.length;i++)
		{
			s+="********************************************************************\n";
			switch(i){
				case 0: s+="Monday";
				break;
				case 1: s+="Tuesday";
				break;
				case 2: s+="Wednesday";
				break;
				case 3: s+="Thursday";
				break;
				case 4: s+="Friday";
				break;
				case 5: s+="Saturday";
				break;
				case 6: s+="Sunday";
				break;
				default: s+="Error";
				break;
			}
			s+= "\n";
			s+= price[i].toString();
			s+= "\n";
			s+="********************************************************************";
			s+="\n";
		}
		
		return s;
	}

	public void init()
	{
		for(int i = 0; i< price.length;i++)
		{
			price[i]= new Priceperhour();
			price[i].init();
			
		}
	}
	
	
}
