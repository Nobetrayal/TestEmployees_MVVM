package ru.msnetworks.testemployees.screens.employees;

import java.util.List;

import ru.msnetworks.testemployees.pojo.Employee;

public interface EmployeesListView {

    void showData(List<Employee> employees);

    void showError(Throwable throwable);


}
