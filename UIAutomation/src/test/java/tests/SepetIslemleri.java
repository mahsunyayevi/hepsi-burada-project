package tests;

import com.pages.IndexPage;
import com.pages.LoginPage;
import com.pages.UrunDetay;
import com.pages.Urunler;
import com.runner.TestsRunner;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.data.tests.TestDescription.*;
import static com.data.BaseData.*;

public class SepetIslemleri extends TestsRunner {


    @Test(enabled = true, description = TS0001Description)
    public void TS0001() throws InterruptedException {

        IndexPage indexPage = new IndexPage(getDriver(), testNo, getBrowserName());
        LoginPage loginPage = new LoginPage(getDriver(), testNo, getBrowserName());
        Urunler urunler = new Urunler(getDriver(), testNo, getBrowserName());
        UrunDetay urunDetay = new UrunDetay(getDriver(), testNo, getBrowserName());


        String urun = "Samsung Galaxy S20 Plus 128 GB";

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
                .aramaDoldur(urun)
                .btnAra();
        urunler
                .urunKontrolVeSec(urun);

        ArrayList<String> satici = urunDetay.digerSaticilariGetir();
        urunDetay
                .sepeteEkleDigerSatici(satici.get(0))
                .popupSepeteDevamEt()
                .sepeteEkleDigerSatici(satici.get(1))
                .popupSepeteDevamEt();
    }

    @Test(enabled = true, description = TS0002Description)
    public void TS0002() throws InterruptedException {

        Urunler urunler = new Urunler(getDriver(), testNo, getBrowserName());
        UrunDetay urunDetay = new UrunDetay(getDriver(), testNo, getBrowserName());

        String menu = "Kitap, Müzik, Film, Hobi";
        String altMenu = "Uzaktan Kumandalı Araçlar";
        String urun = "Drone Yedek";


        urunler
                .menuSec(menu,altMenu);
        urunler.urunKontrolVeSec(urun);
        urunDetay
                .sepeteEkle();
    }
}
