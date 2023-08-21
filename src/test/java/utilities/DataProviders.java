package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir")+"//testData//Api_test_data.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Sheet1");
        int colCount = xl.getCellCount("Sheet1",1);

        String[][] apiData = new String[rowNum][colCount];
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j <= colCount; j++) {
                apiData[i-1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        return apiData;
    }
    @DataProvider(name = "Ids")
    public Object[][] getProductId() throws IOException{
        String path = System.getProperty("user.dir")+"//testData//Api_test_data.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Sheet1");

        String apiData[][] = new String[rowNum][2];
        for (int i = 1; i <=rowNum ; i++) {
            apiData[i-1][2]= xl.getCellData("Sheet1", i, 2);
        }
        return apiData;
    }
}
