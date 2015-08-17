package demos.derby;

import java.sql.*;
import java.util.GregorianCalendar;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DerbyTest {

	private static final String CLOUDSCAPE_DIR = "db";
	private static final String DERBY_JDBC_EMBEDDED_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String CREATE_TABLE_COMMAND = "CREATE TABLE Courses(CourseNum VARCHAR(10) PRIMARY KEY, CourseTitle VARCHAR(30), CourseType VARCHAR(15),StartDate DATE,EndDate DATE)";
	private static final String DROP_TABLE_COMMAND = "DROP TABLE Courses";
	private static final String INSERT_COMMAND = "INSERT INTO Courses (CourseNum, CourseTitle, CourseType, StartDate, EndDate) VALUES (?,?,?,?,?)";
	private static final String UPDATE_COMMAND = "UPDATE Courses SET CourseTitle = ?, CourseType = ? WHERE CourseNum = ?";

	@BeforeClass
	public static void startAll() {
		String cloudscapePath = System.getProperty("user.dir") + File.separator + CLOUDSCAPE_DIR;
		System.setProperty("derby.system.home",cloudscapePath);
		System.out.println("Set Cloudscape home to: " + cloudscapePath);
		try {
			Driver driver = (Driver)Class.forName(DERBY_JDBC_EMBEDDED_DRIVER).newInstance();
			System.out.println("Using Cloudscape driver version " + driver.getMajorVersion() + "." + driver.getMinorVersion());
		} catch(Exception ex) {
			System.out.println("CANNOT START CLOUDSCAPE: " + ex);
		}
	}
	@Before
	public void start() throws Exception {
		connection = DriverManager.getConnection("jdbc:derby:CoursesDB");
		createCoursesTable();
		populateCoursesTable();
	}
	@After
	public void end() throws Exception {
		removeCoursesTable();
		connection.close();
	}
	@Test
	public void databaseSetupOK() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Courses");
		assertTrue("No first row",rs.next());
		assertEquals("Wrong number of records!",7,rs.getInt(1));
	}
	@Test
	public void iteratingResultSetForwards() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Courses WHERE CourseType = 'Beginners'");
		assertTrue("No first row",rs.next());
		assertEquals("First beginners not found","AB12",rs.getString("CourseNum"));
		assertTrue("No second row",rs.next());
		assertEquals("Second beginners not found","CD34",rs.getString("CourseNum"));
		assertTrue("No third row",rs.next());
		assertEquals("Third beginners not found","EF56",rs.getString("CourseNum"));
		assertFalse("Not at end",rs.next());
	}
	@Test
	public void iteratingResultSetBackwards() throws SQLException {
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = statement.executeQuery("SELECT * FROM Courses WHERE CourseType = 'Beginners'");
		rs.afterLast();
		assertTrue("No third row",rs.previous());
		assertEquals("Third beginners not found","EF56",rs.getString("CourseNum"));
		assertTrue("No second row",rs.previous());
		assertEquals("Second beginners not found","CD34",rs.getString("CourseNum"));
		assertTrue("No first row",rs.previous());
		assertEquals("First beginners not found","AB12",rs.getString("CourseNum"));
		assertFalse("Not at start",rs.previous());
	}
	@Test
	public void resultSetMetaData() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Courses WHERE CourseNum = 'Beginners'");
		ResultSetMetaData rsmd = rs.getMetaData();
		assertEquals("Wrong number of columns",5,rsmd.getColumnCount());
		//Check the column names
		assertEquals("Wrong first column name","COURSENUM",rsmd.getColumnName(1));
		assertEquals("Wrong second column name","COURSETITLE",rsmd.getColumnName(2));
		assertEquals("Wrong third column name","COURSETYPE",rsmd.getColumnName(3));
		assertEquals("Wrong fourth column name","STARTDATE",rsmd.getColumnName(4));
		assertEquals("Wrong fifth column name","ENDDATE",rsmd.getColumnName(5));
		//Check the column types
		assertEquals("Wrong first column type",Types.VARCHAR,rsmd.getColumnType(1));
		assertEquals("Wrong second column type",Types.VARCHAR,rsmd.getColumnType(2));
		assertEquals("Wrong third column type",Types.VARCHAR,rsmd.getColumnType(3));
		assertEquals("Wrong fourth column type",Types.DATE,rsmd.getColumnType(4));
		assertEquals("Wrong fifth column type",Types.DATE,rsmd.getColumnType(5));
	}
	@Test
	public void updatableRecordSet() throws SQLException {
		Statement statementOne = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
		ResultSet resultOne = statementOne.executeQuery("SELECT * FROM Courses WHERE CourseNum = 'AB12' FOR UPDATE OF CourseTitle");
		resultOne.next();
		//Check ResultSet is updatable
		assertEquals("Result Set not updatable",ResultSet.CONCUR_UPDATABLE,resultOne.getConcurrency());
		//Change the first row
		resultOne.updateString("CourseTitle","Intro To Python");
		resultOne.updateRow();
		//Check the changed row
		Statement statementTwo = connection.createStatement();
		ResultSet resultTwo = statementTwo.executeQuery("SELECT CourseTitle FROM Courses WHERE CourseNum = 'AB12'");
		resultTwo.next();
		assertEquals("Title not changed","Intro To Python",resultTwo.getString(1));
	}
	@Test
	public void preparedStatement() throws SQLException {
		PreparedStatement prepared = connection.prepareStatement(UPDATE_COMMAND);
		prepared.setString(1,"Intro To Smalltalk");
		prepared.setString(2,"Advanced");
		prepared.setString(3,"AB12");
		prepared.executeUpdate();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Courses WHERE CourseNum = 'AB12'");
		rs.next();
		assertEquals("Title not changed","Intro To Smalltalk",rs.getString("CourseTitle"));
		assertEquals("Type not changed","Advanced",rs.getString("CourseType"));
	}
	@Test
	public void callableStatement() throws SQLException {
		CallableStatement statementOne = connection.prepareCall("{ CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(?,?)}");
		statementOne.setString(1, "derby.locks.deadlockTimeout");
		statementOne.setString(2, "8192");
		statementOne.executeUpdate();
		CallableStatement statementTwo = connection.prepareCall("{ ? = CALL SYSCS_UTIL.SYSCS_GET_DATABASE_PROPERTY(?)}");
		statementTwo.registerOutParameter(1,Types.VARCHAR);
		statementTwo.setString(2,"derby.locks.deadlockTimeout");
		statementTwo.executeUpdate();
		assertEquals("Page size incorrect","8192",statementTwo.getString(1));
	}
	private void createCoursesTable() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(CREATE_TABLE_COMMAND);
	}
	private void removeCoursesTable() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(DROP_TABLE_COMMAND);
	}
	private void populateCoursesTable() throws SQLException {
		addCourseToDB("AB12", "Intro To C++", "Beginners");
		addCourseToDB("CD34", "Intro To C#", "Beginners");
		addCourseToDB("EF56", "Intro To Java", "Beginners");
		addCourseToDB("GH78", "Programming in IL", "Intermediate");
		addCourseToDB("IJ90", "XPath and XSLT", "Intermediate");
		addCourseToDB("KL12", "Enterprise JavaBeans", "Advanced");
		addCourseToDB("MN34", "Designing .NET Apps", "Advanced");
	}
	private void addCourseToDB(String num, String title, String type) throws SQLException {
		long now = new GregorianCalendar().getTime().getTime();
		PreparedStatement statement = connection.prepareStatement(INSERT_COMMAND);
		statement.setString(1,num);
		statement.setString(2,title);
		statement.setString(3,type);
		statement.setDate(4,new Date(now));
		statement.setDate(5,new Date(now));
		statement.executeUpdate();
	}
	private Connection connection;
}
