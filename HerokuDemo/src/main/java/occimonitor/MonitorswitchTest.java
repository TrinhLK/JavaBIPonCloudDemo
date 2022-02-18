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
 * - Lê Khánh Trình <trinh.le-khanh@inria.fr>
 *
 * Generated at Sun Jan 16 13:23:15 CET 2022 from platform:/resource/monitorswitch/model/monitorswitch.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package occimonitor;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.servlet.*;
import javax.servlet.http.*;

import org.javabip.api.BIPActor;
import org.javabip.api.BIPEngine;
import org.javabip.api.BIPGlue;
import org.javabip.engine.factory.EngineFactory;
import org.json.JSONObject;

import akka.actor.ActorSystem;

import org.apache.log4j.BasicConfigurator;
public class MonitorswitchTest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
//	static Logger log = LoggerFactory.getLogger(MonitorswitchTest.class);
	String notification = "";
	ActorSystem system;
	EngineFactory engineFactory;
	BIPGlue bipGlue;
	BIPEngine engine;
	MonitorswitchTest bipMoni;
	// BIP Components
//	MonitorConnector moni;
	MonitorConnector_3 moni_3;
//	MonitorConnector moni;
//	MonitorConnector moni;
//	MonitorConnector moni;
	
	SwitchConnector sw;
	HerokuControlConnector controller;
	// BIP Actors
//	BIPActor moniActor;
	BIPActor moniActor_3;
//	BIPActor moniActor;
//	BIPActor moniActor;
//	BIPActor moniActor;
	
	BIPActor swActor;
	BIPActor controllerActor;
	

//	static String moniRespone = "lalala";

