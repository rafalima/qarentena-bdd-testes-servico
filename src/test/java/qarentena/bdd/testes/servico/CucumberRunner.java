package qarentena.bdd.testes.servico;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:build/reports/feature"},
        features = {"src/test/java/qarentena/bdd/testes/servico/features"})
public class CucumberRunner {
}