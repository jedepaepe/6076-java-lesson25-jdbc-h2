import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Demo2ConnectionWith {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            System.out.println("connecté");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}