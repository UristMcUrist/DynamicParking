package researchproject;

public interface Price {

	public double getPrice(int start, int time);
	public void updatePrice(double gradient,int cycle);
	public String toString();
	public void init();
}
