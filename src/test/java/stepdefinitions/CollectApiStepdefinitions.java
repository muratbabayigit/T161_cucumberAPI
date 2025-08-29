package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;

public class CollectApiStepdefinitions {
    String url="";
    Response response;


    @When("kullanici GET sorgusu icin {string} adresine gider")
    public void kullaniciGETSorgusuIcinAdresineGider(String baseUrl) {
        url+= ConfigReader.getProperty(baseUrl);
        
    }

    @When("kulalnici path parametresi olarak {string} girer")
    public void kulalniciPathParametresiOlarakGirer(String pathparams) {
        url+="/"+pathparams;
    }

    @When("kullanici query parametresi olarak il degerine {string} ilce degerine {string} girer")
    public void kullaniciQueryParametresiOlarakIlDegerineIlceDegerineGirer(String ilvalue, String ilcevalue) {
        url+="?ilce="+ilcevalue+"&il="+ilvalue;
     //   https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale&ilce=Merkez
    }

    @When("kullanici get request icin donen cevabi kaydeder")
    public void kullaniciGetRequestIcinDonenCevabiKaydeder() {
        response= RestAssured.given().when().header("authorization","apikey 4q90n30xa250errKiWzuxg:5W5hJ1DloVjag8g3KB4mss").get(url);
        
    }

    @When("kullanici donen response degerini yazdirir")
    public void kullaniciDonenResponseDegeriniYazdirir() {
        response.prettyPrint();

    }
}
