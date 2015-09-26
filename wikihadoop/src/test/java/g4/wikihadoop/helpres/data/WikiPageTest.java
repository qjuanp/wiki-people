package g4.wikihadoop.helpres.data;

import g4.wikihadoop.helpers.data.WikiPage;
import junit.framework.TestCase;

public class WikiPageTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetTitleOk() {
		// Given
		String page = "  <page>    <title>Wikipedia:Albert Stern</title>    <ns>4</ns>    <id>44460678</id>    <redirect title=\"Albert Stern (violinist)\" />    <revision>      <id>637925956</id>      <parentid>636200467</parentid>      <timestamp>2014-12-13T17:00:05Z</timestamp>      <contributor>        <username>Xqbot</username>        <id>8066546</id>      </contributor>      <minor/>      <comment>Bot: Fixing double redirect to [[Albert Stern (violinist)]]</comment>      <model>wikitext</model>      <format>text/x-wiki</format>      <text xml:space=\"preserve\" bytes=\"54\">#REDIRECT [[Albert Stern (violinist)]]{{R from move}}</text>      <sha1>ovzb05ggcvuuvsw04aa605ydmpxw7yc</sha1>    </revision>  </page>";
		
		// When
		String title = WikiPage.getTitle(page);
		
		// Then
		assertTrue(title!=null && !title.isEmpty());
		assertEquals("Wikipedia:Albert Stern", title);
	}
	
	public void testNotTitle() {
		// Given
		String page = "  <page>       <ns>4</ns>    <id>44460678</id>    <redirect title=\"Albert Stern (violinist)\" />    <revision>      <id>637925956</id>      <parentid>636200467</parentid>      <timestamp>2014-12-13T17:00:05Z</timestamp>      <contributor>        <username>Xqbot</username>        <id>8066546</id>      </contributor>      <minor/>      <comment>Bot: Fixing double redirect to [[Albert Stern (violinist)]]</comment>      <model>wikitext</model>      <format>text/x-wiki</format>      <text xml:space=\"preserve\" bytes=\"54\">#REDIRECT [[Albert Stern (violinist)]]{{R from move}}</text>      <sha1>ovzb05ggcvuuvsw04aa605ydmpxw7yc</sha1>    </revision>  </page>";
		
		// When
		String title = WikiPage.getTitle(page);
		
		// Then
		assertNull(title);
	}
}
