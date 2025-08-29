package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

public class JPHStepDefinitions {
    String url="";
    Response response;
    JsonPath resJP;


    @Given("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String ConfigBaseUrl) {
        url+= ConfigReader.getProperty(ConfigBaseUrl);
        //https://jsonplaceholder.typicode.com oluştu

    }

    @Then("kullanici path parametresi olarak {string} girer")
    public void kullaniciPathParametresiOlarakGirer(String pathParams) {
        url=url+"/"+pathParams;
        //https://jsonplaceholder.typicode.com/posts/44 oluştu

    }

    @Then("kullanici GET request yaparak donen response bilgilerini kaydeder")
    public void kullaniciGETRequestYaparakDonenResponseBilgileriniKaydeder() {

        response= RestAssured.given().when().get(url);

    }

    @And("kullanici response statusCode degerinin {int} oldugunu test eder")
    public void kullaniciResponseStatusCodeDegerininOldugunuTestEder(int expStatusCode) {
        Assertions.assertEquals(expStatusCode,response.getStatusCode());
    }

    @And("kullanici content type degerinin {string} oldugunu test eder")
    public void kullaniciContentTypeDegerininOldugunuTestEder(String expContentType) {
        Assertions.assertEquals(expContentType,response.getContentType());
    }

    @And("kullanici response degerini jsonpath olarak kaydeder")
    public void kullaniciResponseDegeriniJsonpathOlarakKaydeder() {

        resJP=response.jsonPath();
    }

    @Then("kullanici response {string} degerinin {string} oldugunu test eder")
    public void kullaniciResponseDegerininOldugunuTestEder(String expKey, String expValue) {
        Assertions.assertEquals(expValue,resJP.getString(expKey));
        // expValue benim beklediğim sonuç, expKey ise hangi key in sonucu olduğudur

    }
}
