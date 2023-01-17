package org.lubna.data_access;

import org.lubna.exception.DataNotFoundException;
import org.lubna.models.Student;
import org.lubna.sequencer.StudentDaoListSequencer;
import org.lubna.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {
    List<Student> students = new ArrayList<>();

    @Autowired
    UserInputService scannerService;

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        if (student.getId() == 0) {
            student.setId(StudentDaoListSequencer.nextId());
            students.add(student);
        } else {
            System.out.println("Enter the updated name :  ");
            String setUserName = scannerService.getString();
            student.setName(setUserName);
        }
        return student;
    }

    @Override
    public Student find(int id) throws DataNotFoundException {
        return students.stream().
                filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("student not found"));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        Student studentById = find(id);
        students.remove(studentById);
    }
}
