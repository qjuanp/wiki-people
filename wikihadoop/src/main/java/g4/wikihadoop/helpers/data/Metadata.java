package g4.wikihadoop.helpers.data;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metadata {

	private final Pattern METADATA_PATTERN = Pattern.compile("\\|\\w+.*\\|.* }",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	private final String KEYS = "\\|\\w+ =";
	private final Pattern METADATA_KEYS_PATTERN = Pattern.compile("\\|(\\w+) =",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	private String _content;

	public Metadata(String content){
		_content = content;
	}
	
	public boolean hasMetadataParameter(String paramenter){
		HashMap<String,String> metadata = getAllMetadata();
		
		return metadata.containsKey(paramenter);
	}
	
	public HashMap<String,String> getAllMetadata(){
		HashMap<String,String> metadata = new HashMap<String, String>();
		
		Matcher metadataMatcher = METADATA_PATTERN.matcher(_content);
		if(metadataMatcher.find()) {
			String metadataFullString = metadataMatcher.group(0);
			Matcher metadataKeysMatcher = METADATA_KEYS_PATTERN.matcher(metadataFullString);
			if(metadataKeysMatcher.find()){
				String[] metadataValues = metadataFullString.split(KEYS);
				
				for (int startPoint = 0, index = 0; 
					 metadataKeysMatcher.find(startPoint); 
					 startPoint = metadataKeysMatcher.end(), index++){
					System.out.println(" Key found at " + metadataKeysMatcher.start(1) + " with value [" + metadataKeysMatcher.group(1) + "]");
					
					if((index+1)<metadataValues.length){
						String metadataValue =  metadataValues[index +1];
						if(metadataValue!=null && !metadataValue.trim().isEmpty()){
							System.out.println("Value found: " + metadataValue);
							metadata.put(metadataKeysMatcher.group(1),metadataValue.trim());
						}
					}
				}
			}
		}
		
		return metadata;
	}
	
}
