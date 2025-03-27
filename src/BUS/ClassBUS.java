package BUS;

import DAO.ClassDAO;
import DTO.ClassDTO;
import java.util.ArrayList;

public class ClassBUS implements BUS<ClassDTO> {

    private ClassDAO dao;

    public ClassBUS() {
        dao = new ClassDAO();
    }

    @Override
    public ArrayList<ClassDTO> getAll() {
        return dao.getAll();
    }

    @Override
    public ClassDTO get(int classId) {
        return dao.get(classId);
    }

    public int getLatest() {
        return dao.getLatest();
    }

    public ArrayList<ClassDTO> getAllOfTeacherWithSize(int teacherId) {
        return dao.getAllOfTeacherTotalStudents(teacherId);
    }

    public ArrayList<ClassDTO> getAllOfTeacher(int teacherId) {
        return dao.getAllOfTeacher(teacherId);
    }

    public ArrayList<ClassDTO> getAllOfStudent(int studentId) {
        return dao.getAllOfStudent(studentId);
    }

    public ArrayList<ClassDTO> getAllOfSubject(int subjectId) {
        return dao.getAllOfSubject(subjectId);
    }

    public int getNumberStudent(int classId) {
        return dao.getNumberStudent(classId);
    }

    @Override
    public ArrayList<ClassDTO> find(String s) {
        ArrayList<ClassDTO> allClasses = getAll();
        ArrayList<ClassDTO> foundedClasses = new ArrayList<ClassDTO>();
        for (ClassDTO i : allClasses) {
            if (i.getClassName().toLowerCase().contains(s.toLowerCase())) {
                foundedClasses.add(i);
            }
        }
        return foundedClasses;
    }

    @Override
    public ArrayList<ClassDTO> findById(String s) {
        ArrayList<ClassDTO> allClasses = getAll();
        ArrayList<ClassDTO> foundedClasses = new ArrayList<ClassDTO>();
        if (s.equals("")) {
            return allClasses;
        }
        for (ClassDTO i : allClasses) {
            if (Integer.toString(i.getClassId()).contains(s)) {
                foundedClasses.add(i);
                return foundedClasses;
            }
        }
        return foundedClasses;
    }

    public ArrayList<ClassDTO> findByTeacher(String s) {
        ArrayList<ClassDTO> allClasses = getAll();
        ArrayList<ClassDTO> foundedClasses = new ArrayList<ClassDTO>();
        if (!s.matches(".*\\d+.*")) {
            for (ClassDTO i : allClasses) {
                if (i.getTeacherName().toLowerCase().contains(s.toLowerCase())) {
                    foundedClasses.add(i);
                }
            }
        }
        return foundedClasses;
    }

    public ArrayList<ClassDTO> findBySubject(String s) {
        ArrayList<ClassDTO> allClasses = getAll();
        ArrayList<ClassDTO> foundedClasses = new ArrayList<ClassDTO>();
        for (ClassDTO i : allClasses) {
            if (i.getSubjectName().toLowerCase().contains(s.toLowerCase())) {
                foundedClasses.add(i);
            }
        }
        return foundedClasses;
    }

    public ArrayList<ClassDTO> findByNumberOfStudents(String s) {
        ArrayList<ClassDTO> allClasses = getAll();
        ArrayList<ClassDTO> foundedClasses = new ArrayList<ClassDTO>();
        if (s.equals("")) {
            return allClasses;
        }
        for (ClassDTO i : allClasses) {
            if (Integer.toString(i.getTotalStudents()).contains(s)) {
                foundedClasses.add(i);
                return foundedClasses;
            }
        }
        return foundedClasses;
    }

    @Override
    public boolean insert(ClassDTO o) {
        return dao.insert(o);
    }

    public boolean insertStudent(int studentId, int classId) {
        return dao.insertStudent(studentId, classId);
    }

    @Override
    public boolean remove(int classId) {
        return dao.remove(classId);
    }

    @Override
    public boolean update(ClassDTO o) {
        return dao.update(o);
    }

}
