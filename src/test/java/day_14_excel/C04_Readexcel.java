package day_14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_Readexcel {
    @Test
    public  void readExcelTest() throws IOException {
        //ingilizce baskentler sutununu yazdiralim

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        String satirdakiData="";

        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }
    }
}
