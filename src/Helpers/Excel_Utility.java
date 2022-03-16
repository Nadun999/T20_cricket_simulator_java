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

//    public void readExcel() throws IOException {
//
//        Team_Array temp = new Team_Array("Mumbai_India");
//        System.out.println(temp.getTeamPath());
//        File excelFile = new File(String.valueOf(temp.getTeamPath()));
//        FileInputStream fis = new FileInputStream(excelFile);
//
//
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sh = wb.getSheetAt(0);
//        Iterator <Row> row = sh.iterator();
//
//        while (row.hasNext()){
//
//            Row r = row.next();
//            Iterator<Cell> ci = r.cellIterator();
//
////                if (cell.toString()=="PLAYER NAME" ) {
//////                    ci.remove();
////                    System.out.println("hello");
////                }
//            if (ci.remove();)
//
//            while (ci.hasNext()){
//                Cell cell = ci.next();
//
//
////                System.out.println(cell.toString());
//
//            }
//        }
//
//        wb.close();
//        fis.close();
//
//
//
//    }

    public void getTeamFromExcel(String teamName,boolean isBattingTeam) throws IOException {

        Team_Array temp = new Team_Array(teamName);
        ArrayList<Batsman> battingTeam = new ArrayList<>();
        ArrayList<Bowler> bowlingTeam = new ArrayList<>();

        File excelFile = new File(String.valueOf(temp.getTeamPath()));
        FileInputStream fis = new FileInputStream(excelFile);


        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        Iterator <Row> row = sh.iterator();

//        System.out.println(sh.getRow(1).getCell(0).toString() );
        System.out.println(sh.getRow(0).getLastCellNum());
        System.out.println(sh.getLastRowNum());
        int cellCount = sh.getRow(1).getLastCellNum();
        int rowCount = sh.getLastRowNum();

//        String xx = sh.getRow(1).getCell(0).getStringCellValue();


        for (int i = 1; i < rowCount+1; i++) {

                Batsman batsman = new Batsman();

                Row header = sh.getRow(i);
                int n = header.getLastCellNum();
                batsman.name = header.getCell(0).getStringCellValue();
//                System.out.println(batsman.name);


            battingTeam.add(batsman);
        }

        for(Batsman i: battingTeam) {
            System.out.println(i.name);
        }


//        while (row.hasNext()){
//
//            Batsman batsman = new Batsman();
//
//            Row r = row.next();
//            Iterator<Cell> ci = r.cellIterator();
//
//
//            while (ci.hasNext()){
//                Cell cell = ci.next();
//
//                if (cell.toString()!="PLAYER NAME" ) {
//                    batsman.name = cell.toString();
//                }
//
//            }
//        }

        wb.close();
        fis.close();



    }
}



