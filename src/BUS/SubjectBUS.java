package BUS;

import DAO.SubjectDAO;
import DTO.SubjectDTO;
import GUI.ExcelFile;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SubjectBUS extends ExcelFile implements BUS<SubjectDTO> {

    private SubjectDAO dao;

    public SubjectBUS() {
        dao = new SubjectDAO();
    }

    @Override
    public ArrayList<SubjectDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public SubjectDTO get(int subjectId) {
        return dao.get(subjectId);
    }

    public ArrayList<SubjectDTO> getAllOfTeacher(int teacherId) {
        return dao.getAllOfTeacher(teacherId);
    }

    public String getSubjectOfClass(int classId) {
        return dao.getSubjectOfClass(classId);
    }

    public String getName(int subjectId) {
        return dao.getName(subjectId);
    }

    @Override
    public ArrayList<SubjectDTO> find(String s) {
        ArrayList<SubjectDTO> allSubjects = getAll();
        ArrayList<SubjectDTO> foundedSubjects = new ArrayList<SubjectDTO>();
        for (SubjectDTO i : allSubjects) {
            if (i.getSubjectName().toLowerCase().contains(s.toLowerCase())) {
                foundedSubjects.add(i);
            }
        }
        return foundedSubjects;
    }

    @Override
    public ArrayList<SubjectDTO> findById(String s) {
        ArrayList<SubjectDTO> allSubjects = getAll();
        ArrayList<SubjectDTO> foundedSubjects = new ArrayList<SubjectDTO>();
        if (s.equals("")) {
            return allSubjects;
        }
        for (SubjectDTO i : allSubjects) {
            if (Integer.toString(i.getSubjectId()).contains(s)) {
                foundedSubjects.add(i);
                return foundedSubjects;
            }
        }
        return foundedSubjects;
    }

    @Override
    public boolean insert(SubjectDTO o) {
        if (dao.insert(o)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int subjectId) {
        if (dao.remove(subjectId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(SubjectDTO o) {
        if (dao.update(o)) {
            return true;
        }
        return false;
    }

    @Override
    public void writeRow(Object rowData, Row row) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object setDataRow(Iterator<Cell> cellIterator) {
        SubjectDTO dataRow = new SubjectDTO();
        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            Object cellValue = getCellValue(cell);
            if (cellValue == null || cellValue.toString().isEmpty()) {
                continue;
            }
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case 0:
                    dataRow.setSubjectName((String) cellValue);
                    break;
                default:
                    break;
            }
        }
        return dataRow;
    }

}
