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
 * - term: herokuregion
 * - title: 
 */
@Ports({
	@Port(name = "toUS", type = PortType.enforceable),
	@Port(name = "setAddonsForUS", type = PortType.enforceable),
	
	@Port(name = "toEU", type = PortType.enforceable),
	@Port(name = "setAddonsForEU", type = PortType.enforceable),

	@Port(name = "USreset", type = PortType.enforceable),
	@Port(name = "EUreset", type = PortType.enforceable),
})

@ComponentType(initial = "Init", name = "deployer.HerokuRegion")
public class HerokuRegionConnector {
	
//	String setRegion = "";
	
	@Transitions({
		@Transition(name = "toUS", source = "Init", target = "US"),
	})
	public void toUS() {	
		System.out.println("[HerokuRegion] toUS triggered .... (Init --> US)");
	}
	@Transitions({
		@Transition(name = "setAddonsForUS", source = "US", target = "USAddonsSet"),
	})
	public void setAddonsForUS() {	
		System.out.println("[HerokuRegion] setAddonsForUS triggered .... (US --> USAddonsSet)");
	}
	
	
	
	@Transitions({
		@Transition(name = "toEU", source = "Init", target = "EU"),
	})
	public void toEU() {	
		System.out.println("[HerokuRegion] toEU triggered .... (Init --> EU)");
	}
	@Transitions({
		@Transition(name = "setAddonsForEU", source = "EU", target = "EUAddonsSet"),
	})
	public void setAddonsForEU() {	
		System.out.println("[HerokuRegion] setAddonsForEU triggered .... (EU --> EUAddonsSet)");
	}
	
	
	@Transitions({
		@Transition(name = "USreset", source = "USAddonsSet", target = "Init"),
	})
	public void USreset() {	
		System.out.println("[HerokuRegion] USreset triggered .... (USAddonsSet --> Init)");
	}
	
	@Transitions({
		@Transition(name = "EUreset", source = "EUAddonsSet", target = "Init"),
	})
	public void EUreset() {	
		System.out.println("[HerokuRegion] EUreset triggered .... (EUAddonsSet --> Init)");
	}
	
}
