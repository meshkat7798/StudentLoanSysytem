package service.impl;

import entity.person.Student;
import repository.StudentRepository;
import service.StudentService;
import java.time.LocalDate;

@SuppressWarnings("unused")
public class StudentServiceImpl extends PersonServiceImpl<Student, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public boolean existByUserNameAndPassword(String userName, String password) {
        return repository.existByUserNameAndPassword(userName, password);
    }

    @Override
    public Student findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public boolean existByUserName(String userName) {
        return repository.existByUserName(userName);
    }


    @Override
    public Boolean isStudentGraduated(Student student, LocalDate date) {
        int year = date.getYear();

        switch (student.getStudentGrade()) {
            case ASSOCIATE, MASTER_DISCONTINUOUS -> {
                return student.getEntryYear() + 2 <= year;
            }
            case BACHELOR, BACHELOR_DISCONTINUOUS -> {
                return student.getEntryYear() + 4 <= year;
            }
            case MASTER -> {
                return student.getEntryYear() + 6 <= year;
            }
            case PHD_PROFESSIONAL, PHD_CONTINUOUS, SPECIALIZED_DOCTORATE -> {
                return student.getEntryYear() + 5 <= year;
            }

            default -> throw new IllegalStateException("Unexpected value: " + student.getStudentGrade());
        }
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        return repository.existsByNationalId(nationalId);
    }

    @Override
    public Student findByNationalId(String nationalId) {
        return repository.findByNationalId(nationalId);
    }


}

