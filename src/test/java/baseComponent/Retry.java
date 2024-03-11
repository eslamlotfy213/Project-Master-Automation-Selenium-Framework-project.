package baseComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test method has to be retried, false otherwise.
     */

    int count=0;
    int maxtry=1;
    @Override
    public boolean retry(ITestResult result) {
        if (count < maxtry){
            count ++;
            return  true;
        }
        return false;
    }


}
