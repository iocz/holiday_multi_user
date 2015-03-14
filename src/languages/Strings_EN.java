package languages;

public class Strings_EN implements Language {

    public final String START_CHOICE = "Choose your language:\n1-RU\n2-EN";
    private final String MAIN_MENU = "Welcome to holiday library! Press 4 to read a HELP file\n1 - add\n2 - search\n3 - show\n4 - help\n5 - exit";
    private final String WRONG_CHOICE = "Wrong choice!";
    private final String ADD_MENU = "What's to add?\n1 - new tradition\n2 - back to main menu";
    private final String IO_ERROR = "Input-output error occurred";
    private final String HELP_FILE_ERROR = "Can't read a help file";
    private final String HELP_MENU = "1 - back to main menu\n2 - exit";
    private final String SHOW_MENU = "What to show?\n1 - holidays today\n2 - holidays by date\n3 - holidays by type\n4 - holidays by country\n5 - show all holidays\n6 - show all countries\n7 - back to main menu";
    private final String SEARCH_MENU = "How to search?\n1 - by substring\n2 - by mask\n3 - regular search\n4 - back to main menu";
    private final String TABLE_ID = "ID";
    private final String TABLE_HOLIDAY = "HOLIDAY";
    private final String TABLE_DATE = "DATE";
    private final String TABLE_TYPE = "TYPE";
    private final String PRINT_MENU = "1 - look its traditions\n2 - change\n3 - remove\n4 - back";
    private final String TABLE_COUNTRY = "COUNTRY";
    private final String ID_REQUEST = "Enter ID:";
    private final String TYPE_CHOICE = "Choose the type number:";
    private final String PARSE_ERROR = "Can't parse the date";
    private final String DAY = "Enter a day:";
    private final String MONTH = "Enter a month:";
    private final String COUNTRY_CHOICE = "Choose the country:";
    private final String TRADITION_MENU = "1 - read the description\n2 - change tradition\n3 - remove tradition\n4 - back";
    private final String COUNTRY_REQUEST = "Enter the country name:";
    private final String HOLIDAY_REQUEST = "Enter the holiday name:";
    private final String WRONG_MASK = "Wrong mask request!";
    private final String NOT_FOUND = "No holidays found";
    private final String READY = "Completed!";
    private final String TYPE_REQUEST = "Choose the type:";
    private final String DATE_REQUEST = "Choose the date: \n1 - today\n2 - enter";
    private final String END_DATE_REQUEST = "Is this holiday duration one day? \n1 - yes\n 2 - no";
    private final String NO_TRADITION = "No added traditions for this holiday, add?\n 1 - yes\n 2 - no";
    private final String NO_CLASS = "Holiday loading has been failed";
    private final String DESCRIPT_REQUEST = "Add description? \n1 - yes\n2 - no";
    private final String TRADITION_COUNTRY = "Choose the country:\n1 - from existed\n2 - create new";
    private final String TRADITION_HOLIDAY = "Choose the holiday:\n1 - from existed\n2 - create new";
    private final String NO_DESCRIPT = "Description is empty, change it?\n1 - yes\n2 - no";
    private final String CHANGE_TRADITION = "What is to change?\n1 - change description\n2 - change country\n3 - change holiday";
    private final String ENTER_DESCRIPTION = "Enter its description:";
    private final String ENTER_LOGIN = "Enter login:";
    private final String ENTER_PASS = "Enter pass:";

    public String getLogin(){
        return ENTER_LOGIN;
    }

    public String getPass(){
        return ENTER_PASS;
    }

    public String getENTER_DESCRIPTION() {
        return ENTER_DESCRIPTION;
    }

    public String getCHANGE_TRADITION() {
        return CHANGE_TRADITION;
    }

    public String getNO_DESCRIPT() {
        return NO_DESCRIPT;
    }

    public String getTRADITION_HOLIDAY() {
        return TRADITION_HOLIDAY;
    }

    public String getTRADITION_COUNTRY() {
        return TRADITION_COUNTRY;
    }

    public String getDESCRIPT_REQUEST() {
        return DESCRIPT_REQUEST;
    }

    public String getNO_CLASS() {
        return NO_CLASS;
    }

    public String getNO_TRADITION() {
        return NO_TRADITION;
    }

    public String getEND_DATE_REQUEST() {
        return END_DATE_REQUEST;
    }

    public String getDATE_REQUEST() {
        return DATE_REQUEST;
    }

    public String getTYPE_REQUEST() {
        return TYPE_REQUEST;
    }

    public String getREADY() {
        return READY;
    }

    public String getNOT_FOUND() {
        return NOT_FOUND;
    }

    public String getWRONG_MASK() {
        return WRONG_MASK;
    }

    public String getSEARCH_REQUEST() {
        return SEARCH_REQUEST;
    }

    public String getHOLIDAY_REQUEST() {
        return HOLIDAY_REQUEST;
    }

    public String getCOUNTRY_REQUEST() {
        return COUNTRY_REQUEST;
    }

    private final String SEARCH_REQUEST = "Enter the searching substring:";

    public Strings_EN() {
    }

    public String getSTART_CHOICE() {
        return START_CHOICE;
    }

    public String getMAIN_MENU() {
        return MAIN_MENU;
    }

    public String getWRONG_CHOICE() {
        return WRONG_CHOICE;
    }

    public String getADD_MENU() {
        return ADD_MENU;
    }

    public String getIO_ERROR() {
        return IO_ERROR;
    }

    public String getHELP_FILE_ERROR() {
        return HELP_FILE_ERROR;
    }

    public String getHELP_MENU() {
        return HELP_MENU;
    }

    public String getSHOW_MENU() {
        return SHOW_MENU;
    }

    public String getSEARCH_MENU() {
        return SEARCH_MENU;
    }

    public String getTABLE_ID() {
        return TABLE_ID;
    }

    public String getTABLE_HOLIDAY() {
        return TABLE_HOLIDAY;
    }

    public String getTABLE_DATE() {
        return TABLE_DATE;
    }

    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    public String getPRINT_MENU() {
        return PRINT_MENU;
    }

    public String getTABLE_COUNTRY() {
        return TABLE_COUNTRY;
    }

    public String getID_REQUEST() {
        return ID_REQUEST;
    }

    public String getTYPE_CHOICE() {
        return TYPE_CHOICE;
    }

    public String getPARSE_ERROR() {
        return PARSE_ERROR;
    }

    public String getDAY() {
        return DAY;
    }

    public String getMONTH() {
        return MONTH;
    }

    public String getCOUNTRY_CHOICE() {
        return COUNTRY_CHOICE;
    }

    public String getTRADITION_MENU() {
        return TRADITION_MENU;
    }
}
