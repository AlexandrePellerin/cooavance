import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MissionTest {

	private Mission miss;

	@Before
	public void setUp() {
		miss = new Mission(23, 8, 24, 17, 500);
	}

	@Test
	public void testMissionFull1() {
		try {
			new Mission(45, 2, 2, 2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Jour de depart errone");
		}
	}

	@Test
	public void testMissionFull2() {
		try {
			new Mission(2, 2, 1, 2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Jour de retour errone");
		}
	}

	@Test
	public void testMissionFull3() {
		try {
			new Mission(2, 45, 5, 2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Heure de depart erronee");
		}
	}

	@Test
	public void testMissionFull4() {
		try {
			new Mission(2, 2, 2, -2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Heure de retour erronee");
		}
	}

	@Test
	public void testMissionFull5() {
		try {
			new Mission(2, 2, 3, -2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Heure de retour erronee");
		}
		try {
			new Mission(2, 2, 2, 2, 2);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Heure de retour erronee");
		}
	}

	@Test
	public void testMissionFull6() {
		try {
			new Mission(2, 2, 2, 5, -2);
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Nombre de kilometres parcourus errone");
		}
	}

	@Test
	public void testMissionValide() {
		try {
			new Mission(2, 2, 2, 2, 2);
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			assertFalse(false);
		}
	}

	@Test
	public void testNbHebAvant5() {
		miss.hDep = 4;
		assertEquals(2, miss.nbHeb());
	}
	
	@Test
	public void testNbHebApres5() {
		assertEquals(1, miss.nbHeb());
	}
	
	@Test
	public void testMemeJourDepMatinRetAprem() {
		miss.jRet = 23;
		assertEquals(1, miss.nbRepas());
	}
	
	@Test
	public void testMemeJourDepApremRetourSoir() {
		miss = new Mission(23, 16, 23, 20, 400);
		assertEquals(1, miss.nbRepas());
		miss.hDep = 19;
		assertEquals(1, miss.nbRepas());
	}
	
	@Test
	public void testDiffJourDepMatinRetourMatin(){
		miss = new Mission(23, 8, 25, 10, 400);
		assertEquals(4, miss.nbRepas());
	}
	
	@Test
	public void testDiffJourDepApremRetourAprem(){
		miss = new Mission(23, 16, 25, 15, 400);
		assertEquals(4, miss.nbRepas());
	}
	
	@Test
	public void testDiffJourDepMatinRetourSoir(){
		miss = new Mission(23, 22, 25, 23, 400);
		assertEquals(4, miss.nbRepas());
	}
	
	@Test
	public void testFraiMiss() {
		assertEquals(miss.nbHeb() * 60 + miss.nbRepas() * 15 + miss.nbKm, miss.fraisMiss());
	}
}
