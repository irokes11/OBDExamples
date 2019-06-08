import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

//wstawianie danych
public class insertSQL {
	public static void main (String[] args){	
		try {
			
			String url = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
			String user = "iseredyn";
			String password = "iseredyn";
		//	String sql1 = "INSERT INTO DZIALYIS (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('15','TOWARY','UL. 1 Czerwca 25')"
			String sql1 = "INSERT INTO OCENA (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('2','jeden +',1.5)";  //wstawianie danych  inna skladnia niz w v4
			String sql2 = "INSERT INTO OCENA (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('4','dwa +',2.5)";
			String sql3 = "INSERT INTO OCENA (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('6','trzy +',3.5)";
			String sql4 = "INSERT INTO OCENA (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('8','cztery +',4.5)";
			String sql5 = "INSERT INTO OCENA (IDO,WARTOSC_OPISOWA,WARTOSC_NUMERYCZNA) VALUES('10','pec +',5.5)";
			//String sql1 = ("UPDATE dzialyIS SET nr_dzialu = 10 WHERE nr_dzialu = 1");  //edycja rekordu
			//String sql1 = ("DELETE FROM dzialyIS  WHERE nr_dzialu = 15");  //kasoweanie rekordu
			//String sql1 = "SELECT nr_dzialu, nazwa_dzialu,siedziba FROM dzialyIS";  //zapuszczanie SELECT 
			
			
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("AutoCommit: "+connection.getAutoCommit()+ " "+connection.hashCode());
			Statement polecenie = connection.createStatement();	
			System.out.println("execute "+polecenie.executeUpdate(sql1));
			System.out.println("execute "+polecenie.executeUpdate(sql2));
			System.out.println("execute "+polecenie.executeUpdate(sql3));
			System.out.println("execute "+polecenie.executeUpdate(sql4));
			System.out.println("execute "+polecenie.executeUpdate(sql5));
			
			
			System.out.println("Inserted the following entry:");
			System.out.println(sql1);
			System.out.println(sql2);
			System.out.println(sql3);
			System.out.println(sql4);
			System.out.println(sql5);
			connection.close();
			
			
		} catch (Exception e) {
			System.out.println("Nieudane dodanie");	
			e.printStackTrace();
			return;
		}
		System.out.println("Sukces dodano dane" );
		
		
		}
	}


