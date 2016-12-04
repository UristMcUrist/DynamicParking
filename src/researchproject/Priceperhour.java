package researchproject;

public class Priceperhour implements Price{

	public double eurospermin;
	public double learningiteration = 1;
	private double[] priceequation =  {1,100,1,1,1};  //minprice, maxprice , pricepermin, priceinflation
	private double[] pricedirect = {1,1,1,1,1}; 
	@Override
	public double getPrice(int start, int duration) {
		// TODO Auto-generated method stub
//		String starttime =timeToString(start);
//		String endtime =timeToString(end);
//		int starthour =Integer.parseInt( starttime.substring(0, 2));
//		int startmin = Integer.parseInt(starttime.substring(2,4));
//		int endhour = Integer.parseInt(endtime.substring(0, 2));
//		int endmin = Integer.parseInt(endtime.substring(2,4));
		double slots = duration/60.0;
		if(slots!=((int)slots))
		{
			slots = (int) (slots+1);
		}
		int flots =(int) slots;
		
		double res =0;
		for(int i = 0; i<slots;i++)
		{
			res +=  (Math.pow(priceequation[3],i)*priceequation[2]);
		}
		if(res < priceequation[0])
		{
			res = priceequation[0];
		}
		else if(res > priceequation[1])
		{
			res = priceequation[1];
		}
		
		return res;
	}
	public String timeToString(int time)
	{
		String output ="";
		if(time<1000)
		{
			output+="0";
		}
		if(time<100)
		{
			output+="0";
		}
		if(time<10)
		{
			output+="0";
		}
		output+="time";
		return output;
	}
	
	@Override
	public void updatePrice(double gradient,int cycle) {
		if(pricedirect[cycle]<0)
		{
			if(gradient >0)
			{
				priceequation[cycle] += gradient * -1;
				pricedirect[cycle] = -1;
			}
			else
			{
				priceequation[cycle] += gradient*-1 ;
				pricedirect[cycle] = 1;
			}
			
		}
		else
		{
			if(gradient <0)
			{
				priceequation[cycle] += gradient;
				pricedirect[cycle] = -1;
			}
			else
			{
				priceequation[cycle] += gradient ;
				pricedirect[cycle] = 1;
			
		}
		
	}

}
	
	public void init()
	{
		double [] newerg= {1,100,1,1,1};
		this.priceequation=newerg;
		double[]newdirect ={1,1,1,1,1};
		this.pricedirect=newdirect;
	}
	
	public String toString()
	{
		String s="";
		s+="********************************************************************\n";
		s+="*\t " +priceequation[2] +"\t Euro(s) per hour \t\t*\n";
		s+="*\t Minimal price to pay: \t"+priceequation[1]+"\t\t*\n";
		s+="*\t Maximal price to pay: \t"+priceequation[0]+"\t\t*\n";
		s+="*\t Price change per hour:\t"+priceequation[3]+"\t\t*\n";
		s+="********************************************************************\n";
		return s;
	}

}


	