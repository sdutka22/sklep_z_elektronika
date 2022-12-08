package pl.sdutka.electronic.shop.database;

import pl.sdutka.electronic.shop.model.*;

public class ProductDB {
    private Device[] devices = new Device[8];
    private static final ProductDB instance = new ProductDB();

    public ProductDB() {
        this.devices[0] = new SmartPhone("Apple", "Iphone 14 pro max", 2022, "black", 6, 256, 6.7, 48, 5000, 20);
        this.devices[1] = new SmartPhone("Samsung", "Samsung s22 ultra", 2022, "silver", 12, 512,7.2, 108, 6000, 10);

        this.devices[2] = new SmartWatch("Apple", "Apple Watch series 8", 2022, "silver", 2, 1, 0.45, 3000, 5);
        this.devices[3] = new SmartWatch("Samsung", "Galaxy Watch 4 pro", 2021, "black", 4, 2, 0.46, 2500, 10);

        this.devices[4] = new Tablet("Apple", "Ipad pro", 2021, "blue", 6, 128, 12.9, 16, 2000, 20);
        this.devices[5] = new Tablet("Samsung", "Tab s8", 2022, "grey", 12, 256, 11, 20, 1500, 10);

        this.devices[6] = new Laptop("HP", "Pavilion Gaming TG01", 2020, "black", 32, 1000, "Intel i9", "RTX 3080", "Windows 10 pro", 16, 2000, 10);
        this.devices[7] = new Laptop("Apple", "Macbook Pro", 2021, "silver", 64, 8000, "M1 MAX", "M1 MAX", "MAC OS",16 ,10000, 2);
    }

    public Device[] getDevices(){
        return devices;
    }

    public boolean buyDevice(String[] deviceNameAndAmount){
        for(Device device : this.devices){
            if(device.getModel().equals(deviceNameAndAmount[0]) && device.getProductsAmount() > 0){
                int amount = device.getProductsAmount();
                if(amount < Integer.parseInt(deviceNameAndAmount[1])){
                    System.out.println("You bought " + amount + " because so much was available ");
                    amount = 0;
                }else{
                    amount -= Integer.parseInt(deviceNameAndAmount[1]);
                }
                device.setProductsAmount(amount);
                return true;
            }
        }
        return false;
    }

    public void increaseAmountOfExistingDevice(String[] newDeviceAmount) {
        for(Device device : this.devices) {
            if(device.getModel().equals(newDeviceAmount[0])) {
                device.setProductsAmount(device.getProductsAmount() + Integer.parseInt(newDeviceAmount[1]));
                System.out.println("Properly increased amount of existing product");
            }
        }
    }

    public void addNewDevice(Device device) {
        Device[] electronicDevices = new Device[this.devices.length + 1];
        for(int i = 0; i < this.devices.length; i++) {
            electronicDevices[i] = this.devices[i];
        }
        electronicDevices[electronicDevices.length - 1] = device;
        this.devices = electronicDevices;
    }

    public static ProductDB getInstance() {
        return instance;
    }
}
