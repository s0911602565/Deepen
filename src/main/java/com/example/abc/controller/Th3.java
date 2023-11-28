package com.example.abc.controller;

import com.example.abc.util.FieldMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface Th3 {
    String msg() default "1、2 需要相同";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

    String firs();
    String second();

}
