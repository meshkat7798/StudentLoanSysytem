package repository;

import base.repository.BaseEntityRepository;
import entity.Installment;
import entity.Loan;
import entity.person.Student;

import java.util.List;

@SuppressWarnings("unused")
public interface InstallmentRepository extends BaseEntityRepository<Installment, Integer> {

    List<Object[]> paidInstallments(int loanId);

    List<Object[]> unpaidInstallments(int loanId);

    Installment findByNumber(Integer number, Integer loanId);


}
