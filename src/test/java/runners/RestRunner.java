package runners;


import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utils.RunnerPersonalizado;


@CucumberOptions(features = {"src/test/resources/features/Rest.feature"},
        glue = "definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@MetodosPOST")

@RunWith(RunnerPersonalizado.class)
public class RestRunner
{

}