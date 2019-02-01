import java.util.*;
import java.io.*;

public class ExcelEngine extends ExcelBase {
   public static void main(String args[]){
      GridBase.grid = new Grid();
      ExcelEngine engine = new ExcelEngine();
      
      engine.runInputLoop();
   }
   public String processCommand(String input){
      if(input.contains("load")){
         try{
            return loadFile(input);
         } 
         catch (FileNotFoundException e){
            return "File loading failed";
         }
      }
      
      
      return GridBase.grid.processCommand(input);
   }
   public String loadFile(String input) throws FileNotFoundException {
      Scanner parse = new Scanner(input);
      parse.next();
      File file = new File(parse.next());
      Scanner fileP = new Scanner(file);
      
      while(fileP.hasNextLine()){
         GridBase.grid.processCommand(fileP.nextLine());
      }
      return "File loaded successfully";
   }
}