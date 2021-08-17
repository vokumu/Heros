import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Squad.clearAllSquad(); //clear out all the posts before each test.
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad(2,"abc","Intro");
        assertEquals(true, squad instanceof Squad);
    }
    @Test
    public void SquadInstantiatesWithMaxSize_true() throws Exception {
        Squad squad = new Squad(2,"abc","Day 1: Intro");
        assertEquals(2, squad.getMaxSize());

    }
    @Test
    public void SquadInstantiatesWithName_true() throws Exception {
        Squad squad = new Squad(2,"abc","Intro");
        assertEquals("abc", squad.getName());

    }

    @Test
    public void SquadInstantiatesWithFightingCause_true() throws Exception {
        Squad squad = new Squad(2,"abc","Intro");
        assertEquals("Intro", squad.getFightingCause());

    }

    @Test
    public void AllSqaudAreCorrectlyReturned_true() {
        Squad squad = new Squad(2,"abc","Intro");
        Squad otherSquad = new Squad(3,"xyz","Easting");
        assertEquals(2, Squad.getAll().size());
    }

    @Test
    public void AllSquadsContainsAllPosts_true() {
        Squad squad = new Squad(2,"abc","Intro");
        Squad otherSquad = new Squad(3,"xyz","Easting");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(otherSquad));
    }
    public void getId_SquadInstantiateWithAnID_1() throws Exception{
        Squad.clearAllSquad();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        assertEquals(1, testSquad.getId());
    }
    @Test
    public void findReturnsCorrectPost() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        assertEquals(1, Squad.findById(testSquad.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOneSquadExists() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        assertEquals(1, Squad.findById(testSquad.getId()).getId());
    }
}