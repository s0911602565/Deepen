package com.example.abc.util;

import com.example.abc.controller.Th3;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<Th3, Object> {

    private String firstName;
    private String secondName;

    @Override
    public void initialize(Th3 constraintAnnotation) {
        firstName = constraintAnnotation.firs();
        secondName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try{
            final Object firstObj = BeanUtils.getProperty(value , firstName);
            final Object secondObj = BeanUtils.getProperty(value , secondName);
            boolean isValid = (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
            if(!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(secondName).addConstraintViolation();
            }
            return isValid;
        }catch (Exception e){
            //
        }
        return true;
    }
}
