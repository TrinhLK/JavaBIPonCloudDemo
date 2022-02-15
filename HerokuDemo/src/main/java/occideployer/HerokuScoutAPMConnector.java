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
 * - term: herokuscoutapm
 * - title: 
 */
@Ports({
	@Port(name = "init", type = PortType.spontaneous),
	@Port(name = "on", type = PortType.enforceable),
	@Port(name = "off", type = PortType.enforceable),
	@Port(name = "sub1", type = PortType.enforceable),
	@Port(name = "reset1", type = PortType.enforceable),
})

@ComponentType(initial = "init", name = "deployer.monitoring.HerokuScoutAPM")
public class HerokuScoutAPMConnector {
	
	String name = "ScoutAPM";
	
	AddOnAvailability availability;
	
	@Transitions({
		@Transition(name = "init", source = "init", target = "Off"),
	})
	public void init(@Data(name = "availability") AddOnAvailability availability) {	
		this.availability = availability;
		System.out.println("[Addon-HerokuScoutAPM] init triggered .... (init --> Off)");
		this.availability.setAvailability(false);
	}
	
	@Transitions({
		@Transition(name = "on", source = "On", target = "On"),
		@Transition(name = "on", source = "Off", target = "On"),
	})
	public void on() {	
		System.out.println("[Addon-HerokuScoutAPM] on triggered .... (Off --> On)/(On --> On)");
		this.availability.setAvailability(true);
	}
	
	@Transitions({
		@Transition(name = "off", source = "Off", target = "Off"),
		@Transition(name = "off", source = "On", target = "Off"),
	})
	public void off() {	
		System.out.println("[Addon-HerokuScoutAPM] off triggered .... (Off --> On)/(Off --> Off)");
		this.availability.setAvailability(false);
	}
	
	
	@Transitions({
		@Transition(name = "sub1", source = "On", target = "Chair"),
	})
	public void sub1() {	
		System.out.println("[Addon-HerokuScoutAPM] sub1 triggered .... (On --> Chair)");
	}
	
	
	@Transitions({
		@Transition(name = "reset1", source = "Chair", target = "Off"),
	})
	public void reset1() {	
		System.out.println("[Addon-HerokuScoutAPM] reset1 triggered .... (Chair --> Off)");
		this.availability.setAvailability(false);
	}

}
