import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.util.logging.*;
import javax.sql.rowset.WebRowSet;
import java.util.ResourceBundle;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import java.util.MissingResourceException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.TimeoutException;
import java.io.*;
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Thread;
import java.util.ArrayList;
import  static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Proxy;
import java.lang.Object;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.JavascriptException;
import java.net.URL;
import org.springframework.util.StringUtils;
//import jdk.javadoc.internal.doclets.toolkit.util.JavaScriptScanner;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.PageLoadStrategy;



public class SeleniumBot extends Thread implements Runnable {

    public static WebDriver webDriver;
    public WebDriverWait webWait;
    Logger logger=Logger.getLogger(SeleniumBot.class.getName());
    ChromeOptions options;
    ChromeDriverService cds;
    //FirefoxOptions fop;
    //GeckoDriverService fds;
    String str ;
    public SeleniumBot(String str){
        try{
            this.str = str;
        options = new ChromeOptions()
        .setAcceptInsecureCerts(true)
        .setBinary(new File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"));
        options.addArguments("user-data-dir=C:\\Users\\PAUL\\AppData\\Local\\Google\\Chrome\\User Data2");
        options.addArguments("profile-directory=Profile 3");
        cds = new ChromeDriverService
        .Builder()
        .usingAnyFreePort()
        .usingDriverExecutable(new File("C:/Users/PAUL/Documents/AAAfiles/c++/SeleniumBot/chromedriver_win32/chromedriver.exe"))
        .build();
        options.setCapability("strictFileInteractability", true);
        options.setCapability("javascriptEnabled" ,true);
        options.setCapability("networkConnectionEnabled", true);
        options.setCapability("pageLoadStrategy", PageLoadStrategy.NORMAL);
        //Proxy proxy = new Proxy();
        //proxy.setProxyType(Proxy.ProxyType.MANUAL);
        //proxy.setHttpProxy("140.227.64.248:58888");
        //proxy.setSslProxy("140.227.69.124:3128");
        //options.setProxy(proxy);
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        list2.add("enable-automation");
        list1.add("origin-trial-disabled-features=SecurePaymentConfirmation");
        options.addArguments(list1);
        options.setExperimentalOption("excludeSwitches",list2);
        options.setExperimentalOption("useAutomationExtension",false);
    }
        catch(WebDriverException| ArrayIndexOutOfBoundsException|NullPointerException e){
           e.getMessage();
                }
    }
       
        public SeleniumBot init(){
            Logger logger1=Logger.getLogger(SeleniumBot.class.getName());
            File baseDirectory=new File("SeleniumBot.java");
            try{
            System.setProperty("webdriver.chrome.driver ",
            baseDirectory.getAbsolutePath()+"chromedriver_win32//chromedriver.exe");
            webDriver.navigate().to("https://www.asos.com/");
            String var1=webDriver.getCurrentUrl();
            log(var1);
            String var2=webDriver.getTitle();
            log(var2);
        }catch(ElementNotInteractableException|NoSuchElementException
        |InvalidArgumentException |TimeoutException e){
            logger1.log(Level.INFO,e.toString());
    }   
        return this;
        } 

        public SeleniumBot getItems(String str){
        webWait = new WebDriverWait(webDriver,40);
        webWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        WebElement searchBar = webDriver.findElement(By.name("q"));
        log(searchBar.getAttribute("innerHTML"));
        searchBar.sendKeys(str);
        WebElement searchButton = webDriver.findElement
        (By.className("kH5PAAC"));
        searchButton.click();
        ArrayList<WebElement> array1=  new ArrayList<WebElement>(10);
        array1.trimToSize();
        System.out.println(array1.size());
        array1 = (ArrayList<WebElement>)webDriver.findElements(By.className("_3TqU78D"));
        ArrayList<String> array2 = new ArrayList<String>();
        ArrayList<String> array3 = new ArrayList<String>();
        System.out.println(array1.size());
        array1.removeIf((WebElement wb1)->
        StringUtils.tokenizeToStringArray(wb1.getAttribute("aria-label"),":;,£").length>3);
        System.out.println(array1.size());
        String min = StringUtils.tokenizeToStringArray
        (array1.get(0).getAttribute("aria-label"),":;,£")[2];
        int marker = 0;
        array1.removeIf((WebElement wb1)->Double.parseDouble(
        StringUtils.tokenizeToStringArray(wb1.getAttribute("aria-label"),":;,£")[2])>25.00);
        System.out.println(array1.size());
        for(int i = 0; i<array1.size();i++){
            array2.add(StringUtils.tokenizeToStringArray
            (array1.get(i).getAttribute("aria-label"),":;,£")[0]);
            array3.add(StringUtils.tokenizeToStringArray
            (array1.get(i).getAttribute("aria-label"),":;,£")[2]);
        }
        array1.trimToSize();
        for(int i = 0;i<array2.size();i++){
            if(Double.parseDouble(array3.get(i))<
            Double.parseDouble(min)){
                min = array3.get(i);  
                marker = i;
            }
            log(array2.get(i)+": £"+array3.get(i));
        }
        System.out.println(array1.size());
        System.out.println(array3.size());
        System.out.println(array3.toString());
        log(min.toString());
        JavascriptExecutor JS = (JavascriptExecutor)(this.webDriver);
        JS.executeScript("arguments[0].click()",array1.get(marker));
        webWait = (WebDriverWait)(new WebDriverWait(webDriver,40).pollingEvery
        (Duration.ofSeconds(8)).ignoring(NoSuchElementException.class));
        WebElement wb1 = webDriver.findElement(By.id("main-size-select-0"));
        WebElement wb2 = webDriver.findElement(By.xpath
        ("/html/body/div[2]/div/main/div[1]/section[1]/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/button"));
        Select sec1 = new Select(wb1);
        sec1.selectByIndex(2); //*[@id="myAccountDropdown"]/button
        JS.executeScript("arguments[0].click()",wb2);

        return this;
    }
        public SeleniumBot login(){
        JavascriptExecutor JS = (JavascriptExecutor)(this.webDriver);
        webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"EmailAddress\"]")));
        webDriver.findElement(By.id("EmailAddress")).sendKeys(AsosDetails.EMAIL.getValue());
        webDriver.findElement(By.id("Password")).sendKeys(AsosDetails.PASSWORD.getValue());
        webDriver.findElement(By.id("signin")).click();
        return this;
        }
        public SeleniumBot checkOut(){
        JavascriptExecutor JS = (JavascriptExecutor)(this.webDriver);
        String str1 = new String("//div[@id=\"myAccountDropdown\"]/button"); 
        String str2 =new String("//div[@id=\"myaccount-dropdown\"]/div/div/div/div/div/span/a[1]");
        webWait.until(presenceOfElementLocated(By.xpath(str1)));
        JS.executeScript("arguments[0].click()",this.webDriver.findElement(By.xpath(str1)));
        JS.executeScript("arguments[0].click()",this.webDriver.findElement(By.xpath(str2)));
        webWait = new WebDriverWait(webDriver,40);
        webDriver.navigate().to("https://www.asos.com/bag?nlid=nav%20header");
        //.findElement(By.xpath("/html/body/div[2]/div/main/div/div[1]/div/div[2]/div/bag-total/div/div/span[2]/p/a")).click();
        webDriver.findElement(By.linkText("CHECKOUT")).click();
        this.login();
        webDriver.findElement
        (By.xpath
        ("//div[@id=\"minibag-dropdown\"]/div/div/div/div[2]/div/div[3]/div[1]/a")).click();
        webWait.until(ExpectedConditions.visibilityOfElementLocated
        (By.xpath
        ("//div[@id=\"bagApp\"]/div[1]/div/div[2]/div/bag-total/div/div/span[2]/p/a")));
        JS.executeScript("argument[0].click()",webDriver.findElement
        (By.xpath
        ("//div[@id=\"bagApp\"]/div[1]/div/div[2]/div/bag-total/div/div/span[2]/p/a")));
        WebElement changeButton = webDriver.findElement(By.className("btn tertiary change"));
        JS.executeScript("document.querySelector(\"@btn tertiary change\")",changeButton);
        webWait.until(presenceOfElementLocated(By.className("wallet")));
        JS.executeScript
        ("document.querySelector(\"@wallet\").childNode.click()",webDriver.findElement(By.className("btn primary add-new-payment")));
        webWait.until(presenceOfElementLocated(By.className("payment-methods")));
        JS.executeScript
        ("document.querySelector(\"@payment-methods\").childNode.click()",webDriver.findElement(By.className("btn secondary payment-method card")));
        webDriver.findElement
        (By.id("cardNumber")).sendKeys(AsosDetails.CARDPAN.getValue());
        WebElement wb1 = webDriver.findElement(By.id("expiryMonth"));
        Select monthList = new Select(wb1);
        monthList.selectByValue
        ((String)AsosDetails.CARDEXPIRYDATE.getValue().substring(0,2));
        WebElement wb2 = webDriver.findElement(By.id("expiryYear"));
        Select yearList = new Select(wb2);
        yearList.selectByValue
        ((String)AsosDetails.CARDEXPIRYDATE.getValue().substring(3));
        webDriver.findElement
        (By.id("cardName")).sendKeys(AsosDetails.CARDNAME.getValue());
        webDriver.findElement
        (By.id("cardCode")).sendKeys(AsosDetails.CVV.getValue());
        webDriver.findElement
        (By.className("btn primary save-card")).click();
        return this;
        }
        @Override
        public void run(){
        this.webDriver = new ChromeDriver(cds,options);
        this.webWait = new WebDriverWait(webDriver,40);
        try{
        this.init()
        //.login();
        .getItems(str);
        //.checkOut();
        }catch(WebDriverException|ArrayIndexOutOfBoundsException|
        NullPointerException|NumberFormatException E){
            System.out.println(E.toString());
        }  
    }
    public void log(WebElement webElement){
        this.logger.log(Level.INFO, webElement.toString());
    }
    public void log(String webElement){
        this.logger.log(Level.INFO, webElement.toString());
    }
    public static synchronized void impose(Thread T1,String str,int var1){
        T1.setPriority(var1);
        T1.setName(str);
        T1.start();
    }
    public static void main(String[] args){
    //Thread Thread1 = new SeleniumBot(10,true);
    //SeleniumBot.impose(Thread1,"T1",5);
    //The string argument of the constructor of the SeleniumBot class refers to the item to be searched for on Asos.
    Thread seleniumBot = new SeleniumBot("Mens Joggers");
    SeleniumBot.impose(seleniumBot,"T1",5);
    }
}