package repository;

import entity.person.Student;
@SuppressWarnings("unused")
public interface StudentRepository extends PersonRepository<Student> {
//    boolean isMarried(Integer id);
//    boolean gotMortgageLoan(Integer id);
    boolean existsByNationalId(String nationalId);
    boolean existByUserNameAndPassword(String userName, String password);
    Student findByUserName(String userName);
    Student findByNationalId(String nationalId);
    boolean existByUserName(String userName);

}
