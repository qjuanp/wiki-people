package g4.wikihadoop.helpers.fileSystem;

import org.apache.hadoop.conf.Configuration;

public final class FileSystemConfiguration {

	public static void setConfiguration(Configuration configuration){
//		configuration.set("fs.default.name", "file:///");
//		configuration.set("mapred.job.tracker", "local");
//		configuration.set("fs.file.impl", "g4.wikihadoop.helpers.fileSystem.WindowsLocalFileSystem");
//		configuration.set("io.serializations","org.apache.hadoop.io.serializer.JavaSerialization,org.apache.hadoop.io.serializer.WritableSerialization");
		
		configuration.set("mapreduce.app-submission.cross-platform", "true");
	}
}
