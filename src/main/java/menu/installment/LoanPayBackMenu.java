package menu.installment;
import entity.person.Student;
import menu.loan.LoanMenu;
import utility.InputHandling;
import utility.SecurityContext;
import java.text.ParseException;
import java.time.LocalDate;
import static menu.MainMenu.*;
public class LoanPayBackMenu {

   public static void installmentMenu() throws ParseException {
            Student student = SecurityContext.getCurrentStudent();
            LocalDate localDate = SecurityContext.getTodayDate();

            if (studentService.isStudentGraduated(student, localDate)) {
                System.out.println("""
                    *** Installment Menu ***
                                   
                    1- Show Paid Installments
                    2- Show UnPaid Installments
                    3- Pay installment
                    4- Back
                                        
                    """);
                int installmentInput = InputHandling.switchInput(1,4);
                switch (installmentInput) {
                    case 1 -> PaidInstallments.seePaidInstallments();
                    case 2 -> UnpaidInstallments.seeUnPaidInstallments();
                    case 3 -> new PayNewInstallment().repayment();
                    case 4 -> LoanMenu.backToStudent();
                }
            } else {
                System.out.println("This Page is Locked For You Because\n" +
                        "You Have Not Graduated Yet!");
                LoanMenu.backToStudent();
            }
        }
    }

