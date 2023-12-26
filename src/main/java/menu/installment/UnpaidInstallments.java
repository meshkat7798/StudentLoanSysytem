package menu.installment;

import utility.InputHandling;
import java.util.Arrays;
import java.util.stream.Collectors;
import static menu.MainMenu.*;

public class UnpaidInstallments {

    public static void seeUnPaidInstallments() {
        System.out.println("Please Enter Your Loan Id:");
        int loanId = InputHandling.integerInput();
        installmentService.unpaidInstallments(loanId)
                .stream()
                .map(row -> Arrays.stream(row)
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }
}
