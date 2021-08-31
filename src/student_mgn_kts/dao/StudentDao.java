package student_mgn_kts.dao;

import java.util.ArrayList;

import student_mgn_kts.dto.Student;

public interface StudentDao {
	
	ArrayList<Student> selectStudentAll();
	Student selectStudentByNo(Student std);
	int insertStudent(Student std);
	int updateStudent(Student std);
	int deleteStudent(Student std);
	
}
