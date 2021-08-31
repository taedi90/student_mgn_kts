package student_mgn_kts.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import student_mgn_kts.dao.impl.StudentDaoImpl;
import student_mgn_kts.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest {
	StudentDaoImpl dao = StudentDaoImpl.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test05SelectStudentAll() {
		System.out.println("testSelectStudentAll");
		ArrayList<Student> stdArr = dao.selectStudentAll();
		Assert.assertNotNull(stdArr);
		for(Student std : stdArr) {
			System.out.println(std);
		}
	}

	@Test
	public void test03SelectStudentByNo() {
		System.out.println("test05SelectStudentByNo");
		Student std = new Student(5);
		Student res = dao.selectStudentByNo(std);
		Assert.assertNotNull(res);

		System.out.println(std.getNo() + "번 학생 정보");
		System.out.println(res);
	}

	@Test
	public void test01InsertStudent() {
		System.out.println("testInsertStudent");
		Student std = new Student(5,"아무개", 90, 80, 70);
		int res = dao.insertStudent(std);
		Assert.assertEquals(1, res);
		
		//출력
		System.out.println(std.getNo() + "번 학생 추가");
		ArrayList<Student> stdArr = dao.selectStudentAll();
		for(Student student : stdArr) {
			System.out.println(student);
		}
		
	}

	@Test
	public void test02UpdateStudent() {
		System.out.println("testUpdateStudent");
		Student std = new Student(5,"아무개", 10, 10, 10);
		int res = dao.updateStudent(std);
		Assert.assertEquals(1, res);
		
		//출력
		System.out.println(std.getNo() + "번 학생 점수 변경");
		ArrayList<Student> stdArr = dao.selectStudentAll();
		for(Student student : stdArr) {
			System.out.println(student);
		}
		
	}

	@Test
	public void test04DeleteStudent() {
		System.out.println("testDeleteStudent");
		Student std = new Student(5);
		int res = dao.deleteStudent(std);
		Assert.assertEquals(1, res);
		
		//출력
		System.out.println(std.getNo() + "번 학생 삭제");
		ArrayList<Student> stdArr = dao.selectStudentAll();
		for(Student student : stdArr) {
			System.out.println(student);
		}
	}

}
