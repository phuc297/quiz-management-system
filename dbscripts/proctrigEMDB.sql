use ExamManagementDB

/*InsertStudent*/
GO
CREATE PROCEDURE InsertStudent
	@username VARCHAR(50),
	@password VARCHAR(50),
	@first_name NVARCHAR(50),
	@last_name NVARCHAR(50),
	@birth_day DATE,
	@gender NVARCHAR(5),
	@phone_number VARCHAR(11),
	@email VARCHAR(50)
AS
BEGIN
	DECLARE @account_id INT
	INSERT INTO Account (username, password, role) VALUES (@username, @password, 'student')
	SET @account_id = SCOPE_IDENTITY()

	IF @account_id IS NOT NULL -- Check if the INSERT INTO Account statement was successful
	BEGIN
		INSERT INTO Student (first_name, last_name, birth_day, gender, phone_number, email, account_id) VALUES
			(@first_name, @last_name, @birth_day, @gender, @phone_number, @email, @account_id)

		DECLARE @student_id INT
		SET @student_id = SCOPE_IDENTITY()

		IF @student_id IS NULL 
		BEGIN
			DELETE Account WHERE account_id = @account_id
		END
	END
	
END;
GO

/*InsertTeacher*/
GO
CREATE PROCEDURE InsertTeacher
	@username VARCHAR(50),
	@password VARCHAR(50),
	@first_name NVARCHAR(50),
	@last_name NVARCHAR(50),
	@birth_day DATE,
	@gender NVARCHAR(5),
	@phone_number VARCHAR(11),
	@email VARCHAR(50)
AS
BEGIN
	DECLARE @account_id INT
	INSERT INTO Account (username, password, role) VALUES (@username, @password, 'teacher')
	SET @account_id = SCOPE_IDENTITY()

	IF @account_id IS NOT NULL -- Check if the INSERT INTO Account statement was successful
	BEGIN
		INSERT INTO Teacher (first_name, last_name, birth_day, gender, phone_number, email, account_id) VALUES
			(@first_name, @last_name, @birth_day, @gender, @phone_number, @email, @account_id)
	END
END;
GO

/*GetAllClass*/
GO
CREATE PROCEDURE GetAllClass
AS
BEGIN
	SELECT c.*, subject_name, total_students, t.first_name + ' ' + t.last_name AS teacher_name FROM Class c
	JOIN Subject s ON s.subject_id = c.subject_id
	JOIN (SELECT class_id, COUNT(*) AS total_students FROM StudentClass GROUP BY class_id) AS sc ON sc.class_id = c.class_id
	JOIN Teacher t ON t.teacher_id = c.teacher_id
END;
GO

/*GetClassesOfTeacherTotalStudents*/
GO
CREATE PROCEDURE GetClassesOfTeacherTotalStudents
    @teacher_id INT
AS
BEGIN
	SELECT c.class_id, class_name, c.subject_id, subject_name, total_students FROM Class c
	INNER JOIN Subject s ON s.subject_id = c.subject_id
	INNER JOIN (SELECT class_id, COUNT(*) AS total_students FROM StudentClass GROUP BY class_id) AS sc ON sc.class_id = c.class_id
	WHERE c.teacher_id = @teacher_id
END;
GO

/*GetClassesOfStudent*/
GO
CREATE PROCEDURE GetClassesOfStudent
    @student_id INT
AS
BEGIN
	SELECT c.class_id, c.class_name, t.first_name + ' ' + t.last_name AS teacher_name, s.subject_name  FROM Class c
	JOIN StudentClass sc ON sc.class_id = c.class_id
	JOIN Teacher t ON t.teacher_id = c.teacher_id
	JOIN Subject s ON s.subject_id = c.subject_id
	WHERE sc.student_id = @student_id
END;
GO

/*GetSubjectsOfTeacher*/
GO
CREATE PROCEDURE GetSubjectsOfTeacher
    @teacher_id INT
AS
BEGIN
	SELECT ts.subject_id, subject_name FROM TeacherSubject ts
	JOIN Subject s ON s.subject_id = ts.subject_id
	WHERE teacher_id = @teacher_id
END;
GO

/*GetTeacherBySubject*/
GO
CREATE PROCEDURE GetTeacherBySubject 
    @subject_id INT
AS
BEGIN
	SELECT t.* FROM TeacherSubject ts
	JOIN Teacher t ON t.teacher_id = ts.teacher_id
	WHERE subject_id = @subject_id
END;
GO

