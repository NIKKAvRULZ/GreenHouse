package impl;

import interfaces.SoilMoistureService;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SoilMoistureServiceImpl implements SoilMoistureService {

	private int moistureLevel = 50; // Default starting value
	private int moistureThreshold = 30;
	private final Random random = new Random();
	
	public SoilMoistureServiceImpl() {
        // Simulate soil moisture changes every 5 seconds
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                simulateMoistureChange();
            }
        }, 0, 5000);
    }

    private void simulateMoistureChange() {
        moistureLevel += random.nextInt(6) - 3; // Gradual changes
        moistureLevel = Math.max(10, Math.min(90, moistureLevel)); // Keep within 10-90%
    }

	
	@Override
    public int getMoistureLevel() {
        return moistureLevel;
    }
	@Override
	public void setMoistureThreshold(int threshold) {
		this.moistureThreshold = threshold;
        System.out.println("✅ Soil moisture threshold set to " + moistureThreshold + "%");
		
	}

}
