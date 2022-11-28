package Client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author vic
 * date: 23/11/2022
 * purpose: Step 11. The CONFIGURATION  (SERVICE LAYER - springContainer)
 *
 */
//annotate the file to indicate that this class has the '@Bean' definition method:
@Configuration

//specify the packages that we want to be scanned:
//if no base package, give names of each package (in array form):
@ComponentScan(basePackages = {"persistence", "presentation", "service"})
public class EmployeeConfiguration {

	@Bean(name = "MySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		//instantiate the JDBC interface to return a new connection:
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		//Register Driver:
		//get driver address from MySQL WorkBench
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		//connect to the Database:
		//add the 'JBDC connection string', followed by the database name:
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/WileyDI001");
		
		//add the database username:
		ds.setUsername("root");
		
		//add the database password:
		ds.setPassword("fiveteen");
		
		//return the connection:
		return ds;
	} 
	
	@Bean
	public JdbcTemplate geTemplate() {
		//construct a new 'JdbcTemplate'to obtain connections from:
		return new JdbcTemplate(getDataSource());
	}
}
