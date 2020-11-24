package pages.common.logical;
/**
 * This class describes the logical header of a page common across all or most pages of a site.
 * This is the fullscreen header.
 */
import helpers.DriverHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Header {

    private WebDriver wd;

    public Header(WebDriver wd) {
        this.wd = wd;
    }

    public void mouseOverMenuItem(MenuItems menuItem){
        WebElement el = DriverHelpers.waitForElement(wd,By.linkText(menuItem.toString()));
        new Actions(wd).moveToElement(el).perform();
    }

    public void clickSubMenuItem(AboutSubMenuItems subMenuItem){
        WebElement el = DriverHelpers.waitForElement(wd,By.linkText(subMenuItem.toString()));
        el.click();
    }

    /** Make selection of header menu items available to methods to avoid coding errors */
    /** * could be updated to return destination pages as well to assist POM */
    public enum AboutSubMenuItems {
        OUR_IDENTITY("Our Identity"),
        LATEST_NEWS("Latest News"),
        OUR_TEAM("Our Team"),
        CLIENTS_AND_PARTNERS("Clients & Partners"),
        CAREERS("Careers");

        private final String strValue;

        AboutSubMenuItems(String str){
            strValue = str;
        }

        @Override
        public String toString(){
            return strValue;
        }
    }

    public enum MenuItems {
        EXPERTISE("Expertise"),
        DOMAINS("Domains"),
        SERVICES("Services"),
        ABOUT("About"),
        BLOG("Blog"),
        CONTACT("Contact");

        private final String menuItem;

        MenuItems(String menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public String toString(){
            return menuItem;
        }
    }
}
