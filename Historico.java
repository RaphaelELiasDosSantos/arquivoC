package projeto1;
import javax.swing.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;

public class Historico implements ActionListener{
	JFrame frame;
	Connection con;
	public Historico(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	String anoSelect;
	JButton botao;
	JButton botao2;
	int cont=0;
	public void histor()
	{
		System.gc();
		frame.getContentPane().removeAll();
		frame.setContentPane(new JPanel());
		frame.setLayout(null);
		frame.getContentPane ().setBackground(new Color(220,220,255));
		frame.repaint();
		java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
		Dimension tamTela= toolkit.getScreenSize(); 
		final float ajustey = (float)tamTela.height/1080;
		final float ajustex = (float)tamTela.width/1920;
		final JComboBox comboB[] = new JComboBox[1];
		final JLabel[] labels = new JLabel[2];
		final String[] nula = {null};
		botao = new JButton("PDF");
		botao2 = new JButton("Limpar Tela");
		comboB[0] = new JComboBox(nula);
		comboB[0].setSelectedIndex(0);
		comboB[0].setBounds((int)(ajustex*(130)),(int)(ajustey*100),(int)(ajustex*150),(int)(ajustey*20));
		labels[1]= new JLabel("Ano");
		labels[1].setFont(new Font("Ano", Font.BOLD, (int)(15*ajustex)));
		labels[1].setBounds((int)(ajustex*(145)),(int)(ajustey*55),(int)(ajustex*50),(int)(ajustey*50));
		frame.getContentPane ().add(comboB[0]);
		frame.getContentPane ().add (labels[1]);
		final LogicaCusGan logCG = new LogicaCusGan(frame,con);
		final String anos[]=logCG.todosAnos();
		DefaultComboBoxModel model = new DefaultComboBoxModel( anos);
		comboB[0].setModel(model);
		comboB[0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(comboB[0].getSelectedIndex()>0)
			{
				anoSelect = anos[comboB[0].getSelectedIndex()];
				frame.getContentPane().removeAll();
				frame.setVisible( true );
	            frame.repaint();
				frame.setContentPane( new JPanel() {
					public void paintComponent( Graphics g ) {
							frame.setLayout(null);
							super.setBackground(new Color(220,220,255));
							super.paintComponent(g);
							Graphics2D g2 = (Graphics2D)g;
							g2.setColor(Color.red);
							int ganhoTotal =0;
							int gastoTotal =0;
							int res=0;
							ganhoTotal= logCG.ganhoTotal("Janeiro",anoSelect);
							gastoTotal= logCG.custoTotal("janeiro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		g2.fillRect((int)(ajustex*(220)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else 			g2.fillRect((int)(ajustex*(220)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Fevereiro",anoSelect);
							gastoTotal= logCG.custoTotal("Fevereiro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(285)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(285)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Março",anoSelect);
							gastoTotal= logCG.custoTotal("Março",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(350)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(350)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Abril",anoSelect);
							gastoTotal= logCG.custoTotal("Abril",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		g2.fillRect((int)(ajustex*(415)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			g2.fillRect((int)(ajustex*(415)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Maio",anoSelect);
							gastoTotal= logCG.custoTotal("Maio",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		g2.fillRect((int)(ajustex*(480)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			g2.fillRect((int)(ajustex*(480)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Junho",anoSelect);
							gastoTotal= logCG.custoTotal("Junho",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(545)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else		     g2.fillRect((int)(ajustex*(545)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Julho",anoSelect);
							gastoTotal= logCG.custoTotal("Julho",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(610)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(610)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Agosto",anoSelect);
							gastoTotal= logCG.custoTotal("Agosto",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(675)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else		     g2.fillRect((int)(ajustex*(675)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Setembro",anoSelect);
							gastoTotal= logCG.custoTotal("Setembro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(740)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(740)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Outubro",anoSelect);
							gastoTotal= logCG.custoTotal("Outubro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		g2.fillRect((int)(ajustex*(805)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			g2.fillRect((int)(ajustex*(805)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Novembro",anoSelect);
							gastoTotal= logCG.custoTotal("Novembro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(870)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(870)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
				            ganhoTotal= logCG.ganhoTotal("Dezembro",anoSelect);
							gastoTotal= logCG.custoTotal("Dezembro",anoSelect);
							res= (int)(300*(ganhoTotal - gastoTotal)/50000);
							if(res>=0)		 g2.fillRect((int)(ajustex*(935)), (int)(ajustey*(500-res)), (int)(ajustex*(65)), (int)(ajustey*(res)));
							else			 g2.fillRect((int)(ajustex*(935)), (int)(ajustey*(500)), (int)(ajustex*(65)), (int)(ajustey*(-res)));
							g2.setColor(Color.blue);
							
							g2.drawLine((int)(ajustex*(200)),(int)(ajustey*(800)),(int)(ajustex*(200)),(int)(ajustey*(200)));
							g2.drawLine((int)(ajustex*(150)),(int)(ajustey*(500)),(int)(ajustex*(1050)),(int)(ajustey*(500)));
							g2.drawLine((int)(ajustex*(220)),(int)(ajustey*(520)),(int)(ajustex*(220)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(285)),(int)(ajustey*(520)),(int)(ajustex*(285)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(350)),(int)(ajustey*(520)),(int)(ajustex*(350)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(415)),(int)(ajustey*(520)),(int)(ajustex*(415)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(480)),(int)(ajustey*(520)),(int)(ajustex*(480)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(545)),(int)(ajustey*(520)),(int)(ajustex*(545)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(610)),(int)(ajustey*(520)),(int)(ajustex*(610)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(675)),(int)(ajustey*(520)),(int)(ajustex*(675)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(740)),(int)(ajustey*(520)),(int)(ajustex*(740)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(805)),(int)(ajustey*(520)),(int)(ajustex*(805)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(870)),(int)(ajustey*(520)),(int)(ajustex*(870)),(int)(ajustey*(480)));
							g2.drawLine((int)(ajustex*(935)),(int)(ajustey*(520)),(int)(ajustex*(935)),(int)(ajustey*(480)));
			                g2.drawLine((int)(ajustex*(1000)),(int)(ajustey*(520)),(int)(ajustex*(1000)),(int)(ajustey*(480)));
			                
			                g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(560)),(int)(ajustex*(220)),(int)(ajustey*(560)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(620)),(int)(ajustex*(220)),(int)(ajustey*(620)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(680)),(int)(ajustex*(220)),(int)(ajustey*(680)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(740)),(int)(ajustex*(220)),(int)(ajustey*(740)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(800)),(int)(ajustex*(220)),(int)(ajustey*(800)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(440)),(int)(ajustex*(220)),(int)(ajustey*(440)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(380)),(int)(ajustex*(220)),(int)(ajustey*(380)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(320)),(int)(ajustex*(220)),(int)(ajustey*(320)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(260)),(int)(ajustex*(220)),(int)(ajustey*(260)));
							g2.drawLine((int)(ajustex*(180)),(int)(ajustey*(200)),(int)(ajustex*(220)),(int)(ajustey*(200)));
							 
							g2.setFont(new Font("10000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("10000",(int)(ajustex*(230)), (int)(ajustey*(440)));
				               g2.setFont(new Font("20000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("20000",(int)(ajustex*(230)), (int)(ajustey*(380)));
				               g2.setFont(new Font("30000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("30000",(int)(ajustex*(230)), (int)(ajustey*(320)));
				               g2.setFont(new Font("40000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("40000",(int)(ajustex*(230)), (int)(ajustey*(260)));
				               g2.setFont(new Font("50000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("50000",(int)(ajustex*(230)), (int)(ajustey*(200)));
				               g2.setFont(new Font("-10000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("-10000",(int)(ajustex*(230)), (int)(ajustey*(560)));
				               g2.setFont(new Font("-20000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("-20000",(int)(ajustex*(230)), (int)(ajustey*(620)));
				               g2.setFont(new Font("-30000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("-30000",(int)(ajustex*(230)), (int)(ajustey*(680)));
				               g2.setFont(new Font("-40000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("-40000",(int)(ajustex*(230)), (int)(ajustey*(740)));
				               g2.setFont(new Font("-50000",Font.BOLD, (int)(11*ajustex)));
				               g2.drawString("-50000",(int)(ajustex*(230)), (int)(ajustey*(800)));
			               g2.setFont(new Font("Lucro(R$)",Font.BOLD, (int)(14*ajustex)));
			               
			               AffineTransform fontAT = new AffineTransform();
			               fontAT.rotate(270 * java.lang.Math.PI/180);
			               Font theFont = g2.getFont();
			               Font theDerivedFont=g2.getFont().deriveFont(fontAT);
			               g2.setFont(theDerivedFont);
			               g2.drawString("Lucro(R$)", (int)(ajustex*(160)), (int)(ajustey*(400)));
			               g2.setFont(theFont);
			               g2.setFont(new Font("Meses",Font.BOLD, (int)(14*ajustex)));
			               g2.drawString("Meses",(int)(ajustex*(1050)), (int)(ajustey*(520)));
			               g2.setFont(new Font("janeiro",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("janeiro",(int)(ajustex*(230)), (int)(ajustey*(520)));
			               g2.setFont(new Font("fevereiro",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("fevereiro",(int)(ajustex*(295)), (int)(ajustey*(520)));
			               g2.setFont(new Font("março",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("março",(int)(ajustex*(360)), (int)(ajustey*(520)));
			               g2.setFont(new Font("abril",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("abril",(int)(ajustex*(425)), (int)(ajustey*(520)));
			               g2.setFont(new Font("maio",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("maio",(int)(ajustex*(490)), (int)(ajustey*(520)));
			               g2.setFont(new Font("junho",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("junho",(int)(ajustex*(555)), (int)(ajustey*(520)));
			               g2.setFont(new Font("julho",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("julho",(int)(ajustex*(620)), (int)(ajustey*(520)));
			               g2.setFont(new Font("agosto",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("agosto",(int)(ajustex*(685)), (int)(ajustey*(520)));
			               g2.setFont(new Font("setembro",Font.BOLD, (int)(13*ajustex)));
			               g2.drawString("setembro",(int)(ajustex*(745)), (int)(ajustey*(520)));
			               g2.setFont(new Font("outubro",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("outubro",(int)(ajustex*(810)), (int)(ajustey*(520)));
			               g2.setFont(new Font("novembro",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("novembro",(int)(ajustex*(875)), (int)(ajustey*(520)));
			               g2.setFont(new Font("dezembro",Font.BOLD, (int)(11*ajustex)));
			               g2.drawString("dezembro",(int)(ajustex*(940)), (int)(ajustey*(520)));
			               
			               botao.setFont(new Font("PDF", Font.BOLD, (int)(13*ajustex)));
			               botao.setBounds( (int)(ajustex*(1300)), (int)(ajustey*650),(int)(ajustex*200), (int)(ajustey*50) );
			               frame.getContentPane ().add (botao);
			               botao2.setFont(new Font("Limpar Tela", Font.BOLD, (int)(13*ajustex)));
			               botao2.setBounds( (int)(ajustex*(1300)), (int)(ajustey*750),(int)(ajustex*200), (int)(ajustey*50) );
			               frame.getContentPane ().add (botao2);
					}
				});
				frame.setVisible( true );
				}
			}
		});
		botao2.addActionListener(this);
		botao.addActionListener(this);
       frame.setVisible( true );
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("PDF"))
		{
			Document document = new Document(PageSize.A4);
			JOptionPane.showMessageDialog(frame, "PDf Gerado");
	        try {
	        	botao2.setVisible(false);
	        	botao.setVisible(false);
	    		frame.repaint();
	            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("advansGrafico"+anoSelect+".pdf"));

	            document.open();

	            PdfContentByte contentByte = writer.getDirectContent();

	            PdfTemplate template = contentByte.createTemplate(500, 500);

	            @SuppressWarnings("deprecation")
				Graphics2D g2 = template.createGraphics(500, 500);

	            double w = document.getPageSize().getWidth();           

	            double scale= w / frame.getContentPane().getWidth();

	            g2.scale(scale, scale);

	            frame.getContentPane().print(g2);

	            g2.dispose();

	            contentByte.addTemplate(template, 30, 300);

	        } catch (Exception g) {

	        	JOptionPane.showMessageDialog(frame, "Erro de memoria");
				System.exit(0);

	        } 

			document.close();
			Historico x= new Historico(frame,con);
			x.histor();

		}
		if(source.getText().equals("Limpar Tela"))
		{
			Historico x= new Historico(frame,con);
			x.histor();
		}
	}
}
