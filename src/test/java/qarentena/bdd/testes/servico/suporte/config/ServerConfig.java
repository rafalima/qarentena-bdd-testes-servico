package qarentena.bdd.testes.servico.suporte.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${ENV}.properties",
                 "classpath:properties/local.properties"})
public interface ServerConfig extends Config {
    @DefaultValue("baseURI")
    @Key("api.base.uri")
    String baseURI();

    @DefaultValue("basePath")
    @Key("api.base.path")
    String basePath();

    @DefaultValue("0")
    int port();

}
