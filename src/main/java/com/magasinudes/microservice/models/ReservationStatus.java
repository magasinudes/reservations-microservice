package com.magasinudes.microservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation_statuses", schema = "public")
public class ReservationStatus extends AuditModel {
    @Id
    @GeneratedValue(generator = "reservation_status_generator")
    @SequenceGenerator(
            name = "reservation_status_generator",
            sequenceName = "reservation_status_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    // ------------
    // Associations
    // ------------

    @OneToMany(mappedBy = "reservationStatus", orphanRemoval = true, targetEntity = Reservation.class)
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();

    // ------------
    // Helpers
    // ------------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        reservation.setReservationStatus(this);
    }
}
