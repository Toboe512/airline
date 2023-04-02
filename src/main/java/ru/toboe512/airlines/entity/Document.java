package ru.toboe512.airlines.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class Document.
 * Implements Document Entity.
 *
 */

@Entity
@Table(name = "documents")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(name = "type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @Column(name = "number", length = 50, nullable = false)
    private String number;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    // TODO: 13.10.2022 Добавить Passenger
//    private Long passengerId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "passenger_id")
    @JsonIgnore
    @ToString.Exclude
    private Passenger passenger;

    @Setter(AccessLevel.NONE)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Setter(AccessLevel.NONE)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "version", nullable = false)
    @ToString.Exclude
    private Long version = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                type == document.type &&
                Objects.equals(number, document.number) &&
                Objects.equals(expiryDate, document.expiryDate) &&
                Objects.equals(createdAt, document.createdAt) &&
                Objects.equals(updatedAt, document.updatedAt) &&
                Objects.equals(version, document.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, number, expiryDate, createdAt, updatedAt, version);
    }
}
