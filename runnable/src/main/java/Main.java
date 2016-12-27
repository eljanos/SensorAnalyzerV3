
import com.itesoft.inputreader.InputReaderException;
import com.itesoft.inputreader.SensorLineException;
import com.itesoft.sensoranalyzer.SensorAnalyzer;


/**
 * @author jar
 */
public class Main {


    public static void main(String[] args) {

        String fileName = (args[0] !=null && args[1] !=null) ?  (args[0].equals("-f") ? args[1]:null) : null;

        System.out.println(SensorAnalyzer.NEW_LINE + SensorAnalyzer.NEW_LINE);
        System.out.println("Hello Guys ! " + SensorAnalyzer.NEW_LINE);
        System.out.println("Loading Data from Meteo Super Heros Provider Of America..." + SensorAnalyzer.NEW_LINE);
        System.out.println("Mr Stark, please turn off your jetpack... sensors are burning " + SensorAnalyzer.NEW_LINE + SensorAnalyzer.NEW_LINE);



        SensorAnalyzer analyser = new SensorAnalyzer(fileName);
        try {
            analyser.launch();


        } catch (InputReaderException e) {

            if (e instanceof SensorLineException){

            }



            else {

            }
            e.printStackTrace();
        }
        System.out.println(" file " + analyser.getFilename() +"analyzed");


    }
}
