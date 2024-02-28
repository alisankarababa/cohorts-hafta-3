package com.n11.util;

import com.n11.interfaces.ITotalAmountDue;

import java.util.List;
import java.util.OptionalDouble;

public class Mean {

    private Mean() {

    }

    public static double calculate(List<? extends ITotalAmountDue> list) {

        OptionalDouble optionalDouble = list.stream()
                .mapToDouble(ITotalAmountDue::getTotalAmountDue)
                .average();

        if(optionalDouble.isEmpty()) {
            return 0;
        }

        return optionalDouble.getAsDouble();
    }
}
