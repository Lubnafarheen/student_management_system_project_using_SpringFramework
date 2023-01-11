package org.lubna.data_access;

import org.lubna.exception.DataNotFoundException;
import org.lubna.models.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student student);

    Student find(int id) throws DataNotFoundException;

    List<Student> findAll();

    void delete (int id) throws DataNotFoundException;

}
