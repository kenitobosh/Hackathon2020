package HTMLUnitDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.List;

public class HTMLUnitDriverMain {

    public static void main(String[] args)
    {
        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("https://courses.illinois.edu/schedule/2020/fall/GWS/100");
        List<WebElement> tr = driver.findElements(By.xpath("//tr[contains(@id, 'uid')]"));
        for(WebElement row: tr)
        {
            List<WebElement> info  = row.findElements(By.className("app-meeting"));
            boolean available = true;
            if(row.findElement(By.tagName("img")).getAttribute("title").equals("Closed"))
            {
                available = false;
            }
            List<String> text = new ArrayList<>();
            for(int i = 0; i < info.size(); i++)
            {
                text.add(info.get(i).getText());
            }

            if(available)
            {
                ClassInfo classInformation = new ClassInfo(text);
                System.out.println(classInformation.getInfo());
            }
        }
        driver.quit();
    }

}
