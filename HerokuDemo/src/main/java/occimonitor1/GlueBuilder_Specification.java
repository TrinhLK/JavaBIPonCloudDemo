/**
 * Copyright (c) 2016-2017 Inria
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * - Lê Khánh Trình <trinh.le-khanh@inria.fr>
 *
 * Generated at Sun Jan 16 13:23:15 CET 2022 from platform:/resource/monitorswitch/model/monitorswitch.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package occimonitor1;

import org.javabip.glue.GlueBuilder;

public class GlueBuilder_Specification extends GlueBuilder
{
	//Monitor_4
	@Override
	public void configure() {
		//(Monitor_4.switchServer)-(Switch.switchServer)
		//ALL Synchron: root.null
		port(SwitchConnector.class, "switchServer").requires(Monitor_4Connector.class, "switchServer");
		port(Monitor_4Connector.class, "switchServer").requires(SwitchConnector.class, "switchServer");

		port(SwitchConnector.class, "switchServer").accepts(Monitor_4Connector.class, "switchServer");
		port(Monitor_4Connector.class, "switchServer").accepts(SwitchConnector.class, "switchServer");

		//(Monitor_4.receiveSwitchConfirm)-(Switch.switchConfirm)
		//ALL Synchron: root.null		
		port(Monitor_4Connector.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
		port(SwitchConnector.class, "switchConfirm").requires(Monitor_4Connector.class, "receiveSwitchConfirm");
		
		port(Monitor_4Connector.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
		port(SwitchConnector.class, "switchConfirm").accepts(Monitor_4Connector.class, "receiveSwitchConfirm");
	
		//(Monitor_4.addDatabase)-(HerokuControlConnector.addDatabase)
		//ALL Synchron: root.null	
		port(HerokuControllerConnector.class, "addDatabase").requires(Monitor_4Connector.class, "addDatabase");
		port(Monitor_4Connector.class, "addDatabase").requires(HerokuControllerConnector.class, "addDatabase");
	
		port(HerokuControllerConnector.class, "addDatabase").accepts(Monitor_4Connector.class, "addDatabase");
		port(Monitor_4Connector.class, "addDatabase").accepts(HerokuControllerConnector.class, "addDatabase");
		
		// Start of user code Developer policies
		data(Monitor_4Connector.class,"currentReq").to(HerokuControllerConnector.class, "currentReq");
	
		// Start of user code Developer policies
		// TODO Declare fixed policies
		// End of user code
	}
}

