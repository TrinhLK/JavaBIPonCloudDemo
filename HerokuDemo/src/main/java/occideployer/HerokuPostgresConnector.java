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
import java.io.IOException;

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
 * - term: herokupostgres
 * - title: 
 */
@Ports({
	@Port(name = "init", type = PortType.spontaneous),
	@Port(name = "on", type = PortType.enforceable),
	@Port(name = "off", type = PortType.enforceable),
	@Port(name = "sub1", type = PortType.enforceable),
	@Port(name = "sub2", type = PortType.enforceable),
	@Port(name = "up1t2", type = PortType.spontaneous),
	@Port(name = "down2t1", type = PortType.spontaneous),
	@Port(name = "reset1", type = PortType.enforceable),
	@Port(name = "reset2", type = PortType.enforceable),
	
	@Port(name = "sendAddonResponse", type = PortType.enforceable),
})

@ComponentType(initial = "Init", name = "deployer.database.HerokuPostgre")
public class HerokuPostgresConnector {

	AddOnAvailability availability;
	boolean sendResult = false;
	
	@Transitions({
		@Transition(name = "init", source = "Init", target = "Off"),
	})
	public void init(@Data(name = "availability") AddOnAvailability availability) {	
		this.availability = availability;
		System.out.println("[Addon-HerokuPostgres] init triggered .... (init --> Off)");
		this.availability.setAvailability(false);
	}
	
	
	
	@Transitions({
		@Transition(name = "on", source = "On", target = "On"),
		@Transition(name = "on", source = "Off", target = "On"),
	})
	public void on() {	
		System.out.println("[Addon-HerokuPostgres] on triggered .... (Off --> On)/(On --> On)");
		this.availability.setAvailability(true);
	}
	
	@Transitions({
		@Transition(name = "off", source = "Off", target = "Off"),
		@Transition(name = "off", source = "On", target = "Off"),
	})
	public void off() {	
		System.out.println("[Addon-HerokuPostgres] off triggered .... (On --> Off)/(Off --> Off)");
		this.availability.setAvailability(false);
	}
	
	
	String result = "";
	
	@Transitions({
		@Transition(name = "sub1", source = "On", target = "HobbyDev"),
	})
	public void sub1(@Data(name = "AppName") String AppName) {	
		System.out.println("[Addon-HerokuPostgres] sub1 triggered .... (On --> HobbyDev)");
		result = HerokuCli.createAddon("heroku-postgresql", "hobby-dev", AppName);
		sendResult = true;
	}
	
	
	@Transitions({
		@Transition(name = "sub2", source = "On", target = "HobbyBasic"),
	})
	public void sub2(@Data(name = "AppName") String AppName) {	
		System.out.println("[Addon-HerokuPostgres] sub2 triggered .... (On --> HobbyBasic)");
		result = HerokuCli.createAddon("heroku-postgresql", "hobby-basic", AppName);
		sendResult = true;
	}
	
	@Transitions({
		@Transition(name = "sendAddonResponse", source = "HobbyDev", target = "HobbyDev", guard = "isSendResult"),
		@Transition(name = "sendAddonResponse", source = "HobbyBasic", target = "HobbyBasic", guard = "isSendResult"),
	})
	public void sendDynoResponse() throws IOException {	
		System.out.println("[Addon-HerokuPostgres] sendAddonResponse triggered .... ()");
		sendResult = false;
	}
	@Guard(name = "isSendResult")
	public boolean isSendResult() {
		return sendResult;
	}
	@Data(name = "AddonResponse")
	public String AddonResponse() {
		return result;
	}
	
	
	
	@Transitions({
		@Transition(name = "up1t2", source = "HobbyDev", target = "HobbyBasic"),
	})
	public void up1t2() {	
		System.out.println("[Addon-HerokuPostgres] up1t2 triggered .... (On --> HobbyDev)");
	}
	
	@Transitions({
		@Transition(name = "down2t1", source = "HobbyBasic", target = "HobbyDev"),
	})
	public void down2t1() {	
		System.out.println("[Addon-HerokuPostgres] down2t1 triggered .... (HobbyBasic --> HobbyBasic)");
	}
	
	
	
	@Transitions({
		@Transition(name = "reset1", source = "HobbyDev", target = "Off"),
	})
	public void reset1() {	
		System.out.println("[Addon-HerokuPostgres] reset1 triggered .... (HobbyDev --> Off)");
		this.availability.setAvailability(false);
	}
	
	@Transitions({
		@Transition(name = "reset2", source = "HobbyBasic", target = "Off"),
	})
	public void reset2() {	
		System.out.println("[Addon-HerokuPostgres] reset2 triggered .... (HobbyBasic --> Off)");
		this.availability.setAvailability(false);
	}
	
	
	
}
