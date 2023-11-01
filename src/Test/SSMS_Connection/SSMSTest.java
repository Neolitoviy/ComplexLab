package Test.SSMS_Connection;
import SSMS_Connection.SSMS;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Клас містить тести для перевірки підключення до SQL Server.
 */
public class SSMSTest {
    /**
     * Тест на успішне підключення до SQL Server.
     *
     * @throws SQLException виникає, коли виникають проблеми з підключенням до бази даних SQL Server.
     */
    @Test
    public void testSSMSConnection() throws SQLException {
        SSMS connection = new SSMS();
        Assert.assertNotNull(connection);
    }
}