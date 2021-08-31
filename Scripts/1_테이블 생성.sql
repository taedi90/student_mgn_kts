-- 내 스키마
DROP SCHEMA IF EXISTS student_mgn;

-- 내 스키마
CREATE SCHEMA student_mgn;

use student_mgn;

-- 학생
CREATE TABLE student_mgn.student (
	no   INTEGER     NOT NULL COMMENT '학번', -- 학번
	name VARCHAR(50) NOT NULL COMMENT '성명', -- 성명
	kor  INTEGER     NULL     COMMENT '국어', -- 국어
	eng  INTEGER     NULL     COMMENT '영어', -- 영어
	math INTEGER     NULL     COMMENT '수학' -- 수학
)
COMMENT '학생';

-- 학생
ALTER TABLE student_mgn.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			no -- 학번
		);