package edouard.yu.dao.implement;

import edouard.yu.dao.DAO;
import edouard.yu.pojo.Dept;
import edouard.yu.pojo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmpDAO extends DAO<Emp> {
    public EmpDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Emp find(int id) throws SQLException {
        PreparedStatement pstmt = this.connect
                .prepareStatement("SELECT * FROM emp WHERE empno = ?");
        pstmt.setInt(1, id);

        ResultSet result = pstmt.executeQuery();
        if(!result.next()) return null;

        int empno = result.getInt("empno");
        String ename = result.getString("ename");
        String efirst = result.getString("efirst");
        String job = result.getString("job");

        Emp mgr = this.find(result.getInt("mgr"));

        Date hiredate = result.getDate("hiredate");
        int sal = result.getInt("sal");
        int comm = result.getInt("comm");
        String tel = result.getString("tel");

        DAO<Dept> departmentDao = new DeptDAO(this.connect);
        Dept department = departmentDao.find(result.getInt("deptno"));

        return new Emp(empno, ename, efirst, job, mgr, hiredate, sal, comm, tel, department);

    }

    @Override
    public boolean create(Emp object) {
        return false;
    }

    @Override
    public boolean update(Emp object) {
        return false;
    }

    @Override
    public boolean delete(Emp object) {
        return false;
    }
}
