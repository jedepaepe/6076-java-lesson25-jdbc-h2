import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Demo3CreateTable {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            System.out.println("connecté");
            Statement statement = connection.createStatement();
            String sql = "create table CAT(" +
                    "ID integer primary key auto_increment," +
                    "BREED varchar(32)," +
                    "SIZE double," +
                    "WEIGHT double" +
                    ");";
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("enregistrement inséré");
            } else {
                System.out.println("erreur");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}