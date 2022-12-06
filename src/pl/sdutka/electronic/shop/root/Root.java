package pl.sdutka.electronic.shop.root;

import pl.sdutka.electronic.shop.categories.User;
import pl.sdutka.electronic.shop.database.ProductDB;
import pl.sdutka.electronic.shop.database.UserDB;
import pl.sdutka.electronic.shop.gui.GUI;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static pl.sdutka.electronic.shop.gui.GUI.showLoginRegister;


public class Root {
    private static final Scanner scanner = new Scanner(System.in);
    final ProductDB productDB = ProductDB.getInstance();
    final UserDB userDB = UserDB.getInstance();
    final Auth auth = Auth.getInstance();
    final GUI gui = GUI.getInstance();
    private static final Root instance = new Root();
    private Root() {

    }
    public void run(){

        boolean isRunning = false;
        boolean isWorking = true;
        int counter = 0;

        while(isWorking) {
            switch(showLoginRegister()){
                case "1" -> {
                    User user = GUI.readNewLoginAndPassword();
                    if(!Auth.validate(user)){
                        System.out.println("Wprowadzono zły login lub hasło poprawny login oraz haslo składa sie z min 5 liter,");
                    }else{
                        if(Auth.doesExist(user, this.auth.userDB)){
                            System.out.println("Konto o podanym loginie już istnieje");
                        }else{
                            this.auth.userDB.addNewUser(user);
                        }
                    }
                }
                case "2" -> {
                    while(!isRunning && counter < 3) {
                        this.auth.authentication(GUI.readLoginAndPassword());
                        isRunning = this.auth.getLoggedUser() != null;
                        System.out.println(isRunning);
                        if(!isRunning) {
                            System.out.println("Not authorized !!");
                        }
                        counter++;
                    }
                    counter = 0;
                }
                case "3" -> {
                    isWorking = false;
                }
            }

            while (isRunning) {
                switch (this.gui.showMenu()) {
                    case "1" -> GUI.listOfDevices(productDB.getDevices());
                    case "2" -> GUI.showBuyResult(productDB.buyDevice(GUI.readProduct()));
                    case "3" -> {
                        if(this.auth.getLoggedUser() != null && this.auth.getLoggedUser().getRole() == User.Role.ADMIN) {
                            productDB.increaseAmountOfExistingDevice(GUI.readAmountOfProductToBuy());
                        }
                    }
                    case "4" -> {
                        if(this.auth.getLoggedUser() != null && this.auth.getLoggedUser().getRole() == User.Role.ADMIN) {
                            productDB.addNewDevice(GUI.readNewDeviceData());
                        }
                    }
                    case "5" -> {
                        if(this.auth.getLoggedUser() != null && this.auth.getLoggedUser().getRole() == User.Role.ADMIN) {
                            System.out.println("Zmieniasz usera na admina czy chcesz kontynuować");
                            String choose = scanner.nextLine();
                            if (Objects.equals(choose, "Y")) {
                                System.out.println("Podaj login");
                                String login = scanner.nextLine();
                                this.auth.userDB.setUserAsAdmin(login, GUI.readUsertoAdmin());
                            }
                        }
                    }
                    case "6" -> {
                        if(this.auth.getLoggedUser() != null && this.auth.getLoggedUser().getRole() == User.Role.ADMIN) {
                            GUI.listOfUsersAndAdmins(userDB.getUsers());
                        }
                    }
                    case "7" -> {
                        this.auth.logOut();
                        isRunning = false;
                    }

                    default -> System.out.println("Wrong choose!! choose again");
                }
            }
        }

    }
    public static Root getInstance() {
        return instance;
    }
}
