package com.function.annotation;

import com.function.enums.LimitType;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limit {
	String name() default "";
	
	String key() default "";

	String prefix() default "";

	int period();

	int count();

	LimitType limitType() default  LimitType.CUSTOMER;
}
