package edouard.yu;

import edouard.yu.dao.DAO;
import edouard.yu.dao.DAOFactory;
import edouard.yu.pojo.Dept;
import edouard.yu.pojo.Emp;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Load JDBC Driver. */
        try {
            Class.forName( "org.postgresql.Driver" );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pass = "Xinyi.xian2509";
            Connection connection = DriverManager.getConnection( url, user, pass );
            // Requests to bdd will be here
            System.out.println("DB Connected");
            Utils.displayDepartment(connection);

            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the empno of the employee you want to move from department? ");
            int empno = sc.nextInt();
            System.out.print("To which new department do you want to move it? ");
            int newDeptno = sc.nextInt();
            sc.close();
            Utils.moveDepartment(connection, empno, newDeptno);

            Utils.displayTable(connection, "emp");

            DAOFactory daoFactory = new DAOFactory(connection);

            DAO<Dept> departmentDao = daoFactory.getDeptDAO();
            Dept dept20 = departmentDao.find(20);
            System.out.println(dept20);

            DAO<Emp> empDAO = daoFactory.getEmpDAO();
            Emp emp = empDAO.find(7369);
            System.out.println(emp);

            connection.close();
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
    }
}