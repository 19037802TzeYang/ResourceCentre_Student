import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		// Test if Item list is not null, so item can be added
		assertNotNull("Test if Item list is not null but empty", chromebookList);
		assertEquals("Test if empty", 0, chromebookList.size());
		
		// Test if output retrieved is empty
		String allChromebooks = ResourceCentre.retrieveAllChromebook(chromebookList);
		assertEquals("Test if chromebook empty", "", allChromebooks);
		
		// Given empty list, after adding 2 items, list size should be 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		
		assertEquals("Test list size equals 2", 2, chromebookList.size());
		
		// Test if expected output string is equal to the one retrieved from SourceCentre
		allChromebooks = ResourceCentre.retrieveAllChromebook(chromebookList);

		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebooks);
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here 
		String tag="CC0011";
		String dueDate="22-7-2020"; //Date-Month-Year
		ArrayList<Camcorder> camcorderList2=new ArrayList<Camcorder>();
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		camcorderList2.add(cc1);
		camcorderList2.add(cc2);
		//Test case 1 returns True
		boolean actualOutput1=ResourceCentre.doLoanCamcorder(camcorderList2, tag, dueDate);
		boolean expectedOutput1=true;
		assertEquals(expectedOutput1,actualOutput1);

		//Test case 2 returns False
		boolean actualOutput2=ResourceCentre.doLoanCamcorder(camcorderList2, tag, dueDate);
		boolean expectedOutput2=false;
		assertEquals(expectedOutput2,actualOutput2); 
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		String tag="CB0011";
		String dueDate="22-7-2020"; //Date-Month-Year
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");
		ArrayList<Chromebook> chromebookList2=new ArrayList<Chromebook>();
		chromebookList2.add(cb1);
		chromebookList2.add(cb2);
		//Test case 1 returns True
		boolean actualOutput1=ResourceCentre.doLoanChromebook(chromebookList2, tag, dueDate);
		boolean expectedOutput1=true;
		assertEquals(expectedOutput1,actualOutput1);

		//Test case 2 returns False
		boolean actualOutput2=ResourceCentre.doLoanChromebook(chromebookList2, tag, dueDate);
		boolean expectedOutput2=false;
		assertEquals(expectedOutput2,actualOutput2);
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}


