package menu.loan;

import entity.Loan;
import entity.enumeration.LoanType;
import entity.enumeration.PaymentType;
import entity.person.Student;
import utility.SecurityContext;
import java.time.LocalDate;
import static menu.MainMenu.*;


public class MortgageMenu {
    public static Loan setMortgageLoan(Student student) {
        LocalDate creationDate = SecurityContext.getTodayDate();
        double amount;
        if (addressService.isCapital(student.getAddress().getCity())) {
            amount = 32000000;
        } else if (addressService.isMetropolis(student.getAddress().getCity())) {
            amount = 26000000;
        } else {
            amount = 19500000;
        }
        LoanType loanType = LoanType.MORTGAGE;
        PaymentType paymentType = PaymentType.ONCE_IN_EACH_ACADEMIC_LEVEL;
        return new Loan(amount, student, loanType, paymentType, creationDate);
    }
}

