package log.util;

import java.io.IOException;
import log.util.threads.FileThreadWriter;

public class FileLogger extends AbstractLogger{

	private String fileName;
	private boolean debug;
	private String className;

	public FileLogger(String fileName,String className) {
		this.fileName=fileName;
		this.className=className;
	}

	public FileLogger(String fileName, String className,boolean debug) {
		this.debug=debug;
		this.className=className;
	}

	@Override
	protected void logInfo(String str) throws IOException{
		FileThreadWriter threadWriter=new FileThreadWriter(fileName,className,str,"INFO");
		executorService.submit(threadWriter);
		if(nextLogger!=null) {
			nextLogger.logInfo(str);
		}
		
	}

	@Override
	protected void logDebug(String str) throws IOException{
		if(debug) {
			FileThreadWriter threadWriter=new FileThreadWriter(fileName,className,str,"INFO");
			executorService.submit(threadWriter);
			if(nextLogger!=null) {
				nextLogger.logDebug(str);
			}
		}
	}
	@Override
	protected void logError(String str) throws IOException{
		FileThreadWriter threadWriter=new FileThreadWriter(fileName,className,str,"INFO");
		executorService.submit(threadWriter);
		if(nextLogger!=null) {
			nextLogger.logError(str);
		}
	}
}
