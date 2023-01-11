package org.lubna;

import org.lubna.config.ComponentScanConfig;
import org.lubna.data_access.StudentDao;
import org.lubna.exception.DataNotFoundException;
import org.lubna.models.Student;
import org.lubna.service.StudentManagementConsoleImpl;
import org.lubna.util.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagementConsoleImpl studentManagementConsole = context.getBean(StudentManagementConsoleImpl.class);

        Student anna = studentDao.save(new Student("Anna Berg"));
        Student joseph_andreas = studentDao.save(new Student("Joseph Andreas"));
        System.out.println(studentDao.findAll());

       /* try {
            Student student = studentDao.find(1);
            System.out.println(student);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            studentDao.delete(1);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(studentDao.findAll());

    }/*
}
         */

    Student student = studentManagementConsole.create();
    studentManagementConsole.save(student);
    System.out.println(studentManagementConsole.findAll());

   // Student student1 = studentManagementConsole.find(1);
    //System.out.println(student1);

   // studentManagementConsole.remove(3);

       // System.out.println(studentManagementConsole.findAll());

        studentManagementConsole.edit(student);


        System.out.println(studentManagementConsole.findAll());







    }
}