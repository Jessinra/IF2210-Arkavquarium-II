import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class TestRunnerArkavquarium {
    public static void main(String[] args) {

        // >> ADD YOUR TEST CLASS HERE <<
        Class[] testClasses = new Class[]{

            TestFood.class,
            TestCoin.class,
        };

        // Test every JUnit class
        for (Class testClass : testClasses) {

            // Display header
            System.out.println("==================================");
            System.out.println("\t" + testClass.toString());
            System.out.println("==================================");

            // Run the JUnit class
            Result result = JUnitCore.runClasses(testClass);

            // Show failing test
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            // Overall report
            System.out.println("\nOverall test success : " + result.wasSuccessful() + "\n");
       }
   }
}