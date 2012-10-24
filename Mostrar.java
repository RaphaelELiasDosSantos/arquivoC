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
import javax.swing.JScrollPane;



public class Mostrar  implements ActionListener{
 JFrame frame;
 Connection con;
 public Mostrar(JFrame frame2,Connection con)
 {
  frame=frame2;
  this.con=con;
 }
 JButton botoes[] = new JButton[5];
 public void mostra()
 {
  java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
  Dimension tamTela= toolkit.getScreenSize(); 
  frame.getContentPane ().removeAll();
  int x = 400;
  int y = 150;
  final String[] nula = {null};
  final JComboBox comboB[] = new JComboBox[4];
  final JScrollPane[] scrollpane = new JScrollPane[3];
  final float ajustey = (float)tamTela.height/1080;
  final float ajustex = (float)tamTela.width/1920;
  final JList lista[] = new JList[18];
  final JLabel[] labels = new JLabel[6];
  JLabel labels3= new JLabel("Listar");
  labels3.setFont(new Font("Listar", Font.BOLD, (int)(50*ajustex)));
  labels3.setBounds((int)(ajustex*(900)),(int)(ajustey*0),(int)(ajustex*300),(int)(ajustey*130));
  final LogicaMostrar mostr = new LogicaMostrar(frame,con);
  String str[]=mostr.MostraCompras();
  String str2[]=mostr.MostraConsignados();
  final String  str3[] = mostr.concatena(str,str2);
  frame.getContentPane ().add (labels3);
  frame.getContentPane ().setBackground(new Color(220,220,255));
  botoes[1]=new JButton("Limpar Tela");
  labels[0]= new JLabel("Veiculos a venda");
  labels[0].setFont(new Font("Veiculos a venda", Font.BOLD, (int)(20*ajustex)));
  labels[0].setBounds((int)(ajustex*(x-50)),(int)(ajustey*y),(int)(ajustex*300),(int)(ajustey*20));
  comboB[0] = new JComboBox(str3);
  comboB[0].setSelectedIndex(0);
  comboB[0].setBounds((int)(ajustex*(x-50)),(int)(ajustey*(y+60)),(int)(ajustex*300),(int)(ajustey*20));
  frame.add(comboB[0]);
  scrollpane[0] = new JScrollPane(null);
  lista[0] = new JList(nula);
  comboB[0].addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	if(comboB[0].getSelectedIndex()>=0)
	{
	String strFinal[]= mostr.ProcuraEstoque(str3[comboB[0].getSelectedIndex()]);
	lista[0].setListData(strFinal);
    int x = 400;
    int y = 150;
    labels[2].setVisible(false);
	for(int i=3;i<=5;i++)			labels[i].setVisible(false);
	for(int i=0;i<=3;i++)			comboB[i].setVisible(false);
    lista[0].setListData(strFinal);
    scrollpane[0].revalidate();
    scrollpane[0].add(lista[0]);
    scrollpane[0].setBounds((int)(ajustex*(x-50)),(int)(ajustey*(y+110)),(int)(ajustex*300),(int)(ajustey*(400)));
    frame.add(scrollpane[0]);
     scrollpane[0].setVisible(true);
       scrollpane[0].setViewportView(lista[0]);
       frame.repaint();
       botoes[1].setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
       botoes[1].setBounds( (int)(ajustex*(600)), (int)(ajustey*800),(int)(ajustex*200), (int)(ajustey*50) );
       frame.getContentPane ().add (botoes[1]);
	}
   }
  });
  final String meses[]=mostr.MesesDisponiveisVenda();
  labels[2]= new JLabel("Vendas");
  labels[2].setFont(new Font("Vendas", Font.BOLD, (int)(20*ajustex)));
  labels[2].setBounds((int)(ajustex*(x+900)),(int)(ajustey*y),(int)(ajustex*300),(int)(ajustey*20));
  comboB[2] = new JComboBox(meses);
  comboB[2].setSelectedIndex(0);
  comboB[2].setBounds((int)(ajustex*(x+800)),(int)(ajustey*(y+60)),(int)(ajustex*150),(int)(ajustey*30));
  frame.add(comboB[2]);
  labels[3]= new JLabel("Mês");
  labels[3].setFont(new Font("Mês", Font.BOLD, (int)(15*ajustex)));
  labels[3].setBounds((int)(ajustex*(x+850)),(int)(ajustey*(y+20)),(int)(ajustex*50),(int)(ajustey*50));
  frame.getContentPane ().add (labels[3]);
  labels[4]= new JLabel("Ano");
  labels[4].setFont(new Font("Ano", Font.BOLD, (int)(15*ajustex)));
  labels[4].setBounds((int)(ajustex*(x+1050)),(int)(ajustey*(y+20)),(int)(ajustex*50),(int)(ajustey*50));
  frame.getContentPane ().add (labels[4]);
  labels[5]= new JLabel("de");
  labels[5].setFont(new Font("de", Font.BOLD, (int)(12*ajustex)));
  labels[5].setBounds((int)(ajustex*(x+960)),(int)(ajustey*(y+60)),(int)(ajustex*30),(int)(ajustey*20));
  frame.getContentPane ().add (labels[5]);
  comboB[3] = new JComboBox(nula);
  comboB[3].setSelectedIndex(0);
  comboB[3].setBounds((int)(ajustex*(x+1000)),(int)(ajustey*(y+60)),(int)(ajustex*90),(int)(ajustey*30));
  frame.add(comboB[3]);
  comboB[1] = new JComboBox(nula);
  comboB[1].setSelectedIndex(0);
  comboB[1].setBounds((int)(ajustex*(x+1150)),(int)(ajustey*(y+60)),(int)(ajustex*170),(int)(ajustey*30));
  frame.add(comboB[1]);
  scrollpane[2] = new JScrollPane(null);  
  lista[2] = new JList(nula);
  comboB[2].addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  if(comboB[2].getSelectedIndex()>0)
			{
			final String anos[] = mostr.AnosDisponiveisVenda(meses[comboB[2].getSelectedIndex()]);
			DefaultComboBoxModel model2 = new DefaultComboBoxModel( anos);
			comboB[3].setModel(model2);
			frame.repaint();
			frame.setVisible(true);
			comboB[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					if(comboB[3].getSelectedIndex()>0&&comboB[2].getSelectedIndex()>0)
					{
					final String dados[]=mostr.ProcuraVendas(meses[comboB[2].getSelectedIndex()],anos[comboB[3].getSelectedIndex()]);
					DefaultComboBoxModel model = new DefaultComboBoxModel(dados);
					comboB[1].setModel(model);
					comboB[1].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(comboB[1].getSelectedIndex()>0&&comboB[3].getSelectedIndex()>0&&comboB[2].getSelectedIndex()>0)
							{
							int x = 400;
							int y = 150;
							String strFinal2[]=mostr.ProcuraVendporPlaca2(dados[comboB[1].getSelectedIndex()]);
							labels[0].setVisible(false);
							for(int i=3;i<=5;i++)			labels[i].setVisible(false);
							for(int i=0;i<=3;i++)			comboB[i].setVisible(false);
							lista[2].setListData(strFinal2);
							scrollpane[2].revalidate();
							scrollpane[2].add(lista[2]);
							scrollpane[2].setBounds((int)(ajustex*(x+800)),(int)(ajustey*(y+110)),(int)(ajustex*300),(int)(ajustey*(400)));
							frame.add(scrollpane[2]);
							scrollpane[2].setVisible(true);
							scrollpane[2].setViewportView(lista[2]);
							frame.repaint();
							  botoes[1].setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
							  botoes[1].setBounds( (int)(ajustex*(1450)), (int)(ajustey*800),(int)(ajustex*200), (int)(ajustey*50) );
							  frame.getContentPane ().add (botoes[1]);
					}
				}
			});
			}
		}
		});
	 }
   }
  });
  
  frame.getContentPane ().add (labels[0]);
  for(int j=2;j<=5;j++) frame.getContentPane ().add (labels[j]);
  frame.setVisible(true);
  frame.repaint();
  for(int i=1;i<=1;i++)  botoes[i].addActionListener((ActionListener) this);
 }
@Override
public void actionPerformed(ActionEvent e) {
	JButton source = (JButton) (e.getSource());
	if(source.getText().equals("Limpar Tela"))
	{
		Mostrar most = new Mostrar(frame,con);
		most.mostra();
	}
}

}
