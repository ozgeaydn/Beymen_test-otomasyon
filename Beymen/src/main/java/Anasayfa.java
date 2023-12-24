import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
//import jxl.Sheet;
//import jxl.Workbook;

public class Anasayfa {
    WebDriver driver;
    public void basla() {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver/chromedriver.exe");

        driver = new ChromeDriver(ops);

        driver.get("https://www.beymen.com/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.beymen.com/");
    }

    public void cerezleriKabulEt() throws InterruptedException{
        Thread.sleep(1000);
      driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public void cinsiyetSec(){
       driver.findElement(By.id("genderWomanButton")).click();
    }

    public void anasayfaKontrol(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.beymen.com/");
    }


    public void aramaYap() throws InterruptedException {

        Thread.sleep(100);

        driver.findElement(By.xpath("//div[@class='o-header__search--wrapper']")).click();

        driver.findElement(By.name("qSugesstion")).click();

//        Workbook wBook = Workbook.getWorkbook(new File("excel.xls"));
//        jxl.Sheet Sheet = wBook.getSheet(0);

        driver.findElement(By.name("qSugesstion")).sendKeys("gömlek");
        Thread.sleep(5000);
        driver.findElement(By.name("qSugesstion")).clear();

        Thread.sleep(5000);
        driver.findElement(By.name("qSugesstion")).sendKeys("gömlek");
        driver.findElement(By.className("o-header__search--btn")).click();
        Thread.sleep(1000);
    }


    List<WebElement> tumUrunler;
    public void randomUrunSec() throws InterruptedException{
        try {
            tumUrunler  = driver.findElements(By.xpath("//div[@class='m-productImageList']"));
            Thread.sleep(1000);
            Random random = new Random();
            int rastgeleUrun  = random.nextInt(tumUrunler.size());
            tumUrunler.get(rastgeleUrun).click();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

    }


    List<WebElement> tumBedenler;
    public void randomBedenSec() throws InterruptedException {
        try {
            tumBedenler  = driver.findElements(By.xpath("//div[@class='m-variation']"));
            Thread.sleep(1000);
            Random random = new Random();
            int rastgeleBeden  = random.nextInt(tumBedenler.size());
            tumBedenler.get(rastgeleBeden).click();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

    }

    public void sepeteEkle() throws InterruptedException{
        Thread.sleep(5000);
         driver.findElement(By.id("addBasket")).click();
    }

    public void sepeteTıkla() throws InterruptedException{
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@class='o-header__userInfo--item bwi-cart-o -cart']")).click();
        Thread.sleep(5000);
    }

    public void miktarArttir(){
       Select dropdown = new Select(driver.findElement(By.id("quantitySelect0-key-0")));
        dropdown.selectByIndex(2);
    }

    public void sil() throws InterruptedException{
        Thread.sleep(10000);
        driver.findElement(By.id("removeCartItemBtn0-key-0")).click();
    }

}
