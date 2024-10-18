package in.bitcode.CrudDemo.Service;

import java.util.List;

import in.bitcode.CrudDemo.Model.Student;

public interface Services {
	public List<Student> getAllstud();
	public String addStudent(Student student);
	public Student getSingle(int id);
	public Student updStudent(Student stud,int id);
	public String deleteStudent(int id);
}
