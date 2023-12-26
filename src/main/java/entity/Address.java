package entity;

import base.entity.BaseEntity;
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
public class Address extends BaseEntity<Integer> {
    private String city;
    private String details;
    private String postalCode;
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Student student;

    public Address(String city, String details, String postalCode) {
        this.city = city;
        this.details = details;
        this.postalCode = postalCode;
    }
}
