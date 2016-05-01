package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BackgroundTask;
import model.Datenbank;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bedienung extends JFrame {

	private JPanel contentPane;
	private JPanel leftPanel;
	private JPanel control_panel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JLabel gas;
	private JLabel wasser;
	private JLabel strom;
	private static JTextField wassfield;
	private static JTextField stromfield;
	private static JTextField gasfield;
	private boolean wass;
	private boolean gase = true;
	private boolean stroeme;
	private JButton kommaBtn;
	private boolean wassKomma = true;
	private boolean gasKomma = true;
	private boolean stromKomma = true;
	public static JTextField textField;
	private JButton btnOk;
	private JButton btnDel;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bedienung frame = new Bedienung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bedienung() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		control_panel = new JPanel();
		control_panel.setBackground(Color.WHITE);
		contentPane.add(control_panel, BorderLayout.EAST);
		control_panel.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][][][][]"));

		btn1 = new JButton("1");
		btn1.addActionListener(new ButtonActionListener1());
		control_panel.add(btn1, "cell 3 2");

		btn2 = new JButton("2");
		btn2.addActionListener(new ButtonActionListener2());
		control_panel.add(btn2, "cell 4 2");

		btn3 = new JButton("3");
		btn3.addActionListener(new ButtonActionListener3());
		control_panel.add(btn3, "cell 5 2");

		btn4 = new JButton("4");
		btn4.addActionListener(new ButtonActionListener4());
		control_panel.add(btn4, "cell 3 3");

		btn5 = new JButton("5");
		btn5.addActionListener(new ButtonActionListener5());
		control_panel.add(btn5, "cell 4 3");

		btn6 = new JButton("6");
		btn6.addActionListener(new ButtonActionListener6());
		control_panel.add(btn6, "cell 5 3");

		btn7 = new JButton("7");
		btn7.addActionListener(new ButtonActionListener7());
		control_panel.add(btn7, "cell 3 4");

		btn8 = new JButton("8");
		btn8.addActionListener(new ButtonActionListener8());
		control_panel.add(btn8, "cell 4 4");

		btn9 = new JButton("9");
		btn9.addActionListener(new ButtonActionListener9());
		control_panel.add(btn9, "cell 5 4");

		btn0 = new JButton("0");
		btn0.addActionListener(new ButtonActionListener0());
		control_panel.add(btn0, "cell 4 5");

		kommaBtn = new JButton(".");
		kommaBtn.addActionListener(new KommaBtnActionListener());
		control_panel.add(kommaBtn, "cell 5 5");

		btnOk = new JButton("OK");
		btnOk.addActionListener(new BtnOkActionListener());
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new BtnSearchActionListener());
		control_panel.add(btnSearch, "cell 6 7");
		control_panel.add(btnOk, "cell 6 8");

		btnDel = new JButton("Del");
		btnDel.addMouseListener(new BtnDelMouseListener());
		control_panel.add(btnDel, "cell 6 9");

		leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		contentPane.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setLayout(new MigLayout("", "[][grow][grow]", "[][][][][]"));

		gas = new JLabel("Gas");
		gas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leftPanel.add(gas, "cell 0 0,alignx trailing");

		setGasfield(new JTextField());
		getGasfield().addMouseListener(new TextFieldMouseListener());
		leftPanel.add(getGasfield(), "cell 1 0,growx,aligny baseline");
		getGasfield().setColumns(10);

		wasser = new JLabel("Wasser");
		wasser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leftPanel.add(wasser, "cell 0 2,alignx trailing");

		setWassfield(new JTextField());
		getWassfield().addMouseListener(new WassfieldMouseListener());
		leftPanel.add(getWassfield(), "cell 1 2,growx");
		getWassfield().setColumns(10);

		strom = new JLabel("Strom");
		strom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leftPanel.add(strom, "cell 0 4,alignx trailing");

		setStromfield(new JTextField());
		getStromfield().addMouseListener(new StromfieldMouseListener());
		leftPanel.add(getStromfield(), "cell 1 4,growx");
		getStromfield().setColumns(10);

		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}
	public static JTextField getWassfield() {
		return wassfield;
	}

	public void setWassfield(JTextField wassfield) {
		this.wassfield = wassfield;
	}
	public static JTextField getGasfield() {
		return gasfield;
	}

	public static void setGasfield(JTextField gasfield) {
		Bedienung.gasfield = gasfield;
	}
	public static JTextField getStromfield() {
		return stromfield;
	}

	public static void setStromfield(JTextField stromfield) {
		Bedienung.stromfield = stromfield;
	}
	private class ButtonActionListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//JButton btn = new JButton
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn1.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn1.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn1.getText());
			}
		}
	}
	private class ButtonActionListener2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn2.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn2.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn2.getText());
			}
		}
	}	
	private class ButtonActionListener3 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn3.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn3.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn3.getText());
			}
		}
	}
	private class ButtonActionListener4 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn4.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn4.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn4.getText());
			}
		}
	}
	private class ButtonActionListener5 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn5.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn5.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn5.getText());
			}
		}
	}
	private class ButtonActionListener6 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn6.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn6.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn6.getText());
			}
		}
	}
	private class ButtonActionListener7 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn7.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn7.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn7.getText());
			}
		}
	}
	private class ButtonActionListener8 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn8.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn8.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn8.getText());
			}
		}
	}
	private class ButtonActionListener9 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn9.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn9.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn9.getText());
			}
		}
	}
	private class ButtonActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wass){
				getWassfield().setText(getWassfield().getText() + btn0.getText());
			}
			if(gase){
				getGasfield().setText(getGasfield().getText() + btn0.getText());	
			}
			if(stroeme){
				getStromfield().setText(getStromfield().getText() + btn0.getText());
			}
		}
	}
	private class TextFieldMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			gase = true;
			wass = false;
			stroeme = false;
		}
	}
	private class WassfieldMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			wass = true;
			gase = false;
			stroeme = false;
		}
	}
	private class StromfieldMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			stroeme = true;
			wass = false;
			gase = false;
		}
	}
	private class KommaBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(wass && wassKomma){
				getWassfield().setText(getWassfield().getText() + kommaBtn.getText());
				wassKomma = false;
			}
			else if(wass && !wassKomma) {
				textField.setText("Sie haben bereits ein Komma gesetzt!");
			}
			if(gase && gasKomma){
				getGasfield().setText(getGasfield().getText() + kommaBtn.getText());	
				gasKomma = false;
			}
			else if(gase && !gasKomma){
				textField.setText("Sie haben bereits ein Komma gesetzt");
			}
			if(stroeme && stromKomma){
				getStromfield().setText(getStromfield().getText() + kommaBtn.getText());
				stromKomma = false;
			}
			else if(stroeme && !stromKomma){
				textField.setText("Sie haben bereits ein Komma gesetzt");
			}
		}
	}
	private class BtnDelMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(wass){
				getWassfield().setText(null);
			}
			if(gase){
				getGasfield().setText(null);	
			}
			if(stroeme){
				getStromfield().setText(null);
			}
		}
	}
	private class BtnOkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Datenbank.Speichern();
			BackgroundTask.start();
		}
	}
	private class BtnSearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BackgroundTask.read();
		}
	}
}
