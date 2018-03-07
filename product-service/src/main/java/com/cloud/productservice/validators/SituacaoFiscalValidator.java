package com.cloud.productservice.validators;

import com.cloud.productservice.integrations.SituacaoFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SituacaoFiscalValidator implements ConstraintValidator<VerifyExistenceSituacaoFiscal, Long> {

    @Autowired
    private ApplicationContext context;

    @Override
    public void initialize(VerifyExistenceSituacaoFiscal constraint) {}

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return context.getBean(SituacaoFiscalService.class).exists(id);
    }
}
