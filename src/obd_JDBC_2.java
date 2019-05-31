
public class obd_JDBC_2 {

	// check of JDBC driver
public static void main (String[] args){

String nazwaSterownika = "oracle.jdbc.driver.OracleDriver";

try {
	Class c = Class.forName(nazwaSterownika);
	System.out.println("Pakiet    :"+ c.getPackage());
	System.out.println("Pakiet    :"+ c.getName());
} catch (Exception e) {
	//sterownik nie odnaleziony
	System.out.println("Pakiet    :"+ e.getMessage());
	e.printStackTrace();
	return;
}
System.out.println("Sukces");
}
}
