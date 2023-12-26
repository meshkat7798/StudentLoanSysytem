package entity.person;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity<Integer> {
    private String firstname;
    private String lastname;
    private String fatherName;
    private String motherName;
    private String birthCertificateNumber;
    private String nationalId;
    private String dateOfBirth;
}
