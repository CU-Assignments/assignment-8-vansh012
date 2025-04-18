import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple login check (you can replace with database verification)
        if ("user".equals(username) && "password123".equals(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Invalid Credentials. Please try again.</h2>");
        }
    }
}
