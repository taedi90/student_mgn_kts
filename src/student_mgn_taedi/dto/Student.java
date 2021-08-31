package student_mgn_taedi.dto;

public class Student {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int no) {
		super();
		this.no = no;
	}

	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Student(int no, String name, int kor, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		int sum = kor + eng + math;
		int avg = sum / 3;
		
		return String.format("[학번=%s, 성명=%s, 국어=%s, 영어=%s, 수학=%s, 총점=%s, 평균 =%s]", no, name, kor, eng, math, sum, avg);
	}

}
