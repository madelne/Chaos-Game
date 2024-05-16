package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The type Home page.
 */
public class HomePage extends Application{
    private Stage homeStage;
    private final BorderPane root = new BorderPane();
    private ComboBox<String> fractalType;

    /**
     * Instantiates a new Home page.
     */
    public HomePage(){
        setMenu();
    }

    @Override
    public void start(Stage homeStage) {
        this.homeStage = homeStage;

        Scene scene = new Scene(root, 1000, 800);

        // Set up the stage
        homeStage.setTitle("Chaos Game");
        homeStage.setScene(scene);
        homeStage.show();
    }

    /**
     * Set menu.
     */
    public void setMenu(){
        String[] fractals = {"Affine2D", "Barnsley", "Julia", "Create new Affine transformation", "Create new Barnsley transformation", "Upload from files"};
        fractalType = new ComboBox<>(FXCollections.observableArrayList(fractals));

        Button chooseFractal = new Button("Choose fractal");
        chooseFractal.setOnAction(actionEvent -> {
            try {
                chooseFractalOnAction();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        HBox menu = new HBox(fractalType, chooseFractal);
        menu.setSpacing(50);
        HBox.setMargin(fractalType, new Insets(20, 10, 10, 20));
        HBox.setMargin(chooseFractal, new Insets(20, 10, 10, 20));
        root.setCenter(menu);
        BorderPane.setAlignment(menu, Pos.CENTER);

        Label header = new Label("Chaos Game");
        root.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);
    }

    /**
     * Choose fractal on action.
     *
     * @throws Exception the exception
     */
    public void chooseFractalOnAction() throws Exception {
        if(fractalType.getValue().equals("Julia")){
            JuliaPage juliaPage = new JuliaPage();
            juliaPage.start(homeStage);
        }
        if(fractalType.getValue().equals("Affine2D")){
            Affine2DPage affine2DPage = new Affine2DPage();
            affine2DPage.start(homeStage);
        }
        if(fractalType.getValue().equals("Barnsley")){
            BarnsleyPage barnsleyPage = new BarnsleyPage();
            barnsleyPage.start(homeStage);
        }
        if(fractalType.getValue().equals("Create new Affine transformation")){
            CreateAffinePage createAffinePage = new CreateAffinePage();
            createAffinePage.start(homeStage);
        }
        if(fractalType.getValue().equals("Create new Barnsley transformation")){
            CreateBarnsleyPage createBarnsleyPage = new CreateBarnsleyPage();
            createBarnsleyPage.start(homeStage);
        }
        if (fractalType.getValue().equals("Upload from files")) {
            CreateUploadFilePage uploadPage = new CreateUploadFilePage();
            uploadPage.start(homeStage);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       HomePage.launch(args);
    }
}
