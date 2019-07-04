package com.magasinudes.microservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrow_statuses", schema = "public")
public class BorrowStatus extends AuditModel {
    @Id
    @GeneratedValue(generator = "borrow_status_generator")
    @SequenceGenerator(
            name = "borrow_status_generator",
            sequenceName = "borrow_status_sequence",
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

    @OneToMany(mappedBy = "borrowStatus", orphanRemoval = true, targetEntity = Borrow.class)
    @JsonIgnore
    private Set<Borrow> borrows = new HashSet<>();

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

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void addBorrow(Borrow borrow) {
        this.borrows.add(borrow);
        borrow.setBorrowStatus(this);
    }
}
