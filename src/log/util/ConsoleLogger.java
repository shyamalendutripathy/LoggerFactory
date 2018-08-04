package log.util;

import java.io.IOException;

public class ConsoleLogger extends AbstractLogger{

	private boolean debug;

	public ConsoleLogger(boolean debug) {
		this.debug=debug;
	}

	@Override
	protected void logInfo(String str) throws IOException{
		System.out.println("INFO" +str);
	}

	@Override
	protected void logDebug(String str) throws IOException{
		if(debug) {
			System.out.println("INFO" +str);
		}
	}
	@Override
	protected void logError(String str) throws IOException{
		System.out.println("ERROR" +str);
	}
}
