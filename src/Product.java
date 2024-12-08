public class Product {
    private String name;
    private double price;
    private String category;
    private int serialNumber;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.serialNumber = createSerialNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    private int createSerialNumber() {
    	int max = 1000000000;
    	int min = 100000000;
        return (int) (Math.random() * (max - min) + min);
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", category=" + category + ", serialNumber="
                + serialNumber + "]";
    }
}
