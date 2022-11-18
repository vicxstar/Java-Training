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
@ComponentScan(basePackages = {"client", "database", "entity", "persistence", "presentation", "service"})
public class BookConfiguration {

//	//import the '@Bean' annotation method:
//	@Bean(name = "dao")
//	//the instantiation of the 'Dao' object:
//	//import 'BookDaoImpl':
//	public BookDaoImpl getPersistence() {
//		return new BookDaoImpl();
//	}
//	
//	@Bean(name = "service")
//	//import 'BookServiceImpl':
//	public BookServiceImpl getBookService() {
//		//the constructor Injection (generate constructor method in ServiceImpl class):
//		return new BookServiceImpl(getPersistence());
//	}
//	
//	@Bean(name = "bkPresentation")
//		//import 'BookPresentationImpl':
//	public BookPresentationImpl getBookPresentation() {
//		//the Setter Injection (generate setter method in PresentationImpl class):
//		//instantiate a new 'BookPresentationImpl' object:
//		BookPresentationImpl presentation = new BookPresentationImpl();
//		presentation.setBookService(getBookService());
//		return presentation;
//	}

}
