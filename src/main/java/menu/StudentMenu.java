package menu;

import entity.person.Spouse;
import entity.person.Student;
import menu.installment.LoanPayBackMenu;
import menu.loan.LoanMenu;
import utility.InputHandling;
import utility.SecurityContext;

import java.text.ParseException;

public class StudentMenu {
    MainMenu menu = new MainMenu();

    String userName;
    String passWord;
    String today;


    public StudentMenu(String userName, String passWord, String today) throws ParseException {
        this.userName = userName;
        this.passWord = passWord;
        this.today = today;
        login();
    }

    public void login() throws ParseException {
        if (MainMenu.studentService.existByUserNameAndPassword(userName, passWord)) {
            Student student = MainMenu.studentService.findByUserName(userName);
            SecurityContext.fillStudentContext(student);
            studentMenu(student);
        } else {
            System.out.println("Invalid Username Or Password");
            menu.start();
        }
    }

    public void studentMenu(Student student) throws ParseException {
        System.out.println("Hello Again, " + student.getFirstname() + "!");
        boolean stillSignedIn = true;
        while (stillSignedIn) {
            String text = """
                    1. SignUp For new Loan
                    2. Previous Loans PayBacks
                    3. Edit Username And Password
                    4. Edit Your Grade
                    5. Edit Marriage Status
                    6. Logout
                                       
                    """;
            System.out.println(text);
            System.out.println("Please choose from above:");
            int input = InputHandling.switchInput(1, 6);
            switch (input) {
                case 1:
                    new LoanMenu().chooseLoan();
                    break;

                case 2: LoanPayBackMenu.installmentMenu();
                    break;
                case 3: {
                    Student edited = Updating.changeUserAndPass(student);
                    MainMenu.studentService.creatOrUpdate(edited);
                    break;
                }
                case 4: {
                    Student edited = Updating.changeGrade(student);
                    MainMenu.studentService.creatOrUpdate(edited);
                    break;
                }
                case 5: {
                    Student edited = Updating.changeMarriageStatus(student);
                    if (edited.isMarried() && !student.isMarried()) {
                        Spouse spouse = Regesteration.setSpouseInfo();
                        spouse.setStudent(student);
                        student.setSpouse(spouse);
                        MainMenu.spouseService.creatOrUpdate(spouse);
                    }
                    if (student.isMarried() && !edited.isMarried()) {
                        MainMenu.spouseService.delete(student.getSpouse().getId());
                    }

                    MainMenu.studentService.creatOrUpdate(edited);
                    break;
                }
                case 6: {

                    System.out.println("Goodbye, " + student.getFirstname() + "!");
                    SecurityContext.logout();
                    menu.start();
                    stillSignedIn = false;
                    break;
                }
            }
        }
    }
}