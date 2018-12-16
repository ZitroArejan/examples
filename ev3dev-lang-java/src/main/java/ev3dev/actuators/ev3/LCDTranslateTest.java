package example.programming;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LCDTranslateTest {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDTranslateTest.class);

    public static void main(final String[] args) {


        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        LOGGER.info("EV3 LCD Example");

        GraphicsLCD lcd = LCD.getInstance();

        lcd.clear();
        lcd.setColor(Color.BLACK);
        lcd.drawLine(0, 100, 50, 100);
        lcd.drawLine(50, 100, 50, 0);
        lcd.refresh();

        LOGGER.info("Translate {} {} ", lcd.getTranslateX(), lcd.getTranslateY());

        lcd.translate(50, 100);

        LOGGER.info("Translate {} {} ", lcd.getTranslateX(), lcd.getTranslateY());

        lcd.drawLine(0, 0, 50, 50);

        lcd.refresh();

        Delay.msDelay(5000);
    }
}
