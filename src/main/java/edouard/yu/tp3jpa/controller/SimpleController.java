package edouard.yu.tp3jpa.controller;

import edouard.yu.tp3jpa.entity.Emp;
import edouard.yu.tp3jpa.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class SimpleController {
    private final EmpService empService;
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello(@RequestParam(value = "name", required = false) String name) {
        if(name == null) name = "";
        return "<p>Hello " + name + "</p>";
    }

    @GetMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Emp> getEmployees() {
        return this.empService.getEmployees();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/employees",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Emp addEmployee(@RequestBody Emp emp) {
        return this.empService.addEmployee(emp);
    }

    @GetMapping(value="/employees/{empno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Emp getEmployeeByID(@PathVariable Integer empno) {
        return this.empService.getEmployeeByID(empno);
    }

    @PutMapping(value="/employees/{empno}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Emp updateEmployee(@PathVariable Integer empno, @RequestBody Emp emp) {
        return this.empService.updateEmployee(empno, emp);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/employees/{empno}")
    public void deleteEmployee(@PathVariable Integer empno) {
        this.empService.deleteEmployee(empno);
    }
}
