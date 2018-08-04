package log.util.threads;

import java.io.IOException;
import java.util.concurrent.Callable;

import log.init.WriteFile;

public class FileThreadWriter implements Callable{
	private String fileName;
	private String msg;
	private String level;
	private String className;
	
	public FileThreadWriter(String fileName, String className, String msg, String level) {
		this.fileName=fileName;
		this.msg=msg;
		this.level=level;
		this.className=className;
	}

	@Override
	public Object call() throws IOException {
		
		WriteFile.writeLog(fileName, className,msg, level);
		return 1;
	}

}
