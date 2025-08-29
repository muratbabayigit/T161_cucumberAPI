Feature: Collect API Sorguları
#  curl --request GET \
# --url 'https://api.collectapi.com/health/dutyPharmacy?ilce=Yenimahalle&il=Ankara' \
#  --header 'authorization: apikey 4q90n30xa250errKiWzuxg:5W5hJ1DloVjag8g3KB4mss' \
#  --header 'content-type: application/json'
  Scenario: NobetciEczanelerSorgusu

    * kullanici GET sorgusu icin "collectApiUrl" adresine gider
    * kulalnici path parametresi olarak "health/dutyPharmacy" girer
    * kullanici query parametresi olarak il degerine "Kırıkkale" ilce degerine "Merkez" girer
    * kullanici get request icin donen cevabi kaydeder
    * kullanici donen response degerini yazdirir


