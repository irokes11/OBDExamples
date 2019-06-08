import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class obd_JDBC_2_15 {

	static class Namiary {
		static String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
		static String user = "iseredyn";
		static String password = "iseredyn";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String sql1 = "{ CALL szef(?,?)}";
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("AutoCommit: "+connection.getAutoCommit());
			CallableStatement polecenie = connection.prepareCall(sql1);
			polecenie.setInt(1, 7);
			polecenie.registerOutParameter(2, java.sql.Types.VARCHAR);
			System.out.println("execute; "+ polecenie.execute());
			System.out.println("wynik: "+polecenie.getObject(2));
			connection.close();
			
		} catch (SQLException e) {
			
			System.out.println("Blad programu");
			e.printStackTrace();
			return;
		}
			System.out.println("Sukces");
		}

	}

}
