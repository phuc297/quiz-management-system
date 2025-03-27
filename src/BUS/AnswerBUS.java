package BUS;

import DAO.AnswerDAO;
import DTO.AnswerDTO;
import DTO.QuestionDTO;
import java.util.ArrayList;

public class AnswerBUS {

    private AnswerDAO dao;

    public AnswerBUS() {
        dao = new AnswerDAO();
    }

    public ArrayList<AnswerDTO> getAllAnswers() {
        return dao.getAllAnswers();
    }

    public void insertAnswer(ArrayList<AnswerDTO> answers) {
        dao.insertAnswer(answers);
    }

    public boolean submitExam(int examId, int studentId) {
        return dao.submitExam(examId, studentId);
    }

    public void insertAnswer2(ArrayList<AnswerDTO> answers, int examId) {
        ArrayList<QuestionDTO> examQuestions = (new QuestionBUS()).getQuestionsOfExam(examId);
        for (AnswerDTO a : answers) {
            for (QuestionDTO q : examQuestions) {
                if (a.getQuestionId() == q.getQuestionId()) {
                    if (a.getAnswer()== q.getCorrectAnswer()) {
                        a.setIsCorrect(1);
                        break;
                    }
                }
            }
        }
        dao.insert(answers);
    }
}
