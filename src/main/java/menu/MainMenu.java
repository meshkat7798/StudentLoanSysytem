package menu;

import entity.person.Spouse;
import entity.person.Student;
import service.*;
import utility.ApplicationContext;
import utility.InputHandling;
import utility.SecurityContext;

import java.text.ParseException;

public class MainMenu {
    public static AddressService addressService = ApplicationContext.getAddressService();
    public static SpouseService spouseService = ApplicationContext.getSpouseService();
    public static StudentService studentService = ApplicationContext.getStudentService();
    public static LoanService loanService = ApplicationContext.getLoanService();
    public static InstallmentService installmentService = ApplicationContext.getInstallmentService();
    public static CreditCardService creditCardService = ApplicationContext.getCreditCardService();
    protected String userName;
    protected String passWord;
    protected String today;


    public void start() throws ParseException {
        String text = """
                *** Welcome ***
                1. SignUp
                2. SignIn
                3. EXIT
                                   
                """;
        System.out.println(text);
        System.out.println("Please choose from above:");
        int input = InputHandling.switchInput(1, 3);
        switch (input) {
            case 1 -> {
                Student student = Regesteration.setStudentInfo();
                if (student.isMarried()) {
                    Spouse spouse = Regesteration.setSpouseInfo();
                    spouse.setStudent(student);
                    student.setSpouse(spouse);
                    student.setSpouseNationalId(spouse.getNationalId());
                    spouseService.creatOrUpdate(spouse);

                }
                studentService.creatOrUpdate(student);
                addressService.creatOrUpdate(student.getAddress());
                System.out.println("""
                        You Have Been Registered Successfully!
                        You initial username is your nationalId
                        And your Password is:
                        """ + student.getPassword()
                );
                start();
            }
            case 2 -> {
                login();
                new StudentMenu(userName, passWord, today);
            }
            case 3 -> {
                System.out.println("See You soon :)");
                System.exit(0);
            }
        }


    }


    void login() {

        System.out.println("PLEASE ENTER YOUR USERNAME : ");
        this.userName = InputHandling.stringInput();
        System.out.println("PLEASE ENTER YOUR PASSWORD : ");
        this.passWord = InputHandling.stringInput();
        System.out.println("Enter Current Date:(yyyy-mm-dd)");
        this.today = InputHandling.dateInput();
        SecurityContext.fillDateContext(InputHandling.stringToDate(this.today));
    }

}