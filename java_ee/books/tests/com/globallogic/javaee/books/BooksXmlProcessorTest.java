package com.globallogic.javaee.books;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.custommonkey.xmlunit.XMLTestCase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 9/12/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */



public class BooksXmlProcessorTest extends XMLTestCase {
    public BooksXmlProcessorTest(String name) {
        super(name);
    }

    public void testMarshalToXmlFile() throws Exception {

        Catalog aCatalog = new Catalog();
        Books aBooks = new Books();

        Book aBook1 = new Book();
        Book aBook2 = new Book();

        aBook1.setId(BigInteger.valueOf(111));
        aBook1.setName("Learning JAXB");
        aBook1.setISBN(BigInteger.valueOf( 123445));
        aBook1.setPrice("34.12 $");
        Authors anAuthorsBook1 = new Authors();
        anAuthorsBook1.addAuthor("Jane Doe");
        aBook1.setDescription("Step by step instructions for beginners");
        aBook1.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2003,01,01)));
        aBook1.setAuthors(anAuthorsBook1);

        aBook2.setId(BigInteger.valueOf(222));
        aBook2.setName("Java Webservices today and Beyond");
        aBook2.setISBN(BigInteger.valueOf( 522965));
        aBook2.setPrice("29.12 $");
        Authors anAuthorsBook2 = new Authors();
        anAuthorsBook2.addAuthor("John Brown");
        anAuthorsBook2.addAuthor("Peter T.");
        aBook2.setDescription("Information for users so that they can start using Java Web Services Developer Pack");
        aBook2.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2002,11,01)));
        aBook2.setAuthors(anAuthorsBook2);

        aBooks.addBook(aBook1);
        aBooks.addBook(aBook2);

        aCatalog.setBooks(aBooks);
        Path aPathToTestFile = FileSystems.getDefault().getPath(".", "testBooksMarshalToFile.xml");
        if(Files.exists(aPathToTestFile))
            Files.delete(aPathToTestFile);


        BooksXmlProcessor aProcessor = new BooksXmlProcessor(aCatalog);
        aProcessor.marshalToXmlFile("testBooksMarshalToFile.xml");


        String xmlStringFromSampleFile = new Scanner(new File("books1.xml")).useDelimiter("\\Z").next();
        String contentMarshalledToXmlFile = new Scanner(new File("testBooksMarshalToFile.xml")).useDelimiter("\\Z").next();

        assertXMLEqual("comparing books1.xml to testBooksMarshalToFile.xml", xmlStringFromSampleFile, contentMarshalledToXmlFile);
        //Files.delete(aPathToTestFile);
    }

    public void testMarshalToXmlString() throws Exception {

        Catalog aCatalog = new Catalog();
        Books aBooks = new Books();

        Book aBook1 = new Book();
        Book aBook2 = new Book();

        aBook1.setId(BigInteger.valueOf(111));
        aBook1.setName("Learning JAXB");
        aBook1.setISBN(BigInteger.valueOf( 123445));
        aBook1.setPrice("34.12 $");
        Authors anAuthorsBook1 = new Authors();
        anAuthorsBook1.addAuthor("Jane Doe");
        aBook1.setDescription("Step by step instructions for beginners");
        aBook1.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2003,01,01)));
        aBook1.setAuthors(anAuthorsBook1);

        aBook2.setId(BigInteger.valueOf(222));
        aBook2.setName("Java Webservices today and Beyond");
        aBook2.setISBN(BigInteger.valueOf( 522965));
        aBook2.setPrice("29.12 $");
        Authors anAuthorsBook2 = new Authors();
        anAuthorsBook2.addAuthor("John Brown");
        anAuthorsBook2.addAuthor("Peter T.");
        aBook2.setDescription("Information for users so that they can start using Java Web Services Developer Pack");
        aBook2.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2002,11,01)));
        aBook2.setAuthors(anAuthorsBook2);

        aBooks.addBook(aBook1);
        aBooks.addBook(aBook2);

        aCatalog.setBooks(aBooks);

        BooksXmlProcessor aProcessor = new BooksXmlProcessor(aCatalog);
        String testXmlString = aProcessor.marshalToXmlString();

        String xmlStringFromSampleFile = new Scanner(new File("books1.xml")).useDelimiter("\\Z").next();

        assertXMLEqual("comparing books1.xml to testXmlString", xmlStringFromSampleFile, testXmlString);
    }

    public void testUnMarshalFromClassPath() throws Exception {
        Catalog aCatalog = new Catalog();
        Books aBooks = new Books();

        Book aBook1 = new Book();
        Book aBook2 = new Book();

        aBook1.setId(BigInteger.valueOf(111));
        aBook1.setName("Learning JAXB");
        aBook1.setISBN(BigInteger.valueOf( 123445));
        aBook1.setPrice("34.12 $");
        Authors anAuthorsBook1 = new Authors();
        anAuthorsBook1.addAuthor("Jane Doe");
        aBook1.setDescription("Step by step instructions for beginners");
        aBook1.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2003,01,01)));
        aBook1.setAuthors(anAuthorsBook1);

        aBook2.setId(BigInteger.valueOf(222));
        aBook2.setName("Java Webservices today and Beyond");
        aBook2.setISBN(BigInteger.valueOf( 522965));
        aBook2.setPrice("29.12 $");
        Authors anAuthorsBook2 = new Authors();
        anAuthorsBook2.addAuthor("John Brown");
        anAuthorsBook2.addAuthor("Peter T.");
        aBook2.setDescription("Information for users so that they can start using Java Web Services Developer Pack");
        aBook2.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2002,11,01)));
        aBook2.setAuthors(anAuthorsBook2);

        aBooks.addBook(aBook1);
        aBooks.addBook(aBook2);

        aCatalog.setBooks(aBooks);

        //marshall Catalog class back to the string and compare with the demo string
        BooksXmlProcessor testProcessorSample = new BooksXmlProcessor(aCatalog);
        String sampleString = testProcessorSample.marshalToXmlString();

        Catalog testObject = testProcessorSample.unMarshalFromClassPath("books1.xml");

        BooksXmlProcessor testProcessorTest = new BooksXmlProcessor(testObject);
        String testString = testProcessorTest.marshalToXmlString();

        assertXMLEqual("comparing books1.xml to testXmlString", sampleString, testString);
    }

    public void testUnMarshalFromString() throws Exception {
        Catalog aCatalog = new Catalog();
        Books aBooks = new Books();

        Book aBook1 = new Book();
        Book aBook2 = new Book();

        aBook1.setId(BigInteger.valueOf(111));
        aBook1.setName("Learning JAXB");
        aBook1.setISBN(BigInteger.valueOf( 123445));
        aBook1.setPrice("34.12 $");
        Authors anAuthorsBook1 = new Authors();
        anAuthorsBook1.addAuthor("Jane Doe");
        aBook1.setDescription("Step by step instructions for beginners");
        aBook1.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2003,01,01)));
        aBook1.setAuthors(anAuthorsBook1);

        aBook2.setId(BigInteger.valueOf(222));
        aBook2.setName("Java Webservices today and Beyond");
        aBook2.setISBN(BigInteger.valueOf( 522965));
        aBook2.setPrice("29.12 $");
        Authors anAuthorsBook2 = new Authors();
        anAuthorsBook2.addAuthor("John Brown");
        anAuthorsBook2.addAuthor("Peter T.");
        aBook2.setDescription("Information for users so that they can start using Java Web Services Developer Pack");
        aBook2.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2002,11,01)));
        aBook2.setAuthors(anAuthorsBook2);

        aBooks.addBook(aBook1);
        aBooks.addBook(aBook2);

        aCatalog.setBooks(aBooks);

        String xmlStringFromSampleFile = new Scanner(new File("books1.xml")).useDelimiter("\\Z").next();

        //marshall Catalog class back to the string and compare with the demo string
        //marshall Catalog class back to the string and compare with the demo string
        BooksXmlProcessor testProcessorSample = new BooksXmlProcessor(aCatalog);
        String sampleString = testProcessorSample.marshalToXmlString();

        Catalog testObject = testProcessorSample.unMarshalFromString(xmlStringFromSampleFile);

        BooksXmlProcessor testProcessorTest = new BooksXmlProcessor(testObject);
        String testString = testProcessorTest.marshalToXmlString();

        assertXMLEqual("comparing books1.xml to testXmlString", sampleString, testString);
    }

    public void testUnMarshalFromFile() throws Exception {
        Catalog aCatalog = new Catalog();
        Books aBooks = new Books();

        Book aBook1 = new Book();
        Book aBook2 = new Book();

        aBook1.setId(BigInteger.valueOf(111));
        aBook1.setName("Learning JAXB");
        aBook1.setISBN(BigInteger.valueOf( 123445));
        aBook1.setPrice("34.12 $");
        Authors anAuthorsBook1 = new Authors();
        anAuthorsBook1.addAuthor("Jane Doe");
        aBook1.setDescription("Step by step instructions for beginners");
        aBook1.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2003,01,01)));
        aBook1.setAuthors(anAuthorsBook1);

        aBook2.setId(BigInteger.valueOf(222));
        aBook2.setName("Java Webservices today and Beyond");
        aBook2.setISBN(BigInteger.valueOf( 522965));
        aBook2.setPrice("29.12 $");
        Authors anAuthorsBook2 = new Authors();
        anAuthorsBook2.addAuthor("John Brown");
        anAuthorsBook2.addAuthor("Peter T.");
        aBook2.setDescription("Information for users so that they can start using Java Web Services Developer Pack");
        aBook2.setPublishDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2002,11,01)));
        aBook2.setAuthors(anAuthorsBook2);

        aBooks.addBook(aBook1);
        aBooks.addBook(aBook2);

        aCatalog.setBooks(aBooks);

        String xmlStringFromSampleFile = new Scanner(new File("books1.xml")).useDelimiter("\\Z").next();

        //marshall Catalog class back to the string and compare with the demo string
        //marshall Catalog class back to the string and compare with the demo string
        BooksXmlProcessor testProcessorSample = new BooksXmlProcessor(aCatalog);
        String sampleString = testProcessorSample.marshalToXmlString();

        Catalog testObject = testProcessorSample.unMarshalFromXmlFile("books1.xml");

        BooksXmlProcessor testProcessorTest = new BooksXmlProcessor(testObject);
        String testString = testProcessorTest.marshalToXmlString();

        assertXMLEqual("comparing books1.xml to testXmlString", sampleString, testString);
    }

}