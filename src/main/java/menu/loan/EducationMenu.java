package menu.loan;

import entity.Loan;
import entity.enumeration.LoanType;
import entity.enumeration.PaymentType;
import entity.person.Student;
import utility.SecurityContext;
import java.time.LocalDate;

public class EducationMenu {

    public static Loan setEducationLoan(Student student){
        LocalDate creationDate = SecurityContext.getTodayDate();
        double amount = 0;
        switch (student.getStudentGrade()) {
            case BACHELOR, ASSOCIATE, BACHELOR_DISCONTINUOUS -> amount =1900000;
            case MASTER, MASTER_DISCONTINUOUS, PHD_CONTINUOUS, PHD_PROFESSIONAL -> amount=2250000;
            case SPECIALIZED_DOCTORATE ->  amount = 2600000;
        }
        LoanType loanType = LoanType.EDUCATION;
        PaymentType paymentType = PaymentType.ONCE_IN_EACH_TERM;
        return new Loan(amount,student,loanType,paymentType,creationDate);
    }
        }


