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
package occimonitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import javax.servlet.http.HttpServlet;

import org.javabip.annotations.*;
import org.javabip.api.PortType;
import org.javabip.api.BIPActor;
import org.javabip.api.DataOut.AccessType;

// Start of user code import
		// TODO Add permanent libs
// End of user code
/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://occiware.org/monitorswitch#
 * - term: switch
 * - title: 
 */
@Ports({
// Start of user code Ports
		// TODO Add permanent libs
// End of user code
@Port(name = "chooseServer", type = PortType.spontaneous)
, @Port(name = "switchServer", type = PortType.enforceable)
, @Port(name = "removeAllServer", type = PortType.spontaneous)
, @Port(name = "switchConfirm", type = PortType.enforceable)
, @Port(name = "addServer", type = PortType.spontaneous)
, @Port(name = "resetSwitch", type = PortType.spontaneous)
})
@ComponentType(initial = "SwitchInit", name = "monitorswitch.connector.Switch")
public class SwitchConnector 
{
	/**
	 * Initialize the logger.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(SwitchConnector.class);
	//MonitorswitchSingleton instance = MonitorswitchSingleton.getInstance();
	// Start of user code variables
	public static List<String> serverslist = new ArrayList<String>();
	static String currentServer = "";
	static String previousServer = "";
	int serverIndex = 0;
	// End of user code

	// Start of user code Switchconnector_constructor
	/**
	 * Constructs a switch connector.
	 */
	SwitchConnector()
	{
		//final BIPActor executor = instance.engine.register(this, getTitle(), true);
		LOGGER.debug("Constructor called on " + this);
		// TODO: Implement this constructor.
	}
	// End of user code

	
	/**
	 * Implement OCCI action:
	 * - name: chooseServer
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: chooseserver
     * - title: 
	 */
	@Transitions({
		@Transition(name = "chooseServer", source = "SwitchReady", target = "SwitchReady", guard = "canChooseServer"),
	})
	//@Override
	//Start of user code chooseServer
	public void chooseServer(@Data(name = "serverAddress") MonitorResult serverAddress)
	{
		System.out.println("[SWITCH] Choosing a server....");
		if (serverslist.isEmpty()) {
			System.out.println("[SWITCH] No server registered");
		}
		else
		{
			System.out.println("[SWITCH] Choose server (" + serverAddress.getHttpResponse() + ")");
			serverIndex = serverslist.indexOf(serverAddress.getHttpResponse());
			previousServer = currentServer;
			currentServer = serverslist.get(serverIndex).toString();
		}
//		System.out.println("[SWITCH] Server chose");
		System.out.println("[SWITCH] Server's chosen: SwitchReady --> SwitchReady");
		serverAddress.setHttpResponse("");
	}
	//End of user code
	
	//Start of user code canChooseServer
	@Guard(name = "canChooseServer")
	public boolean canChooseServer(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: switchServer
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: switchserver
     * - title: 
	 */
	@Transitions({
		@Transition(name = "switchServer", source = "ServerReady", target = "ServerReady", guard = "canSwitchServer"),
	})
	//@Override
	//Start of user code switchServer
	public void switchServer()
	{
		System.out.println("[SWITCH] Switching to another server....");
		if (serverslist.isEmpty()) {
			System.out.println("[SWITCH] No server registered");
		}
		else
		{
			if ( serverslist.size() > serverIndex + 1 ) {
				serverIndex = serverIndex + 1;
				previousServer = currentServer;
				currentServer = serverslist.get(serverIndex).toString();
				System.out.println("[SWITCH] Switching to another server (" + currentServer + ")");
			} else {
				serverIndex = 0;
				previousServer = currentServer;
				currentServer = serverslist.get(serverIndex).toString();
				System.out.println("[SWITCH] Switching back to 1st server (" + currentServer + ")");
			}
		}
		System.out.println("[SWITCH] Server switched");
		System.out.println("[SWITCH] ServerReady --> ServerReady");
	}
	//End of user code
	
	//Start of user code canSwitchServer
	@Guard(name = "canSwitchServer")
	public boolean canSwitchServer(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: removeAllServer
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: removeallserver
     * - title: 
	 */
	@Transitions({
		@Transition(name = "removeAllServer", source = "SwitchReady", target = "SwitchInit", guard = "canRemoveAllServer"),
	})
	//@Override
	//Start of user code removeAllServer
	public void removeAllServer(@Data(name = "flag") MonitorResult flag)
	{
		System.out.println("[SWITCH] Remove all servers....");
		serverslist.clear();
		currentServer = "";
		serverIndex = 0;
		System.out.println("[SWITCH] All servers are removed");
		System.out.println("[SWITCH] SwitchReady --> SwitchInit");
		flag.setHttpResponse("");
	}
	//End of user code
	
	//Start of user code canRemoveAllServer
	@Guard(name = "canRemoveAllServer")
	public boolean canRemoveAllServer(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: switchConfirm
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: switchconfirm
     * - title: 
	 */
	@Transitions({
		@Transition(name = "switchConfirm", source = "SwitchReady", target = "ServerReady", guard = "canSwitchConfirm"),
	})
	//@Override
	//Start of user code switchConfirm
	public void switchConfirm()
	{
		System.out.println("[SWITCH] Confirm ....");
		System.out.println("[SWITCH] SwitchReady --> ServerReady");
	}
	//End of user code
	
	//Start of user code canSwitchConfirm
	@Guard(name = "canSwitchConfirm")
	public boolean canSwitchConfirm(){
		return currentServer != "";
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: addServer
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: addserver
     * - title: 
	 */
	@Transitions({
		@Transition(name = "addServer", source = "SwitchInit", target = "SwitchReady", guard = "canAddServer"),
		@Transition(name = "addServer", source = "SwitchReady", target = "SwitchReady", guard = "canAddServer"),
	})
	//@Override
	//Start of user code addServer
	public void addServer(@Data(name = "address") MonitorResult address)
	{
		System.out.println("[SWITCH] Adding a server....");
		serverslist.add(address.getHttpResponse());
		System.out.println("[SWITCH] Added the server : " + address.getHttpResponse() + " ("+ serverslist.size() +" servers are added)");
		System.out.println("[SWITCH] SwitchInit/SwitchReady --> SwitchReady");
		address.setHttpResponse("");
	}
	//End of user code
	
	//Start of user code canAddServer
	@Guard(name = "canAddServer")
	public boolean canAddServer(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: resetSwitch
     * - scheme: http://occiware.org/monitorswitch/switch/action#
     * - term: resetswitch
     * - title: 
	 */
	@Transitions({
		@Transition(name = "resetSwitch", source = "ServerReady", target = "SwitchInit", guard = "canResetSwitch"),
	})
	//@Override
	//Start of user code resetSwitch
	public void resetSwitch()
	{
		System.out.println("[SWITCH] Reset the Switch (ServerReady --> SwitchInit)");
		serverslist.clear();
		currentServer = "";
		serverIndex = 0;
		System.out.println("[SWITCH] All servers are removed");
	}
	//End of user code
	
	//Start of user code canResetSwitch
	@Guard(name = "canResetSwitch")
	public boolean canResetSwitch(){
		return true;
	}
	//End of user code
	
	// Start of user code other functions
	// End of user code
}	
