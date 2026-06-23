package test.suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import test.LoginTest;
import test.SearchEmployeeTest;

@Suite
@SelectClasses({
        LoginTest.class,
        SearchEmployeeTest.class
})
public class SmokeSuite {
}
