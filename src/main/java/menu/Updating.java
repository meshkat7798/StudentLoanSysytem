package menu;

import entity.person.Student;
import utility.InputHandling;
import utility.Validation;

public class Updating {

    public static Student changeUserAndPass(Student student){
        System.out.println("Enter new username:");
        String username = InputHandling.stringInput();
        while (MainMenu.studentService.existByUserName(username)){
            System.out.println("This userName Already Exists! Please choose another one:");
            username = InputHandling.stringInput();
        }
        System.out.println("Enter new password:");
        String password = InputHandling.stringInput();
        while (!Validation.isValidPassword(password)){
            System.out.println("""
                    Password should be at least 8 characters\040
                    and must contain at least 1 sign(!@#$%), 1 number and 1 Capital letter!""");
            password = InputHandling.stringInput();
        }
        student.setUsername(username);
        student.setPassword(password);
        student.setId(student.getId());
        System.out.println("Username And Password Edited Successfully!");
        return student;
    }

    public static Student changeGrade(Student student){
        Student edited = student;
        edited.setStudentGrade(Regesteration.setGrade());
        System.out.println("UniversityName:");
        String UniversityName = InputHandling.stringInput();
        edited.setUniversityName(UniversityName);
        edited.setUnversityType(Regesteration.setType());
        System.out.println("Choose your new EntryYear:");
        int entryYear = Validation.validEntryYear();
        edited.setEntryYear(entryYear);
        if(edited.getStudentGrade()==student.getStudentGrade()) {
            edited.setGotMortgageInThisGrade(false);
        }
        System.out.println("""
                Do you have dormitory?
                1. Yes
                2. No
                """);
        edited.setHasDormitory(InputHandling.booleanInput());
        edited.setId(student.getId());
        System.out.println("Successfully edited!");
        return edited;
    }

    public static Student changeMarriageStatus(Student student){
        System.out.println("""
                Are you Married? :
                1. Yes
                2. No
                """
        );
        student.setMarried(InputHandling.booleanInput());
        student.setId(student.getId());
        return student;

    }

}
