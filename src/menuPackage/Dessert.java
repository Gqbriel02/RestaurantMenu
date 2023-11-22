package menuPackage;

public class Dessert extends Menu {
	private String dessertType;
	public Dessert(int id, String name, String details, double price, String dessertType) {
		super(id, name, details, price);
		this.dessertType = dessertType;
	}
	public String getDessertType() {
		return dessertType;
	}
	public void setDessertType(String dessertType) {
		this.dessertType = dessertType;
	}	
}
