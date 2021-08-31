package student_mgn_taedi.dao;

import java.util.ArrayList;

import student_mgn_taedi.dto.Student;

public interface StudentDao {
	
	ArrayList<Student> selectStudentAll();
	Student selectStudentByNo(Student std);
	int insertStudent(Student std);
	int updateStudent(Student std);
	int deleteStudent(Student std);
	
}
