package com.ty.validator;

import jakarta.validation.ConstraintValidatorContext;

public interface RequestDtoValidator<T> {

	public boolean validate(T requestData,ConstraintValidatorContext context);
}
