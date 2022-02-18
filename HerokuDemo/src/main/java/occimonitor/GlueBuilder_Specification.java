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
package occimonitor;

import org.javabip.glue.GlueBuilder;

public class GlueBuilder_Specification extends GlueBuilder
{
//	//Monitor_4
//	@Override
//	public void configure() {
//		//(Monitor.switchConfirm)-(Switch.switchConfirm)
//		//ALL Synchron: root.null
//		port(SwitchConnector.class, "switchServer").requires(MonitorConnector_4.class, "switchServer");
//		port(MonitorConnector_4.class, "switchServer").requires(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_4.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector_4.class, "receiveSwitchConfirm");
//		
//		port(SwitchConnector.class, "switchServer").accepts(MonitorConnector_4.class, "switchServer");
//		port(MonitorConnector_4.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_4.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector_4.class, "receiveSwitchConfirm");
//		
//		port(HerokuControlConnector.class, "addDatabase").requires(MonitorConnector_4.class, "addDatabase");
//		port(MonitorConnector_4.class, "addDatabase").requires(HerokuControlConnector.class, "addDatabase");
//		port(HerokuControlConnector.class, "addDatabase").accepts(MonitorConnector_4.class, "addDatabase");
//		port(MonitorConnector_4.class, "addDatabase").accepts(HerokuControlConnector.class, "addDatabase");
//		
//		// Start of user code Developer policies
//		data(MonitorConnector_4.class,"currentRequest").to(HerokuControlConnector.class, "currentRequest");
//	}
	
	//Monitor_3
	@Override
	public void configure() {
		//(Monitor.switchConfirm)-(Switch.switchConfirm)
		//ALL Synchron: root.null
		port(SwitchConnector.class, "switchServer").requires(MonitorConnector_3.class, "switchServer");
		port(MonitorConnector_3.class, "switchServer").requires(SwitchConnector.class, "switchServer");

		port(SwitchConnector.class, "switchServer").accepts(MonitorConnector_3.class, "switchServer");
		port(MonitorConnector_3.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
		
		//----
		port(MonitorConnector_3.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector_3.class, "receiveSwitchConfirm");

		port(MonitorConnector_3.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector_3.class, "receiveSwitchConfirm");
		
		port(HerokuControlConnector.class, "addDatabase").requires(MonitorConnector_3.class, "addDatabase");
		port(MonitorConnector_3.class, "addDatabase").requires(HerokuControlConnector.class, "addDatabase");
		port(HerokuControlConnector.class, "addDatabase").accepts(MonitorConnector_3.class, "addDatabase");
		port(MonitorConnector_3.class, "addDatabase").accepts(HerokuControlConnector.class, "addDatabase");
		
		// Start of user code Developer policies
		data(MonitorConnector_3.class,"currentRequest").to(HerokuControlConnector.class, "currentRequest");
	}
	
//	//Monitor_2
//	@Override
//	public void configure() {
//		//(Monitor.switchConfirm)-(Switch.switchConfirm)
//		//ALL Synchron: root.null
//		port(SwitchConnector.class, "switchServer").requires(MonitorConnector_2.class, "switchServer");
//		port(MonitorConnector_2.class, "switchServer").requires(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_2.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector_2.class, "receiveSwitchConfirm");
//		
//		port(SwitchConnector.class, "switchServer").accepts(MonitorConnector_2.class, "switchServer");
//		port(MonitorConnector_2.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_2.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector_2.class, "receiveSwitchConfirm");
//
//		// Start of user code Developer policies
//		// TODO Declare fixed policies
//		// End of user code
//	}
		
//	//Monitor_1
//	@Override
//	public void configure() {
//		//(Monitor.switchConfirm)-(Switch.switchConfirm)
//		//ALL Synchron: root.null
//		port(SwitchConnector.class, "switchServer").requires(MonitorConnector_1.class, "switchServer");
//		port(MonitorConnector_1.class, "switchServer").requires(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_1.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector_1.class, "receiveSwitchConfirm");
//		
//		port(SwitchConnector.class, "switchServer").accepts(MonitorConnector_1.class, "switchServer");
//		port(MonitorConnector_1.class, "switchServer").accepts(SwitchConnector.class, "switchServer");
//
//		port(MonitorConnector_1.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector_1.class, "receiveSwitchConfirm");
//
//		port(HerokuControlConnector.class, "addDatabase").requires(MonitorConnector_1.class, "addDatabase");
//		port(MonitorConnector_1.class, "addDatabase").requires(HerokuControlConnector.class, "addDatabase");
//		port(HerokuControlConnector.class, "addDatabase").accepts(MonitorConnector_1.class, "addDatabase");
//		port(MonitorConnector_1.class, "addDatabase").accepts(HerokuControlConnector.class, "addDatabase");
//		
//		// Start of user code Developer policies
//		data(MonitorConnector_1.class,"currentRequest").to(HerokuControlConnector.class, "currentRequest");
//		// End of user code
//	}
	
//	//Monitor
//	@Override
//	public void configure() {
//		//(Monitor.switchConfirm)-(Switch.switchConfirm)
//		//ALL Synchron: root.null
//		port(MonitorConnector.class, "switchConfirm").requires(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector.class, "switchConfirm");
//
//		port(MonitorConnector.class, "switchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector.class, "switchConfirm");
//
//		//(Monitor.receiveSwitchConfirm)-(Switch.switchConfirm)
//		//ALL Synchron: root.null
//		port(MonitorConnector.class, "receiveSwitchConfirm").requires(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").requires(MonitorConnector.class, "receiveSwitchConfirm");
//
//		port(MonitorConnector.class, "receiveSwitchConfirm").accepts(SwitchConnector.class, "switchConfirm");
//		port(SwitchConnector.class, "switchConfirm").accepts(MonitorConnector.class, "receiveSwitchConfirm");
//
//		// Start of user code Developer policies
//		// TODO Declare fixed policies
//		// End of user code
//	}
}
