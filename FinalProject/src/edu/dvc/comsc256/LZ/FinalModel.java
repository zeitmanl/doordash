//Lewis Zeitman, ID: 1146317
package edu.dvc.comsc256.LZ;

import java.sql.*;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinalModel {
	private ArrayList<ImageView> images = new ArrayList<ImageView>();
	private ArrayList<String> items = new ArrayList<String>();
	private Connection myConn = null;
    private ResultSet resultSet = null;
    private String displayCart = "";
    private Statement myStmt = null;
    
    //retrieve menu from database
	public ArrayList<String> fetchMenu() {
		try {
			//change this to scott/tiger
        	myConn = DriverManager.getConnection(""
        			+ "jdbc:mysql://localhost:3306/menu?user=root&password=root");
        	myStmt = myConn.createStatement();

        	String makeQ = "SELECT * FROM menu.menu;";
        	resultSet = myStmt.executeQuery(makeQ);
        	
        	while (resultSet.next()) {
        		String name = resultSet.getString(2);
        		String desc = resultSet.getString(3);
        		double cost = resultSet.getDouble(4);
        		String result = name + "\t\t" + "$" + cost + "0" + "\n" + desc + "\n";
        		
        		items.add(result);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return items;
	}
	
	//store thumbnails in arraylist
	public ArrayList<ImageView> getImages() {
		for (int i = 11; i < 14; i++) {
    		Image image = new Image("file:content/images/appetizers/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		for (int i = 21; i < 24; i++) {
    		Image image = new Image("file:content/images/drinks/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		for (int i = 31; i < 34; i++) {
    		Image image = new Image("file:content/images/pasta/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		for (int i = 41; i < 44; i++) {
    		Image image = new Image("file:content/images/pizza/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		for (int i = 51; i < 54; i++) {
    		Image image = new Image("file:content/images/salad/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		for (int i = 61; i < 64; i++) {
    		Image image = new Image("file:content/images/specials/" + i + ".jpg");
    		ImageView img = new ImageView(image);
    		images.add(img);
		}
		
		return images;
	}
	
	//add item to db
	public void addItem(int id, int qty, String name, double cost, double tax) {
		try {
        	myStmt = myConn.createStatement();
        	
        	String addQ = "INSERT into cart (id, qty, name, cost, tax, total, totalTax)\nvalues ("
        			+ id + ", " + qty + ", '" + name + "', " + cost + ", "
        			+ tax + ", " + (qty*cost) + ", " + (qty*tax) 
        		    + ")"
        			+ "\nON DUPLICATE KEY UPDATE qty = qty + 1, total = (qty*cost), totalTax = (qty*tax);";
        	
        	myStmt.executeUpdate(addQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//remove item from db
	public void removeItem(int i) {
		try {
        	myStmt = myConn.createStatement();
        	
        	String returnQ = "SELECT * FROM CART;";
        	resultSet = myStmt.executeQuery(returnQ);
        	
        	while (resultSet.next()) {
        		int id = resultSet.getInt(1);
        		int qty = resultSet.getInt(2);

        		if (id == i) {
        			if (qty > 0) {
        				subtractItem(i);
        			}
        		} else {
        			continue;
        		}
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		returnCart();
	}
	
	public void subtractItem(int itemId) {
		try {
			myStmt = myConn.createStatement();
			
			String updateQ = "UPDATE cart "
					+ "SET qty = qty - 1 WHERE ID = " + itemId + ";";
	        myStmt.executeUpdate(updateQ);
	        	
	        String updateTot = "UPDATE cart "
	        		+ "SET total = (qty*cost) WHERE ID = " + itemId + ";";
	        myStmt.executeUpdate(updateTot);
	        
	        String updateTax = "UPDATE cart "
	        		+ "SET totalTax = (qty*tax) WHERE ID = " + itemId + ";";
	        myStmt.executeUpdate(updateTax);
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//return cart from db
	public String returnCart() {
		displayCart = "";
		
		try {
        	myStmt = myConn.createStatement();
        	
        	String returnQ = "SELECT * FROM CART;";
        	resultSet = myStmt.executeQuery(returnQ);
        	
        	while (resultSet.next()) {
        		int qty = resultSet.getInt(2);
        		String name = resultSet.getString(3);
        		double cost = resultSet.getDouble(4);
        		
        		if(qty > 0) {
        			displayCart += name + " x" + qty + "\t\t" + "$" + cost + "0" + "\n";
        		}
        		
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		displayCart += "\n\nSubtotal: $" + returnTotal() + "0\nTax: $" + returnTax() + "\nTotal: $" + (returnTotal() + returnTax());
		
		return displayCart;
	}
	
	public double returnTax() {
		double totalTax = 0;

		try {
        	myStmt = myConn.createStatement();
        	
        	String returnTax = "SELECT SUM(totalTax) FROM cart;";
        	resultSet = myStmt.executeQuery(returnTax);
        	
        	while (resultSet.next()) {
        		totalTax = resultSet.getDouble(1);
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		String toSend = String.format("%.2f", totalTax);
		totalTax = Double.parseDouble(toSend);
		
		return totalTax;
	}
	
	public double returnTotal() {
		double retTotal = 0;
		try {
        	myStmt = myConn.createStatement();
        	
        	String returnTotal = "SELECT SUM(total) FROM cart;";
        	resultSet = myStmt.executeQuery(returnTotal);
        	
        	while (resultSet.next()) {
        		retTotal = resultSet.getDouble(1);
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return retTotal;
	}
	
	public void clearCart() {
		try {
        	myStmt = myConn.createStatement();
        	
        	String returnQ = "DELETE FROM CART;";
        	myStmt.executeUpdate(returnQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
