package com.udacity.jdnd.course3.critter.services.base;

import com.udacity.jdnd.course3.critter.entities.Schedule;

import java.util.List;

public interface DefaultScheduleService {
    List<Schedule> getAllSchedules();
    List<Schedule> getAllSchedulesForPet(long petId);
    List<Schedule> getAllSchedulesForEmployee(long employeeId);
    List<Schedule> getAllSchedulesForCustomer(long customerId);
    Schedule saveSchedule(Schedule schedule, List<Long> employeeIds, List<Long> petIds);
}
