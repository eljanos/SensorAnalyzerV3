/**
 * Created by janos on 06/11/2016.
 */
package com.itesoft.inputreader;

/**
 * Interface des input readers
 */

public interface InputReaders {


        /**
         * Ouvre la source de donnée
         *
         * @return un Boolean indiquant le succès de l'ouverture
         */

    public Boolean openDataSource();

    /**
     * Ferme la source de donnée
     */

    public void closeDataSource();


    /**
     * Renvoie la ligne courante
     *
     * @return un String[] avec les données structurées du capteur Type,Unité,Valeur,[Autre]
     * Type peut contenir COMMENT si c'est une ligne de commentaire
     * Type peut contenir ERROR si c'est une ligne mal structurée ( unité contiendra alors la ligne )
     */
    public String[] getInformationLine();

}
