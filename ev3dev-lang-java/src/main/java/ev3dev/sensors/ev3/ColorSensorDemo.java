package examples.sensors.ev3;

import ev3dev.sensors.ev3.EV3ColorSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ColorSensorDemo {

	//Robot Configuration
	private static EV3ColorSensor color1 = new EV3ColorSensor(SensorPort.S1);
	
	//Configuration
	private static int HALF_SECOND = 500;
	
	public static void main(String[] args) {

		//Red Mode
		LOGGER.info("Switching to Red Mode");
		SampleProvider sp = color1.getRedMode();
		
		int sampleSize = sp.sampleSize();
		float[] sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
        	sp.fetchSample(sample, 0);
			LOGGER.info("N=" + i + " Sample=" +  (int)sample[0]);
            
            Delay.msDelay(HALF_SECOND);
        }

        //Color ID
		LOGGER.info("Switching to Color ID Mode");
		sp = color1.getColorIDMode();
		
		sampleSize = sp.sampleSize();
		sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
        	sp.fetchSample(sample, 0);
			LOGGER.info("N=" + i + " Sample={}" +  (int)sample[0]);
            
            Delay.msDelay(HALF_SECOND);
        }

        //Ambient Mode
		LOGGER.info("Switching to Ambient Mode");
		sp = color1.getAmbientMode();
		
		sampleSize = sp.sampleSize();
		sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
        	sp.fetchSample(sample, 0);
			LOGGER.info("N=" + i + " Sample={}" +  (int)sample[0]);

            Delay.msDelay(HALF_SECOND);
        }
		
		//RGB
		LOGGER.info("Switching to RGB Mode");
		sp = color1.getRGBMode();
		
		sampleSize = sp.sampleSize();
		sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
        	sp.fetchSample(sample, 0);
			LOGGER.info("N=" + i + " Sample={}" + (int)sample[0]);
			LOGGER.info("N=" + i + " Sample={}" + (int)sample[1]);
			LOGGER.info("N=" + i + " Sample={}" + (int)sample[2]);

            Delay.msDelay(HALF_SECOND);
        }

	}

}
