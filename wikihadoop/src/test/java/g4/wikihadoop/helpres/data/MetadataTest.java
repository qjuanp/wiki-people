package g4.wikihadoop.helpres.data;

import java.util.HashMap;

import g4.wikihadoop.helpers.data.Metadata;
import junit.framework.TestCase;

public class MetadataTest extends TestCase {

	private final String EXAMPLE_TEXT = "<text xml:space=\"preserve\" bytes=\"37597\">(Acting)}} |office2 = [[Ministry of Finance and Public Credit (Colombia)|Minister of Finance and Public Credit]] |president2 = [[Andrés Pastrana Arango]] |term_start2 = 7 August 2000 |term_end2 = 7 August 2002 |predecessor2 = [[Juan Camilo Restrepo Salazar]] |successor2 = Roberto Junguito Bonnet |office3 = [[Ministry of Foreign Trade (Colombia)|Minister of Foreign Trade]] |president3 = [[César Gaviria]] |term_start3 = 18 November 1991 |term_end3 = 7 August 1994 |predecessor3 = Position established |successor3 = Daniel Mazuera Gómez |birth_name = Juan Manuel Santos Calderón |birth_date = {{birth date and age|1951|8|10|df=y}} |birth_place = [[Bogotá]], [[Colombia]] |death_date = |death_place = |party = [[Colombian Liberal Party|Liberal Party]] {{small|(Before 2005)}}<br>[[Social Party of National Unity]] {{small|(2005–present)}} |spouse = Silvia Amaya Londoño {{small|(Divorced)}}<br>[[María Clemencia Rodríguez Múnera]] {{small|(1987–present)}} |children = Martín<br>María Antonia<br>Esteban |residence = [[Casa de Nariño]] |alma_mater = [[University of Kansas|University of Kansas, Lawrence]]<br>[[London School of Economics]]<br>[[John F. Kennedy School of Government|Harvard University]] |religion = [[Catholic Church|Roman Catholicism]] |signature = Juan Manuel Santos Signature.svg }} '''Juan Manuel Santos Calderón''' ({{IPA-es|xwan maˈnwel ˈsantos kaldeˈɾon|lang}}; born 10 August 1951) is the [[List of Presidents of Colombia|32nd]] and current [[President of Colombia]], in office since 2010. He was [[Ministry of National Defence (Colombia)|Minister of Defence]] from 2006 to 2009. An economist by profession and a journalist by trade, Santos is a member of the wealthy and influential Santos family, who from 1913 to 2007 were the [[majority shareholder]]s of</text>";
	private HashMap<String,String> testHashMap;
	
	protected void setUp() throws Exception {
		testHashMap = new HashMap<String, String>();
		testHashMap.put("office2","[[Ministry of Finance and Public Credit (Colombia)|Minister of Finance and Public Credit]]");
		testHashMap.put("president2","[[Andrés Pastrana Arango]]");
		testHashMap.put("term_start2","7 August 2000");
		testHashMap.put("term_end2","7 August 2002");
		testHashMap.put("predecessor2","[[Juan Camilo Restrepo Salazar]]");
		testHashMap.put("successor2","Roberto Junguito Bonnet");
		testHashMap.put("office3","[[Ministry of Foreign Trade (Colombia)|Minister of Foreign Trade]]");
		testHashMap.put("president3","[[César Gaviria]]");
		testHashMap.put("term_start3","18 November 1991");
		testHashMap.put("term_end3","7 August 1994");
		testHashMap.put("predecessor3","Position established");
		testHashMap.put("successor3","Daniel Mazuera Gómez");
		testHashMap.put("birth_name","Juan Manuel Santos Calderón");
		testHashMap.put("birth_date","{{birth date and age|1951|8|10|df=y}}");
		testHashMap.put("birth_place","[[Bogotá]], [[Colombia]]");
		testHashMap.put("party","[[Colombian Liberal Party|Liberal Party]] {{small|(Before 2005)}}<br>[[Social Party of National Unity]] {{small|(2005–present)}}");
		testHashMap.put("spouse","Silvia Amaya Londoño {{small|(Divorced)}}<br>[[María Clemencia Rodríguez Múnera]] {{small|(1987–present)}}");
		testHashMap.put("children","Martín<br>María Antonia<br>Esteban");
		testHashMap.put("residence","[[Casa de Nariño]]");
		testHashMap.put("alma_mater","[[University of Kansas|University of Kansas, Lawrence]]<br>[[London School of Economics]]<br>[[John F. Kennedy School of Government|Harvard University]]");
		testHashMap.put("religion","[[Catholic Church|Roman Catholicism]]");
		testHashMap.put("signature","Juan Manuel Santos Signature.svg }");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHasMetadataParameterBirthDateTrue() {
		// Given
		Metadata metadata = new Metadata(EXAMPLE_TEXT);
		// When & Then
		assertTrue(metadata.hasMetadataParameter("birth_date"));
	}
	
	public void testHasMetadataParameterDeathDateFalse() {
		// Given
		Metadata metadata = new Metadata(EXAMPLE_TEXT);
		// When & Then
		assertFalse(metadata.hasMetadataParameter("death_date"));
	}

	public void testGetAllMetadata() {
		// Given
		Metadata metadata = new Metadata(EXAMPLE_TEXT);
		
		// When
		HashMap<String,String> metadataValues = metadata.getAllMetadata();
		
		// Then
		for(String key:metadataValues.keySet()){
			System.out.printf("IsInTestKey %s | Key %s \nTestValue %s\nValue %s\n---------------------\n", 
					testHashMap.containsKey(key),
					key,
					testHashMap.get(key),
					metadataValues.get(key));
			assertTrue(testHashMap.containsKey(key));
			assertEquals(testHashMap.get(key), metadataValues.get(key));
		}
	}

}
