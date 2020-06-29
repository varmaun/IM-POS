package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.ExpenseTypeContext;
import com.impos.settings.domain.ExpenseType;

public interface IExpenseTypeService {
	
	ExpenseType create(ExpenseType expenseType);

	void deleteExpenseType(String expenseTypeId);

	ExpenseType getExpenseType(String expenseTypeId);

	List<ExpenseType> getAll();

	ExpenseType updateExpenseType(ExpenseType expenseType);

	List<ExpenseType> getAll(ExpenseTypeContext context);

}
