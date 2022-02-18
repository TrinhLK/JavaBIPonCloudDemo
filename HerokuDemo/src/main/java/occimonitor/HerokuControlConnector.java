package occimonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.javabip.annotations.ComponentType;
import org.javabip.annotations.Data;
import org.javabip.annotations.Guard;
import org.javabip.annotations.Port;
import org.javabip.annotations.Ports;
import org.javabip.annotations.Transition;
import org.javabip.annotations.Transitions;
import org.javabip.api.PortType;
import org.json.JSONObject;

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
//	HttpServletRequest request;
	boolean hasDatabases;
	
	public HerokuControlConnector() {
		
	}
	
	@Transitions({
		@Transition(name = "addDatabase", source = "Init", target = "Init",  guard = "canAdd"),
	})
	public void addDatabase(@Data(name = "currentRequest") String currentReq) {
		System.out.println("\n\n[HerokuControl] add Database to server (....)");
		JSONObject jsonObj = new JSONObject(currentReq);
		String server = jsonObj.optString("server");
		String baseUrl = server.substring(0, server.lastIndexOf("/")) + "/BIPDeployerOCCI" + "?req=add&addon=heroku-postgresql";
		
	    System.out.println("\n\n[HerokuControl] Check URL: " + baseUrl);
	    URL url;
		try {
			url = new URL(baseUrl);
			System.out.println("[HerokuControl] Check URL: " + baseUrl);
			URLConnection urlconnect = url.openConnection();
			InputStream stream = urlconnect.getInputStream();
			hasDatabases = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Guard(name = "canAdd")
	public boolean canAdd() throws IOException {
		System.out.println("[HerokuControl] Checking if it is possible to add DB....");
		if (hasDatabases) {
			return false;
		}

		return true;
	}
	
}
