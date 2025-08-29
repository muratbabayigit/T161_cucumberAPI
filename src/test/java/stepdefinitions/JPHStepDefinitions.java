package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

public class JPHStepDefinitions {
    String url="";
    Response response;
    JsonPath resJP;
    JSONObject reqBody=new JSONObject();


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


    @When("kullanici PUT request yaparak response bilgilerini kaydeder")
    public void kullaniciPUTRequestYaparakResponseBilgileriniKaydeder() {
        response=RestAssured.given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

    }

    @When("kullanici {string} header dergerinin {string} oldugunu test eder")
    public void kullaniciHeaderDergerininOldugunuTestEder(String headerKey, String headerValue) {
        Assertions.assertEquals(headerValue,response.getHeader(headerKey));
                             // keep-alive,                    Connection

    }

    @When("kullanici response id degerinin {int} oldugunu test eder")
    public void kullaniciResponseIdDegerininOldugunuTestEder(int expId) {
        Assertions.assertEquals(expId,resJP.getInt("id"));
    }

    @When("kullanici response userId degerinin {int} oldugunu test eder")
    public void kullaniciResponseUserIdDegerininOldugunuTestEder(int expUserId) {
        Assertions.assertEquals(expUserId,resJP.getInt("userId"));
    }



    @When("kullanici PUT request yapabilmek için {string},{string} , {double} {double} bilgileri ile reqBody olusturur")
    public void kullaniciPUTRequestYapabilmekIcinBilgileriIleReqBodyOlusturur(String title, String body, double userId, double id) {
        reqBody.put("title",title);
        reqBody.put("body",body);
        reqBody.put("userId",userId);
        reqBody.put("id",id);

    }
}
