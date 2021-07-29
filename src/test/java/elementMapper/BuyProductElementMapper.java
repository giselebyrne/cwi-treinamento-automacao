package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyProductElementMapper {

    //Mapear Elementos para Efetuar a Compra do Produto Selecionado
    @FindBy(id = "group_1")
    public WebElement group_1;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[3]")
    public WebElement selectedGroup_1;

    @FindBy(id = "color_14")
    public WebElement color_14;


    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    public WebElement buy_product;

    @FindBy(className = "product-name")
    public WebElement product_name;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement proceed_checkout;

}
