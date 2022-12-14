package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.services.base.DefaultEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeService implements DefaultEmployeeService {
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.getOne(employeeId);
    }
    public List<Employee> getEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        List<Employee> employees = employeeRepository
                .findAllByDaysAvailableContains(date.getDayOfWeek()).stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
        return employees;
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public void setEmployeeAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }
}
