package in.bitcode.CrudDemo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bitcode.CrudDemo.Model.Student;
import in.bitcode.CrudDemo.Service.Serviceimpl.Impl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudController {
	
	private Impl serviceimImpl;
	
	public StudController(Impl serviceimImpl) {
		super();
		this.serviceimImpl = serviceimImpl;
	}
	
	@GetMapping("/getall")
	public List<Student> getAllStudents(){
		return serviceimImpl.getAllstud();
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student student) {
		serviceimImpl.addStudent(student);
		return "student save suceessfully";
	}
	
	@GetMapping("{id}")
	public Student findStudent(@PathVariable int id) {
		return serviceimImpl.getSingle(id);
	}
	
	@PutMapping("{id}")
	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student stud) {
		return serviceimImpl.updStudent(stud, id);
	}
	
	@DeleteMapping("{id}")
	public String delStuent(@PathVariable int id) {
		serviceimImpl.deleteStudent(id);
		return "student is deleted";
	}

}
