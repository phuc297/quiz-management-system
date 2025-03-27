package BUS;

import DAO.ExamDAO;
import DTO.ExamDTO;
import GUI.ExcelFile;
import static GUI.ExcelFile.cellStyleFormatNumber;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ExamBUS extends ExcelFile implements BUS<ExamDTO> {
    
    private ExamDAO dao;
    
    public ExamBUS() {
        dao = new ExamDAO();
    }
    
    @Override
    public ArrayList<ExamDTO> getAll() {
        return dao.getAll();
    }
    
    @Override
    public ExamDTO get(int examId) {
        return dao.get(examId);
    }
    
    public ArrayList<ExamDTO> getAllOfStudent(int studentId) {
        return dao.getAllOfStudent(studentId);
    }
    
    public ArrayList<ExamDTO> getAllOfTeacher(int teacherId) {
        return dao.getAllOfTeacher(teacherId);
    }
    
    public ArrayList<ExamDTO> getAllOrderBySubject() {
        return dao.getAllOrderBySubject();
    }
    
    public ArrayList<ExamDTO> getAllPending() {
        return dao.getAllPending();
    }
    
    public ArrayList<ExamDTO> getAllInProgress() {
        return dao.getAllInProgress();
    }
    
    public ArrayList<ExamDTO> getAllFinished() {
        return dao.getAllFinished();
    }
    
    public ArrayList<ExamDTO> getAllOrderByStatus() {
        return dao.getAllOrderByStatus();
    }
    
    @Override
    public ArrayList<ExamDTO> find(String s) {
        ArrayList<ExamDTO> allExams = getAll();
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        for (ExamDTO i : allExams) {
            if (i.getExamName().toLowerCase().contains(s.toLowerCase())) {
                foundedExams.add(i);
            }
        }
        return foundedExams;
    }
    
    public ArrayList<ExamDTO> findName(ArrayList<ExamDTO> exams, String s) {
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        for (ExamDTO i : exams) {
            if (i.getExamName().toLowerCase().contains(s.toLowerCase())) {
                foundedExams.add(i);
            }
        }
        return foundedExams;
    }
    
    @Override
    public ArrayList<ExamDTO> findById(String s) {
        ArrayList<ExamDTO> allExams = getAll();
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        if (s.equals("")) {
            return allExams;
        }
        for (ExamDTO i : allExams) {
            if (Integer.toString(i.getExamId()).contains(s)) {
                foundedExams.add(i);
                return foundedExams;
            }
        }
        return foundedExams;
    }
    
    public ArrayList<ExamDTO> findBySubject(ArrayList<ExamDTO> exams, String s) {
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        for (ExamDTO i : exams) {
            if (i.getSubjectName().toLowerCase().contains(s.toLowerCase())) {
                foundedExams.add(i);
            }
        }
        return foundedExams;
    }
    
    public ArrayList<ExamDTO> findByTime(ArrayList<ExamDTO> exams, String s) {
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        for (ExamDTO i : exams) {
            if (i.getDuration() == Integer.parseInt(s)) {
                foundedExams.add(i);
            }
        }
        return foundedExams;
    }
    
    public ArrayList<ExamDTO> findByNumberQuestions(ArrayList<ExamDTO> exams, String s) {
        ArrayList<ExamDTO> foundedExams = new ArrayList<ExamDTO>();
        if (s.equals("")) {
            return exams;
        }
        for (ExamDTO i : exams) {
            if (Integer.toString(i.getTotalQuestion()).equals(s)) {
                foundedExams.add(i);
            }
        }
        return foundedExams;
    }
    
    public int getLatestId() {
        return dao.getLatestId();
    }
    
    @Override
    public boolean insert(ExamDTO o) {
        return dao.insert(o);
    }
    
    @Override
    public boolean remove(int examId) {
        return dao.remove(examId);
    }
    
    public boolean startExam(int examId) {
        return dao.startExam(examId);
    }
    
    public boolean finishExam(int examId) {
        return dao.finishExam(examId);
    }
    
    @Override
    public boolean update(ExamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void writeRow(Object rowData, Row row) {
        if (cellStyleFormatNumber == null) {
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        
        ExamDTO rowStudent = (ExamDTO) rowData;
        
        int indexRow = 0;
        
        Cell cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getExamId());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getExamName());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getSubjectName());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getStatus());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getDurationString());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getStartTime());
        
        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getTotalQuestion());
        
    }
    
    @Override
    public Object setDataRow(Iterator<Cell> cellIterator) {
        ExamDTO dataRow = new ExamDTO();
        while (cellIterator.hasNext()) {
            
            Cell cell = cellIterator.next();
            Object cellValue = getCellValue(cell);
            if (cellValue == null || cellValue.toString().isEmpty()) {
                continue;
            }
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case 0:
                    dataRow.setExamId(new BigDecimal((double) cellValue).intValue());
                    break;
                case 1:
                    dataRow.setExamName((String) getCellValue(cell));
                    break;
                case 2:
                    dataRow.setSubjectName((String) getCellValue(cell));
                    break;
                case 3:
                    dataRow.setStatus((String) getCellValue(cell));
                    break;
                case 4:
                    dataRow.setDuration(new BigDecimal((double) cellValue).intValue());
                    break;
                case 5:
                    dataRow.setStartTime((String) getCellValue(cell));
                    break;
                case 6:
                    dataRow.setTotalQuestion(new BigDecimal((double) cellValue).intValue());
                    break;
                default:
                    break;
            }
        }
        return dataRow;
    }
    
}
