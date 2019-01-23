public class ExcelEngine extends ExcelBase {
   public static void main(String args[]){
      GridBase.grid = new Grid();
      ExcelEngine engine = new ExcelEngine();
      
      engine.runInputLoop();
   }
}