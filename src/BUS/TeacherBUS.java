package BUS;

import DAO.TeacherDAO;
import DTO.TeacherDTO;
import GUI.ExcelFile;
import static GUI.ExcelFile.cellStyleFormatNumber;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class TeacherBUS extends ExcelFile implements BUS<TeacherDTO> {

    private TeacherDAO dao;

    public TeacherBUS() {
        dao = new TeacherDAO();
    }

    @Override
    public ArrayList<TeacherDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public TeacherDTO get(int teacherId) {
        return dao.get(teacherId);
    }

    public TeacherDTO getByAccount(int AccountId) {
        return dao.getByAccount(AccountId);
    }

    public ArrayList<TeacherDTO> getAllBySubject(int subjectId) {
        return dao.getAllBySubject(subjectId);
    }

    public ArrayList<TeacherDTO> getAllBirthdayAsc() {
        return dao.getAllBirthdayAsc();
    }

    public ArrayList<TeacherDTO> getAllBirthdayDesc() {
        return dao.getAllBirthdayDesc();
    }

    public ArrayList<TeacherDTO> getAllMale() {
        ArrayList<TeacherDTO> teachers = getAll();
        ArrayList<TeacherDTO> maleTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO s : teachers) {
            if (s.getGender().equals("Nam")) {
                maleTeachers.add(s);
            }
        }
        return maleTeachers;
    }

    public ArrayList<TeacherDTO> getAllFemale() {
        ArrayList<TeacherDTO> teachers = getAll();
        ArrayList<TeacherDTO> femaleTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO s : teachers) {
            if (s.getGender().equals("Nữ")) {
                femaleTeachers.add(s);
            }
        }
        return femaleTeachers;
    }

    public ArrayList<TeacherDTO> find(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO i : allTeachers) {
            if (i.toString1().toLowerCase().contains(s.toLowerCase())) {
                foundedTeachers.add(i);
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findById(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        if (s.equals("")) {
            return allTeachers;
        }
        for (TeacherDTO i : allTeachers) {
            if (Integer.toString(i.getTeacherId()).contains(s)) {
                foundedTeachers.add(i);
                return foundedTeachers;
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findByName(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        if (!s.matches(".*\\d+.*")) {
            for (TeacherDTO i : allTeachers) {
                if (i.toString1().toLowerCase().contains(s.toLowerCase())) {
                    foundedTeachers.add(i);
                }
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findByPhone(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO i : allTeachers) {
            if (i.getPhoneNumber().contains(s)) {
                foundedTeachers.add(i);
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findByEmail(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO i : allTeachers) {
            if (i.getEmail().toLowerCase().contains(s.toLowerCase())) {
                foundedTeachers.add(i);
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findByBirthday(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        for (TeacherDTO i : allTeachers) {
            if (i.getBirthday().contains(s)) {
                foundedTeachers.add(i);
            }
        }
        return foundedTeachers;
    }

    public ArrayList<TeacherDTO> findByAccountId(String s) {
        ArrayList<TeacherDTO> allTeachers = getAll();
        ArrayList<TeacherDTO> foundedTeachers = new ArrayList<TeacherDTO>();
        if (s.equals("")) {
            return allTeachers;
        }
        for (TeacherDTO i : allTeachers) {
            if (Integer.toString(i.getAccountId()).contains(s)) {
                foundedTeachers.add(i);
                return foundedTeachers;
            }
        }
        return foundedTeachers;
    }

    public int count() {
        return getAll().size();
    }

    public boolean insert(TeacherDTO o) {
        return dao.insert(o);
    }

    @Override
    public boolean remove(int teacherId) {
        return dao.remove(teacherId);
    }

    public boolean update(TeacherDTO o) {
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

        TeacherDTO rowStudent = (TeacherDTO) rowData;

        int indexRow = 0;

        Cell cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getTeacherId());

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
        TeacherDTO dataRow = new TeacherDTO();
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
