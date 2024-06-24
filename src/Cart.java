import java.util.Arrays;
import java.util.Date;

public class Cart {
	private Product[] products;
	private Date date;
	public Cart(Product[] products, Date date) {
		this.products = products;
		this.date = date;
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Cart [products=" + Arrays.toString(products) + ", date=" + date + "]";
	}
	
}
