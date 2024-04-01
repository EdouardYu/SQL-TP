package edouard.yu.pojo;

import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private String efirst;
    private String job;
    private Emp mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private String tel;
    private Dept department;

    public Emp() {
    }

    public Emp(
            int empno,
            String ename,
            String efirst,
            String job,
            Emp mgr,
            Date hiredate,
            int sal,
            int comm,
            String tel,
            Dept department
    ) {
        this.empno = empno;
        this.ename = ename;
        this.efirst = efirst;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.tel = tel;
        this.department = department;
    }

    public int getEmpno() {
        return this.empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEfirst() {
        return this.efirst;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Emp getMgr() {
        return this.mgr;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return this.hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return this.sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return this.comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Dept getDepartment() {
        return this.department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "\n\tempno=" + empno +
                ",\n\tename='" + ename + '\'' +
                ",\n\tefirst='" + efirst + '\'' +
                ",\n\tjob='" + job + '\'' +
                ",\n\tmgr=" + mgr +
                ",\n\thiredate=" + hiredate +
                ",\n\tsal=" + sal +
                ",\n\tcomm=" + comm +
                ",\n\ttel='" + tel + '\'' +
                ",\n\tdepartment=" + department +
                "\n}";
    }
}
