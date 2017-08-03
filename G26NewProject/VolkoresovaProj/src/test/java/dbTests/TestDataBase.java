package dbTests;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;


public class TestDataBase {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");


    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testWithDB() throws SQLException {
        logger.info(dbMySQL.selectTable("select login from seleniumTable"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
       // logger.info(dbMySQL.changeDB("INSERT INTO seleniumTable " + "VALUES (777, 'volkorezovaTest', 'pass')"));
        logger.info(dbMySQL.changeDB("DELETE FROM seleniumTable " + "WHERE login ='volkorezovaTest'"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));

    }
}