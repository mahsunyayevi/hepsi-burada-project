package tests;

import com.pages.*;
import com.runner.TestsRunner;
import org.testng.annotations.Test;

import static com.data.BaseData.password;
import static com.data.BaseData.username;

public class TeslimatSecenekleri  extends TestsRunner {


    @Test
    public void TS0003() throws InterruptedException {
        IndexPage indexPage = new IndexPage(getDriver(), testNo, getBrowserName());
        LoginPage loginPage = new LoginPage(getDriver(), testNo, getBrowserName());
        Urunler urunler = new Urunler(getDriver(), testNo, getBrowserName());
        UrunDetay urunDetay = new UrunDetay(getDriver(), testNo, getBrowserName());

        String urunKilif = "Casethrone Apple iPhone X";
        String urunOturmaGrubu = "Hepsi Home Bahama Bambu Balkon Bahçe Oturma Grubu";

        indexPage
                .accountNav()
                .girisYapNavKontrol()
                .girisYapBtn();
        loginPage
                .girisYapPageAlanKontrolleri()
                .emailDoldur(username)
                .sifreDoldur(password)
                .girisYapBtn();
        indexPage
                .aramaDoldur(urunKilif)
                .btnAra();
        urunler
                .urunKontrolVeSec(urunKilif);

        urunDetay
                .sepeteEkle();
        indexPage
                .aramaDoldur(urunOturmaGrubu)
                .btnAra();
        urunler
                .urunKontrolVeSec(urunOturmaGrubu);

        urunDetay
                .sepeteEkle();


    }
}
