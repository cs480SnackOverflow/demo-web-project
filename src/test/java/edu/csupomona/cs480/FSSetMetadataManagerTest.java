package edu.csupomona.cs480;

import edu.csupomona.cs480.data.entity.SetMetadata;
import edu.csupomona.cs480.data.provider.FSFlashCardSetManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FSSetMetadataManagerTest {

	private FSFlashCardSetManager fs = new FSFlashCardSetManager();

	@Test
	public void testFlashCardSetManagerCreationAndGet(){
		SetMetadata f = new SetMetadata();
		f.setName("Test");
		f.setSetId("Test ID 1");
		f.setUserId("Test User");
		fs.updateFlashCardSet(f);
		SetMetadata get = fs.getFlashCardSet("Test ID 1");
		assertEquals(f.getName(), get.getName());
		assertEquals(f.getSetId(), get.getSetId());
		assertEquals(f.getUserId(), get.getUserId());
	}

	@Test
	public void testSerializationAndDeserialization(){
		SetMetadata f = new SetMetadata();
		f.setName("Test");
		f.setSetId("Test ID 1");
		f.setUserId("Test User");
		String s = fs.serializeJSON(f);
		SetMetadata get = fs.parseJSON(s);
		assertEquals(f.getName(), get.getName());
		assertEquals(f.getSetId(), get.getSetId());
		assertEquals(f.getUserId(), get.getUserId());
	}

	@Test
	public void testDeletion(){
		SetMetadata f1 = fs.getFlashCardSet("Test ID 1");
		fs.deleteFlashCardSet("Test ID 1");
		SetMetadata f2 = fs.getFlashCardSet("Test ID 1");
		assertNotNull(f1);
		assertNull(f2);
	}

}
