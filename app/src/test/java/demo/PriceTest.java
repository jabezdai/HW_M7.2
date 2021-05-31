package swimpool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceTest {
	Price people;

	@BeforeEach
	void setUp() throws Exception {
		people = new Price();
	}
//swimprice(int member,int week,String time,int group,int age)
	@Test
	void testSwimprice01() throws Exception {
		assertEquals(100,people.swimprice(1, 1, "08:00", 0, 50));
	}
	@Test
	void testSwimprice02() throws Exception {
		assertEquals(200,people.swimprice(0, 1, "08:00", 0, 50));
	}
	@Test
	void testSwimprice03() throws Exception {
		assertEquals(160,people.swimprice(0, 1, "06:59", 0, 50));
	}
	@Test
	void testSwimprice04() throws Exception {
		assertEquals(160,people.swimprice(0, 1, "08:00", 0, 12));
	}
	@Test
	void testSwimprice05() throws Exception {
		assertEquals(160,people.swimprice(0, 1, "08:00", 0, 60));
	}
	@Test
	void testSwimprice06() throws Exception {
		assertEquals(125,people.swimprice(1, 6, "08:00", 0, 55));
	}
	@Test
	void testSwimprice07() throws Exception {
		assertEquals(250,people.swimprice(0, 6, "08:00", 0, 55));
	}
	@Test
	void testSwimprice08() throws Exception {
		assertEquals(140,people.swimprice(0, 1, "08:00", 1, 50));
	}
	@Test
	void testSwimprice09() throws Exception {
		assertEquals(125,people.swimprice(1, 7, "08:00", 0, 55));
	}
	@Test
	void testFindtype10() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 8, "08:00", 0, 55),
		""
		);
	}
	@Test
	void testFindtype11() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 0, "08:00", 0, 55),
		""
		);
	}
	@Test
	void testFindtype12() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 5, "08:00", 0, 2),
		""
		);
	}
	@Test
	void testFindtype13() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 5, "08:00", 0, 90),
		""
		);
	}
	@Test
	void testFindtype14() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 5, "03:00", 0, 55),
		""
		);
	}
	@Test
	void testFindtype15() {
		assertThrows(
		Exception.class,
		() -> 	people.swimprice(1, 5, "23:00", 0, 55),
		""
		);
	}
	@Test
	void testSwimprice16() throws Exception {
		String[] time = {"A"} ;
		assertThrows(
		Exception.class,
		() -> 	people.racingprice(0, 10, time),
		""
		);
	}
	@Test
	void testSwimprice17() throws Exception {
		String[] time = {"A","A"} ;
		assertThrows(
		Exception.class,
		() -> 	people.racingprice(1, 10, time),
		""
		);
	}
	@Test
	void testSwimprice18() throws Exception {
		String[] time = {"A","F"} ;
		assertThrows(
		Exception.class,
		() -> 	people.racingprice(1, 10, time),
		""
		);
	}
	@Test
	void testSwimprice19() throws Exception {
		String[] time = {"A","B","C","D","E"} ;
		assertEquals(30000,people.racingprice(1, 1, time));
	}
	@Test
	void testSwimprice20() throws Exception {
		String[] time = {"A","B","C","D","E"} ;
		assertEquals(4100,people.racingprice(1, 10, time));
	}
}
