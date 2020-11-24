import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home_page;
import java.util.List;
import static pages.common.logical.Header.MenuItems.*;
import static pages.common.logical.Header.AboutSubMenuItems.*;

public class OurTeam_pageTest {

    private WebDriver wd = null;

    @BeforeEach
    public void setup(){
        wd = new ChromeDriver();
    }

    @Test
    public void OurTeamTest(){
        wd.get("https://semanticbits.com/");
        Home_page pg = new Home_page(wd);
        pg.header.mouseOverMenuItem(ABOUT);
        pg.header.clickSubMenuItem(OUR_TEAM);
        wd.switchTo().frame("advanced_iframe");
        List<WebElement> staffArr = wd.findElements(By.className("name"));
        int chrisCount = 0;
        for(WebElement el : staffArr){
            String fullName = el.getText().toLowerCase();
            if(fullName.startsWith("chris")){
                chrisCount++;
            }
        }
        Assertions.assertEquals(chrisCount, 8);
    }

    @AfterEach
    public void tearDown(){
        if(wd != null){
            wd.quit();
        }
        wd = null;
    }
}