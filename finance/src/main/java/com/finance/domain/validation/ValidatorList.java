package com.finance.domain.validation;

import java.util.LinkedList;
import java.util.List;

public class ValidatorList {

    private final List<AbstractValidator> validatorList;


    private ValidatorList(){
        this.validatorList = new LinkedList<>();
    }

    public static ValidatorList of(){
        return new ValidatorList();
    }

    public ValidatorList consistOf(AbstractValidator abstractValidator){

        this.validatorList.add(abstractValidator);

        return this;
    }

    public void validate(){
        this.validatorList.forEach(AbstractValidator::validate);
    }
}