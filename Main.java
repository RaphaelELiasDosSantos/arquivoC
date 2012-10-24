package projeto1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {

	public static void inicia() throws Exception
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advans","root","29k3lxwi");		
		verificaSeTabelaExiste(con);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JFrame fram = new JFrame("Advans Veiculos");
				menu men=new menu(fram,con);
				men.createGUI();
			}
		});
	}
	//atualização
	public static void novajanela() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advans","root","29k3lxwi");		
		verificaSeTabelaExiste(con);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JFrame fram = new JFrame("Advans Veiculos");
				menu men=new menu(fram,con);
				men.NovJan();
			}
		});
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			inicia();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void verificaSeTabelaExiste(Connection con)
	{
		PreparedStatement statement;
		try {
			int i=0;
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				i++;
			}
			if(i<5)
			{
				crianovaCompra(con);
				criaNovoConsignado(con);
				criaVendas(con);
				criaDesp(con);
				criaLogin(con);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void criaLogin(Connection con)
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(1).equals("login"))				return;
			}
			//se passou é porque nao existe
			String str;
			str= "create table login"+
			"(adm varchar(50),senha varchar(50));";
			PreparedStatement statement2= con.prepareStatement(str);
			statement2.executeUpdate(str);
			String str2= "Insert into login(adm,senha)"+ " values('advans','raphael01');";
			statement2= con.prepareStatement(str2);
			statement2.executeUpdate(str2);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void criaDesp(Connection con)
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(1).equals("despin"))				return;
			}
			//se passou é porque nao existe
			String str;
			str= "create table DespIn"+
			"(Func1 Float,Func2 Float,Func3 Float,Prolabore1 Float,"+
			"Prolabore2 Float,Agua Float,Luz Float,Telefone Float,Contador Float,"+
			"NotaFiscal Float,Manutenção Float,Impressos Float,PdeLimpeza Float,Anuncios Float,Acic Float,"+
			"Consultas Float,";
			for(int i=1;i<=50;i++){
				str+= "Desp" + i + " varchar(150),";
				str+= "valorDesp" + i + " Float,";
			}
			str+="cont integer,mesVenda integer,anoVenda integer);";
			PreparedStatement statement2= con.prepareStatement(str);
			statement2.executeUpdate(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void crianovaCompra(Connection con)
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(1).equals("novacompra"))				return;
			}
			//se passou é porque nao existe
			String str;
			str= "create table novacompra"+
			"(marca varchar(50) not null,modelo varchar(100) not null,Ano varchar(20) not null,Placa varchar(50) not null,"+
			"Chassi varchar(50),Renavam varchar(50),DataCompra varchar(50) not null,ValorCompra integer not null,Obs1 varchar(150),"+
			"Obs2 varchar(150),Obs3 varchar(150),Obs4 varchar(150),Obs5 varchar(150),Obs6 varchar(150),Obs7 varchar(150),"+
			"Obs8 varchar(150),Obs9 varchar(150),ValorFinal integer not null,";
			for(int i=1;i<=50;i++){
				str+= "Desp" + i + " varchar(150),";
				str+= "valorDesp" + i + " integer,";
			}
			str+="contador integer,primary key(Placa));";
			PreparedStatement statement2= con.prepareStatement(str);
			statement2.executeUpdate(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void criaNovoConsignado(Connection con)
	{
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(1).equals("novoconsignado"))				return;
			}
			//se passou é porque nao existe
			String str;
			str= "create table novoconsignado"+
			"(marca varchar(50) not null,modelo varchar(100) not null,Ano varchar(20) not null,Placa varchar(50) not null,"+
			"Data varchar(20) not null,Proprietario varchar(200),Telefone varchar(100),Endereço varchar(100),Email varchar(30),"+
			"ValorPedido integer not null,Obs1 varchar(150),"+
			"Obs2 varchar(150),Obs3 varchar(150),Obs4 varchar(150),Obs5 varchar(150),Obs6 varchar(150),";
			str+="ValorFinal integer not null,primary key(Placa));";
			PreparedStatement statement2= con.prepareStatement(str);
			statement2.executeUpdate(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
	public static void criaVendas(Connection con)
	{
		PreparedStatement statement;
		try {
			int i=0;
			statement = con.prepareStatement("show tables from advans;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(1).equals("vendas"))				return;
			}
			//se passou é porque nao existe
			String str;
			str= "create table vendas"+
			"(marca varchar(50),modelo varchar(100),Ano varchar(20),Placa varchar(50),"+
			"ValorCompra integer,Garantia varchar(50),ValorVenda integer not null,Nome varchar(150),Telefone varchar(100),"+
			"Endereço varchar(100),Cidade varchar(30),Email varchar(100),"+
			"Obs1 varchar(400),"+
			"Obs2 varchar(400),Obs3 varchar(400),mesVenda integer,anoVenda integer,diaVenda integer,primary key(Placa))";
			PreparedStatement statement2= con.prepareStatement(str);
			statement2.executeUpdate(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			System.exit(0);
		}
	}
}