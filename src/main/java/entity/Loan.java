package entity;

import base.entity.BaseEntity;
import entity.enumeration.LoanType;
import entity.enumeration.PaymentType;
import entity.enumeration.StudentGrade;
import entity.enumeration.UnversityType;
import entity.person.Student;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan extends BaseEntity<Integer> {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "loanType")
    private LoanType loanType;

    private double amount;

    @ToString.Exclude
    @OneToMany(mappedBy = "loan",cascade = CascadeType.ALL)
    private List<Installment> installments;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Student student;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "studentGrade")
    private StudentGrade studentGrade;

    private String city ;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "unversityType")
    private UnversityType unversityType;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "paymentType")
    private PaymentType paymentType;

    private String rentalNumber;

    private LocalDate creationDate;


    public Loan(double amount, Student student , LoanType loanType , PaymentType paymentType, LocalDate creationDate) {
        this.amount = amount;
        this.student = student;
        this.loanType = loanType;
        this.paymentType = paymentType;
        this.creationDate = creationDate;
    }
}
