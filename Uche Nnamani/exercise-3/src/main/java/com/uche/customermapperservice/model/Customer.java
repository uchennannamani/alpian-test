package com.uche.customermapperservice.model;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

@Entity
@Table(name = "customer_mapper_service")
public class Customer {
    @Id
    @GeneratedValue
//    @Column(name = "external-id", updatable = false, nullable = false)
    private UUID externalId;
    // We will assume this to be from an external service provider. We wil assume the external.
    @Column(name = "customer_id", unique = true)
    private int customerId;
    // Since it will be provided during post, we will assume it is not a primary key. However, we need to make it a unique value.
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Customer() {
    }

    public Customer(int customerId, String createdDate) {
        this.externalId = null;
        this.customerId = customerId;
        this.createdDate = stringToDate(createdDate);
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

    private static LocalDate stringToDate(String inputDate) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate createdDate = null;
        try {
            if (!LocalDate.parse(inputDate, dateTimeFormatter).isAfter(currentDate)) {
                createdDate = LocalDate.parse(inputDate, dateTimeFormatter);
            }
        } catch (DateTimeParseException dateTimeParseException) {
            System.out.println("Date must be in this format: yyyy-mm-dd");

        } catch (DateTimeException dateTimeException) {
            System.out.println("Date should not be in the future");
        }

        return createdDate;
    }
}
