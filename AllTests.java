package testare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestComanda.class, TestFactura.class, TestValidare.class, TestClient.class, TestDateClient.class })
public class AllTests {

}