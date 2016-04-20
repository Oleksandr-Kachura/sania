package com.test.servlet.util;


import com.test.servlet.exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorUtils {



    public void validate(Object o) throws ValidationException {
        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        //SpringCheckInitializationListener - add spring service to Oval Conf
        myConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        Validator validator = new Validator(myConfigurer);
        List<ConstraintViolation> violations = validator.validate(o); //provides detailed information about a single constraint
        Map<String, String> map = new HashMap<String, String>();
        if (violations.size() > 0) {
            for (ConstraintViolation cs : violations) {
                OValContext c = cs.getContext(); // Returns the context where the constraint violation occurred.
                if (c instanceof FieldContext) {
                    Field field = ((FieldContext) c).getField();
                    map.put(field.getName(), cs.getMessage());
                }
            }
            throw new ValidationException(map);
        }
    }
}
