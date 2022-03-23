import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*DONT USE IN PRODUCTION. Use environment variables*/
public class SimpleSelect {

public static void main(String[] args)
   {
   try
       {
       Class.forName("com.informix.jdbc.IfxDriver");
       FileWriter fwTrace = new FileWriter("log/JDBCTrace.log");
       PrintWriter pwTrace = new PrintWriter(fwTrace);
       DriverManager.setLogWriter(pwTrace);
       String debug_url = "SQLIDEBUG=log/sqlidebug.trace";
       String url = "jdbc:informix-sqli://localhost:9088/sysmaster:INFORMIXSERVER=informix;" + debug_url;
       Connection connection = DriverManager.getConnection(url, "informix", "in4mix");
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT rec_num, lname FROM person;");
       while (resultSet.next())
           System.out.println(resultSet.getObject(1) + "|" + resultSet.getObject(2));
       }
   catch (Exception e)
       {
       e.printStackTrace();
       }
   }
}
