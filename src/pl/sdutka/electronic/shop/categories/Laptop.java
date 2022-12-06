package pl.sdutka.electronic.shop.categories;

public class Laptop extends Device{
    private String Processor;
    private String GraphicCard;
    private String OperatingSystem;

    public Laptop(String brand, String model, int productionYear, String color, int RAM, int builtInMemory,  String processor, String graphicCard, String operatingSystem, double screenSize, double price, int productsAmount) {

        super(brand, model, productionYear, color , RAM, builtInMemory, screenSize, price, productsAmount);
        this.Processor = processor;
        this.GraphicCard = graphicCard;
        this.OperatingSystem = operatingSystem;
    }

    public String getProcessor() {
        return Processor;
    }

    public void setProcessor(String processor) {
        Processor = processor;
    }

    public String getGraphicCard() {
        return GraphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        GraphicCard = graphicCard;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public String toString(){
        return super.toString() +
                " Procesor:" +
                this.getProcessor() +
                " Karta Graficzna:" +
                this.getGraphicCard() +
                " System Operacyjny: " +
                this.getOperatingSystem();
    }
}
