package ru.toboe512.airlines.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Class BookingRef.
 * Implements BookingRef Entity.
 *
 */
@Entity
@Table(name = "book_refs",
        uniqueConstraints = {
                @UniqueConstraint(name = "UniqueRefNumber", columnNames = {"ref_number"})
        }
)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    /**
     * Human-readable booking number.
     */
    @Size(message = "Booking reference must have from 6 to 8 characters", min = 6, max = 8)
    @NotBlank(message = "Booking reference can't be empty")
    @Column(name = "ref_number", nullable = false, length = 8)
    private String refNumber;

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "version", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long version = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        BookingRef bookingRef = (BookingRef) o;
        return this.id == bookingRef.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

