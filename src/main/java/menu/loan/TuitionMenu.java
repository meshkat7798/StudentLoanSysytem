package menu.loan;

import entity.Loan;
import entity.enumeration.LoanType;
import entity.enumeration.PaymentType;
import entity.person.Student;
import utility.SecurityContext;
import java.time.LocalDate;

public class TuitionMenu {
    public static Loan setTuitionLoan(Student student){
        LocalDate creationDate = SecurityContext.getTodayDate();
        double amount = 0;
        switch (student.getStudentGrade()) {
            case BACHELOR, ASSOCIATE, BACHELOR_DISCONTINUOUS -> amount =1300000;
            case MASTER, MASTER_DISCONTINUOUS, PHD_CONTINUOUS, PHD_PROFESSIONAL -> amount=2600000;
            case SPECIALIZED_DOCTORATE ->  amount = 6500000;
        }
        LoanType loanType = LoanType.TUITION;
        PaymentType paymentType = PaymentType.ONCE_IN_EACH_TERM;
        return new Loan(amount,student,loanType,paymentType,creationDate);
    }

}
