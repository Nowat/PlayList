import controllers.Menu;
import sun.plugin2.message.JavaScriptCallMessage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.loadPlaylist();
        menu.runMenu();



    }

}
