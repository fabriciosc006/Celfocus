package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"src/test/java/Steps"},
        tags = "@browserTest",
        plugin = { "pretty", "html:test-output",
                "json:target/cucumber-report/cucumber.json" ,
                "de.monochromata.cucumber.report.PrettyReports:target/maven-cucumber-report"},
        dryRun = false,monochrome = true

)
public class Runner {

    @AfterClass
      public static void TearDown(){
        File reportOutputDirectory = new File("target/maven-cucumber-report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report/cucumber.json");
        Configuration configuration = new Configuration(reportOutputDirectory, "qa-challenge");
        configuration.setBuildNumber("011");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Environment", "QA");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();

    }
}
