package qarentena.bdd.testes.servico;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarentena",
        plugin = {"pretty", "html:build/reports/feature.html"},
        features = {"src/test/resources/features"})
public class TestesCucumber {
}