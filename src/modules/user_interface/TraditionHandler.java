package modules.user_interface;

import main.MainClass;
import model.Country;
import model.Holiday;
import model.Tradition;
import modules.functional.Add;

import java.io.IOException;
import java.util.ArrayList;

public class TraditionHandler {

    public static void traditionMenu() {
        MainMenu.out.println(MainMenu.language.getTRADITION_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());
            switch (choice) {
                case 1:
                    printDescription();
                    break;
                case 2:
                    ChangeHandler.changeTradition();
                    break;
                case 3:
                    RemoveHandler.removeTradition();
                    break;
                case 4:
                    PrintHandler.showMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    break;
            }
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    private static void printDescription() {
        MainMenu.out.println(MainMenu.language.getID_REQUEST());
        try {
            int id = Integer.parseInt(MainMenu.reader.readLine());
            Tradition tradition = MainClass.traditions.get(id);
            if (!tradition.getDescription().equals("")) MainMenu.out.println(MainClass.traditions.get(id).getDescription());
            else {
                MainMenu.out.println(MainMenu.language.getNO_DESCRIPT());

                int choice = Integer.parseInt(MainMenu.reader.readLine());
                switch (choice) {
                    case 1:
                        MainClass.traditions.get(id).setDescription(MainMenu.reader.readLine());
                    case 2: break;
                }
            }
            MainMenu.out.println(MainMenu.language.getHELP_MENU());
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            switch (choice) {
                case 1:
                    MainMenu.mainMenu();
                    break;
                case 2:
                    MainMenu.exit();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    MainMenu.mainMenu();
                    break;
            }
        }
            catch (IOException e) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            }
        }

    public static void noTraditionMenu(Holiday holiday) {
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());

            switch (choice) {
                case 1:
                    addTradition(holiday);
                    break;
                case 2:
                    PrintHandler.showMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    noTraditionMenu(holiday);
                    return;
            }
        } catch (NumberFormatException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            noTraditionMenu(holiday);
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            noTraditionMenu(holiday);
        }
    }

    public static void noTraditionMenu(Country country) {
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());

            switch (choice) {
                case 1:
                    addTradition(country);
                    break;
                case 2:
                    PrintHandler.showMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    noTraditionMenu(country);
                    break;
            }
        } catch (NumberFormatException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            noTraditionMenu(country);
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            noTraditionMenu(country);
        }
    }

    private static void addTradition(Holiday holiday) {
        MainMenu.out.println(MainMenu.language.getCOUNTRY_CHOICE());
        PrintHandler.printArrayCountries(MainClass.countries);
        try {
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            Country country = MainClass.countries.get(choice);
            MainMenu.out.println(MainMenu.language.getDESCRIPT_REQUEST());
            choice = Integer.parseInt(MainMenu.reader.readLine());
            String description = "";

            if (choice == 1) {description = MainMenu.reader.readLine();
                MainClass.traditions = (ArrayList<Tradition>)Add.newTradition(holiday, country, description, MainClass.traditions);
            MainMenu.out.println(MainMenu.language.getREADY());
            PrintHandler.showMenu();}
            else if (choice == 2) {
                MainClass.traditions = (ArrayList<Tradition>)Add.newTradition(holiday, country, MainClass.traditions);
            MainMenu.out.println(MainMenu.language.getREADY());
            PrintHandler.showMenu();}
            else MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());

        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    private static void addTradition(Country country) {
        MainMenu.out.println(MainMenu.language.getHOLIDAY_REQUEST());
        PrintHandler.printArrayHolidays(MainClass.holidays);
        try {
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            Holiday holiday = MainClass.holidays.get(choice);
            MainMenu.out.println(MainMenu.language.getDESCRIPT_REQUEST());
            choice = Integer.parseInt(MainMenu.reader.readLine());
            String description = "";

            if (choice == 1) {description = MainMenu.reader.readLine();
                MainClass.traditions = (ArrayList<Tradition>)Add.newTradition(holiday, country, description, MainClass.traditions);
                MainMenu.out.println(MainMenu.language.getREADY());
                PrintHandler.showMenu();}
            else if (choice == 2) {
                MainClass.traditions = (ArrayList<Tradition>)Add.newTradition(holiday, country, MainClass.traditions);
                MainMenu.out.println(MainMenu.language.getREADY());
                PrintHandler.showMenu();}
            else MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());

        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }
}
