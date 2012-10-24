package projeto1;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaMostrar {

	Connection con;
	JFrame frame;
	public LogicaMostrar(JFrame fram, Connection con)
	{
		frame=fram;
		this.con=con;
	}
	public String[] ProcuraVendas(String mes,String ano)
	{
		int i=0;
		String str[] = new String[100];
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
			String comando = "select Placa from vendas where mesVenda = "+ mesNumero +" and anoVenda = "+ ano + ";";
			PreparedStatement statement = con.prepareStatement(comando);
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(1);
				i++;
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
			
		}
		return str;
	}
	public String[] ProcuraVendporPlaca(String placa)
	{
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from vendas where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				if(result.getString(j)!=null&&result.getString(j)!="")		str[j]=rsmd.getColumnName(j)+ ": "+result.getString(j);
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] ProcuraVendporPlaca2(String placa)
	{        
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from vendas where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				if(result.getString(j)!=null&&result.getString(j)!="")		str[j]=rsmd.getColumnName(j)+ ": "+result.getString(j);
			}
			Calendar data2= Calendar.getInstance();
			data2.set(Calendar.DAY_OF_MONTH, Integer.parseInt(result.getString(18)));  
	        data2.set(Calendar.MONTH, Integer.parseInt(result.getString(16))-1);  
	        data2.set(Calendar.YEAR, Integer.parseInt(result.getString(17)));  
	        data2.set(Calendar.HOUR_OF_DAY, 00);  
	        data2.set(Calendar.MINUTE, 00);  
	        data2.set(Calendar.SECOND, 00);  
		    Calendar cal = Calendar.getInstance();
		    if((int)((cal.getTimeInMillis()-data2.getTimeInMillis())/86400000)>Integer.parseInt(result.getString(6)))		str[19]="Garantia Vencida "+(int)((cal.getTimeInMillis()-data2.getTimeInMillis())/86400000) + " dias desde seu inicio";
		    else																											str[19]="Garantia Em andamento "+(int)((cal.getTimeInMillis()-data2.getTimeInMillis())/86400000) + " dias desde seu inicio";
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		
		return str;
	}
	public String[] ProcuraVendporPlacaComNulos(String placa)
	{
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from vendas where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				str[j]=result.getString(j);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] AnosDisponiveisVenda(String mes)
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
			String comando = "select * from vendas where mesVenda ="+ mesNumero +" order by anoVenda;";
			PreparedStatement statement = con.prepareStatement(comando);
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(17);
				i++;
			}
			str=tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] Meses()
	{
		String  meses[] = {"Janeiro", "Fevereiro", "Março","Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return meses;
	}
	public String[] Anos(){
		String anos[] = new String[100];
		for (int i =0; i<=25;i++)
		{
		anos[i]="19"+( String.valueOf(90+i));
		}
		
		return anos;
	}
	public String[] MesesDisponiveisVenda()
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
			str=tiraIguais(str,i);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] tiraIguais(String str[],int aux)
	{
		String str2[] = new String[12];
		boolean passou=false;
		int contador=0;
		for(int i=0;i<aux;i++)
		{
			passou=false;
			for(int j=0;j<i;j++)
			{
				if(str[i].equals(str[j]))
				{
					passou=true;
					break;
				}
			}
			if(passou==false)
			{
				str2[contador]=str[i];
				contador++;
			}
		}
		str2=removeNulos(str2);
		return str2;
	}
	public String[] ProcuraEstoque(String placa)
	{
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			if(!result.first())		
			{
				PreparedStatement statement2 =con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
				result= statement2.executeQuery();
			}
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				if(j==119)			break;
				if(result.getString(j)!=null&&result.getString(j)!="")		str[j]=rsmd.getColumnName(j)+ ": "+result.getString(j);
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] procuraConsigComNulos(String placa)
	{
		String str[]= new String[120];
		int numColumns;
		try {
			PreparedStatement statement =con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				str[j]=result.getString(j);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] ProcuraCompraComNulos(String placa)
	{
		String str[]= new String[120];
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				str[j]=result.getString(j);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] ProcuraEstoque2(String placa)
	{
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			if(!result.first())		
			{
				PreparedStatement statement2 =con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
				result= statement2.executeQuery();
			}
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
			for(int j=1;j<=numColumns;j++)
			{
				if(j==119)			break;
				if(result.getString(j)!=null&&result.getString(j)!="")		str[j]=result.getString(j);
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] concatena(String[] str1, String[] str2)
	{
		String[] nula = {null};
		boolean entrou=false;
		ArrayList<String> list = new ArrayList<String>();
		list.add(null);
		for(String s : str1) {
		   if(s != null && s.length() > 0) {
		       list.add(s);
		       entrou=true;
		   }
		}
		for(String s : str2) {
			   if(s != null && s.length() > 0) {
			       list.add(s);
			       entrou=true;
			   }
		}
		if(entrou==false)			return nula;
		return list.toArray(new String[list.size()]);
	}
	public String ValordeVenda(String placa)
	{
		
		String str[]= new String[120];
		int i=0;
		int numColumns;
		try {
			PreparedStatement statement = con.prepareStatement("select * from novacompra where Placa = '" + placa + "';");
			ResultSet result= statement.executeQuery();
			if(!result.first())		
			{
				PreparedStatement statement2 =con.prepareStatement("select * from novoconsignado where Placa = '" + placa + "';");
				result= statement2.executeQuery();
			}
			result.first();
			ResultSetMetaData rsmd = result.getMetaData();  
	        numColumns = rsmd.getColumnCount();
	        if(rsmd.getColumnName(10).equals("ValorPedido"))			return result.getString(10);
	        else
	        {
	        	int vf=0;
	        	vf+= Integer.parseInt(result.getString(8));
	        	for(int j=19;j<=118;j++)
				{
					if(j%2==0&&result.getString(j)!=null&&result.getString(j)!="")		vf+=Integer.parseInt(result.getString(j));
				}
	        	return ""+vf;
	        }
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return null;
	}
	public String[] MostraCompras()
	{
		PreparedStatement statement;
		String str[]= new String[150];
		int i=0;
		try {
			statement = con.prepareStatement("select Placa from novacompra;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(1);
				i++;
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
	}
	public String[] MostraConsignados()
	{
		PreparedStatement statement;
		String str[]= new String[150];
		int i=0;
		try {
			statement = con.prepareStatement("select Placa from novoconsignado;");
			ResultSet result= statement.executeQuery();
			while(result.next())
			{
				str[i]=result.getString(1);
				i++;
			}
			str=removeNulos(str);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro de conexão com Banco de dados");
			System.exit(0);
		}
		return str;
		
	}
	public String MostraVendas()
	{
		return null;
		
	}
	public String[] removeNulos(String str[])
	{
		 ArrayList<String> list = new ArrayList<String>();
		 list.add(null);
		    for(String s : str) {
		       if(s != null && s.length() > 0) {
		          list.add(s);
		       }
		    }

		    str = list.toArray(new String[list.size()]);
		    return str;
		
	}
}
