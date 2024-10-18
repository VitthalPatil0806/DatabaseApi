package in.bitcode.CrudDemo.Service.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.bitcode.CrudDemo.Exception.ResourceException;
import in.bitcode.CrudDemo.Model.Student;
import in.bitcode.CrudDemo.Repo.StudRepository;
import in.bitcode.CrudDemo.Service.Services;

@Service
public class Impl implements Services{
	private StudRepository repository;
	
	public Impl(StudRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<Student> getAllstud() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);
		return null;
	}


	@Override
	public Student getSingle(int id) {
		// TODO Auto-generated method stub
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceException("Student", "Id", id);
		}
	}


	@Override
	public Student updStudent(Student stud,int id) {
		// TODO Auto-generated method stub
		Student existingStudent = repository.findById(id).orElseThrow(()->new ResourceException("Student", "Id", id));
		existingStudent.setName(stud.getName());
		existingStudent.setMarks(stud.getMarks());
		
		repository.save(existingStudent);
		return existingStudent;
	}


	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return "student deleted";
	}
	

}
