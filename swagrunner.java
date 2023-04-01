package stepdefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\HP\\eclipse-workspace\\amnur.com\\src\\test\\resources\\features\\swag.feature"},
glue = {"stepdefination"},monochrome = true,
plugin = {"html:C:\\Users\\HP\\eclipse-workspace\\amnur.com\\src\\test\\swag.html",
		"me.jvt.cucumber.report.PrettyReports:C:\\Users\\HP\\eclipse-workspace\\amnur.com\\src\\test\\cucumber"})

public class swagrunner {

}
