package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tws.dto.employeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeesService {
	
	@Autowired
    private EmployeeMapper employeeMapper;
	
	public ResponseEntity<List<Employee>> getAll(
	    	@RequestParam(required = false) int page,
	    	@RequestParam(required = false) int pageSize
	    	){
	        return ResponseEntity.ok(employeeMapper.selectAll(page,pageSize));
	    }
	
	public ResponseEntity<employeeDto>selectById(@PathVariable String id){
    	Employee employee = employeeMapper.selectById(id);
    	employeeDto employeeDto = new employeeDto();
    	employeeDto.setId(employee.getId());
    	employeeDto.setName(employee.getName());
    	employeeDto.setAge(employee.getAge());
    	
    	String desc = String.format("name:%s,"name:%s","
    			employee.getName(),
    			employee.getAge(),
    			);
    	employeeDto.setDesc(desc);
    	return ResponseEnity.ok(employeeDto);
    }
}
