package entity;

import base.entity.BaseEntity;
import entity.enumeration.BankType;
import entity.person.Student;
import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class CreditCard extends BaseEntity<Integer> {
    @Column(nullable = false)
    private String cardNumber;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Student student;

    @Column(nullable = false)
    private Integer cvv2;

    @Column(nullable = false)
    private String expiringDate;

    @Column
    @Enumerated(EnumType.STRING)
    private BankType bank;
    int studentId;

    public CreditCard(String cardNumber, Integer cvv2, String expiringDate, BankType bank) {
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.expiringDate = expiringDate;
        this.bank = bank;
    }
}
