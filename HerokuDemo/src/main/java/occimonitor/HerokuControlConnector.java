package occimonitor;

import org.javabip.annotations.ComponentType;
import org.javabip.annotations.Port;
import org.javabip.annotations.Ports;
import org.javabip.api.PortType;

@Ports({
	// Start of user code Ports
			// TODO Add permanent libs
	// End of user code
	@Port(name = "addDatabase", type = PortType.enforceable)
	})
@ComponentType(initial = "Init", name = "monitorswitch.connector.HerokuController")
public class HerokuControlConnector {

	private static final long serialVersionUID = 1L;
	private final static String USER_AGENT = "Mozilla/5.0";
	
	
}
