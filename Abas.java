package projeto1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Abas {
	JFrame frame;
	public Abas(JFrame fram2){
		frame=fram2;
	}
	public JTabbedPane JTabbedPaneDemo()
	{
		JTabbedPane jtbExample = new JTabbedPane();
		jtbExample.add(new JPanel(), "1 Panel");  
		jtbExample.setSelectedIndex(0);
		return jtbExample;
	}
	public void makeUI() {
		JTabbedPane panel = new JTabbedPane();
		JPanel painel = new JPanel();
		panel.add(painel, "1 Panel");  
		panel.setSelectedIndex(0);
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize(); 
		panel.setBounds(0, 0, tamTela.width, tamTela.height-55);
		painel.setBounds(0,70,tamTela.width,tamTela.height-75);
		panel.setVisible(true);
		frame.add(panel);
		frame.repaint();
	}

}
