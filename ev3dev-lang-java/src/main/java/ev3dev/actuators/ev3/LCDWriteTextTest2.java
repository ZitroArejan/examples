package example.robotics.ev3.actuator;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LCDWriteTextTest2 {

    public static Logger LOGGER = LoggerFactory.getLogger(LCDWriteTextTest2.class);

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(final String[] args) {

        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        LOGGER.info("EV3 LCD Example");

        clear();
        writeMessage("Juanito");
        Delay.msDelay(5000);
        clear();
        writeMessage("Jorgito");
        Delay.msDelay(5000);
        clear();
        writeMessage("Pablito");
        Delay.msDelay(5000);
    }


    public static void writeMessage(final String message){
        //lcd.setColor(Color.BLACK);
        lcd.setColor(0,0,0);
        lcd.drawString(message, 50,50, 0, true);
        lcd.refresh();
    }

    public static void clear(){
        //lcd.setColor(Color.WHITE);
        lcd.setColor(255,255,255);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());

    }
}
