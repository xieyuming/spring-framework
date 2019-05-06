/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @AutowireTestConstructor} defines class-level metadata that is used to
 * determine if a test class constructor should be automatically autowired from
 * components in the test's {@link org.springframework.context.ApplicationContext
 * ApplicationContext}.
 *
 * <p>If {@code @AutowireTestConstructor} is not present on a test class, the
 * default <em>test constructor autowire</em> mode will be used. See
 * {@link #AUTOWIRE_TEST_CONSTRUCTOR_PROPERTY_NAME} for details on how to change
 * the global default value.
 *
 * <p>As of Spring Framework 5.2, this annotation is only supported in conjunction
 * with the {@link org.springframework.test.context.junit.jupiter.SpringExtension
 * SpringExtension} for use with JUnit Jupiter.
 *
 * @author Sam Brannen
 * @since 5.2
 * @see org.springframework.beans.factory.annotation.Autowired @Autowired
 * @see org.springframework.test.context.junit.jupiter.SpringExtension SpringExtension
 * @see org.springframework.test.context.junit.jupiter.SpringJUnitConfig @SpringJUnitConfig
 * @see org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig @SpringJUnitWebConfig
 * @see ContextConfiguration @ContextConfiguration
 * @see ContextHierarchy @ContextHierarchy
 * @see ActiveProfiles @ActiveProfiles
 * @see TestPropertySource @TestPropertySource
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AutowireTestConstructor {

	/**
	 * System property used to configure the default <em>test constructor autowire</em>
	 * mode: {@value #TEST_CONSTRUCTOR_AUTOWIRE_PROPERTY_NAME}.
	 * <p>May alternatively be configured via the
	 * {@link org.springframework.core.SpringProperties} mechanism.
	 * <p>If the property is not set, the value will default to {@code false}.
	 * @see #value
	 */
	String TEST_CONSTRUCTOR_AUTOWIRE_PROPERTY_NAME = "spring.test.constructor.autowire";


	/**
	 * Flag for setting the <em>test constructor autowire</em> mode.
	 * @return {@code true} if the test constructor should be autowired
	 * @see #AUTOWIRE_TEST_CONSTRUCTOR_PROPERTY_NAME
	 * @see org.springframework.beans.factory.annotation.Autowired @Autowired
	 */
	boolean value() default true;

}
