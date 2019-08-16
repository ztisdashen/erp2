package com.exception;

/**
 * @program: erp2
 * @description:
 * @author: zt648
 * @create: 2019-08-16 11:42
 **/
public class ERPException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ERPException(String message) {
        super(message);
    }
}
