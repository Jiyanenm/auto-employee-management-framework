package test.suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import test.*;

@Suite
@SelectClasses({
        LoginTest.class,
        AddEmployeeTest.class,
        SearchEmployeeTest.class,
        searchNonExistingEmployeeTest.class,
        DeleteEmployeeTest.class
})
public class RegressionSuite {
}
