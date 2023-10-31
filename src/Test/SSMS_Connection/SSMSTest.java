package Test.SSMS_Connection;
import SSMS_Connection.SSMS;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class SSMSTest {
    @Test
    public void TestSSMSConnection() throws SQLException {
        SSMS connection = new SSMS();
        Assert.assertNotNull(connection);
    }
}