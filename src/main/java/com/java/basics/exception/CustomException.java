package com.java.basics.exception;

import com.java.basics.collection.UsingExistingData;

import java.io.FileNotFoundException;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomException extends Exception {

    CustomException(String exp, Throwable ex) {
        super(exp, ex);
    }

    CustomException(String message, Throwable cause,
                    boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void main(String[] args) throws CustomException {
        CustomException customException = new CustomException("me", new Throwable());
        throw customException;
    }

    public static void main(String args) {

    }
}
