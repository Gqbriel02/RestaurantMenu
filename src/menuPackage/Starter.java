package menuPackage;

public class Starter extends Menu {
	private String starterType;
	
	public Starter(int id, String name, String details, double price, String starterType) {
		super(id, name, details, price);
		this.starterType = starterType;
	}
	public String getStarterType() {
		return starterType;
	}
	public void setStarterType(String starterType) {
		this.starterType = starterType;
	}
}
