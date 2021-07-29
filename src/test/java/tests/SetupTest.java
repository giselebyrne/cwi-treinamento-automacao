package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BuyProduct;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SelectProduct;
import utils.Browser;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{

    //No SetupTest implementamos os Testes
    @Test
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e Carregamos a URL!");
    }

    @Test
    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Clicou em Sign In e direcionou para a Página de Login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        System.out.println("Url Correta");
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("giselebyrne@gmail.com");
        System.out.println("Preencheu o email");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("teste123");
        System.out.println("Preencheu a Senha");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site");
    }

    @Test
    public void testSearch() throws InterruptedException {

        String quest = "DRESS";
        String questResultQtd = "7";

        //Iniciar as Páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a Pesquisa
        //Iniciei a Home chamando o método da HomePage
        home.doSearch(quest);
        System.out.println("Realizou a Pesquisa do Produto");

        // Validar a Pesquisa
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=search&orderby=position&orderway=desc&search_query=DRESS&submit_search=")));
        //O metodo Replace foi chamado para retirar as " do texto
        assertEquals(search.getTextLighter().replace("\"",""), quest);
        assertThat(search.getHeading_counter(), CoreMatchers.containsString(questResultQtd));
        System.out.println("Validou se o resultado da Pesquisa está correto");

        //Iniciar a Página do Produto Selecionado
        SelectProduct select = new SelectProduct();
        System.out.println("Acessou a Página do Produto escolhido");

        //Executar a ação de Mover o Mouse
        Browser.action.moveToElement(select.right_block).click(select.Button_more).perform();
        System.out.println("Acessou a Página de Detalhamento do Produto escolhido");

        //Validar a Página do Produto selecionado
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?id_product=1&controller=product&search_query=DRESS&results=7")));
        System.out.println("Validou se a Página do Produto escolhido está correta");
        assertThat(select.getNavigation_pipe(),CoreMatchers.containsString("Faded Short Sleeve T-shirts"));
        System.out.println("Validou se o título da Página está correto");
        // assertEquals(search.getTextLighter().replace("\"",""), quest);
        assertEquals(select.getOur_price_display().replace("$",""),"16.51");
        System.out.println("Validou se o Valor do Produto escolhido está correto");

        // Instanciar a Página da Compra do Produto que foi selecionado
        BuyProduct buyproduct = new BuyProduct();
        System.out.println("Acessou a página de Compra do Produto escolhido");

        // Ação de Escolher o tamanho do produto escolhido
        Browser.action.moveToElement(buyproduct.group_1).click(buyproduct.group_1).perform();
        System.out.println("Clicou no Combo de Seleção do Tamanho do Produto");
        Browser.action.moveToElement(buyproduct.group_1).click(buyproduct.group_1).perform();
        System.out.println("Selecionou o Tamanho do Produto Escolhido");

        //Ação de Selecionar a Cor do Produto Escolhido

        Browser.getCurrentDriver().findElement(By.id("color_14")).click();
        //String x = Browser.driver.getWindowHandle();
        //System.out.println(x);
        System.out.println("Selecionou a Cor do Produto");


        //Ação de Adicionar o produto no Carrinho
        Browser.action.moveToElement(buyproduct.buy_product).click().perform();
        //Browser.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"add_to_cart\"]/button")));
        System.out.println("Adicionou o Produto escolhido no Carrinho");

        //Validar a Tela de Confirmação da Compra
        //assertEquals(search.getTextLighter().replace("\"",""), quest);
        //assertTrue(Browser.getCurrentDriver().findElement(By.className("product-name")).getText().contains("Product successfully added to your shopping cart"));
        assertEquals(Browser.getCurrentDriver().findElement(By.className("clearfix")).getText(),"Product successfully added to your shopping cart");
        System.out.println("Mensagem Correta!");


        //Alterna para a nova Janela
        // GetWindowHandles retorna a lista de janelas
    }
}
