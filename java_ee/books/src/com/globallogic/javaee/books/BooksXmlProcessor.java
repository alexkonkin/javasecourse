package com.globallogic.javaee.books;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 9/12/13
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class BooksXmlProcessor {
    private Catalog booksCatalog;

    public BooksXmlProcessor(Catalog aCatalog){
        booksCatalog = aCatalog;
    }

    public void marshalToXmlFile(String aFimeName){
        try {
            JAXBContext jaxContext = JAXBContext.newInstance(booksCatalog.getClass());
            Marshaller aMarshaller = jaxContext.createMarshaller();
            aMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            aMarshaller.marshal( booksCatalog, new FileOutputStream(aFimeName));
        }  catch( FileNotFoundException fe) {
            fe.printStackTrace();
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
    }

    public String marshalToXmlString(){
        String anXmlString = new String();
        try {
            JAXBContext jaxContext = JAXBContext.newInstance(booksCatalog.getClass());
            Marshaller aMarshaller = jaxContext.createMarshaller();
            aMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            StringWriter stringWriter = new StringWriter();
            aMarshaller.marshal( booksCatalog, stringWriter);
            anXmlString = stringWriter.toString();
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        return anXmlString;
    }

    public Catalog unMarshalFromXmlFile(String aFileName) {
        Catalog result = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(booksCatalog.getClass());
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File anXmlFile = new File(aFileName);
            result = (Catalog) unmarshaller.unmarshal(anXmlFile);
        } catch (JAXBException je) {
            je.printStackTrace();
        }
        return result;
    }

    public Catalog unMarshalFromString (String aString){
        Catalog result = null;
        String content = new String(aString);
        try {
            JAXBContext jc = JAXBContext.newInstance(Catalog.class);
            StringReader stringReader = new StringReader(content);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            result = (Catalog) unmarshaller.unmarshal(stringReader);
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        return result;
    }

    public Catalog unMarshalFromClassPath(String anXmlFileName){
        Catalog result = null;
            try {
                JAXBContext jc = JAXBContext.newInstance(booksCatalog.getClass());
                InputStream inputStream = booksCatalog.getClass().getClassLoader().getResourceAsStream(anXmlFileName);
                String inputStreamString = new Scanner(inputStream,"UTF-8").useDelimiter("\\A").next();
                StringReader stringReader = new StringReader(inputStreamString);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                result = (Catalog) unmarshaller.unmarshal(stringReader);
            } catch( JAXBException je ) {
                je.printStackTrace();
            }
            return result;
    }

}