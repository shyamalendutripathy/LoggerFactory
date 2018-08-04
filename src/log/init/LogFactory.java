package log.init;

import log.util.AbstractLogger;
import log.util.ConsoleLogger;
import log.util.FileLogger;

public class LogFactory {
	
	public static AbstractLogger LogImpl(String className) {
		
//		Read Conf files to get to the log directory.
//		AbstratFactory.
		
		AbstractLogger log=new FileLogger("log.txt",className);
		AbstractLogger consoleLog=new ConsoleLogger(false);
		log.setNextLogger(consoleLog);
		return log;
	}
}