/*GetStudentsInClass*/
GO
CREATE PROCEDURE GetStudentsInClass 
    @class_id INT
AS
BEGIN
    SELECT s.* FROM Class c
	JOIN StudentClass sc ON sc.class_id = c.class_id
	JOIN Student s ON s.student_id = sc.student_id
	WHERE c.class_id = @class_id
END;
GO

/*GetQuestionById*/
GO
CREATE PROCEDURE GetQuestionById
	@question_id INT
AS
BEGIN
	SELECT q.question_id, q.question_text, q.option_a , q.option_b, q.option_c, q.option_d, q.correct_answer, s.subject_id, subject_name FROM Question q
	JOIN Subject s ON s.subject_id = q.subject_id
	WHERE question_id = @question_id;
END;
GO

/*GetAllQuestions*/
GO
CREATE PROCEDURE GetAllQuestions
AS
BEGIN
	SELECT q.question_id, q.question_text, q.option_a , q.option_b, q.option_c, q.option_d, q.correct_answer, s.subject_id, subject_name FROM Question q
	JOIN Subject s ON s.subject_id = q.subject_id
END;
GO

/*GetAllQuestionsOrderBySubject*/
GO
CREATE PROCEDURE GetAllQuestionsOrderBySubject
AS
BEGIN
	SELECT q.question_id, q.question_text, q.option_a , q.option_b, q.option_c, q.option_d, q.correct_answer, s.subject_id, subject_name FROM Question q
	JOIN Subject s ON s.subject_id = q.subject_id
	ORDER BY subject_id
END;
GO

/*GetQuestionsOrderBySubject*/
GO
CREATE PROCEDURE GetQuestionsOrderBySubject
	@teacher_id INT
AS
BEGIN
	SELECT q.question_id, q.question_text, q.option_a , q.option_b, q.option_c, q.option_d, q.correct_answer, s.subject_id, subject_name FROM Question q
	JOIN TeacherSubject ts ON ts.subject_id = q.subject_id
	JOIN Subject s ON s.subject_id = q.subject_id
	WHERE ts.teacher_id = @teacher_id
	ORDER BY q.subject_id
END;
GO

/*GetQuestionsInSubject*/
GO
CREATE PROCEDURE GetQuestionsInSubject
    @subject_id INT
AS
BEGIN
	SELECT sub.subject_name, s.* FROM Question s 
	JOIN Subject sub ON sub.subject_id =s.subject_id
	WHERE sub.subject_id = @subject_id;
END;
GO

/*GetQuestionsInTeacher*/
GO
CREATE PROCEDURE GetQuestionsInTeacher
    @teacher_id INT
AS
BEGIN
	SELECT q.question_id, q.question_text, q.option_a , q.option_b, q.option_c, q.option_d, q.correct_answer, subject_name FROM TeacherSubject ts
	JOIN Subject s ON s.subject_id = ts.subject_id
	JOIN Question q ON q.subject_id = s.subject_id
	WHERE teacher_id = @teacher_id
END;
GO

/*GetQuestionsInExam*/
GO
CREATE PROCEDURE GetQuestionsInExam
    @exam_id INT
AS
BEGIN
    SELECT q.*
	FROM Question q
	JOIN ExamQuestion eq ON eq.question_id = q.question_id
	WHERE eq.exam_id = @exam_id;
END;
GO

/*GetExamForStudent*/
GO
CREATE PROCEDURE GetExamForStudent
    @student_id INT
AS
BEGIN
    SELECT e.exam_id, e.exam_name, e.subject_id, s.subject_name, e.status, e.duration, e.start_time_formatted, e.end_time_formatted, e.total_question FROM Exam e
	JOIN ExamStudent es ON es.exam_id = e.exam_id
	JOIN Subject s ON s.subject_id = e.subject_id
	WHERE es.student_id = @student_id AND e.status = 'in progress' AND e.exam_id NOT IN ( SELECT exam_id FROM Result WHERE student_id = @student_id);
END;
GO

/*GetExamTeacherClass*/
GO
CREATE PROCEDURE GetExamTeacherClass
    @teacher_id INT
AS
BEGIN
    SELECT e.exam_id, e.exam_name, e.subject_id, s.subject_name, e.status, e.start_time_formatted, e.duration, e.total_question FROM Exam e
	JOIN (SELECT exam_id, class_id FROM ExamStudent GROUP BY exam_id, class_id) es ON es.exam_id = e.exam_id
	JOIN Class c ON c.class_id = es.class_id
	JOIN Subject s ON s.subject_id = e.subject_id
	WHERE c.teacher_id = @teacher_id
