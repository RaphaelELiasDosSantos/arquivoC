package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DepesasIn implements ActionListener {
	JFrame frame;
	Connection con;
	public DepesasIn(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public JScrollPane scrollpane = new JScrollPane(null);
	public JScrollPane scrollpane2 = new JScrollPane(null);
	JTextField texts2[] = new JTextField[50];
	JFormattedTextField texts3[] = new JFormattedTextField[50];
	int contador=0;
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JFormattedTextField texts[] = new JFormattedTextField[16];
	DecimalFormat integer = new DecimalFormat("#"); 
	public void despesas()
	{
		integer.setMaximumIntegerDigits(10);
		frame.getContentPane ().removeAll();
		frame.setContentPane(new JPanel());
		frame.setLayout(null);
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize(); 
		final float ajustey = (float)tamTela.height/1080;
		final float ajustex = (float)tamTela.width/1920;
		int x = 500;
		int y = 100;
		final JComboBox comboB[] = new JComboBox[4];
		final JScrollPane scrollpane;
		JLabel labels[] = new JLabel[50];
		JButton botoes[] = new JButton[7]; 
		final JList lista[] = new JList[3];
		final String[] nula = {null};
		final JLabel[] labels2 = new JLabel[7];
		frame.getContentPane ().setBackground(new Color(220,220,255));
		JLabel labels4= new JLabel("Mostrar");
		labels4.setFont(new Font("Mostrar", Font.BOLD, (int)(18*ajustex)));
		labels4.setBounds((int)(ajustex*(1030)),(int)(ajustey*(70)),(int)(ajustex*150),(int)(ajustey*20));
		frame.getContentPane ().add (labels4);
		comboB[2] = new JComboBox(nula);
		comboB[2].setSelectedIndex(0);
		comboB[2].setBounds((int)(ajustex*(1030)),(int)(ajustey*170),(int)(ajustex*150),(int)(ajustey*20));
		frame.add(comboB[2]);
		labels2[5]= new JLabel("Mês");
		labels2[5].setFont(new Font("Mês", Font.BOLD, (int)(15*ajustex)));
		labels2[5].setBounds((int)(ajustex*(1080)),(int)(ajustey*125),(int)(ajustex*50),(int)(ajustey*50));
		frame.getContentPane ().add (labels2[5]);
		labels2[6]= new JLabel("Ano");
		labels2[6].setFont(new Font("Ano", Font.BOLD, (int)(15*ajustex)));
		labels2[6].setBounds((int)(ajustex*(1220)),(int)(ajustey*125),(int)(ajustex*50),(int)(ajustey*50));
		frame.getContentPane ().add (labels2[6]);
		labels2[4]= new JLabel("de");
		labels2[4].setFont(new Font("de", Font.BOLD, (int)(12*ajustex)));
		labels2[4].setBounds((int)(ajustex*(1185)),(int)(ajustey*170),(int)(ajustex*30),(int)(ajustey*20));
		frame.getContentPane ().add (labels2[4]);
		comboB[3] = new JComboBox(nula);
		comboB[3].setSelectedIndex(0);
		comboB[3].setBounds((int)(ajustex*(1210)),(int)(ajustey*170),(int)(ajustex*60),(int)(ajustey*20));
		frame.add(comboB[3]);
		frame.repaint();
		frame.setVisible(true);
		JLabel labels3= new JLabel("Despesas");
		labels3.setFont(new Font("Despesas", Font.BOLD, (int)(50*ajustex)));
		labels3.setBounds((int)(ajustex*(x+280)),(int)(ajustey*(-30)),(int)(ajustex*300),(int)(ajustey*130));
		frame.getContentPane ().add (labels3);
	    frame.getContentPane ().setBackground(new Color(220,220,255));
	    botoes[0]=new JButton("Efetuar");
	    botoes[0].setFont(new Font("Efetuar", Font.BOLD, (int)(13*ajustex)));
		botoes[0].setBounds( (int)(ajustex*(x+60)), (int)(ajustey*900),(int)(ajustex*200), (int)(ajustey*50) );
		botoes[0].addActionListener(this);
		frame.getContentPane ().add (botoes[0]);
		texts[0]= new JFormattedTextField(integer);
		texts[0].setBounds((int)(ajustex*(x+60)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
		labels[5]= new JLabel("Salario Func");
		labels[5].setFont(new Font("Salario Func", Font.BOLD, (int)(18*ajustex)));
		labels[5].setBounds((int)(ajustex*(x+110)),(int)(ajustey*70),(int)(ajustex*150),(int)(ajustey*20));
		labels[0]= new JLabel("Func1");
		labels[0].setFont(new Font("Func1", Font.BOLD, (int)(13*ajustex)));
		labels[0].setBounds((int)(ajustex*x),(int)(ajustey*y),(int)(ajustex*50),(int)(ajustey*20));
		texts[1]= new JFormattedTextField(integer);
		texts[1].setBounds((int)(ajustex*(x+60)),(int)(ajustey*(y+30)),(int)(ajustex*200),(int)(ajustey*20));
		labels[1]= new JLabel("Func2");
		labels[1].setFont(new Font("Func2", Font.BOLD, (int)(13*ajustex)));
		labels[1].setBounds((int)(ajustex*x),(int)(ajustey*(y+30)),(int)(ajustex*50),(int)(ajustey*20));
		texts[2]= new JFormattedTextField(integer);
		texts[2].setBounds((int)(ajustex*(x+60)),(int)(ajustey*(y+60)),(int)(ajustex*200),(int)(ajustey*20));
		labels[2]= new JLabel("Func3");
		labels[2].setFont(new Font("Func3", Font.BOLD, (int)(13*ajustex)));
		labels[2].setBounds((int)(ajustex*x),(int)(ajustey*(y+60)),(int)(ajustex*50),(int)(ajustey*20));
		labels[3]= new JLabel("1000");
		labels[3].setFont(new Font("1000", Font.BOLD, (int)(13*ajustex)));
		labels[3].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y)),(int)(ajustex*50),(int)(ajustey*20));
		labels[4]= new JLabel("3000");
		labels[4].setFont(new Font("3000", Font.BOLD, (int)(13*ajustex)));
		labels[4].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+30)),(int)(ajustex*50),(int)(ajustey*20));
		labels[6]= new JLabel("Depesas Indiretas");
		labels[6].setFont(new Font("Depesas Indiretas", Font.BOLD, (int)(18*ajustex)));
		labels[6].setBounds((int)(ajustex*(x+85)),(int)(ajustey*200),(int)(ajustex*180),(int)(ajustey*20));
		texts[3]= new JFormattedTextField(integer);
		texts[3].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+140)),(int)(ajustex*150),(int)(ajustey*20));
		labels[7]= new JLabel("Prolabore1");
		labels[7].setFont(new Font("Prolabore1", Font.BOLD, (int)(13*ajustex)));
		labels[7].setBounds((int)(ajustex*x),(int)(ajustey*(y+140)),(int)(ajustex*100),(int)(ajustey*20));
		labels[8]= new JLabel("10000");
		labels[8].setFont(new Font("10000", Font.BOLD, (int)(13*ajustex)));
		labels[8].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+140)),(int)(ajustex*50),(int)(ajustey*20));
		texts[4]= new JFormattedTextField(integer);
		texts[4].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+170)),(int)(ajustex*150),(int)(ajustey*20));
		labels[9]= new JLabel("Prolabore2");
		labels[9].setFont(new Font("Prolabore2", Font.BOLD, (int)(13*ajustex)));
		labels[9].setBounds((int)(ajustex*x),(int)(ajustey*(y+170)),(int)(ajustex*100),(int)(ajustey*20));
		labels[10]= new JLabel("10000");
		labels[10].setFont(new Font("10000", Font.BOLD, (int)(13*ajustex)));
		labels[10].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+170)),(int)(ajustex*50),(int)(ajustey*20));
		texts[5]= new JFormattedTextField(integer);
		texts[5].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+200)),(int)(ajustex*150),(int)(ajustey*20));
		labels[11]= new JLabel("Agua");
		labels[11].setFont(new Font("Agua", Font.BOLD, (int)(13*ajustex)));
		labels[11].setBounds((int)(ajustex*x),(int)(ajustey*(y+200)),(int)(ajustex*100),(int)(ajustey*20));
		labels[12]= new JLabel("100");
		labels[12].setFont(new Font("100", Font.BOLD, (int)(13*ajustex)));
		labels[12].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+200)),(int)(ajustex*50),(int)(ajustey*20));
		texts[6]= new JFormattedTextField(integer);
		texts[6].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+230)),(int)(ajustex*150),(int)(ajustey*20));
		labels[13]= new JLabel("Luz");
		labels[13].setFont(new Font("Luz", Font.BOLD, (int)(13*ajustex)));
		labels[13].setBounds((int)(ajustex*x),(int)(ajustey*(y+230)),(int)(ajustex*100),(int)(ajustey*20));
		labels[14]= new JLabel("300");
		labels[14].setFont(new Font("300", Font.BOLD, (int)(13*ajustex)));
		labels[14].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+230)),(int)(ajustex*50),(int)(ajustey*20));
		texts[7]= new JFormattedTextField(integer);
		texts[7].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+260)),(int)(ajustex*150),(int)(ajustey*20));
		labels[15]= new JLabel("Telefone");
		labels[15].setFont(new Font("Telefone", Font.BOLD, (int)(13*ajustex)));
		labels[15].setBounds((int)(ajustex*x),(int)(ajustey*(y+260)),(int)(ajustex*100),(int)(ajustey*20));
		labels[16]= new JLabel("1000");
		labels[16].setFont(new Font("1000", Font.BOLD, (int)(13*ajustex)));
		labels[16].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+260)),(int)(ajustex*50),(int)(ajustey*20));
		texts[8]= new JFormattedTextField(integer);
		texts[8].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+290)),(int)(ajustex*150),(int)(ajustey*20));
		labels[17]= new JLabel("Contador");
		labels[17].setFont(new Font("Contador", Font.BOLD, (int)(13*ajustex)));
		labels[17].setBounds((int)(ajustex*x),(int)(ajustey*(y+290)),(int)(ajustex*100),(int)(ajustey*20));
		labels[18]= new JLabel("1000");
		labels[18].setFont(new Font("1000", Font.BOLD, (int)(13*ajustex)));
		labels[18].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+290)),(int)(ajustex*50),(int)(ajustey*20));
		texts[9]= new JFormattedTextField(integer);
		texts[9].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+320)),(int)(ajustex*150),(int)(ajustey*20));
		labels[19]= new JLabel("Nota fiscal");
		labels[19].setFont(new Font("Nota fiscal", Font.BOLD, (int)(13*ajustex)));
		labels[19].setBounds((int)(ajustex*x),(int)(ajustey*(y+320)),(int)(ajustex*100),(int)(ajustey*20));
		labels[20]= new JLabel("2000");
		labels[20].setFont(new Font("2000", Font.BOLD, (int)(13*ajustex)));
		labels[20].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+320)),(int)(ajustex*50),(int)(ajustey*20));
		texts[10]= new JFormattedTextField(integer);
		texts[10].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+350)),(int)(ajustex*150),(int)(ajustey*20));
		labels[21]= new JLabel("Manutenção");
		labels[21].setFont(new Font("Manutenção", Font.BOLD, (int)(13*ajustex)));
		labels[21].setBounds((int)(ajustex*x),(int)(ajustey*(y+350)),(int)(ajustex*100),(int)(ajustey*20));
		labels[22]= new JLabel("500");
		labels[22].setFont(new Font("500", Font.BOLD, (int)(13*ajustex)));
		labels[22].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+350)),(int)(ajustex*50),(int)(ajustey*20));
		texts[11]= new JFormattedTextField(integer);
		texts[11].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+380)),(int)(ajustex*150),(int)(ajustey*20));
		labels[23]= new JLabel("Impressos");
		labels[23].setFont(new Font("Impressos", Font.BOLD, (int)(13*ajustex)));
		labels[23].setBounds((int)(ajustex*x),(int)(ajustey*(y+380)),(int)(ajustex*100),(int)(ajustey*20));
		labels[24]= new JLabel("100");
		labels[24].setFont(new Font("100", Font.BOLD, (int)(13*ajustex)));
		labels[24].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+380)),(int)(ajustex*50),(int)(ajustey*20));
		texts[12]= new JFormattedTextField(integer);
		texts[12].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+410)),(int)(ajustex*150),(int)(ajustey*20));
		labels[25]= new JLabel("P. de Limpeza");
		labels[25].setFont(new Font("Prod de Limpeza", Font.BOLD, (int)(13*ajustex)));
		labels[25].setBounds((int)(ajustex*x),(int)(ajustey*(y+410)),(int)(ajustex*100),(int)(ajustey*20));
		labels[26]= new JLabel("200");
		labels[26].setFont(new Font("200", Font.BOLD, (int)(13*ajustex)));
		labels[26].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+410)),(int)(ajustex*50),(int)(ajustey*20));
		texts[13]= new JFormattedTextField(integer);
		texts[13].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+440)),(int)(ajustex*150),(int)(ajustey*20));
		labels[27]= new JLabel("Anuncios");
		labels[27].setFont(new Font("Anuncios", Font.BOLD, (int)(13*ajustex)));
		labels[27].setBounds((int)(ajustex*x),(int)(ajustey*(y+440)),(int)(ajustex*100),(int)(ajustey*20));
		labels[28]= new JLabel("500");
		labels[28].setFont(new Font("500", Font.BOLD, (int)(13*ajustex)));
		labels[28].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+440)),(int)(ajustex*50),(int)(ajustey*20));
		texts[14]= new JFormattedTextField(integer);
		texts[14].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+470)),(int)(ajustex*150),(int)(ajustey*20));
		labels[29]= new JLabel("Acic");
		labels[29].setFont(new Font("Acic", Font.BOLD, (int)(13*ajustex)));
		labels[29].setBounds((int)(ajustex*x),(int)(ajustey*(y+470)),(int)(ajustex*100),(int)(ajustey*20));
		labels[30]= new JLabel("300");
		labels[30].setFont(new Font("300", Font.BOLD, (int)(13*ajustex)));
		labels[30].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+470)),(int)(ajustex*50),(int)(ajustey*20));
		texts[15]= new JFormattedTextField(integer);
		texts[15].setBounds((int)(ajustex*(x+110)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*20));
		labels[31]= new JLabel("Consultas");
		labels[31].setFont(new Font("Consultas", Font.BOLD, (int)(13*ajustex)));
		labels[31].setBounds((int)(ajustex*x),(int)(ajustey*(y+500)),(int)(ajustex*100),(int)(ajustey*20));
		labels[32]= new JLabel("500");
		labels[32].setFont(new Font("500", Font.BOLD, (int)(13*ajustex)));
		labels[32].setBounds((int)(ajustex*(x+280)),(int)(ajustey*(y+500)),(int)(ajustex*50),(int)(ajustey*20));
		labels[33]= new JLabel("Outros");
		labels[33].setFont(new Font("Outros", Font.BOLD, (int)(18*ajustex)));
		labels[33].setBounds((int)(ajustex*(x+110)),(int)(ajustey*640),(int)(ajustex*150),(int)(ajustey*20));
		labels[34]= new JLabel("Descrição");
		labels[34].setFont(new Font("Descrição", Font.BOLD, (int)(13*ajustex)));
		labels[34].setBounds((int)(ajustex*(x+30)),(int)(ajustey*(y+570)),(int)(ajustex*90),(int)(ajustey*20));
		labels[35]= new JLabel("Valor (R$)");
		labels[35].setFont(new Font("Valor (R$)", Font.BOLD, (int)(13*ajustex)));
		labels[35].setBounds((int)(ajustex*(x+190)),(int)(ajustey*(y+570)),(int)(ajustex*120),(int)(ajustey*20));
		botoes[1] = new JButton("Adicionar Despesas");
		botoes[1].setFont(new Font("Adicionar Despesas", Font.BOLD, (int)(13*ajustex)));
		botoes[1].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+600)),(int)(ajustex*190), (int)(ajustey*30) );
		botoes[1].addActionListener(this);
		frame.getContentPane ().add (botoes[1]);
		botoes[2] = new JButton("Remover Despesas");
		botoes[2].setFont(new Font("Remover Despesas", Font.BOLD, (int)(13*ajustex)));
		botoes[2].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+750)),(int)(ajustex*190), (int)(ajustey*30) );
		botoes[2].addActionListener(this);
		frame.getContentPane ().add (botoes[2]);
		for(int i=0;i<=35;i++)				frame.getContentPane ().add (labels[i]);
		for(int i=0;i<=15;i++)				frame.getContentPane ().add (texts[i]);
		escreveDesp();
		scrollpane= new JScrollPane(null);
		lista[0] = new JList(nula);
		final LogicaDespesasIn desps;
		desps=new LogicaDespesasIn(frame,con);
		final String meses[]=desps.MesDesp();
		DefaultComboBoxModel model = new DefaultComboBoxModel( meses);
		comboB[2].setModel(model);
		comboB[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(comboB[2].getSelectedIndex()>0)
				{
					final String anos[] = desps.AnoDesp(meses[comboB[2].getSelectedIndex()]);
					DefaultComboBoxModel model2 = new DefaultComboBoxModel(anos);
					comboB[3].setModel(model2);
					frame.repaint();
					frame.setVisible(true);
					comboB[3].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(comboB[2].getSelectedIndex()>0&&comboB[3].getSelectedIndex()>0)
							{
									String strFinal[]=desps.ProcuraDesp(meses[comboB[2].getSelectedIndex()],anos[comboB[3].getSelectedIndex()]);
									lista[0].setListData(strFinal);
									scrollpane.revalidate();
									scrollpane.add(lista[0]);
									scrollpane.setBounds((int)(ajustex*(1400)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
								    frame.add(scrollpane);
								    scrollpane.setVisible(true);
								    scrollpane.setViewportView(lista[0]);
								    frame.setVisible(true);
									frame.repaint();
							}
						}
					});
				}
			}
		});
		frame.setVisible(true);
		frame.repaint();
	}
	public void escreveDesp()
	{
	    LogicaDespesasIn desps= new LogicaDespesasIn(frame,con);
	    String strFinal[]=desps.ProcuraDespAtual();
	    if(strFinal==null)						return;
	    else
	    {
	    	java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
	    	Dimension tamTela= toolkit.getScreenSize();
			final float ajustey = (float)tamTela.height/1080;
			final float ajustex = (float)tamTela.width/1920;
			int x=500;
			int y=100;
			contador= Integer.parseInt(strFinal[117]);
			for(int i=0;i<contador;i++)
				{
					texts2[i]= new JTextField(150);
					texts2[i].setDocument(new FixedLengthDocument(150));
					panel.add(texts2[i]);
					texts3[i]= new JFormattedTextField(integer);
					panel2.add(texts3[i]);
				}
			panel.setLayout(new GridLayout( 50, 2 ) ); 
			panel2.setLayout(new GridLayout( 50, 2 ) ); 
			scrollpane.revalidate();
			scrollpane.add(panel);
			scrollpane.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+640)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane);
		    scrollpane.setVisible(true);
		    scrollpane.setViewportView(panel);
		    scrollpane2.revalidate();
			scrollpane2.add(panel2);
			scrollpane2.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+640)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel2);
		    int aux=0;
		    for(int i=16;i<16+2*contador;i=i+2)
		    {
		    	if(strFinal[i+1]!=null&&strFinal[i+1]!="")			texts2[aux].setText(strFinal[i+1]);
		    	aux++;
		    }
		    aux=0;
			for(int i=17;i<17+2*contador;i=i+2)
			{
				if(strFinal[i+1]!=null&&strFinal[i+1]!="")			texts3[aux].setText(strFinal[i+1]);
				aux++;
			}
			for(int i=0;i<=15;i++)
			{
				if(strFinal[i+1]!=null&&strFinal[i+1]!="")			texts[i].setText(strFinal[i+1]);
			}
	    }
	}
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Efetuar"))
		{
			LogicaDespesasIn desps= new LogicaDespesasIn(frame,con);
		    String strFinal[]=desps.ProcuraDespAtual();
		    if(strFinal!=null)
		    {
		    	desps.removeDespAtual();
		    }
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;  
		    int year = cal.get(Calendar.YEAR);  
			String[] strings= new String[119];
			for(int i=0; i <=15;i++)		strings[i]=texts[i].getText();
			strings[116]= ""+ contador;
			strings[117]= "" + month;
			strings[118]= "" + year;
			int aux=0;
			for(int i=16;i<=2*contador+15;i++)
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
			for(int i=2*contador+16;i<=115;i++)			strings[i]=null;
			aux=0;
			desps.AddDesp(strings);
			JOptionPane.showMessageDialog(frame, "Efetuado");
			DepesasIn despIn = new DepesasIn(frame,con);
			despIn.despesas();
		}
		if(source.getText().equals("Adicionar Despesas"))
		{
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 500;
			int y = 100;
			texts2[contador]= new JTextField(20);
			texts2[contador].setDocument(new FixedLengthDocument(150));
			texts3[contador]= new JFormattedTextField(integer);
			panel.setLayout(new GridLayout( 50, 2 ) ); 
			panel2.setLayout(new GridLayout( 50, 2 ) ); 
			panel.add(texts2[contador]);
			panel2.add(texts3[contador]);
			scrollpane.revalidate();
			scrollpane.add(panel);
			scrollpane.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+640)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane);
		    scrollpane.setVisible(true);
		    scrollpane.setViewportView(panel);
		    scrollpane2.revalidate();
			scrollpane2.add(panel2);
			scrollpane2.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+640)),(int)(ajustex*120),(int)(ajustey*(100)));
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
			scrollpane.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+640)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane);
		    scrollpane.setVisible(true);
		    scrollpane.setViewportView(panel);
		    scrollpane2.revalidate();
			scrollpane2.add(panel2);
			scrollpane2.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+640)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel2);
		    frame.setVisible(true);
			frame.repaint();
		}
		
	}

}
