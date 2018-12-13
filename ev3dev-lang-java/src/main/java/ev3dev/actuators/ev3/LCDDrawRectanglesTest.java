package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LCDDrawRectanglesTest {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDArcDemo.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(final String[] args) {

        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        LOGGER.info("EV3 LCD Example");

        clear();
        //lcd.setColor(Color.BLACK);
        lcd.setColor(0,0,0);
        lcd.drawRect(0, 0, 20, 20);
        lcd.drawRect(40, 40, 20, 20);

        lcd.drawRoundRect(80 , 80, 40, 40, 10,5);

        lcd.refresh();

        Delay.msDelay(5000);
    }


    public static void clear(){
        //lcd.setColor(Color.WHITE);
        lcd.setColor(255,255,255);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
    }

}
