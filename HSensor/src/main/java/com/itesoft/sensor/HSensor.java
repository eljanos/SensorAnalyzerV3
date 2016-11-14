package com.itesoft.sensor;

/**
 * Created by janos on 06/11/2016.
 */


public class HSensor extends Sensor {

    /**
     * @param u    String unité de la mesure
     * @param t    String donnée de la mesure
     * @param lieu String Station de la mesure
     */
    public HSensor(String u, String t, String lieu) {
        super(u, t, lieu);
    }

    /**
     * @param u String unité de la mesure
     * @param t String donnée de la mesure
     */
    public HSensor(String u, String t) {
        super(u, t);
    }

    /**
     * Retourne le type de capteur
     *
     * @return String type de capteur ( H )
     */
    public String getType() {
        return "H";
    }


}
