package menuPackage;

public class MainDish extends Menu {
	private String cuisine;
	
	public MainDish(int id, String name, String details, double price, String cuisine) {
		super(id, name, details, price);
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
}
