package com.example.abc.controller.jsp.account.valid;
//自訂驗證器
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MyValid.class)
public @interface FieldMatch {
    String message()default "密碼要一致";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String first();
    String second();
}















