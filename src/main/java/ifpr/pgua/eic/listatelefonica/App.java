package ifpr.pgua.eic.listatelefonica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaCadastro;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaLista;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.models.FabricaConexoes;
import ifpr.pgua.eic.listatelefonica.models.ListaTelefonica;
import ifpr.pgua.eic.listatelefonica.models.daos.ContatoDAO;
import ifpr.pgua.eic.listatelefonica.models.daos.JDBCContatoDAO;
import ifpr.pgua.eic.listatelefonica.models.repositories.ContatoRepository;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistry;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private ListaTelefonica listaTelefonica;

    private FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
    private ContatoDAO contatoDAO;
    private ContatoRepository contatoRepository;

    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();

        listaTelefonica = new ListaTelefonica();

        contatoDAO = new JDBCContatoDAO(fabricaConexoes);
        contatoRepository = new ContatoRepository(contatoDAO);
    }

    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        return "Lista Telefônica";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "fxml/principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTRO", new ScreenRegistryFXML(App.class, "fxml/cadastro.fxml", o->new JanelaCadastro(contatoRepository)));
        registraTela("LISTA", new ScreenRegistryFXML(App.class, "fxml/listar.fxml", o->new JanelaLista(listaTelefonica)));
        
    }

    @Override
    public void atualizaEstilo() {
        adicionarArquivoEstilo(getClass().getResource("css/estilo.css").toExternalForm());
    }
    


    

}