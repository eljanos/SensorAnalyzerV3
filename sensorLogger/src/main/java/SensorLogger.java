package com.itesoft.logger;

/**
 * Created by jar on 09/11/2016.
 */

import org.apache.log4j.Logger;

public class SensorLogger {

    static final Logger logger = Logger.getLogger("sensorlogger");

    /**
     * Logge un message dans le logger standard de sensorlogger
     *
     * @param String message
     */
    public static void log(String message) {
        logger.info(message);
    }
}
