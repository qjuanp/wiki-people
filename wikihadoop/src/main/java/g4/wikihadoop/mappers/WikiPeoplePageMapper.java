package g4.wikihadoop.mappers;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import g4.wikihadoop.helpers.data.Metadata;
import g4.wikihadoop.helpers.data.WikiPage;

public class WikiPeoplePageMapper
	   extends Mapper<Text,Text,Text,Text>{
	
	@Override
	protected void map(Text key, Text value, Context context)
			throws IOException, InterruptedException {
		System.out.printf("Key: %s", key.toString());
		System.out.printf("Value: %s", value.toString());
		
		String content = value.toString();
		
		Metadata metadata = new Metadata(content);
		
		if(metadata.hasMetadataParameter("birth_date")){
			String fullName = WikiPage.getTitle(content);
			
			if(fullName!=null)
				context.write(new Text(fullName), value);
		}
	}
}