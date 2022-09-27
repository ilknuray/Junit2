package day_14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    /*
    excel dosysindaki tum verileri classimiza alip bir java objesine store edelim
    boylece her seferinde excel e ulasip satir sutun vs ugrasmayalim
     */

//database yapisinda olan excel i koyabilecegimiz en uygun java objesi maptir


    @Test
    public void ReadExcelTest() throws IOException {

        Map<String, String> ulkelerMap = new HashMap<>();

        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //fileInputStream olusturup parametre olarak dosya yolunu atayalim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //workbook objesi olusturalim parametre olarak fileinputstream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatirIndex; i++) {
            //key i.satirdaki 0 indexindeki datadir
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            //value ise i.satirdaki 1 2 ve3. index deki datalarin birlesimi olacak
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);
        //listede gana oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
    }
}