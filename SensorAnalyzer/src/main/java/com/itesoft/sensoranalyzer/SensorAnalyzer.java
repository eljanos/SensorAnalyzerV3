package com.itesoft.sensoranalyzer;

import com.itesoft.inputreader.InputReaderException;
import com.itesoft.inputreader.MSHPOAInputReader;
import com.itesoft.inputreader.SensorLineException;
import com.itesoft.logger.SensorLogger;


/**
 * @author jar
 */
public class SensorAnalyzer {


    private String filename;

    public final static String NEW_LINE= System.getProperty("line.separator");

    private final static String DEFAULT_FILE_NAME="sensors.txt";

    public SensorAnalyzer(final String fileName){
        this.filename = fileName;
    }

    public String getFilename() {
        return filename !=null ? filename : DEFAULT_FILE_NAME  ;
    }

    public void launch() throws InputReaderException {

        SensorLogger.log("Démarrage de l'analyzer");
        MSHPOAInputReader reader;
        MesureContainer mesures;
        reader = new MSHPOAInputReader(getFilename());

        mesures = new MesureContainer();
        mesures.fillWithData(reader);


        System.out.println("################################################################");
        System.out.println("");
        System.out.println(mesures.numberOfStations() + " Registered stations " + SensorAnalyzer.NEW_LINE);

        System.out.println("################################################################" + SensorAnalyzer.NEW_LINE);

        System.out.println("Valeurs minimales des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllMinSensors(mesures));


        System.out.println("################################################################" + SensorAnalyzer.NEW_LINE);

        System.out.println("Valeurs minimales des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllMaxSensors(mesures));

        System.out.println("################################################################" + SensorAnalyzer.NEW_LINE);

        System.out.println("Valeurs moyennes des capteurs connus : ");
        System.out.println(MesuresProcessor.getAllAvgSensors(mesures));

        System.out.println("################################################################" + SensorAnalyzer.NEW_LINE);

        System.out.println(MesuresProcessor.getErrors(mesures));


    }


}
