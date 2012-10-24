package projeto1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaDespesasIn {
	Connection con;
	JFrame frame;
	public LogicaDespesasIn(JFrame frame,Connection con)
	{
		this.frame=frame;
		this.con=con;
	}
	public String[] MesDesp()
	{
		int i=0;
		String str[] = new String[1000];
		try {
			PreparedStatement statement = con.prepareStatement("select * from despin order by mesVenda;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				if(result.getString(118).equals("1"))			str[i]="Janeiro";
				else if(result.getString(118).equals("2"))		str[i]="Fevereiro";
				else if(result.getString(118).equals("3"))		str[i]="Março";
				else if(result.getString(118).equals("4"))		str[i]="Abril";
				else if(result.getString(118).equals("5"))		str[i]="Maio";
				else if(result.getString(118).equals("6"))		str[i]="Junho";
				else if(result.getString(118).equals("7"))		str[i]="Julho";
				else if(result.getString(118).equals("8"))		str[i]="Agosto";
				else if(result.getString(118).equals("9"))		str[i]="Setembro";
				else if(result.getString(118).equals("10"))		str[i]="Outubro";
				else if(result.getString(118).equals("11"))		str[i]="Novembro";
				else if(result.getString(118).equals("12"))		str[i]="Dezembro";
				i++;
			}
			LogicaMostrar mostr = new LogicaMostrar(frame,con);
			str=mostr.tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] AnoDesp(String mes)
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
			String comando = "select * from despin where mesVenda ="+ mesNumero +" order by anoVenda;";
			PreparedStatement statement = con.prepareStatement(comando);
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(119);
				i++;
			}
			LogicaMostrar mostr = new LogicaMostrar(frame,con);
			str=mostr.tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] ProcuraDesp(String mes,String ano)
	{
		String str[]= new String[120];
		int i=0;
		int numColumns;
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
			PreparedStatement statement = con.prepareStatement("select * from despin where mesVenda = " + mesNumero + " and anoVenda =" + ano + ";");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				if(result.getString(j)!=null&&result.getString(j)!=""&&j<117)		str[j]=rsmd.getColumnName(j)+ ": "+result.getString(j);
				else if(result.getString(j)!=null&&result.getString(j)!=""&&j==118)		str[j]="Mes: " +result.getString(j);
				else if(result.getString(j)!=null&&result.getString(j)!=""&&j==119)		str[j]="Ano: " +result.getString(j);
			}
			LogicaMostrar mostr= new LogicaMostrar(frame,con);
			str=mostr.removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
		
	}
	public void removeDespAtual()
	{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;  
	    int year = cal.get(Calendar.YEAR); 
		String str="delete from despin where mesVenda = " + month + " and anoVenda =" + year + ";";
		PreparedStatement statement2;
		try {
			statement2 = con.prepareStatement(str);
			int x= statement2.executeUpdate(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
	}
	public String[] ProcuraDespAtual()
	{
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;  
	    int year = cal.get(Calendar.YEAR);  
		String str[]= new String[120];
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from despin where mesVenda = " + month + " and anoVenda =" + year + ";");
			ResultSet result= statement.executeQuery();
			if(result.first())
			{
				ResultSetMetaData rsmd = result.getMetaData();  
		        numColumns = rsmd.getColumnCount();
				for(int j=1;j<=numColumns;j++)
				{
					str[j]=result.getString(j);
				}
				return str;
			}
			else				return null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return null;
	}
	public void  AddDesp(String strings[])
	{
		PreparedStatement statement;
		String str;
		str= "Insert into despin(Func1,Func2,Func3,Prolabore1,"+
			"Prolabore2,Agua,Luz,Telefone,Contador,"+
			"NotaFiscal,Manutenção,Impressos,PdeLimpeza,Anuncios,Acic,"+
			"Consultas,";
		for(int i=1;i<=50;i++)			str+="Desp" + i + ",valorDesp" + i +",";
		str+="cont,mesVenda,anoVenda)" +	" values(";
		for(int i=0;i<=15;i++)
			{
				if(strings[i]==null)				str+= "null,";
				else 
				{
					if(strings[i].length()==0)			str+= "null,";
					else				str+= strings[i] + ",";
				}
			}
		for(int i=16;i<=115;i++)
		{
			if(strings[i]==null)				str+= "null,";
			else 
			{
				if(strings[i].length()==0)			str+= "null,";
				else 								str+= "'"+strings[i] + "'" + ",";
			}
			i++;
			if(i>=116)		break;
			if(strings[i]==null)				str+= "null,";
			else 
			{
				if(strings[i].length()==0)			str+= "null,";
				else								str+= strings[i]  + ",";
			}
		}
		for(int i=116;i<=117;i++)
		{
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
	}
}
