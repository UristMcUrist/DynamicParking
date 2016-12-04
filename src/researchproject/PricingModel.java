package researchproject;

import java.sql.Time;
import java.util.HashMap;

import org.jfree.data.time.Day;

public interface PricingModel {

	
	
	public double getPrice(int day, int start, int end);
	public void updateModel(Knowledge k, Knowledge oldk, ParkingAgent p, int cycle);
	public String toString();
	public void init();
	
}
