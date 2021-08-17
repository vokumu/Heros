import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHero(); //clear out all the posts before each test.
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(true, hero instanceof Hero);
    }
    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals("victoria", hero.getName());
    }
    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(22, hero.getAge());
    }
    @Test
    public void heroInstantiatesWithSpecialPowers_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals("eating", hero.getSpecialPower());
    }
    @Test
    public void heroInstantiatesWithWeakness_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals("sleeping", hero.getWeakness());
    }
    @Test
    public void heroInstantiatesWithSquad_true() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(testSquad, hero.getMsquad());
    }
    @Test
    public void AllHeroAreCorrectlyReturned_true() {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        Hero otherHero = new Hero("atieno",3,"running","talking",testSquad);
        assertEquals(2, hero.getAll().size());
    }

    @Test
    public void AllHerosContainsAllPosts_true() {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        Hero otherHero = new Hero("atieno",3,"running","talking",testSquad);
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }
    @Test
    public void getId_HerosInstantiateWithAnID_1() throws Exception{
        Hero.clearAllHero();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(1, hero.getId());
    }
    @Test
    public void findReturnsCorrectPost() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Squad testSquad=new Squad(3,"pingPong","wierdness");
        Hero hero = new Hero("victoria",22,"eating","sleeping",testSquad);
        Hero otherHero = new Hero("victoria",22,"eating","sleeping",testSquad);
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

}