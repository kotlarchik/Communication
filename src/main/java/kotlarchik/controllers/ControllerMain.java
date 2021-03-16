package kotlarchik.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import kotlarchik.dao.DAO;
import kotlarchik.model.EntityCities;
import kotlarchik.service.ServiceCities;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class ControllerMain {
    ObservableList<EntityCities> entityCities = FXCollections.observableArrayList();

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TilePane tilePane;

    private AnchorPane anchorPane;

    @FXML
    public void initialize() throws IOException {
        initDataBase();
        initCells();

    }

    private void initCells() throws IOException {
        for (EntityCities entityCities: entityCities){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Tile.fxml"));
            anchorPane = loader.load();

            ControllerTile controllerTile = loader.getController();
            controllerTile.initData(entityCities);

            tilePane.setHgap(15);
            tilePane.setVgap(15);
            tilePane.getChildren().add(anchorPane);
        }
    }

    private void initDataBase(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<EntityCities, Integer> DAOentityCities = new ServiceCities(factory);
        entityCities.addAll(DAOentityCities.readAll());
    }
}
