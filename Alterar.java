package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.ParseException;

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
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.SimpleAttributeSet;

public class Alterar implements ActionListener {

	JFrame frame;
	Connection con;
	public Alterar(JFrame fram,Connection con){
		frame=fram;
		this.con=con;
	}
	public boolean entrou;
	public JScrollPane scrollpane2 = new JScrollPane(null);
	public JScrollPane scrollpane3 = new JScrollPane(null);
	JTextField texts2[] = new JTextField[50];
	JFormattedTextField texts3[] = new JFormattedTextField[50];
	JFormattedTextField textsCompra[] = new JFormattedTextField[18];
	JFormattedTextField textsConsig[] = new JFormattedTextField[18];
	JFormattedTextField textsVenda[] = new JFormattedTextField[18];
	int contador=0;
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	String Veiculo;
	int option;
	DecimalFormat integer = new DecimalFormat("#");
	MaskFormatter forData = null;//campo para data
	public void altera()
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
		final String[] dados = {null,"Veiculos comprados","Veiculos Consignados","Vendas"};
		final String[] nula = {null};
		final JLabel[] labels2 = new JLabel[7];
		final JButton botao = new JButton("Alterar");
		final JButton botao2 = new JButton("Limpar Tela");
		final JButton botoes[] = new JButton[2]; 
		botoes[0]=new JButton("Adicionar Despesas");
		botoes[1]=new JButton("Remover Despesas");
		try {
			forData = new MaskFormatter("##/##/####");
			forData.setValidCharacters("0123456789"); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		entrou=false;
		frame.getContentPane ().setBackground(new Color(220,220,255));
		JLabel labels3= new JLabel("Alterar");
		labels3.setFont(new Font("Alterar", Font.BOLD, (int)(50*ajustex)));
		labels3.setBounds((int)(ajustex*(780)),(int)(ajustey*(-30)),(int)(ajustex*300),(int)(ajustey*130));
		frame.getContentPane ().add (labels3);
		labels2[4]=null;
		labels2[5]=null;
		labels2[6]=null;
		comboB[2]=null;
		comboB[3]=null;
		labels2[0]= new JLabel("Tipos de alterações");
		labels2[0].setFont(new Font("Tipos de alterações", Font.BOLD, (int)(18*ajustex)));
		labels2[0].setBounds((int)(ajustex*(10)),(int)(ajustey*70),(int)(ajustex*200),(int)(ajustey*20));
		comboB[0] = new JComboBox(dados);
		comboB[0].setSelectedIndex(0);
		comboB[0].setBounds((int)(ajustex*(10)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
		frame.add(comboB[0]);
		labels2[1]= new JLabel("Item a ser alterado");
		labels2[1].setFont(new Font("Item a ser alterado", Font.BOLD, (int)(18*ajustex)));
		labels2[1].setBounds((int)(ajustex*(500)),(int)(ajustey*70),(int)(ajustex*200),(int)(ajustey*20));
		comboB[1] = new JComboBox(nula);
		comboB[1].setSelectedIndex(0);
		comboB[1].setBounds((int)(ajustex*(500)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
		frame.add(comboB[1]);
		scrollpane= new JScrollPane(null);
		lista[0] = new JList(nula);
		comboB[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboB[2]==null&&comboB[0].getSelectedIndex()==3)
				{
					DefaultComboBoxModel model = new DefaultComboBoxModel(nula);
					comboB[1].setModel(model);
					final LogicaMostrar mostr = new LogicaMostrar(frame,con);
					final String meses[]=mostr.MesesDisponiveisVenda();
					comboB[2] = new JComboBox(meses);
					comboB[2].setSelectedIndex(0);
					comboB[2].setBounds((int)(ajustex*(230)),(int)(ajustey*100),(int)(ajustex*150),(int)(ajustey*20));
					frame.add(comboB[2]);
					labels2[5]= new JLabel("Mês");
					labels2[5].setFont(new Font("Mês", Font.BOLD, (int)(15*ajustex)));
					labels2[5].setBounds((int)(ajustex*(280)),(int)(ajustey*55),(int)(ajustex*50),(int)(ajustey*50));
					frame.getContentPane ().add (labels2[5]);
					labels2[6]= new JLabel("Ano");
					labels2[6].setFont(new Font("Ano", Font.BOLD, (int)(15*ajustex)));
					labels2[6].setBounds((int)(ajustex*(420)),(int)(ajustey*55),(int)(ajustex*50),(int)(ajustey*50));
					frame.getContentPane ().add (labels2[6]);
					labels2[4]= new JLabel("De");
					labels2[4].setFont(new Font("De", Font.BOLD, (int)(12*ajustex)));
					labels2[4].setBounds((int)(ajustex*(385)),(int)(ajustey*100),(int)(ajustex*30),(int)(ajustey*20));
					frame.getContentPane ().add (labels2[4]);
					comboB[3] = new JComboBox(nula);
					comboB[3].setSelectedIndex(0);
					comboB[3].setBounds((int)(ajustex*(410)),(int)(ajustey*100),(int)(ajustex*60),(int)(ajustey*20));
					frame.add(comboB[3]);
					frame.repaint();
					frame.setVisible(true);
					comboB[2].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {	
							if(comboB[2].getSelectedIndex()>0&&comboB[0].getSelectedIndex()>0)
							{
								final String anos[] = mostr.AnosDisponiveisVenda(meses[comboB[2].getSelectedIndex()]);
								DefaultComboBoxModel model2 = new DefaultComboBoxModel( anos);
								comboB[3].setModel(model2);
								frame.repaint();
								frame.setVisible(true);
								comboB[3].addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {	
										if(comboB[3].getSelectedIndex()>0&&comboB[2].getSelectedIndex()>0&&comboB[0].getSelectedIndex()>0)
										{
											final String dados[]=mostr.ProcuraVendas(meses[comboB[2].getSelectedIndex()],anos[comboB[3].getSelectedIndex()]);
											DefaultComboBoxModel model = new DefaultComboBoxModel(dados);
											comboB[1].setModel(model);
											comboB[1].addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													if(entrou==false)
													{
														if(comboB[1].getSelectedIndex()>0&&comboB[3].getSelectedIndex()>0&&comboB[2].getSelectedIndex()>0&&comboB[0].getSelectedIndex()>0)
														{
															entrou=true;
															option=3;
															Veiculo = dados[comboB[1].getSelectedIndex()];
															String strFinal[]=mostr.ProcuraVendporPlaca(dados[comboB[1].getSelectedIndex()]);
															lista[0].setListData(strFinal);
															comboB[2].setVisible(false);
															comboB[3].setVisible(false);
															comboB[0].setVisible(false);
															comboB[1].setVisible(false);
															comboB[1].removeAllItems();
															labels2[4].setVisible(false);
															labels2[5].setVisible(false);
															labels2[6].setVisible(false);
															labels2[0].setVisible(false);
															labels2[1].setVisible(false);
															scrollpane.revalidate();
															scrollpane.add(lista[0]);
															scrollpane.setBounds((int)(ajustex*(400)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
														    frame.add(scrollpane);
														    scrollpane.setVisible(true);
														    scrollpane.setViewportView(lista[0]);
														    frame.setVisible(true);
															frame.repaint();
														    labels2[2]= new JLabel("= >");
															labels2[2].setFont(new Font("= >", Font.BOLD, (int)(28*ajustex)));
															labels2[2].setBounds((int)(ajustex*(820)),(int)(ajustey*250),(int)(ajustex*100),(int)(ajustey*100));
															frame.getContentPane ().add (labels2[2]);
															int x=100;
															int aux = x +850;
															JLabel labels[] = new JLabel[30];
															labels[1]= new JLabel("Venda");
															labels[1].setFont(new Font("Venda", Font.BOLD, (int)(18*ajustex)));
															labels[1].setBounds((int)(ajustex*(90+aux)),(int)(ajustey*90),(int)(ajustex*150),(int)(ajustey*20));
															textsVenda[1]= new JFormattedTextField(integer);
															textsVenda[1].setBounds((int)(ajustex*(140+aux)),(int)(ajustey*130),(int)(ajustex*120),(int)(ajustey*20));
															labels[2]= new JLabel("Tempo de Garantia");
															labels[2].setFont(new Font("Tempo de Garantia", Font.BOLD, (int)(13*ajustex)));
															labels[2].setBounds((int)(ajustex*(aux)),(int)(ajustey*130),(int)(ajustex*150),(int)(ajustey*20));
															textsVenda[2]= new JFormattedTextField(integer);
															textsVenda[2].setBounds((int)(ajustex*(aux+140)),(int)(ajustey*160),(int)(ajustex*120),(int)(ajustey*20));
															labels[3]= new JLabel("Valor da Venda (R$)");
															labels[3].setFont(new Font("Valor da Venda", Font.BOLD, (int)(13*ajustex)));
															labels[3].setBounds((int)(ajustex*(aux)),(int)(ajustey*160),(int)(ajustex*130),(int)(ajustey*20));
															labels[4]= new JLabel("Comprador");
															labels[4].setFont(new Font("Comprador", Font.BOLD, (int)(15*ajustex)));
															labels[4].setBounds((int)(ajustex*(aux+90)),(int)(ajustey*185),(int)(ajustex*130),(int)(ajustey*30));
															textsVenda[3]= new JFormattedTextField();
															textsVenda[3].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*220),(int)(ajustex*190),(int)(ajustey*20));
															labels[5]= new JLabel("Nome");
															labels[5].setFont(new Font("Nome", Font.BOLD, (int)(13*ajustex)));
															labels[5].setBounds((int)(ajustex*(aux)),(int)(ajustey*220),(int)(ajustex*50),(int)(ajustey*20));
															labels[6]= new JLabel("Telefone");
															labels[6].setFont(new Font("Telefone", Font.BOLD, (int)(13*ajustex)));
															labels[6].setBounds((int)(ajustex*(aux)),(int)(ajustey*250),(int)(ajustex*100),(int)(ajustey*20));
															textsVenda[4]= new JFormattedTextField();
															textsVenda[4].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*250),(int)(ajustex*190),(int)(ajustey*20));
															labels[7]= new JLabel("Endereço");
															labels[7].setFont(new Font("Endereço", Font.BOLD, (int)(13*ajustex)));
															labels[7].setBounds((int)(ajustex*(aux)),(int)(ajustey*280),(int)(ajustex*80),(int)(ajustey*20));
															textsVenda[5]= new JFormattedTextField();
															textsVenda[5].setBounds((int)(ajustex*(aux+70)),(int)(ajustey*280),(int)(ajustex*190),(int)(ajustey*20));
															labels[8]= new JLabel("Cidade");
															labels[8].setFont(new Font("Cidade", Font.BOLD, (int)(13*ajustex)));
															labels[8].setBounds((int)(ajustex*(aux)),(int)(ajustey*310),(int)(ajustex*60),(int)(ajustey*20));
															textsVenda[6]= new JFormattedTextField();
															textsVenda[6].setBounds((int)(ajustex*(aux+70)),(int)(ajustey*310),(int)(ajustex*190),(int)(ajustey*20));
															labels[9]= new JLabel("Email");
															labels[9].setFont(new Font("Email", Font.BOLD, (int)(13*ajustex)));
															labels[9].setBounds((int)(ajustex*(aux)),(int)(ajustey*340),(int)(ajustex*50),(int)(ajustey*20));
															textsVenda[7]= new JFormattedTextField();
															textsVenda[7].setBounds((int)(ajustex*(70+aux)),(int)(ajustey*340),(int)(ajustex*190),(int)(ajustey*20));
															labels[10]= new JLabel("Observações");
															labels[10].setFont(new Font("Observações", Font.BOLD, (int)(15*ajustex)));
															labels[10].setBounds((int)(ajustex*(aux+90)),(int)(ajustey*365),(int)(ajustex*100),(int)(ajustey*20));
															labels[11]= new JLabel("1-");
															labels[11].setFont(new Font("1-", Font.BOLD, (int)(13*ajustex)));
															labels[11].setBounds((int)(ajustex*(aux)),(int)(ajustey*390),(int)(ajustex*20),(int)(ajustey*20));
															textsVenda[8]= new JFormattedTextField();
															textsVenda[8].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*390),(int)(ajustex*240),(int)(ajustey*20));
															labels[12]= new JLabel("2-");
															labels[12].setFont(new Font("2-", Font.BOLD, (int)(13*ajustex)));
															labels[12].setBounds((int)(ajustex*(aux)),(int)(ajustey*410),(int)(ajustex*20),(int)(ajustey*20));
															textsVenda[9]= new JFormattedTextField();
															textsVenda[9].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*410),(int)(ajustex*240),(int)(ajustey*20));
															labels[13]= new JLabel("3-");
															labels[13].setFont(new Font("3-", Font.BOLD, (int)(13*ajustex)));
															labels[13].setBounds((int)(ajustex*(aux)),(int)(ajustey*430),(int)(ajustex*20),(int)(ajustey*20));
															textsVenda[10]= new JFormattedTextField();
															textsVenda[10].setBounds((int)(ajustex*(aux+20)),(int)(ajustey*430),(int)(ajustex*240),(int)(ajustey*20));
															for(int i=1;i<=13;i++)				frame.getContentPane ().add (labels[i]);
															for(int i=1;i<=10;i++)				frame.getContentPane ().add (textsVenda[i]);
															botao.setFont(new Font("Alterar", Font.BOLD, (int)(13*ajustex)));
															botao.setBounds( (int)(ajustex*(1010)), (int)(ajustey*480),(int)(ajustex*200), (int)(ajustey*50) );
															botao.addActionListener(this);
															frame.getContentPane ().add (botao);
															botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
															botao2.setBounds( (int)(ajustex*(1010)), (int)(ajustey*560),(int)(ajustex*200), (int)(ajustey*50) );
															botao2.addActionListener(this);
															frame.getContentPane ().add (botao2);
															frame.setVisible(true);
															frame.repaint();
															textsVenda[3].setDocument(new FixedLengthDocument(150));
															textsVenda[4].setDocument(new FixedLengthDocument(100));
															textsVenda[5].setDocument(new FixedLengthDocument(100));
															textsVenda[6].setDocument(new FixedLengthDocument(30));
															textsVenda[7].setDocument(new FixedLengthDocument(100));
															textsVenda[8].setDocument(new FixedLengthDocument(400));
															textsVenda[9].setDocument(new FixedLengthDocument(400));
															textsVenda[10].setDocument(new FixedLengthDocument(400));
															escreveVenda();
												
														}
													}
											}
										});
									}
								}
							});
							}
						}
					});
				}
				else if(comboB[0].getSelectedIndex()!=3&&comboB[0].getSelectedIndex()>0){
					final LogicaMostrar mostr = new LogicaMostrar(frame,con);
					String str[]=mostr.MostraCompras();
					String str2[]=mostr.MostraConsignados();
					final String  str3[];
					if(comboB[0].getSelectedIndex()==1)			str3=str;
					else										str3=str2;
					DefaultComboBoxModel model = new DefaultComboBoxModel(str3);
				comboB[1].setModel(model);
				if(comboB[2]!=null)
				{
					comboB[2].setVisible(false);
					comboB[2]=null;
					comboB[3].setVisible(false);
					labels2[4].setVisible(false);
					labels2[5].setVisible(false);
					labels2[6].setVisible(false);
				}
				frame.repaint();
				frame.setVisible(true);
				comboB[1].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						if(entrou==false&&comboB[1].getSelectedIndex()>0&&comboB[0].getSelectedIndex()>0&&comboB[2]==null)
						{
							entrou=true;
							Veiculo=str3[comboB[1].getSelectedIndex()];
							labels2[0].setVisible(false);
							labels2[1].setVisible(false);
							String strFinal[]= mostr.ProcuraEstoque(str3[comboB[1].getSelectedIndex()]);
							comboB[1].setVisible(false);
							comboB[1].removeAllItems();
							lista[0].setListData(strFinal);
							scrollpane.revalidate();
							scrollpane.add(lista[0]);
							scrollpane.setBounds((int)(ajustex*(400)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
						    frame.add(scrollpane);
						    scrollpane.setVisible(true);
						    scrollpane.setViewportView(lista[0]);
						    frame.setVisible(true);
							frame.repaint();
						    labels2[2]= new JLabel("= >");
							labels2[2].setFont(new Font("= >", Font.BOLD, (int)(28*ajustex)));
							labels2[2].setBounds((int)(ajustex*(820)),(int)(ajustey*450),(int)(ajustex*100),(int)(ajustey*100));
							frame.getContentPane ().add (labels2[2]);
							if(comboB[0].getSelectedIndex()==2)
							{
								option=2;
								comboB[0].setVisible(false);
								int x=100;
								int aux = x +850;
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
								labels[8].setFont(new Font("Valor Pedido (R$)", Font.BOLD, (int)(13*ajustex)));
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
								textsConsig[0].setDocument(new FixedLengthDocument(50));
								textsConsig[1].setDocument(new FixedLengthDocument(100));
								textsConsig[2].setDocument(new FixedLengthDocument(20));
								textsConsig[3].setDocument(new FixedLengthDocument(50));
								textsConsig[5].setDocument(new FixedLengthDocument(200));
								textsConsig[6].setDocument(new FixedLengthDocument(100));
								textsConsig[7].setDocument(new FixedLengthDocument(100));
								textsConsig[8].setDocument(new FixedLengthDocument(30));
								for(int i=10;i<=15;i++)		textsConsig[i].setDocument(new FixedLengthDocument(150));
								escreveConsignado();
								frame.setVisible(true);
								frame.repaint();
							}
							if(comboB[0].getSelectedIndex()==1)
							{
								option =1;
								comboB[0].setVisible(false);
								int x=950;
								int y = 100;
								JLabel labels[] = new JLabel[30];
								textsCompra[0]= new JFormattedTextField();
								textsCompra[0].setBounds((int)(ajustex*(x+60)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
								labels[21]= new JLabel("Compra");
								labels[21].setFont(new Font("Compra", Font.BOLD, (int)(18*ajustex)));
								labels[21].setBounds((int)(ajustex*(x+110)),(int)(ajustey*70),(int)(ajustex*100),(int)(ajustey*20));
								labels[0]= new JLabel("Marca");
								labels[0].setFont(new Font("Marca", Font.BOLD, (int)(13*ajustex)));
								labels[0].setBounds((int)(ajustex*x),(int)(ajustey*y),(int)(ajustex*50),(int)(ajustey*20));
								textsCompra[1]= new JFormattedTextField();
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
								textsCompra[17]= new JFormattedTextField(integer);
								textsCompra[17].setBounds((int)(ajustex*(x+120)),(int)(ajustey*(y+670)),(int)(ajustex*140),(int)(ajustey*20));
								labels[22]= new JLabel("Valor Final (R$)");
								labels[22].setFont(new Font("ValorFinal (R$)", Font.BOLD, (int)(13*ajustex)));
								labels[22].setBounds((int)(ajustex*x),(int)(ajustey*(y+670)),(int)(ajustex*150),(int)(ajustey*20));
								botoes[0].setFont(new Font("Adicionar Despesas", Font.BOLD, (int)(13*ajustex)));
								botoes[0].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+440)),(int)(ajustex*190), (int)(ajustey*30) );
								frame.getContentPane ().add (botoes[0]);
								botoes[1].setFont(new Font("Remover Despesas", Font.BOLD, (int)(13*ajustex)));
								botoes[1].setBounds( (int)(ajustex*(x+50)), (int)(ajustey*(y+620)),(int)(ajustex*190), (int)(ajustey*30) );
								frame.getContentPane ().add (botoes[1]);
								for(int i=0;i<=22;i++)				frame.getContentPane ().add (labels[i]);
								for(int i=0;i<=17;i++)				frame.getContentPane ().add (textsCompra[i]);
								textsCompra[1].setDocument(new FixedLengthDocument(100));
								textsCompra[2].setDocument(new FixedLengthDocument(20));
								textsCompra[3].setDocument(new FixedLengthDocument(50));
								textsCompra[4].setDocument(new FixedLengthDocument(50));
								textsCompra[5].setDocument(new FixedLengthDocument(50));
								for(int i=8;i<=16;i++)		textsCompra[i].setDocument(new FixedLengthDocument(150));
								escreveCompra();
							}
							botao.setFont(new Font("Alterar", Font.BOLD, (int)(13*ajustex)));
							botao.setBounds( (int)(ajustex*(1010)), (int)(ajustey*800),(int)(ajustex*200), (int)(ajustey*50) );
							frame.getContentPane ().add (botao);
							botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
							botao2.setBounds( (int)(ajustex*(1010)), (int)(ajustey*900),(int)(ajustex*200), (int)(ajustey*50) );
							frame.getContentPane ().add (botao2);
							frame.setVisible(true);
							frame.repaint();
					}
					}
				});
				}
			}
		});
		botoes[0].addActionListener(this);
		botoes[1].addActionListener(this);
		botao2.addActionListener(this);
		botao.addActionListener(this);
		for(int i=0;i<=1;i++)				frame.getContentPane ().add (labels2[i]);
		frame.setVisible(true);
		frame.repaint();
	}
	public void escreveVenda()
	{
		LogicaMostrar mostr = new LogicaMostrar(frame,con);
		String strFinal[]=mostr.ProcuraVendporPlacaComNulos(Veiculo);
		for(int i=1;i<=10;i++)
			{
				if(strFinal[i+5]!=null&&strFinal[i+5]!="")			textsVenda[i].setText(strFinal[i+5]);
			}
	}
	public void escreveConsignado()
	{
		LogicaMostrar mostr = new LogicaMostrar(frame,con);
		String strFinal[]=mostr.procuraConsigComNulos(Veiculo);
		for(int i=0;i<=16;i++)
		{
			if(strFinal[i+1]!=null&&strFinal[i+1]!="")			textsConsig[i].setText(strFinal[i+1]);
		}
	}
	public void escreveCompra()
	{
		LogicaMostrar mostr = new LogicaMostrar(frame,con);
		String strFinal[]=mostr.ProcuraCompraComNulos(Veiculo);
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize();
		final float ajustey = (float)tamTela.height/1080;
		final float ajustex = (float)tamTela.width/1920;
		int x=950;
		int y=100;
		contador= Integer.parseInt(strFinal[119]);
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
		scrollpane2.revalidate();
		scrollpane2.add(panel);
		scrollpane2.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*(100)));
	    frame.add(scrollpane2);
	    scrollpane2.setVisible(true);
	    scrollpane2.setViewportView(panel);
	    scrollpane3.revalidate();
		scrollpane3.add(panel2);
		scrollpane3.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+500)),(int)(ajustex*120),(int)(ajustey*(100)));
	    frame.add(scrollpane3);
	    scrollpane3.setVisible(true);
	    scrollpane3.setViewportView(panel2);
	    int aux=0;
	    for(int i=18;i<18+2*contador;i=i+2)
	    {
	    	if(strFinal[i+1]!=null&&strFinal[i+1]!="")			texts2[aux].setText(strFinal[i+1]);
	    	aux++;
	    }
	    aux=0;
		for(int i=19;i<19+2*contador;i=i+2)
		{
			if(strFinal[i+1]!=null&&strFinal[i+1]!="")			texts3[aux].setText(strFinal[i+1]);
			aux++;
		}
		for(int i=0;i<=17;i++)
		{
			if(strFinal[i+1]!=null&&strFinal[i+1]!="")			textsCompra[i].setText(strFinal[i+1]);
		}
	}
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Limpar Tela"))
		{
			Alterar altera= new Alterar(frame,con);
			altera.altera();
		}
		else if(source.getText().equals("Alterar"))
		{
			LogicaAltera alter= new LogicaAltera(frame,con);
			if(option==2)
			{
				String[] strings= new String[17];
				for(int i=0; i <=16;i++)		strings[i]=textsConsig[i].getText();
				if(strings[0]==null||strings[0].equals("")||strings[1]==null||strings[1].equals("")||strings[2]==null||strings[2].equals("")||strings[3]==null||strings[3].equals("")||strings[4]==null||strings[4].equals("")||strings[9]==null||strings[9].equals("")||strings[16]==null||strings[16].equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Faltam dados");
					return;
				}
				alter.AlteraTudo(Veiculo,strings);
				JOptionPane.showMessageDialog(frame, "Alterado");
				Alterar altera= new Alterar(frame,con);
				altera.altera();
			}
			else if(option==1)
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
				for(int i=2*contador+20;i<=117;i++)			strings[i]=null;
				alter.AlteraTudo(Veiculo,strings);
				JOptionPane.showMessageDialog(frame, "Alterado");
				Alterar altera= new Alterar(frame,con);
				altera.altera();
			}
			else
			{
				String[] strings= new String[10];
				for(int i=1; i <=10;i++)		strings[i-1]=textsVenda[i].getText();
				if(strings[2]==null||strings[2].equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Faltam dados");
					return;
				}
				alter.AlteraTudo(Veiculo,strings);
				JOptionPane.showMessageDialog(frame, "Alterado");
				Alterar altera= new Alterar(frame,con);
				altera.altera();
			}
		}
		else if(source.getText().equals("Adicionar Despesas"))
		{
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 950;
			int y = 100;
			texts2[contador]= new JTextField(150);
			texts2[contador].setDocument(new FixedLengthDocument(150));
			texts3[contador]= new JFormattedTextField(integer);
			panel.setLayout(new GridLayout( 50, 2 ) ); 
			panel2.setLayout(new GridLayout( 50, 2 ) ); 
			panel.add(texts2[contador]);
			panel2.add(texts3[contador]);
			scrollpane2.revalidate();
			scrollpane2.add(panel);
			scrollpane2.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel);
		    scrollpane3.revalidate();
			scrollpane3.add(panel2);
			scrollpane3.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+500)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane3);
		    scrollpane3.setVisible(true);
		    scrollpane3.setViewportView(panel2);
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
			int x = 950;
			int y = 100;
			contador--;
			panel.remove(texts2[contador]);
			panel2.remove(texts3[contador]);
			scrollpane2.revalidate();
			scrollpane2.add(panel);
			scrollpane2.setBounds((int)(ajustex*(x)),(int)(ajustey*(y+500)),(int)(ajustex*150),(int)(ajustey*(100)));
		    frame.add(scrollpane2);
		    scrollpane2.setVisible(true);
		    scrollpane2.setViewportView(panel);
		    scrollpane3.revalidate();
			scrollpane3.add(panel2);
			scrollpane3.setBounds((int)(ajustex*(x+160)),(int)(ajustey*(y+500)),(int)(ajustex*120),(int)(ajustey*(100)));
		    frame.add(scrollpane3);
		    scrollpane3.setVisible(true);
		    scrollpane3.setViewportView(panel2);
		    frame.setVisible(true);
			frame.repaint();
		}
		
	}
}
