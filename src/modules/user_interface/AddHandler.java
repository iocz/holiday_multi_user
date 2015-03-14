package modules.user_interface;

import main.MainClass;
import model.Country;
import model.Holiday;
import model.Tradition;
import modules.functional.Add;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class AddHandler {

    protected static void addMenu() {
        int choice = 0;
        while (true) {
            try {
                MainMenu.out.println(MainMenu.language.getADD_MENU());
                choice = Integer.parseInt(MainMenu.reader.readLine());

                switch (choice) {
                    case 1:
                        addTradition();
                        break;
                    case 2:
                        MainMenu.mainMenu();
                        break;
                    default:
                        MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                }
            } catch (NumberFormatException ex) {
                MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            } catch (IOException e) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            }
        }
    }

    private static void addTradition() {
        while (true) {
            try {
                MainClass.traditions = (ArrayList<Tradition>)Add.newTradition(holidayMenu(), countryMenu(), MainClass.traditions);
                MainMenu.out.println(MainMenu.language.getDESCRIPT_REQUEST());
                int choice = Integer.parseInt(MainMenu.reader.readLine());
                switch (choice) {
                    case 1:
                        MainClass.traditions.get(MainClass.traditions.size() - 1).setDescription(MainMenu.reader.readLine());
                        MainMenu.out.println(MainMenu.language.getREADY());
                        addMenu();
                        break;
                    case 2:
                        MainMenu.out.println(MainMenu.language.getREADY());
                        addMenu();
                        break;
                    default:
                        MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                }
            } catch (IOException ex) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            }
        }
    }

    private static Country countryMenu() {
        while (true) {
            try {
                MainMenu.out.println(MainMenu.language.getTRADITION_COUNTRY());
                int choice = Integer.parseInt(MainMenu.reader.readLine());
                switch (choice) {
                    case 1:
                        MainMenu.out.println(MainMenu.language.getID_REQUEST());
                        PrintHandler.printArrayCountries(MainClass.countries);
                        choice = Integer.parseInt(MainMenu.reader.readLine());
                        return MainClass.countries.get(choice);
                    case 2:
                        return addCountry();
                    default:
                        MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                }
            } catch (IOException ex) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            }
        }
    }

    private static Holiday holidayMenu() {
        Holiday holiday;
        while (true) {
            try {
                MainMenu.out.println(MainMenu.language.getTRADITION_HOLIDAY());
                int choice = Integer.parseInt(MainMenu.reader.readLine());
                switch (choice) {
                    case 1:
                        PrintHandler.printArrayHolidays(MainClass.holidays);
                        MainMenu.out.println(MainMenu.language.getID_REQUEST());
                        choice = Integer.parseInt(MainMenu.reader.readLine());
                        holiday = MainClass.holidays.get(choice);
                        return holiday;
                    case 2:
                        holiday = addHoliday();
                        return holiday;
                    default:
                        MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                }
            } catch (IOException ex) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
                addMenu();
            } catch (IndexOutOfBoundsException ex) {
                MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
            }
        }
    }

    protected static Holiday addHoliday() {
        while (true) {
            try {
                MainMenu.out.println(MainMenu.language.getHOLIDAY_REQUEST());
                String name = MainMenu.reader.readLine();

                MainMenu.out.println((MainMenu.language.getTYPE_REQUEST()));
                PrintHandler.printAllTypes();
                int type = Integer.parseInt(MainMenu.reader.readLine());

                MainMenu.out.println(MainMenu.language.getDATE_REQUEST());
                int dateChoice = Integer.parseInt(MainMenu.reader.readLine());

                switch (dateChoice) {
                    case 1:
                        MainClass.holidays = (LinkedList<Holiday>)Add.newHoliday(name, type, MainClass.holidays);
                        return new Holiday(name, type);
                    case 2:
                        Date start = createDate();
                        Date end;
                        MainMenu.out.println(MainMenu.language.getEND_DATE_REQUEST());
                        int endChoice = Integer.parseInt(MainMenu.reader.readLine());
                        if (endChoice == 2) {
                            end = createDate();
                            MainClass.holidays = (LinkedList<Holiday>)Add.newHoliday(name, start, end, type, MainClass.holidays);
                            return new Holiday(name, start, end, type);
                        } else if (endChoice == 1) {
                            MainClass.holidays = (LinkedList<Holiday>)Add.newHoliday(name, start, type, MainClass.holidays);
                            return new Holiday(name, start, type);
                        } else {
                            MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                            MainClass.holidays = (LinkedList<Holiday>)Add.newHoliday(name, start, type, MainClass.holidays);
                            return new Holiday(name, start, type);
                        }
                    default:
                        MainMenu.out.println(MainMenu.language.getWRONG_CHOICE());
                }
            } catch (IOException ex) {
                MainMenu.out.println(MainMenu.language.getIO_ERROR());
            } catch (ParseException ex) {
                MainMenu.language.getPARSE_ERROR();
            }
        }
    }

    private static Country addCountry() {
        Country country = null;
        try {
            MainMenu.out.println(MainMenu.language.getCOUNTRY_REQUEST());
            country = new Country(MainMenu.reader.readLine());
            MainClass.countries = (LinkedList<Country>)Add.newCountry(country, MainClass.countries);
            MainMenu.out.println(MainMenu.language.getREADY());
        } catch (IOException ex) {
            MainMenu.out.println(MainMenu.language.getIO_ERROR());
            addMenu();
        }
        return country;
    }

    private static Date createDate() throws ParseException, IOException {
        MainMenu.out.println(MainMenu.language.getDAY());
        int day = Integer.parseInt(MainMenu.reader.readLine());
        MainMenu.out.println(MainMenu.language.getMONTH());
        int month = Integer.parseInt(MainMenu.reader.readLine());
        Date date = Holiday.dateFormat.parse(day + "." + month);
        return date;
    }
}
