package g4.wikihadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

import g4.wikihadoop.job.SearchPeopleJob;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {
    	System.setProperty("hadoop.home.dir", "C:\\qlab-dev\\bigdata\\taller2\\WikiHadoop\\wikihadoop\\");
        int res = ToolRunner.run(new Configuration(),new SearchPeopleJob(),args);
        System.exit(res);
    }
}