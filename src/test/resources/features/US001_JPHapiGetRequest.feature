Feature: US001_JPH API GET REQUEST

# https://jsonplaceholder.typicode.com/posts/44 endpointine
# bir GET request gonderdigimizde donen response'un
# status code'unun 200 olduğunu,
# content type degerinin "application/json; charset=utf-8 " ve
# "title" degerinin "optio dolor molestias sit" oldugunu test edin

  Scenario: JPH Get Request Testi

    * kullanici "JPHBaseUrl" adresine gider
    # Burada endpoint base url oluşturuldu
    * kullanici path parametresi olarak "posts/44" girer
    # Burada endpoint parametresi girilerek enpoint tamamlandı
    * kullanici GET request yaparak donen response bilgilerini kaydeder
    * kullanici response statusCode degerinin 200 oldugunu test eder
    * kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
    * kullanici response degerini jsonpath olarak kaydeder
    * kullanici response "title" degerinin "optio dolor molestias sit" oldugunu test eder



