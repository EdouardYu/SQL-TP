package edouard.yu.tp3jpa.service;

import edouard.yu.tp3jpa.entity.Emp;
import edouard.yu.tp3jpa.repository.EmpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmpService {
    private final EmpRepository empRepository;

    public List<Emp> getEmployees() {
        return this.empRepository.findAll();
    }

    public Emp addEmployee(Emp emp) {
        return this.empRepository.save(emp);
    }

    public Emp getEmployeeByID(Integer empno) {
        return this.empRepository.findById(empno)
                .orElseThrow(() -> new RuntimeException("Unknown employee"));
    }

    public Emp updateEmployee(Integer empno, Emp emp) {
        Emp employee = this.empRepository.findById(empno)
                .orElseThrow(() -> new RuntimeException("Unknown employee"));

        if(employee.getEmpno().equals(emp.getEmpno())) {
            return this.empRepository.save(emp);
        }

        throw new RuntimeException("Empno of the body doesn't correspond to that of the path variable");
    }


    public void deleteEmployee(Integer empno) {
        this.empRepository.deleteById(empno);
    }
}
