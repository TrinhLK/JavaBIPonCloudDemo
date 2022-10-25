package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCmd {
	
	public static void main(String[] args) {
		RunCmd test = new RunCmd();
		test.warDeploy();
	}
	
	public String warDeploy () {
		String command = "/usr/local/bin/heroku war:deploy /Users/trinhlk/Desktop/HerokuDemo.war" + " -a " + "test-runexe";
		return exeCm(command);
	}
	
	public String exeCm (String command) {
		String content = "";
		try {
			System.out.println("Runtime-cmd: " + command);
		    Process process = Runtime.getRuntime().exec(command);
		 
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(process.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	System.out.println("Runtime-cmd checking: " + line);
		        content = content + "\n" + line;
		    }
		    reader.close();
		    
		    BufferedReader errorReader = new BufferedReader(
		            new InputStreamReader(process.getErrorStream()));
		    while ((line = errorReader.readLine()) != null) {
		        System.out.println(line);
		        System.out.println(line);
		        content = content + "\n" + line;
		    }
		    errorReader.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return content;
	}
	
}
