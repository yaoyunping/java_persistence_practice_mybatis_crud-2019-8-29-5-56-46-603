package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;

@RunWith(SpringRunner.class)
@MybatisTest

public class EmployeeMapperTest {
	
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@After
	public void teardown() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
	}
	@Test
    public void shouldFetchList() {
    	//given
    	jdbcTemplate.execute("insert into employee values('1','zhangsan','22')");
    	//when
    	List<Employee>employees=employeeMapper.selectAll();
    	//then
    	assertEquals(1, employees.size());
    	assertEquals("zhagnsan", employees.get(0).getName());
    }
	
	@Test
    public void shouldSaveList() {
    	//given
    	jdbcTemplate.execute("insert into employee values('1','zhangsan','22')");
    	//when
    	List<Employee>employees=employeeMapper.selectAll();
    	int numbers = 
    	//then
    	
    	assertEquals(1, employees.size());
    	assertEquals("zhagnsan", employees.get(0).getName());
    }
	
}
