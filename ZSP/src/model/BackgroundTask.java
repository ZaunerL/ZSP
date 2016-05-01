package model;

import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import view.Bedienung;


public class BackgroundTask extends SwingWorker<String, Object>{

	@Override
	protected String doInBackground() throws Exception {

		Socket s = new Socket();
		ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
		String wasser = Bedienung.getWassfield().getText();
		String gas = Bedienung.getGasfield().getText();
		String strom = Bedienung.getStromfield().getText();
		os.writeObject(wasser);
		os.writeObject(gas);
		os.writeObject(strom);
		os.close();
		return wasser;
		
	}
	

}
