package menu.loan;

import entity.CreditCard;
import entity.Installment;
import entity.Loan;
import entity.enumeration.UnversityType;
import entity.person.Student;
import menu.MainMenu;
import menu.Regesteration;
import menu.StudentMenu;
import service.*;
import utility.ApplicationContext;
import utility.InputHandling;
import utility.SecurityContext;
import utility.Validation;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import static menu.MainMenu.*;

public class LoanMenu {

    public void chooseLoan() throws ParseException {
        Student student = SecurityContext.getCurrentStudent();
        LocalDate date = SecurityContext.getTodayDate();
        if (Validation.isRightTime()) {
            if (!studentService.isStudentGraduated(student, date)) {
                System.out.println("""
                        Please choose the type of loan you would like to sign up for:
                                        
                        1.Education Loan
                        2.Tuition Loan
                        3.Mortgage Loan
                        4.Back""");

                int input = InputHandling.switchInput(1, 4);
                switch (input) {
                    case 1 -> {
                        if (!loanService.studentHasActiveEducationalLoan(student)) {
                            Loan education = EducationMenu.setEducationLoan(student);
                            education.setStudentGrade(student.getStudentGrade());
                            education.setUnversityType(student.getUnversityType());
                            loanService.creatOrUpdate(education);
                            SecurityContext.fillLoanContext(education);
                            List<Installment> installments = Regesteration.fillInstallment(education);
                            for (Installment installment : installments) {
                                installment.setLoanId(education.getId());
                                installmentService.creatOrUpdate(installment);
                            }
                            education.setInstallments(installments);
                            CreditCard creditCard = Regesteration.setCardInfo();
                            creditCard.setStudentId(student.getId());
                            creditCardService.creatOrUpdate(creditCard);
                            System.out.println("Successfully Registered For EducationLoan");
                            backToStudent();
                        } else {
                            System.out.println("You Already Have An Active EducationLoan!");
                            chooseLoan();
                        }
                    }
                    case 2 -> {
                        if(student.getUnversityType()!= UnversityType.PUBLIC_DAILY){
                        if (!loanService.studentHasActiveTuitionLoan(student)) {
                            Loan tuition = TuitionMenu.setTuitionLoan(student);
                            tuition.setStudentGrade(student.getStudentGrade());
                            tuition.setUnversityType(student.getUnversityType());
                            loanService.creatOrUpdate(tuition);
                            SecurityContext.fillLoanContext(tuition);
                            List<Installment> installments = Regesteration.fillInstallment(tuition);
                            for (Installment installment : installments) {
                                installment.setLoanId(tuition.getId());
                                installmentService.creatOrUpdate(installment);
                            }
                            tuition.setInstallments(installments);
                            CreditCard creditCard = Regesteration.setCardInfo();
                            creditCard.setStudentId(student.getId());
                            creditCardService.creatOrUpdate(creditCard);
                            System.out.println("Successfully Registered For TuitionLoan");
                            backToStudent();
                        } else {
                            System.out.println("You Already Have An Active TuitionLoan!");
                            chooseLoan();
                        }}else {
                            System.out.println("Your University Type Does Not Need Tuition! ");
                            chooseLoan();
                        }
                    }
                    case 3 -> {
                        if (student.isMarried()) {
                            if (!student.isHasDormitory()) {
                                if (loanService.studentHasNotActiveMortgageLoan(student,studentService)) {
                                    Loan mortgage = MortgageMenu.setMortgageLoan(student);
                                    mortgage.setStudentGrade(student.getStudentGrade());
                                    mortgage.setUnversityType(student.getUnversityType());
                                    mortgage.setCity(student.getAddress().getCity());
                                    loanService.creatOrUpdate(mortgage);
                                    SecurityContext.fillLoanContext(mortgage);
                                    List<Installment> installments = Regesteration.fillInstallment(mortgage);
                                    for (Installment installment : installments) {
                                        installment.setLoanId(mortgage.getId());
                                        installmentService.creatOrUpdate(installment);
                                    }
                                    mortgage.setInstallments(installments);
                                    CreditCard creditCard = Regesteration.setCardInfo();
                                    creditCard.setStudentId(student.getId());
                                    creditCardService.creatOrUpdate(creditCard);
                                    System.out.println("Successfully Registered For MortgageLoan");
                                    backToStudent();
                                } else {
                                    System.out.println("You Or Your Spouse Have An Active MortgageLoan Already!");
                                    chooseLoan();
                                }
                            } else {
                                System.out.println("You Have Dormitory. This loan Does not Apply to you! ");
                                chooseLoan();
                            }
                        } else {
                            System.out.println("This Loan is For Married Students Only!");
                            System.out.println("See you With your Spouse Next Time! ;)");
                        }
                    }
                    case 4 -> backToStudent();
                }
            } else {
                System.out.println("You Are Graduated At This Grade!");
                new StudentMenu(student.getUsername(), student.getPassword(), date.toString()).studentMenu(student);

            }
        } else {
            System.out.println("This Is Not A Right Time To Signup For A New Loan. Come Back In August 1st to 7th or November 1st to 7th!");
        }

    }

    public static void backToStudent() throws ParseException {
        Student student = SecurityContext.getCurrentStudent();
        LocalDate date = SecurityContext.getTodayDate();
        new StudentMenu(student.getUsername(), student.getPassword(), date.toString()).studentMenu(student);
    }

}