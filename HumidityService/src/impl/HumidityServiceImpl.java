package impl;

import interfaces.HumidityService;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class HumidityServiceImpl implements HumidityService {
	private int humidityLevel;
    private int humidityThreshold = 40; // Default threshold
    private final Random random = new Random();

    public HumidityServiceImpl() {
        // Simulate humidity changes every 5 seconds
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                simulateHumidityChange();
            }
        }, 0, 5000);
    }

    private void simulateHumidityChange() {
        humidityLevel += random.nextInt(5) - 2; // Small fluctuations
        humidityLevel = Math.max(20, Math.min(80, humidityLevel)); // Keep within limits
    }

    @Override
    public int getHumidityLevel() {
        return humidityLevel;
    }

    @Override
    public void setHumidityThreshold(int threshold) {
        this.humidityThreshold = threshold;
        System.out.println("✅ Humidity threshold set to " + humidityThreshold + "%");
    }
	
}
