package in.bitcode.CrudDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bitcode.CrudDemo.Model.Student;

@Repository
public interface StudRepository extends JpaRepository<Student,Integer>{

}
