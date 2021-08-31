package student_mgn_taedi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student_mgn_taedi.dao.StudentDao;
import student_mgn_taedi.dto.Student;
import student_mgn_taedi.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	// singleton
	private static final StudentDaoImpl instance = new StudentDaoImpl();

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	private StudentDaoImpl() {
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String name = rs.getString("name");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		Student std = new Student(no, name, kor, eng, math);
		return std;
	}

	@Override
	public ArrayList<Student> selectStudentAll() {
		String sql = "select no, name, kor, eng, math from student";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Student> stdArr = new ArrayList<Student>();
			while (rs.next()) {
				stdArr.add(getStudent(rs));
			}
			return stdArr;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student selectStudentByNo(Student std) {
		String sql = "select no, name, kor, eng, math from student where no = ?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, std.getNo());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return getStudent(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudent(Student std) {
		String sql = "insert into student values(?,?,?,?,?)";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, std.getNo());
			pstmt.setString(2, std.getName());
			pstmt.setInt(3, std.getKor());
			pstmt.setInt(4, std.getEng());
			pstmt.setInt(5, std.getMath());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student std) {
		String sql = "update student set kor = ?, eng = ?, math = ? where no = ?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, std.getKor());
			pstmt.setInt(2, std.getEng());
			pstmt.setInt(3, std.getMath());
			pstmt.setInt(4, std.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student std) {
		String sql = "delete from student where no = ?";

		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, std.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
