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
 * - term: database
 * - title: 
 */
@Ports({
// Start of user code Ports
		// TODO Add permanent libs
// End of user code
@Port(name = "addHerokuPostgres", type = PortType.enforceable)
, @Port(name = "reset", type = PortType.enforceable)
, @Port(name = "addClearDBMySQL", type = PortType.enforceable)
})
@ComponentType(initial = "Init", name = "herokudeployer.connector.Database")
public class DatabaseConnector
{
	/**
	 * Initialize the logger.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnector.class);
	//HerokudeployerSingleton instance = HerokudeployerSingleton.getInstance();
	// Start of user code variables
		// TODO Add permanent variable
	// End of user code

	// Start of user code Databaseconnector_constructor
	/**
	 * Constructs a database connector.
	 */
	DatabaseConnector()
	{
		//final BIPActor executor = instance.engine.register(this, getTitle(), true);
		LOGGER.debug("Constructor called on " + this);
		// TODO: Implement this constructor.
	}
	// End of user code

	
	/**
	 * Implement OCCI action:
	 * - name: addHerokuPostgres
     * - scheme: http://occiware.org/herokudeployer/database/action#
     * - term: addherokupostgres
     * - title: 
	 */
	@Transitions({
		@Transition(name = "addHerokuPostgres", source = "Init", target = "DatabaseUsed", guard = "canAddHerokuPostgres"),
	})
	//@Override
	//Start of user code addHerokuPostgres
	public void addHerokuPostgres()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action addHerokuPostgres() called on " + this);
		System.out.println("[AddonCategories-Database] addHerokuPostgres triggered .... (Init --> DatabaseUsed)");
		// TODO: Implement how to addHerokuPostgres this Database.
	}
	//End of user code
	
	//Start of user code canAddHerokuPostgres
	@Guard(name = "canAddHerokuPostgres")
	public boolean canAddHerokuPostgres(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: reset
     * - scheme: http://occiware.org/herokudeployer/database/action#
     * - term: reset
     * - title: 
	 */
	@Transitions({
		@Transition(name = "reset", source = "DatabaseUsed", target = "Init", guard = "canReset"),
	})
	//@Override
	//Start of user code reset
	public void reset()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action reset() called on " + this);
		System.out.println("[AddonCategories-Database] reset triggered .... (DatabaseUsed --> Init)");
		// TODO: Implement how to reset this Database.
	}
	//End of user code
	
	//Start of user code canReset
	@Guard(name = "canReset")
	public boolean canReset(){
		return true;
	}
	//End of user code
	
	
	/**
	 * Implement OCCI action:
	 * - name: addClearDBMySQL
     * - scheme: http://occiware.org/herokudeployer/database/action#
     * - term: addcleardbmysql
     * - title: 
	 */
	@Transitions({
		@Transition(name = "addClearDBMySQL", source = "Init", target = "DatabaseUsed", guard = "canAddClearDBMySQL"),
	})
	//@Override
	//Start of user code addClearDBMySQL
	public void addClearDBMySQL()
	{
		//instance.runningConfiguration();
		LOGGER.debug("Action addClearDBMySQL() called on " + this);
		System.out.println("[AddonCategories-Database] addClearDBMySQL triggered .... (Init --> DatabaseUsed)");
		// TODO: Implement how to addClearDBMySQL this Database.
	}
	//End of user code
	
	//Start of user code canAddClearDBMySQL
	@Guard(name = "canAddClearDBMySQL")
	public boolean canAddClearDBMySQL(){
		return true;
	}
	//End of user code
	
	// Start of user code other functions
	// End of user code
}	
