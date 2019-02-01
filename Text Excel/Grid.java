import java.util.*;
import java.io.*;

public class Grid extends GridBase{
   public int rows = 10;
   public int cols = 7;
   public int width = 9;
   
   public String processCommand(String input){
      if(input.contains("rows") || input.contains("cols") || input.contains("width")){
         return varController(input);
      }
      else if(input.equalsIgnoreCase("print")){
         return printGrid();
      }
   
      return input;
   }
   
   public String varController(String input){
      boolean isRows = false;
      boolean isCols = false;
      boolean isWidth = false;
      Scanner parser = new Scanner(input);
      String token = parser.next();
      if(token.equalsIgnoreCase("rows")){
         isRows = true;
      } 
      else if(token.equalsIgnoreCase("cols")){
         isCols = true;
      } 
      else if(token.equalsIgnoreCase("width")){
         isWidth = true;
      }
      if(parser.hasNext()){
         token = parser.next();
      }
      int changeVar = 0;
      if(token.equalsIgnoreCase("=") && parser.hasNext()){
         changeVar = Integer.parseInt(parser.next());
      } else if(isRows){
         return rows + "";
      } else if(isCols){
         return cols + "";
      } else if(isWidth){
         return width + "";
      }
      if(isRows){
         rows = changeVar;
      } else if(isCols){
         cols = changeVar;
      } else if(isWidth){
         width = changeVar;
      }
      return changeVar + "";
   }
   
   public String printGrid(){
      String gridString = "";
      char currentLetter = 'A';
      int rightSpaces = width / 2;
      for(int currentRows = 0; currentRows <= rows; currentRows++){
         if(currentRows != 0){
            gridString += charSomeTimes(' ', 1);
            gridString += String.format("%2d", currentRows);
            gridString += charSomeTimes(' ', 1);
         } 
         else {
            gridString += charSomeTimes(' ', 4);
         }
         gridString += "|";
         for(int columns = 0; columns < cols; columns++){
            gridString += charSomeTimes(' ', width / 2);
            if(currentRows == 0){
               gridString += currentLetter;
               currentLetter += 1;
            } 
            else {
               gridString += " ";
               
            }
            gridString += charSomeTimes(' ', rightSpaces - (width + 1) % 2);
            gridString += "|";
         
         }
         gridString += "\n";
         gridString += longLine();
         gridString += "\n";
      }
      return gridString;
   }
   
   public String charSomeTimes(char c, int times){
      String string = "";
      for(int x = 0; x < times; x++){
         string += c;
      }
      return string;
   }
   public String longLine(){
      String line = "";
      line += charSomeTimes('-', 4);
      line += "+";
      for(int columns = 0; columns < cols; columns++){
         line += charSomeTimes('-', width);
         line += "+";
      }
      return line;
   }
   
   public int digitsInNum(int num){
      int digits;
      if(num == 0){
         return 0;
      }
      
      for(digits = 0; num > 0; digits++){
         num /= 10;
      }
      
      return digits;
   }
}