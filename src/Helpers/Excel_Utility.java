package Helpers;

import Models.Batsman;
import Models.Bowler;
import Models.Team_Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Utility {

    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Row row;
    private static Cell cell;


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


    public void writeExcel() throws IOException, InvalidFormatException {

        fis = new FileInputStream(("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();
        System.out.println(noOfRows);

//        row = sh.createRow(10);
//        cell = row.createCell(10);
//        cell.setCellValue("QAV");
//        System.out.println(cell.getStringCellValue());
//        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx");
//        wb.write(fos);
//        fos.flush();
//        fos.close();
//        System.out.println("Done");

        findRow(sh,"Mumbai_India");


    }

    private static void findRow(XSSFSheet sheet, String cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
//                        int currentMatchCount = Integer.parseInt(String.valueOf(row.getCell(1).getRichStringCellValue()));
                        int currentMatchCount = (int) row.getCell(1).getNumericCellValue();
                        currentMatchCount++;
                        row.getCell(1).setCellValue(currentMatchCount);
                        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/coursework/tournament/points_table.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                        //                        System.out.println(cell.getRichStringCellValue().getString()+"--------------------");
                    }
                }
            }
        }
    }


    public void playerStandingWriteExcel(ArrayList<Batsman> batting,ArrayList<Bowler> bowling ,boolean isBatsman) throws IOException, InvalidFormatException {

        fis = new FileInputStream(("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/fx/src/PlayerStanding/player_standings.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();

        if (isBatsman){
            for(Batsman player: batting){
                playerStandingFindBatsmanRow(sh,player);
            }
        }else {
            for(Bowler player: bowling){
                playerStandingFindBowlerRow(sh,player);
            }

        }
    }

    private static void playerStandingFindBatsmanRow(XSSFSheet sheet, Batsman cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent.getName())) {
//                        int currentMatchCount = Integer.parseInt(String.valueOf(row.getCell(1).getRichStringCellValue()));
                        int currentBatsmanRuns = (int) row.getCell(1).getNumericCellValue();
                        currentBatsmanRuns+= cellContent.getRuns();
                        row.getCell(1).setCellValue(currentBatsmanRuns);
                        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/fx/src/PlayerStanding/player_standings.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                        //                        System.out.println(cell.getRichStringCellValue().getString()+"--------------------");
                    }
                }
            }
        }
    }

    private static void playerStandingFindBowlerRow(XSSFSheet sheet, Bowler cellContent) throws IOException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent.getName())) {
//                        int currentMatchCount = Integer.parseInt(String.valueOf(row.getCell(1).getRichStringCellValue()));
                        int currentBowlerWickets = (int) row.getCell(2).getNumericCellValue();
                        currentBowlerWickets+= cellContent.getWickets();
                        row.getCell(2).setCellValue(currentBowlerWickets);
                        fos = new FileOutputStream("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/fx/src/PlayerStanding/player_standings.xlsx");
                        wb.write(fos);
                        fos.flush();
                        fos.close();
                        System.out.println("Done");
                        //                        System.out.println(cell.getRichStringCellValue().getString()+"--------------------");
                    }
                }
            }
        }
    }

    public void displayPlayerStanding() throws IOException, InvalidFormatException {

        fis = new FileInputStream(("E:/IIT/1st Year/2nd Trimester/CM1601 [PRO] Programming Fundamentals/CW/fx/src/PlayerStanding/player_standings.xlsx"));
        wb = (XSSFWorkbook) WorkbookFactory.create(fis);
        sh = wb.getSheet("Sheet1");
        int noOfRows = sh.getLastRowNum();
        ArrayList<Batsman> topBatsmen = new ArrayList<>();
        ArrayList<Bowler> topBowler = new ArrayList<>();


        for (Row row : sh) {
            if(row.getRowNum() != 0){
                for (Cell cell : row) {
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        Batsman currentBatsman = new Batsman();
                        Bowler currentBowler = new Bowler();

                        currentBatsman.setName(row.getCell(0).toString());
                        currentBowler.setName(row.getCell(0).toString());
                        currentBatsman.setRuns((int)row.getCell(1).getNumericCellValue());
                        currentBowler.setWickets((int)row.getCell(2).getNumericCellValue());

                        topBatsmen.add(currentBatsman);
                        topBowler.add(currentBowler);
                    }
                }
            }
        }


        System.out.println("\n\nTop 5 run scores of the tournament");
        //sort batsman runs to descending order
        Collections.sort(topBatsmen,(o1, o2) -> o2.getIntegerRuns().compareTo(o1.getIntegerRuns()));

        System.out.println("\n\nTop 5 wicket takers of the tournament");
        //sort bowler wickets to descending order
        Collections.sort(topBowler,(o1, o2) -> o2.getIntegerWickets().compareTo(o1.getIntegerWickets()));



        for (int i = 0; i < 6; i++) {
            System.out.println(topBatsmen.get(i).getName()+" "+topBatsmen.get(i).getRuns());
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(topBowler.get(i).getName()+" "+topBowler.get(i).getWickets());
        }


    }

}

