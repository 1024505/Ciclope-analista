package co.com.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/IngresarHorasNovedades.feature",
        glue = "co.com.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class IngresarHorasNovedadesRunner {
}
