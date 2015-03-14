package modules.user_interface;

import main.MainClass;
import model.Country;
import model.Holiday;
import model.Tradition;
import modules.functional.Change;
import modules.functional.Remove;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ChangeHandler {

    protected static void holidayChanger() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            PrintHandler.printArrayHolidays(MainClass.holidays);
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            changeHoliday(choice);
            PrintHandler.showMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }

    }

    protected static void countryChanger() {
        try {
            MainMenu.out.println(MainMenu.language.getCOUNTRY_CHOICE());
            PrintHandler.printArrayCountries(MainClass.countries);
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            changeCountry(choice);
            PrintHandler.showMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    private static void changeHoliday(int id) throws IOException {
        Holiday holiday = MainClass.holidays.get(id);
        Holiday newHoliday = AddHandler.addHoliday();
        MainClass.holidays = (LinkedList<Holiday>)Change.editHoliday(id, newHoliday, MainClass.holidays);
        Remove.removeHoliday(MainClass.holidays.size()-1,MainClass.holidays);
        MainClass.traditions = (ArrayList<Tradition>)Change.editTradition(holiday, newHoliday, MainClass.traditions);
    }

    private static void changeCountry(int id) throws IOException {
        Country country = MainClass.countries.get(id);
        MainMenu.out.println(MainMenu.language.getCOUNTRY_REQUEST());
        String newCountryName = MainMenu.reader.readLine();
        MainClass.traditions = (ArrayList<Tradition>)Change.editTradition(newCountryName, id, 4, MainClass.traditions);
        MainClass.countries = (LinkedList<Country>)Change.editCountry(country, newCountryName, MainClass.countries);
        MainMenu.out.println(MainMenu.language.getREADY());
    }

    protected static void changeTradition() {
        MainMenu.out.println(MainMenu.language.getCHANGE_TRADITION());
        try {
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            switch (choice) {
                case 1:
                    changeDescription();
                    break;
                case 2:
                    changeCountryTradition();
                    break;
                case 3:
                    changeHolidayTradition();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            }
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    protected static void changeHolidayTradition() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int choice = Integer.parseInt(MainMenu.reader.readLine());

            MainMenu.out.println(MainMenu.language.getHOLIDAY_REQUEST());
            PrintHandler.printArrayHolidays(MainClass.holidays);
            int description = Integer.parseInt(MainMenu.reader.readLine());

            MainClass.traditions = (ArrayList<Tradition>)Change.editTradition(MainClass.holidays.get(description).getName(), choice, 3,
                    MainClass.traditions);
            MainMenu.out.println(MainMenu.language.getREADY());
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    protected static void changeCountryTradition() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int choice = Integer.parseInt(MainMenu.reader.readLine());

            MainMenu.out.println(MainMenu.language.getCOUNTRY_CHOICE());
            PrintHandler.printArrayCountries(MainClass.countries);
            int description = Integer.parseInt(MainMenu.reader.readLine());

            MainClass.traditions = (ArrayList<Tradition>)Change.editTradition(MainClass.countries.get(description).getName(), choice, 2,
                    MainClass.traditions);
            MainMenu.out.println(MainMenu.language.getREADY());
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    protected static void changeDescription() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            MainMenu.out.println(MainMenu.language.getENTER_DESCRIPTION());

            String description = MainMenu.reader.readLine();
            MainClass.traditions = (ArrayList<Tradition>)Change.editTradition(description, choice, 1, MainClass.traditions);

            MainMenu.out.println(MainMenu.language.getREADY());
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }
}
