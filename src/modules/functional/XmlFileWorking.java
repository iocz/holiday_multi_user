package modules.functional;

import main.MainClass;
import model.Country;
import model.Holiday;
import model.HolidayType;
import model.Tradition;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 Created by Михаил on 09.03.2015.
*/

public class XmlFileWorking implements DataSaveLoad {

    private SAXBuilder builder = new SAXBuilder();

    @Override
    public void saveTradition(ArrayList<Tradition> traditions, String direct) throws IOException {
        Element root = new Element("traditionSave");
        Document doc = new Document(root);
        for (Tradition tradition : traditions) {

            Element traditionElement = new Element("tradition");
            traditionElement.setAttribute("description", tradition.getDescription());

            Element holidayElement = new Element("holiday");

            Element holidayName = new Element("holidayName");
            holidayName.setText(tradition.getHoliday().getName());
            holidayElement.addContent(holidayName);

            Element holidayStartDate = new Element("holidayStartDate");
            holidayStartDate.setText(tradition.getHoliday().getStartDate());
            holidayElement.addContent(holidayStartDate);

            /*Element holidayEndDate = new Element("holidayEndDate");
            holidayEndDate.setText((String)tradition.getHoliday().getEndDate());
            holidayElement.addContent(holidayEndDate);
*/
            Element holidayType = new Element("holidayType");
            holidayType.setText(tradition.getHoliday().getType().toString());
            holidayElement.addContent(holidayType);

            traditionElement.addContent(holidayElement);

            Element elementCountry = new Element("country");

            Element countryName = new Element("countryName");
            countryName.setText(tradition.getCountry().getName());
            elementCountry.addContent(countryName);

            traditionElement.addContent(elementCountry);

            root.addContent(traditionElement);
            writeXml(doc, direct);


        }

    }

    @Override
    public ArrayList<Tradition> loadTradition(String direct) throws IOException, JDOMException, ParseException {
        ArrayList<Tradition> traditions = new ArrayList<Tradition>();
        if (!((new File(direct)).exists())) {direct = XML_TRADITION_DEFAULT_RU;}

                Document document = builder.build(direct);
                Element root = document.getRootElement();
                List traditionElem = root.getChildren();

                for (Iterator traditionIterator = traditionElem.iterator(); traditionIterator.hasNext(); ) {
                    Element traditionElement = (Element) traditionIterator.next();

                    Tradition tradition = new Tradition();
                    tradition.setDescription(traditionElement.getAttributeValue("description"));

                    Element holidayElement = traditionElement.getChild("holiday");
                    Holiday holiday = new Holiday(holidayElement.getChild("holidayName").getText());

                    holiday.setStartDate(Holiday.dateFormat.parse(holidayElement.getChild("holidayStartDate").getText()));
//              holiday.setEndDate(Holiday.dateFormat.parse(holidayElement.getChild("holidayEndDate").getText()));
                    holiday.setType(HolidayType.valueOf(holidayElement.getChild("holidayType").getText()));

                    tradition.setHoliday(holiday);

                    Element countryElement = traditionElement.getChild("country");

                    Country country = new Country(countryElement.getChild("countryName").getText());

                    tradition.setCountry(country);
                    traditions.add(tradition);


                }



        return traditions;

    }

    @Override
    public void saveHolidays(LinkedList<Holiday> holidays, String direct) throws IOException {
        Element root = new Element("holidaysSave");
        Document doc = new Document(root);
        for (Holiday holiday : holidays) {
            Element holidayElement = new Element("holiday");
            Element holidayName = new Element("holidayName");
            holidayName.setText(holiday.getName());
            holidayElement.addContent(holidayName);

            Element holidayStartDate = new Element("holidayStartDate");
            holidayStartDate.setText(holiday.getStartDate());
            holidayElement.addContent(holidayStartDate);

            /*Element holidayEndDate = new Element("holidayEndDate");
            holidayEndDate.setText((String)holiday.getEndDate());
            holidayElement.addContent(holidayEndDate);
*/
            Element holidayType = new Element("holidayType");
            holidayType.setText(holiday.getType().toString());
            holidayElement.addContent(holidayType);

            root.addContent(holidayElement);
            writeXml(doc, direct);


        }
    }

