//Lewis Zeitman, ID: 1146317
package edu.dvc.comsc256.LZ;

import javafx.application.Application;
import javafx.stage.Stage;

public class MVCFinal extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
		FinalView theView = new FinalView();
		FinalModel theModel = new FinalModel();
		new FinalController(theView,theModel);
    	primaryStage.setTitle("Final Project");
    	primaryStage.setScene(theView.getScene());
    	primaryStage.show();
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
}
