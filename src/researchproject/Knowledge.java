package researchproject;

import java.util.ArrayList;
import java.util.HashMap;

import fireFighters_MAS.Position;

public class Knowledge
{
	// Local variables declaration
	private HashMap<ParkingAgent,PricingModel> pricingmodel= new HashMap<ParkingAgent,PricingModel>();
	private HashMap<ParkingAgent, Integer> capacity =new HashMap<ParkingAgent, Integer> ();
	private HashMap<ParkingAgent,Position> parkingAgents = new HashMap<ParkingAgent,Position> ();
	private HashMap<ParkingAgent,double[]> revenue = new HashMap<ParkingAgent,double[]>();
	//private HashMap<ParkingAgent,double[]> change = new HashMap<ParkingAgent,double[]>();
	public void addRevenue(ParkingAgent p,int day,double a)
	{
		double[] d = revenue.get(p);
		d[day] += a;
		revenue.put(p, d);
	}
	public PricingModel getPricingmodel(ParkingAgent p)
	{
		return pricingmodel.get(p);
	}
	public void addPricingModel(ParkingAgent p,PricingModel pr)
	{
		pricingmodel.put(p, pr);
	}
	@SuppressWarnings("unchecked")
	public Knowledge getClone()
	{
		Knowledge k = new Knowledge();
		k.capacity=(HashMap<ParkingAgent, Integer>) capacity.clone();
		k.parkingAgents=(HashMap<ParkingAgent, Position>) parkingAgents.clone();
		k.pricingmodel=(HashMap<ParkingAgent, PricingModel>) pricingmodel.clone();
		k.revenue=(HashMap<ParkingAgent, double[]>) revenue.clone();
		return k;
	}
	public double[] getRevenue(ParkingAgent p)
	{
		return revenue.get(p);
	}
	
	
}
