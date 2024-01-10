package com.ty.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = {RegistrationRequestDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistrationRequestValidator {
	
	String message() default "Invalid Registration quest data";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};
	
}
