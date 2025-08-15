import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveRecordToRDS {

    // Database connection details (replace with your RDS instance details)
    private static final String DB_URL = "jdbc:mysql://database-1.c70sos6cgu5d.ap-south-1.rds.amazonaws.com:3306/Company";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "Suyog123456789";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 3. Prepare the SQL INSERT statement with placeholders
            String sql = "INSERT INTO Employee (e_id, e_name, e_address) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // 4. Set the values for the prepared statement
            preparedStatement.setInt(1, 1);             // e_id
            preparedStatement.setString(2, "Suyog");    // e_name
            preparedStatement.setString(3, "Nasik");    // e_address

            // 5. Execute the INSERT statement
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            // 6. Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
