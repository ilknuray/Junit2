package day_14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readTestExcel() throws IOException {
        //input olarak verilen satirNo
        //sutunNo degerlrii parametre olarak ele alip o cell deki datayi String olarak bana donduren bir method olusturun
         int satirNo=4;
         int sutunNo=4;

         //Donen stringin cezayir old tet edin
        String expectedData="Cezayir";

       String actualData= banaDataGetir(satirNo-1,sutunNo-1);//cunku excel index ile calisir
        Assert.assertEquals(expectedData,actualData);

    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();



        return istenenData;
    }
}
