package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Loan;
import entity.enumeration.LoanType;
import entity.person.Student;
import repository.LoanRepository;
import service.LoanService;
import service.StudentService;
import utility.SecurityContext;

import java.util.List;

@SuppressWarnings("unused")
public class LoanServiceImpl extends BaseEntityServiceImpl<Loan, Integer, LoanRepository> implements LoanService {
    public LoanServiceImpl(LoanRepository repository) {
        super(repository);
    }

    @Override
    public boolean studentHasActiveEducationalLoan(Student student) {
        List<Loan> loans = student.getLoans();
        if (!loans.isEmpty()) {
            try {
                for (Loan loan : loans) {
                    if (loan.getLoanType().equals(LoanType.EDUCATION)) {
                        if (loan.getCreationDate().getYear() == SecurityContext.getTodayDate().getYear())
                            return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean studentHasActiveTuitionLoan(Student student) {
        List<Loan> loans = student.getLoans();
        if (!loans.isEmpty()) {
            try {
                for (Loan loan : loans) {
                    if (loan.getLoanType().equals(LoanType.TUITION)) {
                        if (loan.getCreationDate().getYear() == SecurityContext.getTodayDate().getYear())
                            return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean studentHasNotActiveMortgageLoan(Student student, StudentService studentService) {
        List<Loan> loans = student.getLoans();
        boolean hasLoanBefore = false;
        boolean spouseHasLoanBefore = false;
        if (!loans.isEmpty()) {
            for (Loan l : loans) {
                if (l.getLoanType().equals(LoanType.MORTGAGE)) {
                    if (l.getStudentGrade() == student.getStudentGrade()) {
                        hasLoanBefore = true;
                        break;
                    }
                }
            }
            if ((studentService.existsByNationalId(student.getSpouseNationalId()))) {
                Student spouseStu= studentService.findByNationalId(student.getSpouseNationalId());
                List<Loan> spouseLoans = spouseStu.getLoans();
                if(!spouseLoans.isEmpty()){
                for (Loan loan : spouseLoans) {
                    if (loan.getLoanType().equals(LoanType.MORTGAGE)) {
                        if (loan.getStudentGrade() == spouseStu.getStudentGrade()) {
                            spouseHasLoanBefore = true;
                            break;
                        }
                    }
                }
            }}
        }
        return !hasLoanBefore && student.isMarried() && !student.isHasDormitory() && !spouseHasLoanBefore;
    }


    @Override
    public Double getAmount(Student student) {
        return repository.getAmount(student);
    }

    @Override
    public List<Loan> findByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public Loan findEducationLoan(Student student) {
        return repository.findEducationLoan(student);
    }

    @Override
    public Loan findTuitionLoan(Student student) {
        return repository.findTuitionLoan(student);
    }

    @Override
    public Loan findMortgageLoan(Student student) {
        return repository.findMortgageLoan(student);
    }

    @Override
    public Loan findLoanById(int id) {
        return repository.findLoanById(id);
    }
}
