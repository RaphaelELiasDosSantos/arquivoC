package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaAltera {
	Connection con;
	JFrame frame;
	public LogicaAltera(JFrame fram, Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public void AlteraTudo(String placa,String Dados[])
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
				LogicaCadastro logcad = new LogicaCadastro(frame,con,Dados);
				logcad.CadNovoVeiculo();
			}
			else
			{
				PreparedStatement statement3 = con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
				ResultSet result2= statement3.executeQuery();
				if(!result2.first())
				{
					PreparedStatement statement7 = con.prepareStatement("select * from vendas where Placa = '" + placa + "';");
					ResultSet result7= statement7.executeQuery();
					result7.first();
			        String[] str2= new String[18];
					for(int j=1;j<=5;j++)
					{
						str2[j-1]=result7.getString(j);
					}
					for(int i=5; i <=14;i++)		str2[i]=Dados[i-5];
					str2[15]=result7.getString(16);
					str2[16]=result7.getString(17);
					str2[17]=result7.getString(18);
					str="delete from vendas where Placa = '" + placa + "';";
					PreparedStatement statement4 =con.prepareStatement(str);
					int x= statement4.executeUpdate(str);
					LogicaVenda logvend = new LogicaVenda(frame,con);
					logvend.venda(str2);
				}
				else
				{
					str="delete from novoconsignado where Placa = '" + placa + "';";
					PreparedStatement statement5 =con.prepareStatement(str);
					int x= statement5.executeUpdate(str);
					LogicaCadastro logcad = new LogicaCadastro(frame,con,Dados);
					logcad.CadConsignado();
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
	}
}
