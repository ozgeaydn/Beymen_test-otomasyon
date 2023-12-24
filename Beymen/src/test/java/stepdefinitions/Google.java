package stepdefinitions;

public class Google {

    public void google_sitesine_gidilir(){
        Driver.getDriver().get(ConfigReader.getPropert("browser"));
    }
}
