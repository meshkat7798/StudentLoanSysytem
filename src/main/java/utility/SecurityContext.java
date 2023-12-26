package utility;
import entity.Loan;
import entity.person.Student;
import lombok.Getter;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class SecurityContext {


    private SecurityContext() {
    }
    @Getter
    private static Student currentStudent;
    @Getter
    private static LocalDate todayDate;
    @Getter
    private static Loan thisLoan;
    public static void fillDateContext(LocalDate today) {
        todayDate = today;
    }
    public static void fillLoanContext(Loan loan) {
        thisLoan = loan;
    }
    public static void logout() {
        currentStudent = null;
    }
    public static void fillStudentContext(Student student){currentStudent = student;}

}
