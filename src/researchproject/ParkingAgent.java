package researchproject;

import java.util.ArrayList;
import java.util.HashMap;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameters;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.grid.Grid;

public class ParkingAgent
{
	// Local variables definition
	private Grid<Object> grid;
	public int day;
	private int id;
	private int maximumcapacity;
	private int usedcapacity;
	private Role role;
	private int cycle=0;
	private int cyclecounter =0;
	
	
	private Context<Object> context;
	private boolean newInfo = false;
	
	
	
	private Knowledge knowledge = new Knowledge();
	private Knowledge lastweek;
	private ArrayList<ParkingAgent> contacts = new ArrayList<ParkingAgent>();	
	HashMap<Integer,Integer> filling = new HashMap<Integer,Integer>();
	/**
	 * Custom constructor
	 * @param context - context to which the forester is added
	 * @param grid - grid to which the forester is added
	 * @param id - an ID
	 */
	public ParkingAgent(Context<Object> context, Grid<Object> grid, int id, int maximumcapacity, Role role)
	{
		//Parameters params = RunEnvironment.getInstance().getParameters();
		
		this.context = context;
		this.grid = grid;
		this.id = id;
		this.maximumcapacity=maximumcapacity;
		this.role=role;
		initKnowledge();
	}
	private void initKnowledge()
	{
		PricingModel p = new SimplePricing();
		p.init();
		knowledge.addPricingModel(this, p);
	}
	public double getPrice(int day, int starttime, int staytime)
	{
		
		return knowledge.getPricingmodel(this).getPrice(day, starttime, staytime);
		
	}

	@ScheduledMethod(start = 1, interval = 24*7)
	public void nextDay()
	{
		if(day<7)
		{
			day++;
		}
		else
		{
			day=0;
			newWeek();
		}
		
	}
	
	public void newWeek()
	{
		updatePricing();
		lastweek = knowledge.getClone();
		cyclecounter = (cyclecounter + 1)%10;
		if(cyclecounter ==0)
		{
			cycle = (cycle +1)%5;
		}
	}
	public void updatePricing()
	{
		PricingModel p= knowledge.getPricingmodel(this);
		p.updateModel(knowledge, lastweek,this, cycle);
	}
	
	/** Search the whole grid for foresters, and all of them as contacts */
	private void addAllContacts()
	{
		Iterable<Object> objects = this.grid.getObjects();
		
		for (Object object : objects)
		{
			if (object.getClass() == ParkingAgent.class) { contacts.add((ParkingAgent) object); }
		}
	}
	

	public boolean checkin(int id,int checkin)
	{
		if(usedcapacity!=maximumcapacity)
		{
		filling.put(id, checkin);
		usedcapacity++;
		return true;
		}
		else
		{
			return false;
		}
	}
	
	public double checkout(int id, int checkout)
	{
		int checkin = filling.get(id);
		filling.remove(id);
		knowledge.addRevenue(this, day, knowledge.getPricingmodel(this).getPrice(day, checkin, checkout-checkin));
		usedcapacity--;
		return knowledge.getPricingmodel(this).getPrice(day, checkin, checkout-checkin);
	}
	
	
	/**
	 * Send message using radio transmitter
	 */
	public void sendRadioMessage()
	{
		Message message = new Message();
		message.setKnowledge(knowledge);
		
		for (ParkingAgent contact : contacts) { contact.recieveMessage(message); }
		
		newInfo = false; // All the new information was sent, over now
	}
	/**
	 * Receive message
	 * @param message - a message
	 */
	public void recieveMessage(Message message) { compareKnowledge(message.getKnowledge()); }
	/**
	 * Update the knowledge of the forester by taking info from a given knowledge
	 * @param k - knowledge to compare to
	 */
	public void compareKnowledge(Knowledge k)
	{

	}	
	
	public String toString()
	{
		String s="ID:"+id+"\n";
		s+="Role:"+role.toString()+"\n";
		s+="Maximumcapacity:"+maximumcapacity+"\n";
		s+="Pricing modells:\n"+knowledge.getPricingmodel(this).toString();
		return s;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

