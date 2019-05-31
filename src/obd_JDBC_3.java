import java.sql.Connection;
import java.sql.DriverManager;

public class obd_JDBC_3 {

	//Connection to DB
	public static void main (String[] args){	
	try {
		
		String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
		String user = "iseredyn";
		String password = "iseredyn";
		
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("AutoCommit: "+connection.getAutoCommit()+ " "+connection.hashCode());
		connection.close();
		
		
	} catch (Exception e) {
		//nie ma polaczenia 
		System.out.println("Nieudane polacznie z baza danych sorry");	
		e.printStackTrace();
		return;
	}
	System.out.println("Sukces");
	}
}
