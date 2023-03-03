package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        Employee employee = service.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

            Employee newEmployee = service.addEmployee(employee);

            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(Employee employee) {
        Employee updateEmployee = service.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") Long id) {
        service.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("User deleted",true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
