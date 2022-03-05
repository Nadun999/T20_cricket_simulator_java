package Genarate_Random_Match;

//import sun.jvmstat.perfdata.monitor.protocol.rmi.PerfDataBuffer;
//
//import java.io.File;
//import java.util.Arrays;
//import java.util.List;

import Models.Team_Array;

import java.util.*;

public class generate_random_match {

    public generate_random_match(){

    }

    public ArrayList<Team_Array> generateRandomMatch(Team_Array Group_A[],Team_Array Group_B[]){

        //        converting team array into lists
        List<Team_Array> Group_A_list = Arrays.asList(Group_A);
        List<Team_Array> Group_B_list = Arrays.asList(Group_B);

//        shufflling the teams inside a group
        Collections.shuffle(Arrays.asList(Group_A));
        Collections.shuffle(Arrays.asList(Group_B));

        ArrayList<Team_Array> match_between_A = new ArrayList<Team_Array>();
        ArrayList<Team_Array> match_between_B = new ArrayList<Team_Array>();

//        selecting two teams from each group
        match_between_A.add(Group_A_list.get(0));
        match_between_A.add(Group_A_list.get(1));

        match_between_B.add(Group_B_list.get(0));
        match_between_B.add(Group_B_list.get(1));


//        for(Team_Array i: match_between_A){
//            System.out.println(i.getTeamName());
//        }
//        for(Team_Array i: match_between_B){
//            System.out.println(i.getTeamName());
//        }
//        System.out.println("-----------------------------");


//        inserting the two genarated matches into chosen match variable
        List<ArrayList<Team_Array>> chosen_match = Arrays.asList(match_between_A,match_between_B);

//        picking a random match from the two genarated matches
        Random r=new Random();
        ArrayList<Team_Array> randomElement = chosen_match.get(r.nextInt(chosen_match.size()));

//        for(Team_Array i: randomElement){
//            System.out.println(i.getTeamName());
//        }

        return randomElement;
    }

}
