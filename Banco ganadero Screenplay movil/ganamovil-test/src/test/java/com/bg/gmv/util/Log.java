package com.bg.gmv.util;

import org.apache.log4j.Logger;

/**
 * Esta clase sirve para manejo de logs.
 */
public class Log {
    //Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());//

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startTestCase(final String sTestCaseName) {
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    /**
     * This is to print log for the ending of the test case.
     * @param sTestCaseName es el caso de prueba.
     */
    public static void endTestCase(final String sTestCaseName) {
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");
    }

    /**
     * Implementacion por defecto.
     * @param message es el mensaje a loggear.
     */
    public static void info(final String message) {
        Log.info(message);
    }

    /**
     * Implementacion por defecto.
     * @param message es el mensaje a loggear.
     */
    public static void warn(final String message) {
        Log.warn(message);
    }

    /**
     * Implementacion por defecto.
     * @param message es el mensaje a loggear.
     */
    public static void error(final String message) {
        Log.error(message);
    }

    /**
     * Implementacion por defecto.
     * @param message es el mensaje a loggear.
     */
    public static void fatal(final String message) {
        Log.fatal(message);
    }

    /**
     * Implementacion por defecto.
     * @param message es el mensaje a loggear.
     */
    public static void debug(final String message) {
        Log.debug(message);
    }
}
