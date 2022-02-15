package occideployer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	static String cliDir = "heroku";
	
	public static String createAddon (String addon, String plan, String appName) {
		String command = cliDir + " addons:create " + addon + ":" + plan + " -a " + appName;
		return exeCm(command);
	}
	
	
	static String warDeploy (String dir, String appName) {
		String command = cliDir + " war:deploy " + dir + " -a " + appName;
		return exeCm(command);
	}
	
	
	static String exeCm (String command) {
		String content = "";
		try {
			System.out.println("Runtime-cmd: " + command);
		    Process process = Runtime.getRuntime().exec(command);
		 
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(process.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	System.out.println(line);
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
	
	public static void main(String[] args) {
		exeCm("/usr/local/bin/heroku war:deploy /Users/trinhlk/Desktop/HerokuDemo.war -a damp-fjord-76589");
	}
}
