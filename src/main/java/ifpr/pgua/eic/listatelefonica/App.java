package ifpr.pgua.eic.listatelefonica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistry;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    public static final ScreenRegistry PRINCIPAL=new ScreenRegistry(App.class, "principal.fxml", o->new JanelaPrincipal());
    

    public static void main(String[] args) {
        launch();
    }

    @Override
    public ScreenRegistry getHomeFXML() {
        // TODO Auto-generated method stub
        return PRINCIPAL;
    }

    @Override
    public Parent getHomeParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Lista Telefônica";
    }

}