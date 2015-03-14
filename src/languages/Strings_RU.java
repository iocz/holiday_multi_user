package languages;

public class Strings_RU implements Language {

    public final String START_CHOICE = "Выберите язык:\n1-RU\n2-EN";
    private final String MAIN_MENU = "Добро пожаловать в библиотеку праздников! Нажмите 4, чтобы вызвать справку\n1 - добавить\n2 - поиск\n3 - показать\n4 - справка\n5 - выход";
    private final String WRONG_CHOICE = "Неправильный выбор";
    private final String ADD_MENU = "Что добавить?\n1 - новую традицию\n2 - в главное меню";
    private final String IO_ERROR = "Произошла ошибка чтения-записи";
    private final String HELP_FILE_ERROR = "Не могу открыть файл справки";
    private final String HELP_MENU = "1 - в главное меню\n2 - выход";
    private final String SHOW_MENU = "Какие праздники вывести?\n1 - сегодня\n2 - по дате\n3 - по типу\n4 - по стране\n5 - все праздники\n6 - все страны\n7 - в главное меню";
    private final String SEARCH_MENU = "Как искать?\n1 - по подстроке\n2 - расширенный поиск\n3 - по регулярному выражению\n4 - в главное меню";
    private final String TABLE_ID = "ID";
    private final String TABLE_HOLIDAY = "ПРАЗДНИК";
    private final String TABLE_DATE = "ДАТА";
    private final String TABLE_TYPE = "ТИП";
    private final String PRINT_MENU = "1 - посмотреть традиции\n2 - изменить\n3 - удалить\n4 - назад";
    private final String TABLE_COUNTRY = "СТРАНА";
    private final String ID_REQUEST = "Введите ID:";
    private final String TYPE_CHOICE = "Выберите тип:";
    private final String PARSE_ERROR = "Не удалось преобразовать дату";
    private final String DAY = "Введите день:";
    private final String MONTH = "Введите месяц:";
    private final String COUNTRY_CHOICE = "Выберите страну:";
    private final String TRADITION_MENU = "1 - прочитать описание\n2 - изменить традицию\n3 - удалить традицию\n4 - назад";
    private final String COUNTRY_REQUEST = "Введите страну:";
    private final String HOLIDAY_REQUEST = "Введите праздник:";
    private final String NOT_FOUND = "Праздники не найдены";
    private final String READY = "Выполнено!";
    private final String TYPE_REQUEST = "Выберите тип:";
    private final String DATE_REQUEST = "Выберите дату: \n1 - сегодня\n2 - ввод";
    private final String END_DATE_REQUEST = "Праздник длится один день? \n1 - да \n2 - нет";
    private final String NO_TRADITION = "Нет добавленных традиций для праздника, добавить? \n1 - да \n2 - нет";
    private final String NO_CLASS = "Загрузка праздников не удалась";
    private final String DESCRIPT_REQUEST = "Добавить описание? \n1 - да \n2 - нет";
    private final String TRADITION_COUNTRY = "Выберите страну:\n1 - из существующих\n2 - создать новую";
    private final String TRADITION_HOLIDAY = "Выберите праздник:\n1 - из существующих\n2 - создать новый";
    private final String NO_DESCRIPT = "Описание отсутствует, добавить?\n1 - да\n2 - нет";
    private final String CHANGE_TRADITION = "Что изменить? \n1 - описание\n2 - страну\n3 - праздник";
    private final String ENTER_DESCRIPTION = "Введите описание";
    private final String ENTER_LOGIN = "Введите логин:";
    private final String ENTER_PASS = "Введите пароль:";

    public String getLogin() { return ENTER_LOGIN; }

    public String getPass() { return ENTER_PASS; }

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

    private final String WRONG_MASK = "Неправильный запрос!";

    public String getCOUNTRY_REQUEST() {
        return COUNTRY_REQUEST;
    }

    public String getHOLIDAY_REQUEST() {
        return HOLIDAY_REQUEST;
    }

    public String getSEARCH_REQUEST() {
        return SEARCH_REQUEST;
    }

    private final String SEARCH_REQUEST = "Введите подстроку:";

    public Strings_RU() {
    }

    public String getSTART_CHOICE() {
        return START_CHOICE;
    }

    @Override
    public String getMAIN_MENU() {
        return MAIN_MENU;
    }

    @Override
    public String getWRONG_CHOICE() {
        return WRONG_CHOICE;
    }

    @Override
    public String getADD_MENU() {
        return ADD_MENU;
    }

    @Override
    public String getIO_ERROR() {
        return IO_ERROR;
    }

    @Override
    public String getHELP_FILE_ERROR() {
        return HELP_FILE_ERROR;
    }

    @Override
    public String getHELP_MENU() {
        return HELP_MENU;
    }

    @Override
    public String getSHOW_MENU() {
        return SHOW_MENU;
    }

    @Override
    public String getSEARCH_MENU() {
        return SEARCH_MENU;
    }

    @Override
    public String getTABLE_ID() {
        return TABLE_ID;
    }

    @Override
    public String getTABLE_HOLIDAY() {
        return TABLE_HOLIDAY;
    }

    @Override
    public String getTABLE_DATE() {
        return TABLE_DATE;
    }

    @Override
    public String getTABLE_TYPE() {
        return TABLE_TYPE;
    }

    @Override
    public String getPRINT_MENU() {
        return PRINT_MENU;
    }

    @Override
    public String getTABLE_COUNTRY() {
        return TABLE_COUNTRY;
    }

    @Override
    public String getID_REQUEST() {
        return ID_REQUEST;
    }

    @Override
    public String getTYPE_CHOICE() {
        return TYPE_CHOICE;
    }

    @Override
    public String getPARSE_ERROR() {
        return PARSE_ERROR;
    }

    @Override
    public String getDAY() {
        return DAY;
    }

    @Override
    public String getMONTH() {
        return MONTH;
    }

    @Override
    public String getCOUNTRY_CHOICE() {
        return COUNTRY_CHOICE;
    }

    @Override
    public String getTRADITION_MENU() {
        return TRADITION_MENU;
    }
}
