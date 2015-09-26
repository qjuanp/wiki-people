package g4.wikihadoop.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

import g4.wikihadoop.helpers.fileSystem.FileSystemConfiguration;
import g4.wikihadoop.mappers.WikiPeoplePageMapper;
import g4.wikihadoop.reducers.PeoplePageReducer;

public class SearchPeopleJob extends Configured implements Tool 
{
	private static final String JOB_NAME ="Search People on Wikipedia";

	public int run(String[] arg0) throws Exception {
		Configuration configuration = getConf();
		FileSystemConfiguration.setConfiguration(configuration);
		
		Job job = Job.getInstance(configuration, JOB_NAME);

		/// Input configuration
		FileInputFormat.addInputPath(job, new Path("input"));

		/**
		 *  Mappers and reducers configuration		
		 */
		// Mappers
		job.setMapperClass(WikiPeoplePageMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		// Reducers
		job.setReducerClass(PeoplePageReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		/// Output configuration
		FileOutputFormat.setOutputPath(job, new Path("output"));

		job.waitForCompletion(true);
		return 0;
	}

}
