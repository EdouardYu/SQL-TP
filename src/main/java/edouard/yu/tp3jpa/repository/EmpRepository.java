package edouard.yu.tp3jpa.repository;

import edouard.yu.tp3jpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
}
