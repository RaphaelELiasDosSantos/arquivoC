package projeto1;
import java.awt.Dimension;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import javax.swing.JFrame;


	//Used Action Listner for JMenuItem & JRadioButtonMenuItem
	//Used Item Listner for JCheckBoxMenuItem
	public class menu implements ActionListener {

		JFrame frame;
		JScrollPane jspPane;
		Connection con;
		public menu(JFrame fram,Connection con)
		{
			frame=fram;
			this.con=con;
		}
		public JMenuBar createJMenuBar() {
			JMenuBar mainMenuBar;
			JMenu menu1, menu2,menu3;
			JMenuItem Menu1,NovoV, vendidos,RemoveV,ListaV,sair,historico,ganho,alterarV,NovaJanela,DepesasIn;
			mainMenuBar = new JMenuBar();
			menu3 = new JMenu("Arquivo");
			menu3.setMnemonic(KeyEvent.VK_M);
			mainMenuBar.add(menu3);
			NovaJanela = new JMenuItem("Nova Janela",
					KeyEvent.VK_T);
			NovaJanela.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F8, ActionEvent.ALT_MASK));
			NovaJanela.addActionListener(this);
			menu3.add(NovaJanela);
			Menu1 = new JMenuItem("Menu",
					KeyEvent.VK_T);
			Menu1.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F7, ActionEvent.ALT_MASK));
			Menu1.addActionListener(this);
			menu3.add(Menu1);
			// Sub Menu follows a seperator
			menu3.addSeparator();
			sair = new JMenuItem("Fechar Tudo",
					KeyEvent.VK_T);
			sair.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F10, ActionEvent.ALT_MASK));
			sair.addActionListener(this);
			menu3.add(sair);
			menu1 = new JMenu("Veiculos");
			menu1.setMnemonic(KeyEvent.VK_M);
			mainMenuBar.add(menu1);
			// Creating the MenuItems
			NovoV = new JMenuItem("Novo",
					KeyEvent.VK_T);
			// can be done either way for assigning shortcuts
			// menuItem.setMnemonic(KeyEvent.VK_T);
			// Accelerators, offer keyboard shortcuts to bypass navigating the menu
			// hierarchy.
			NovoV.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_1, ActionEvent.ALT_MASK));
			NovoV.addActionListener(this);
			menu1.add(NovoV);
			alterarV = new JMenuItem("Alterar",
					KeyEvent.VK_T);
			alterarV.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_2, ActionEvent.ALT_MASK));
			alterarV.addActionListener(this);
			menu1.add(alterarV);
			vendidos= new JMenuItem("Vender",
					KeyEvent.VK_T);
			vendidos.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_3, ActionEvent.ALT_MASK));
			vendidos.addActionListener(this);
			menu1.add(vendidos);
			RemoveV = new JMenuItem("Remover",
					KeyEvent.VK_T);
			RemoveV.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_4, ActionEvent.ALT_MASK));
			RemoveV.addActionListener(this);
			menu1.add(RemoveV);
			ListaV = new JMenuItem("Listar",
					KeyEvent.VK_T);
			ListaV.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_5, ActionEvent.ALT_MASK));
			ListaV.addActionListener(this);
			menu1.add(ListaV);
			// Menu Item with just an Image
			// Build second menu in the menu bar.
			menu2 = new JMenu("Finanças");
			menu2.setMnemonic(KeyEvent.VK_N);
			mainMenuBar.add(menu2);
			historico = new JMenuItem("Historico",
					KeyEvent.VK_T);
			historico.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F2, ActionEvent.ALT_MASK));
			historico.addActionListener(this);
			menu2.add(historico);
			ganho = new JMenuItem("Custos e Ganhos",
					KeyEvent.VK_T);
			ganho.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F3, ActionEvent.ALT_MASK));
			ganho.addActionListener(this);
			menu2.add(ganho);
			DepesasIn = new JMenuItem("Despesas Indiretas",
					KeyEvent.VK_T);
			DepesasIn.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_F4, ActionEvent.ALT_MASK));
			DepesasIn.addActionListener(this);
			menu2.add(DepesasIn);
			menu2 men = new menu2(frame,con);
			men.menu();

			return mainMenuBar;
		}
		void createGUI() {
			// Create and set up the window.
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			frame.setSize(tamTela.width/2,tamTela.height/2);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			login log = new login(frame,con);
			log.crialogin();
		}
		public void NovJan()
		{
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
			Dimension tamTela= toolkit.getScreenSize(); 
			frame.setSize(tamTela.width/2,tamTela.height/2);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			menu men= new menu(frame,con);
			men.vaimenu();
		}
		public void vaimenu()
		{
			frame.setJMenuBar(this.createJMenuBar());
			frame.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem) (e.getSource());
			if(source.getText().equals("Novo"))
			{
				cadastro cad=new cadastro(frame,con);
				cad.cadastrar();
			}
			else if(source.getText().equals("Fechar Tudo"))
			{
				System.exit(0);
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
			else if(source.getText().equals("Menu"))
			{
				menu2 men = new menu2(frame,con);
				men.menu();
			}
			else if(source.getText().equals("Listar"))
			{
				Mostrar most = new Mostrar(frame,con);
				most.mostra();
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
			else if(source.getText().equals("Historico"))
			{
				Historico hist= new Historico(frame,con);
				hist.histor();
			}
			else if(source.getText().equals("Nova Janela"))
			{
				try {
					Main.novajanela();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
					System.exit(0);
				}
			}
			else if(source.getText().equals("Despesas Indiretas"))
			{
				DepesasIn desp= new DepesasIn(frame,con);
				desp.despesas();
			}
			
		}
		
	}

