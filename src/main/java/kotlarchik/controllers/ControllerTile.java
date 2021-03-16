package kotlarchik.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kotlarchik.model.EntityCities;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControllerTile {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    private ImageView imageView;
    @FXML
    private Label labelTitle;
    @FXML
    private Label label2;
    @FXML
    private Label label3;

    public void initData(EntityCities entityCities){
        imageView.setImage(new Image(entityCities.getImagePath()));
        labelTitle.setText(entityCities.getName());
        label2.setText("День: " + entityCities.getRateDay());
        label3.setText("Ночь: " + entityCities.getRateNight());
    }
}
