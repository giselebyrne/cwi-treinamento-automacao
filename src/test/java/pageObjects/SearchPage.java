package pageObjects;

import elementMapper.SearchPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPage extends SearchPageElementMapper{
    public SearchPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    //Ações de pegar o texto dos elementos para validar se acessou a página correta no setupTest
    //O Navigation_page sempre será Fixo
    public String getTextNavigation_page(){
        return navigation_page.getText();
    }

    // O Lighter e o Heading Counter sempre irão variar. Lighter é o produto q estamos pesquisando
    // e o Heading Counter é a quantidade de produtos que foram encontrados
    public String getTextLighter(){
        return lighter.getText();
    }

    public String getHeading_counter(){
        return heading_counter.getText();
    }

    // Não entendi esse método
    // Eu acho q esse método retorna um booleano informando se a página é a Search ou não
    public boolean isSearchPage(){
        return getTextNavigation_page().equals("Search");
    }

}
