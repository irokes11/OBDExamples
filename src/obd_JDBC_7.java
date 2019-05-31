import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

// dodanie do SELECT  nazwe kolumny 
public class obd_JDBC_7 {
	public static void main (String[] args){	
		try {
			
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String user = "iseredyn";
			String password = "iseredyn";
			//String sql1 = "INSERT INTO dzialyIS (nr_dzialu,nazwa_dzialu,siedziba) VALUES(20,'KSIEGOWOSC','UL. 1 LUTEGO 23')";  //wstawianie danych  inna skladnia niz w v4
			//String sql1 = ("UPDATE dzialyIS SET nr_dzialu = 10 WHERE nr_dzialu = 1");  //edycja rekordu
			//String sql1 = ("DELETE FROM dzialyIS  WHERE nr_dzialu = 15");  //kasoweanie rekordu
			String sql1 = "SELECT nr_dzialu, nazwa_dzialu,siedziba FROM dzialyIS";  //zapuszczanie SELECT 
			
			
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("AutoCommit: "+connection.getAutoCommit()+ " "+connection.hashCode());
			Statement polecenie = connection.createStatement();
			ResultSet rs = polecenie.executeQuery(sql1); // efect wyszukania jako nowy obiect "rs"  to przy SELECT
			ResultSetMetaData rsm = rs.getMetaData();
			int kolumn = rsm.getColumnCount();
					
			while (rs.next()) {
				for (int i =1; i<=kolumn; i++) {
					System.out.println(rsm.getColumnLabel(i)+":"+rs.getObject(i).toString());
				}
			System.out.println("----");	
			//System.out.println(rs.getInt("nr_dzialu")+ "|" + rs.getString("nazwa_dzialu") + "|" +rs.getString("siedziba"));
				
			}
			rs.close();
			
		//	System.out.println("execute "+polecenie.executeUpdate(sql1));
			connection.close();
			
			
		} catch (Exception e) {
			//nie ma polaczenia 
			System.out.println("Nieudane dodanie");	
			e.printStackTrace();
			return;
		}
		System.out.println("Sukces dodano dane" );
		}
	}

	


