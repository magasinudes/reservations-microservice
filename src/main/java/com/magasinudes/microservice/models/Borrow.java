package com.magasinudes.microservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrows", schema = "public")
public class Borrow extends AuditModel {
    @Id
    @GeneratedValue(generator = "borrow_generator")
    @SequenceGenerator(
            name = "borrow_generator",
            sequenceName = "borrow_sequence",
            initialValue = 1
    )
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_at", nullable = false)
    private Date startAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_at", nullable = false)
    private Date endAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "returned_at")
    private Date returnedAt;

    @Column(name = "note")
    private String note;

    @JoinColumn(name = "user_id", nullable = false)
    private String userId;

    @JoinColumn(name = "resource_id", nullable = false)
    private String resourceId;

    // ------------
    // Associations
    // ------------

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "borrow_status_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BorrowStatus borrowStatus;

    // ------------
    // Helpers
    // ------------

    public Long getId() {
        return id;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(BorrowStatus status) {
        this.borrowStatus = status;
    }
}
