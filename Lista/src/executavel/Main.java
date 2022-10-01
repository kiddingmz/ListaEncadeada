package executavel;

import java.io.IOException;
import java.text.ParseException;
import menu.Menu;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Menu menu = new Menu();
      
        menu.menu();
        menu.save();
    }
    
}
