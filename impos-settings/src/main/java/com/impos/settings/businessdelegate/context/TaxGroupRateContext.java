package com.impos.settings.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.businessdelegate.context.IBusinessDelegateContext;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxGroupRateContext implements IBusinessDelegateContext{

}
