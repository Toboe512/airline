package ru.toboe512.airlines.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Percentage;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate dateOfBirth;

    @Email
    @Column(name = "email")
    private String username;

    @Column
    private String password;

    @Column(name = "mobile_num")
    private String mobileNumber;

    @Column(name = "nick_name")
    private String nickName;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Document> documents = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(firstName, passenger.firstName) &&
                Objects.equals(middleName, passenger.middleName) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(dateOfBirth, passenger.dateOfBirth) &&
                Objects.equals(username, passenger.username) &&
                Objects.equals(password, passenger.password) &&
                Objects.equals(mobileNumber, passenger.mobileNumber) &&
                Objects.equals(nickName, passenger.nickName) &&
                Objects.equals(documents, passenger.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, dateOfBirth, username, password, mobileNumber, nickName, documents);
    }
}
