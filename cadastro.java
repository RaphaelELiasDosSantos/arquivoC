package projeto1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

public class cadastro implements ActionListener{
	/**
	 * 
	 */
	JFrame frame;
	Connection con;
	public cadastro(JFrame frame2,Connection con)
	{
		this.frame=frame2;
		this.con=con;
	}
	public JScrollPane scrollpane = new JScrollPane(null);
	public JScrollPane scrollpane2 = new JScrollPane(null);
	JTextField texts2[] = new JTextField[50];
	JFormattedTextField texts3[] = new JFormattedTextField[50];
	JFormattedTextField textsCompra[] = new JFormattedTextField[18];
	JFormattedTextField textsConsig[] = new JFormattedTextField[18];
	int contador=0;
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	DecimalFormat integer = new DecimalFormat("#"); 
	
	MaskFormatter forData = null;//campo para data  
	public void cadastrar()
	{
			integer.setMaximumIntegerDigits(10);
			frame.getContentPane ().removeAll();
			frame.setContentPane(new JPanel());
			frame.setLayout(null);
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 500;
			int y = 100;
			JLabel labels[] = new JLabel[30];
			JButton botoes[] = new JButton[7]; 
			try {
				forData = new MaskFormatter("##/##/####");
				forData.setValidCharacters("0123456789"); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			JLabel labels3= new JLabel("Cadastro");
			labels3.setFont(new Font("Cadastro", Font.BOLD, (int)(50*ajustex)));
			labels3.setBounds((int)(ajustex*(x+280)),(int)(ajustey*(-30)),(int)(ajustex*300),(int)(ajustey*130));
			frame.getContentPane ().add (labels3);
		    frame.getContentPane ().setBackground(new Color(220,220,255));
		    botoes[0]=new JButton("Adicionar Compra");
		    botoes[0].setFont(new Font("Adicionar Compra", Font.BOLD, (int)(13*ajustex)));
			botoes[0].setBounds( (int)(ajustex*(x+60)), (int)(ajustey*800),(int)(ajustex*200), (int)(ajustey*50) );
			botoes[0].addActionListener(this);
			frame.getContentPane ().add (botoes[0]);
			textsCompra[0]= new JFormattedTextField();
			textsCompra[0].setBounds((int)(ajustex*(x+60)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
			labels[21]= new JLabel("Compra");
			labels[21].setFont(new Font("Compra", Font.BOLD, (int)(18*ajustex)));
			labels[21].setBounds((int)(ajustex*(x+110)),(int)(ajustey*70),(int)(ajustex*100),(int)(ajustey*20));
			labels[0]= new JLabel("Marca");
			labels[0].setFont(new Font("Marca", Font.BOLD, (int)(13*ajustex)));
			labels[0].setBounds((int)(ajustex*x),(int)(ajustey*y),(int)(ajustex*50),(int)(ajustey*20));
			textsCompra[1]= new JFormattedTextField();
			textsCompra[1].setColumns(20); 
			textsCompra[1].setBounds((int)(ajustex*(x+60)),(int)(ajustey*(y+30)),(int)(ajustex*200),(int)(ajustey*20));
			labels[1]= new JLabel("Modelo");
			labels[1].setFont(new Font("Modelo", Font.BOLD, (int)(13*ajustex)));
			labels[1].setBounds((int)(ajustex*x),(int)(ajustey*(y+30)),(int)(ajustex*50),(int)(ajustey*20));
			textsCompra[2]= new JFormattedTextField();
			textsCompra[2].setBounds((int)(ajustex*(x+60)),(int)(ajustey*(y+60)),(int)(ajustex*50),(int)(ajustey*20));
			labels[2]= new JLabel("Ano");
			labels[2].setFont(new Font("Ano", Font.BOLD, (int)(13*ajustex)));
			labels[2].setBounds((int)(ajustex*x),(int)(ajustey*(y+60)),(int)(ajustex*50),(int)(ajustey*20));
			textsCompra[3]= new JFormattedTextField();
			textsCompra[3].setBounds((int)(ajustex*(x+190)),(int)(ajustey*(y+60)),(int)(ajustex*70),(int)(ajustey*20));
			labels[3]= new JLabel("Placa");
			labels[3].setFont(new Font("Placa", Font.BOLD, (int)(13*ajustex)));
			labels[3].setBounds((int)(ajustex*(x+150)),(int)(ajustey*(y+60)),(int)(ajustex*50),(int)(ajustey*20));
			textsCompra[6]= new JFormattedTextField(forData);
			labels[20]= new JLabel("Chassi");
			labels[20].setFont(new Font("Chassi", Font.BOLD, (int)(13*ajustex)));
			labels[20].setBounds((int)(ajustex*x),(int)(ajustey*(y+90)),(int)(ajustex*50),(int)(ajustey*20));
			textsCompra[4]= new JFormattedTextField();
			textsCompra[4].setBounds((int)(ajustex*(x+60)),(int)(ajustey*(y+90)),(int)(ajustex*50),(int)(ajustey*20));
			labels[19]= new JLabel("Renavam");
			labels[19].setFont(new Font("Renavam", Font.BOLD, (int)(13*ajustex)));
			labels[19].setBounds((int)(ajustex*(x+120)),(int)(ajustey*(y+90)),(int)(ajustex*80),(int)(ajustey*20));
			textsCompra[5]= new JFormattedTextField();
			textsCompra[5].setBounds((int)(ajustex*(x+190)),(int)(ajustey*(y+90)),(int)(ajustex*70),(int)(ajustey*20));
			textsCompra[6].setBounds((int)(ajustex*(x+140)),(int)(ajustey*(y+120)),(int)(ajustex*120),(int)(ajustey*20));
			labels[4]= new JLabel("Data de Compra");
			labels[4].setFont(new Font("Data de Compra", Font.BOLD, (int)(13*ajustex)));
			labels[4].setBounds((int)(ajustex*x),(int)(ajustey*(y+120)),(int)(ajustex*130),(int)(ajustey*20));
			textsCompra[7]= new JFormattedTextField(integer);
			textsCompra[7].setBounds((int)(ajustex*(x+140)),(int)(ajustey*(y+145)),(int)(ajustex*120),(int)(ajustey*20));
			labels[5]= new JLabel("Valor de Compra (R$)");
			labels[5].setFont(new Font("Valor de Compra (R$)", Font.BOLD, (int)(12*ajustex)));
			labels[5].setBounds((int)(ajustex*x),(int)(ajustey*(y+145)),(int)(ajustex*130),(int)(ajustey*20));
			labels[6]= new JLabel("Observações");
			labels[6].setFont(new Font("Observações", Font.BOLD, (int)(13*ajustex)));
			labels[6].setBounds((int)(ajustex*x),(int)(ajustey*(y+170)),(int)(ajustex*100),(int)(ajustey*20));
			labels[7]= new JLabel("1-");
			labels[7].setFont(new Font("1-", Font.BOLD, (int)(13*ajustex)));
			labels[7].setBounds((int)(ajustex*x),(int)(ajustey*(y+190)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[8]= new JFormattedTextField();
			textsCompra[8].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+190)),(int)(ajustex*240),(int)(ajustey*20));
			labels[8]= new JLabel("2-");
			labels[8].setFont(new Font("2-", Font.BOLD, (int)(13*ajustex)));
			labels[8].setBounds((int)(ajustex*x),(int)(ajustey*(y+210)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[9]= new JFormattedTextField();
			textsCompra[9].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+210)),(int)(ajustex*240),(int)(ajustey*20));
			labels[9]= new JLabel("3-");
			labels[9].setFont(new Font("3-", Font.BOLD, (int)(13*ajustex)));
			labels[9].setBounds((int)(ajustex*x),(int)(ajustey*(y+230)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[10]= new JFormattedTextField();
			textsCompra[10].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+230)),(int)(ajustex*240),(int)(ajustey*20));
			labels[10]= new JLabel("4-");
			labels[10].setFont(new Font("4-", Font.BOLD, (int)(13*ajustex)));
			labels[10].setBounds((int)(ajustex*x),(int)(ajustey*(y+250)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[11]= new JFormattedTextField();
			textsCompra[11].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+250)),(int)(ajustex*240),(int)(ajustey*20));
			labels[11]= new JLabel("5-");
			labels[11].setFont(new Font("5-", Font.BOLD, (int)(13*ajustex)));
			labels[11].setBounds((int)(ajustex*x),(int)(ajustey*(y+270)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[12]= new JFormattedTextField();
			textsCompra[12].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+270)),(int)(ajustex*240),(int)(ajustey*20));
			labels[12]= new JLabel("6-");
			labels[12].setFont(new Font("6-", Font.BOLD, (int)(13*ajustex)));
			labels[12].setBounds((int)(ajustex*x),(int)(ajustey*(y+290)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[13]= new JFormattedTextField();
			textsCompra[13].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+290)),(int)(ajustex*240),(int)(ajustey*20));
			labels[13]= new JLabel("7-");
			labels[13].setFont(new Font("7-", Font.BOLD, (int)(13*ajustex)));
			labels[13].setBounds((int)(ajustex*x),(int)(ajustey*(y+310)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[14]= new JFormattedTextField();
			textsCompra[14].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+310)),(int)(ajustex*240),(int)(ajustey*20));
			labels[14]= new JLabel("8-");
			labels[14].setFont(new Font("8-", Font.BOLD, (int)(13*ajustex)));
			labels[14].setBounds((int)(ajustex*x),(int)(ajustey*(y+330)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[15]= new JFormattedTextField();
			textsCompra[15].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+330)),(int)(ajustex*240),(int)(ajustey*20));
			labels[15]= new JLabel("9-");
			labels[15].setFont(new Font("9-", Font.BOLD, (int)(13*ajustex)));
			labels[15].setBounds((int)(ajustex*x),(int)(ajustey*(y+350)),(int)(ajustex*20),(int)(ajustey*20));
			textsCompra[16]= new JFormattedTextField();
			textsCompra[16].setBounds((int)(ajustex*(x+20)),(int)(ajustey*(y+350)),(int)(ajustex*240),(int)(ajustey*20));
			labels[16]= new JLabel("Despesas");
			labels[16].setFont(new Font("Despesas", Font.BOLD, (int)(13*ajustex)));
			labels[16].setBounds((int)(ajustex*(x+100)),(int)(ajustey*(y+390)),(int)(ajustex*90),(int)(ajustey*20));
			labels[17]= new JLabel("Descrição");
			labels[17].setFont(new Font("Descrição", Font.BOLD, (int)(13*ajustex)));
			labels[17].setBounds((int)(ajustex*(x+30)),(int)(ajustey*(y+410)),(int)(ajustex*90),(int)(ajustey*20));
			labels[18]= new JLabel("Valor (R$)");
			labels[18].setFont(new Font("Valor (R$)", Font.BOLD, (int)(13*ajustex)));
			labels[18].setBounds((int)(ajustex*(x+190)),(int)(ajustey*(y+410)),(int)(ajustex*120),(int)(ajustey*20));
			botoes[1] = new JButton("Adicionar Despesas");
			botoes[1].setFont(new Font("Adicionar Despesas", Font.BOLD, (int)(13*ajustex)));
			botoes[1].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+440)),(int)(ajustex*190), (int)(ajustey*30) );
			botoes[1].addActionListener(this);
			frame.getContentPane ().add (botoes[1]);
			botoes[2] = new JButton("Remover Despesas");
			botoes[2].setFont(new Font("Remover Despesas", Font.BOLD, (int)(13*ajustex)));
			botoes[2].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+620)),(int)(ajustex*190), (int)(ajustey*30) );
			botoes[2].addActionListener(this);
			textsCompra[17]= new JFormattedTextField(integer);
			textsCompra[17].setBounds((int)(ajustex*(x+120)),(int)(ajustey*(y+670)),(int)(ajustex*140),(int)(ajustey*20));
			labels[22]= new JLabel("Valor Final (R$)");
			labels[22].setFont(new Font("ValorFinal (R$)", Font.BOLD, (int)(13*ajustex)));
			labels[22].setBounds((int)(ajustex*x),(int)(ajustey*(y+670)),(int)(ajustex*150),(int)(ajustey*20));
			frame.getContentPane ().add (botoes[2]);
			botoes[6]=new JButton("Adicionar Consignação");
		    botoes[6].setFont(new Font("Adicionar Consignação", Font.BOLD, (int)(13*ajustex)));
			botoes[6].setBounds( (int)(ajustex*(x+570)), (int)(ajustey*560),(int)(ajustex*200), (int)(ajustey*50) );
			botoes[6].addActionListener(this);
			
			frame.getContentPane ().add (botoes[6]);
			for(int i=0;i<=22;i++)				frame.getContentPane ().add (labels[i]);
			for(int i=0;i<=17;i++)				frame.getContentPane ().add (textsCompra[i]);
			textsCompra[0].setDocument(new FixedLengthDocument(50));
			textsCompra[1].setDocument(new FixedLengthDocument(100));
			textsCompra[2].setDocument(new FixedLengthDocument(20));
			textsCompra[3].setDocument(new FixedLengthDocument(50));
			textsCompra[4].setDocument(new FixedLengthDocument(50));
			textsCompra[5].setDocument(new FixedLengthDocument(50));
			for(int i=8;i<=16;i++)		textsCompra[i].setDocument(new FixedLengthDocument(150));
			this.cadastroConsig();
	}
	public void cadastroConsig()
	{
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize(); 
		float ajustey = (float)tamTela.height/1080;
		float ajustex = (float)tamTela.width/1920;
		int x = 10;
		int aux = x +1000;
		JLabel labels[] = new JLabel[30];
		textsConsig[0]= new JFormattedTextField();
		textsConsig[0].setBounds((int)(ajustex*(aux+60)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
		labels[19]= new JLabel("Consignação");
		labels[19].setFont(new Font("Consignação", Font.BOLD, (int)(18*ajustex)));
		labels[19].setBounds((int)(ajustex*(90+aux)),(int)(ajustey*70),(int)(ajustex*150),(int)(ajustey*20));
		labels[0]= new JLabel("Marca");
		labels[0].setFont(new Font("Marca", Font.BOLD, (int)(13*ajustex)));
		labels[0].setBounds((int)(ajustex*(aux)),(int)(ajustey*100),(int)(ajustex*50),(int)(ajustey*20));
		textsConsig[1]= new JFormattedTextField();
		textsConsig[1].setBounds((int)(ajustex*(60+aux)),(int)(ajustey*130),(int)(ajustex*200),(int)(ajustey*20));
		labels[1]= new JLabel("Modelo");
		labels[1].setFont(new Font("Modelo", Font.BOLD, (int)(13*ajustex)));
		labels[1].setBounds((int)(ajustex*(aux)),(int)(ajustey*130),(int)(ajustex*50),(int)(ajustey*20));
		textsConsig[2]= new JFormattedTextField();
		textsConsig[2].setBounds((int)(ajustex*(aux+60)),(int)(ajustey*160),(int)(ajustex*50),(int)(ajustey*20));
		labels[2]= new JLabel("Ano");
		labels[2].setFont(new Font("Ano", Font.BOLD, (int)(13*ajustex)));
		labels[2].setBounds((int)(ajustex*(aux)),(int)(ajustey*160),(int)(ajustex*50),(int)(ajustey*20));
		textsConsig[3]= new JFormattedTextField();
		textsConsig[3].setBounds((int)(ajustex*(190+aux)),(int)(ajustey*160),(int)(ajustex*70),(int)(ajustey*20));
		labels[3]= new JLabel("Placa");
		labels[3].setFont(new Font("Placa", Font.BOLD, (int)(13*ajustex)));
		labels[3].setBounds((int)(ajustex*(150+aux)),(int)(ajustey*160),(int)(ajustex*50),(int)(ajustey*20));
		textsConsig[4]= new JFormattedTextField(forData);
		textsConsig[4].setBounds((int)(ajustex*(120+aux)),(int)(ajustey*190),(int)(ajustex*140),(int)(ajustey*20));
		labels[4]= new JLabel("Data de Entrada");
		labels[4].setFont(new Font("Data de Entrada", Font.BOLD, (int)(13*ajustex)));
		labels[4].setBounds((int)(ajustex*(aux)),(int)(ajustey*190),(int)(ajustex*130),(int)(ajustey*20));
		textsConsig[5]= new JFormattedTextField();
		textsConsig[5].setBounds((int)(ajustex*(90+aux)),(int)(ajustey*220),(int)(ajustex*170),(int)(ajustey*20));
		labels[5]= new JLabel("Proprietario");
		labels[5].setFont(new Font("Proprietario", Font.BOLD, (int)(12*ajustex)));
		labels[5].setBounds((int)(ajustex*(aux)),(int)(ajustey*220),(int)(ajustex*130),(int)(ajustey*20));
		labels[6]= new JLabel("Observações");
		labels[6].setFont(new Font("Observações", Font.BOLD, (int)(13*ajustex)));
		labels[6].setBounds((int)(ajustex*(aux)),(int)(ajustey*365),(int)(ajustex*100),(int)(ajustey*20));
		labels[7]= new JLabel("Telefone");
		labels[7].setFont(new Font("Telefone", Font.BOLD, (int)(13*ajustex)));
		labels[7].setBounds((int)(ajustex*(aux)),(int)(ajustey*250),(int)(ajustex*100),(int)(ajustey*20));
		textsConsig[6]= new JFormattedTextField();
		textsConsig[6].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*250),(int)(ajustex*190),(int)(ajustey*20));
		labels[17]= new JLabel("Endereço");
		labels[17].setFont(new Font("Endereço", Font.BOLD, (int)(13*ajustex)));
		labels[17].setBounds((int)(ajustex*(aux)),(int)(ajustey*280),(int)(ajustex*100),(int)(ajustey*20));
		textsConsig[7]= new JFormattedTextField();
		textsConsig[7].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*280),(int)(ajustex*190),(int)(ajustey*20));
		labels[18]= new JLabel("Email");
		labels[18].setFont(new Font("Email", Font.BOLD, (int)(13*ajustex)));
		labels[18].setBounds((int)(ajustex*(aux)),(int)(ajustey*310),(int)(ajustex*100),(int)(ajustey*20));
		textsConsig[8]= new JFormattedTextField();
		textsConsig[8].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*310),(int)(ajustex*190),(int)(ajustey*20));
		labels[8]= new JLabel("Valor Pedido (R$)");
		labels[8].setFont(new Font("2-", Font.BOLD, (int)(13*ajustex)));
		labels[8].setBounds((int)(ajustex*(aux)),(int)(ajustey*340),(int)(ajustex*120),(int)(ajustey*20));
		textsConsig[9]= new JFormattedTextField(integer);
		textsConsig[9].setBounds((int)(ajustex*(aux+130)),(int)(ajustey*340),(int)(ajustex*130),(int)(ajustey*20));
		labels[10]= new JLabel("1-");
		labels[10].setFont(new Font("1-", Font.BOLD, (int)(13*ajustex)));
		labels[10].setBounds((int)(ajustex*(aux)),(int)(ajustey*390),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[10]= new JFormattedTextField();
		textsConsig[10].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*390),(int)(ajustex*240),(int)(ajustey*20));
		labels[11]= new JLabel("2-");
		labels[11].setFont(new Font("2-", Font.BOLD, (int)(13*ajustex)));
		labels[11].setBounds((int)(ajustex*(aux)),(int)(ajustey*410),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[11]= new JFormattedTextField();
		textsConsig[11].setBounds((int)(ajustex*(20+aux)),(int)(ajustey*410),(int)(ajustex*240),(int)(ajustey*20));
		labels[12]= new JLabel("3-");
		labels[12].setFont(new Font("3-", Font.BOLD, (int)(13*ajustex)));
		labels[12].setBounds((int)(ajustex*(aux)),(int)(ajustey*430),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[12]= new JFormattedTextField();
		textsConsig[12].setBounds((int)(ajustex*(20+aux)),(int)(ajustey*430),(int)(ajustex*240),(int)(ajustey*20));
		labels[13]= new JLabel("4-");
		labels[13].setFont(new Font("4-", Font.BOLD, (int)(13*ajustex)));
		labels[13].setBounds((int)(ajustex*(aux)),(int)(ajustey*450),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[13]= new JFormattedTextField();
		textsConsig[13].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*450),(int)(ajustex*240),(int)(ajustey*20));
		labels[14]= new JLabel("5-");
		labels[14].setFont(new Font("5-", Font.BOLD, (int)(13*ajustex)));
		labels[14].setBounds((int)(ajustex*(aux)),(int)(ajustey*470),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[14]= new JFormattedTextField();
		textsConsig[14].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*470),(int)(ajustex*240),(int)(ajustey*20));
		labels[15]= new JLabel("6-");
		labels[15].setFont(new Font("6-", Font.BOLD, (int)(13*ajustex)));
		labels[15].setBounds((int)(ajustex*(aux)),(int)(ajustey*490),(int)(ajustex*20),(int)(ajustey*20));
		textsConsig[15]= new JFormattedTextField();
		textsConsig[15].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*490),(int)(ajustex*240),(int)(ajustey*20));
		labels[16]= new JLabel("Valor de Venda (R$)");
		labels[16].setFont(new Font("Valor de Venda (R$)", Font.BOLD, (int)(13*ajustex)));
		labels[16].setBounds((int)(ajustex*(aux)),(int)(ajustey*530),(int)(ajustex*130),(int)(ajustey*20));
		textsConsig[16]= new JFormattedTextField(integer);
		textsConsig[16].setBounds((int)(ajustex*(aux+170)),(int)(ajustey*530),(int)(ajustex*90),(int)(ajustey*20));
		for(int i=0;i<=19;i++)
			{
				if(i!=9)				frame.getContentPane ().add (labels[i]);
			}
		for(int i=0;i<=16;i++)
			{
				frame.getContentPane ().add (textsConsig[i]);
			}
		frame.setVisible(true);
		frame.repaint();
		textsConsig[0].setDocument(new FixedLengthDocument(50));
		textsConsig[1].setDocument(new FixedLengthDocument(100));
		textsConsig[2].setDocument(new FixedLengthDocument(20));
		textsConsig[3].setDocument(new FixedLengthDocument(50));
		textsConsig[5].setDocument(new FixedLengthDocument(200));
		textsConsig[6].setDocument(new FixedLengthDocument(100));
		textsConsig[7].setDocument(new FixedLengthDocument(100));
		textsConsig[8].setDocument(new FixedLengthDocument(30));
		for(int i=10;i<=15;i++)		textsConsig[i].setDocument(new FixedLengthDocument(150));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Adicionar Compra"))
		{
			String[] strings= new String[119];
			for(int i=0; i <=17;i++)		strings[i]=textsCompra[i].getText();
			if(strings[0]==null||strings[0].equals("")||strings[1]==null||strings[1].equals("")||strings[2]==null||strings[2].equals("")||strings[3]==null||strings[3].equals("")||strings[6]==null||strings[6].equals("")||strings[7]==null||strings[7].equals("")||strings[17]==null||strings[17].equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Faltam dados");
				return;
			}
			strings[118]= ""+ contador;
			int aux=0;
			for(int i=18;i<=2*contador+17;i++)
			{
				strings[i]=texts2[aux].getText();
				i++;
				strings[i]=texts3[aux].getText();
				aux++;
				if(strings[i-1]!=null&&!strings[i-1].equals("")&&(strings[i]==null||strings[i].equals("")))
				{
					JOptionPane.showMessageDialog(frame, "Falta Valor de novas Despesas");
					return;
				}
			}
			for(int i=2*contador+18;i<=117;i++)			strings[i]=null;
			aux=0;
			LogicaCadastro logcad = new LogicaCadastro(frame,con,strings);
			boolean valor=logcad.CadNovoVeiculo();
			if(valor==true)			JOptionPane.showMessageDialog(frame, "Veiculo Cadastrado");
			cadastro cad=new cadastro(frame,con);
			cad.cadastrar();
		}
		else if(source.getText().equals("Adicionar Consignação"))
		{
			String[] strings= new String[17];
			for(int i=0; i <=16;i++)		strings[i]=textsConsig[i].getText();
			if(strings[0]==null||strings[0].equals("")||strings[1]==null||strings[1].equals("")||strings[2]==null||strings[2].equals("")||strings[3]==null||strings[3].equals("")||strings[4]==null||strings[4].equals("")||strings[9]==null||strings[9].equals("")||strings[16]==null||strings[16].equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Faltam dados");
				return;
			}
			LogicaCadastro logcad = new LogicaCadastro(frame,con,strings);
			boolean valor=logcad.CadConsignado();
			if(valor==true)			JOptionPane.showMessageDialog(frame, "Veiculo Cadastrado");
			cadastro cad=new cadastro(frame,con);
			cad.cadastrar();
		}
		else if(source.getText().equals("Adicionar Despesas")&&contador<=49)
		{
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 500;
			int y = 100;
			texts2[contador]= new JTextField(20);
			texts3[contador]= new JFormattedTextField(integer);
			texts2[contador].setDocument(new FixedLengthDocument(150));
			panel.setLayout(new GridLayout( 50, 2 ) ); 
			panel2.setLayout(new GridLayout( 50, 2 ) ); 
			panel.add(texts2[contador]);
			panel2.add(texts3[contador]);
			scrollpane.revalidate();
			scrollpane.add(panel);
			scrollpane.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane);
		    scrollpane.setVisible(true);
		    scrollpane.setViewportView(panel);
		    scrollpane2.revalidate();
			scrollpane2.add(panel2);
			scrollpane2.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+500)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel2);
		    contador++;
			/*labels[0]= new JLabel("1-");
			labels[0].setFont(new Font("1-", Font.BOLD, (int)(13*ajustex)));
			labels[0].setBounds((int)(ajustex*x),(int)(ajustey*(y+500)),(int)(ajustex*20),(int)(ajustey*20));
			for(int i=0;i<=0;i++)		frame.getContentPane ().add (labels[i]);*/
			//for(int i=0;i<=1;i++)		frame.getContentPane ().add (texts[i]);
			frame.setVisible(true);
			frame.repaint();
		}
		else if(source.getText().equals("Remover Despesas")&&contador>=2)
		{
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 500;
			int y = 100;
			contador--;
			panel.remove(texts2[contador]);
			panel2.remove(texts3[contador]);
			scrollpane.revalidate();
			scrollpane.add(panel);
			scrollpane.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane);
		    scrollpane.setVisible(true);
		    scrollpane.setViewportView(panel);
		    scrollpane2.revalidate();
			scrollpane2.add(panel2);
			scrollpane2.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+500)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel2);
		    frame.setVisible(true);
			frame.repaint();
		}
		
	}

}