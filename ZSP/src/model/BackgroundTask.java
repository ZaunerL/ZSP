package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import view.Bedienung;


public class BackgroundTask{

	
	SwingWorker worker = new Swingworker<Void, String>() {
		
		private void doRun(){
			run.setEnabled(true);
			cancel.setEnabled(false);
			
			worker.cancel(true);
			
		}

		protected Void doInBackground() throws Exception {

			Socket s = new Socket();
			ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
			String wasser = Bedienung.getWassfield().getText();
			String gas = Bedienung.getGasfield().getText();
			String strom = Bedienung.getStromfield().getText();
			os.writeObject(wasser);
			os.writeObject(gas);
			os.writeObject(strom);
			os.close();

		}
		protected String Read() throws Exception {

			Socket s = new Socket();
			ObjectInputStream sr = new ObjectInputStream(s.getInputStream());

			String wasser = (String) sr.readObject();
			String gas = (String) sr.readObject();
			String strom = (String) sr.readObject();
			sr.close();

			return wasser;
			return strom;
			return gas;
		}
		protected void done(){
			run.setEnabled(true);
			cancel.setEnabled(false);
		}
		worker.execute();
	}
	
	
	
	/*
	static SwingWorker readWas = new SwingWorker<String>() {
		protected Void doInBackground() throws Exception {

			Socket s = new Socket();
			ObjectInputStream sr = new ObjectInputStream(s.getInputStream());

			String wasser = (String) sr.readObject();
			String gas = (String) sr.readObject();
			String strom = (String) sr.readObject();
			sr.close();

			return wasser;
			return strom;
			return gas;
		}
		protected void done(){
			run.setEnabled(true);
			cancel.setEnabled(false);
		}
		readWas.execute();
		
	}
*/
}