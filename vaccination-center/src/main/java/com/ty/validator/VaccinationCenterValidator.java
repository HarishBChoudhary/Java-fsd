package com.ty.validator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {VaccinationCenterDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VaccinationCenterValidator {

	String message() default "Invalid Vaccination center data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
