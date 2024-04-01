package edouard.yu.dao.implement;

import edouard.yu.dao.DAO;
import edouard.yu.pojo.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO extends DAO<Dept> {
    public DeptDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Dept find(int id) throws SQLException {
        PreparedStatement pstmt = this.connect
                .prepareStatement("SELECT * FROM dept WHERE deptno = ?");
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery();
        result.next();

        int deptno = result.getInt("deptno");
        String dname = result.getString("dname");
        String loc = result.getString("loc");

        return new Dept(deptno, dname, loc);
    }

    @Override
    public boolean create(Dept object) {
        return false;
    }

    @Override
    public boolean update(Dept object) {
        return false;
    }

    @Override
    public boolean delete(Dept object) {
        return false;
    }
}
