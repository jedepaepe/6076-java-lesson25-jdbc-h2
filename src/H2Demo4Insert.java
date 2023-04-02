import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Demo4Insert {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "")) {
            String sql = "insert into CAT (BREED, SIZE, WEIGHT) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Siamois");
            statement.setDouble(2, 2.23);
            statement.setDouble(3, 1.4);
            boolean result = statement.execute();
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
