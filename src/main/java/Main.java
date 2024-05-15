import data_handler.FileLoader;
import data_handler.SaveToFile;
import domain_model.*;
import domain_model.Record;
import ui.UserInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //Setting the default locale to Locale.US, to ensure that the decimal separator will always be a dot,
        // regardless of the system's default locale.
        Locale.setDefault(Locale.US);

        // these lines are just for test and must be removed from the main class
        FileLoader fileLoader = new FileLoader();
        SaveToFile saveToFile = new SaveToFile();

        UserInterface ui = new UserInterface();
        ui.startProgram();
    }
}



