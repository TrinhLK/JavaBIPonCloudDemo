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
 * Generated at Wed Jan 12 21:26:57 CET 2022 from platform:/resource/HerokuDeployer/model/herokudeployer.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package occideployer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.javabip.annotations.*;
import org.javabip.api.PortType;
import org.javabip.api.BIPActor;
import org.javabip.api.DataOut.AccessType;

// Start of user code import
		// TODO Add permanent libs
// End of user code
/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://occiware.org/herokudeployer#
 * - term: monitoring
 * - title: 
 */
@Ports({
// Start of user code Ports
		// TODO Add permanent libs
// End of user code
@Port(name = "addScoutAPM", type = PortType.enforceable)
, @Port(name = "addNewRelicAPM", type = PortType.enforceable)
, @Port(name = "reset", type = PortType.enforceable)
})
@ComponentType(initial = "Init", name = "herokudeployer.connector.Monitoring")
public class MonitoringConnector
{
	/**
	 * Initialize the logger.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(MonitoringConnector.class);
	//HerokudeployerSingleton instance = HerokudeployerSingleton.getInstance();
	// Start of user code variables
		// TODO Add permanent variable
	// End of user code

	// Start of user code Monitoringconnector_constructor
	/**
	 * Constructs a monitoring connector.
	 */
	MonitoringConnector()
	{
		//final BIPActor executor = instance.engine.register(this, getTitle(), true);
		LOGGER.debug("Constructor called on " + this);
		// TODO: Implement this constructor.
	}
	// End of user code

	
	/**
	 * Implement OCCI action:
	 * - name: addScoutAPM
     * - scheme: http://occiware.org/herokudeployer/monitoring/action#
     * - term: addscoutapm
     * - title: 
	 */
	@Transitions({
		@Transition(name = "addScoutAPM", source = "Init", target = "MonitoringUsed", guard = "canAddScoutAPM"),
	})
	//@Override
	//Start of user code addScoutAPM
	public void addScoutAPM()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action addScoutAPM() called on " + this);
		System.out.println("[AddonCategories-Monitoring] addScoutAPM triggered .... (Init --> MonitoringUsed)");
		// TODO: Implement how to addScoutAPM this Monitoring.
	}
	//End of user code
	
	//Start of user code canAddScoutAPM
	@Guard(name = "canAddScoutAPM")
	public boolean canAddScoutAPM(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: addNewRelicAPM
     * - scheme: http://occiware.org/herokudeployer/monitoring/action#
     * - term: addnewrelicapm
     * - title: 
	 */
	@Transitions({
		@Transition(name = "addNewRelicAPM", source = "Init", target = "MonitoringUsed", guard = "canAddNewRelicAPM"),
	})
	//@Override
	//Start of user code addNewRelicAPM
	public void addNewRelicAPM()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action addNewRelicAPM() called on " + this);
		System.out.println("[AddonCategories-Monitoring] addNewRelicAPM triggered .... (Init --> MonitoringUsed)");
		// TODO: Implement how to addNewRelicAPM this Monitoring.
	}
	//End of user code
	
	//Start of user code canAddNewRelicAPM
	@Guard(name = "canAddNewRelicAPM")
	public boolean canAddNewRelicAPM(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: reset
     * - scheme: http://occiware.org/herokudeployer/monitoring/action#
     * - term: reset
     * - title: 
	 */
	@Transitions({
		@Transition(name = "reset", source = "MonitoringUsed", target = "Init", guard = "canReset"),
	})
	//@Override
	//Start of user code reset
	public void reset()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action reset() called on " + this);
		System.out.println("[AddonCategories-Monitoring] reset triggered .... (MonitoringUsed --> Init)");
		// TODO: Implement how to reset this Monitoring.
	}
	//End of user code
	
	//Start of user code canReset
	@Guard(name = "canReset")
	public boolean canReset(){
		return true;
	}
	//End of user code
	
	// Start of user code other functions
	// End of user code
}	
