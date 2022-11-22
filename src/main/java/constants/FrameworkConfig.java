package constants;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/properties/Config.properties"})
public interface FrameworkConfig extends Config {

    String browser();

    @Key("${environment}.url")
    String url();

    @DefaultValue("si")
    String environment();

    int implicitWait();

    int explicitWait();

    @DefaultValue("Canada")
    String languagecountry();


}
