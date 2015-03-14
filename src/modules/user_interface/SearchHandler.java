package modules.user_interface;

import main.MainClass;
import modules.functional.Search;

import java.io.IOException;
import java.util.regex.PatternSyntaxException;

import static modules.functional.Search.*;

public class SearchHandler {

    protected static void searchMenu() {
        MainMenu.out.println(MainMenu.language.getSEARCH_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());

            switch (choice) {
                case 1:
                    searchVoid();
                    break;
                case 2:
                    maskSearchVoid();
                    break;
                case 3:
                    regularSearchVoid();
                case 4:
                    MainMenu.mainMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                            searchMenu();
                    break;
            }
        } catch (NumberFormatException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    searchMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
                    searchMenu();
        }
    }

    private static void searchVoid() {
        try {
            MainMenu.out.println(MainMenu.language.getSEARCH_REQUEST());
            String request = MainMenu.reader.readLine();
            if (Search.search(request, MainClass.traditions).size() != 0) {
                PrintHandler.printArrayTraditions(Search.search(request,MainClass.traditions));
                TraditionHandler.traditionMenu();
            }
            else MainMenu.out.println(MainMenu.language.getNOT_FOUND());
        }
        catch (IOException ex) {MainMenu.out.println(MainMenu.language.getIO_ERROR());}
        searchMenu();
    }

    private static void maskSearchVoid() {
        try {
            String country, holiday, description = "";
            MainMenu.out.println(MainMenu.language.getCOUNTRY_REQUEST());
            country = MainMenu.reader.readLine();
            MainMenu.out.println(MainMenu.language.getHOLIDAY_REQUEST());
            holiday = MainMenu.reader.readLine();
            if (Search.maskSearch(holiday,country,"",MainClass.traditions).size() != 0) {
                PrintHandler.printArrayTraditions(Search.maskSearch(holiday, country, "",MainClass.traditions));
                TraditionHandler.traditionMenu();
            }
            else MainMenu.out.println(MainMenu.language.getNOT_FOUND());
        }
        catch (IOException ex) {MainMenu.out.println(MainMenu.language.getIO_ERROR());}
        searchMenu();
    }

    private static void regularSearchVoid() {
        try {
            MainMenu.out.println(MainMenu.language.getSEARCH_REQUEST());
            String request = MainMenu.reader.readLine();
            if (Search.regularSearch(request,MainClass.traditions).size() != 0) {
                PrintHandler.printArrayTraditions(Search.regularSearch(request,MainClass.traditions));
                TraditionHandler.traditionMenu();
            }
            else MainMenu.out.println(MainMenu.language.getNOT_FOUND());
        }
        catch (IOException ex) {MainMenu.out.println(MainMenu.language.getIO_ERROR());}
        catch (PatternSyntaxException ex) {MainMenu.out.println(MainMenu.language.getWRONG_MASK());}
        searchMenu();
    }
}