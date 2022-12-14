package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.repositories.ScheduleRepository;
import com.udacity.jdnd.course3.critter.services.base.DefaultScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScheduleService implements DefaultScheduleService {

    private ScheduleRepository scheduleRepository;
    private PetRepository petRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getAllSchedulesForPet(long petId) {
        Pet pet = petRepository.getOne(petId);
        return scheduleRepository.findAllByPetsContains(pet);
    }

    public List<Schedule> getAllSchedulesForEmployee(long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        return scheduleRepository.findAllByEmployeesContains(employee);
    }

    public List<Schedule> getAllSchedulesForCustomer(long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        return  scheduleRepository.findAllByPetsIn(customer.getPets());
    }

    public Schedule saveSchedule(Schedule schedule, List<Long> employeeIds, List<Long> petIds) {
        List<Employee> employees = employeeRepository.findAllById(employeeIds);
        List<Pet> pets = petRepository.findAllById(petIds);
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        return scheduleRepository.save(schedule);
    }
}
