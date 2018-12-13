package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class LCDArcDemo {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDArcDemo.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(String[] args) {

        final int height = lcd.getHeight();
        final int width = lcd.getWidth();

        LOGGER.info("Display dimensions: W:{} H:{}", width , height);

        LOGGER.info("{}", lcd.getStrokeStyle());

        lcd.setColor(Color.BLACK);

        long range = 10;

        lcd.setColor(Color.BLACK);
        lcd.drawArc( (int)(50-range), (int)(50-range), (int)range*2, (int)range*2, 0, 360);

        lcd.fillArc(80,80, 20, 20, 0, 360);

        lcd.refresh();

        LOGGER.info("Wait");
        Delay.msDelay(10000);
    }

    private static int getRandom(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
