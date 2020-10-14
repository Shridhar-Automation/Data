package PractiseMode.MavenJob;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUtility {

	public ArrayList<String> getData(String getValueOf) throws IOException
	{

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\Shridhar\\Desktop\\Data.xlsx");
		XSSFWorkbook xw = new XSSFWorkbook(fis);

		int sheets=	xw.getNumberOfSheets();

		for(int i=0;i<sheets;i++)
		{

			if(	xw.getSheetName(i).equalsIgnoreCase("Test"))
			{
				XSSFSheet sheet=	xw.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstrow = rows.next();

				Iterator<Cell> ce = firstrow.cellIterator();
				int k=0;
				int column = 0;
				while(ce.hasNext())
				{
					Cell value = ce.next();

					if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
						column=k;		

					}
					k++;

				}
			//	System.out.println(column);
				while(rows.hasNext())
				{
					Row r=	rows.next();

					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(getValueOf))
					{
						Iterator <Cell> cv =	r.cellIterator();

						while(cv.hasNext())
						{

							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}



					}


				}






			}


		}




		return a;
	}


}
