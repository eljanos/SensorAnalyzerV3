package com.itesoft.inputreader;

/**
 * Created by janos on 06/11/2016.
 */

import com.itesoft.logger.SensorLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MSHPOAInputReader implements InputReaders {

    private File file;
    private String filePath;
    private BufferedReader br;
    private FileReader sourceFile;

    /**
     *
     * @param fichier nom du fichier à traiter par le reader;
     */

    public MSHPOAInputReader(String fichier){
        filePath = fichier;
    }


    /**
     * ramène la ligne courante d'information
     * renvoie :
     * la ligne
     * ou null
     * ou COMMENT,NULL
     * ou ERROR,la ligne
     *
     * @return String ligne d'information formattée
     */
    public String[] getInformationLine() throws SensorLineException {

        String ligne = "";
        String[] ligneSplitte = null;


        try {
            ligne = br.readLine();

            if (ligne == null) {
                return null;
            }


            SensorLogger.log("retour lecture " + ligne);



            //Gestion des lignes de commentaire
            if (ligne.substring(0, 1).equals("#")) {
                ligne = "COMMENT,NULL";
            }

            // formating d'un HSensor
            ligneSplitte = ligne.split(",");
            if (ligne.substring(0, 2).equals("H,")) {
                // ligne de Humidité, la donnée n'est pas en 3eme
                String retourFormat = ligneSplitte[0] + "," + " " + "," + ligneSplitte[1];
                return retourFormat.split(",");
            }

            // formating d'un PSensor
            if (ligne.substring(0, 2).equals("P,")) {
                // ligne de pression, la donnée n'est pas en 3eme position
                String retourFormat = ligneSplitte[0] + "," + ligneSplitte[1] + "," + ligneSplitte[3] + "," + ligneSplitte[2];
                return retourFormat.split(",");
            }

        } catch (StringIndexOutOfBoundsException | IOException e ) {
            throw new SensorLineException(filePath);

//            SensorLogger.log("ERROR ligne : " + ligne);
//            ligne = "ERROR," + ligne;
//            ligneSplitte = ligne.split(",");
        }

        return ligneSplitte;

    }




    /**
     * Ouvre la source de donnée pour l'instant définie en dur
     *
     * @return Boolean réussite de l'ouverture
     */
    public Boolean openDataSource() {
        // A FAIRE : Gestion d'erreur si le fichier n'existe pas
        // A FAIRE : Mettre le nom du fichier paramétrable dans le xml de param
        try {
            sourceFile = new FileReader(new File(filePath));
            br = new BufferedReader(sourceFile);
        } catch (IOException e) {
            SensorLogger.log(e.getStackTrace().toString());
            return false;
        }

        return true;
    }

    /**
     * Ferme la source de donnée
     */
    public void closeDataSource() {
        try {
            sourceFile.close();
        } catch (IOException e) {
            SensorLogger.log(e.getStackTrace().toString());
        }

    }

}
