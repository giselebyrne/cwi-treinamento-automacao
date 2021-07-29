package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMapper {

    //Mapeamento dos Elementos que irá utilizar no Teste

    @FindBy(className = "Login")
    // Declaração de Variável do Tipo WebElement
    public WebElement login;

    @FindBy(id= "search_query_top")
    public WebElement search_query_top;

    @FindBy(css = "button.btn.btn-default.button-search")
    public WebElement submit_search;
}
