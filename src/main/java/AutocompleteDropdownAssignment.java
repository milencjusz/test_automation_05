import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutocompleteDropdownAssignment {
    public static void main(String[] args) {
        // Initialize a new instance of WebDriver as EdgeDriver
        WebDriver driver = new EdgeDriver();
        // Navigate to the specified URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("autocomplete"));
        // Send keys "ind" to the dropdown to filter the options
        dropdown.sendKeys("ind");
        // Wait for the options to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-front li")));
        // Find all the web elements that appear in options dropdown and store them in a List
        List<WebElement> options = driver.findElements(By.cssSelector(".ui-front li"));
        // Iterate over the options in the dropdown
        for (int i = 0; i < options.size(); i++) {
            // Get the text of the current option
            String optionText = options.get(i).getText();
            // Check if the option text is "India"
            if (optionText.equalsIgnoreCase("India")) {
                // If it is, create an Actions object, move to the option, click on it, and break out of the loop
                Actions actions = new Actions(driver);
                actions.moveToElement(options.get(i)).click().build().perform();
                break;
            }
        }
        // Print the value of the input field
        System.out.println(driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).getAttribute("value"));
    }
}