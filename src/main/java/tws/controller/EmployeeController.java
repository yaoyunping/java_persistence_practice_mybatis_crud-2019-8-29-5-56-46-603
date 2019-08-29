package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee>selectById(@PathVariable String id){
    	Employee employee = employeeMapper.selectById(id);
    	return ResponseEnity.ok(employee);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateById(
    		@PathVariable String id,
    		@RequestBody Employee employee
    		){
    	employeeMapper.updateById(id,employee);
    	return ResponseEnity.ok(employee);
    }
    
    
    @PostMapping("")
    public ResponseEntity<Employee>insert(@RequestBody Employee employee){
    	String id = UUID.randomUUID().toString();
    			employee.setId(id);
    	employeeMapper.insert(employee);
    	return ResponseEntity.created(URI.create("/employees"+id)).build();
    }
    
    

}