//	@Before
	public void initialize() {

		system = ActorSystem.create("MySystem");
		engineFactory = new EngineFactory(system);
	}

	// Use terminate method instead
	// @After
	public void cleanup() {
//		system.shutdown();
	}

	public void init() throws ServletException {
		BasicConfigurator.configure();
//		log.info("This is Logger Info");

		System.out.println("----------");
		System.out.println("---------- JavaBIP Initializing ----------");

		bipMoni = new MonitorswitchTest();
		bipMoni.initialize();
		
		bipGlue = new GlueBuilder_Specification().build();
//		bipGlue = new GlueBuilder() {
//			@Override
//			public void configure() {
////				// Sync
////				// Monitor
////				port(SwitchConnector.class, "switchServer").requires(MonitorConnector.class, "switchServer");
////				port(MonitorConnector.class, "switchServer").requires(SwitchConnector.class, "switchServer");
////
////				port(MonitorConnector.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
////				port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector.class, "receiveSwitchConfirm");
////				
////				port(SwitchConnector.class, "switchServer").accepts(MonitorConnector.class, "switchServer");
////				port(MonitorConnector.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
////
////				port(MonitorConnector.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
////				port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector.class, "receiveSwitchConfirm");
////				// Data
//
//				// Sync
//				// Monitor_3
//				port(SwitchConnector.class, "switchServer").requires(MonitorConnector_3.class, "switchServer");
//				port(MonitorConnector_3.class, "switchServer").requires(SwitchConnector.class, "switchServer");
//
//				port(MonitorConnector_3.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
//				port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector_3.class, "receiveSwitchConfirm");
//				
//				port(SwitchConnector.class, "switchServer").accepts(MonitorConnector_3.class, "switchServer");
//				port(MonitorConnector_3.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
//
//				port(MonitorConnector_3.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//				port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector_3.class, "receiveSwitchConfirm");
//			}
//		}.build();

		engine = bipMoni.engineFactory.create("myEngine", bipGlue);

//		moni = new MonitorConnector();
		moni_3 = new MonitorConnector_3();
		
		sw = new SwitchConnector();
		controller = new HerokuControlConnector();
		
//		moniActor = engine.register(moni, "Monitor", true);
		moniActor_3 = engine.register(moni_3, "Monitor_3", true);
		swActor = engine.register(sw, "Switch", true);
		controllerActor = engine.register(controller, "HerokuController", true);
		
		engine.start();
		engine.execute();

//  		try {
//			TimeUnit.SECONDS.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		engine.stop();
//		bipMoni.engineFactory.destroy(engine);
//		bipMoni.cleanup(); 	

		System.out.println("---------- JavaBIP Initialized successfully ----------");
		System.out.println("----------");
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
	}

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[Java BIP] Receiving a request");

		// Get Json from client
		String req = request.getParameter("req");
		String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
		String content = "";
		if ("user".equals(req)) {

			PrintWriter out = response.getWriter();
			if (!SwitchConnector.currentServer.isEmpty()) {

				System.out.println("[BIP] Compute Button is pressed");
//				moniActor.inform("receiveRandomNumberRequest");
				moniActor_3.inform("receiveRandomNumberRequest");

				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				MonitorResult re = new MonitorResult("");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("data", re);
//				moniActor.inform("sendRandomNumberRequest", data);
				moniActor_3.inform("sendRandomNumberRequest", data);

				while (re.getHttpResponse() == "") {
					System.out.println("Check whether the response is empty: ");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (re.getHttpResponse() != "") {
						System.out.println("The response is not empty: " + re.getHttpResponse());
						break;
					}
				}
				
				content = re.getHttpResponse();
				System.out.print(content);
//				//Json
//				JSONObject jsonObj = new JSONObject(content);
			}
			out.println(content);
			out.flush();
		} else { //// buttons handling

			// Add server ////////////////////////////////////////////////////////////
			String addServerButton = request.getParameter("add");
			if (addServerButton != null) {
				System.out.println("[BIP] Add server button is pressed");
				MonitorResult re = new MonitorResult("");
				String serverAddress = request.getParameter("serverAddress");
				re.setHttpResponse(serverAddress);
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("address", re);
				swActor.inform("addServer", data);
//				request = setAttributesFromSessionUI(request);

				// This is used for waiting the result - find another better way
				while (re.getHttpResponse() != "") {
//					System.out.println("The respone is not empty");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (re.getHttpResponse() == "") {
						System.out.println("[BIP] Adding server is done, break!");
						break;
					}
				}
				request = setAttributesFromSessionUI(request);

			}
			//////////////////////////////////////////////////////////////////////////

			// Remove servers ////////////////////////////////////////////////////////
			String removeServersButton = request.getParameter("remove");
			if (removeServersButton != null) {
				System.out.println("[BIP] Remove all servers button is pressed");
				MonitorResult re = new MonitorResult("processing...");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("flag", re);
				swActor.inform("removeAllServers", data);
//				request = setAttributesFromSessionUI(request);

				// This is used for waiting the result - find another better way
				while (re.getHttpResponse() != "") {
//					System.out.println("The respone is not empty");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (re.getHttpResponse() == "") {
						System.out.println("[BIP] Removing all servers is done, break!");
						break;
					}
				}
				request = setAttributesFromSessionUI(request);
			}
			//////////////////////////////////////////////////////////////////////////

			// Choose servers ////////////////////////////////////////////////////////
			String chooseServersButton = request.getParameter("chooseServer");
			if (chooseServersButton != null) {
				System.out.println("[BIP] Choose server button is pressed");
				Map<String, Object> data = new HashMap<String, Object>();
//				String serverAddress = request.getParameter("serverAddress");
				String serverAddress = request.getParameter("addedServer");
				MonitorResult re = new MonitorResult(serverAddress);
				re.setHttpResponse(serverAddress);
				data.put("serverAddress", re);
				swActor.inform("chooseServer", data);
//				request = setAttributesFromSessionUI(request);

				// This is used for waiting the result - find another better way
				while (re.getHttpResponse() != "") {
//								System.out.println("The respone is not empty");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (re.getHttpResponse() == "") {
						System.out.println("[BIP] Choosing a server is done, break!");
						break;
					}
				}
				request = setAttributesFromSessionUI(request);
			}
			//////////////////////////////////////////////////////////////////////////

			// Switch confirms ////////////////////////////////////////////////////////
