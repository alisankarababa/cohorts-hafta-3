package com.n11.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
public class Bill extends BaseEntity{

    private Long id;
    private Long customerId;
    private Double totalAmountDue;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalAmountDue=" + String.format("%.2f", totalAmountDue) +
                ", timeOfCreation=" + super.getTimeOfCreation() +
                '}';
    }
}
