package com.uche.customermapperservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customer_mapper_service")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "external_id", updatable = false, nullable = false)
    private UUID externalId;

    @Column(name = "customer_id", unique = true)
    private int customerId;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    public Customer() {
    }

    public Customer(int customerId, LocalDate createdDate) {
        this.externalId = null;
        this.customerId = customerId;
        this.createdDate = createdDate;
    }

    public UUID getExternalId() {

        return externalId;
    }

    public void setExternalId(UUID externalId) {

        this.externalId = externalId;
    }

    public int getCustomerId() {

        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {

        this.createdDate = createdDate;
    }
}
