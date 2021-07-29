package pageObjects;

import elementMapper.BuyProductElementMapper;
import javafx.scene.input.InputMethodTextRun;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class BuyProduct extends BuyProductElementMapper {

    public BuyProduct(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    //Mapear as Ações para Efetuar a compra do Produto Selecionado
    public String getGroup_1(){
        return group_1.getText();
    }

    public String getSelectedGroup_1(){
        return selectedGroup_1.getText();
    }

    public String getColor_14(){
        return color_14.getText();
    }

    public String getBuy_product(){
        return buy_product.getText();
    }

    public String getProduct_name(){
        return product_name.getText();
    }

    public String getProceed_checkout(){
        return proceed_checkout.getText();
    }


}
