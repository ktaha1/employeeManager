package ma.employeemanager.service;

import ma.employeemanager.exception.UserNotFoundException;
import ma.employeemanager.model.Employee;
import ma.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(emp);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()->new UserNotFoundException("User by id "+ id + " was not found"));
    }



}
