package menuPackage;

public class Drinks extends Menu {
	private String drinksType;
	public Drinks(int id, String name, String details, double price, String drinksType) {
		super(id, name, details, price);
		this.drinksType = drinksType;
	}
	public String getDrinksType() {
		return drinksType;
	}
	public void setDrinksType(String drinksType) {
		this.drinksType = drinksType;
	}
}
