package modules.user_interface;

import main.MainClass;
import modules.functional.Remove;

import java.io.IOException;

public class RemoveHandler {

    protected static void holidayRemover() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int id = Integer.parseInt(MainMenu.reader.readLine());
            removeHoliday(id);
            PrintHandler.showMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }

    }

    protected static void countryRemover() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int id = Integer.parseInt(MainMenu.reader.readLine());
            removeCountry(id);
            PrintHandler.showMenu();
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
    }

    private static void removeCountry(int id) {
        Remove.removeCountry(id, MainClass.countries);
    }

    private static void removeHoliday(int id) {
        Remove.removeHoliday(id, MainClass.holidays);
    }

    protected static void removeTradition() {
        try {
            MainMenu.out.println(MainMenu.language.getID_REQUEST());
            int choice = Integer.parseInt(MainMenu.reader.readLine());
            Remove.removeTradition(choice, MainClass.traditions);
            MainMenu.out.println(MainMenu.language.getREADY());
        } catch (IOException e) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
        }
        catch (IndexOutOfBoundsException ex) {
            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());}
    }
}
