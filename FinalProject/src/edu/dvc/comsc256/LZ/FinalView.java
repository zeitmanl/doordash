//Lewis Zeitman, ID: 1146317
package edu.dvc.comsc256.LZ;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class FinalView {
	ArrayList<Button> cartBs = new ArrayList<Button>();
    ArrayList<Button> cartRBs = new ArrayList<Button>();
	ArrayList<ImageView> images = new ArrayList<ImageView>();
	ArrayList<String> items = new ArrayList<String>();
	private Button a1, a2, a3, d1, d2, d3, p1, p2, p3, p4, p5, p6, s1, s2, s3, s4, s5, s6;
	private Button a1R, a2R, a3R, d1R, d2R, d3R, p1R, p2R, p3R, p4R, p5R, p6R, s1R, s2R, s3R, s4R, s5R, s6R;
	private Button order;
	private GridPane mainMenu;
	private GridPane cartGrid;
	private HashMap<String, Integer> cartContents = new HashMap<String, Integer>();
	private int yCount = 0;
	private Scene scene;
	private Text menuStuff = new Text("");
	private Text showCart = new Text("");
	private TextFlow header;
	private VBox body;
	
	public FinalView() {
		BorderPane root = new BorderPane();
		
	    HBox toolbar = new HBox();
	    Image banner = new Image("file:content/images/resources/banner.jpg", 600, 150, false, false);
	    ImageView bannerIV = new ImageView(banner);
	    toolbar.getChildren().add(bannerIV);
	    toolbar.setAlignment(Pos.CENTER);
	    toolbar.setPadding(new Insets(15, 0, 15, 0));
	    
	    ScrollPane content = new ScrollPane();
	    content.setPrefSize(800, 400);
	    content.setPadding(new Insets(15, 15, 15, 15));
	    
	    body = new VBox();

	    mainMenu = new GridPane();
	    mainMenu.setVgap(20);
		mainMenu.setHgap(20);
	    
	    header = new TextFlow();
	    
	    Text name = new Text("Pizza Italiano");
	    name.setFont(Font.font ("Helvetica", FontWeight.BOLD, 50));
	    
	    Text hours = new Text("\nOpen Monday thru Friday from 11AM to 9PM");
	    
	    Text desc = new Text("\n\nAre you sick of the same old meals? "
	    		+ "\nLocals have made Pizza Italiano one of the most popular restaurants in town. "
	    		+ "\nTry some of their offerings and see if you agree!\n\n\n");
	    desc.setFont(Font.font ("Helvetica", 15));
	    
	    Text menuText = new Text("Menu");
	    menuText.setFont(Font.font ("Helvetica", FontWeight.BOLD, 30));
	    
	    Text menuHeader = new Text("\n\nAppetizers\t    Drinks\tPasta\tPizza\tSalad\tSpecials\tCart");
	    menuHeader.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    
	    header.getChildren().addAll(name, hours, desc, menuText, menuHeader);
	    
	    Separator sep = new Separator();
	    sep.setPadding(new Insets(5, 0, 5, 0));
	    
	    VBox menuCon = new VBox();
	    
	    cartGrid = new GridPane();
	    
	    //Order Area
	    HBox orderGrid = new HBox();
	    Separator sep1 = new Separator();
	    sep1.setPadding(new Insets(5, 0, 5, 0));
	    order = new Button("Place Order");
	    orderGrid.getChildren().addAll(sep1, order);
	    orderGrid.setAlignment(Pos.CENTER);
	    orderGrid.setPadding(new Insets(15, 0, 15, 0));
	    
	    body.getChildren().addAll(header, sep, menuCon, menuStuff, mainMenu, cartGrid, orderGrid);
	    
	    content.setContent(body);
	    
	    root.setTop(toolbar);
	    root.setCenter(content);

    	scene = new Scene(root, 850, 600);	
    }
    
	public Scene getScene() {
		return scene;
	}
	
	public void formatMenu(ArrayList<String> t, ArrayList<ImageView> m) {
	    //Apps
	    TextFlow appsHead = new TextFlow();
	    Text apps = new Text("Appetizers");
	    apps.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    apps.setUnderline(true);
	    appsHead.getChildren().add(apps);
	    mainMenu.add(appsHead, 0, yCount);
	    
	    a1 = new Button("Add to Cart");
	    a2 = new Button("Add to Cart");
	    a3 = new Button("Add to Cart");
	    a1R = new Button("Remove");
	    a2R = new Button("Remove");
	    a3R = new Button("Remove");
	    cartBs.add(a1);
	    cartBs.add(a2);
	    cartBs.add(a3);
	    cartRBs.add(a1R);
	    cartRBs.add(a2R);
	    cartRBs.add(a3R);
	    
	    yCount++;
		for (int i = 0; i < 3; i++) {
			mainMenu.add(m.get(i), 0, yCount);
			Label label = new Label(t.get(i));
			label.setWrapText(true);
			label.maxWidth(100);
			mainMenu.add(label, 1, yCount);
			mainMenu.add(cartBs.get(i), 2, yCount);
			mainMenu.add(cartRBs.get(i), 3, yCount);
			yCount++;
		}
		
		//Drinks
		TextFlow drinksHead = new TextFlow();
	    Text drinks = new Text("\nDrinks");
	    drinks.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    drinks.setUnderline(true);
	    drinksHead.getChildren().add(drinks);
	    mainMenu.add(drinksHead, 0, yCount);
	    yCount++;
	    d1 = new Button("Add to Cart");
	    d2 = new Button("Add to Cart");
	    d3 = new Button("Add to Cart");
	    d1R = new Button("Remove");
	    d2R = new Button("Remove");
	    d3R = new Button("Remove");
	    cartBs.add(d1);
	    cartBs.add(d2);
	    cartBs.add(d3);
	    cartRBs.add(d1R);
	    cartRBs.add(d2R);
	    cartRBs.add(d3R);
	    yCount++;
	    addSection(4, 7);
		
		//Pasta
		yCount++;
		TextFlow pastaHead = new TextFlow();
	    Text pasta = new Text("\nPasta");
	    pasta.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    pasta.setUnderline(true);
	    pastaHead.getChildren().add(pasta);
	    mainMenu.add(pastaHead, 0, yCount);
	    yCount++;
	    p1 = new Button("Add to Cart");
	    p2 = new Button("Add to Cart");
	    p3 = new Button("Add to Cart");
	    p1R = new Button("Remove");
	    p2R = new Button("Remove");
	    p3R = new Button("Remove");
	    cartBs.add(p1);
	    cartBs.add(p2);
	    cartBs.add(p3);
	    cartRBs.add(p1R);
	    cartRBs.add(p2R);
	    cartRBs.add(p3R);
	    yCount++;
		addSection(7, 10);
		
		//Pizza
		yCount++;
		TextFlow pizzaHead = new TextFlow();
	    Text pizza = new Text("\nPizza");
	    pizza.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    pizza.setUnderline(true);
	    pizzaHead.getChildren().add(pizza);
	    mainMenu.add(pizzaHead, 0, yCount);
	    yCount++;
	    p4 = new Button("Add to Cart");
	    p5 = new Button("Add to Cart");
	    p6 = new Button("Add to Cart");
	    p4R = new Button("Remove");
	    p5R = new Button("Remove");
	    p6R = new Button("Remove");
	    cartBs.add(p4);
	    cartBs.add(p5);
	    cartBs.add(p6);
	    cartRBs.add(p4R);
	    cartRBs.add(p5R);
	    cartRBs.add(p6R);
	    yCount++;
	    addSection(10, 13);
		
		//Salad
		yCount++;
		TextFlow saladHead = new TextFlow();
	    Text salad = new Text("\nSalad");
	    salad.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    salad.setUnderline(true);
	    saladHead.getChildren().add(salad);
	    mainMenu.add(saladHead, 0, yCount);
	    yCount++;
	    s1 = new Button("Add to Cart");
	    s2 = new Button("Add to Cart");
	    s3 = new Button("Add to Cart");
	    s1R = new Button("Remove");
	    s2R = new Button("Remove");
	    s3R = new Button("Remove");
	    cartBs.add(s1);
	    cartBs.add(s2);
	    cartBs.add(s3);
	    cartRBs.add(s1R);
	    cartRBs.add(s2R);
	    cartRBs.add(s3R);
	    yCount++;
	    addSection(13, 16);
		
		//Specials
		yCount++;
		TextFlow specialHead = new TextFlow();
	    Text special = new Text("\nSpecials");
	    special.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    special.setUnderline(true);
	    specialHead.getChildren().add(special);
	    mainMenu.add(specialHead, 0, yCount);
	    yCount++;
	    s4 = new Button("Add to Cart");
	    s5 = new Button("Add to Cart");
	    s6 = new Button("Add to Cart");
	    s4R = new Button("Remove");
	    s5R = new Button("Remove");
	    s6R = new Button("Remove");
	    cartBs.add(s4);
	    cartBs.add(s5);
	    cartBs.add(s6);
	    cartRBs.add(s4R);
	    cartRBs.add(s5R);
	    cartRBs.add(s6R);
	    yCount++;
	    addSection(16, 19);
		yCount++;
		
		//Cart
		TextFlow cartHead = new TextFlow();
	    Text cartHeader = new Text("\nCart");
	    cartHeader.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
	    cartHeader.setUnderline(true);
	    cartHead.getChildren().add(cartHeader);
	    mainMenu.add(cartHead, 0, yCount);
	    yCount++;
	    
	    cartGrid.add(showCart, 0, 0);
	}
	
	public void copyMenu(ArrayList<String> t, ArrayList<ImageView> m) {
		for (int i = 0; i < t.size(); i++) {
			items.add(t.get(i));
		}
		for (int i = 0; i < m.size(); i++) {
			images.add(m.get(i));
		}
	}
	
	public void addSection(int a, int b) {
		for (int i = a; i < b; i++) {
			mainMenu.add(images.get(i - 1), 0, yCount);
			Label label = new Label(items.get(i - 1));
			label.setWrapText(true);
			label.maxWidth(100);
			mainMenu.add(label, 1, yCount);
			mainMenu.add(cartBs.get(i - 1), 2, yCount);
			mainMenu.add(cartRBs.get(i - 1), 3, yCount);
			yCount++;
		}
	}
	
	public void addToCart(String name, int qty) {
		if (!cartContents.containsKey(name)) {
			cartContents.put(name, qty);
		} else {
			cartContents.put(name, cartContents.get(name) + 1);
		}
	}
	
	public void refreshAdd (String c) {
	    showCart.setText(c);
	}
	
	public void removeFromCart(String name, int qty) {
		if (cartContents.containsKey(name)) {
			if (cartContents.get(name) > 0) {
				cartContents.put(name, cartContents.get(name) - 1);
			}
		}
	}
	
	public void complete() {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setContentText("Your order has been placed!");
		a.show();
	}
	
	public void a1CartListener(EventHandler<ActionEvent> a1Listener) {
		a1.setOnAction(a1Listener);
	}
	
	public void a1RCartListener(EventHandler<ActionEvent> a1RListener) {
		a1R.setOnAction(a1RListener);
	}
	
	public void a2CartListener(EventHandler<ActionEvent> a2Listener) {
		a2.setOnAction(a2Listener);
	}
	
	public void a2RCartListener(EventHandler<ActionEvent> a2RListener) {
		a2R.setOnAction(a2RListener);
	}
	
	public void a3CartListener(EventHandler<ActionEvent> a3Listener) {
		a3.setOnAction(a3Listener);
	}
	
	public void a3RCartListener(EventHandler<ActionEvent> a3RListener) {
		a3R.setOnAction(a3RListener);
	}
	
	public void d1CartListener(EventHandler<ActionEvent> d1Listener) {
		d1.setOnAction(d1Listener);
	}
	
	public void d1RCartListener(EventHandler<ActionEvent> d1RListener) {
		d1R.setOnAction(d1RListener);
	}
	
	public void d2CartListener(EventHandler<ActionEvent> d2Listener) {
		d2.setOnAction(d2Listener);
	}
	
	public void d2RCartListener(EventHandler<ActionEvent> d2RListener) {
		d2R.setOnAction(d2RListener);
	}
	
	public void d3CartListener(EventHandler<ActionEvent> d3Listener) {
		d3.setOnAction(d3Listener);
	}
	
	public void d3RCartListener(EventHandler<ActionEvent> d3RListener) {
		d3R.setOnAction(d3RListener);
	}
	
	public void p1CartListener(EventHandler<ActionEvent> p1Listener) {
		p1.setOnAction(p1Listener);
	}
	
	public void p1RCartListener(EventHandler<ActionEvent> p1RListener) {
		p1R.setOnAction(p1RListener);
	}
	
	public void p2CartListener(EventHandler<ActionEvent> p2Listener) {
		p2.setOnAction(p2Listener);
	}
	
	public void p2RCartListener(EventHandler<ActionEvent> p2RListener) {
		p2R.setOnAction(p2RListener);
	}
	
	public void p3CartListener(EventHandler<ActionEvent> p3Listener) {
		p3.setOnAction(p3Listener);
	}
	
	public void p3RCartListener(EventHandler<ActionEvent> p3RListener) {
		p3R.setOnAction(p3RListener);
	}
	
	public void p4CartListener(EventHandler<ActionEvent> p4Listener) {
		p4.setOnAction(p4Listener);
	}
	
	public void p4RCartListener(EventHandler<ActionEvent> p4RListener) {
		p4R.setOnAction(p4RListener);
	}
	
	public void p5CartListener(EventHandler<ActionEvent> p5Listener) {
		p5.setOnAction(p5Listener);
	}
	
	public void p5RCartListener(EventHandler<ActionEvent> p5RListener) {
		p5R.setOnAction(p5RListener);
	}
	
	public void p6CartListener(EventHandler<ActionEvent> p6Listener) {
		p6.setOnAction(p6Listener);
	}
	
	public void p6RCartListener(EventHandler<ActionEvent> p6RListener) {
		p6R.setOnAction(p6RListener);
	}
	
	public void s1CartListener(EventHandler<ActionEvent> s1Listener) {
		s1.setOnAction(s1Listener);
	}
	
	public void s1RCartListener(EventHandler<ActionEvent> s1RListener) {
		s1R.setOnAction(s1RListener);
	}
	
	public void s2CartListener(EventHandler<ActionEvent> s2Listener) {
		s2.setOnAction(s2Listener);
	}
	
	public void s2RCartListener(EventHandler<ActionEvent> s2RListener) {
		s2R.setOnAction(s2RListener);
	}
	
	public void s3CartListener(EventHandler<ActionEvent> s3Listener) {
		s3.setOnAction(s3Listener);
	}
	
	public void s3RCartListener(EventHandler<ActionEvent> s3RListener) {
		s3R.setOnAction(s3RListener);
	}
	
	public void s4CartListener(EventHandler<ActionEvent> s4Listener) {
		s4.setOnAction(s4Listener);
	}
	
	public void s4RCartListener(EventHandler<ActionEvent> s4RListener) {
		s4R.setOnAction(s4RListener);
	}
	
	public void s5CartListener(EventHandler<ActionEvent> s5Listener) {
		s5.setOnAction(s5Listener);
	}
	
	public void s5RCartListener(EventHandler<ActionEvent> s5RListener) {
		s5R.setOnAction(s5RListener);
	}
	
	public void s6CartListener(EventHandler<ActionEvent> s6Listener) {
		s6.setOnAction(s6Listener);
	}
	
	public void s6RCartListener(EventHandler<ActionEvent> s6RListener) {
		s6R.setOnAction(s6RListener);
	}
	
	public void orderListener(EventHandler<ActionEvent> orderListener) {
		order.setOnAction(orderListener);
	}
}
