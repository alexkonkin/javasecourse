package com.globallogic.javaee.service;

/**
 * Common service exception. Throws in case of logic errors in services.
 * 
 */
public class ServiceException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message and cause
     */
    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message
     */
    public ServiceException(String message)
    {
        super(message);
    }
}
