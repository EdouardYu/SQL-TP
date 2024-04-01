package edouard.yu.tp3jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Emp {
    @Id
    private Integer empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "efirst")
    private String efirst;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Integer mgr;
    @Column(name = "hiredate")
    private Date hiredate;
    @Column(name = "sal")
    private Integer sal;
    @Column(name = "comm")
    private Integer comm;
    @Column(name = "tel")
    private String tel;
    @Column(name = "deptno")
    private Integer deptno;
}
