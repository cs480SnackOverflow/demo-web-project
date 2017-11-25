package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.configuration.RepositoryConfiguration;
import edu.csupomona.cs480.data.entity.Flashcard;

import static org.junit.Assert.*;

import edu.csupomona.cs480.data.entity.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class SetRepositoryTest {
    private SetRepository setRepository;

    @Autowired
    public void setSetRepository(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Test
    public void testSaveSet1() {
        Set set = new Set();
        set.setTitle("Christmas");
        set.setSetId(UUID.randomUUID().toString());
        assertNotNull(set);
        setRepository.save(set);
        assertEquals(setRepository.findByTitle("Christmas").get(0).getSetId(), set.getSetId());
    }

    @Test
    public void testSaveSet2() {
        Set set = new Set();
        set.setTitle("Halloween");
        set.setSetId(UUID.randomUUID().toString());
        assertNotNull(set);
        setRepository.save(set);
        List<Set> actual = setRepository.findByTitle("Halloween");
        assertEquals(actual.get(0).getSetId(), set.getSetId());
    }

    @Test
    public void testSaveSet3() {
        Set set = new Set();
        set.setTitle("Thanksgiving");
        set.setSetId(UUID.randomUUID().toString());
        assertNotNull(set);
        setRepository.save(set);
        List<Set> actual = setRepository.findByTitle("Thanksgiving");
        assertEquals(actual.get(0).getTitle(), set.getTitle());
    }

    @Test
    public void testDeleteSet() {
        Set expectedSet = new Set();
        expectedSet.setSetId(UUID.randomUUID().toString());
        expectedSet.setTitle("Holidays");
        long count = setRepository.count();
        setRepository.save(expectedSet);
        setRepository.delete(expectedSet.getId());
        Set actualSet = setRepository.findOne(expectedSet.getId());
        assertNull(actualSet);
        assertEquals(setRepository.count(), count);
    }

    @Test
    public void testFindByTitle1() {
        Set expectedSet = new Set();
        expectedSet.setSetId(UUID.randomUUID().toString());
        expectedSet.setTitle("Fruit");
        setRepository.save(expectedSet);
        List<Set> actualSet = setRepository.findByTitle(expectedSet.getTitle());
        assertNotNull(actualSet);
    }

    @Test
    public void testFindByTitle2() {
        Set expectedSet = new Set();
        expectedSet.setSetId(UUID.randomUUID().toString());
        expectedSet.setTitle("Vegetables");
        setRepository.save(expectedSet);
        List<Set> actualSet = setRepository.findByTitle(expectedSet.getTitle());
        assertNotNull(actualSet);
        assertEquals(actualSet.get(0).getTitle(), expectedSet.getTitle());
    }

    @Test
    public void testFindBySetId1() {
        Set expectedSet = new Set();
        expectedSet.setSetId(UUID.randomUUID().toString());
        setRepository.save(expectedSet);
        List<Set> actualSet = setRepository.findBySetId(expectedSet.getSetId());
        assertNotNull(actualSet);
    }

    @Test
    public void testFindBySetId2() {
        Set expectedSet = new Set();
        expectedSet.setSetId(UUID.randomUUID().toString());
        setRepository.save(expectedSet);
        List<Set> actualSet = setRepository.findBySetId(expectedSet.getSetId());
        assertNotNull(actualSet);
        assertEquals(actualSet.get(0).getSetId(), expectedSet.getSetId());

    }
}
