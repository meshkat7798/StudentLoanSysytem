package menu;

import entity.*;
import entity.enumeration.BankType;
import entity.enumeration.StudentGrade;
import entity.enumeration.UnversityType;
import entity.person.Spouse;
import entity.person.Student;
import utility.InputHandling;
import utility.SecurityContext;
import utility.Validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Regesteration {


    public static Spouse setSpouseInfo() {
        System.out.println("*** Spouse Information ***");

        System.out.println("firstname:");
        String firstname = InputHandling.nameInput();

        System.out.println("lastname:");
        String lastname = InputHandling.nameInput();

        System.out.println("fatherName:");
        String fatherName = InputHandling.nameInput();

        System.out.println("motherName:");
        String motherName = InputHandling.nameInput();

        System.out.println("birthCertificateNumber:");
        String birthCertificateNumber = InputHandling.stringInput();
        while (!Validation.isValid10DigitNumber(birthCertificateNumber)) {
            System.out.println("Please Enter Valid Date!");
            System.out.println("birthCertificateNumber:");
            birthCertificateNumber = InputHandling.stringInput();
        }

        System.out.println("nationalId:");
        String nationalId = InputHandling.stringInput();
        while (!Validation.isValid10DigitNumber(nationalId)) {
            System.out.println("Please Enter Valid Date!");
            System.out.println("nationalId:");
            nationalId = InputHandling.stringInput();
        }
        System.out.println("dateOfBirth:");
        String dateOfBirth = InputHandling.dateInput();

        return new Spouse(firstname, lastname, fatherName, motherName, birthCertificateNumber, nationalId, dateOfBirth);
    }


    public static Student setStudentInfo() {
        System.out.println("*******************");
        System.out.println("Please fill the student form: ");

        System.out.println("firstname:");
        String firstname = InputHandling.nameInput();

        System.out.println("lastname:");
        String lastname = InputHandling.nameInput();

        System.out.println("fatherName:");
        String fatherName = InputHandling.nameInput();

        System.out.println("motherName:");
        String motherName = InputHandling.nameInput();

        System.out.println("birthCertificateNumber:");
        String birthCertificateNumber = InputHandling.stringInput();
        while (!Validation.isValid10DigitNumber(birthCertificateNumber)) {
            System.out.println("Please Enter Valid Date!");
            System.out.println("birthCertificateNumber:");
            birthCertificateNumber = InputHandling.stringInput();
        }

        System.out.println("nationalId:");
        String nationalId = InputHandling.stringInput();
        while (!Validation.isValid10DigitNumber(nationalId)) {
            System.out.println("Please Enter Valid Date!");
            System.out.println("nationalId:");
            nationalId = InputHandling.stringInput();
        }
        System.out.println("dateOfBirth:");
        String dateOfBirth = InputHandling.dateInput();

        System.out.println("""
                Marriage Status:
                1. Married
                2. Single
                """
        );
        boolean married = InputHandling.booleanInput();

        Address address = setAddressInfo();
        System.out.println("*** University Information ***");
        System.out.println("UniversityName:");
        String universityName = InputHandling.stringInput();
       UnversityType unversityType = setType();
        System.out.println("studentNumber:");
        String studentNumber = String.valueOf(InputHandling.integerInput());
        System.out.println("entryYear:");
        int entryYear = Validation.validEntryYear();
        StudentGrade studentGrade =setGrade();
        System.out.println("""
                Do you have dormitory?
                1. Yes
                2. No
                """);
        boolean hasDorm = InputHandling.booleanInput();
        return new Student(firstname, lastname, fatherName, motherName, birthCertificateNumber, nationalId, dateOfBirth, studentNumber, universityName,
                unversityType, entryYear, studentGrade, married, address, hasDorm, nationalId, Validation.generateRandomPassword());
    }

    public static Address setAddressInfo() {
        System.out.println("*** Address Information ***");
        System.out.println("City:");
        String city = InputHandling.stringInput();

        System.out.println("Details(StreetName,ApartmentNO):");
        String details = InputHandling.stringInput();

        System.out.println("postalCode:");
        String postalCode = InputHandling.stringInput();
        while (!Validation.isValid10DigitNumber(postalCode)) {
            System.out.println("Please Enter Valid Date!");
            System.out.println("postalCode:");
            postalCode = InputHandling.stringInput();
        }

        return new Address(city, details, postalCode);
    }


    public static CreditCard setCardInfo() {
        System.out.println("*** CreditCard Information ***");
        System.out.println("Card Number: ");
        String cardNumber = InputHandling.stringInput();
        while (!Validation.isValidCardNumber(cardNumber)) {
            System.out.println("Please Enter A Valid CardNumber:");
            cardNumber = InputHandling.stringInput();
        }
        System.out.println("CVV2: ");
        Integer cvv2 = InputHandling.integerInput();
        while (!Validation.isValidCvv2(String.valueOf(cvv2))) {
            System.out.println("Please Enter A Valid CVV2:");
            cvv2 = InputHandling.integerInput();
        }
        System.out.print("Card Expiring Date: ");
        String expiringDate = InputHandling.dateInput();
        String bankText = """                 
                Please Choose Your Bank:
                1 - MELLI
                2 - REFAH
                3 - TEJARAT
                4 - MASKAN
                             
                """;
        System.out.println(bankText);
        int bankInput = InputHandling.switchInput(1, 4);
        BankType bankType = null;
        switch (bankInput) {
            case 1 -> bankType = BankType.MELLI;
            case 2 -> bankType = BankType.REFAH;
            case 3 -> bankType = BankType.TEJARAT;
            case 4 -> bankType = BankType.MASKAN;
        }
        return new CreditCard(cardNumber, cvv2, expiringDate, bankType);
    }


    public static StudentGrade setGrade(){
        System.out.println("Choose your new Grade:");
        System.out.println("""
                1.ASSOCIATE
                2.BACHELOR
                3.BACHELOR_DISCONTINUOUS
                4.MASTER
                5.MASTER_DISCONTINUOUS
                6.SPECIALIZED_DOCTORATE
                7.PHD_CONTINUOUS
                8.PHD_PROFESSIONAL
                           
                """);
        StudentGrade studentGrade = null;
        int chooseGrade = InputHandling.switchInput(1, 6);
        switch (chooseGrade) {
            case 1 -> studentGrade = StudentGrade.ASSOCIATE;
            case 2 -> studentGrade = StudentGrade.BACHELOR;
            case 3 -> studentGrade = StudentGrade.BACHELOR_DISCONTINUOUS;
            case 4 -> studentGrade = StudentGrade.MASTER;
            case 5 -> studentGrade = StudentGrade.MASTER_DISCONTINUOUS;
            case 6 -> studentGrade = StudentGrade.SPECIALIZED_DOCTORATE;
            case 7 -> studentGrade = StudentGrade.PHD_CONTINUOUS;
            case 8 -> studentGrade = StudentGrade.PHD_PROFESSIONAL;

        }
        return studentGrade;
    }

    public static UnversityType setType(){
        System.out.println("""
                Please choose your UniversityType:
                1.PUBLIC_DAILY
                2.PUBLIC_NIGHTLY
                3.PRIVATE
                4.PARDIS
                5.EXCESS_CAPACITY
                6.PAYAM_NOOR
                7.APPLIED_SCIENCES
                8.AZAD
                """);
        UnversityType unversityType = null;
        int chooseType = InputHandling.switchInput(1, 8);
        switch (chooseType) {
            case 1 -> unversityType = UnversityType.PUBLIC_DAILY;
            case 2 -> unversityType = UnversityType.PUBLIC_NIGHTLY;
            case 3 -> unversityType = UnversityType.PRIVATE;
            case 4 -> unversityType = UnversityType.PARDIS;
            case 5 -> unversityType = UnversityType.EXCESS_CAPACITY;
            case 6 -> unversityType = UnversityType.PAYAM_NOOR;
            case 7 -> unversityType = UnversityType.APPLIED_SCIENCES;
            case 8 -> unversityType = UnversityType.AZAD;
        }
        return unversityType;
    }

    public static List<Installment> fillInstallment(Loan loan) {
        LocalDate repaymentDate =SecurityContext.getTodayDate();
        List<Installment> installments = new ArrayList<>();
        double loanAmount = loan.getAmount();
        double repayAmount = (loanAmount * 4) / 100 + loanAmount;
        int count = 1;
        for (int i = 0; i < 5; i++) {
            double amount = (repayAmount / 31) * Math.pow(2, i);
            for (int j = 0; j < 12; j++) {
                Installment installment = new Installment(repaymentDate,amount/12,false,count++);
                installments.add(installment);
                repaymentDate = repaymentDate.plusMonths(1);
            }
        }
        return installments;
    }



}
    