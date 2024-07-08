
public class SpecialProduct extends Product{
	private boolean special;
	private double addedPrice;
	public SpecialProduct(String name, double price, String category, boolean special, double addedPrice) {
		super(name, price, category);
		this.special = special;
		this.addedPrice = addedPrice;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	public double getAddedPrice() {
		return addedPrice;
	}
	public void setAddedPrice(double addedPrice) {
		this.addedPrice = addedPrice;
	}
    @Override
    public String toString() {
        return super.toString() + " [special=" + special + ", addedPrice=" + addedPrice + "]";
    }
	

}
