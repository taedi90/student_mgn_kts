package student_mgn_taedi.util;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() {
		System.out.println("testGetConnection()");
		Connection con = JdbcUtil.getConnection();
		Assert.assertNotNull(con);
		System.out.println("con is == " + con);
	}

}
