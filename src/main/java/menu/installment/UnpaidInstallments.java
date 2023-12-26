package menu.installment;

import utility.InputHandling;
import utility.SecurityContext;

import java.util.Arrays;
import java.util.stream.Collectors;
import static menu.MainMenu.*;

public class UnpaidInstallments {

    public static void seeUnPaidInstallments() {
        int loanId = LoanPayBackMenu.showStudentLoans(SecurityContext.getCurrentStudent());
        installmentService.unpaidInstallments(loanId)
                .stream()
                .map(row -> Arrays.stream(row)
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}
