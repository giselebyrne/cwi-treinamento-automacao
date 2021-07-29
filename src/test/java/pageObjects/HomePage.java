package pageObjects;

import elementMapper.HomePageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

// No PageObjects colocamos todas as ações do Script de Teste
public class HomePage extends HomePageElementMapper {

    public HomePage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    //Declarando um método que vai conter uma ação para a variável declarada em elementMapper
    public void clickBtnLogin(){
        login.click();
    }

    public void clickSearch_query_top(){
        search_query_top.click();
    }

    // Nesse método temos q enviar o produto q estamos pesquisando, por isso q estamos passando uma string no método
    public void sendKeysSearch_query_top(String Keys){
        search_query_top.sendKeys(Keys);
    }

    public void clickSubmit_search(){
        submit_search.click();
    }

    // Para facilitar criamos um método que contém todos os métodos criados acima
    public void doSearch(String quest){
        clickSearch_query_top();
        sendKeysSearch_query_top(quest);
        clickSubmit_search();

    }
}
