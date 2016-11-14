import com.itesoft.sensor.TSensor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jar on 07/11/2016.
 */
public class TSensorTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getValue() throws Exception {

    }

    @org.junit.Test
    public void getType() throws Exception {

        TSensor sensor = new TSensor("C", "10");
        Assert.assertEquals("Erreur de type", "T", sensor.getType());

    }

    @Test
    public void getStation() throws Exception {
        TSensor sensor = new TSensor("C", "10", "HONGKONG");
        Assert.assertEquals("Erreur de type", "PARIS", sensor.getStation());
    }

}