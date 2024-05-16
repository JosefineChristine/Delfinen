import data_handler.FileLoader;
import data_handler.SaveToFile;
import domain_model.*;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //Setting the default locale to Locale.US, to ensure that the decimal separator will always be a dot,
        // regardless of the system's default locale.
        Locale.setDefault(Locale.US);



        TeamCollection teamCollection = new TeamCollection();
        //teamCollection.teamsArrayList();
        for (Team team : teamCollection.getAllTheTeams()){
            System.out.println(team.getTeamListAsString());
            System.out.println(team.getTeamMemberList().size());

        }
//        teamCollection.generateTeams();
//        teamCollection.showTeams();



    }
}


