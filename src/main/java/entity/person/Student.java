package entity.person;
import entity.Address;
import entity.CreditCard;
import entity.Loan;
import entity.enumeration.StudentGrade;
import entity.enumeration.UnversityType;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends Person {
    private String studentNumber;
    private String universityName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "unversityType")
    private UnversityType unversityType;

    private int entryYear;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "studentGrade")
    private StudentGrade studentGrade;
    private boolean married;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Spouse spouse;
    private String spouseNationalId;

    private boolean gotMortgageInThisGrade;

    @ToString.Exclude
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Loan> loans;

    @ToString.Exclude
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCards;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    private boolean hasDormitory;

    @Column(unique = true)
    private String username;
    private String password;


    public Student(String firstname, String lastname, String fatherName,
                   String motherName, String birthCertificateNumber,
                   String nationalId, String dateOfBirth, String studentNumber,
                   String universityName, UnversityType unversityType,
                   int entryYear, StudentGrade studentGrade, boolean married,
                   Address address, boolean hasDormitory, String username,
                   String password) {
        super(firstname, lastname, fatherName, motherName, birthCertificateNumber, nationalId, dateOfBirth);
        this.studentNumber = studentNumber;
        this.universityName = universityName;
        this.unversityType = unversityType;
        this.entryYear = entryYear;
        this.studentGrade = studentGrade;
        this.married = married;
        this.address = address;
        this.hasDormitory = hasDormitory;
        this.username = username;
        this.password = password;
    }



}