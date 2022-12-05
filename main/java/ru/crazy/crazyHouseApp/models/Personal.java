package ru.crazy.crazyHouseApp.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personal")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private char sex;
    private Date dateOfBirth;
    private String phone;
    private Date dateEmploy;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    @ToString.Exclude
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet_id")
    @ToString.Exclude
    private Cabinet cabinet;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "personal")
    private List<Patient> patients = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateEmploy() {
        return dateEmploy;
    }

    public void setDateEmploy(Date dateEmploy) {
        this.dateEmploy = dateEmploy;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

//    public Personal(String lastName, String firstName,String middleName, char sex, String phone, Date) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.sex = sex;
//        this.dateOfBirth = dateOfBirth;
//        this.phone = phone;
//        this.dateEmploy = dateEmploy;
//        this.position = position;
//        this.cabinet = cabinet;
//        this.patients = patients;
//    }
}
//, Position position, Cabinet cabinet, List<Patient> patients
//dateOfBirth, , Date dateEmploy