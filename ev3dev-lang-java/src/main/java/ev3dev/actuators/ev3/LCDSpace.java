package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class LCDSpace {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDSpace.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(String[] args) {

        final int height = lcd.getHeight();
        final int width = lcd.getWidth();

        LOGGER.info("Display dimensions: W:{} H:{}", width , height);

        int previous = lcd.getPixel(0,0);
        if(previous == 0) {
            LOGGER.info("OK");
        }
        lcd.setPixel(0, 0, Color.BLACK);
        lcd.refresh();
        previous = lcd.getPixel(0,0);
        if(previous == 1) {
            LOGGER.info("OK");
        }

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int flag = getRandom(0, 1);
                if(flag == 1) {
                    lcd.setPixel(x, y, Color.BLACK);
                }
            }
            lcd.refresh();
        }

        LOGGER.info("Wait");
        Delay.msDelay(10000);
    }

    private static int getRandom(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
