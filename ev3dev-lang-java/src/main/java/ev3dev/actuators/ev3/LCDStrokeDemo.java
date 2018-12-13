package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class LCDStrokeDemo {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDStrokeDemo.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(String[] args) {

        final int height = lcd.getHeight();
        final int width = lcd.getWidth();

        LOGGER.info("Display dimensions: W:{} H:{}", width , height);

        LOGGER.info("{}", lcd.getStrokeStyle());

        lcd.setColor(Color.BLACK);
        lcd.setStrokeStyle(GraphicsLCD.DOTTED);

        LOGGER.info("{}", lcd.getStrokeStyle());

        lcd.drawRect(10,10, 100, 100);

        lcd.setStrokeStyle(GraphicsLCD.SOLID);
        lcd.drawRect(50,50, 60, 60);
        lcd.refresh();

        LOGGER.info("Wait");
        Delay.msDelay(10000);
    }

    private static int getRandom(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
