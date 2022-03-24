package com.company;

import Helpers.Excel_Utility;
import Helpers.Helper;
import Innings.First_Innings;
import Innings.Second_Innings;
import Match_Summary.match_summary;
import Models.Team_Array;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Team_Array team1 = new Team_Array("Mumbai_India");
        Team_Array team2 = new Team_Array("Chennai_SouthAfrica");
        Team_Array team3 = new Team_Array("Delhi_NewZealand");
        Team_Array team4 = new Team_Array("RoyalChallengers_Bangladesh");
        Team_Array team5 = new Team_Array("Rajastan_Australia");
        Team_Array team6 = new Team_Array("Kolkata_England");
        Team_Array team7 = new Team_Array("Punjab_Pakistan");
        Team_Array team8 = new Team_Array("Sunrisers_SriLanka");


        //        Assigning teams to the groups
        Team_Array[] Group_A = { team1,team2,team3,team4 };
        Team_Array[] Group_B = { team5,team6,team7,team8 };

        Helper cricket_helper = new Helper();


        //        Generating a match between the two teams
        ArrayList<Team_Array> the_match = cricket_helper.get_random_match(Group_A,Group_B);

        for(Team_Array i: the_match){
            System.out.println(i.getTeamName());
        }


        //        Tossing the coin
        List<Team_Array> toss_outcome = cricket_helper.toss_coin(the_match);


        //        start the first innings
        First_Innings firstInnings = new First_Innings(toss_outcome);
        firstInnings.playFirstInnings();

        //        start the second innings
        Second_Innings secondInnings = new Second_Innings(toss_outcome);
        secondInnings.playSecondInnings(firstInnings.Total1);

        //        match summary
        match_summary matchSummary = new match_summary();
        matchSummary.matchSummary(firstInnings.Total1, secondInnings.Total2);















    }
}