package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Remover implements ActionListener {
	JFrame frame;
	Connection con;
	public Remover(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public boolean entrou;
	public String Veiculo;
	public void remove()
	{
		
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
			final JButton botao = new JButton("Remover");
			final JButton botao2 = new JButton("Limpar Tela");
			entrou=false;
			frame.getContentPane ().setBackground(new Color(220,220,255));
			JLabel labels3= new JLabel("Remover");
			labels3.setFont(new Font("Remover", Font.BOLD, (int)(50*ajustex)));
			labels3.setBounds((int)(ajustex*(880)),(int)(ajustey*(-35)),(int)(ajustex*300),(int)(ajustey*130));
			frame.getContentPane ().add (labels3);
			labels2[4]=null;
			comboB[2]=null;
			comboB[3]=null;
			labels2[0]= new JLabel("Tipos de remoções");
			labels2[0].setFont(new Font("Tipos de remoções", Font.BOLD, (int)(18*ajustex)));
			labels2[0].setBounds((int)(ajustex*(10)),(int)(ajustey*70),(int)(ajustex*200),(int)(ajustey*20));
			comboB[0] = new JComboBox(dados);
			comboB[0].setSelectedIndex(0);
			comboB[0].setBounds((int)(ajustex*(10)),(int)(ajustey*100),(int)(ajustex*200),(int)(ajustey*20));
			frame.add(comboB[0]);
			labels2[1]= new JLabel("Item a ser Removido");
			labels2[1].setFont(new Font("Item a ser Removido", Font.BOLD, (int)(18*ajustex)));
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
						labels2[4]= new JLabel("de");
						labels2[4].setFont(new Font("de", Font.BOLD, (int)(12*ajustex)));
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
														Veiculo = dados[comboB[1].getSelectedIndex()];
														String strFinal[]=mostr.ProcuraVendporPlaca(dados[comboB[1].getSelectedIndex()]);
														lista[0].setListData(strFinal);
														comboB[2].setVisible(false);
														comboB[3].setVisible(false);
														comboB[0].setVisible(false);
														comboB[1].setVisible(false);
														labels2[4].setVisible(false);
														labels2[5].setVisible(false);
														labels2[6].setVisible(false);
														labels2[0].setVisible(false);
														labels2[1].setVisible(false);
														scrollpane.revalidate();
														scrollpane.add(lista[0]);
														scrollpane.setBounds((int)(ajustex*(550)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
													    frame.add(scrollpane);
													    scrollpane.setVisible(true);
													    scrollpane.setViewportView(lista[0]);
													    frame.setVisible(true);
														frame.repaint();
														botao.setFont(new Font("Remover", Font.BOLD, (int)(13*ajustex)));
														botao.setBounds( (int)(ajustex*(1000)), (int)(ajustey*550),(int)(ajustex*200), (int)(ajustey*50) );
														botao.addActionListener(this);
														frame.getContentPane ().add (botao);
														botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
														botao2.setBounds( (int)(ajustex*(1000)), (int)(ajustey*450),(int)(ajustex*200), (int)(ajustey*50) );
														botao2.addActionListener(this);
														frame.getContentPane ().add (botao2);
														frame.setVisible(true);
														frame.repaint();
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
							comboB[0].setVisible(false);
							labels2[0].setVisible(false);
							labels2[1].setVisible(false);
							String strFinal[]= mostr.ProcuraEstoque(str3[comboB[1].getSelectedIndex()]);
							lista[0].setListData(strFinal);
							comboB[1].setVisible(false);
							scrollpane.revalidate();
							scrollpane.add(lista[0]);
							scrollpane.setBounds((int)(ajustex*(550)),(int)(ajustey*70),(int)(ajustex*320),(int)(ajustey*(900)));
						    frame.add(scrollpane);
						    scrollpane.setVisible(true);
						    scrollpane.setViewportView(lista[0]);
						    frame.setVisible(true);
							frame.repaint();
							botao.setFont(new Font("Remover", Font.BOLD, (int)(13*ajustex)));
							botao.setBounds( (int)(ajustex*(1000)), (int)(ajustey*550),(int)(ajustex*200), (int)(ajustey*50) );
							frame.getContentPane ().add (botao);
							botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
							botao2.setBounds( (int)(ajustex*(1000)), (int)(ajustey*450),(int)(ajustex*200), (int)(ajustey*50) );
							frame.getContentPane ().add (botao2);
							frame.setVisible(true);
							frame.repaint();
							}
						}
					});
					}
				}
			});
			botao2.addActionListener(this);
			botao.addActionListener(this);
			for(int i=0;i<=1;i++)				frame.getContentPane ().add (labels2[i]);
			frame.setVisible(true);
			frame.repaint();
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Limpar Tela"))
		{
			Remover rem= new Remover(frame,con);
			rem.remove();
		}
		else if(source.getText().equals("Remover"))
		{
			LogicaRemover remove= new LogicaRemover(frame,con);
			remove.RemovedeTudo(Veiculo);
			JOptionPane.showMessageDialog(frame, "Removido");
			Remover rem= new Remover(frame,con);
			rem.remove();
		}
	}

}
