package com.company;

import Genarate_Random_Match.generate_random_match;
import Models.Team_Array;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Team_Array team1 = new Team_Array("Mumbai_India");
        Team_Array team2 = new Team_Array("Chennai_SouthAfrica");
        Team_Array team3 = new Team_Array("Delhi_NewZealand");
        Team_Array team4 = new Team_Array("RoyalChallengers_Bangladesh");
        Team_Array team5 = new Team_Array("Rajastan_Australia");
        Team_Array team6 = new Team_Array("Kolkata_England");
        Team_Array team7 = new Team_Array("Punjab_Pakistan");
        Team_Array team8 = new Team_Array("Sunrisers_SriLanka");


//        Assigning teams to the groups
        Team_Array Group_A[] = { team1,team2,team3,team4 };
        Team_Array Group_B[] = { team5,team6,team7,team8 };

        generate_random_match my_match = new generate_random_match();

        ArrayList<Team_Array> the_match = new ArrayList<Team_Array>();

        the_match = my_match.generateRandomMatch(Group_A,Group_B);

        for(Team_Array i: the_match){
            System.out.println(i.getTeamName());
        }


//# ----------------------------------------------------------------------------------------------------Importing Modules-----------------------------------------------------------------------------------------------
//import cricket
//from openpyxl import load_workbook
//import random
//import pandas as pd
//from operator import itemgetter
//# ---------------------------------------------------------------------------------Global variables which are used when accessing the functions------------------------------------------------------------------------
//
//        user_input = ''
//        global_exit = ''
//        winning_team = []
//        losing_team = []

//        System.out.println("\n\n---------------------------------------------------------------------------------Welcome to IIT Cricket Premier League 2021------------------------------------------------------------------------------");

//        try:
//        System.out.println("\n\nPress the desired number for your action... \n\nPlay a new match - 1 \nView/edit team/player profile - 2 \nView Player Standings - 3 \nView Tournament Standings - 4 \nPress 'x' to exit...  ");
//        Scanner scanner = new Scanner(System.in);
//        String user_input = scanner.nextLine();

//        while (user_input != "x"){
//            if (user_input == "1"){
//                cricket.generate_random_match();
//                cricket.points_table();
//                cricket.toss_coin();
//                cricket.first_innings();
//                cricket.second_innings();
//                cricket.match_summary();
//            }

//            else if (user_input == "2"){
//                cricket.team_profile_edit(user_input);
//            }

//            else if (user_input == "3"){
//                cricket.display_player_standings();
//            }

//            else if (user_input == "4"){
//                cricket.display_points_table();
//            }

//            else if (user_input == "x"){
//                break;
//            }

//        }



//        else:
//            print('Input value incorrect \nTry again!!!\n')
//            except IndexError as e:
//            print('\n-------------------------------------------------------------------------------------------TOURNAMENT OVER-------------------------------------------------------------------------------------------\n')
//            except Exception as e:
//            print(e)

//        System.out.println("\n\n-----------------------------------------------------------------------------------------Thank you for playing!!!----------------------------------------------------------------------------------------");



    }
}