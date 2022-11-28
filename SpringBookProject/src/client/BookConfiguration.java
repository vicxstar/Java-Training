package client;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import persistence.BookDaoImpl;
//import presentation.BookPresentationImpl;
//import service.BookServiceImpl;

/**
 *
 * @author vic
 * date: 10/11/2022
 * purpose: Step 11. The CONFIGURATION  (springContainer)
 *
 */

//annotate the file to indicate that this class has the '@Bean' definition method:
@Configuration

//specify the packages that we want to be scanned:
//if no base package, give names of each package (in array form):
@ComponentScan(basePackages = {"persistence", "presentation", "service"})
public class BookConfiguration {
}
