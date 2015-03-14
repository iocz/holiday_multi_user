package modules.user_interface;

import languages.Language;
import languages.Strings_EN;
import languages.Strings_RU;
import main.MainClass;
import model.*;
import modules.functional.DataSaveLoad;
import modules.functional.SerFileWorking;
import modules.functional.XmlFileWorking;
import org.jdom2.JDOMException;

import java.io.*;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;

public class MainMenu {

    protected static Language language = new Strings_EN();
    protected static PrintWriter out = new PrintWriter(System.out, true);
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static DataSaveLoad xmlFiles = new XmlFileWorking();
    protected static DataSaveLoad serFiles = new SerFileWorking();
    static RSA rsa = new RSA();

    //region Completed
    public static void init() {
        chooseLocale();
    }

    private static ArrayList<String> logins = new ArrayList<String>();
    //private static ArrayList<BigInteger> passwords = new ArrayList<BigInteger>();
    private static ArrayList<User> users = new ArrayList<User>();

    public static boolean authorizate(String login, String pass){
        int index = 0;
        for (String value : logins){
            out.println(value);
            if (value.equals(login))
                 index = logins.indexOf(value);
            }
        //out.println(index);
        BigInteger message = new BigInteger(pass.getBytes());
        BigInteger decrypt = rsa.decrypt(users.get(index).getPass());
        //out.println(decrypt.toString());
        //out.println(message);
        if (decrypt.toString().equals(message.toString())){
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean checkLogin(String login){
        boolean result = false;
        for (String value : logins){
            if (login.equals(value)) {
                out.println("Пользователь с таким именем уже существует");
                result = true;
            }
        }
        return result;
    }

    private static void registration(){
        String login = "";
        String pass1 = "";
        String pass2 = "";

        try {
        while (true) {
            out.println(language.getLogin());
            login = reader.readLine();
            if (checkLogin(login)){
                break;
            }
            out.println(language.getPass());
                pass1 = reader.readLine();
            out.println(language.getPass());
                pass2 = reader.readLine();
            if (pass1.equals(pass2)) {
                int N = 1024;

                rsa.init(N);
                //User user = new User(login, pass1);
                BigInteger pass = new BigInteger(pass1.getBytes());
                User user = new User(login, pass, rsa.getPublicKey(),
                        rsa.getModulus());
                users.add(user);
                logins.add(login);
                out.println("Пользователь создан!");
            }
            else {
                out.println("Пароль не совпадает");
            }
            break;
        }
        }catch (IOException e){
            out.println(language.getIO_ERROR());
            mainMenu();
        }
    }

    private static void authorization() throws IOException {
        String login = "";
        String pass = "";
        while (true) {
            out.println(language.getLogin());
                login = reader.readLine();
            out.println(language.getPass());
                pass = reader.readLine();
            if (authorizate(login, pass)){
                out.println("Приветствую вас, " + login + "!");
            }
            else {
                out.println("Неправильные логин и(или) пароль!");
                logIn();
            }
            mainMenu();
        }
    }

    private static void chooseLocale() {
        int N = 1024;

        rsa.init(N);
        //User user = new User(login, pass1);
        String login = "user";
        String pass1 = "12345";
        BigInteger pass = new BigInteger(pass1.getBytes());
        User user = new User(login, pass, rsa.getPublicKey(),
                rsa.getModulus());
        //passwords.add(pass);
        user.setCount();
        users.add(user);
        logins.add(login);
        int choice = 0;
        while (true) {
            out.println(language.getSTART_CHOICE());
            try {
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        language = new Strings_RU();
                        readArrays();
                        logIn();
                        //mainMenu();
                        break;
                    case 2:
                        language = new Strings_EN();
                        readArrays();
                        logIn();
                        //mainMenu();
                        break;
                    default:
                        out.println(language.getWRONG_CHOICE());
                }
            } catch (NumberFormatException ex) {
                out.println(language.getWRONG_CHOICE());
            } catch (IOException ex) {
                out.println(language.getIO_ERROR());
            }
        }
    }

    protected static void logIn(){
        out.println("Вход:\n1 - Авторизация\n2 - Регистрация\n3 - Гостевой режим");
        int choice = 0;
        try{
            choice = Integer.parseInt(reader.readLine());

            switch(choice){
                case 1:
                        authorization();
                        mainMenu();
                    break;
                case 2:
                        registration();
                        logIn();
                        //mainMenu();
                    break;
                case 3:
                    mainMenu();
                default:
                    out.println(language.getWRONG_CHOICE());
                    logIn();
                    break;
            }
        } catch (IOException e) {
            out.println(language.getIO_ERROR());
            logIn();
        }
    }

    protected static void mainMenu() {
        out.println(language.getMAIN_MENU());
        int choice = 0;
        try {
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    AddHandler.addMenu();
                    break;
                case 2:
                    SearchHandler.searchMenu();
                    break;
                case 3:
                    PrintHandler.showMenu();
                    break;
                case 4:
                    if (language.getClass() == Strings_EN.class) help("./resources/help_en.txt");
                    else help("./resources/help_ru.txt");
                    break;
                case 5:
                    exit();
                    break;
                default:
                    out.println(language.getWRONG_CHOICE());
                    mainMenu();
                    break;
            }
        } catch (NumberFormatException ex) {
            out.println(language.getWRONG_CHOICE());
            mainMenu();
        } catch (IOException e) {
            out.println(language.getIO_ERROR());
            mainMenu();
        }
    }

    private static void help(String path) {

        File helpFile = new File(path);
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(helpFile));
            while (fileReader.ready()) out.println(fileReader.readLine());

            out.println(language.getHELP_MENU());
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    mainMenu();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    out.println(language.getWRONG_CHOICE());
                    mainMenu();
            }
        } catch (FileNotFoundException e) {
            out.println(language.getHELP_FILE_ERROR());
            mainMenu();
        } catch (IOException e) {
            out.println(language.getIO_ERROR());
            mainMenu();
        } catch (NumberFormatException ex) {
            out.println(language.getWRONG_CHOICE());
            mainMenu();
        }
    }

    protected static void exit() { //Куча Исключений, нужны try и catch
        try {
            writeArrays();

            reader.close();
            out.close();
            System.exit(0);
        } catch (IOException e) {  // прописать сюда ошибкииииииии

        } catch (JDOMException e) {

        } catch (ParseException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    private static void readArrays() throws IOException {
        try {
            if (MainMenu.language.getClass() == Strings_EN.class) xmlFiles.loadAllEN();
            else xmlFiles.loadAllRU();

        } catch (ClassNotFoundException ex) {
            MainMenu.out.println(MainMenu.language.getNO_CLASS());
        } catch (JDOMException e) {  //подписать сюда какие нибудь ошибки

        } catch (ParseException e) {// И СЮДААААААААА

        }
    }

    private static void writeArrays() throws IOException, JDOMException, ParseException, ClassNotFoundException {

        if (MainMenu.language.getClass() == Strings_EN.class) {
            xmlFiles.saveAllEN();
            serFiles.saveAllEN();
        } else {
            xmlFiles.saveAllRU();
            serFiles.saveAllRU();
        }
    }
    //endregion
}
