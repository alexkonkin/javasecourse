package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/13/13
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceException extends Exception {

    ServiceException() {
        ;
    }

    public String toString() {
        return "Service Exception has happened";
    }

}
