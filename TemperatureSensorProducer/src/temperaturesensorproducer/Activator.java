package temperaturesensorproducer;
import impl.TemperatureServiceImpl;
import interfaces.TemperatureService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private TemperatureService service;

	public void start(BundleContext context) throws Exception {
		service = new TemperatureServiceImpl();
		context.registerService(TemperatureService.class, service, null);
        System.out.println("✅ Temperature Sensor Service Started...");
    }
	public void stop(BundleContext context) throws Exception {
        System.out.println("❌ Temperature Sensor Service Stopped...");
    }
}
