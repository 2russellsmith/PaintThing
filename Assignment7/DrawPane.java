// Assignment #: Arizona State University CSE205 #7
//         Name: Jon Bartlett
//    StudentID: 1215254430
//      Lecture: Lecture 3, M,W 6:00-7:15
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle or a Circle with different
//               colors. We can also use the the two buttons to erase the last
//				 drawn shape or clear them all.

//import any classes necessary here
//----
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Observable;
import java.util.SortedSet;

public class DrawPane extends BorderPane
{
   private Button undoBtn, eraseBtn;
   private ComboBox<String> comboBox;
   private ArrayList<Shape> shapeList;
   private Pane canvas;
   private Color color;
   private RadioButton rectangle;
   private RadioButton circle;
   private String shapeType;
   private Circle circleS;
   private Rectangle rectangleS;
   private String iD = "0";
   private int idHolder =0;
   //declare any other necessary instance variables here
   //----

   //Constructor
   public DrawPane()
   {
      //Step #1: initialize each instance variable and set up layout
      undoBtn = new Button("Undo");
      eraseBtn = new Button("Erase");
      undoBtn.setMinWidth(80.0);
      eraseBtn.setMinWidth(80.0);
      //creates the needed buttons

       VBox vpane = new VBox();
       HBox hpane = new HBox();
       //crceates the pans i am going to use

      //Create the color comboBox and intial its default color
      ObservableList<String> comboList= FXCollections.observableArrayList("Black", "Blue", "Green","Red","Yellow","Orange","Pink");

      comboBox = new ComboBox(FXCollections.observableArrayList(comboList));
      comboBox.getSelectionModel().select(0);
        //creates the cocmbo box

      hpane.getChildren().add(undoBtn);
      hpane.getChildren().add(eraseBtn);
      hpane.setSpacing(25);
      hpane.setPadding(new Insets(10,10,20,200));
      //sets up the hpane

       ToggleGroup toggleGroup = new ToggleGroup();

       rectangle = new RadioButton();
       rectangle.setText("Rectangle");
       circle = new RadioButton();
       circle.setText("Circle");
       rectangle.setToggleGroup(toggleGroup);
       circle.setToggleGroup(toggleGroup);
       //sets up the RadioButtons and their toggle group

       vpane.getChildren().add(comboBox);
       vpane.getChildren().add(rectangle);
       vpane.getChildren().add(circle);
       vpane.setSpacing(40);
       vpane.setPadding(new Insets(10,10,10,10));
       //adds the components to the vpane

      //canvas is a Pane where we will draw rectangles and circles on it
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: beige;");

      shapeList = new ArrayList<>();


      this.setCenter(canvas);
      this.setLeft(vpane);
      this.setBottom(hpane);
        //adds everything to the border pane
      // Registers the source nodes with its handler objects

      undoBtn.setOnAction(new ButtonHandler());
      eraseBtn.setOnAction(new ButtonHandler());
      comboBox.setOnAction(new ColorHandler());
      canvas.addEventHandler(MouseEvent.ANY, new MouseHandler());
      circle.setOnAction(new ShapeHandler());
      rectangle.setOnAction(new ShapeHandler());


    }

   //Step #2(A) - MouseHandler
   private class MouseHandler implements EventHandler<MouseEvent>
   {
       double shapeX,shapeY, shapeWidth, shapeHeight, radius;



      public void handle(MouseEvent event) {
          if (circle.isSelected()){
          if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
              System.out.println("Registered");
              shapeWidth =event.getX();
              shapeHeight =event.getY();
              radius =0;
              circleS = new Circle(event.getX(),event.getY(),radius,color);
              canvas.getChildren().add(idHolder,circleS);
          }
          if (event.getEventType() == MouseEvent.MOUSE_DRAGGED){
          shapeX = event.getX();
          shapeY = event.getY();
          radius =((shapeX -shapeWidth)*(shapeY -shapeHeight)/100);
          circleS.setRadius(radius);
          circleS.setFill(Color.WHITE);
          circleS.setStroke(Color.BLACK);


      }
          if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
              System.out.println("Object Created");
              circleS.setFill(color);
              shapeList.add(circleS);
              idHolder ++;

      }
          }
          else if (rectangle.isSelected()){
              if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
                  System.out.println("Registered");
                  shapeWidth =event.getX();
                  shapeHeight =event.getY();
                  radius =0;
                  rectangleS = new Rectangle(event.getX(),event.getY(),0,0);
                  canvas.getChildren().add(idHolder,rectangleS);
                  idHolder ++;
              }
              if (event.getEventType() == MouseEvent.MOUSE_DRAGGED){
                  shapeX = event.getX();
                  shapeY = event.getY();
                  rectangleS.setWidth(shapeX/2);
                  rectangleS.setHeight(shapeY/2);
                  rectangleS.setFill(Color.WHITE);
                  rectangleS.setStroke(Color.BLACK);

              }
              if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                  System.out.println("Object Created");
                  rectangleS.setFill(color);
                  shapeList.add(rectangleS);
              }
          }
      }
          }


   //end MouseHandler

   //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
          if (event.getSource() == eraseBtn){

              if (idHolder >0){
              do {
                  canvas.getChildren().remove(0);
                  idHolder --;
                  System.out.println(idHolder);
              }
              while (0<idHolder);}
          }
          else if(event.getSource() == undoBtn){
              canvas.getChildren().remove(idHolder-1);
              if (idHolder>0){
                  idHolder--;
              }
          }
		  //write your codes here
		  //----



      }
   }//end ButtonHandler

   //Step #2(C)- A handler class used to handle events from the two radio buttons
   private class ShapeHandler implements EventHandler<ActionEvent>

   {
      public void handle(ActionEvent event)
      {
          if (event.getSource() == circle){
              System.out.println("Circle");
              shapeType = "Circle";
          }
          else if (event.getSource() == rectangle){
              System.out.println("Rectangle");
              shapeType = "Rectangle";
          }

      }

   }//end ShapeHandler

   //Step #2(D)- A handler class used to handle colors from the combo box
   private class ColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
          try {
              if (comboBox.getValue().equalsIgnoreCase("Black")) {
                  color = Color.BLACK;
              } else if (comboBox.getValue().equalsIgnoreCase("Blue")) {
                  color = Color.BLUE;
              } else if (comboBox.getSelectionModel().getSelectedIndex() == 2) {
                  color = Color.GREEN;
              } else if (comboBox.getSelectionModel().getSelectedIndex() == 3) {
                  color = Color.RED;
              } else if (comboBox.getSelectionModel().getSelectedIndex() == 4) {
                  color = Color.YELLOW;
              } else if (comboBox.getSelectionModel().getSelectedIndex() == 5) {
                  color = Color.ORANGE;
              } else if (comboBox.getSelectionModel().getSelectedIndex() == 6) {
                  color = Color.PINK;
              } else if (comboBox.getValue().equals(null)) {
                  System.out.println("Null");
              }
              }

          catch(NullPointerException e){
                  System.out.println("Null");
              }
              }
      }
   }//end ColorHandler

//end class DrawPane