import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHero(); //clear out all the posts before each test.
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        assertEquals(true, hero instanceof Hero);
    }
    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        assertEquals("victoria", hero.getName());
    }
    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        assertEquals(22, hero.getAge());
    }
    @Test
    public void heroInstantiatesWithSpecialPowers_true() throws Exception {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        assertEquals("eating", hero.getSpecialPower());
    }
    @Test
    public void heroInstantiatesWithWeakness_true() throws Exception {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        assertEquals("sleeping", hero.getWeakness());
    }
    @Test
    public void AllHeroAreCorrectlyReturned_true() {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        Hero otherHero = new Hero("atieno",3,"running","talking");
        assertEquals(2, hero.getAll().size());
    }

    @Test
    public void AllHerosContainsAllPosts_true() {
        Hero hero = new Hero("victoria",22,"eating","sleeping");
        Hero otherHero = new Hero("atieno",3,"running","talking");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

}