package com.udacity.jdnd.course3.critter.services.base;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface DefaultEmployeeService {
    Employee getEmployeeById(long employeeId);
    List<Employee> getEmployeesForService(LocalDate date, Set<EmployeeSkill> skills);
    Employee saveEmployee(Employee employee);
    void setEmployeeAvailability(Set<DayOfWeek> daysAvailable, long employeeId);
}
