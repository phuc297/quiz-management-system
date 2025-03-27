package BUS;

import DAO.QuestionDAO;
import DTO.QuestionDTO;
import GUI.ExcelFile;
import static GUI.ExcelFile.cellStyleFormatNumber;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class QuestionBUS extends ExcelFile implements BUS<QuestionDTO> {

    private QuestionDAO dao;

    public QuestionBUS() {
        dao = new QuestionDAO();
    }

    @Override
    public ArrayList<QuestionDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public QuestionDTO get(int questionId) {
        return dao.get(questionId);
    }

    public ArrayList<QuestionDTO> getQuestionsOfTeacher(int teacherId) {
        return dao.getAllOfTeacher(teacherId);
    }

    public ArrayList<QuestionDTO> getQuestionsOfSubject(int subjectId) {
        return dao.getAllOfSubject(subjectId);
    }

    public ArrayList<QuestionDTO> getQuestionsOfExam(int examId) {
        return dao.getAllOfExam(examId);
    }

    public ArrayList<QuestionDTO> getAllOrderbySubject() {
        return dao.getAllOrderbySubject();
    }

    public ArrayList<QuestionDTO> getOrderbySubject(int teacherId) {
        return dao.getOrderbySubject(teacherId);
    }

    @Override
    public ArrayList<QuestionDTO> find(String s) {
        ArrayList<QuestionDTO> allQuestions = getAll();
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : allQuestions) {
            if (i.toString().toLowerCase().contains(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> find(ArrayList<QuestionDTO> allQuestions, String s) {
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : allQuestions) {
            if (i.toString().toLowerCase().contains(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    @Override
    public ArrayList<QuestionDTO> findById(String s) {
        ArrayList<QuestionDTO> allQuestions = getAll();
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        if (s.equals("")) {
            return allQuestions;
        }
        for (QuestionDTO i : allQuestions) {
            if (Integer.toString(i.getQuestionId()).contains(s)) {
                foundedQuestions.add(i);
                return foundedQuestions;
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> findById(ArrayList<QuestionDTO> allQuestions, String s) {
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        if (s.equals("")) {
            return allQuestions;
        }
        for (QuestionDTO i : allQuestions) {
            if (Integer.toString(i.getQuestionId()).contains(s)) {
                foundedQuestions.add(i);
                return foundedQuestions;
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> findOfByText(ArrayList<QuestionDTO> questions, String s) {
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : questions) {
            if (i.toString().toLowerCase().contains(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> findOfByAnswer(ArrayList<QuestionDTO> questions, String s) {
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : questions) {
            if (i.getCorrectAnswer().toLowerCase().equals(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> findByAnswer(String s) {
        ArrayList<QuestionDTO> allQuestions = getAll();
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : allQuestions) {
            if (i.getCorrectAnswer().toLowerCase().equals(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    public ArrayList<QuestionDTO> findBySubject(String s) {
        ArrayList<QuestionDTO> allQuestions = getAll();
        ArrayList<QuestionDTO> foundedQuestions = new ArrayList<QuestionDTO>();
        for (QuestionDTO i : allQuestions) {
            if (i.getSubjectName().toLowerCase().contains(s.toLowerCase())) {
                foundedQuestions.add(i);
            }
        }
        return foundedQuestions;
    }

    @Override
    public boolean insert(QuestionDTO o) {
        return dao.insert(o);
    }

    @Override
    public boolean remove(int questionId) {
        return dao.remove(questionId);
    }

    @Override
    public boolean update(QuestionDTO o) {
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

        QuestionDTO rowStudent = (QuestionDTO) rowData;

        int indexRow = 0;

        Cell cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getQuestionId());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getQuestionText());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getOptionA());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getOptionB());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getOptionC());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getOptionD());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getCorrectAnswer());

        cell = row.createCell(indexRow++);
        cell.setCellValue(rowStudent.getSubjectName());
    }

    @Override
    public void autosizeColumn(Sheet sheet, int lastColumn) {
        super.autosizeColumn(sheet, lastColumn);
        for (int columnIndex = 1; columnIndex != 6; columnIndex++) {
            sheet.setColumnWidth(columnIndex, 10000);
        }
    }

    @Override
    public Object setDataRow(Iterator<Cell> cellIterator) {
        QuestionDTO dataRow = new QuestionDTO();
        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();
            Object cellValue = getCellValue(cell);
            if (cellValue == null || cellValue.toString().isEmpty()) {
                continue;
            }
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex) {
                case 0:
                    dataRow.setQuestionText((String) cellValue);
                    break;
                case 1:
                    dataRow.setOptionA((String) getCellValue(cell));
                    break;
                case 2:
                    dataRow.setOptionB((String) getCellValue(cell));
                    break;
                case 3:
                    dataRow.setOptionC((String) getCellValue(cell));
                    break;
                case 4:
                    dataRow.setOptionD((String) getCellValue(cell));
                    break;
                case 5:
                    dataRow.setCorrectAnswer((String) getCellValue(cell));
                    break;
                case 6:
                    dataRow.setSubjectId(new BigDecimal((double) cellValue).intValue());
                    break;
                default:
                    break;
            }
        }
        return dataRow;
    }
}
