import java.util.*;
import java.io.*;

public class Grid extends GridBase{
   public int rows = 10;
   public int cols = 7;
   public int width = 9;
   
   public String processCommand(String input){
      if(input.equalsIgnoreCase("rows")){
         return rows + "";
      } 
      else if(input.equalsIgnoreCase("cols")){
         return cols + "";
      } 
      else if(input.equalsIgnoreCase("width")){
         return width + "";
      }
      
      if(input.equalsIgnoreCase("print")){
         return printGrid();
      }
   
      return input;
   }
   
   public String printGrid(){
      String gridString = "";
      char currentLetter = 'A';
      int rightSpaces = width / 2;
      for(int currentRows = 0; currentRows <= rows; currentRows++){
         int digits = digitsInNum(currentRows);
         if(currentRows != 0){
            gridString += charSomeTimes(' ', (rightSpaces - digits) / 2 + digits % 2);
            gridString += currentRows;
            gridString += charSomeTimes(' ', rightSpaces / 2 - 1);
         } else {
            gridString += charSomeTimes(' ', rightSpaces);
         }
         gridString += "|";
         for(int columns = 0; columns < cols; columns++){
            gridString += charSomeTimes(' ', width / 2);
            if(currentRows == 0){
               gridString += currentLetter;
               currentLetter += 1;
            } else {
               gridString += " ";
               
            }
            gridString += charSomeTimes(' ', rightSpaces);
            gridString += "|";
         
         }
         gridString += "\n";
         gridString += longLine(rightSpaces);
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
   public String longLine(int rightSpaces){
      String line = "";
      line += charSomeTimes('-', rightSpaces);
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