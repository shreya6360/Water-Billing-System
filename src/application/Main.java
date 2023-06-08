package application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	Stage st;
	Scene scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage st) {
		
		 Dbconnection db=new Dbconnection();
		 Connection connectDb=db.getConnection();
		// TODO Auto-generated method stub
		GridPane root=new GridPane();
		Scene scene=new Scene(root,500,500);
		st.setScene(scene);
		root.setAlignment(Pos.CENTER);
		root.setVgap(10);   //set vertical gap
		root.setHgap(10);   //set horizontal gap
		root.setPadding(new Insets(10));
		Image img2=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/Water-Bills-Payment.jpg");
		BackgroundPosition bp=new BackgroundPosition(Side.LEFT,0,false,Side.TOP,0,false);
		BackgroundSize bs=new BackgroundSize(115,105,false,false,true,false);
		BackgroundImage bi1=new BackgroundImage(img2,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bp,bs);
		Background bg=new Background(bi1);
		root.setBackground(bg);
		Image img=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/login.jpg");
		ImageView view=new ImageView(img);
		view.setFitHeight(30);
		view.setPreserveRatio(true);
		Button b1=new Button("login");
		Label l4=new Label("click the login button to go to login page");
		b1.setTranslateX(50);
		b1.setTranslateY(25);
		b1.setGraphic(view);
		l4.setFont(Font.font("tahoma",FontWeight.BOLD,15));
		l4.setTextFill(Color.DARKRED);
		root.add(b1, 1, 3);
		root.add(l4, 1, 2);
		Image img1=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/download.png");
		ImageView view1=new ImageView(img1);
		view1.setFitHeight(30);
		view1.setPreserveRatio(true);
		Button b2=new Button("cancel");
		b2.setTranslateX(50);
		b2.setTranslateY(25);
		b2.setGraphic(view1);
		root.add(b2, 1, 4 );
		b1.setOnAction(ae->{
			st.setScene(scene2);
			st.setTitle("Login Form");
			st.setFullScreen(true);
			});
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
			Button sub=new Button("submit");
		GridPane.setHalignment(sub,HPos.RIGHT);
		GridPane root2=new GridPane();
		Image img3=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/360_F_122719641_V0yw2cAOrfxsON3HeWi2Sf4iVxhv27QO.jpg");
		BackgroundPosition bp1=new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,false);
		BackgroundSize bs1=new BackgroundSize(115,105,false,false,true,false);
		BackgroundImage bi11=new BackgroundImage(img3,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bp1,bs1);
		Background bg1=new Background(bi11);
		root2.setBackground(bg1);
		Text t1=new Text("WATER BILLING SYSTEM");
		t1.setFont(Font.font("tahoma",FontWeight.BOLD,25));
		t1.setFill(Color.BLUE);
		t1.setUnderline(true);
		t1.setStrokeWidth(2);
		t1.setStroke(Color.ALICEBLUE);
		root2.add(t1, 0, 0);
		
		Label l1=new Label("USERNAME");
		l1.setFont(Font.font("tahoma",FontWeight.BOLD,25));
		l1.setTextFill(Color.ALICEBLUE);
		root2.add(l1, 0,1 );
		
		TextField tf1=new TextField();
		tf1.setPromptText("username");
		root2.add(tf1, 1, 1);
		
		Label l2=new Label("PASSWORD");
		l2.setFont(Font.font("tahoma",FontWeight.BOLD,25));
		l2.setTextFill(Color.ALICEBLUE);
		root2.add(l2, 0, 2);
		
		PasswordField pf1=new PasswordField();
		pf1.setPromptText("password");
		root2.add(pf1, 1, 2);
		root2.add(sub,4, 5);
		scene2=new Scene(root2,500,500);
		st.setScene(scene2);
		root2.setAlignment(Pos.CENTER);
		root2.setVgap(10);   //set vertical gap
		root2.setHgap(10);   //set horizontal gap
		root2.setPadding(new Insets(10));
		st.show();
		sub.setOnAction(ae->{
			st.setScene(scene3);
			st.setTitle("menu form");
			st.setFullScreen(true);
			});
		sub.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent as) {
				if(tf1.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR,root2.getScene().getWindow(),"login error!","please enter your username");
					return;
					}
				if(pf1.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR,root2.getScene().getWindow(),"login error!","please enter your password");
					return;
					}
			MenuBar m1=new MenuBar();
			Menu master=new Menu("master");
			MenuItem newcustomer = new MenuItem("new customer"); 
			MenuItem cus = new MenuItem("customer detail"); 
			MenuItem dep = new MenuItem("deposite detail"); 
			master.getItems().addAll(newcustomer,cus,dep, new SeparatorMenuItem());
			Menu user=new Menu("user");
			Menu paybill = new Menu("paybill"); 
			MenuItem pen = new MenuItem("pending amount"); 
			MenuItem cer = new MenuItem("current bill"); 
			paybill.getItems().addAll(pen,cer);
			MenuItem cal = new MenuItem("calculate bill"); 
			MenuItem last = new MenuItem("last bill"); 
			user.getItems().addAll(paybill,cal,last, new SeparatorMenuItem());
			Menu report=new Menu("report");
			MenuItem gen = new MenuItem("generating bill");  
			report.getItems().addAll(gen,new SeparatorMenuItem());
			Menu exit=new Menu("exit");
			MenuItem ex = new MenuItem("exits"); 
			exit.getItems().addAll(ex,new SeparatorMenuItem());
			m1.getMenus().add(master);
			m1.getMenus().add(user);
			m1.getMenus().add(report);
			m1.getMenus().add(exit);
			BorderPane root3=new BorderPane();
			Image img4=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/nS6VsI.jpg");
			BackgroundPosition bp2=new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,false);
			BackgroundSize bs2=new BackgroundSize(115,105,false,false,true,false);
			BackgroundImage bi12=new BackgroundImage(img4,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bp2,bs2);
			Background bg2=new Background(bi12);
			root3.setBackground(bg2);
			scene3=new Scene(root3,500,500);
			root3.setTop(m1);
			st.setScene(scene3);
			st.setWidth(500);
			st.setHeight(500);
			st.setTitle("MENU LIST OF WATER BILL");
			root3.setPadding(new Insets(10));
			st.show();
			newcustomer.setOnAction(ae1->{
				st.setScene(scene4);
				st.setTitle("add new customer");
				st.setFullScreen(true);
				});
			newcustomer.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent a9) {
					st.setTitle("add customer");
					GridPane root4=new GridPane();
					Text t2=new Text("Enter your Details");
					t2.setFont(Font.font("tahoma",FontWeight.BOLD,25));
					t2.setFill(Color.BLUE);
					t2.setUnderline(true);
					t2.setStrokeWidth(2);
					t2.setTextAlignment(TextAlignment.CENTER);
					t2.setStroke(Color.ALICEBLUE);
					root4.add(t2, 0, 0);
					Label l3=new Label("NAME:");
					l3.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l3, 0,1 );
					TextField tf3=new TextField();
					tf3.setPrefHeight(20);
					tf3.setPromptText("username");
					root4.add(tf3, 1, 1);
					Label l4=new Label("METER NO:");
					l4.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l4, 0, 2);
					TextField tf4=new TextField();
					tf4.setPromptText("meter no");
					root4.add(tf4, 1, 2);
					Label l5=new Label("ADDRESS:");
					l5.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l5, 0, 3);
					TextField tf5=new TextField();
					tf5.setPromptText("address");
					root4.add(tf5, 1, 3);
					Label l6=new Label("STATE:");
					l6.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l6, 0, 4);
					TextField tf6=new TextField();
					tf6.setPromptText("state");
					root4.add(tf6, 1, 4);
					Label l7=new Label("CITY:");
					l7.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l7, 0, 5);
					TextField tf7=new TextField();
					tf7.setPromptText("city");
					root4.add(tf7, 1, 5);
					Label l8=new Label("EMAIL:");
					l8.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l8, 0, 6);
		            TextField tf8=new TextField();
					tf8.setPromptText("email");
					root4.add(tf8, 1, 6);
					Label l9=new Label("PHONE NO.:");
					l9.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root4.add(l9, 0, 7);
					TextField tf9=new TextField();
					tf9.setPromptText("phone no");
					root4.add(tf9, 1, 7);
					Button sub2=new Button("submit");
					sub2.setPrefHeight(40);
					sub2.setDefaultButton(true);
					sub2.setPrefWidth(100);
					root4.add(sub2, 0, 9, 1, 1);
					GridPane.setHalignment(sub2,HPos.LEFT);
					GridPane.setMargin(sub2,new Insets(20, 0,20,0));
					sub2.setTranslateX(50);
					sub2.setTranslateY(25);
					Button sub3=new Button("cancel");
					sub3.setPrefHeight(40);
					sub3.setDefaultButton(true);
					sub3.setPrefWidth(100);
					root4.add(sub3, 0, 9, 1, 1);
					GridPane.setHalignment(sub3,HPos.RIGHT);
					GridPane.setMargin(sub3,new Insets(20, 0,20,0));
					sub2.setTranslateX(50);
					sub2.setTranslateY(25);
					sub3.setTranslateX(50);
					sub3.setTranslateY(25);
					sub2.setOnAction(ae->{
						st.setScene(scene6);
						st.setTitle("add new customer to database");
						st.setFullScreen(true);
						});
					sub2.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent ad) {
							try {    
									 System.out.println("Connected with database succefully.");
									 System.out.println("inserting record into the table:");
									 String query="insert into customers2(name,meter_no,address,state,city,email,phone_no)values(?,?,?,?,?,?,?)";
									 PreparedStatement ps=connectDb.prepareStatement(query);
									 ps.setString(1,tf3.getText());
									 ps.setString(2,tf4.getText());
									 ps.setString(3,tf5.getText());
									 ps.setString(4,tf6.getText());
									 ps.setString(5,tf7.getText());
									 ps.setString(6,tf8.getText());
									 ps.setString(7,tf9.getText());
									 ps.execute();
									 System.out.println("data inserted successfully");
									 
							     }
						 catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						}
							 
						});
					sub3.setOnAction(ae->{
						st.setScene(scene9);
						st.setTitle("delete the customer");
						st.setFullScreen(true);
						});
					sub3.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent adel) {
			             try {
			            	 System.out.println("Connected with database succefully.");
			                 String query1 = "delete from  customers2 " +
			                         "where meter_no=1003";
			                 PreparedStatement ps=connectDb.prepareStatement(query1);
			                 ps.execute();
			                 System.out.println("Record is deleted from the table successfully..................");
			             }
			             catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
			             System.out.println("Please check it in the MySQL Table. Record is now deleted.......");
						}

			             });
					Scene scene4=new Scene(root4,500,500);
					st.setScene(scene4);
					root4.setAlignment(Pos.CENTER);
					root4.setVgap(10);   //set vertical gap
					root4.setHgap(10);   //set horizontal gap
					root4.setPadding(new Insets(40,40,40, 40));
					Image img6=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/Male-user-add-icon.png");
					BackgroundPosition bp3=new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,false);
					BackgroundSize bs3=new BackgroundSize(50,50,false,false,true,false);
					BackgroundImage bi13=new BackgroundImage(img6,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bp3,bs3);
					Background bg3=new Background(bi13);
					root4.setBackground(bg3);
					st.show();
				}	
			});
			gen.setOnAction(agen->{
				st.setScene(scene10);
				st.setTitle("update the customer detail");
				st.setFullScreen(true);
				});
			gen.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent agen) {
	             try {
	            	 System.out.println("Connected with database succefully.");
	            	 String query2 = "update customers2 set Name='shreya' " + "where meter_no in(1003)";
	            	 PreparedStatement ps=connectDb.prepareStatement(query2);
	            	 ps.execute();
	            	 System.out.println("Record has been updated in the table successfully..................");
	             }
	             catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	             System.out.println("Please check it in the MySQL Table. Record is now updated.......");
				}
			});
			cal.setOnAction(ae2->{
				st.setScene(scene5);
				st.setTitle("calculate bill");
				st.setFullScreen(true);
				});
			cal.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ab) {
					st.setTitle(" cal bill");
					GridPane root5=new GridPane();
					Text tc=new Text("Calculating WATER bill");
					tc.setFont(Font.font("tahoma",FontWeight.BOLD,25));
					tc.setFill(Color.BLUE);
					tc.setUnderline(true);
					tc.setStrokeWidth(2);
					tc.setTextAlignment(TextAlignment.CENTER);
					tc.setStroke(Color.ALICEBLUE);
					root5.add(tc, 0, 0);
					Label lc=new Label("METER NO:");
					lc.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root5.add(lc, 0, 1);
					ComboBox<String> cm1=new ComboBox<String>();
					cm1.setPromptText("Select Meter number");
					ObservableList<String> list=cm1.getItems();
					list.add("1001");
					list.add("1002");
					list.add("1003");
					list.add("1004");
					list.add("1005");
					list.add("1005");
					list.add("1006");
					list.add("1007");
					list.add("1008");
					list.add("1009");
					list.add("1010");
					root5.add(cm1, 1, 1);
					Label lc2=new Label("MONTH:");
					lc2.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root5.add(lc2, 0, 3);
					ComboBox<String> cm2=new ComboBox<String>();
					cm2.setPromptText("Select Month");
					ObservableList<String> list1=cm2.getItems();
					list1.add("Jan");
					list1.add("Feb");
					list1.add("March");
					list1.add("Apr");
					list1.add("May");
					list1.add("Jun");
					list1.add("Jul");
					list1.add("Aug");
					list1.add("Sep");
					list1.add("Oct");
					list1.add("Nov");
					list1.add("DEC");
					root5.add(cm2, 1, 3);
					Label lc3=new Label("UNIT CONSUMED:");
					lc3.setFont(Font.font("tahoma",FontWeight.BOLD,15));
					root5.add(lc3, 0, 5);
					TextField tfc1= new TextField();
					tfc1.setPrefHeight(50);
					root5.add(tfc1, 1, 5);
					Button bc1=new Button("submit");
					bc1.setPrefHeight(40);
					bc1.setDefaultButton(true);
					bc1.setPrefWidth(100);
					root5.add(bc1, 0, 9, 1, 1);
					GridPane.setHalignment(bc1,HPos.LEFT);
					GridPane.setMargin(bc1 ,new Insets(20, 0,20,0));
					bc1.setTranslateX(50);
					bc1.setTranslateY(25);
					Button bc2=new Button("cancel");
					bc2.setPrefHeight(40);
					bc2.setDefaultButton(true);
					bc2.setPrefWidth(100);
					root5.add(bc2, 0, 9, 1, 1);
					GridPane.setHalignment(bc2,HPos.RIGHT);
					GridPane.setMargin(bc2 ,new Insets(20, 0,20,0));
					bc1.setTranslateX(50);
					bc1.setTranslateY(25);
					bc2.setTranslateX(50);
					bc2.setTranslateY(25);
					Scene scene5=new Scene(root5,500,500);
					st.setScene(scene5);
					root5.setAlignment(Pos.CENTER);
					root5.setVgap(20);   //set vertical gap
					root5.setHgap(20);   //set horizontal gap
					root5.setPadding(new Insets(40,40,40, 40));
					Image imgcal=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/blue-water-drop-cartoon-character-260nw-1316614763.webp");
					BackgroundPosition bp9=new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,false);
					BackgroundSize bs9=new BackgroundSize(10,10,false,false,true,false);
					BackgroundImage bi19=new BackgroundImage(imgcal,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bp9,bs9);
					Background bg9=new Background(bi19);
					root5.setBackground(bg9);
				    st.show();
				    
					
				}
		 });
			
			cer.setOnAction(acer2->{
				st.setScene(scene7);
				st.setTitle("current bill amount");
				st.setFullScreen(true);
				});
			cer.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent acer) {
					st.setTitle(" current bill amount");
					GridPane root6=new GridPane();
					Scene scene7=new Scene(root6,500,500);
					st.setScene(scene7);
					root6.setAlignment(Pos.CENTER);
					root6.setVgap(10);   //set vertical gap
					root6.setHgap(10);   //set horizontal gap
					root6.setPadding(new Insets(10));
					Label lcer=new Label("the current bill amount of rama is $550");
					lcer.setFont(Font.font("tahoma",FontWeight.EXTRA_BOLD,25));
					root6.add(lcer, 0, 1);
					Image imgcer=new Image("C:\\Users\\shrey\\OneDrive\\Desktop\\shreya/360_F_243682875_3k9RkqNlGFKS0CyP4AvOrbhXeOM3awdU.jpg");
					BackgroundPosition bcer=new BackgroundPosition(Side.RIGHT,0,false,Side.TOP,0,false);
					BackgroundSize bser=new BackgroundSize(5,5,false,false,true,false);
					BackgroundImage bi1cer=new BackgroundImage(imgcer,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bcer,bser);
					Background bgcer=new Background(bi1cer);
					root6.setBackground(bgcer);
					st.show();
				}
					
				});
			
			}

			public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
			
			});
		
		}
	});
		st.show();
		
     }
    
}		