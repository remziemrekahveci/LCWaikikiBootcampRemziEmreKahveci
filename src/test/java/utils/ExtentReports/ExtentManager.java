package utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent==null){
            //Set HTML reporting file location
            String directory = System.getProperty("user.dir");
            extent = new ExtentReports(directory+"\\ExtentReports\\ExtentReportResults.html");
        }
        return extent;
    }
}
