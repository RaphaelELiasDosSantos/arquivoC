package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CusGan implements ActionListener{
	JFrame frame;
	Connection con;
	public CusGan(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	String custos[];
	String ganhos[];
	String mes1,ano1;
	public void rendimento()
	{
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize();
		frame.getContentPane ().removeAll();
		frame.setContentPane(new JPanel());
		frame.setLayout(null);
		final JComboBox comboB[] = new JComboBox[4];
		final JScrollPane scrollpane[] = new JScrollPane[3];
		final float ajustey = (float)tamTela.height/1080;
		final float ajustex = (float)tamTela.width/1920;
		final JList lista[] = new JList[3];
		final String[] nula = {null};
		final JLabel[] labels2 = new JLabel[6];
		final JLabel[] labels = new JLabel[6];
		final JButton botao = new JButton("PDF");
		final JButton botao2 = new JButton("Limpar Tela");
		frame.getContentPane ().setBackground(new Color(220,220,255));
		JLabel labels3= new JLabel("Custos e Ganhos");
		labels3.setFont(new Font("Custos e Ganhos", Font.BOLD, (int)(50*ajustex)));
		labels3.setBounds((int)(ajustex*(640)),(int)(ajustey*(-35)),(int)(ajustex*500),(int)(ajustey*130));
		frame.getContentPane ().add (labels3);
		labels[0]= new JLabel("Mês");
		labels[0].setFont(new Font("Mês", Font.BOLD, (int)(15*ajustex)));
		labels[0].setBounds((int)(ajustex*(180)),(int)(ajustey*55),(int)(ajustex*50),(int)(ajustey*50));
		frame.getContentPane ().add (labels[0]);
		labels[1]= new JLabel("Ano");
		labels[1].setFont(new Font("Ano", Font.BOLD, (int)(15*ajustex)));
		labels[1].setBounds((int)(ajustex*(320)),(int)(ajustey*55),(int)(ajustex*50),(int)(ajustey*50));
		frame.getContentPane ().add (labels[1]);
		labels[2]= new JLabel("De");
		labels[2].setFont(new Font("De", Font.BOLD, (int)(12*ajustex)));
		labels[2].setBounds((int)(ajustex*(285)),(int)(ajustey*100),(int)(ajustex*30),(int)(ajustey*20));
		frame.getContentPane ().add (labels[2]);
		comboB[0] = new JComboBox(nula);
		comboB[0].setSelectedIndex(0);
		comboB[0].setBounds((int)(ajustex*(130)),(int)(ajustey*100),(int)(ajustex*150),(int)(ajustey*20));
		frame.add(comboB[0]);
		comboB[1] = new JComboBox(nula);
		comboB[1].setSelectedIndex(0);
		comboB[1].setBounds((int)(ajustex*(310)),(int)(ajustey*100),(int)(ajustex*60),(int)(ajustey*20));
		frame.add(comboB[1]);
		frame.repaint();
		frame.setVisible(true);
		scrollpane[0]= new JScrollPane(null);
		lista[0] = new JList(nula);
		scrollpane[1]= new JScrollPane(null);
		lista[1] = new JList(nula);
		final LogicaCusGan logCG = new LogicaCusGan(frame,con);
		final String meses[]=logCG.MEsPossivel();
		DefaultComboBoxModel model = new DefaultComboBoxModel( meses);
		comboB[0].setModel(model);
		labels2[0]=null;
		comboB[0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(comboB[0].getSelectedIndex()>0)
			{
			final String anos[]=logCG.AnoPossivel(meses[comboB[0].getSelectedIndex()]);
			DefaultComboBoxModel model2 = new DefaultComboBoxModel( anos);
			comboB[1].setModel(model2);
			frame.repaint();
			frame.setVisible(true);
			comboB[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboB[0].getSelectedIndex()>0&&comboB[1].getSelectedIndex()>0)
					{
						mes1=meses[comboB[0].getSelectedIndex()];
						ano1=anos[comboB[1].getSelectedIndex()];
						custos=logCG.custos(meses[comboB[0].getSelectedIndex()],anos[comboB[1].getSelectedIndex()]);
						lista[0].setListData(custos);
						ganhos=logCG.vendas(meses[comboB[0].getSelectedIndex()],anos[comboB[1].getSelectedIndex()]);
						lista[1].setListData(ganhos);
						int ganhoTotal= logCG.ganhoTotal(meses[comboB[0].getSelectedIndex()],anos[comboB[1].getSelectedIndex()]);
						int gastoTotal= logCG.custoTotal(meses[comboB[0].getSelectedIndex()],anos[comboB[1].getSelectedIndex()]);
						if(labels2[0]!=null)
						{
							for(int i=0;i<=5;i++)		labels2[i].setVisible(false);
						}
						comboB[0].setVisible(false);
						comboB[1].setVisible(false);
						labels[0].setVisible(false);
						labels[1].setVisible(false);
						labels[2].setVisible(false);
						labels2[0]= new JLabel("Despesas no Mês");
						labels2[0].setFont(new Font("Despesas no Mês", Font.BOLD, (int)(15*ajustex)));
						labels2[0].setBounds((int)(ajustex*(550)),(int)(ajustey*80),(int)(ajustex*140),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[0]);
						scrollpane[0].revalidate();
						scrollpane[0].add(lista[0]);
						scrollpane[0].setBounds((int)(ajustex*(450)),(int)(ajustey*120),(int)(ajustex*320),(int)(ajustey*(900)));
					    frame.add(scrollpane[0]);
					    scrollpane[0].setVisible(true);
					    scrollpane[0].setViewportView(lista[0]);
					    labels2[1]= new JLabel("Vendas no Mês");
						labels2[1].setFont(new Font("Vendas no Mês", Font.BOLD, (int)(15*ajustex)));
						labels2[1].setBounds((int)(ajustex*(1000)),(int)(ajustey*80),(int)(ajustex*120),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[1]);
					    scrollpane[1].revalidate();
						scrollpane[1].add(lista[1]);
						scrollpane[1].setBounds((int)(ajustex*(900)),(int)(ajustey*120),(int)(ajustex*320),(int)(ajustey*(900)));
					    frame.add(scrollpane[1]);
					    scrollpane[1].setVisible(true);
					    scrollpane[1].setViewportView(lista[1]);
					    frame.setVisible(true);
						frame.repaint();
						labels2[0]= new JLabel("Despesas (R$):");
						labels2[0].setFont(new Font("Despesas (R$):", Font.BOLD, (int)(15*ajustex)));
						labels2[0].setBounds((int)(ajustex*(1300)),(int)(ajustey*500),(int)(ajustex*120),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[0]);
						labels2[1]= new JLabel("Vendas (R$):");
						labels2[1].setFont(new Font("Vendas (R$):", Font.BOLD, (int)(15*ajustex)));
						labels2[1].setBounds((int)(ajustex*(1300)),(int)(ajustey*550),(int)(ajustex*120),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[1]);
						labels2[2]= new JLabel("Lucro Liquido (R$):");
						labels2[2].setFont(new Font("Lucro Liquido (R$):", Font.BOLD, (int)(15*ajustex)));
						labels2[2].setBounds((int)(ajustex*(1300)),(int)(ajustey*600),(int)(ajustex*140),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[2]);
						labels2[3]= new JLabel(""+gastoTotal);
						labels2[3].setFont(new Font(""+gastoTotal, Font.BOLD, (int)(15*ajustex)));
						labels2[3].setBounds((int)(ajustex*(1420)),(int)(ajustey*500),(int)(ajustex*140),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[3]);
						labels2[4]= new JLabel(""+ganhoTotal);
						labels2[4].setFont(new Font(""+ganhoTotal, Font.BOLD, (int)(15*ajustex)));
						labels2[4].setBounds((int)(ajustex*(1400)),(int)(ajustey*550),(int)(ajustex*140),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[4]);
						labels2[5]= new JLabel("" + (ganhoTotal - gastoTotal));
						labels2[5].setFont(new Font("" + (ganhoTotal - gastoTotal), Font.BOLD, (int)(15*ajustex)));
						labels2[5].setBounds((int)(ajustex*(1440)),(int)(ajustey*600),(int)(ajustex*140),(int)(ajustey*40));
						frame.getContentPane ().add (labels2[5]);
						botao.setFont(new Font("PDF", Font.BOLD, (int)(13*ajustex)));
						botao.setBounds( (int)(ajustex*(1300)), (int)(ajustey*650),(int)(ajustex*200), (int)(ajustey*50) );
						frame.getContentPane ().add (botao);
						botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
						botao2.setBounds( (int)(ajustex*(1300)), (int)(ajustey*750),(int)(ajustex*200), (int)(ajustey*50) );
						frame.getContentPane ().add (botao2);
					}
				}
			});
			}
		}
		});
		botao2.addActionListener(this);
		botao.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("PDF"))
		{
			Document document=new Document();
			try {
				PdfWriter.getInstance(document,new FileOutputStream("Advans"+mes1+ano1+".pdf"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			document.open();
			try {
				document.add(new Paragraph(mes1 + " de " + ano1));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Custos:"));
				for(int i=0;i<custos.length;i++)			document.add(new Paragraph(custos[i]));
				for(int i=0;i<=5;i++)			document.add(new Paragraph(" "));
				document.add(new Paragraph("Ganhos:"));
				for(int i=0;i<ganhos.length;i++)			document.add(new Paragraph(ganhos[i]));
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			document.close();
			JOptionPane.showMessageDialog(frame, "PDf Gerado");


		}
		else if(source.getText().equals("Limpar Tela"))
		{
			CusGan x= new CusGan(frame,con);
			x.rendimento();
		}
	}

}
