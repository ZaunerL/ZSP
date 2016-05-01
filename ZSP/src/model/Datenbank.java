package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

import view.Bedienung;

public class Datenbank {
	

	
	SwingWorker read = new Swingworker<Void, String>() {
		
		private void doRun(){
			run.setEnabled(true);
			cancel.setEnabled(false);
			
			read.cancel(true);
			
		}

		protected Void doInBackground() throws Exception {

			String wasser = Bedienung.getWassfield.getText();
	        String strom = Bedieung.getStromfield.getText();
	        String gas = Bedienung.getGasfield.getText();
	        String date = Bedienung.getDatefield().getText();
	        
	        URL url = new URL("http://192.168.0.111:821/consumption?typ=wasser&date="+date+"&value="+wasser);
	   
	        try {
	            url.openStream();            
	        } catch(Exception e) {
	            
	        }

		}
		protected String Read() throws Exception {

			String wasser;
			String gas;
			String strom;
			  URL url = new URL("http://192.168.0.111:821/getconsumption?typ=wasser");
		        BufferedReader reader = null;
		        try {
		            reader = new BufferedReader(new InputStreamReader(url.openStream()));
		            wasser = reader.readLine();
		        } finally {
		            if (reader != null) {
		                reader.close();
		            }
		        }
		}
		protected void done(){
			run.setEnabled(true);
			cancel.setEnabled(false);
		}
		read.execute();
	
}
