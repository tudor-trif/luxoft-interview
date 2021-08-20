package tests;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    public String token;

    @BeforeMethod(alwaysRun = true)
    public void beforeTestMethod(Method method) {
        System.out.println("\n--------------");
        System.out.println("STARTING TEST");
        System.out.println("Test name: " + method.getName());
        Test test = method.getAnnotation(Test.class);

        System.out.println();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest(ITestResult result) {

        System.out.println();
        System.out.println("END TEST: " + result.getName());
        System.out.println("Test result: " + resolveTestStatus(result.getStatus()));
        System.out.println("--------------");
    }

    private String resolveTestStatus(int status) {
        switch (status) {
            case 1:
                return "PASSED";
            case 2:
                return "FAILED";
            case 3:
                return "SKIPPED";
            case 4:
                return "SUCCESS PERCENTAGE FAILURE";
            case 16:
                return "STARTED";
            default:
                return "UNKNOWN RESULT";
        }
    }
}

