/**
 * Copyright (c) 2016-2017 Inria
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * - Philippe Merle <philippe.merle@inria.fr>
 * - Faiez Zalila <faiez.zalila@inria.fr>
 * - Lê Khánh Trình <trinh.le-khanh@inria.fr>
 *
 * Generated at Sun Jan 16 13:23:15 CET 2022 from platform:/resource/monitorswitch/model/monitorswitch.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package occimonitor1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
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
import javax.servlet.http.*;

import org.javabip.annotations.*;
import org.javabip.api.PortType;
import org.json.JSONObject;
import org.javabip.api.BIPActor;
import org.javabip.api.DataOut.AccessType;

// Start of user code import
		// TODO Add permanent libs
// End of user code
/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://occiware.org/monitorswitch#
 * - term: monitor
 * - title: 
 */
@Ports({
// Start of user code Ports
		// TODO Add permanent libs
// End of user code
@Port(name = "receiveRandomNumberRequest", type = PortType.spontaneous)
, @Port(name = "receiveSwitchConfirm", type = PortType.enforceable)
, @Port(name = "sendRandomNumberRequest", type = PortType.enforceable)
//, @Port(name = "addDatabase", type = PortType.enforceable)
, @Port(name = "switchServer", type = PortType.enforceable)
, @Port(name = "resetMonitor", type = PortType.spontaneous)
})
@ComponentType(initial = "MonitorInit", name = "monitorswitch.connector.Monitor")
public class MonitorConnector extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private final static String USER_AGENT = "Mozilla/5.0";
	
	
	MonitorResult randomNumberFromMonitor;
	boolean currentLimitReach = false;
	HttpServletRequest request;
	
	public MonitorConnector() {
		// TODO Auto-generated constructor stub
		request = new HttpServletRequest() {
			
			@Override
			public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
					throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public AsyncContext startAsync() throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setAttribute(String name, Object o) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeAttribute(String name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAsyncSupported() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isAsyncStarted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getServerPort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getServerName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getScheme() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RequestDispatcher getRequestDispatcher(String path) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getRemotePort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getRemoteHost() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRemoteAddr() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRealPath(String path) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public BufferedReader getReader() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getProtocol() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getParameterValues(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<String> getParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, String[]> getParameterMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<Locale> getLocales() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getLocalPort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getLocalName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLocalAddr() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ServletInputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public DispatcherType getDispatcherType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getContentLength() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<String> getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public AsyncContext getAsyncContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void logout() throws ServletException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void login(String username, String password) throws ServletException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isUserInRole(String role) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRequestedSessionIdValid() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRequestedSessionIdFromUrl() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRequestedSessionIdFromURL() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRequestedSessionIdFromCookie() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Principal getUserPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HttpSession getSession(boolean create) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HttpSession getSession() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getServletPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRequestedSessionId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public StringBuffer getRequestURL() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRequestURI() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRemoteUser() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getQueryString() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPathTranslated() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getPathInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<Part> getParts() throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Part getPart(String name) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMethod() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getIntHeader(String name) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Enumeration<String> getHeaders(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getHeader(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getDateHeader(String name) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Cookie[] getCookies() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getContextPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAuthType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	
	@Transitions({
		@Transition(name = "receiveSwitchConfirm", source = "MonitorInit", target = "SwitchReady"),
	})
	public void waitSwitchConfirm() {
		System.out.println("[Monitor] Recieved switch confirm....");
	}
	
	@Transitions({
		@Transition(name = "receiveRandomNumberRequest", source = "SwitchReady", target = "RandomNumberRequestReceived"),
	})
	public void getIntoServerAvailable(@Data(name = "randomNumberFromMonitor") MonitorResult randomNumberFromMonitor) {
		this.randomNumberFromMonitor = randomNumberFromMonitor;
		System.out.println("[Monitor] Received a random number request.... " + randomNumberFromMonitor.getHttpResponse());
	}
	
	// Send request //
	public String requestJson (String currentServer) throws IOException {
		System.out.println("[Monitor] Getting Json contain....");
//		URL obj = new URL(Switch.currentServer);
		URL obj = new URL(currentServer);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		//
		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + Switch.currentServer);
		System.out.println("\nSending 'GET' request to URL : " + currentServer);
		System.out.println("Response Code : " + responseCode);
		//
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		//
		while ((inputLine = in.readLine()) != null) {
//			System.out.println("[Monitor-requestJSON]: " + inputLine);
			content.append(inputLine);
		}
		in.close();
		//
		return content.toString();
	}
	
	
	

	@Transitions({
//		@Transition(name = "sendRandomNumberRequest", source = "RandomNumberRequestReceived", target = "SwitchReady", guard = "!limitIsReached"),
		@Transition(name = "sendRandomNumberRequest", source = "RandomNumberRequestReceived", target = "SwitchReady", guard = "!limitIsReached"),
	})
//	public void receiveRandomNumberRequest(@Data(name = "data") MonitorResult data) throws IOException {
//		System.out.println("[Monitor] Getting a random number....@" + Switch.currentServer);
//		// TODO Auto-generated method stub
//		String re = requestJson(Switch.currentServer);
//		data.setHttpResponse(re);
//	}
	public void receiveRandomNumberRequest() throws IOException {
		System.out.println("[Monitor] Getting a random number....@" + SwitchConnector.currentServer);
		// TODO Auto-generated method stub
		String re = requestJson(SwitchConnector.currentServer);
		System.out.println("[Monitor] Check current server: " + SwitchConnector.currentServer);
		randomNumberFromMonitor.setHttpResponse(re);
	}

	

	
	@Transitions({
//		@Transition(name = "switchServer", source = "ServerChecking", target = "ServerSwitched",  guard = "needToChooseServer"),
		@Transition(name = "switchServer", source = "RandomNumberRequestReceived", target = "SwitchReady",  guard = "limitIsReached"),
	})
//		public void switchConfirm (@Data(name = "newServer") String newServer) {
	public void switchServer () throws IOException  {
		System.out.println("[Monitor] switch server (....)");
		
		System.out.println("[Monitor] add Database to server (....)");
		String content = requestJson(SwitchConnector.currentServer);
		JSONObject jsonObj = new JSONObject(content);
		String server = jsonObj.optString("server");
		String baseUrl = server.substring(0, server.lastIndexOf("/")) + "/BIPDeployerOCCI" + "?req=add&addon=heroku-postgresql";
		
	    System.out.println("[Monitor-addDB] Check URL: " + baseUrl);
	    URL url;
		try {
			url = new URL(baseUrl);
			System.out.println("[Monitor] Check URL: " + baseUrl);
			URLConnection urlconnect = url.openConnection();
			InputStream stream = urlconnect.getInputStream();
			if (request == null) {
				System.out.println("Request NULL");
			}
			request.setAttribute("noti", "Heroku Postgres Database has been created and is available");
//			jsonObj.put("counter", 0);
//			HttpServletRequest request = (HttpServletRequest) new MonitorConnector();
			request.setAttribute("counter", 0);
//			request.setAttribute("noti", "Heroku Postgres Database has been created and is available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

	// Request limit info	
	@Guard(name = "limitIsReached")
	public boolean limitIsReached () throws IOException {
		System.out.println("[Monitor] Checking if the limit is reached....");
		String content = requestLimitInfo(SwitchConnector.currentServer);
		System.out.println("[Monitor-limitIsReach] content: " + content);
		//Json
		JSONObject jsonObj = new JSONObject(content);
		
		int counter = jsonObj.getInt("counter");
	    int limit = jsonObj.getInt("requestLimit");
	    System.out.println("[Monitor-limitIsReach] values: " + counter + "/" + limit);
	    if (counter == limit ) {
	    	System.out.println("[Monitor] The limit has been reached....");
//	    	currentLimitReach = true;
	    	return true;
    	} else {
    		System.out.println("[Monitor] The limit has not been reached....");
//    		currentLimitReach = false;
    		return false;
		}
//	    return currentLimitReach;
	}

//	@Transitions({
//		@Transition(name = "addDatabase", source = "RandomNumberRequestReceived", target = "SwitchReady",  guard = "canAdd"),
//	})
//	public void addDatabase (HttpServletRequest request)  {
//		System.out.println("[Monitor] add Database to server (....)");
//		String scheme = request.getScheme() + "://";
//	    String serverName = request.getServerName();
//	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
//	    String contextPath = request.getContextPath();
//	    String baseUrl = scheme + serverName + serverPort + contextPath + "/BIPDeployerOCCI" + "?req=add&addon=heroku-postgresql";
//	    System.out.println("[Monitor-addDB] Check URL: " + baseUrl);
//	    URL url;
//		try {
//			url = new URL(baseUrl);
//			System.out.println("[Monitor] Check URL: " + baseUrl);
//			URLConnection urlconnect = url.openConnection();
//			InputStream stream = urlconnect.getInputStream();
//			request.setAttribute("noti", "Heroku Postgres Database has been created and is available");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//	}
//	
//	@Guard(name = "canAdd")
//	public boolean canAdd() throws IOException {
//		System.out.println("[Monitor] Checking if it is possible to add DB....");
//		String content = requestJson(SwitchConnector.currentServer);
//		System.out.println("[Monitor-canAdd] content: " + content);
//		//Json
//		JSONObject jsonObj = new JSONObject(content);
//		System.out.println("[Monitor-canAdd] check before calling randomNumber");
//		try {
//			int randomNumber = jsonObj.getInt("randomNumber");
//		    System.out.println("[Monitor-canAdd] randomNumber = " + randomNumber);
//		    if (randomNumber < 70) {
//		    	System.out.println("[Monitor] The condition is satisfied to add new DB addon....");
//		    	return true;
//	    	} else {
//	    		System.out.println("[Monitor] The condition is NOT satisfied to add new DB addon....");
//	    		return false;
//			}
//		}catch(Exception e) {
//			System.out.println("[Monitor-canAdd] cannot call randomNumber");
//			return false;
//		}
//	    
//
//	}
	
	public String requestLimitInfo (String currentServer) throws IOException {
		System.out.println("[Monitor] Getting limit info....");
		String requestLimitInfoURL = currentServer.concat("?req=checkLimit");
		System.out.println("[Monitor] URL (" + requestLimitInfoURL + ") \n \n");
		String content = requestJson(requestLimitInfoURL);
		System.out.println("[Monitor] limit info (" + content + ") \n \n");
		return content.toString();
	}
	
	@Transitions({
		@Transition(name = "resetMonitor", source = "SwitchReady", target = "MonitorInit"),
	})
	public void resetMonitor () {
		System.out.println("[Monitor] Reset the Monitor (SwitchReady --> MonitorInit)");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());

		if (!parameterNames.isEmpty()) {
			String firstParam = parameterNames.get(0);
			String firstValue = request.getParameter(firstParam);
		} else {
			
		}
	}
}	
