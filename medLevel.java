import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // Establish JDBC connection
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // SQL Query to search employee by ID
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(employeeId));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Display employee details
                out.println("<h2>Employee Details</h2>");
                out.println("<p>ID: " + rs.getInt("id") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Department: " + rs.getString("department") + "</p>");
            } else {
                out.println("<h2>No employee found with ID " + employeeId + "</h2>");
            }

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Error fetching employee details.</h2>");
        }
    }
}
