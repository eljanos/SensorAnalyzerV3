package com.itesoft.inputreader;

/**
 * @author jar
 */
public class SensorLineException extends InputReaderException {

    public final static String MSG = "bad line %s";




    public SensorLineException(final String line) {
        super(String.format(MSG, line));
    }

}
