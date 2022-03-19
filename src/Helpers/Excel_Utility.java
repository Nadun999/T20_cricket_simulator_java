package Helpers;

import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Utility {


    public Excel_Utility() throws IOException {
    }

//        String xx = sh.getRow(1).getCell(0).getStringCellValue();


    public ArrayList<Batsman> getBattingTeamFromExcel(String teamName, boolean isBattingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Batsman> battingTeam = new ArrayList<>();


        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);


        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator<Row> row = sh.iterator();

//        System.out.println(sh.getRow(1).getCell(0).toString() );
//        System.out.println(sh.getRow(0).getLastCellNum());
//        System.out.println(sh.getLastRowNum());
        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();


        for (int i = 1; i < rowCount + 1; i++) {

            Batsman batsman = new Batsman();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            batsman.name = header.getCell(0).getStringCellValue();
            batsman.battingOrder = i;
//                batsman.battingOrder = Integer.parseInt(String.valueOf(header.getCell(5)));
//                System.out.println(batsman.name);

            battingTeam.add(batsman);
        }


//        for (Batsman i : battingTeam) {
//            System.out.println(i.name);
//            System.out.println(i.runs);
//            System.out.println(i.balls);
//            System.out.println(i.methodOfDissmal);
//            System.out.println(i.battingOrder);
//        }


        wb.close();
        fis.close();

        return battingTeam;
    }

    public ArrayList<Bowler> getBowlingTeamFromExcel(String teamName, boolean isBowlingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Bowler> bowlingTeam = new ArrayList<>();


        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);


        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator<Row> row = sh.iterator();

//        System.out.println(sh.getRow(1).getCell(0).toString() );
//        System.out.println(sh.getRow(0).getLastCellNum());
//        System.out.println(sh.getLastRowNum());
        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();


        for (int i = 1; i < rowCount+1; i++) {

            Bowler bowler = new Bowler();

            Row header = sh.getRow(i);
            int n = header.getLastCellNum();
            bowler.name = header.getCell(0).getStringCellValue();

            bowlingTeam.add(bowler);
        }


//        for(Bowler i: bowlingTeam) {
//            System.out.println(i.name);
//            System.out.println(i.overs);
//            System.out.println(i.runs);
//            System.out.println(i.wickets);
//            System.out.println(i.economy);
//        }

        wb.close();
        fis.close();

        return bowlingTeam;
    }
}


