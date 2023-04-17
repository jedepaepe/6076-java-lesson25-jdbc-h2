import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws SQLException {
        System.out.println("hello");

        // connection
        Connection connection = DriverManager.getConnection("jdbc:h2:./cats");
        System.out.println("connected");

        // créer la table
        String sql = "create table if not exists CAT (ID integer primary key auto_increment, BREED varchar(32), SIZE double, WEIGHT double)";
        Statement statement = connection.createStatement();
        statement.execute(sql);

        // insérer un record

        sql = "insert into CAT (BREED, SIZE, WEIGHT) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Siamois");
        preparedStatement.setDouble(2, 29.3);
        preparedStatement.setDouble(3, 4.76);
        preparedStatement.execute();

        sql = "select * from CAT";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String breed = resultSet.getString("BREED");
            double size = resultSet.getDouble("SIZE");
            double weight = resultSet.getDouble("WEIGHT");
            System.out.println(id + " - " + breed + " - " + size + " - " + weight);
        }

        // fermeture
        connection.close();
    }
}