END;
GO

/*GetAllExams*/
GO
CREATE PROCEDURE GetAllExams
AS
BEGIN
	SELECT e.exam_id, e.exam_name, e.subject_id, s.subject_name, e.status, e.start_time_formatted, e.end_time_formatted, e.total_question, e.duration FROM Exam e
	JOIN Subject s ON s.subject_id = e.subject_id
	ORDER BY exam_id DESC
END;
GO

/*GetAllExamsOrderBySubject*/
GO
CREATE PROCEDURE GetAllExamsOrderBySubject
AS
BEGIN
	SELECT e.exam_id, e.exam_name, e.subject_id, s.subject_name, e.status, e.start_time_formatted, e.end_time_formatted, e.total_question FROM Exam e
	JOIN Subject s ON s.subject_id = e.subject_id
	ORDER BY subject_id
END;
GO

/*GetAllExamsOrderByStatus*/
GO
CREATE PROCEDURE GetAllExamsOrderByStatus
AS
BEGIN
	SELECT e.exam_id, e.exam_name, e.subject_id, s.subject_name, e.status, e.start_time_formatted, e.end_time_formatted, e.total_question FROM Exam e
	JOIN Subject s ON s.subject_id = e.subject_id
	ORDER BY status
END;
GO

/*GetResultStudent*/
GO
CREATE PROCEDURE GetResultStudent
	@student_id INT
AS
BEGIN
	SELECT r.*, exam_name, subject_name FROM Result r
	JOIN Exam e ON e.exam_id = r.exam_id
	JOIN Subject s ON s.subject_id = e.subject_id
	WHERE student_id =	@student_id;
END;
GO

/*GetResultByExam*/
GO
CREATE PROCEDURE GetResultByExam
	@exam_id INT
AS
BEGIN
	SELECT r.*, exam_name, subject_name FROM Result r
	JOIN Exam e ON e.exam_id = r.exam_id
	JOIN Subject s ON s.subject_id = e.subject_id
	WHERE r.exam_id = @exam_id
END;
GO

/*GetResultStudentOrderSubject*/
GO
CREATE PROCEDURE GetResultStudentOrderSubject
	@student_id INT
AS
BEGIN
	SELECT r.*, exam_name, subject_name FROM Result r
	JOIN Exam e ON e.exam_id = r.exam_id
	JOIN Subject s ON s.subject_id = e.subject_id
	WHERE student_id =	@student_id;
END;
GO

/*StartExam*/
GO
CREATE PROCEDURE StartExam
    @exam_id INT
AS
BEGIN
	IF (SELECT total_question FROM Exam WHERE exam_id = @exam_id)=(SELECT COUNT(exam_id) FROM ExamQuestion WHERE exam_id = @exam_id GROUP BY exam_id)
	BEGIN
		UPDATE Exam SET status = 'in progress' WHERE exam_id = @exam_id
	END
	ELSE
	BEGIN
		PRINT 'Cannot Start Exam Because Exam Questions Is Not Enough!'
	END
END;
GO

/*InsertAllStudentInClassToExam*/
GO
CREATE PROCEDURE InsertAllStudentInClassToExam
	@exam_id INT,
	@class_id INT
AS
BEGIN
	INSERT INTO ExamStudent
	SELECT @exam_id, * FROM StudentClass
	WHERE class_id = @class_id
END;
GO

/*InsertAllResult*/
GO
CREATE PROCEDURE InsertAllResult
	@exam_id INT
AS
BEGIN
	DECLARE @total_question INT
	SELECT @total_question = total_question FROM Exam WHERE exam_id = @exam_id;
	INSERT INTO Result (student_id, exam_id, total_question, total_correct_answers, submit_time, score)
	SELECT es.student_id, @exam_id, @total_question, 0, GETDATE(), 0 FROM ExamStudent es WHERE exam_id = @exam_id;
END
GO

/*InsertResult*/
GO
CREATE PROCEDURE InsertResult
    @student_id INT,
	@exam_id INT
AS
BEGIN
	DECLARE @total_question INT
	SELECT @total_question = total_question FROM Exam WHERE exam_id = @exam_id;
	INSERT INTO Result (student_id, exam_id, total_question, total_correct_answers, submit_time, score) VALUES
		(@student_id, @exam_id, @total_question, 0, GETDATE(), 0);
