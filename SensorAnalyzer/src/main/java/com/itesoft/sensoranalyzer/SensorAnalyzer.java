package com.itesoft.sensoranalyzer;

import com.itesoft.inputreader.MSHPOAInputReader;
import com.itesoft.logger.SensorLogger;


/**
 * Created by janos on 05/11/2016.
 */


public class SensorAnalyzer {


    private MSHPOAInputReader reader;
    private MesureContainer mesures;


    public void launch() {

        SensorLogger.log("Démarrage de l'analyzer");

        reader = new MSHPOAInputReader("sensors.txt");

        mesures = new MesureContainer();
        mesures.fillWithData(reader);

        String Newligne = System.getProperty("line.separator");

        System.out.println("################################################################");
        System.out.println("");
        System.out.println(mesures.numberOfStations() + " Registered stations " + Newligne);

        System.out.println("################################################################" + Newligne);

        System.out.println("Valeurs minimales des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllMinSensors(mesures));


        System.out.println("################################################################" + Newligne);

        System.out.println("Valeurs minimales des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllMaxSensors(mesures));

        System.out.println("################################################################" + Newligne);

        System.out.println("Valeurs moyennes des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllAvgSensors(mesures));

        System.out.println("################################################################" + Newligne);

        System.out.println(MesuresProcessor.getErrors(mesures));


    }


}
