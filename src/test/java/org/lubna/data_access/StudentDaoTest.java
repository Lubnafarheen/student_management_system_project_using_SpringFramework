package org.lubna.data_access;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lubna.config.ComponentScanConfig;
import org.lubna.exception.DataNotFoundException;
import org.lubna.models.Student;
import org.lubna.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest {

    StudentDao studentDaoObject;
    Student neha;

    @Autowired
    public StudentDaoTest(StudentDao studentDaoObject) {
        this.studentDaoObject = studentDaoObject;
    }

    @BeforeEach
    public void setup() {
        Student studentData = new Student("Neha");
        neha = studentDaoObject.save(studentData);
    }

    @Test
    void findAll_Test() {
        int expected = 1;
        int actual = studentDaoObject.findAll().size();
        assertEquals(expected, actual);
    }

    @Test
    void find_Test_DoesNotThrowException() {
        assertDoesNotThrow(() -> {
            studentDaoObject.find(neha.getId());
        });
    }

    @Test
    void find_Test_ThrowsException() {
        assertThrows(DataNotFoundException.class, () -> {
            studentDaoObject.find(3);
        });
    }

    @Test
    void delete_Test_DoesNotThrowException() {
        assertDoesNotThrow(() -> {
            studentDaoObject.delete(1);
        });
    }

    @Test
    void delete_Test_ThrowsException() {
        assertThrows(DataNotFoundException.class, () -> {
            studentDaoObject.delete(0);
        });
    }
}