//			String switchConfirmButton = request.getParameter("switchConfirm");
//			if (switchConfirmButton != null) {
//				System.out.println("[BIP] Switch confirm button is pressed");
//				MonitorResult re = new MonitorResult("processing...");
//				Map<String, Object> data = new HashMap<>();
//				data.put("flag", re);
//				swActor.inform("switchConfirm", data);
////				request = setAttributesFromSessionUI(request);
//				
//				// This is used for waiting the result - find another better way
//				while (re.getHttpResponse() != "") {
////					System.out.println("The respone is not empty");
//					try {
//						TimeUnit.SECONDS.sleep(1);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					if (re.getHttpResponse() == "") {
//						System.out.println("[BIP] Switch confirmed, break!");
//						break;
//					}
//				}
//				request = setAttributesFromSessionUI(request);
//			}
			//////////////////////////////////////////////////////////////////////////

			// Testing
			// Compute ///////////////////////////////////////////////////////////////
			String compute = request.getParameter("compute");
			if (compute != null) {
				System.out.println("[BIP] Compute Button is pressed");
				// Initialize a Result for sendRandomNumberRequest transition
				MonitorResult randomNumberFromMonitor = new MonitorResult("");
				Map<String, Object> BIPMonitorResult = new HashMap<String, Object>();
				BIPMonitorResult.put("randomNumberFromMonitor", randomNumberFromMonitor);

//				moniActor.inform("receiveRandomNumberRequest", BIPMonitorResult);
				moniActor_3.inform("receiveRandomNumberRequest", BIPMonitorResult);

//				try {
//					TimeUnit.SECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

//				MonitorResult re = new MonitorResult("");
//				Map<String, Object> data = new HashMap<String, Object>();
//				data.put("data", re);
//				moniActor.inform("sendRandomNumberRequest");
//				moniActor_3.inform("sendRandomNumberRequest");

				while (randomNumberFromMonitor.getHttpResponse() == "") {
					// System.out.println("The respone is not empty");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (randomNumberFromMonitor.getHttpResponse() != "") {
						content = randomNumberFromMonitor.getHttpResponse();
						System.out.println("abcd" + content);
//						//Json
						JSONObject jsonObj = new JSONObject(content);
						request = setAttributesUI(request, jsonObj);
						break;
					}
				}

				System.out.print("End!!!!");
			}
			//////////////////////////////////////////////////////////////////////////

			// Save the computed number
			// ////////////////////////////////////////////////////////////
			String save = request.getParameter("save");
			if (save != null) {
				System.out.println("[BIP] Save Button is pressed");
				
			    String baseUrl = scheme + serverName + serverPort + contextPath + "/BIPDeployerOCCI" + "?req=add&addon=heroku-postgresql";
			    System.out.println("Run URL: " + baseUrl);
			    URL url = new URL(baseUrl);
			    URLConnection urlconnect = url.openConnection();
			    notification = "Heroku Postgres Database has been created and is available";
			    request.setAttribute("noti", notification);
	            InputStream stream
	                = urlconnect.getInputStream();
	            
				System.out.print("End!!!!\n");
			}
			
			//////////////////////////////////////////////////////////////////////////

			// Reset server counter
			// ////////////////////////////////////////////////////////////
			String resetServerButton = request.getParameter("resetServerCounter");
			if (resetServerButton != null) {
				System.out.println("[BIP] Reset server button is pressed");
				String serverAddress = request.getParameter("resetServerlist").concat("?req=reset");
//				serverAddress.concat("?req=resset");
				MonitorConnector moni = new MonitorConnector();
				moni.requestJson(serverAddress);
				request = setAttributesFromSessionUI(request);
			}
			//////////////////////////////////////////////////////////////////////////

			// Reset components
			// ////////////////////////////////////////////////////////////
			String resetAllButton = request.getParameter("resetComponents");
			if (resetAllButton != null) {
				System.out.println("[BIP] Reset components button is pressed");
//				moniActor.inform("resetMonitor");
				moniActor_3.inform("resetMonitor");
				swActor.inform("resetSwitch");
			
//				swActor.
				request = setAttributesFromSessionUI(request);
			}
			//////////////////////////////////////////////////////////////////////////

			RequestDispatcher rd = request.getRequestDispatcher("/monitor-switch-index.jsp");
			rd.include(request, response);
		}

	};

	protected HttpServletRequest setAttributesFromSessionUI(HttpServletRequest request) {
		String id = (String) request.getSession().getAttribute("id");
		String randomNumber = (String) request.getSession().getAttribute("randomNumber");
		String counter = (String) request.getSession().getAttribute("counter");
		String limit = (String) request.getSession().getAttribute("limit");
		String server = (String) request.getSession().getAttribute("server");
		//
		request.setAttribute("id", id);
		request.setAttribute("randomNumber", randomNumber);
		request.setAttribute("counter", counter);
		request.setAttribute("limit", limit);
		request.setAttribute("server", server);
		//
		request.setAttribute("currentServer", SwitchConnector.currentServer);
		request.setAttribute("noti", notification);
		//
		return request;
	}

	protected HttpServletRequest setAttributesUI(HttpServletRequest request, JSONObject jsonObj) {
		int id = jsonObj.getInt("id");
		int randomNumber = jsonObj.getInt("randomNumber");
		int counter = jsonObj.getInt("counter");
		int limit = jsonObj.getInt("requestLimit");
		String server = jsonObj.getString("server");
		//
		request.setAttribute("id", id);
		request.setAttribute("randomNumber", randomNumber);
		request.setAttribute("counter", counter);
		request.setAttribute("limit", limit);
		request.setAttribute("server", server);
		//
		request.setAttribute("currentServer", SwitchConnector.currentServer);
		//
		request.setAttribute("noti", notification);
		
		return request;
	}
}

