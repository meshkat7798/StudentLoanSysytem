package service;

import base.service.BaseEntityService;
import entity.Loan;
import entity.person.Student;

import java.util.List;

@SuppressWarnings("unused")
public interface LoanService extends BaseEntityService<Loan,Integer> {
    boolean studentHasActiveEducationalLoan(Student student);

    boolean studentHasActiveTuitionLoan(Student student);

    boolean studentHasNotActiveMortgageLoan(Student student , StudentService studentService  );

  //  Loan findByNationalIdMortgage(String nationalCode);

    Double getAmount(Student student);

    List<Loan> findByStudent(Student student);

    Loan findEducationLoan(Student student);

    Loan findTuitionLoan(Student student);

    Loan findMortgageLoan(Student student);
}
