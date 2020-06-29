package com.impos.inventory.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.businessdelegate.context.IBusinessDelegateContext;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockTransferContext implements IBusinessDelegateContext {

}
