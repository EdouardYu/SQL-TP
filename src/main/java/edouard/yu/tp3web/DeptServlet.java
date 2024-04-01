package edouard.yu.tp3web;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "deptServlet", value = "/dept-servlet")
public class DeptServlet extends HttpServlet {
    private Connection connection;
    @Override
    public void init() {
        try {
            Class.forName( "org.postgresql.Driver" );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "Xinyi.xian2509";
        try {
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Display departments in a web browser</h1>");

        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM dept");

            while(result.next()) {
                int deptno = result.getInt("deptno");
                String dname = result.getString("dname");
                String loc = result.getString("loc");

                out.println("<p>Department " + deptno + " is for "
                        + dname + " and located in " + loc + ".</p>");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.close();
    }

    @Override
    public void destroy() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}