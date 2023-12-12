package com.example.usermanagement.validations.validator;

import com.example.usermanagement.validations.MatchPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PasswordValidation implements ConstraintValidator<MatchPassword,String> {
    @Override
    public void initialize(MatchPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8,30) ,

                new CharacterRule(EnglishCharacterData.UpperCase,1),

                new CharacterRule(EnglishCharacterData.LowerCase,1),

                new CharacterRule(EnglishCharacterData.Digit,1),

                new CharacterRule(EnglishCharacterData.Special,1),

                new WhitespaceRule()

        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()){
            return true;
        }

        List<String> messages = validator.getMessages(result);

        String messageTemplate = String.join(",",messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
