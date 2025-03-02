package greenhousecontroller;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import interfaces.HumidityService;
import interfaces.SoilMoistureService;
import interfaces.TemperatureService;

import java.util.Scanner;

public class Activator implements BundleActivator {
	private ServiceReference temperatureRef, humidityRef, soilMoistureRef;
	private TemperatureService temperatureService;
	private HumidityService humidityService;
	private SoilMoistureService soilMoistureService;
	
	
	private int tempThreshold = 30;
	private int humidityThreshold = 40;
	private int moistureThreshold = 50;
	
	private boolean running = true;
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public void start(BundleContext context) throws Exception {
        System.out.println("Greenhouse Controller Starting...");
        
        // Get reference for producer service
        temperatureRef = context.getServiceReference(TemperatureService.class.getName());
        humidityRef = context.getServiceReference(HumidityService.class.getName());
        soilMoistureRef = context.getServiceReference(SoilMoistureService.class.getName());
        
        temperatureService = (TemperatureService) context.getService(temperatureRef);
        humidityService = (HumidityService) context.getService(humidityRef);
        soilMoistureService = (SoilMoistureService) context.getService(soilMoistureRef);

        // Start user interaction menu
        runMenu();
	}
	private void runMenu() {
        while (running) {
            System.out.println("\n🌱 Greenhouse Monitoring System 🌱");
            System.out.println("1. View Sensor Data");
            System.out.println("2. Customize Sensor Settings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    viewSensorData();
                    break;
                case 2:
                    customizeSettings();
                    break;
                case 3:
                    running = false;
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
	private void viewSensorData() {
		int temp = temperatureService.getTemperature();
		int humidity = humidityService.getHumidityLevel();
        int moisture = soilMoistureService.getMoistureLevel();

        System.out.println("\n🌡 Current Sensor Readings:");
        System.out.println("Temperature: " + temp + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Soil Moisture: " + moisture + "%");
        
        // Check thresholds and active systems
        if (temp > tempThreshold) {
            System.out.println("🔥 Cooling ON (Temperature exceeds " + tempThreshold + "°C)");
        }
        if (humidity < humidityThreshold){
            System.out.println("💧 Humidifier ON (Humidity below " + humidityThreshold + "%)");
        }
        if (moisture < moistureThreshold) {
            System.out.println("🚿 Irrigation ON (Moisture below " + moistureThreshold + "%)");
        }
	}
	
	private void customizeSettings() {
		System.out.println("\n⚙ Customize Sensor Settings:");
        System.out.println("1. Set Temperature Threshold");
        System.out.println("2. Set Humidity Threshold");
        System.out.println("3. Set Soil Moisture Threshold");
        System.out.println("4. Back to Main Menu");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch(choice) {
        case 1:
        	System.out.println("Enter new temperature threshold : ");
        	 tempThreshold = scanner.nextInt();
             System.out.println("✅ Temperature threshold set to " + tempThreshold + "°C");
             break;
         case 2:
             System.out.print("Enter new humidity threshold: ");
             humidityThreshold = scanner.nextInt();
             System.out.println("✅ Humidity threshold set to " + humidityThreshold + "%");
             break;
         case 3:
             System.out.print("Enter new soil moisture threshold: ");
             moistureThreshold = scanner.nextInt();
             System.out.println("✅ Soil moisture threshold set to " + moistureThreshold + "%");
             break;
         case 4:
             return;  // Go back to main menu
         default:
             System.out.println("Invalid choice! Returning to menu...");
        }
	}


	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Greenhouse Controller Stopping...");
        scanner.close();
        context.ungetService(temperatureRef);
        context.ungetService(humidityRef);
        context.ungetService(soilMoistureRef);
    }
}
