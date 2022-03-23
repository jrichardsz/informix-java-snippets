import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*DONT USE IN PRODUCTION. Use environment variables*/
public class SimpleConnection {

public static void main(String[] args)
   {
   try
       {
       Class.forName("com.informix.jdbc.IfxDriver");
       FileWriter fwTrace = new FileWriter("c:\\JDBCTrace.log");
       PrintWriter pwTrace = new PrintWriter(fwTrace);
       DriverManager.setLogWriter(pwTrace);
       String debug_url = "SQLIDEBUG=C:\\sqlidebug.trace";
       String url = "jdbc:informix-sqli://localhost:9088/sysmaster:INFORMIXSERVER=informix;" + debug_url;
       Connection connection = DriverManager.getConnection(url, "informix", "in4mix");
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT FIRST 1 DBINFO('version','full') FROM systables;");
       while (resultSet.next())
           System.out.println(resultSet.getObject(1));
       }
   catch (Exception e)
       {
       e.printStackTrace();
       }
   }
}
