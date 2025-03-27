package DAO;

import DTO.ExamDTO;
import DTO.ExamQuestionDTO;
import DTO.AccountDTO;
import DTO.AnswerDTO;
import DTO.ResultDTO;
import DTO.StudentDTO;
import DTO.ClassDTO;
import DTO.QuestionDTO;
import DTO.Score;
import DTO.SubjectDTO;
import java.util.ArrayList;
import DTO.TeacherDTO;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetToData {

    public static ArrayList<TeacherDTO> toTeacher(ResultSet rs) {
        ArrayList<TeacherDTO> teacherList = new ArrayList<TeacherDTO>();

        try {
            while (rs.next()) {
                TeacherDTO teacher = new TeacherDTO();
                teacher.setTeacherId(rs.getInt("teacher_id"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setBirthday(rs.getString("birth_day_formatted"));
                teacher.setGender(rs.getString("gender"));
                teacher.setPhoneNumber(rs.getString("phone_number"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAccountId(rs.getInt("account_id"));

                teacherList.add(teacher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teacherList;
    }

    public static ArrayList<ClassDTO> toClass(ResultSet rs) {
        ArrayList<ClassDTO> classList = new ArrayList<ClassDTO>();

        try {
            while (rs.next()) {
                ClassDTO cl = new ClassDTO();
                try {
                    cl.setClassId(rs.getInt("class_id"));
                } catch (Exception e) {
                }
                try {
                    cl.setClassName(rs.getString("class_name"));
                } catch (Exception e) {
                }
                try {
                    cl.setTeacherId(rs.getInt("teacher_id"));
                } catch (Exception e) {
                }
                try {
                    cl.setSubjectId(rs.getInt("subject_id"));
                } catch (Exception e) {
                }
                try {
                    cl.setSubjectName(rs.getString("subject_name"));
                } catch (Exception e) {
                }
                try {
                    cl.setTeacherName(rs.getString("teacher_name"));
                } catch (Exception e) {
                }
                try {
                    cl.setTotalStudents(rs.getInt("total_students"));
                } catch (Exception e) {
                }

                classList.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return classList;
    }

    public static ArrayList<StudentDTO> toStudent(ResultSet rs) {
        ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();

        try {
            while (rs.next()) {
                StudentDTO student = new StudentDTO();
                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setBirthday(rs.getString("birth_day_formatted"));
                student.setGender(rs.getString("gender"));
                student.setPhoneNumber(rs.getString("phone_number"));
                student.setEmail(rs.getString("email"));
                student.setAccountId(rs.getInt("account_id"));

                studentList.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentList;
    }

    public static ArrayList<SubjectDTO> toSubject(ResultSet rs) {
        ArrayList<SubjectDTO> subjectList = new ArrayList<SubjectDTO>();

        try {
            while (rs.next()) {
                SubjectDTO subject = new SubjectDTO();
                subject.setSubjectId(rs.getInt("subject_id"));
                subject.setSubjectName(rs.getString("subject_name"));

                subjectList.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return subjectList;
    }

    public static ArrayList<QuestionDTO> toQuestion(ResultSet rs) {
        ArrayList<QuestionDTO> questionList = new ArrayList<QuestionDTO>();

        try {
            while (rs.next()) {
                QuestionDTO question = new QuestionDTO();
                question.setQuestionId(rs.getInt("question_id"));
                question.setQuestionText(rs.getString("question_text"));
                question.setOptionA(rs.getString("option_a"));
                question.setOptionB(rs.getString("option_b"));
                question.setOptionC(rs.getString("option_c"));
                question.setOptionD(rs.getString("option_d"));
                question.setCorrectAnswer(rs.getString("correct_answer"));
                try {
                    question.setSubjectId(rs.getInt("subject_id"));
                } catch (Exception e) {
                }
                try {
                    question.setSubjectName(rs.getString("subject_name"));
                } catch (Exception e) {
                }

                questionList.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return questionList;
    }

    public static ArrayList<AccountDTO> toAccount(ResultSet rs) {
        ArrayList<AccountDTO> accountList = new ArrayList<AccountDTO>();

        try {
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccounId(rs.getInt("account_id"));
                account.setUserName(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));

                accountList.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return accountList;
    }

    public static ArrayList<AnswerDTO> toAnswer(ResultSet rs) {
        ArrayList<AnswerDTO> answerList = new ArrayList<AnswerDTO>();

        try {
            while (rs.next()) {
                AnswerDTO answer = new AnswerDTO();
                answer.setAnswerId(rs.getInt("answer_id"));
                answer.setResultId(rs.getInt("result_id"));
                answer.setQuestionId(rs.getInt("question_id"));
                answer.setAnswer(rs.getString("answer"));
                answer.setIsCorrect(rs.getInt("is_correct"));

                answerList.add(answer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return answerList;
    }

    public static ArrayList<ExamDTO> toExam(ResultSet rs) {
        ArrayList<ExamDTO> examList = new ArrayList<ExamDTO>();

        try {
            while (rs.next()) {
                ExamDTO exam = new ExamDTO();
                exam.setExamId(rs.getInt("exam_id"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setSubjectId(rs.getInt("subject_id"));
                try {
                    exam.setSubjectName(rs.getString("subject_name"));
                } catch (Exception e) {
                }
                try {
                    exam.setDuration(rs.getInt("duration"));
                } catch (Exception e) {
                }
                exam.setStatus(rs.getString("status"));
                try {
                    exam.setStartTime(rs.getString("start_time_formatted"));
                } catch (Exception e) {
                }
                try {
                    exam.setEndTime(rs.getString("end_time_formatted"));
                } catch (Exception e) {
                }
                exam.setTotalQuestion(rs.getInt("total_question"));

                examList.add(exam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return examList;
    }

    public static ArrayList<ExamQuestionDTO> toExamQuestion(ResultSet rs) {

        ArrayList<ExamQuestionDTO> examQuestionList = new ArrayList<ExamQuestionDTO>();

        try {
            while (rs.next()) {
                ExamQuestionDTO examQuestion = new ExamQuestionDTO();
                examQuestion.setExamId(rs.getInt("exam_id"));
                examQuestion.setQuestionId(rs.getInt("question_id"));

                examQuestionList.add(examQuestion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return examQuestionList;

    }

    public static ArrayList<ResultDTO> toResult(ResultSet rs) {
        ArrayList<ResultDTO> resultList = new ArrayList<ResultDTO>();

        try {
            while (rs.next()) {
                ResultDTO result = new ResultDTO();
                result.setResultId(rs.getInt("result_id"));
                result.setStudentId(rs.getInt("student_id"));
                result.setExamId(rs.getInt("exam_id"));
                result.setTotalQuestion(rs.getInt("total_question"));
                result.setTotalCorrectAnswers(rs.getInt("total_correct_answers"));
                result.setSubmitTime(rs.getString("submit_time_formatted"));
                result.setScore(rs.getInt("score"));
                try {
                    result.setExamName(rs.getString("exam_name"));
                } catch (Exception e) {
                }
                try {
                    result.setSubjectName(rs.getString("subject_name"));
                } catch (Exception e) {
                }
                resultList.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultList;
    }

    public static Score toScore(ResultSet rs) {
        Score score = new Score();
        ArrayList<Double> scores = new ArrayList<Double>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        try {
            while (rs.next()) {
                scores.add(rs.getDouble("score"));
                count.add(rs.getInt("count"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetToData.class.getName()).log(Level.SEVERE, null, ex);
        }
        score.setScores(scores);
        score.setCount(count);
        return score;
    }
}
