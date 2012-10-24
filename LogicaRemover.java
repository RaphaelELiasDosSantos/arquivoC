package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaRemover {

	Connection con;
	JFrame frame;
	public LogicaRemover(JFrame fram, Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public void RemovedeTudo(String placa)
	{
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			String str;
			if(result.first())		
			{
				str="delete from novacompra where Placa = '" + placa + "';";
				PreparedStatement statement2 =con.prepareStatement(str);
				int x= statement2.executeUpdate(str);
			}
			else
			{
				PreparedStatement statement3 = con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
				ResultSet result2= statement3.executeQuery();
				if(!result2.first())
				{
					str="delete from vendas where Placa = '" + placa + "';";
					PreparedStatement statement4 =con.prepareStatement(str);
					int x= statement4.executeUpdate(str);
				}
				else
				{
					str="delete from novoconsignado where Placa = '" + placa + "';";
					PreparedStatement statement5 =con.prepareStatement(str);
					int x= statement5.executeUpdate(str);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
	}
	public void RemoveEstoque(String placa)
	{
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			String str;
			if(!result.first())		
			{
				str="delete from novoconsignado where Placa = '" + placa + "';";
				PreparedStatement statement2 =con.prepareStatement(str);
				int x= statement2.executeUpdate(str);
			}
			else
			{
				str="delete from novacompra where Placa = '" + placa + "';";
				PreparedStatement statement2 =con.prepareStatement(str);
				int x= statement2.executeUpdate(str);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
	}
		

}
