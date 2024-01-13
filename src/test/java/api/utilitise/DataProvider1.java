package api.utilitise;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProvider1 {
    @DataProvider(name = "Data")
    public String[][] getAllData() throws Exception {
        String path = System.getProperty("user.dir") + "//Testdata//UserData.xlsx";//user dir --gives current project location
        XLUtility xl = new XLUtility(path);
        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getColumnCount("Sheet1", 1);

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j <= colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//Testdata//UserData.xlsx";
        XLUtility xl = new XLUtility(path);
        int rownum = xl.getRowCount("Sheet1");
        String apidata[] = new String[rownum];
        for (int i = 1; i<=rownum; i++)
        {
            apidata[i - 1] = xl.getCellData("Sheet1", i, 1);


        }
        return apidata;
    }
}

