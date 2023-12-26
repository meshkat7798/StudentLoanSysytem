package repository;

import base.repository.BaseEntityRepository;
import entity.Loan;
import entity.person.Student;

import java.util.List;

@SuppressWarnings("unused")
public interface LoanRepository extends BaseEntityRepository<Loan, Integer> {

   // Loan findByNationalIdMortgage(String nationalCode);

    Double getAmount(Student student);

    List<Loan> findByStudent(Student student);

    Loan findEducationLoan(Student student);

    Loan findTuitionLoan(Student student);

    Loan findMortgageLoan(Student student);
}
