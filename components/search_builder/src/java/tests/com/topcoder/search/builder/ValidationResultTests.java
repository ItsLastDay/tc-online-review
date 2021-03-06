/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.search.builder;


import com.topcoder.search.builder.filter.EqualToFilter;
import com.topcoder.search.builder.filter.Filter;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for ValidationResult.
 * </p>
 *
 * @author victorlxd, TCSDEVELOPER
 * @version 1.1
 */
public class ValidationResultTests extends TestCase {
    /**
     * The String of message for test.
     */
    private static final String MESSAGE = "message";

    /**
     * The param filter for test ValidationResult.
     */
    private Filter filter = null;

    /**
     * The invalid instance of ValidationResult for test.
     */
    private ValidationResult invalid = null;
    /**
     * The valid instance of ValidationResult for test.
     */
    private ValidationResult valid = null;

    /**
     * setUp.
     */
    protected void setUp() {
        filter = new EqualToFilter("age", new Integer(1));

        invalid = ValidationResult.createInvalidResult(MESSAGE, filter);

        valid = ValidationResult.createValidResult();
    }
    /**
     * testDown.
     */
    protected void tearDown() {
        //empty
    }

    /**
     * test the ValidationResultCreate.
     *
     */
    public void testValidationResultCreate1() {
        assertNotNull("The create of invalid ValidationResult should be success",
            invalid);

        assertNotNull("The create of valid ValidationResult should be success",
            valid);
    }

    /**
     * test the ValidationResultCreate.
     *
     */
    public void testValidationResultCreate2() {
        try {
            ValidationResult test = ValidationResult.createInvalidResult(MESSAGE,
                    filter);
        } catch (Exception e) {
            fail("No Exception should be throw");
        }
    }

    /**
     * test the ValidationResultCreate.
     *
     */
    public void testValidationResultCreate3() {
        try {
            ValidationResult test = ValidationResult.createValidResult();
        } catch (Exception e) {
            fail("No Exception should be throw");
        }
    }

    /**
     * test fail with ValidationResultCreate.For MESSAGE is null.
     *
     */
    public void testValidationResultCreate4() {
        try {
            ValidationResult test = ValidationResult.createInvalidResult(null,
                    filter);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * test fail with ValidationResultCreate. For filter is null.
     *
     */
    public void testValidationResultCreate5() {
        try {
            ValidationResult test = ValidationResult.createInvalidResult(MESSAGE,
                    null);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * test fail with ValidationResultCreate.For MESSAGE is empty.
     *
     */
    public void testValidationResultCreate6() {
        try {
            ValidationResult test = ValidationResult.createInvalidResult("",
                    filter);
            fail("IllegalArgumentException should be throw");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * test the invalid ValidationResult with value.
     *
     */
    public void tesstInvalid1() {
        //isValid return false with invalid result
        assertFalse("The isValid should return false.", invalid.isValid());

        //assertEquals with the message
        assertEquals("The message should be same as the seted.", MESSAGE,
            invalid.getMessage());

        //assertFilter Equals
        assertEquals("The filter should be same as the seted.", filter,
            invalid.getFailedFilter());
    }

    /**
     * test the valid ValidationResult.
     *
     */
    public void testvalid1() {
        //isvalid return true
        assertTrue("The isValid should return true", valid.isValid());
    }
}
