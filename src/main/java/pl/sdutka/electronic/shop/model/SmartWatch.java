package pl.sdutka.electronic.shop.model;

public class SmartWatch extends Device{
    public SmartWatch(String brand, String model, int productionYear, String color, int RAM, int builtInMemory, double screenSize, double price, int productsAmount) {
        super(brand, model, productionYear, color, RAM, builtInMemory, screenSize, price, productsAmount);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
