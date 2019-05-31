import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//dodanie tabeli

public class obd_JDBC_4 {
	public static void main (String[] args){	
		try {
			
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String user = "iseredyn";
			String password = "iseredyn";
			//String sql1 = "CREATE TABLE testyIS (nr_dzialu integer not null, nazwa_dzialu varchar2(30),siedziba varchar2(50) not null)";
			String sql1 = "CREATE TABLE BAZA (nr_dzial integer not null, nazwa_dzial varchar2(30),siedzibaHQ varchar2(50) not null)";
			//String sql1 = "INSERT INTO OCENA (ide,wartosc_opisowa,wartosc_numeryczna) VALUES (2,'dwa','2')";
			
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("AutoCommit: "+connection.getAutoCommit()+ " "+connection.hashCode());
			Statement polecenie = connection.createStatement();
			System.out.println("execute "+polecenie.executeUpdate(sql1));
			connection.close();
			
			
		} catch (Exception e) {
			//nie ma polaczenia 
			System.out.println("Nieudane dodanie");	
			e.printStackTrace();
			return;
		}
		System.out.println("Sukces dodano tabelke" );
		}
	}
