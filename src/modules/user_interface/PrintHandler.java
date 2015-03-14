package modules.user_interface;

import main.MainClass;
import model.Country;
import model.Holiday;
import model.HolidayType;
import model.Tradition;
import modules.functional.Search;
import sun.awt.image.ImageWatched;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class PrintHandler {

    //region Completed
    protected static void showMenu() {
        MainMenu.out.println(MainMenu.language.getSHOW_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());

            switch (choice) {
                case 1:
                    printByToday();
                    break;
                case 2:
                    printByDate();
                    break;
                case 3:
                    printByType();
                    break;
                case 4:
                    printByCountry();
                    break;
                case 5:
                    printAll();
                    break;
                case 6:
                    printArrayCountries(MainClass.countries);
                    printCountryMenu();
                case 7:
                    MainMenu.mainMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    showMenu();
                    break;
            }
        } catch (NumberFormatException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            showMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            showMenu();
        }
    }

    private static void printHolidayMenu() {
        MainMenu.out.println(MainMenu.language.getPRINT_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());
            switch (choice) {
                case 1:
                    chooseHoliday();
                    break;
                case 2:
                    ChangeHandler.holidayChanger();
                    break;
                case 3:
                    RemoveHandler.holidayRemover();
                case 4:
                    showMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    showMenu();
                    break;
            }
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            showMenu();
        }

    }

    private static void printCountryMenu() {
        MainMenu.out.println(MainMenu.language.getPRINT_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(MainMenu.reader.readLine());
            switch (choice) {
                case 1:
                    chooseCountry();
                    break;
                case 2:
                    ChangeHandler.countryChanger();
                    break;
                case 3:
                    RemoveHandler.countryRemover();
                    break;
                case 4:
                    showMenu();
                    break;
                default:
                    MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                    showMenu();
                    break;
            }
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            showMenu();
        }
    }

    private static void chooseHoliday() {
        MainMenu.out.println(MainMenu.language.getID_REQUEST());
        try {
            int id = Integer.parseInt(MainMenu.reader.readLine());
            Holiday holiday = MainClass.holidays.get(id);
            printArrayTraditions(Search.getTraditions(holiday));
            TraditionHandler.traditionMenu();
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        } catch (IndexOutOfBoundsException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
        }
    }

    private static void chooseCountry() {
        MainMenu.out.println(MainMenu.language.getID_REQUEST());
        try {
            int id = Integer.parseInt(MainMenu.reader.readLine());
            if (Search.getCountryTraditions(id).size() != 0) {
                printTraditionTable();
                int count = 0;
                for (Tradition tradition : MainClass.traditions) {
                    if (tradition.getCountry().getName().equals(MainClass.countries.get(id).getName()))
                        MainMenu.out.printf("%5d%s\n", count, tradition);
                    count++;
                }
                TraditionHandler.traditionMenu();
            } else {
                MainMenu.out.println(MainMenu.language.getNO_TRADITION());
                TraditionHandler.noTraditionMenu(MainClass.holidays.get(id));
            }
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            showMenu();
        } catch (IndexOutOfBoundsException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            showMenu();
        }
    }

    private static void printAll() {
        if (MainClass.holidays.size() != 0) {
            printArrayHolidays(MainClass.holidays);
            printHolidayMenu();
        } else {
            MainMenu.out.println(MainMenu.language.getNOT_FOUND());
            MainMenu.mainMenu();
        }
    }

    private static void printByCountry() {
        MainMenu.out.println(MainMenu.language.getID_REQUEST());
        printArrayCountries(MainClass.countries);
        try {
            int choice = Integer.parseInt(MainMenu.reader.readLine());

            if (Search.getCountryTraditions(choice).size() != 0) {
                printArrayTraditions(Search.getCountryTraditions(choice));
                TraditionHandler.traditionMenu();
            } else MainMenu.out.println(MainMenu.language.getNOT_FOUND());

        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        } catch (IndexOutOfBoundsException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
        }
        showMenu();
    }

    private static void printByType() {
        MainMenu.out.println(MainMenu.language.getTYPE_CHOICE());
        printAllTypes();
        while (true) {
            try {
                int choice = Integer.parseInt(MainMenu.reader.readLine());
                if (Search.getTypeHolidays(choice).size() != 0) {
                    printArrayHolidays(Search.getTypeHolidays(choice));
                    printHolidayMenu();
                } else {
                    MainMenu.out.println(MainMenu.language.getNOT_FOUND());
                    showMenu();
                }
            } catch (IOException ex) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            } catch (ArrayIndexOutOfBoundsException ex) {
                MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            }
        }
    }

    private static void printByToday() {
        Date date = new Date();

        if (Search.getDateHolidays(date).size() != 0) {
            printArrayHolidays(Search.getDateHolidays(date));
            printHolidayMenu();
        } else {
            MainMenu.out.println(MainMenu.language.getNOT_FOUND());
            showMenu();
        }
    }

    private static void printByDate() {
        int day, month;
        try {
            MainMenu.out.println(MainMenu.language.getDAY());
            day = Integer.parseInt(MainMenu.reader.readLine());
            MainMenu.out.println(MainMenu.language.getMONTH());
            month = Integer.parseInt(MainMenu.reader.readLine());
            Date date = Holiday.dateFormat.parse(day + "." + month);

            if (Search.getDateHolidays(date).size() != 0) {
                printArrayHolidays(Search.getDateHolidays(date));
                printHolidayMenu();
            } else {
                MainMenu.out.println(MainMenu.language.getNOT_FOUND());
                showMenu();
            }
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        } catch (ParseException ex) {
            MainMenu.out.println(MainMenu.language.getPARSE_ERROR());
        }
    }

    //region Printing arrays
    public static void printAllTypes() {
        for (int i = 0; i < HolidayType.values().length; i++)
            MainMenu.out.printf("%d - %s\n", i, HolidayType.values()[i]);
    }

    protected static void printTraditionTable() {
        MainMenu.out.printf("%5s%30s%20s\n", MainMenu.language.getTABLE_ID(), MainMenu.language.getTABLE_HOLIDAY(),
                MainMenu.language.getTABLE_COUNTRY());
    }

    protected static void printHolidayTable() {
        MainMenu.out.printf("%3s%30s%15s%15s\n", MainMenu.language.getTABLE_ID(),
                MainMenu.language.getTABLE_HOLIDAY(), MainMenu.language.getTABLE_DATE(), MainMenu.language.getTABLE_TYPE());
    }

    public static void printArrayCountries(LinkedList<Country> countries) {
        MainMenu.out.printf("%3s%20s\n", MainMenu.language.getTABLE_ID(),
                MainMenu.language.getTABLE_COUNTRY());
        for (int i = 0; i < countries.size(); i++) {
            MainMenu.out.printf("%3d%20s\n", i, countries.get(i).getName());
        }
    }

    public static void printArrayTraditions(ArrayList<Tradition> traditions) {

        printTraditionTable();

        int count = 0;
        for (Tradition tradition : MainClass.traditions) {
            for (int i = 0; i < traditions.size(); i++) {
                if (tradition.equals(traditions.get(i)))
                    MainMenu.out.printf("%5d%30s\n", count, traditions.get(i));
            }
            count++;
        }
    }

    public static void printArrayHolidays(LinkedList<Holiday> holidays) {
        printHolidayTable();
        int count = 0;
        for (Holiday holiday : MainClass.holidays) {
            for (int i = 0; i < holidays.size(); i++) {
                if (holiday.equals(holidays.get(i)))
                    MainMenu.out.printf("%5d%30s\n", count, holidays.get(i));
            }
            count++;
        }
    }
    //endregion
    //endregion
}
