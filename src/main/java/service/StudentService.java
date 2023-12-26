package service;

import entity.person.Student;

import java.time.LocalDate;
import java.util.Date;

@SuppressWarnings("unused")
public interface StudentService extends PersonService<Student> {
    boolean existByUserNameAndPassword(String userName, String password);
    Student findByUserName(String userName);
    Boolean isStudentGraduated(Student student, LocalDate date);
    boolean existsByNationalId(String nationalId);
    Student findByNationalId(String nationalId);
    boolean existByUserName(String userName);
}
