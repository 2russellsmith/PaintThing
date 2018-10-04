// Assignment #: Arizona State University CSE205 #7
//         Name: Your Name
//    StudentID: Your ID
//      Lecture: Your lecture time (e.g., MWF 9:40am)
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle or a Circle with different
//               colors. We can also use the the two buttons to erase the last
//				 drawn shape or clear them all.

//import any classes necessary here
//----
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class DrawPane extends BorderPane
{
   private Button undoBtn, eraseBtn;
   private ComboBox<String> colorCombo;
   private RadioButton rbRect, rbCircle;
   private ArrayList<Shape> shapeList;
   private Pane canvas;
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

      //Create the color comboBox and intial its default color
      //----

      //Create the two radio buttons and also a ToggleGroup
      //so that the two radio buttons can be selected
      //mutually exclusively. Otherwise they are indepedant of each other
      //----

      //initialize shapeList, it is a data structure we used
      //to track the shape we created
      //----

      //canvas is a Pane where we will draw rectagles and circles on it
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: beige;");

      //initialize the remaining instance variables and set up
      //the layout
      //----
      //----

      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      //----
      //----


    }

   //Step #2(A) - MouseHandler
   private class MouseHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent event)
      {
		 //handle MouseEvent here
		 //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
		 //to check whether the mouse key is pressed, dragged or released
		 //write your own codes here
		 //----





      }//end handle()
   }//end MouseHandler

   //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your codes here
		  //----



      }
   }//end ButtonHandler

   //Step #2(C)- A handler class used to handle events from the two radio buttons
   private class ShapeHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your own codes here
		  //----



      }
   }//end ShapeHandler

   //Step #2(D)- A handler class used to handle colors from the combo box
   private class ColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your own codes here
		  //----

      }
   }//end ColorHandler

}//end class DrawPane