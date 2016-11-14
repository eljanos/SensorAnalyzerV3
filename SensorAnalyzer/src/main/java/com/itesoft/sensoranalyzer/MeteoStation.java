package com.itesoft.sensoranalyzer;

/**
 * Created by janos on 06/11/2016.
 * Défini une station météo
 *
 * @param nom
 * nom de la station météo
 */

import com.itesoft.sensor.*;

import java.util.ArrayList;
import java.util.Iterator;


public class MeteoStation {

    public String stationName;
    protected ArrayList stationTSensorList;

    public MeteoStation(String nom) {

        stationName = nom;
        stationTSensorList = new ArrayList();

    }


    /**
     * renvoie le nom de la station
     *
     * @return un String contenant le nom de la station
     */
    public String getName() {

        return stationName;
    }


    /**
     * Ajoute un capteur à la station
     *
     * @param ligneSplitte Un String[] standardisé contenant
     * @param sensorType   Un String contenant le type de capteur (T,P,C)
     * @return un Boolean indiquant le succès de l'ajout
     */

    public boolean addSensor(String[] ligneSplitte, String sensorType) {
        Sensors newSensor;
        switch (sensorType) {
            case "T":
                newSensor = new TSensor(ligneSplitte[1], ligneSplitte[2], stationName);
                break;
            case "P":
                newSensor = new PSensor(ligneSplitte[1], ligneSplitte[2], stationName);
                break;
            case "H":
                newSensor = new HSensor(ligneSplitte[1], ligneSplitte[2], stationName);
                break;
            default:
                return false;
        }

        stationTSensorList.add(newSensor);

        return true;
    }


    /**
     * Renvoie tous les capteurs de la station
     *
     * @param sensorType Un String contenant le type de capteur (T,P,C)
     * @return un ArrayList de d'objets Sensors
     */


    public ArrayList getSensorList(String type) {
        ArrayList sensorList = new ArrayList();

        Iterator it = stationTSensorList.iterator();

        while (it.hasNext()) {

            Sensor s = (Sensor) it.next();
            if (s.getType().equals(type)) {
                sensorList.add(s);
            }
        }


        return sensorList;
    }
}
