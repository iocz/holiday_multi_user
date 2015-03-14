package main;

import model.Country;
import model.Holiday;
import model.Tradition;
import modules.user_interface.MainMenu;
import java.util.*;

public class MainClass {

    public static LinkedList<Holiday> holidays = new LinkedList<Holiday>();
    public static LinkedList<Country> countries = new LinkedList<Country>();
    public static ArrayList<Tradition> traditions = new ArrayList<Tradition>();

    public static void main(String[] args) {
        MainMenu.init();
    }
}
