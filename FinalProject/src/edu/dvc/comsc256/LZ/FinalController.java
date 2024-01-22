//Lewis Zeitman, ID: 1146317
package edu.dvc.comsc256.LZ;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

public class FinalController {
	private ArrayList<String> toSend;
	private ArrayList<ImageView> toSendImg;
	private FinalModel theModel;
	private FinalView theView;
	
	public FinalController(FinalView theView, FinalModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		//get the unformatted menu and store it in toSend
		this.toSend = theModel.fetchMenu();
		//get images
		this.toSendImg = theModel.getImages();
		//send the unformatted menu to get formatted and displayed by view
		theView.copyMenu(toSend, toSendImg);
		theView.formatMenu(toSend, toSendImg);
		
		this.theView.a1CartListener(new a1Listener());
		this.theView.a1RCartListener(new a1RListener());
		this.theView.a2CartListener(new a2Listener());
		this.theView.a2RCartListener(new a2RListener());
		this.theView.a3CartListener(new a3Listener());
		this.theView.a3RCartListener(new a3RListener());
		
		this.theView.d1CartListener(new d1Listener());
		this.theView.d1RCartListener(new d1RListener());
		this.theView.d2CartListener(new d2Listener());
		this.theView.d2RCartListener(new d2RListener());
		this.theView.d3CartListener(new d3Listener());
		this.theView.d3RCartListener(new d3RListener());
		
		this.theView.p1CartListener(new p1Listener());
		this.theView.p1RCartListener(new p1RListener());
		this.theView.p2CartListener(new p2Listener());
		this.theView.p2RCartListener(new p2RListener());
		this.theView.p3CartListener(new p3Listener());
		this.theView.p3RCartListener(new p3RListener());
		
		this.theView.p4CartListener(new p4Listener());
		this.theView.p4RCartListener(new p4RListener());
		this.theView.p5CartListener(new p5Listener());
		this.theView.p5RCartListener(new p5RListener());
		this.theView.p6CartListener(new p6Listener());
		this.theView.p6RCartListener(new p6RListener());
		
		this.theView.s1CartListener(new s1Listener());
		this.theView.s1RCartListener(new s1RListener());
		this.theView.s2CartListener(new s2Listener());
		this.theView.s2RCartListener(new s2RListener());
		this.theView.s3CartListener(new s3Listener());
		this.theView.s3RCartListener(new s3RListener());
		
		this.theView.s4CartListener(new s4Listener());
		this.theView.s4RCartListener(new s4RListener());
		this.theView.s5CartListener(new s5Listener());
		this.theView.s5RCartListener(new s5RListener());
		this.theView.s6CartListener(new s6Listener());
		this.theView.s6RCartListener(new s6RListener());
		
		this.theView.orderListener(new orderListener());
	}
	
	private class a1Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(11, 1, "Calamari", 12.00, .87);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Calamari", 1);
		}
	}
	
	private class a1RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(11);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Calamari", 1);
		}
	}
	
	private class a2Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(12, 1, "Crab Cakes", 20.00, 1.45);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Crab Cakes", 1);
		}
	}
	
	private class a2RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(12);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Crab Cakes", 1);
		}
	}
	
	private class a3Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(13, 1, "Eggplant Parmigiana", 15.00, 1.08);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Eggplant Parmigiana", 1);
		}
	}
	
	private class a3RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(13);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Eggplant Parmigiana", 1);
		}
	}
	
	private class d1Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(21, 1, "Chardonnay", 12.00, .87);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Chardonnay", 1);
		}
	}
	
	private class d1RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(21);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Chardonnay", 1);
		}
	}
	
	private class d2Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(22, 1, "Limonata", 6.00, .43);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Limonata", 1);
		}
	}
	
	private class d2RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(22);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Limonata", 1);
		}
	}
	
	private class d3Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(23, 1, "Pepsi", 6.00, .43);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Pepsi", 1);
		}
	}
	
	private class d3RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(23);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Pepsi", 1);
		}
	}
	
	private class p1Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(31, 1, "Beef Lasagna", 22.00, 1.59);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Beef Lasagna", 1);
		}
	}
	
	private class p1RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(31);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Beef Lasagna", 1);
		}
	}
	
	private class p2Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(32, 1, "Fettucine Alfredo", 20.00, 1.45);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Fettucine Alfredo", 1);
		}
	}
	
	private class p2RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(32);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Fettucine Alfredo", 1);
		}
	}
	
	private class p3Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(33, 1, "Spaghetti with Meatballs", 17.00, 1.23);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Spaghetti with Meatballs", 1);
		}
	}
	
	private class p3RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(33);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Spaghetti with Meatballs", 1);
		}
	}
	
	private class p4Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(41, 1, "Margherita", 18.00, 1.30);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Margherita", 1);
		}
	}
	
	private class p4RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(41);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Margherita", 1);
		}
	}
	
	private class p5Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(42, 1, "Pepperoni", 22.00, 1.59);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Pepperoni", 1);
		}
	}
	
	private class p5RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(42);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Pepperoni", 1);
		}
	}
	
	private class p6Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(43, 1, "Sausage and Broccoli Rabe", 25.00, 1.81);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Sausage and Broccoli Rabe", 1);
		}
	}
	
	private class p6RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(43);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Sausage and Broccoli Rabe", 1);
		}
	}
	
	private class s1Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(51, 1, "Caesar", 12.00, .87);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Caesar", 1);
		}
	}
	
	private class s1RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(51);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Caesar", 1);
		}
	}
	
	private class s2Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(52, 1, "Mixed", 12.00, .87);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Mixed", 1);
		}
	}
	
	private class s2RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(52);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Mixed", 1);
		}
	}
	
	private class s3Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(53, 1, "Mediterranean", 12.00, .87);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Mediterranean", 1);
		}
	}
	
	private class s3RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(53);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Mediterranean", 1);
		}
	}

	private class s4Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(61, 1, "Roasted Salmon", 25.00, 1.81);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Roasted Salmon", 1);
		}
	}
	
	private class s4RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(61);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Roasted Salmon", 1);
		}
	}
	
	private class s5Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(62, 1, "Butternut Squash Ravioli", 16.00, 1.16);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Butternut Squash Ravioli", 1);
		}
	}
	
	private class s5RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(62);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Butternut Squash Ravioli", 1);
		}
	}
	
	private class s6Listener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.addItem(63, 1, "Pear and Prosciutto Pizza", 25.00, 1.81);
			theView.refreshAdd(theModel.returnCart());
			theView.addToCart("Pear and Prosciutto Pizza", 1);
		}
	}
	
	private class s6RListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.removeItem(63);
			theView.refreshAdd(theModel.returnCart());
			theView.removeFromCart("Pear and Prosciutto Pizza", 1);
		}
	}
	
	private class orderListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			theModel.clearCart();
			theView.complete();
		}
	}
}
