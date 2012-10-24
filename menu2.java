package projeto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menu2 implements ActionListener{

	JFrame frame;
	Connection con;
	public menu2(JFrame frame2,Connection con)
	{
		this.frame=frame2;
		this.con=con;
	}
	
	public void menu ()
	{
			frame.getContentPane ().removeAll();
			frame.setContentPane(new JPanel());
			frame.setLayout(null);
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			float ajustey = (float)tamTela.height/1080;
			float ajustex = (float)tamTela.width/1920;
			int x = 10;
			JLabel labels[] = new JLabel[30];
			JButton botoes[] = new JButton[10];
		    frame.setLayout(null); 
		    frame.getContentPane ().setBackground(new Color(220,220,255));
		    labels[0]= new JLabel("Menu");
			labels[0].setFont(new Font("Menu", Font.BOLD, (int)(50*ajustex)));
			labels[0].setBounds((int)(ajustex*(x+800)),(int)(ajustey*40),(int)(ajustex*180),(int)(ajustey*130));
		    labels[1]= new JLabel("Veículos");
			labels[1].setFont(new Font("Veículos", Font.BOLD, (int)(30*ajustex)));
			labels[1].setBounds((int)(ajustex*(x+400)),(int)(ajustey*150),(int)(ajustex*180),(int)(ajustey*130));
			labels[2]= new JLabel("Finanças");
			labels[2].setFont(new Font("Finanças", Font.BOLD, (int)(30*ajustex)));
			labels[2].setBounds((int)(ajustex*(x+800)),(int)(ajustey*150),(int)(ajustex*180),(int)(ajustey*130));
			labels[3]= new JLabel("Arquivo");
			labels[3].setFont(new Font("Arquivo", Font.BOLD, (int)(30*ajustex)));
			labels[3].setBounds((int)(ajustex*(x+1100)),(int)(ajustey*150),(int)(ajustex*180),(int)(ajustey*130));
		    botoes[0]=new JButton("Novo");
		    botoes[0].setFont(new Font("Novo", Font.BOLD, (int)(13*ajustex)));
		    botoes[0].setBounds( (int)(ajustex*(x+350)), (int)(ajustey*300),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[0]);
			botoes[1]=new JButton("Alterar");
		    botoes[1].setFont(new Font("Alterar", Font.BOLD, (int)(13*ajustex)));
		    botoes[1].setBounds( (int)(ajustex*(x+350)), (int)(ajustey*400),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[1]);
			botoes[2]=new JButton("Remover");
		    botoes[2].setFont(new Font("Remover", Font.BOLD, (int)(13*ajustex)));
		    botoes[2].setBounds( (int)(ajustex*(x+350)), (int)(ajustey*500),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[2]);
			botoes[3]=new JButton("Vender");
		    botoes[3].setFont(new Font("Vender", Font.BOLD, (int)(13*ajustex)));
		    botoes[3].setBounds( (int)(ajustex*(x+350)), (int)(ajustey*600),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[3]);
			botoes[4]=new JButton("Listar");
		    botoes[4].setFont(new Font("Listar", Font.BOLD, (int)(13*ajustex)));
		    botoes[4].setBounds( (int)(ajustex*(x+350)), (int)(ajustey*700),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[4]);
			botoes[5]=new JButton("Histórico");
		    botoes[5].setFont(new Font("Histórico", Font.BOLD, (int)(13*ajustex)));
		    botoes[5].setBounds( (int)(ajustex*(x+750)), (int)(ajustey*300),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[5]);
			botoes[6]=new JButton("Custos e Ganhos");
		    botoes[6].setFont(new Font("Ganho total", Font.BOLD, (int)(13*ajustex)));
		    botoes[6].setBounds( (int)(ajustex*(x+750)), (int)(ajustey*400),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[6]);
			botoes[8]=new JButton("Despesas Indiretas");
		    botoes[8].setFont(new Font("Depesas Indiretas", Font.BOLD, (int)(13*ajustex)));
		    botoes[8].setBounds( (int)(ajustex*(x+750)), (int)(ajustey*500),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[8]);
			botoes[7]=new JButton("Nova Janela");
		    botoes[7].setFont(new Font("Nova Janela", Font.BOLD, (int)(13*ajustex)));
		    botoes[7].setBounds( (int)(ajustex*(x+1050)), (int)(ajustey*300),(int)(ajustex*200), (int)(ajustey*50) );
			frame.getContentPane ().add (botoes[7]);
			frame.setVisible(true);
			frame.repaint();
			for(int i=0;i<=3;i++) frame.getContentPane().add(labels[i]);
			for(int i=0;i<=8;i++)		botoes[i].addActionListener(this);
			
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) (e.getSource());
		if(source.getText().equals("Novo"))
		{
			cadastro cad=new cadastro(frame,con);
			cad.cadastrar();
		}
		else if(source.getText().equals("Nova Janela"))
		{
			try {
				Main.novajanela();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
				System.exit(0);
			}
		}
		else if(source.getText().equals("Alterar"))
		{
			Alterar altera= new Alterar(frame,con);
			altera.altera();
		}
		else if(source.getText().equals("Remover"))
		{
			Remover rem= new Remover(frame,con);
			rem.remove();
		}
		else if(source.getText().equals("Vender"))
		{
			Vender venda= new Vender(frame,con);
			venda.venda();
		}
		else if(source.getText().equals("Custos e Ganhos"))
		{
			CusGan x= new CusGan(frame,con);
			x.rendimento();
		}
		else if(source.getText().equals("Histórico"))
		{
			Historico hist= new Historico(frame,con);
			hist.histor();
		}
		else if(source.getText().equals("Listar"))
		{
			Mostrar most=new Mostrar(frame,con);
			most.mostra();
		}
		else if(source.getText().equals("Despesas Indiretas"))
		{
			DepesasIn desp= new DepesasIn(frame,con);
			desp.despesas();
		}
	}
	
}
