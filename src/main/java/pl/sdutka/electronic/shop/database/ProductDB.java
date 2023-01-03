package pl.sdutka.electronic.shop.database;

import pl.sdutka.electronic.shop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductDB {
    private static final ProductDB instance = new ProductDB();

    private final List<Device> devices= new ArrayList<>();

    private ProductDB(){
        devices.add(new SmartPhone("Apple", "Iphone 14 pro max", 2022, "black", 6, 256, 6.7, 48, 5000, 20));
        devices.add(new SmartPhone("Samsung", "Samsung s22 ultra", 2022, "silver", 12, 512,7.2, 108, 6000, 10));
        devices.add(new SmartWatch("Apple", "Apple Watch series 8", 2022, "silver", 2, 1, 0.45, 3000, 5));
        devices.add(new SmartWatch("Samsung", "Galaxy Watch 4 pro", 2021, "black", 4, 2, 0.46, 2500, 10));
        devices.add(new Tablet("Apple", "Ipad pro", 2021, "blue", 6, 128, 12.9, 16, 2000, 20));
        devices.add(new Tablet("Samsung", "Tab s8", 2022, "grey", 12, 256, 11, 20, 1500, 10));
        devices.add(new Laptop("HP", "Pavilion Gaming TG01", 2020, "black", 32, 1000, "Intel i9", "RTX 3080", "Windows 10 pro", 16, 2000, 10));
        devices.add(new Laptop("Apple", "Macbook Pro", 2021, "silver", 64, 8000, "M1 MAX", "M1 MAX", "MAC OS",16 ,10000, 2));
    }

    public void getDevices() {
        System.out.println(devices.stream().toList());
    }

    public boolean buyDevice(String[] deviceNameAndAmount){
        return devices.stream()
                .filter(device -> device.getModel().equals(deviceNameAndAmount[0]) && device.getProductsAmount() > 0)
                .map(device -> {
                    int amount = device.getProductsAmount();
                    if(amount < Integer.parseInt(deviceNameAndAmount[1])){
                        System.out.println("You bought " + amount + " because so much was available ");
                        amount = 0;
                    }else{
                        amount -= Integer.parseInt(deviceNameAndAmount[1]);
                    }
                    device.setProductsAmount(amount);
                    return true;
                })
                .findFirst()
                .orElse(false);
    }


    public void increaseAmountOfExistingDevice(String[] newDeviceAmount) {
        this.devices.stream()
                .filter(device -> device.getModel().equals(newDeviceAmount[0]))
                .findFirst()
                .ifPresent(device -> {
                    device.setProductsAmount(device.getProductsAmount() + Integer.parseInt(newDeviceAmount[1]));
                    System.out.println("Properly increased amount of existing product");
                });
    }

    public void addNewDevice(Device device) {
        devices.add(device);
    }


    public static ProductDB getInstance() {
        return instance;
    }
}
