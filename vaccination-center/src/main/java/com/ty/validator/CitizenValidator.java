package com.ty.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {CitizenDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CitizenValidator {

	String message() default "Invalid Vaccination Center data";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	
}
