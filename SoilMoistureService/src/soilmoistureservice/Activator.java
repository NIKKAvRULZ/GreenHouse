package soilmoistureservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import impl.SoilMoistureServiceImpl;
import interfaces.SoilMoistureService;

public class Activator implements BundleActivator {

    private SoilMoistureService service;

    @Override
    public void start(BundleContext context) throws Exception {
        service = new SoilMoistureServiceImpl();
        context.registerService(SoilMoistureService.class.getName(), service, null);
        System.out.println("✅ Soil Moisture Service Started...");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("❌ Soil Moisture Service Stopped...");
    }
}
