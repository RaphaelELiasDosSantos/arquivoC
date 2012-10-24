package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaVenda {

	Connection con;
	JFrame frame;
	public LogicaVenda(JFrame fram, Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public void venda(String strings[])
	{
		PreparedStatement statement;
		String str;
		str= "Insert into vendas(marca,modelo,Ano,Placa,ValorCompra,Garantia,ValorVenda,Nome,Telefone,Endereço,Cidade,Email,Obs1,Obs2,Obs3,mesVenda,anoVenda,diaVenda)"+ " values(";
		for(int i=0;i<=16;i++)
			{
				if(strings[i]==null)				str+= "null,";
				else 
				{
					if(strings[i].length()==0)				str+= "null,";
					else if(i!=4&&i!=6&&i!=15&&i!=16)		str+= "'"+strings[i] + "'" + ",";
					else				str+= strings[i] + ",";
				}
			}
		str+= strings[17] + ");";
		try {
			statement = con.prepareStatement(str);
			int result= statement.executeUpdate(str);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
	}

}
