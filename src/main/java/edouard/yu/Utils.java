package edouard.yu;

import java.sql.*;

public class Utils {
    public static void displayDepartment(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet result = statement.
                executeQuery( "SELECT deptno, dname, loc FROM dept" );

        while ( result.next() ) {
            int deptno = result.getInt( "deptno" );
            String dname = result.getString( "dname" );
            String loc = result.getString( "loc" );
            System.out.println("Department " + deptno + " is for "
                    + dname + " and located in " + loc + ".");
        }

        result.close();
        statement.close();
    }

    public static void moveDepartment(Connection connection,
                                      int empno,
                                      int newDeptno
    ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE emp SET deptno = ? WHERE empno = ?"
        );

        preparedStatement.setInt(1, newDeptno);
        preparedStatement.setInt(2, empno);

        int affectedEmp = preparedStatement.executeUpdate();


        if (affectedEmp > 0) {
            System.out.println("Update successful, employee with empno " + empno
                    + " moves to department " + newDeptno + ".");
        } else {
            System.out.println("Update failed.");
        }

        preparedStatement.close();
    }

    public static void displayTable(Connection connection, String tableName) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();


        // Print column names
        for (int i = 1; i <= columnsNumber; i++) {
            System.out.print(rsmd.getColumnName(i).toUpperCase() + " | ");
        }
        System.out.println();

        // Print rows
        while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(result.getString(i) + " | ");
            }
            System.out.println();
        }

        statement.close();
    }
}
