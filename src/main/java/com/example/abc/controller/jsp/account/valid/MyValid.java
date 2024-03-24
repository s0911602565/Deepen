package com.example.abc.controller.jsp.account.valid;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValid implements ConstraintValidator<FieldMatch , Object> {

    private String pwd1;
    private String pwd2;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        pwd1 = constraintAnnotation.first();
        pwd2 = constraintAnnotation.second();
        System.out.println("?? " + constraintAnnotation.first());
        System.out.println("? " +constraintAnnotation.second());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try{
            final Object w1 = BeanUtils.getProperty(value , pwd1);
            final Object w2 = BeanUtils.getProperty(value , pwd2);
            boolean isValid = (w1 == null&& w2 ==null) || (w1 != null && w1.equals(w2));
            System.out.println("pwd1 " + w1);
            System.out.println("pwd2 " + w2);
            System.out.print("isValid:");
            System.out.println(isValid);
            if(!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(pwd1).addConstraintViolation();
                return isValid;
            }
        }catch (Exception e){

        }
        return true;
    }
}
