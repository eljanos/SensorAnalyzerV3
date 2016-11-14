/**
 * Created by janos on 06/11/2016.
 */

package com.itesoft.sensoranalyzer;

import com.itesoft.sensor.Sensor;
import com.itesoft.sensor.Sensors;

import java.util.ArrayList;
import java.util.Iterator;

public class MesuresProcessor {

    private static String newligne = System.getProperty("line.separator");


    /**
     * getAllMinSensors
     *
     * @param mesures objet MesureContainer
     * @return String contenant les valeurs minimales de chaque type de sensor
     */

    public static String getAllMinSensors(MesureContainer mesures) {

        String retour = "";

        retour = retour + " Température - " + getMinSensors(mesures, "T") + newligne;
        retour = retour + " Pression - " + getMinSensors(mesures, "P") + newligne;
        retour = retour + " Humidité - " + getMinSensors(mesures, "H") + newligne;

        return retour;

    }

    /**
     * getAllMaxSensors
     *
     * @param mesures objet MesureContainer
     * @return String contenant les valeurs maximales de chaque type de sensor
     */

    public static String getAllMaxSensors(MesureContainer mesures) {

        String retour = "";
        retour = retour + " Température - " + getMaxSensors(mesures, "T") + newligne;
        retour = retour + " Pression - " + getMaxSensors(mesures, "P") + newligne;
        retour = retour + " Humidité - " + getMaxSensors(mesures, "H") + newligne;

        return retour;

    }

    /**
     * getAllAvgSensors
     *
     * @param mesures objet MesureContainer
     * @return String contenant les valeurs moyennes de chaque type de sensor
     */

    public static String getAllAvgSensors(MesureContainer mesures) {

        String retour = "";
        retour = retour + " Température : " + getAvgSensors(mesures, "T") + newligne;
        retour = retour + " Pression : " + getAvgSensors(mesures, "P") + newligne;
        retour = retour + " Humidité : " + getAvgSensors(mesures, "H") + newligne;

        return retour;

    }

    public static String getMinSensors(MesureContainer mesures, String type) {
        float minValue = 100000;
        String station = "";

        ArrayList sensorsList = mesures.getAllSensors(type);
        Iterator it = sensorsList.iterator();

        while (it.hasNext()) {
            //SensorLogger.log("Parcours des " + type) ;
            Sensor s = (Sensor) it.next();
            //SensorLogger.log("process : " + s.getType()+ " , " + s.getValue());
            if (s.getValue() < minValue) {
                minValue = s.getValue();
                station = s.getStation();
            }
            //SensorLogger.log("Fin calcul " + station);

        }

        if (station.equals("")) {
            return "No Data";
        } else {
            return station + " : " + Float.toString(minValue);
        }

    }

    ;


    public static String getMaxSensors(MesureContainer mesures, String type) {
        float maxValue = -100000;
        String station = "";

        ArrayList sensorsList = mesures.getAllSensors(type);
        Iterator it = sensorsList.iterator();

        while (it.hasNext()) {
            //SensorLogger.log("Parcours des " + type) ;
            Sensors s = (Sensors) it.next();
            if (s.getValue() > maxValue) {
                maxValue = s.getValue();
                station = s.getStation();
            }

        }


        if (station.equals("")) {
            return "No Data";
        } else {
            return station + " : " + Float.toString(maxValue);
        }

    }

    ;


    public static String getAvgSensors(MesureContainer mesures, String type) {
        float value = 0;
        String station = "";
        Integer nombreCapteurs = 0;


        ArrayList sensorsList = mesures.getAllSensors(type);
        Iterator it = sensorsList.iterator();

        while (it.hasNext()) {
            //SensorLogger.log("Parcours des " + type) ;
            Sensors s = (Sensors) it.next();

            value = value + s.getValue();

            nombreCapteurs++;


        }


        return Float.toString(value / nombreCapteurs);


    }

    ;

    public static String getErrors(MesureContainer mesures) {
        ArrayList erreurs = mesures.getFailedMesures();
        String retour = "";
        Iterator it = erreurs.iterator();
        Integer nb = 0;
        Integer nbs = 0;
        // String newligne = System.getProperty("line.separator");
        String value = "";

        while (it.hasNext()) {
            //SensorLogger.log("Parcours des " + type) ;
            value = (String) it.next();
            if(!value.substring(0,7).equals("STATION"))
            {
                nb++;
                retour = retour +  value + newligne;
            }
            else {
                nbs ++;
                retour = retour + newligne + value + newligne + newligne;
            }


        }

        retour = nb.toString() + " capteur(s)  et "+ nbs +" station(s) en erreur : " + newligne + newligne + retour;

        return retour;


    }


}
