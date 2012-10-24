package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login implements ActionListener{

	JFrame frame;
	Connection con;
	public login(JFrame frame,Connection con)
	{
		this.frame=frame;
		this.con=con;
	}
	JTextField texts[] = new JTextField[2];
	public void crialogin()
	{
		frame.getContentPane ().removeAll();
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize(); 
		float ajustey = (float)tamTela.height/1080;
		float ajustex = (float)tamTela.width/1920;
		frame.setLayout(null); 
		JLabel labels[] = new JLabel[3];
		JButton botoes[] = new JButton[2];
		frame.getContentPane ().setBackground(new Color(220,220,255));
		labels[0]= new JLabel("Login");
		labels[0].setFont(new Font("Login", Font.BOLD, (int)(50*ajustex)));
		labels[0].setBounds((int)(ajustex*(900)),(int)(ajustey*50),(int)(ajustex*180),(int)(ajustey*130));
		labels[1]= new JLabel("Login");
		labels[1].setFont(new Font("Login", Font.BOLD, (int)(18*ajustex)));
		labels[1].setBounds((int)(ajustex*(610)),(int)(ajustey*250),(int)(ajustex*150),(int)(ajustey*30));
		labels[2]= new JLabel("Senha");
		labels[2].setFont(new Font("Senha", Font.BOLD, (int)(18*ajustex)));
		labels[2].setBounds((int)(ajustex*(610)),(int)(ajustey*290),(int)(ajustex*150),(int)(ajustey*30));
		botoes[0]=new JButton("Logar");
	    botoes[0].setFont(new Font("Logar", Font.BOLD, (int)(13*ajustex)));
	    botoes[0].setBounds( (int)(ajustex*(670)), (int)(ajustey*370),(int)(ajustex*200), (int)(ajustey*50) );
		botoes[1]=new JButton("Sair");
	    botoes[1].setFont(new Font("Sair", Font.BOLD, (int)(13*ajustex)));
	    botoes[1].setBounds( (int)(ajustex*(920)), (int)(ajustey*370),(int)(ajustex*200), (int)(ajustey*50) );
	    texts[0]= new JTextField(50);
		texts[0].setBounds((int)(ajustex*(720)),(int)(ajustey*(250)),(int)(ajustex*240),(int)(ajustey*20));
		texts[1]= new JPasswordField(50);;
		texts[1].setBounds((int)(ajustex*(720)),(int)(ajustey*(290)),(int)(ajustex*240),(int)(ajustey*20));
		for(int i=0;i<=1;i++)				frame.getContentPane ().add (botoes[i]);
		for(int i=0;i<=1;i++)				botoes[i].addActionListener(this);
		for(int i=0;i<=2;i++)				frame.getContentPane ().add (labels[i]);
		for(int i=0;i<=1;i++)				frame.getContentPane().add(texts[i]);
		texts[0].setDocument(new FixedLengthDocument(50));
		texts[1].setDocument(new FixedLengthDocument(50));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Logar"))
		{
			String str[]= new String[2];
			try {
				for(int i=0;i<=1;i++)					str[i]=texts[i].getText();
				PreparedStatement statement = con.prepareStatement("select * from login where adm = '" + str[0] + "';");
				ResultSet result= statement.executeQuery();
				if(!result.first())		
				{
					JOptionPane.showMessageDialog(frame, "Usuario não existe");
				}
				else
				{
					result.first();
					PreparedStatement statement2 = con.prepareStatement("select * from login where adm = '" + str[0] + "' and senha ='"+str[1]+"';");
					ResultSet result2= statement2.executeQuery();
					if(!result2.first())		
					{
						JOptionPane.showMessageDialog(frame, "Senha Invalida");
					}
					else
					{
						menu men= new menu(frame,con);
						men.vaimenu();
					}
				}
				
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
				System.exit(0);
			}
		}
		else if(source.getText().equals("Sair"))
		{
			System.exit(0);
		}
		
	}
}
