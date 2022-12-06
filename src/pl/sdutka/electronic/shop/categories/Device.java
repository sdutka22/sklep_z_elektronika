package pl.sdutka.electronic.shop.categories;
//Dodaj jeszcze jeden konstruktor strikte dla konsoli i tv, dodaj kolor, oraz dodatkowe parametry
public class Device {
    private String brand;
    private String model;
    private String color; // PAMIETAJ ABY DODAC DO KONSTRUKTORA I POTEM POZMIENIAC TEZ W RESZCIE!!!!!
    private int productionYear;
    private double price;
    private int productsAmount;
    private int RAM;
    private int builtInMemory;

    private double screenSize;

    public Device(String brand, String model, int productionYear, String color, int RAM, int builtInMemory, double screenSize, double price, int productsAmount){
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
        this.RAM = RAM;
        this.builtInMemory = builtInMemory;
        this.screenSize = screenSize;
        this.price = price;
        this.productsAmount = productsAmount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getBuiltInMemory() {
        return builtInMemory;
    }

    public void setBuiltInMemory(int builtInMemory) {
        this.builtInMemory = builtInMemory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductsAmount() {
        return productsAmount;
    }

    public void setProductsAmount(int productsAmount) {
        this.productsAmount = productsAmount;
    }

    @Override
    public String toString() {
        return "Brand: " +
                this.getBrand() +
                " Model: " +
                this.getModel() +
                " Rocznik: " +
                this.getProductionYear() +
                " Cena[PLN]: " +
                this.getPrice() +
                " Pamięć RAM [MB]: " +
                this.getRAM() +
                " Wbudowana pamięć [GB]: " +
                this.getBuiltInMemory() +
                " Dostepna Ilosc: " +
                this.getProductsAmount();
    }
}
