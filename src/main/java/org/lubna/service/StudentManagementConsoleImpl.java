package org.lubna.service;

import org.lubna.data_access.StudentDao;
import org.lubna.exception.DataNotFoundException;
import org.lubna.models.Student;
import org.lubna.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    StudentDao studentDao;
    UserInputService scannerService;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService scannerService) {
        this.studentDao = studentDao;
        this.scannerService = scannerService;
    }

    @Override
    public Student create() {
        System.out.println("Enter your name : ");
        String studentInfo = scannerService.getString();
        return new Student(studentInfo);
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        return studentDao.save(student);

    }

    @Override
    public Student find(int id)  {
        if(id <= 0 ) throw new IllegalArgumentException("Id was not valid");
        try {
            return studentDao.find(id);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student remove(int id) {
        if (id <= 0) throw new IllegalArgumentException("Student Id cannot be zero or below");
        try {
            studentDao.delete(id);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) throw new IllegalArgumentException("Student was null");
        if (student.getId() == 0) throw new IllegalArgumentException("student id should not be empty or zero");
        studentDao.save(student);
        return student;
    }
}
