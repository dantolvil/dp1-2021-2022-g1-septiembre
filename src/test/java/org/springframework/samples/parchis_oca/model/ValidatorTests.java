package org.springframework.samples.parchis_oca.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Locale;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.samples.parchis_oca.user.User;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

class ValidatorTests {

	private Validator createValidator() {
		
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.afterPropertiesSet();
		
		return localValidatorFactoryBean;
	}

	@Test
	void shouldNotValidateWhenFirstNameEmpty() {

		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Person person = new Person();
		person.setFirstName("");
		person.setLastName("smith");

		Validator validator = createValidator();
		Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Person> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("firstName");
		assertThat(violation.getMessage()).isEqualTo("must not be empty");
	}
	
	 @Test
	    void shouldNotValidateInvalidUserNameAndPassword() {

			User user = new User();
	        user.setUsername("userTest");
	        user.setPassword("passTest");


	        Validator validator = createValidator();
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

			assertThat(constraintViolations.size()).isEqualTo(0);
	    }

	    @Test
	    void shouldValidateUserNameAndPassword() {

	        User user = new User();
	        user.setUsername("userTest");
	        user.setPassword("passTest");


	        Validator validator = createValidator();
	        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

	        assertThat(constraintViolations.size()).isEqualTo(0);
	    }


}
