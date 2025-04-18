import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SaveAttendanceServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String attendance = request.getParameter("attendance");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Establish JDBC connection
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Insert attendance record
            String query = "INSERT INTO attendance (student_id, attendance_status) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(studentId));
            stmt.setString(2, attendance);
            stmt.executeUpdate();

            out.println("<h2>Attendance for Student ID " + studentId + " has been marked as " + attendance + ".</h2>");
            
            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Error saving attendance record.</h2>");
        }
    }
}
