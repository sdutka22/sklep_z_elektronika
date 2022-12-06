package pl.sdutka.electronic.shop.categories;

public class Tablet extends Device{
    private int camera;
    public Tablet(String brand, String model, int productionYear, String color, int RAM, int builtInMemory, double screenSize, int camera, double price, int productsAmount){
        super(brand, model, productionYear, color, RAM, builtInMemory, screenSize, price, productsAmount);

        this.camera = camera;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString(){
        return super.toString() +
                " Kamera tylna " +
                this.getCamera() +
                " Mpix";
    }
}
