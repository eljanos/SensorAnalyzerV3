package com.itesoft.sensor;

/**
 * Created by janos on 05/11/2016.
 */

public interface Sensors {


    /**
     * @return Float valeur du capteur
     */
    public float getValue();


    /**
     * @return String le type de capteur
     */
    public String getType();

    /**
     * @return String station du capteur
     */
    public String getStation();


}
