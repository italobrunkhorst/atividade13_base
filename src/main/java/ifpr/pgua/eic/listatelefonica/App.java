package ifpr.pgua.eic.listatelefonica;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistry;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;



/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    

    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Lista Telefônica";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL",new ScreenRegistryFXML(App.class, "principal.fxml", o->new JanelaPrincipal()));
    
    }

}