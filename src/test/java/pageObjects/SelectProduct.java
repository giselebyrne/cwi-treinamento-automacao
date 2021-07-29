package pageObjects;

import elementMapper.SelectProductElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SelectProduct extends SelectProductElementMapper {

    public SelectProduct() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    //Criar métodos para as ações necessárias para validar a página
    public String getNavigation_pipe(){
        return navigation_pipe.getText();
    }

    public String getOur_price_display(){
        return our_price_display.getText();
    }

    public String getPull_right(){
        return pull_right.getText();
    }

}
