package GUI.TableModel;

import DTO.AccountDTO;
import DTO.ClassDTO;
import DTO.ExamDTO;
import DTO.QuestionDTO;
import DTO.ResultDTO;
import DTO.StudentDTO;
import DTO.SubjectDTO;
import DTO.TeacherDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableModel {

    public static DefaultTableModel getAccount(ArrayList<AccountDTO> accountDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã tài khoản");
        columnNames.add("Tên tài khoản");
        columnNames.add("Mật khẩu");
        columnNames.add("Loại tài khoản");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (AccountDTO i : accountDTOs) {
            Object rowData[] = {
                i.getAccounId(),
                i.getUserName(),
                i.getPassword(),
                i.getRole()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getSubject(ArrayList<SubjectDTO> subjectDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã môn học");
        columnNames.add("Tên môn học");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (SubjectDTO i : subjectDTOs) {
            Object rowData[] = {
                i.getSubjectId(),
                i.getSubjectName(),};
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getTeacher(ArrayList<TeacherDTO> teacherDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã giáo viên");
        columnNames.add("Họ");
        columnNames.add("Tên");
        columnNames.add("Ngày sinh");
        columnNames.add("Giới tính");
        columnNames.add("Số điện thoại");
        columnNames.add("Email");
        columnNames.add("Mã tài khoản");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (TeacherDTO i : teacherDTOs) {
            Object rowData[] = {
                i.getTeacherId(),
                i.getFirstName(),
                i.getLastName(),
                i.getBirthday(),
                i.getGender(),
                i.getPhoneNumber(),
                i.getEmail(),
                i.getAccountId()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getStudent(ArrayList<StudentDTO> studentDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã học sinh");
        columnNames.add("Họ");
        columnNames.add("Tên");
        columnNames.add("Ngày sinh");
        columnNames.add("Giới tính");
        columnNames.add("Số điện thoại");
        columnNames.add("Email");
        columnNames.add("Mã tài khoản");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (StudentDTO i : studentDTOs) {
            Object rowData[] = {
                i.getStudentId(),
                i.getFirstName(),
                i.getLastName(),
                i.getBirthday(),
                i.getGender(),
                i.getPhoneNumber(),
                i.getEmail(),
                i.getAccountId()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getClass(ArrayList<ClassDTO> classDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã lớp học");
        columnNames.add("Tên lớp");
        columnNames.add("Giáo viên");
        columnNames.add("Môn học");
        columnNames.add("Số lượng học sinh");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ClassDTO i : classDTOs) {
            Object rowData[] = {
                i.getClassId(),
                i.getClassName(),
                i.getTeacherName(),
                i.getSubjectName(),
                i.getTotalStudents()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getClassStudent(ArrayList<ClassDTO> classDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã lớp học");
        columnNames.add("Tên lớp");
        columnNames.add("Giáo viên");
        columnNames.add("Môn học");

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ClassDTO i : classDTOs) {
            Object rowData[] = {
                i.getClassId(),
                i.getClassName(),
                i.getTeacherName(),
                i.getSubjectName(),};
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getClassTeacher(ArrayList<ClassDTO> classDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã lớp");
        columnNames.add("Tên lớp");
        columnNames.add("Số lượng học sinh");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ClassDTO i : classDTOs) {
            Object rowData[] = {
                i.getClassId(),
                i.getClassName(),
                i.getTotalStudents()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getQuestion(ArrayList<QuestionDTO> questionDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã câu hỏi");
        columnNames.add("Câu hỏi");
        columnNames.add("Đáp án A");
        columnNames.add("Đáp án B");
        columnNames.add("Đáp án C");
        columnNames.add("Đáp án D");
        columnNames.add("Đáp án đúng");
        columnNames.add("Môn học");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (QuestionDTO i : questionDTOs) {
            Object rowData[] = {
                i.getQuestionId(),
                i.getQuestionText(),
                i.getOptionA(),
                i.getOptionB(),
                i.getOptionC(),
                i.getOptionD(),
                i.getCorrectAnswer(),
                i.getSubjectName()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getExamQuestion(ArrayList<QuestionDTO> questionDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Câu hỏi");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (QuestionDTO i : questionDTOs) {
            Object rowData[] = {
                i.getQuestionId(),
                i.getQuestionText()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getExam(ArrayList<ExamDTO> examDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã kì thi");
        columnNames.add("Tên kì thi");
        columnNames.add("Môn học");
        columnNames.add("Trạng thái");
        columnNames.add("Thời gian làm bài");
        columnNames.add("Số câu hỏi");
        columnNames.add("Ngày tạo");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ExamDTO i : examDTOs) {
            Object rowData[] = {
                i.getExamId(),
                i.getExamName(),
                i.getSubjectName(),
                i.getStatus(),
                i.getDuration(),
                i.getTotalQuestion(),
                i.getStartTime()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getResult(ArrayList<ResultDTO> resultDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã kết quả");
        columnNames.add("Mã học sinh");
        columnNames.add("Mã kì thi");
        columnNames.add("Số câu đúng");
        columnNames.add("Thời gian nộp bài");
        columnNames.add("Điểm số");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ResultDTO i : resultDTOs) {
            Object rowData[] = {
                i.getResultId(),
                i.getStudentId(),
                i.getExamId(),
                i.getCorrect(),
                i.getSubmitTime(),
                i.getScore()
            };
            model.addRow(rowData);
        }
        return model;
    }

    public static DefaultTableModel getResultStudent(ArrayList<ResultDTO> resultDTOs) {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã kì thi");
        columnNames.add("Kì thi");
        columnNames.add("Môn thi");
        columnNames.add("Số câu đúng");
        columnNames.add("Thời gian nộp bài");
        columnNames.add("Điểm số");
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ResultDTO i : resultDTOs) {
            Object rowData[] = {
                i.getExamId(),
                i.getExamName(),
                i.getSubjectName(),
                i.getCorrect(),
                i.getSubmitTime(),
                i.getScore()
            };
            model.addRow(rowData);
        }
        return model;
    }

}
