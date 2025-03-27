create database ExamManagementDB

use ExamManagementDB

CREATE TABLE Account (
	account_id INT IDENTITY(0,1) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) CHECK (role IN ('admin', 'teacher', 'student'))
);

CREATE TABLE Subject (
    subject_id INT IDENTITY(1,1) PRIMARY KEY,
    subject_name NVARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Teacher (
    teacher_id INT IDENTITY(1,1) PRIMARY KEY,
	first_name NVARCHAR(50) NOT NULL,
	last_name NVARCHAR(50) NOT NULL,
	birth_day DATE NOT NULL,
	gender NVARCHAR(5) CHECK (gender IN (N'Nam', N'Nữ')) NOT NULL,
	phone_number VARCHAR(11),
    email VARCHAR(50),
	account_id INT NOT NULL,
	birth_day_formatted AS CONVERT(VARCHAR(10), birth_day, 103),
	CONSTRAINT fk_teacher_account FOREIGN KEY (account_id) REFERENCES Account(account_id) ON DELETE CASCADE 
);

CREATE TABLE TeacherSubject(
	teacher_id INT NOT NULL,
	subject_id INT NOT NULL,
	PRIMARY KEY (teacher_id, subject_id),
	CONSTRAINT fk_teachersubject_teacher FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id) ON DELETE CASCADE ,
	CONSTRAINT fk_teachersubject_subject FOREIGN KEY (subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE 
);

CREATE TABLE Class (
    class_id INT IDENTITY(1,1) PRIMARY KEY,
    class_name NVARCHAR(50) UNIQUE NOT NULL,
    teacher_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (teacher_id, subject_id) REFERENCES TeacherSubject(teacher_id, subject_id)
);

CREATE TABLE Student (
    student_id INT IDENTITY(1,1) PRIMARY KEY,
	first_name NVARCHAR(50) NOT NULL,
	last_name NVARCHAR(50) NOT NULL,
	birth_day DATE NOT NULL,
	gender NVARCHAR(5) CHECK (gender IN (N'Nam', N'Nữ')) NOT NULL,
	phone_number VARCHAR(11), 
    email VARCHAR(50),
	account_id INT NOT NULL,
	birth_day_formatted AS CONVERT(VARCHAR(10), birth_day, 103),
	CONSTRAINT fk_student_account FOREIGN KEY (account_id) REFERENCES Account(account_id) ON DELETE CASCADE 
);

CREATE TABLE StudentClass (
	student_id INT NOT NULL,
	class_id INT NOT NULL,
	PRIMARY KEY (student_id, class_id),
	CONSTRAINT fk_studentclass_student FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE ,
	CONSTRAINT fk_studentclass_class FOREIGN KEY (class_id) REFERENCES Class(class_id)
);

CREATE TABLE Question (
    question_id INT IDENTITY(1,1) PRIMARY KEY,
    question_text NVARCHAR(1000) NOT NULL,
    option_a NVARCHAR(500) NOT NULL,
    option_b NVARCHAR(500) NOT NULL,
    option_c NVARCHAR(500) NOT NULL,
    option_d NVARCHAR(500) NOT NULL,
    correct_answer VARCHAR(1) NOT NULL CHECK (correct_answer IN ('A', 'B', 'C', 'D')),
    subject_id INT NOT NULL,
    CONSTRAINT fk_question_subject FOREIGN KEY (subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE 
);

CREATE TABLE Exam (
    exam_id INT IDENTITY(1,1) PRIMARY KEY,
    exam_name NVARCHAR(150) NOT NULL,
    subject_id INT NOT NULL,
	status VARCHAR(150) NOT NULL CHECK (status in ('pending', 'in progress', 'finished')),
	duration INT NOT NULL,
    start_time DATETIME,
    end_time DATETIME,
	start_time_formatted AS CONVERT(VARCHAR(20), start_time, 108) + ' ' + CONVERT(VARCHAR(20), start_time, 105) PERSISTED,
	end_time_formatted AS CONVERT(VARCHAR(20), end_time, 108) + ' ' + CONVERT(VARCHAR(20), end_time, 105) PERSISTED,
    total_question INT NOT NULL,
    CONSTRAINT fk_exam_subject FOREIGN KEY (subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE 
);

CREATE TABLE ExamQuestion (
    exam_id INT NOT NULL,
    question_id INT NOT NULL,
    PRIMARY KEY (exam_id, question_id),
    CONSTRAINT fk_examquestion_exam FOREIGN KEY (exam_id) REFERENCES Exam(exam_id) ON DELETE CASCADE ,
    CONSTRAINT fk_examquestion_question FOREIGN KEY (question_id) REFERENCES Question(question_id)
);

CREATE TABLE ExamStudent(
	exam_id INT NOT NULL,
	student_id INT NOT NULL,
	class_id INT NOT NULL,
	PRIMARY KEY (exam_id, student_id),
	CONSTRAINT fk_examstudent_exam FOREIGN KEY (exam_id) REFERENCES Exam(exam_id) ON DELETE CASCADE ,
    CONSTRAINT fk_examstudent_studentclass FOREIGN KEY (student_id, class_id) REFERENCES StudentClass(student_id, class_id)
);

CREATE TABLE Result (
    result_id INT IDENTITY(1,1) PRIMARY KEY,
    student_id INT NOT NULL,
    exam_id INT NOT NULL,
    total_question INT NOT NULL,
    total_correct_answers INT NOT NULL,
	submit_time DATETIME NOT NULL,
    score FLOAT NOT NULL,
	submit_time_formatted AS CONVERT(VARCHAR(20), submit_time, 108) + ' ' + CONVERT(VARCHAR(20), submit_time, 105) PERSISTED,
	UNIQUE (student_id, exam_id),
    CONSTRAINT fk_result_student FOREIGN KEY (student_id) REFERENCES Student(student_id),
    CONSTRAINT fk_result_exam FOREIGN KEY (exam_id) REFERENCES Exam(exam_id) ON DELETE CASCADE 
);

CREATE TABLE Answer (
	answer_id INT IDENTITY(1,1) NOT NULL,
    result_id INT NOT NULL,
    question_id INT NOT NULL,
    answer VARCHAR(1) CHECK (answer IN ('A', 'B', 'C', 'D')),
	is_correct BIT NOT NULL,
    PRIMARY KEY (result_id, question_id),
    CONSTRAINT fk_answer_result FOREIGN KEY (result_id) REFERENCES Result(result_id) ON DELETE CASCADE ,
    CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES Question(question_id)
);

/*tao du lieu*/
INSERT INTO Account (username, password, role) VALUES
('ad', 'ad', 'admin');

