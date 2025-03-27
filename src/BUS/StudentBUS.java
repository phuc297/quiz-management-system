package BUS;

import DAO.StudentDAO;
import DTO.StudentDTO;
import GUI.ExcelFile;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class StudentBUS extends ExcelFile implements BUS<StudentDTO> {

    private static StudentDAO dao;

    public StudentBUS() {
        dao = new StudentDAO();
    }

    @Override
    public ArrayList<StudentDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public StudentDTO get(int studentId) {
        return dao.get(studentId);
    }

    public StudentDTO getByAccountId(int accountId) {
        return dao.getByAccountId(accountId);
    }

    public ArrayList<StudentDTO> getAllInClass(int classId) {
        return dao.getAllInClass(classId);
    }

    public ArrayList<StudentDTO> getAllBirthdayAsc() {
        return dao.getAllBirthdayAsc();
    }

    public ArrayList<StudentDTO> getAllBirthdayDesc() {
        return dao.getAllBirthdayDesc();
    }

    public ArrayList<StudentDTO> getAllMale() {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> maleStudents = new ArrayList<StudentDTO>();
        for (StudentDTO s : allStudents) {
            if (s.getGender().equals("Nam")) {
                maleStudents.add(s);
            }
        }
        return maleStudents;
    }

    public ArrayList<StudentDTO> getAllFemale() {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> femaleStudents = new ArrayList<StudentDTO>();
        for (StudentDTO s : allStudents) {
            if (s.getGender().equals("Nữ")) {
                femaleStudents.add(s);
            }
        }
        return femaleStudents;
    }

    @Override
    public ArrayList<StudentDTO> find(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        for (StudentDTO i : allStudents) {
            if (i.toString().toLowerCase().contains(s.toLowerCase())) {
                foundedStudents.add(i);
            }
        }
        return foundedStudents;
    }

    @Override
    public ArrayList<StudentDTO> findById(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        if (s.equals("")) {
            return allStudents;
        }
        for (StudentDTO i : allStudents) {
            if (Integer.toString(i.getStudentId()).contains(s)) {
                foundedStudents.add(i);
                return foundedStudents;
            }
        }
        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByName(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        if (!s.matches(".*\\d+.*")) {
            for (StudentDTO i : allStudents) {
                if (i.toString().toLowerCase().contains(s.toLowerCase())) {
                    foundedStudents.add(i);
                }
            }
        }
        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByNameAndId(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        for (StudentDTO i : allStudents) {
            String s1 = i.getStudentId() + " " + i.getName();
            if (s1.toLowerCase().contains(s.toLowerCase())) {
                foundedStudents.add(i);
            }
        }

        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByPhone(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        for (StudentDTO i : allStudents) {
            if (i.getPhoneNumber().contains(s)) {
                foundedStudents.add(i);
            }
        }
        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByEmail(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        for (StudentDTO i : allStudents) {
            if (i.getEmail().toLowerCase().contains(s.toLowerCase())) {
                foundedStudents.add(i);
            }
        }
        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByBirthday(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        for (StudentDTO i : allStudents) {
            if (i.getBirthday().contains(s)) {
                foundedStudents.add(i);
            }
        }
        return foundedStudents;
    }

    public ArrayList<StudentDTO> findByAccountId(String s) {
        ArrayList<StudentDTO> allStudents = getAll();
        ArrayList<StudentDTO> foundedStudents = new ArrayList<StudentDTO>();
        if (s.equals("")) {
            return allStudents;
        }
        for (StudentDTO i : allStudents) {
            if (Integer.toString(i.getAccountId()).contains(s)) {
                foundedStudents.add(i);
                return foundedStudents;
            }
        }
        return foundedStudents;
    }

    @Override
    public boolean insert(StudentDTO o) {
        return dao.insert(o);
    }

    @Override
    public boolean remove(int studentId) {
        return dao.remove(studentId);
    }

    @Override
    public boolean update(StudentDTO o) {
        return dao.update(o);
    }

    @Override
    public void writeRow(Object rowData, Row row) {
        if (cellStyleFormatNumber == null) {
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        StudentDTO rowStudent = (StudentDTO) rowData;

        int indexRow = 0;

        Cell cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getStudentId());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getFirstName());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getLastName());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getBirthday());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getGender());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getPhoneNumber());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getEmail());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getAccountId());

    }

    @Override
    public Object setDataRow(Iterator<Cell> cellIterator) {
        StudentDTO dataRow = new StudentDTO();
        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            Object cellValue = getCellValue(cell);
            if (cellValue == null || cellValue.toString().isEmpty()) {
                continue;
            }
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case 0:
                    dataRow.setFirstName((String) getCellValue(cell));
                    break;
                case 1:
                    dataRow.setLastName((String) getCellValue(cell));
                    break;
                case 2:
                    dataRow.setBirthday((String) getCellValue(cell));
                    break;
                case 3:
                    dataRow.setGender((String) getCellValue(cell));
                    break;
                case 4:
                    dataRow.setPhoneNumber((String) getCellValue(cell));
                    break;
                case 5:
                    dataRow.setEmail((String) getCellValue(cell));
                    break;
                case 6:
                    dataRow.setUserName((String) getCellValue(cell));
                    break;
                case 7:
                    dataRow.setPassword((String) getCellValue(cell));
                    break;
                default:
                    break;
            }
        }
        return dataRow;
    }

}
