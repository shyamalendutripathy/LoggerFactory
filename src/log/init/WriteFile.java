package log.init;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// This class can be made singleton.
public class WriteFile {

	private static Lock lock = new ReentrantLock();


	public static void writeLog(String fileName, String className,String data,String level) throws IOException {
		StringBuilder builder=new StringBuilder(data);
		builder.append(level);
		builder.append("\t");
		builder.append(className);
		builder.append("\n");

		try {
			if(lock.tryLock(2, TimeUnit.SECONDS)){
				Files.write(Paths.get(fileName), builder.toString().getBytes(),StandardOpenOption.APPEND);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}