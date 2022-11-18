package client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author vic
 * date: 11/11/2022
 * purpose: Step 11b. The SECOND CONFIGURATION  (SERVICE LAYER - springContainer)
 *
 */

//annotate the file to indicate that this class has the '@Bean' definition method:
@Configuration

//specify the packages that we want to be scanned:
//if no base package, give names of each package (in array form):
@ComponentScan(basePackages = {"persistence", "presentation", "service"})
public class StudentConfiguration2 {
	
}
