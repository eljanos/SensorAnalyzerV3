package com.itesoft.sensoranalyzer;

import com.itesoft.inputreader.InputReaders;
import com.itesoft.logger.SensorLogger;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by janos on 06/11/2016.
 * <p>
 * <p>
 * Il contiens la liste des stations.
 * Il peut fournir la liste des stations
 * Il peut founir la liste des capteurs par station
 * Il peut fournir la liste globale des capteurs*
 */


public class MesureContainer {
    private Hashtable stationList;
    private ArrayList failedMesures;


    public MesureContainer() {

        stationList = new Hashtable();
        failedMesures = new ArrayList();

    }

    /**
     * getFailedMesures
     *
     * @return ArrayList contenant des Strings de mesures en erreur
     */

    public ArrayList getFailedMesures() {
        return failedMesures;
    }


    /**
     * fillWithData : Remplissage du MesureContainer depuis une InputReader
     *
     * @return Boolean qui indique si le chargement s'est bien passé
     * @input InputReader reader de capteurs
     */

    public Boolean fillWithData(InputReaders reader) {

        Integer nbCapteurs = 0;
        Integer nbCapteursAttendus = 0;
        reader.openDataSource();

        String[] ligne = null;
        MeteoStation currentStation = null;

        ligne = (String[]) reader.getInformationLine();

        try {

            while (ligne != null) {


                if (ligne[0].equals("ERROR")) {
                    if (currentStation != null) {
                        nbCapteurs++;
                        failedMesures.add("CAPTEUR " +currentStation.getName() + " : " + ligne[1]);
                    } else {
                        failedMesures.add("CAPTEUR " +"pas de station / ligne de capteur : " + ligne[1]);
                    }
                } else if (amIStationLine(ligne[0]) == true && !ligne[0].equals("COMMENT")) {

                    //Gestion d'une ligne de station
                    //logger.debug("STATION" + ligne);
                    if (currentStation != null) {
                        // on vérifie que le nombre de capteurs est juste
                        if (!nbCapteurs.equals(nbCapteursAttendus)) {
                            failedMesures.add("STATION "+currentStation.getName() + " : " + nbCapteursAttendus + " capteurs attendus mais " + nbCapteurs + " trouvés");
                        }
                    }
                    nbCapteurs = 0;
                    nbCapteursAttendus = Integer.parseInt(ligne[1]);
                    currentStation = addStation(ligne[0]);
                } else if (!ligne[0].equals("COMMENT")) {
                    //Gestion d'une ligne de donnée
                    //SensorLogger.log("LIGNE");
                    try {
                        nbCapteurs++;
                        currentStation.addSensor(ligne, ligne[0]);
                    } catch (NumberFormatException e) {
                        //gestion d'un capteur en erreur

                        String errorLine = "";
                        Integer it = 0;

                        while (it < ligne.length) {
                            //SensorLogger.log("Parcours des " + type) ;
                            //SensorLogger.log(ligne[it]);
                            errorLine += ligne[it];
                            it++;
                        }
                        failedMesures.add("CAPTEUR " +currentStation.getName() + " : " + errorLine);
                    }

                }

                ligne = reader.getInformationLine();
            }
        } catch (NullPointerException e) {
            SensorLogger.log(e.getStackTrace().toString());
        }

        return true;
    }

    /**
     * NumberOfStation
     *
     * @return Integer nombre de stations connues
     */

    public Integer numberOfStations() {
        return stationList.size();
    }

    /**
     * private MeteoStation
     *
     * @param String contenant le nom de la station
     * @return un objet MeteoStation
     */

    private MeteoStation addStation(String ligne) {


        MeteoStation station = new MeteoStation(ligne);
        stationList.put(ligne, station);
        return station;
    }

    /**
     * @param type String type de capteur souhaité
     * @return ArrayList contenant des Sensors
     */


    public ArrayList getAllSensors(String type) {
        ArrayList tSensorList = new ArrayList();
        String str = "";
        Set<String> keys = stationList.keySet();
        MeteoStation station = null;

        Iterator<String> itr = keys.iterator();

        while (itr.hasNext()) {

            str = itr.next();
            station = (MeteoStation) stationList.get(str);
            //SensorLogger.log("Key: " + str + " & Value: " + station);
            tSensorList.addAll(station.getSensorList(type));
        }
        return tSensorList;
    }

    /**
     * @param ligne String
     * @return Boolean
     * true si c'est une station sinon false
     */

    private Boolean amIStationLine(String ligne) {

        if (ligne.length() > 1) {
            return true;
        }

        return false;
    }

}