END
GO

GO
CREATE PROCEDURE InsertAnswer
    @exam_id INT,
	@student_id INT,
    @question_id INT,
	@answer VARCHAR(1)
AS
BEGIN
    SET NOCOUNT ON;

	DECLARE @result_id INT;
	SELECT @result_id = result_id FROM Result  WHERE exam_id = @exam_id AND student_id = @student_id;

    INSERT INTO Answer (result_id, question_id, answer, is_correct)
    SELECT @result_id, q.question_id, @answer, CASE WHEN q.correct_answer = @answer THEN 1 ELSE 0 END
    FROM Result r
    INNER JOIN ExamQuestion eq ON eq.exam_id = r.exam_id
    INNER JOIN Question q ON q.question_id = eq.question_id
	WHERE eq.question_id = @question_id AND r.result_id = @result_id
END
GO

GO
CREATE TRIGGER ExamQuestion_Insert_Trigger
ON ExamQuestion
AFTER INSERT
AS
BEGIN
    -- Kiểm tra số lượng câu hỏi của mỗi đề thi
    DECLARE @exam_id INT, @question_count INT, @total_question INT
    SELECT @exam_id = exam_id FROM inserted
    SELECT @question_count = COUNT(*) FROM ExamQuestion WHERE exam_id = @exam_id
    SELECT @total_question = total_question FROM Exam WHERE exam_id = @exam_id

    IF @question_count > @total_question
    BEGIN
        RAISERROR('Số câu hỏi đã vượt quá số lượng câu hỏi của đề thi', 16, 1)
        ROLLBACK TRANSACTION
    END
END
GO

GO
CREATE PROCEDURE SubmitAnswer
    @exam_id INT,
	@student_id INT
AS
BEGIN
	DECLARE @result_id INT;
	SELECT @result_id = result_id FROM Result  WHERE exam_id = @exam_id AND student_id = @student_id;

	UPDATE Result
	SET total_correct_answers = (SELECT COUNT(*) FROM Answer WHERE Answer.result_id = Result.result_id AND Answer.is_correct = 1),
	submit_time = GETDATE(),
	score = (SELECT CAST(COUNT(*) AS FLOAT)/CAST(Result.total_question AS FLOAT)*10 FROM Answer WHERE Answer.result_id = Result.result_id AND Answer.is_correct = 1)
	WHERE result_id = @result_id
END
GO






















/*UpdateAccount*/
GO
CREATE PROCEDURE UpdateAccount
	@account_id INT,
	@password VARCHAR(50)
AS
BEGIN
	UPDATE Account SET
	password = @password
	WHERE account_id = @account_id;
END;
GO

/*UpdateStudent*/
GO
CREATE PROCEDURE UpdateStudent
    @student_id INT,
	@first_name NVARCHAR(50),
	@last_name NVARCHAR(50),
	@birth_day DATE,
	@gender NVARCHAR(5),
	@phone_number VARCHAR(11),
    @email VARCHAR(50)
AS
BEGIN
	UPDATE Student SET
	first_name = @first_name,
	last_name = @last_name,
	birth_day = @birth_day,
	gender = @gender,
	phone_number = @phone_number,
	email = @email
	WHERE student_id = @student_id;
END;
GO

/*UpdateTeacher*/
GO
CREATE PROCEDURE UpdateTeacher
    @teacher_id INT,
	@first_name NVARCHAR(50),
	@last_name NVARCHAR(50),
	@birth_day DATE,
	@gender NVARCHAR(5),
	@phone_number VARCHAR(11),
    @email VARCHAR(50)
AS
BEGIN
	UPDATE Teacher SET
	first_name = @first_name,
	last_name = @last_name,
	birth_day = @birth_day,
	gender = @gender,
	phone_number = @phone_number,
	email = @email
	WHERE teacher_id = @teacher_id;
END;
GO

/*UpdateQuestion*/
GO
CREATE PROCEDURE UpdateQuestion
	@question_id INT,
	@question_text NVARCHAR(1000),
    @option_a NVARCHAR(500),
	@option_b NVARCHAR(500),
	@option_c NVARCHAR(500),
	@option_d NVARCHAR(500),
	@correct_answer VARCHAR(1)
AS
BEGIN
	UPDATE Question SET
	question_text = @question_text,
	option_a = @option_a,
	option_b = @option_b,
	option_c = @option_c,
	option_d = @option_d,
	correct_answer = @correct_answer
	WHERE question_id = @question_id;
END;
GO