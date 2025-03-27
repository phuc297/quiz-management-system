package GUI.TableModel;

import java.util.Vector;

public class ColumnNames {

    public static Vector getStudent() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã học sinh");
        columnNames.add("Họ");
        columnNames.add("Tên");
        columnNames.add("Ngày sinh");
        columnNames.add("Giới tính");
        columnNames.add("Số điện thoại");
        columnNames.add("Email");
        columnNames.add("Mã tài khoản");
        return columnNames;
    }

    public static Vector getTeacher() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Họ");
        columnNames.add("Tên");
        columnNames.add("Ngày sinh");
        columnNames.add("Giới tính");
        columnNames.add("Số điện thoại");
        columnNames.add("Email");
        columnNames.add("Mã tài khoản");
        return columnNames;
    }

    public static Vector getQuestion() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã câu hỏi");
        columnNames.add("Câu hỏi");
        columnNames.add("Đáp án A");
        columnNames.add("Đáp án B");
        columnNames.add("Đáp án C");
        columnNames.add("Đáp án D");
        columnNames.add("Đáp án đúng");
        columnNames.add("Môn học");
        return columnNames;
    }

    public static Vector getExam() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Mã kì thi");
        columnNames.add("Tên kì thi");
        columnNames.add("Môn học");
        columnNames.add("Trạng thái");
        columnNames.add("Thời gian làm bài");
        columnNames.add("Số câu hỏi");
        columnNames.add("Ngày tạo");
        return columnNames;
    }

}
