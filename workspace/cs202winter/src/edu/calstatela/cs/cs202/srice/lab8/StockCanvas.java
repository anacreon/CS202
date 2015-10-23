package edu.calstatela.cs.cs202.srice.lab8;



import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockCanvas extends JFrame {
	
	private static final long serialVersionUID = 8643336084240845788L;

	public StockCanvas() {
		// top panel
		JPanel plotPanel = new JPanel();
		plotPanel.setLayout(new GridLayout(1,1));
		plotPanel.add(new JButton("graphics here later"));
		
		// bottom panel
		JPanel ctrlPanel = new JPanel();
		ctrlPanel.setLayout(new GridLayout(1,3));
		ctrlPanel.add(new JTextField("INTC"));
		ctrlPanel.add(new JComboBox(
				new String[]{"Price","Volume"}));
		ctrlPanel.add(new JButton("Go!"));
		
		add(plotPanel, BorderLayout.NORTH);
		add(ctrlPanel, BorderLayout.SOUTH);
	}
	
	// main program
	public static void main(String args[]) {
		StockCanvas canvas = new StockCanvas();
		canvas.setTitle("Stock Plotter");
		canvas.setSize(600,300);
		canvas.setLocationRelativeTo(null);
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setVisible(true);
	
	}
}
