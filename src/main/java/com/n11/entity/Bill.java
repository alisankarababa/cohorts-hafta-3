package com.n11.entity;

import com.n11.interfaces.ITotalAmountDue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
public class Bill extends BaseEntity implements ITotalAmountDue {

    private Long id;
    private Long customerId;
    private Long companyId;
    private Double totalAmountDue;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", companyId=" + companyId +
                ", totalAmountDue=" + String.format("%.2f", totalAmountDue) +
                ", timeOfCreation=" + super.getTimeOfCreation() +
                '}';
    }
}
