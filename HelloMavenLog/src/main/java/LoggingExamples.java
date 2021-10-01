import org.apache.log4j.Logger;

public class LoggingExamples {

	final static Logger log = Logger.getLogger(LoggingExamples.class);
	
	public static void main(String[] args) {
		
		System.out.println("regular sysout without log4j");
		log.trace("trace message - very fine-grained");
		log.debug("this statement should be useful for debugging the application");
		log.info("informational message use this level of logging");
		log.warn("something bad potentially could happen");
		log.error("something went wrong");
		log.fatal("something very bad happened");
	}

}
