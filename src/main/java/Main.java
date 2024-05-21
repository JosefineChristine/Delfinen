
import ui.UserInterface;


import java.util.Locale;


public class Main {
    public static void main(String[] args) {
        //Setting the default locale to Locale.US, to ensure that the decimal separator will always be a dot,
        // regardless of the system's default locale.
        Locale.setDefault(Locale.US);


        UserInterface ui = new UserInterface();
        ui.startProgram();


    }

}


