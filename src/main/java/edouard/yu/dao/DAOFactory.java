package edouard.yu.dao;

import edouard.yu.dao.implement.DeptDAO;
import edouard.yu.dao.implement.EmpDAO;

import java.sql.Connection;

public class DAOFactory {
    private final Connection connect;

    public DAOFactory(Connection connect) {
        this.connect = connect;
    }

    public DeptDAO getDeptDAO() {
        return new DeptDAO(this.connect);
    }

    public EmpDAO getEmpDAO() {
        return new EmpDAO(this.connect);
    }
}
