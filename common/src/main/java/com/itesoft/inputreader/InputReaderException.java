package com.itesoft.inputreader;

/**
 *
 */
public class InputReaderException extends Exception {


    /**
     * Initialize checked exceptions explicitly caught or propagated  message.
     *
     * @param msg that describe de exception
     */
    public InputReaderException(final String msg) {
        super(msg);
    }

    /**
     * Initialize checked exceptions explicitly caught or propagated  message, and his cause.
     *
     * @param msg   that describe de exception
     * @param cause of this exception
     */
    public InputReaderException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    /**
     * Initialize checked exceptions explicitly caught or propagated  cause.
     *
     * @param cause of this exception
     */
    public InputReaderException(final Throwable cause) {
        super(cause);
    }
}
