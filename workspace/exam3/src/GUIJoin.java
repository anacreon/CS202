
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIJoin extends JFrame{
	JTextField fileA = new JTextField("file A");
	JTextField fileB = new JTextField("file B");
	JTextField fileC = new JTextField("file C");
	FileOperator fo = new FileOperator();
	GUIJoin()
	{
		FileOperator fo = new FileOperator();
		JPanel files = new JPanel();
		files.setLayout(new GridLayout(1,1));
		files.add(fileA);
		files.add(fileB);
		files.add(fileC);
		
		JButton Join = new JButton("Join");
		
        files.add(Join);
		add(files, BorderLayout.CENTER);
		
		JoinListener listener = new JoinListener();
		Join.addActionListener(listener);
		
	}
	class JoinListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String fa = new String(fileA.getText());
			String fb = new String(fileB.getText());
			String fc = new String(fileC.getText());
			
			try {
				fo.join(fa, fb, fc);
			} catch (IOException e1) {
				
			}
			
		
		}
	
	}
	public static void main(String args[])
	{
		GUIJoin join = new GUIJoin();
		join.setTitle("GUIJoin");
		join.setSize(600, 300);
		join.setLocationRelativeTo(null);
		join.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		join.setVisible(true);
	}
}