    @Override
    public LinkedList<Holiday> loadHoliday(String direct) throws IOException, JDOMException, ParseException {
        LinkedList<Holiday> holidays = new LinkedList<Holiday>();
        if (!((new File(direct)).exists())) {direct = XML_HOLIDAY_DEFAULT_RU;}
            Document document = builder.build(direct);
            Element root = document.getRootElement();
            List holidayElem = root.getChildren();
            Iterator holidayIterator = holidayElem.iterator();
            while (holidayIterator.hasNext()) {
                Element holidayElement = (Element) holidayIterator.next();
                Holiday holiday = new Holiday();
                holiday.setName(holidayElement.getChild("holidayName").getText());
                holiday.setStartDate(Holiday.dateFormat.parse(holidayElement.getChild("holidayStartDate").getText()));
                // holiday.setEndDate(Holiday.dateFormat.parse(holidayElement.getChild("holidayEndDate").getText()));
                holiday.setType(HolidayType.valueOf(holidayElement.getChild("holidayType").getText()));
                holidays.add(holiday);
            }

        return holidays;
    }

    @Override
    public void saveCountry(LinkedList<Country> countries, String direct) throws IOException {
        Element root = new Element("countrySave");
        Document doc = new Document(root);
        for (Country country : countries) {
            Element countryElement = new Element("country");
            Element countryName = new Element("countryName");
            countryName.setText(country.getName());
            countryElement.addContent(countryName);
            root.addContent(countryElement);
            writeXml(doc, direct);

        }
    }

    @Override
    public LinkedList<Country> loadCountry(String direct) throws IOException, JDOMException {
        LinkedList<Country> countries = new LinkedList<Country>();
        if (!((new File(direct)).exists())) {direct = XML_COUNTRY_DEFAULT_RU;}
        Document document = builder.build(direct);
        Element root = document.getRootElement();
        List countryElem = root.getChildren();
        Iterator countryIterator = countryElem.iterator();
        while (countryIterator.hasNext()) {
            Element countryElement = (Element) countryIterator.next();
            Country country = new Country();
            country.setName(countryElement.getChild("countryName").getText());

            countries.add(country);
        }

        return countries;
    }

    public void writeXml(Document document, String direct) throws IOException {
        XMLOutputter outputter = new XMLOutputter();
        FileWriter writer = new FileWriter(direct);
        outputter.output(document, writer);
        writer.close();

    }

    @Override
    public void loadAllEN() throws JDOMException, IOException, ClassNotFoundException, ParseException {
        MainClass.holidays = xmlSaveLoad.loadHoliday(XML_HOLIDAY_PATCH_EN);
        MainClass.countries = xmlSaveLoad.loadCountry(XML_COUNTRY_PATCH_EN);
        MainClass.traditions = xmlSaveLoad.loadTradition(XML_TRADITION_PATCH_EN);
    }

    @Override
    public void loadAllRU() throws ClassNotFoundException, IOException, JDOMException, ParseException {
        MainClass.holidays = xmlSaveLoad.loadHoliday(XML_HOLIDAY_PATCH_RU);
        MainClass.countries = xmlSaveLoad.loadCountry(XML_COUNTRY_PATCH_RU);
        MainClass.traditions = xmlSaveLoad.loadTradition(XML_TRADITION_PATCH_RU);
    }

    @Override
    public void saveAllEN() throws IOException {
        xmlSaveLoad.saveHolidays(MainClass.holidays, XML_HOLIDAY_PATCH_EN);
        xmlSaveLoad.saveCountry(MainClass.countries, XML_COUNTRY_PATCH_EN);
        xmlSaveLoad.saveTradition(MainClass.traditions, XML_TRADITION_PATCH_EN);
    }

    @Override
    public void saveAllRU() throws IOException {
        xmlSaveLoad.saveHolidays(MainClass.holidays, XML_HOLIDAY_PATCH_RU);
        xmlSaveLoad.saveCountry(MainClass.countries, XML_COUNTRY_PATCH_RU);
        xmlSaveLoad.saveTradition(MainClass.traditions, XML_TRADITION_PATCH_RU);

    }
}
