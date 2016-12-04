package researchproject;

public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingAgent p = new ParkingAgent(null,null,1,1000,Role.CITYPARKING);
		System.out.println(p.getPrice(0, 1, 121));
		System.out.println(p.toString());
	}

}
