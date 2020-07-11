package qarentena.bdd.testes.servico;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "not @wip and not @quarentena",
        plugin = {"pretty", "html:build/reports/feature.html"},
        features = {"src/test/java/qarentena/bdd/testes/servico/features"})
public class TestesCucumber {
}