/**
 * Created by jar on 08/11/2016.
 */

import com.itesoft.sensoranalyzer.SensorAnalyzer;

public class Main {

    private static String newligne = System.getProperty("line.separator");

    public static void main(String[] args) {

        System.out.println(newligne + newligne);
        System.out.println("Hello Guys ! " + newligne);
        System.out.println("Loading Data from Meteo Super Heros Provider Of America..." + newligne);
        System.out.println("Mr Stark, please turn off your jetpack... sensors are burning " + newligne + newligne);

        SensorAnalyzer analyser = new SensorAnalyzer();
        analyser.launch();

    }
}
