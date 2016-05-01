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

import view.Bedienung;

public class Datenbank {
	public static File meinText;
	public static void Speichern(){
		JFrame frame = new JFrame();

		JFileChooser dateiWahl = new JFileChooser();
		dateiWahl.showSaveDialog(frame);
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(dateiWahl.getSelectedFile()));

			writer.write(Bedienung.getGasfield().getText());
			writer.write(Bedienung.getWassfield().getText());
			writer.write(Bedienung.getStromfield().getText());
			writer.close();

		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}


}
