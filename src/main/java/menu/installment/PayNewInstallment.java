package menu.installment;

import entity.CreditCard;
import entity.Installment;
import entity.Loan;
import entity.person.Student;
import menu.Regesteration;
import utility.InputHandling;
import utility.SecurityContext;
import java.util.ArrayList;
import java.util.List;
import static menu.MainMenu.*;


public class PayNewInstallment {
    Student student = SecurityContext.getCurrentStudent();

    public void repayment() {
        List<Loan> loans = loanService.findByStudent(student);
        List<Integer> loanIds = new ArrayList<>();
        for (Loan loan : loans) {
            int loanId = loan.getId();
            loanIds.add(loanId);

        }
        loans.forEach(System.out::println);
        Integer loanId = InputHandling.integerInput();
        while (!loanIds.contains(loanId)) {
            System.out.println("Please Choose A Valid Id: ");
            loanId = InputHandling.integerInput();

        }
        Loan loan = loanService.findById(loanId).orElse(null);
        SecurityContext.fillLoanContext(loan);
        List<Installment> installments = Regesteration.fillInstallment(loan);
        List<Integer> numbers = new ArrayList<>();
        for (Installment installment : installments) {
            int number = installment.getNumber();
            numbers.add(number);

        }
        UnpaidInstallments.seeUnPaidInstallments();
        System.out.print("Please Enter The Number That you Want to Pay: ");
        Integer number = InputHandling.integerInput();
        while (!numbers.contains(number)) {
            System.out.println("Please Enter A Valid Number");
            number = InputHandling.integerInput();
        }

        Installment installment = installmentService.findByNumber(number, loanId);
        CreditCard creditCard = Regesteration.setCardInfo();
        if (creditCardService.isSameCard(student.getId(), creditCard.getCardNumber())) {
            installment.setIspaid(true);
            installment.setId(installment.getId());
            installmentService.creatOrUpdate(installment);
            System.out.println(" SUCCESSFULLY REPAID :) ");
        } else {
            System.out.println("The Card Does Not Match");

        }
    }
}
