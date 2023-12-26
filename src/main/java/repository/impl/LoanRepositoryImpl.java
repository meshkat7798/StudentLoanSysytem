package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Loan;
import entity.enumeration.LoanType;
import entity.person.Student;
import repository.LoanRepository;

import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("unused")
public  class LoanRepositoryImpl extends BaseEntityRepositoryImpl<Loan, Integer> implements LoanRepository {
    public LoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return null;
    }

//    @Override
//    public Loan findByNationalIdMortgage(String nationalId) {
//        try {
//            return entityManager.createQuery("""
//                                    from Loan l
//                                    where l.student.nationalId = :nationalId and l.loanType = :loantype
//                                    """
//                            , Loan.class)
//                    .setParameter("nationalId", nationalId)
//                    .setParameter("loantype", LoanType.MORTGAGE)
//                    .getSingleResult();
//        } catch (Exception e) {
//            return null;
//        }
//}

    @Override
    public Double getAmount(Student student) {
        try {
            return entityManager.createQuery("""
                            SELECT l.amount
                            FROM Loan l WHERE l.student = :student
                            """, Double.class)
                    .setParameter("student", student)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Loan> findByStudent(Student student) {
        try {
            return entityManager.createQuery("""
                            SELECT l FROM Loan l WHERE l.student = :student
                            """,Loan.class)
                    .setParameter("student", student)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Loan findEducationLoan(Student student) {
        try {
            return entityManager.createQuery("""
                            FROM Loan l1
                            WHERE l1.loanType = :loanType
                            AND l1.studentGrade IN (SELECT l.student.studentGrade FROM Loan l WHERE l.student = :student)
                            """, Loan.class)
                    .setParameter("loanType", LoanType.EDUCATION)
                    .setParameter("student", student)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Loan findTuitionLoan(Student student) {
        try {
            return entityManager.createQuery("""
                            FROM Loan l1
                            WHERE l1.loanType = :loanType
                            AND l1.studentGrade IN (SELECT l.student.studentGrade FROM Loan l WHERE l.student = :student)
                            """, Loan.class)
                    .setParameter("loanType", LoanType.TUITION)
                    .setParameter("student", student)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Loan findMortgageLoan(Student student) {
        try {
            return entityManager.createQuery("""
                            FROM Loan l1
                            WHERE l1.loanType = :loanType
                            AND l1.studentGrade IN (SELECT l.student.studentGrade FROM Loan l WHERE l.student = :student)
                            """, Loan.class)
                    .setParameter("loanType", LoanType.MORTGAGE)
                    .setParameter("student", student)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
