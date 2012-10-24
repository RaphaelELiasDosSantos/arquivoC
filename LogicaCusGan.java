package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaCusGan {

	JFrame frame;
	Connection con;
	public LogicaCusGan(JFrame fram,Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public int ganhoTotal(String mes,String ano)
	{
		int res=0;
		try {
			String mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement = con.prepareStatement("select * from vendas where mesVenda ="+ mesNumero +" and anoVenda =" + ano+ " order by anoVenda;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				int custo= Integer.parseInt(result.getString(5));
				int venda= Integer.parseInt(result.getString(7));
				res = res + venda- custo;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return res;
	}
	public int custoTotal(String mes,String ano)
	{
		int res=0;
		try {
			String	mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement4 = con.prepareStatement("select * from despin where mesVenda ="+ mesNumero +" and anoVenda =" + ano+ " order by anoVenda;");
			ResultSet result4= statement4.executeQuery();
			while(result4.next())
			{
				for(int j=1;j<=16;j++)
				{
					if(result4.getString(j)!=null &&result4.getString(j)!="")
					{
						res+= Integer.parseInt(result4.getString(j));
					}
				}
				for(int j=18;j<=116;j=j+2)
				{
					if(result4.getString(j)!=null &&result4.getString(j)!="")
					{
						res+= Integer.parseInt(result4.getString(j));
					}
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return res;
	}
	public String[] vendas(String mes, String ano)
	{
		int i=0;
		String str[] = new String[1000];
		try {
			String mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement = con.prepareStatement("select * from vendas where mesVenda ="+ mesNumero +" and anoVenda =" + ano+ " order by anoVenda;");
			ResultSet result= statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();  
	        rsmd.getColumnCount();
			while(result.next())
			{
				int custo= Integer.parseInt(result.getString(5));
				int venda= Integer.parseInt(result.getString(7));
				int vt = venda-custo;
				str[i]=rsmd.getColumnName(7)+" Placa "+ result.getString(4)+ " : "+ vt;
				i++;
			}
			LogicaMostrar mostr= new LogicaMostrar(frame,con);
			String str2[]=mostr.removeNulos(str);
			return str2;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return null;
	}
	public String[] custos(String mes,String ano)
	{
		int i=0;
		String str[] = new String[1000];
		try {
			String	mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement4 = con.prepareStatement("select * from despin where mesVenda ="+ mesNumero +" and anoVenda =" + ano+ " order by anoVenda;");
			ResultSet result4= statement4.executeQuery();
			ResultSetMetaData rsmd2 = result4.getMetaData();  
	        rsmd2.getColumnCount();
			while(result4.next())
			{
				for(int j=1;j<=16;j++)
				{
					if(result4.getString(j)!=null &&result4.getString(j)!="")
					{
						str[i]=rsmd2.getColumnName(j)+" DespesasIndiretas: "+result4.getString(j);
						i++;
					}
				}
				for(int j=18;j<=116;j=j+2)
				{
					if(result4.getString(j)!=null &&result4.getString(j)!="")
					{
						str[i]=result4.getString(j-1)+" : "+result4.getString(j);
						i++;
					}
				}
			}
			LogicaMostrar mostr = new LogicaMostrar(frame,con);
			String str2[]=mostr.removeNulos(str);
			return str2;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return null;
	}
	public String[] AnoPossivel(String mes)
	{
		int i=0;
		String str[] = new String[1000];
		try {
			String mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement = con.prepareStatement("select * from vendas where mesVenda ="+ mesNumero +" order by anoVenda;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(17);
				i++;
			}
			mesNumero = null;
			if(mes.equals("Janeiro"))			mesNumero= "1";
			else if(mes.equals("Fevereiro"))	mesNumero= "2";
			else if(mes.equals("Março"))		mesNumero= "3";
			else if(mes.equals("Abril"))		mesNumero= "4";
			else if(mes.equals("Maio"))			mesNumero= "5";
			else if(mes.equals("Junho"))		mesNumero= "6";
			else if(mes.equals("Julho"))		mesNumero= "7";
			else if(mes.equals("Agosto"))		mesNumero= "8";
			else if(mes.equals("Setembro"))		mesNumero= "9";
			else if(mes.equals("Outubro"))		mesNumero= "10";
			else if(mes.equals("Novembro"))		mesNumero= "11";
			else if(mes.equals("Dezembro"))		mesNumero= "12";
			PreparedStatement statement4 = con.prepareStatement("select * from despin where mesVenda ="+ mesNumero +" order by anoVenda;");
			ResultSet result4= statement4.executeQuery();
			while(result4.next())
			{
				str[i]=result4.getString(119);
				i++;
			}
			LogicaMostrar mostr= new LogicaMostrar(frame,con);
			str=mostr.tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] todosAnos()
	{
		int i=0;
		String str[] = new String[1000];
		try {
			PreparedStatement statement = con.prepareStatement("select * from vendas order by anoVenda;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{ 
				str[i]=result.getString(17);
				i++;
			}
			PreparedStatement statement4 = con.prepareStatement("select * from despin order by anoVenda;");
			ResultSet result4= statement4.executeQuery();
			while(result4.next())
			{
				str[i]=result4.getString(119);
				i++;
			}
			LogicaMostrar mostr= new LogicaMostrar(frame,con);
			str=mostr.tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] MEsPossivel()
	{
		int i=0;
		String str[] = new String[1000];
		try {
			PreparedStatement statement = con.prepareStatement("select * from vendas order by mesVenda;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(16).equals("1"))			str[i]="Janeiro";
				else if(result.getString(16).equals("2"))		str[i]="Fevereiro";
				else if(result.getString(16).equals("3"))		str[i]="Março";
				else if(result.getString(16).equals("4"))		str[i]="Abril";
				else if(result.getString(16).equals("5"))		str[i]="Maio";
				else if(result.getString(16).equals("6"))		str[i]="Junho";
				else if(result.getString(16).equals("7"))		str[i]="Julho";
				else if(result.getString(16).equals("8"))		str[i]="Agosto";
				else if(result.getString(16).equals("9"))		str[i]="Setembro";
				else if(result.getString(16).equals("10"))		str[i]="Outubro";
				else if(result.getString(16).equals("11"))		str[i]="Novembro";
				else if(result.getString(16).equals("12"))		str[i]="Dezembro";
				i++;
			}
			PreparedStatement statement4 = con.prepareStatement("select * from despin order by mesVenda;");
			ResultSet result4= statement4.executeQuery();
			while(result4.next())
			{
				if(result4.getString(118).equals("1"))			str[i]="Janeiro";
				else if(result4.getString(118).equals("2"))		str[i]="Fevereiro";
				else if(result4.getString(118).equals("3"))		str[i]="Março";
				else if(result4.getString(118).equals("4"))		str[i]="Abril";
				else if(result4.getString(118).equals("5"))		str[i]="Maio";
				else if(result4.getString(118).equals("6"))		str[i]="Junho";
				else if(result4.getString(118).equals("7"))		str[i]="Julho";
				else if(result4.getString(118).equals("8"))		str[i]="Agosto";
				else if(result4.getString(118).equals("9"))		str[i]="Setembro";
				else if(result4.getString(118).equals("10"))		str[i]="Outubro";
				else if(result4.getString(118).equals("11"))		str[i]="Novembro";
				else if(result4.getString(118).equals("12"))		str[i]="Dezembro";
				i++;
			}
			LogicaMostrar mostr= new LogicaMostrar(frame,con);
			str=mostr.tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
		
	}
}
