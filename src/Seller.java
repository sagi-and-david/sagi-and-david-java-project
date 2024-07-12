import java.util.Arrays;

public class Seller extends Human {
	private Product[] products;
	private int productsCount;
	
	public int getProductsCount() {
		return productsCount;
	}

	public Seller(String name, String password) {
		super(name, password);
		this.products = new Product[10]; // initiating with 10 if needed will be expanded
		this.productsCount = 0;
	}

	public Product[] getProducts() {
		return this.products;
	}

	public void expandProduct() {
		Product[] newProductsArray = new Product[this.products.length * 2];
		for (int i = 0; i < this.products.length; i++) {
			newProductsArray[i] = this.products[i];
		}
		this.products = newProductsArray;
	}


	public void addProduct(Product product) {
		if (this.productsCount >= this.products.length) {
			this.expandProduct();
		}
		this.products[this.productsCount] = product;
		
		this.productsCount++;
	}
	
	public String displayProducts() {
		String printText = "";
		for(int i = 0; i < this.products.length; i++) {
			if (this.products[i] == null) {
				break;
			}
		 printText += products[i].toString() + "\n";
		}
		return printText;
	}
	
	public Product getExistingProduct(String productName) {
		for (int i = 0; i<this.products.length; i ++) {
			if (this.products[i] == null) {
				return null;
			}
			if (productName.equals(this.products[i].getName())) {
				return this.products[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return super.toString() + " " + "Seller [products=" + Arrays.toString(products) + ", productsCount=" + productsCount + "]";
	}
	
	
}
