package ro.ase.acs.cts.connections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Configuration {
	public static String readConfiguration() {
		
		BufferedReader bufferedReader=null;
		try {
			FileInputStream fileInputStream = new FileInputStream("config.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader (inputStreamReader);
			return bufferedReader.readLine();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
