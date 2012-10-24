package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaCadastro {
	Connection con;
	JFrame frame;
	String strings[];
	public LogicaCadastro(JFrame fram, Connection con,String strings[])
	{
		frame=fram;
		this.con=con;
		this.strings=strings;
	}
	public boolean CadNovoVeiculo()
	{
		PreparedStatement statement2;
		ResultSet result2 = null;
		PreparedStatement statement3;
		ResultSet result3 = null;
		PreparedStatement statement4;
		ResultSet result4 = null;
		try {
			statement2 = con.prepareStatement("select * from novacompra where Placa = '" + strings[3] + "';");
			result2= statement2.executeQuery();
			statement3 = con.prepareStatement("select * from vendas where Placa = '" + strings[3] + "';");
			result3= statement3.executeQuery();
			statement4 = con.prepareStatement("select * from novoconsignado where Placa = '" + strings[3] + "';");
			result4= statement4.executeQuery();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		try {
			if(result2.first()||result3.first()||result4.first())
			{
				JOptionPane.showMessageDialog(frame, "Placa já existente!");
				return false;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		PreparedStatement statement;
		String str;
		str= "Insert into novacompra(marca,modelo,Ano,Placa,Chassi,Renavam,DataCompra,ValorCompra,Obs1,Obs2,Obs3,Obs4,Obs5,Obs6,Obs7,Obs8,Obs9,ValorFinal,";
		for(int i=1;i<=50;i++)			str+="Desp" + i + ",valorDesp" + i +",";
		str+="contador)" +	" values(";
		for(int i=0;i<=17;i++)
			{
				if(strings[i]==null)				str+= "null,";
				else 
				{
					if(strings[i].length()==0)			str+= "null,";
					else if(i!=7&&i!=17)		str+= "'"+strings[i] + "'" + ",";
					else				str+= strings[i] + ",";
				}
			}
		for(int i=18;i<=117;i++)
		{
			if(strings[i]==null)				str+= "null,";
			else 
			{
				if(strings[i].length()==0)			str+= "null,";
				else if(i!=7)		str+= "'"+strings[i] + "'" + ",";
				else				str+= strings[i] + ",";
			}
			i++;
			if(i>=118)		break;
			if(strings[i]==null)				str+= "null,";
			else 
			{
				if(strings[i].length()==0)			str+= "null,";
				else								str+= strings[i]  + ",";
			}
		}
		if(strings[118]==null)					str+= "null);";
		else
		{
			if(strings[118].length()!=0)			str+=  strings[118]  +");";
			else									str+= "null);";
		}
		try {
			statement = con.prepareStatement(str);
			statement.executeUpdate(str);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		/*for(int i=2;i<=50;i++){
				str= "alter table novacompra add Desp" + i + " varchar(150)";
				System.out.println(str);
				statement = con.prepareStatement(str);
				int result= statement.executeUpdate(str);
				str= "alter table novacompra add valorDesp" + i + " integer";
				System.out.println(str);
				statement = con.prepareStatement(str);
				result= statement.executeUpdate(str);
			}*/
		return true;
	}
	public boolean CadConsignado()
	{
		PreparedStatement statement2;
		ResultSet result2 = null;
		PreparedStatement statement3;
		ResultSet result3 = null;
		PreparedStatement statement4;
		ResultSet result4 = null;
		try {
			statement2 = con.prepareStatement("select * from novacompra where Placa = '" + strings[3] + "';");
			result2= statement2.executeQuery();
			statement3 = con.prepareStatement("select * from vendas where Placa = '" + strings[3] + "';");
			result3= statement3.executeQuery();
			statement4 = con.prepareStatement("select * from novoconsignado where Placa = '" + strings[3] + "';");
			result4= statement4.executeQuery();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		try {
			if(result2.first()||result3.first()||result4.first())
			{
				JOptionPane.showMessageDialog(frame, "Placa já existente!");
				return false;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		PreparedStatement statement;
		String str;
		str= "Insert into novoconsignado(marca,modelo,Ano,Placa,Data,Proprietario,Telefone,Endereço,Email,ValorPedido,Obs1,Obs2,Obs3,Obs4,Obs5,Obs6,ValorFinal)"+ " values(";
		for(int i=0;i<=15;i++)
			{
				if(strings[i]==null)				str+= "null,";
				else 
				{
					if(strings[i].length()==0)			str+= "null,";
					else if(i!=9)		str+= "'"+strings[i] + "'" + ",";
					else				str+= strings[i] + ",";
				}
			}
		str+= strings[16] + ");";
		try {
			statement = con.prepareStatement(str);
			int result= statement.executeUpdate(str);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return true;
	}
}
