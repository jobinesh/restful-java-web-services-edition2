/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch4.validation;

import com.packtpub.rest.ch4.model.Department;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

/**
 * Defines the logic to validate a given constraint It just follows a dummy
 * implementation, you can override isDeptExistsForLoc() to provide real life
 * implementation.
 *
 * @author Jobinesh
 */
public class ValidDepartmentValidator implements ConstraintValidator<ValidDepartment, Department> {

    private static final Logger logger = Logger.getLogger(ValidDepartmentValidator.class.getName());

    @Override
    public void initialize(ValidDepartment constraintAnnotation) {
    }

    @Override
    public boolean isValid(Department department, ConstraintValidatorContext context) {
        logger.log(Level.INFO, "isValid: " + department.toString());
        if (isDeptExistsForLoc(department.getDepartmentId(),
                department.getDepartmentName(), department.getLocationId())) {
            return true;
        }

        return false;
    }

    private boolean isDeptExistsForLoc(Short deptId, String deptName, Short locationId) {
        return false;
    }

}
