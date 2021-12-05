package su.nsk.iae.post;

import com.google.inject.Injector;

public class PoSTStandaloneSetup extends PoSTStandaloneSetupGenerated {

private static PoSTStandaloneSetup INSTANCE;
	
	public static Injector getInjector() {
		if (INSTANCE == null) {
			INSTANCE = new PoSTStandaloneSetup();
		}
		return INSTANCE.createInjectorAndDoEMFRegistration();
	}
}
