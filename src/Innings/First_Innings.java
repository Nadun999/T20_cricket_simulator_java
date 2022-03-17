package Innings;

import Helpers.Excel_Utility;
import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class First_Innings {

    Team_Array battingInfo = new Team_Array();
    Team_Array bowlingInfo = new Team_Array();
    ArrayList<Batsman> battingTeam = new ArrayList<>();
    ArrayList<Bowler> bowlingTeam = new ArrayList<>();
    Excel_Utility eu = new Excel_Utility();


    public First_Innings(List<Team_Array> toss_outcome) throws IOException {
        battingInfo = toss_outcome.get(0);
        bowlingInfo = toss_outcome.get(1);
    }

    public void playFirstInnings() throws IOException {
        battingTeam = eu.getBattingTeamFromExcel(battingInfo.getTeamName(),true);
        bowlingTeam = eu.getBowlingTeamFromExcel(bowlingInfo.getTeamName(),true);
    }

}