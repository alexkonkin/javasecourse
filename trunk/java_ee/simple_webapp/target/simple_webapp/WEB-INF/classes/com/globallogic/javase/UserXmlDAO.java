package com.globallogic.javase;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 8/15/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserXmlDAO implements AbstractDAO {
    private String aDbFileName;

    UserXmlDAO(String aDbStorageName){
        aDbFileName = aDbStorageName;
        initUserStorage(aDbStorageName);
    }

    private void initUserStorage(String aDbStorageName){
        aDbFileName = aDbStorageName;
        boolean flag = false;

        File usersDB = new File(aDbFileName);
        try {
            if (!usersDB.exists()){
                flag = usersDB.createNewFile();
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("logininfo");
                doc.appendChild(rootElement);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(aDbFileName));

                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.transform(source, result);
            }
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);
        } catch (TransformerException te){
            System.out.println("Error while transforming xml file" + te);
        } catch (ParserConfigurationException pce){
            System.out.println("Error while parsing xml file" + pce);
        }
    }

    public User getUser(String aLogin){
        User aUser;
        User result = new User();
        try{
            //File fXmlFile = new File("D:\\oleksiy.konkin\\Documents\\JAVA\\JAVA_SE\\chapter_7\\LoginManager\\staff.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = null;
            doc = dBuilder.parse(aDbFileName);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("credential");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nelement :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("credential id : " + eElement.getAttribute("id"));
                    //System.out.println("login : " + eElement.getAttribute("login"));
                    //System.out.println("password : " + eElement.getAttribute("password"));
                    if(eElement.getAttribute("login").equals(aLogin)){
                        result.setLogin(eElement.getAttribute("login"));
                        result.setPassword(eElement.getAttribute("password"));
                        continue;
                    }
                }
            }
        }catch (IOException ioe) {
            System.out.println("Error while reading db file" + ioe);
        }
        catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (result.getLogin().equals(""))
            return null;
        else
            return result;
    }

    public void putUser (User aUser) throws UserAlreadyExists{
        boolean result = false;
        if(getUser(aUser.getLogin()) == null){
            try{
                File fXmlFile = new File(aDbFileName);

                //System.out.println("UserXmlDAO  "+aDbFileName);

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();
                Element rootElement = doc.getDocumentElement();

                //System.out.println("root element :" + rootElement.getNodeName());

                NodeList nList = doc.getElementsByTagName("credential");
                //System.out.println("Node count :" + nList.getLength());


                Element userData = doc.createElement("credential");
                rootElement.appendChild(userData);

                // set attribute to staff element
                Attr id = doc.createAttribute("id");
                Attr login = doc.createAttribute("login");
                Attr password = doc.createAttribute("password");
                id.setValue(Integer.toString(nList.getLength()+1));
                login.setValue(aUser.getLogin());
                password.setValue(aUser.getPassword());
                userData.setAttributeNode(id);
                userData.setAttributeNode(login);
                userData.setAttributeNode(password);

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult sresult = new StreamResult(new File(aDbFileName));

                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.transform(source, sresult);
            }catch (IOException e) {
                System.out.println("Error while reading db file" + e);
            }
            catch (ParserConfigurationException e){
                e.printStackTrace();
            }
            catch (TransformerConfigurationException e){
                e.printStackTrace();
            }
            catch (TransformerException e){
                e.printStackTrace();
            }
            catch (SAXException e){
                e.printStackTrace();
            }
        }else{
            throw new UserAlreadyExists(aUser.getLogin());
        }
    }

}
