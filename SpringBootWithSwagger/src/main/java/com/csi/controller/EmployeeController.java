package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public String signup(@RequestBody Employee employee)
    {
        employeeService.signUp(employee);
        return "Signup Done";
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
            public boolean signIn(@PathVariable String empEmailId,@PathVariable String empPassword)
    {
return employeeService.signIn(empEmailId,empPassword);
    }
}
