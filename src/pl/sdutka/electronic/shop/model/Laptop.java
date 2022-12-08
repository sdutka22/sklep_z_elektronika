package pl.sdutka.electronic.shop.model;

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
        return new StringBuilder()
                .append(super.toString())
                .append(" Processor: ")
                .append(getProcessor())
                .append(" Graphic Card:")
                .append(GraphicCard)
                .append(" Operating System: ")
                .append(OperatingSystem).toString();
    }
}
