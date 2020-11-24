package pages;

import helpers.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.common.logical.Footer;
import pages.common.logical.Header;

public class Home_page {

    private static volatile String page_title = "SemanticBits – SemanticBits specializes in the design and " +
            "development of software systems for the health and life sciences industries";
    private final WebDriver wd;
    public final Header header;
    public final Footer footer;

    public Home_page(WebDriver wd){
        this.wd = wd;
        this.header = new Header(this.wd);
        this.footer = new Footer(this.wd);
        DriverHelpers.waitForTitle(this.wd,page_title);
    }

    // this is where actions performed on the page itself rather than the logical header or footer.
}
