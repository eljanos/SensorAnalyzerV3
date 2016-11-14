package com.itesoft.sensor;

/**
 * Created by jar on 09/11/2016.
 */
public abstract class Sensor implements Sensors {

    public float value;
    public String unite;
    public String station;

    /**
     * @param u    String unité de la mesure
     * @param t    String donnée de la mesure
     * @param lieu String Station de la mesure
     */

    public Sensor(String u, String t, String lieu) {
        value = Float.parseFloat(t);
        unite = u;
        station = lieu;
    }

    /**
     * @param u String unité de la mesure
     * @param t String donnée de la mesure
     */

    public Sensor(String u, String t) {
        value = Float.parseFloat(t);
        unite = u;
        station = "";
    }

    public Sensor() {
        value = Float.parseFloat("0");
        unite = "";
        station = "";
    }

    /**
     * @return Float valeur du capteur
     */
    public float getValue() {
        return value;
    }

    /**
     * @return String station du capteur
     */
    public String getStation() {
        return station;
    }
}