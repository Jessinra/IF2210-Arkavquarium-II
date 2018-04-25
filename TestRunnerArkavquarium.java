import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

public class TestRunnerArkavquarium {
    public static void main(String[] args) {

        // >> ADD YOUR TEST CLASS HERE <<
        Class[] testClasses = new Class[]{

            TestImage.class,
            TestFood.class,
            TestCoin.class,
            TestFish.class,
            TestGuppy.class,
            TestPiranha.class,
            TestLinkedList.class,
            TestPet.class,
            TestSiput.class,
            TestAquarium.class,

        };

        // Test every JUnit class
        int testRunned = 0;
        int testFail = 0;

        for (Class testClass : testClasses) {

            // Display header
            System.out.println("==================================");
            System.out.println("\t" + testClass.toString());
            System.out.println("==================================");

            // Run the JUnit class
            Result result = JUnitCore.runClasses(testClass);

            testRunned += result.getRunCount();
            testFail += result.getFailureCount(); 

            // Show failing test
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }

            // Overall report
            System.out.println("\nOverall test success : " + result.wasSuccessful() + "\n");
       }

       System.out.println("\n\n=============================");
       System.out.println("\t Final Report");
       System.out.println("=============================");
       System.out.println("Testing done     : " + testRunned);
       System.out.println("Testing success  : " + (testRunned - testFail));
       System.out.println("Testing fail     : " + testFail);
       System.out.println("Success rate     : " + ((testRunned-testFail)*100/testRunned) + "%");
       System.out.println("=============================");
   }
}