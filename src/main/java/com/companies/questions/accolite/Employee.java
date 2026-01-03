package com.companies.questions.accolite;

import lombok.Builder;

@Builder
public record Employee (
        int empId,
        String firstName,
        String lastName,
        int mgrId,

        String department,
        double salary
){

}
