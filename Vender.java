package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
public class Vender implements ActionListener {
	JFrame frame;
	Connection con;
	public Vender(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public JFormattedTextField texts[] = new JFormattedTextField[34];
	public String VeiculoVendido;
	DecimalFormat integer = new DecimalFormat("#"); 
	public void venda()
	{
		integer.setMaximumIntegerDigits(10);
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize();
		frame.getContentPane ().removeAll();
		frame.setContentPane(new JPanel());
		frame.setLayout(null);
		final JComboBox comboB[] = new JComboBox[4];
		final JScrollPane scrollpane;
		final float ajustey = (float)tamTela.height/1080;
		final float ajustex = (float)tamTela.width/1920;
		final JList lista[] = new JList[3];
		final String[] nula = {null};
		final JLabel[] labels2 = new JLabel[5];
		final JButton botao = new JButton("Adicionar Venda");
		final JButton botao2 = new JButton("Limpar Tela");
		final JLabel labels[] = new JLabel[30];
		final LogicaMostrar mostr = new LogicaMostrar(frame,con);
		String str[]=mostr.MostraCompras();
		String str2[]=mostr.MostraConsignados();
		final String  str3[] = mostr.concatena(str,str2);
		frame.getContentPane ().setBackground(new Color(220,220,255));
		JLabel labels3= new JLabel("Vender");
		labels3.setFont(new Font("Vender", Font.BOLD, (int)(50*ajustex)));
		labels3.setBounds((int)(ajustex*(920)),(int)(ajustey*(-30)),(int)(ajustex*300),(int)(ajustey*130));
		frame.getContentPane ().add (labels3);
		labels2[0]= new JLabel("Veículo");
		labels2[0].setFont(new Font("Veículo", Font.BOLD, (int)(18*ajustex)));
		labels2[0].setBounds((int)(ajustex*(100)),(int)(ajustey*70),(int)(ajustex*200),(int)(ajustey*20));
		comboB[0] = new JComboBox(str3);
		comboB[0].setSelectedIndex(0);
		comboB[0].setBounds((int)(ajustex*(100)),(int)(ajustey*100),(int)(ajustex*350),(int)(ajustey*20));
		frame.add(comboB[0]);
		scrollpane= new JScrollPane(null);
		lista[0] = new JList(nula);
		labels[1]=null;
		comboB[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboB[0].getSelectedIndex()>=0)
				{
					VeiculoVendido=str3[comboB[0].getSelectedIndex()];
					String strFinal[]= mostr.ProcuraEstoque(str3[comboB[0].getSelectedIndex()]);
					lista[0].setListData(strFinal);
					if(labels[1]!=null)
					{
						for(int i=1;i<=13;i++)
						{
							labels[i].setVisible(false);
						}
						for(int i=1;i<=10;i++)
						{
							texts[i].setVisible(false);
						}
					}
					scrollpane.revalidate();
					scrollpane.add(lista[0]);
					scrollpane.setBounds((int)(ajustex*(550)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
				    frame.add(scrollpane);
				    scrollpane.setVisible(true);
				    scrollpane.setViewportView(lista[0]);
				    frame.setVisible(true);
					frame.repaint();
					labels2[1]= new JLabel("= >");
					labels2[1].setFont(new Font("= >", Font.BOLD, (int)(28*ajustex)));
					labels2[1].setBounds((int)(ajustex*(900)),(int)(ajustey*350),(int)(ajustex*100),(int)(ajustey*100));
					frame.getContentPane ().add (labels2[1]);
					int x=100;
					int aux = x +1000;
					labels[1]= new JLabel("Venda");
					labels[1].setFont(new Font("Venda", Font.BOLD, (int)(18*ajustex)));
					labels[1].setBounds((int)(ajustex*(90+aux)),(int)(ajustey*90),(int)(ajustex*150),(int)(ajustey*20));
					texts[1]= new JFormattedTextField(integer);
					texts[1].setBounds((int)(ajustex*(140+aux)),(int)(ajustey*130),(int)(ajustex*120),(int)(ajustey*20));
					labels[2]= new JLabel("Garantia em dias");
					labels[2].setFont(new Font("Garantia em dias", Font.BOLD, (int)(13*ajustex)));
					labels[2].setBounds((int)(ajustex*(aux)),(int)(ajustey*130),(int)(ajustex*150),(int)(ajustey*20));
					texts[2]= new JFormattedTextField(integer);
					texts[2].setBounds((int)(ajustex*(aux+140)),(int)(ajustey*160),(int)(ajustex*120),(int)(ajustey*20));
					labels[3]= new JLabel("Valor da Venda (R$)");
					labels[3].setFont(new Font("Valor da venda", Font.BOLD, (int)(13*ajustex)));
					labels[3].setBounds((int)(ajustex*(aux)),(int)(ajustey*160),(int)(ajustex*130),(int)(ajustey*20));
					labels[4]= new JLabel("Comprador");
					labels[4].setFont(new Font("Comprador", Font.BOLD, (int)(15*ajustex)));
					labels[4].setBounds((int)(ajustex*(aux+90)),(int)(ajustey*185),(int)(ajustex*130),(int)(ajustey*30));
					texts[3]= new JFormattedTextField();
					texts[3].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*220),(int)(ajustex*190),(int)(ajustey*20));
					labels[5]= new JLabel("Nome");
					labels[5].setFont(new Font("Nome", Font.BOLD, (int)(13*ajustex)));
					labels[5].setBounds((int)(ajustex*(aux)),(int)(ajustey*220),(int)(ajustex*50),(int)(ajustey*20));
					labels[6]= new JLabel("Telefone");
					labels[6].setFont(new Font("Telefone", Font.BOLD, (int)(13*ajustex)));
					labels[6].setBounds((int)(ajustex*(aux)),(int)(ajustey*250),(int)(ajustex*100),(int)(ajustey*20));
					texts[4]= new JFormattedTextField();
					texts[4].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*250),(int)(ajustex*190),(int)(ajustey*20));
					labels[7]= new JLabel("Endereço");
					labels[7].setFont(new Font("Endereço", Font.BOLD, (int)(13*ajustex)));
					labels[7].setBounds((int)(ajustex*(aux)),(int)(ajustey*280),(int)(ajustex*80),(int)(ajustey*20));
					texts[5]= new JFormattedTextField();
					texts[5].setBounds((int)(ajustex*(aux+70)),(int)(ajustey*280),(int)(ajustex*190),(int)(ajustey*20));
					labels[8]= new JLabel("Cidade");
					labels[8].setFont(new Font("Cidade", Font.BOLD, (int)(13*ajustex)));
					labels[8].setBounds((int)(ajustex*(aux)),(int)(ajustey*310),(int)(ajustex*60),(int)(ajustey*20));
					texts[6]= new JFormattedTextField();
					texts[6].setBounds((int)(ajustex*(aux+70)),(int)(ajustey*310),(int)(ajustex*190),(int)(ajustey*20));
					labels[9]= new JLabel("Email");
					labels[9].setFont(new Font("Email", Font.BOLD, (int)(13*ajustex)));
					labels[9].setBounds((int)(ajustex*(aux)),(int)(ajustey*340),(int)(ajustex*50),(int)(ajustey*20));
					texts[7]= new JFormattedTextField();
					texts[7].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*340),(int)(ajustex*190),(int)(ajustey*20));
					labels[10]= new JLabel("Observações");
					labels[10].setFont(new Font("Observações", Font.BOLD, (int)(15*ajustex)));
					labels[10].setBounds((int)(ajustex*(aux+90)),(int)(ajustey*365),(int)(ajustex*100),(int)(ajustey*20));
					labels[11]= new JLabel("1-");
					labels[11].setFont(new Font("1-", Font.BOLD, (int)(13*ajustex)));
					labels[11].setBounds((int)(ajustex*(aux)),(int)(ajustey*390),(int)(ajustex*20),(int)(ajustey*20));
					texts[8]= new JFormattedTextField();
					texts[8].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*390),(int)(ajustex*240),(int)(ajustey*20));
					labels[12]= new JLabel("2-");
					labels[12].setFont(new Font("2-", Font.BOLD, (int)(13*ajustex)));
					labels[12].setBounds((int)(ajustex*(aux)),(int)(ajustey*410),(int)(ajustex*20),(int)(ajustey*20));
					texts[9]= new JFormattedTextField();
					texts[9].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*410),(int)(ajustex*240),(int)(ajustey*20));
					labels[13]= new JLabel("3-");
					labels[13].setFont(new Font("3-", Font.BOLD, (int)(13*ajustex)));
					labels[13].setBounds((int)(ajustex*(aux)),(int)(ajustey*430),(int)(ajustex*20),(int)(ajustey*20));
					texts[10]= new JFormattedTextField();
					texts[10].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*430),(int)(ajustex*240),(int)(ajustey*20));
					//SEGUE O EXEMPLO!
					//texts[33].setText("595959");
					//
					for(int i=1;i<=13;i++)
					{
						frame.getContentPane ().add (labels[i]);
					}
					for(int i=1;i<=10;i++)
					{
						frame.getContentPane ().add (texts[i]);
					}
					botao.setFont(new Font("Adicionar Venda", Font.BOLD, (int)(13*ajustex)));
					botao.setBounds( (int)(ajustex*(aux+60)), (int)(ajustey*480),(int)(ajustex*200), (int)(ajustey*50) );
					frame.getContentPane ().add (botao);
					botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
					botao2.setBounds( (int)(ajustex*(aux+60)), (int)(ajustey*570),(int)(ajustex*200), (int)(ajustey*50) );
					frame.getContentPane ().add (botao2);
					frame.setVisible(true);
					frame.repaint();
					texts[3].setDocument(new FixedLengthDocument(150));
					texts[4].setDocument(new FixedLengthDocument(100));
					texts[5].setDocument(new FixedLengthDocument(100));
					texts[6].setDocument(new FixedLengthDocument(30));
					texts[7].setDocument(new FixedLengthDocument(100));
					texts[8].setDocument(new FixedLengthDocument(400));
					texts[9].setDocument(new FixedLengthDocument(400));
					texts[10].setDocument(new FixedLengthDocument(400));
					
				}
			}
		});
		for(int i=0;i<=0;i++)				frame.getContentPane ().add (labels2[i]);
		botao2.addActionListener(this);
		botao.addActionListener(this);
		frame.setVisible(true);
		frame.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Limpar Tela"))
		{
			Vender venda= new Vender(frame,con);
			venda.venda();
		}
		else if(source.getText().equals("Adicionar Venda"))
		{
			String[] strings= new String[18];
			LogicaMostrar mostr = new LogicaMostrar(frame,con);
			String strFinal[]= mostr.ProcuraEstoque2(VeiculoVendido);
			String valorV = mostr.ValordeVenda(VeiculoVendido);
			for(int i=0;i<=3;i++)			strings[i]=strFinal[i+1];
			strings[4]=valorV;
			for(int i=5; i <=14;i++)		strings[i]=texts[i-4].getText();
			if(strings[6]==null||strings[6].equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Falta Valor de Venda");
				return;
			}
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;  
		    int year = cal.get(Calendar.YEAR);  
		    int dia = cal.get(Calendar.DAY_OF_MONTH);
		    strings[15]=""+ month;
		    strings[16]=""+ year;
		    strings[17]="" +dia;
			LogicaVenda logvend = new LogicaVenda(frame,con);
			logvend.venda(strings);
			LogicaRemover remove= new LogicaRemover(frame,con);
			remove.RemoveEstoque(VeiculoVendido);
			JOptionPane.showMessageDialog(frame, "Veiculo Vendido");
			Vender venda= new Vender(frame,con);
			venda.venda();
		}
	}
}
