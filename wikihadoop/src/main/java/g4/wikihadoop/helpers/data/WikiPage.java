package g4.wikihadoop.helpers.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WikiPage {
	
	public static final Pattern TITLE_PATTERN = Pattern.compile("<title>(.*)</title>");
	
	public static String getTitle(String content){
		String title = null;
		
		Matcher titleMatcher = TITLE_PATTERN.matcher(content);
		
		if(titleMatcher.find()){
			title = titleMatcher.group(1);
		}
		
		return title;
	}
}
