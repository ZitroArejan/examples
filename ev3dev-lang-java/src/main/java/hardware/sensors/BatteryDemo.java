package hardware.sensors;

import ev3dev.hardware.sensors.Battery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatteryDemo {

	public static void main(String[] args) {
        final Battery battery = Battery.getInstance();
		log.info("Battery Voltage: {}", battery.getVoltage());
        log.info("Battery Current: {}", battery.getBatteryCurrent());
	}

}
