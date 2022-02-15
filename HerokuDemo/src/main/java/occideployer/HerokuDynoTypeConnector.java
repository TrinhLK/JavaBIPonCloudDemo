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

import java.io.*;
import java.net.*;
import java.util.ArrayList;

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
 * - term: herokudynotype
 * - title: 
 */
@Ports({
	// Plan
	@Port(name = "sub1", type = PortType.enforceable),
	// reset
	@Port(name = "reset1", type = PortType.enforceable),
	//Data
	@Port(name = "sendDynoResponse", type = PortType.enforceable),
})

@ComponentType(initial = "Init", name = "deployer.HerokuDynoType")
public class HerokuDynoTypeConnector {
	
	//
	Response dynoCreatingResponse;
	@Transitions({
		@Transition(name = "sub1", source = "Init", target = "Free"),
	})
	public void sub1(@Data(name = "DynoOptions") ArrayList<String> DynoOptions) throws IOException {	
		System.out.println("[HerokuDynoType] sub1 Free triggered .... (Init --> Free)");
		URL obj = new URL("https://api.heroku.com/apps");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		//add request header
		con.setRequestProperty("Accept", "application/vnd.heroku+json; version=3");
		con.setRequestProperty("Authorization", "Bearer " + BIPDeployerOCCI.authorizationToken);
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);
		
		if (!DynoOptions.get(0).isEmpty()) {
			DynoOptions.set(0, "\"name\": \"" + DynoOptions.get(0) +"\"");
		} 
		if (!DynoOptions.get(1).isEmpty()) { 
			DynoOptions.set(1, "  \"region\": \"" + DynoOptions.get(1) + "\"");
		} 
		if (!DynoOptions.get(2).isEmpty()) { 
			DynoOptions.set(2, "  \"stack\": \"" + DynoOptions.get(2) + "\"");
		}
		String jsonInputString = "{";
		boolean first = false;
		for (int i = 0; i < DynoOptions.size(); i++) {
			if (!DynoOptions.get(i).isEmpty() && !first) {
				jsonInputString = jsonInputString + DynoOptions.get(i);
				first = true;
			} else {
				if (!DynoOptions.get(i).isEmpty()) {
				jsonInputString = jsonInputString + "," + DynoOptions.get(i);
				}
			}
		}
		jsonInputString = jsonInputString + "}";
		
		System.err.println(jsonInputString);
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);           
		}
		//
		int responseCode = con.getResponseCode();
		//
		String inputLine = null;
		StringBuffer jSONContent = new StringBuffer();
		BufferedReader in;
		if (responseCode < 300) {
			 in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			//
			while ((inputLine = in.readLine()) != null) {
				jSONContent.append(inputLine);
			}
		} else {
			 in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			//
			while ((inputLine = in.readLine()) != null) {
				jSONContent.append(inputLine);
			}
		}
		in.close();
		//
//		System.out.println(jSONContent.toString());
		dynoCreatingResponse = new Response(responseCode, jSONContent.toString());
	}
	
	@Transitions({
		@Transition(name = "sendDynoResponse", source = "Free", target = "Free"),
	})
	public void sendDynoResponse() throws IOException {	
		System.out.println("[HerokuDynoType] sendDynoResponse Free triggered .... (Init --> Free)");
	}
	// Adding more options for deploying
	@Data(name = "DynoResponseData")
	public Response DynoResponseData() {
		return dynoCreatingResponse;
	}
	
	@Transitions({
		@Transition(name = "reset1", source = "Free", target = "Init"),
	})
	public void reset1() {	
		System.out.println("[HerokuDynoType] reset1 triggered .... (Free --> Init)");
	}
	

}
