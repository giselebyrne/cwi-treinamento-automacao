package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectProductElementMapper {

    //Mapear os Elementos para selecionar a página do Produto escolhido
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[6]/div/div[2]")
    public WebElement right_block;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[6]/div/div[2]/div[2]/a[2]")
    public WebElement Button_more;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]")
    public WebElement navigation_pipe;

    @FindBy(id = "our_price_display")
    public WebElement our_price_display;

    @FindBy(className = "pull-right")
    public WebElement pull_right;
}
