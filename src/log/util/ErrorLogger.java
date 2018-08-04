package log.util;

import java.io.IOException;

public class ErrorLogger extends AbstractLogger{

	private boolean debug;

	public ErrorLogger(boolean debug) {
		this.debug=debug;
	}

	@Override
	protected void logInfo(String str) throws IOException{
		System.err.println("INFO" +str);
	}

	@Override
	protected void logDebug(String str) throws IOException{
		if(debug) {
			System.err.println("INFO" +str);
		}
	}
	@Override
	protected void logError(String str) throws IOException{
		System.err.println("ERROR" +str);
	}
}
