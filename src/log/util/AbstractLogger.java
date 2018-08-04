package log.util;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractLogger {
	protected ExecutorService executorService = Executors.newFixedThreadPool(20);
	protected AbstractLogger nextLogger;
	
	protected void logInfo(String str) throws IOException{};
	protected void logDebug(String str) throws IOException{};
	protected void logError(String str) throws IOException{}
	public ExecutorService getExecutorService() {
		return executorService;
	}
	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}
	
	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger=nextLogger;
	}
}
