package autofiller.autofiller;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.ShapeTypes;

import java.io.FileOutputStream;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Desktop;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Excel {
	
	public static String DateConvert(String date) {
		String cmonth="";
		int cm=0;
		for (int i=0; i<date.length(); i++) {
			if (cm==2) { 
				cmonth=cmonth+date.charAt(i);
			}
			if (date.charAt(i)=='.') cm++;
		}
		if (cmonth.equals("janvāris")) cmonth="01";
		if (cmonth.equals("februāris")) cmonth="02";
		if (cmonth.equals("marts")) cmonth="03";
		if (cmonth.equals("aprīlis")) cmonth="04";
		if (cmonth.equals("maijs")) cmonth="05";
		if (cmonth.equals("jūnijs")) cmonth="06";
		if (cmonth.equals("jūlijs")) cmonth="07";
		if (cmonth.equals("augusts")) cmonth="08";
		if (cmonth.equals("septembris")) cmonth="09";
		if (cmonth.equals("oktobris")) cmonth="10";
		if (cmonth.equals("novembris")) cmonth="11";
		if (cmonth.equals("decembris")) cmonth="12";
		return cmonth;
	}
	
	public static void CreateWB(String[] data) {
		try {
			//Create workbook in .xlsx format
			Workbook wb = new XSSFWorkbook();
			//Create Sheet
			Sheet sh = wb.createSheet("Pavadzīme");
			//create cellstyle default
			XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
			//create cellstyle bold
			XSSFCellStyle styleBold = (XSSFCellStyle) wb.createCellStyle();
			//create font
			XSSFFont font = (XSSFFont) wb.createFont();
			//create font bold
			XSSFFont fontBold = (XSSFFont) wb.createFont();
						
			//cell width
			for(int i=0; i<=100; i++) sh.setColumnWidth(i, 3 * 256);
			
			//default style
			font.setFontHeightInPoints((short) 9);
			font.setFontName("Tahoma");
			font.setBold(false);
			style.setFont(font);
			
			//bold style
			fontBold.setFontHeightInPoints((short) 9);
			fontBold.setFontName("Tahoma");
			fontBold.setBold(true);
			styleBold.setFont(fontBold);
			

		    // content of excel file
			
			//new row
	        Row row = sh.createRow(3);
	        Cell cell = row.createCell(11);
	        cell.setCellValue("Pavadzīme Nr. " + data[13]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(8);
	        cell = row.createCell(1);
	        cell.setCellValue("Izrakstīšanas datums: ");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(11);
	        cell.setCellValue(data[1]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(10);
	        cell = row.createCell(1);
	        cell.setCellValue("Pakalpojumu sniedzējs:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[20]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Kods");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(24);
	        cell.setCellValue(data[21]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(11);
	        cell = row.createCell(1);
	        cell.setCellValue("Adrese:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[22]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(12);
	        cell = row.createCell(1);
	        cell.setCellValue("Norēķinu rekvizīti:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[23]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Konts");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(24);
	        cell.setCellValue(data[24]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(14);
	        cell = row.createCell(1);
	        cell.setCellValue("Pakalpojumu saņēmējs:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[9]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Kods");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(24);
	        cell.setCellValue(data[10]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(15);
	        cell = row.createCell(1);
	        cell.setCellValue("Adrese");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[15]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(16);
	        cell = row.createCell(1);
	        cell.setCellValue("Norēķinu rekvizīti:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(9);
	        cell.setCellValue(data[19]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Konts");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(24);
	        cell.setCellValue(data[16]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(18);
	        cell = row.createCell(1);
	        cell.setCellValue("Preču izsniegšanas vieta:       " +data[25]);
	        cell.setCellStyle(style);
	       
	      //new row
	        row = sh.createRow(19);
	        cell = row.createCell(1);
	        cell.setCellValue("Preču saņemšanas vieta:       " +data[25]);
	        cell.setCellStyle(style);
	        
	      //new row
	        row = sh.createRow(20);
	        cell = row.createCell(1);
	        cell.setCellValue("Saimnieciskā darījuma apraksts");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(11);
	        cell.setCellValue("Preču piegāde");
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(21);
	        cell = row.createCell(1);
	        cell.setCellValue("Prece netiek transportēta");
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(23);
	        cell = row.createCell(1);
	        cell.setCellValue("Apmaksas veids un kārtība ");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(23);
	        cell.setCellValue("Speciālas atzīmes");
	        cell.setCellStyle(style);
	        
	      //new row
	        row = sh.createRow(24);
	        cell = row.createCell(1);
	        cell.setCellValue(data[18]);
	        cell.setCellStyle(styleBold);
	        
	      //new row
	        row = sh.createRow(25);
	        cell = row.createCell(1);
	        cell.setCellValue("Pakalpojuma apraksts");
	        sh.addMergedRegion(new CellRangeAddress(25,25,1,15));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Cena");
	        sh.addMergedRegion(new CellRangeAddress(25,25,16,18));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("Daudz.");
	        sh.addMergedRegion(new CellRangeAddress(25,25,19,21));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("Summa EUR");
	        sh.addMergedRegion(new CellRangeAddress(25,25,22,25));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(26);
	        cell.setCellValue("Summa EUR");
	        sh.addMergedRegion(new CellRangeAddress(25,25,26,29));
	        cell.setCellStyle(style);
	        
	      //new row
	        row = sh.createRow(26);
	        cell = row.createCell(1);
	        cell.setCellValue("Lietota automašīna ");
	        sh.addMergedRegion(new CellRangeAddress(26,27,1,15));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(16);
	        cell.setCellValue(data[14]);
	        sh.addMergedRegion(new CellRangeAddress(26,27,16,18));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("1.");
	        sh.addMergedRegion(new CellRangeAddress(26,27,19,21));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(22);
	        cell.setCellValue(data[14]);
	        sh.addMergedRegion(new CellRangeAddress(26,27,22,25));
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(26);
	        cell.setCellValue(data[14]);
	        sh.addMergedRegion(new CellRangeAddress(26,27,26,29));
	        cell.setCellStyle(style);
	        
	      //new row
	        row = sh.createRow(28);
	        cell = row.createCell(1);
	        cell.setCellValue("Marka: " + data[4]);
	        sh.addMergedRegion(new CellRangeAddress(28,28,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(28,28,16,18));
	        sh.addMergedRegion(new CellRangeAddress(28,28,19,21));
	        sh.addMergedRegion(new CellRangeAddress(28,28,22,25));
	        sh.addMergedRegion(new CellRangeAddress(28,28,26,29));
	        
	        //new row
	        row = sh.createRow(29);
	        cell = row.createCell(1);
	        cell.setCellValue("Izlaiduma gads: " + data[3]);
	        sh.addMergedRegion(new CellRangeAddress(29,29,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(29,29,16,18));
	        sh.addMergedRegion(new CellRangeAddress(29,29,19,21));
	        sh.addMergedRegion(new CellRangeAddress(29,29,22,25));
	        sh.addMergedRegion(new CellRangeAddress(29,29,26,29));
	        
	        //new row
	        row = sh.createRow(30);
	        cell = row.createCell(1);
	        cell.setCellValue("Šasijas numurs: " + data[5]);
	        sh.addMergedRegion(new CellRangeAddress(30,30,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(30,30,16,18));
	        sh.addMergedRegion(new CellRangeAddress(30,30,19,21));
	        sh.addMergedRegion(new CellRangeAddress(30,30,22,25));
	        sh.addMergedRegion(new CellRangeAddress(30,30,26,29));
	        
	        //new row
	        row = sh.createRow(31);
	        cell = row.createCell(1);
	        cell.setCellValue("Pašmasa: " + data[7]);
	        sh.addMergedRegion(new CellRangeAddress(31,31,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(31,31,16,18));
	        sh.addMergedRegion(new CellRangeAddress(31,31,19,21));
	        sh.addMergedRegion(new CellRangeAddress(31,31,22,25));
	        sh.addMergedRegion(new CellRangeAddress(31,31,26,29));
	        
	        //new row
	        row = sh.createRow(32);
	        cell = row.createCell(1);
	        cell.setCellValue("Motora tilpums: " + data[17]);
	        sh.addMergedRegion(new CellRangeAddress(32,32,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(32,32,16,18));
	        sh.addMergedRegion(new CellRangeAddress(32,32,19,21));
	        sh.addMergedRegion(new CellRangeAddress(32,32,22,25));
	        sh.addMergedRegion(new CellRangeAddress(32,32,26,29));
	        
	        //new row
	        row = sh.createRow(33);
	        cell = row.createCell(1);
	        cell.setCellValue("Krāsa: " + data[6]);
	        sh.addMergedRegion(new CellRangeAddress(33,33,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(33,33,16,18));
	        sh.addMergedRegion(new CellRangeAddress(33,33,19,21));
	        sh.addMergedRegion(new CellRangeAddress(33,33,22,25));
	        sh.addMergedRegion(new CellRangeAddress(33,33,26,29));
	        
	        //new row
	        row = sh.createRow(34);
	        cell = row.createCell(1);
	        cell.setCellValue("Tehniskā pase: " + data[8]);
	        sh.addMergedRegion(new CellRangeAddress(34,34,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(34,34,16,18));
	        sh.addMergedRegion(new CellRangeAddress(34,34,19,21));
	        sh.addMergedRegion(new CellRangeAddress(34,34,22,25));
	        sh.addMergedRegion(new CellRangeAddress(34,34,26,29));
	        
	        //new row
	        row = sh.createRow(35);
	        cell = row.createCell(1);
	        cell.setCellValue("V.N.: " + data[2]);
	        sh.addMergedRegion(new CellRangeAddress(35,35,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(35,35,16,18));
	        sh.addMergedRegion(new CellRangeAddress(35,35,19,21));
	        sh.addMergedRegion(new CellRangeAddress(35,35,22,25));
	        sh.addMergedRegion(new CellRangeAddress(35,35,26,29));
	        
	        //new row
	        row = sh.createRow(36);
	        cell = row.createCell(1);
	        cell.setCellValue("Īpašumtiesību apliecība Nr. " + data[0]);
	        sh.addMergedRegion(new CellRangeAddress(36,36,1,15));
	        cell.setCellStyle(style);
	        
	        sh.addMergedRegion(new CellRangeAddress(36,36,16,18));
	        sh.addMergedRegion(new CellRangeAddress(36,36,19,21));
	        sh.addMergedRegion(new CellRangeAddress(36,36,22,25));
	        sh.addMergedRegion(new CellRangeAddress(36,36,26,29));
	        
	        //new row
	        row = sh.createRow(37);
	        cell = row.createCell(1);
	        cell.setCellValue("Piezimes: Ar savu parakstu pirceijs apliecina ka ir iepazinies");
	        cell.setCellStyle(style);
	        sh.addMergedRegion(new CellRangeAddress(37,37,1,15));
	        
	        sh.addMergedRegion(new CellRangeAddress(37,38,16,18));
	        sh.addMergedRegion(new CellRangeAddress(37,38,19,21));
	        sh.addMergedRegion(new CellRangeAddress(37,38,22,25));
	        sh.addMergedRegion(new CellRangeAddress(37,38,26,29));
	        
	        //new row
	        row = sh.createRow(38);
	        cell = row.createCell(1);
	        cell.setCellValue("un apmierinats ar preces faktisko stavokli");
	        cell.setCellStyle(style);
	        sh.addMergedRegion(new CellRangeAddress(38,38,1,15));
	        
	        //new row
	        row = sh.createRow(39);
	        cell = row.createCell(1);
	        cell.setCellValue("Kopā:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(19);
	        cell.setCellValue("1,000");
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(39,39,19,21));
	        
	        cell = row.createCell(22);
	        cell.setCellValue(data[14]);
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(39,39,22,25));
	        
	        cell = row.createCell(26);
	        cell.setCellValue(data[14]);
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(39,39,26,29));
	        
	        //new row
	        row = sh.createRow(40);
	        cell = row.createCell(1);
	        cell.setCellValue("Pievienotās vērtības nodoklis peļņas daļas režīms lietotām precēm");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(22);
	        cell.setCellValue("0,00");
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(40,40,22,25));
	        
	        cell = row.createCell(26);
	        cell.setCellValue("0,00");
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(40,40,26,29));
	        
	        //new row
	        row = sh.createRow(41);
	        cell = row.createCell(1);
	        cell.setCellValue("Pavisam apmaksai");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(22);
	        cell.setCellValue(data[14]);
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(41,41,22,25));
	        
	        cell = row.createCell(26);
	        cell.setCellValue(data[14]);
	        cell.setCellStyle(styleBold);
	        sh.addMergedRegion(new CellRangeAddress(41,41,26,29));
	        
	        //new row
	        row = sh.createRow(42);
	        cell = row.createCell(1);
	        cell.setCellValue("Vārdiem:");
	        cell.setCellStyle(style);
	        sh.addMergedRegion(new CellRangeAddress(42,43,4,29));
	        
	        //new row
	        row = sh.createRow(44);
	        cell = row.createCell(1);
	        cell.setCellValue("Izsniedza:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(4);
	        cell.setCellValue(data[20]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Saņēma:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(19);
	        cell.setCellValue(data[9]);
	        cell.setCellStyle(styleBold);
	        
	        //new row
	        row = sh.createRow(45);
	        cell = row.createCell(1);
	        cell.setCellValue("Vārds, uzvārds:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(6);
	        cell.setCellValue(data[11]);
	        cell.setCellStyle(styleBold);
	        
	        cell = row.createCell(16);
	        cell.setCellValue("Vārds, uzvārds:");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(21);
	        cell.setCellValue(data[12]);
	        cell.setCellStyle(styleBold);
	        
	        //new row
	        row = sh.createRow(46);
	        cell = row.createCell(1);
	        cell.setCellValue(data[1]);
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(16);
	        cell.setCellValue(data[1]);
	        cell.setCellStyle(style);
	        
	        //new row
	        row = sh.createRow(50);
	        cell = row.createCell(9);
	        cell.setCellValue("z.v.");
	        cell.setCellStyle(style);
	        
	      //create black line
	        //3rd line
			XSSFDrawing patriarch= (XSSFDrawing) sh.createDrawingPatriarch();
			XSSFClientAnchor a = new XSSFClientAnchor(0, 0, 1023, 255, (short)1, 49, (short)9, 49);
			XSSFSimpleShape shape = patriarch.createSimpleShape(a);
			shape.setLineStyleColor(0, 0, 0);
			shape.setShapeType(ShapeTypes.LINE);
			//4th line
			a = new XSSFClientAnchor(0,0,1023,255, (short)16, 49, (short)24, 49);
			shape = patriarch.createSimpleShape(a);
			shape.setLineStyleColor(0,0,0);
			shape.setShapeType(ShapeTypes.LINE);
			//1st line
			a = new XSSFClientAnchor(0,0,1023,255, (short)1, 13, (short)29, 13);
			shape = patriarch.createSimpleShape(a);
			shape.setLineStyleColor(0,0,0);
			shape.setShapeType(ShapeTypes.LINE);
			//2nd line
			a = new XSSFClientAnchor(0,0,1023,255, (short)1, 22, (short)29, 22);
			shape = patriarch.createSimpleShape(a);
			shape.setLineStyleColor(0,0,0);
			shape.setShapeType(ShapeTypes.LINE);
	        
	        
	        
	        
	        //Borders
	        PropertyTemplate pt = new PropertyTemplate();
	        pt.drawBorders(new CellRangeAddress(25,38,1,29),BorderStyle.THIN,IndexedColors.BLACK.getIndex(),BorderExtent.ALL);
	        pt.applyBorders(sh);
	        
	        pt.drawBorders(new CellRangeAddress(39,39,19,29),BorderStyle.THIN,IndexedColors.BLACK.getIndex(),BorderExtent.ALL);
	        pt.applyBorders(sh);
	        
	        pt.drawBorders(new CellRangeAddress(40,41,22,29),BorderStyle.THIN,IndexedColors.BLACK.getIndex(),BorderExtent.ALL);
	        pt.applyBorders(sh);
	        
	        pt.drawBorders(new CellRangeAddress(37, 38, 1, 15),BorderStyle.THIN,IndexedColors.WHITE.getIndex(),BorderExtent.INSIDE_HORIZONTAL);  
	        pt.applyBorders(sh);
	     	        
	        //save workbook file
	        try (FileOutputStream outputStream = new FileOutputStream(data[26])) {
	            wb.write(outputStream);
	        }
	        catch(Exception e) {
	        	
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String PDFRead(String filepath) { // read pdf file content
		String text = null;
		try {
			//Loading an existing document
		      File file = new File(filepath);
		      PDDocument document = PDDocument.load(file);
		      //Instantiate PDFTextStripper class
		      PDFTextStripper pdfStripper = new PDFTextStripper();
		      //Retrieving text from PDF document
		      text = pdfStripper.getText(document);
		      //Closing the document
		      document.close();
		}
		catch(Exception e) {
			System.out.println("Не удается прочитать PDF или неверный путь к файлу!");
		}
		return text;
	}
	public static String[] DataFilter(String[] array) {
		String[] result= new String[30];
		// data filtering from pdf
		for(int i=1; i<array.length; i++) {
			if(array[i].equals("Nr.") && array[i-1].equals("apliecība")) result[0]=array[i+1]; //ipasumtiesiba number (0)
			if(array[i].equals("plkst.")) result[1]=array[i-4]+array[i-3]+ " " + array[i-2] + array[i-1]; //date (1)
			if(array[i].equals("numurs") && array[i-1].equals("izziņas") && !array[i+1].equals("1.reģ.dat.")) result[2]=array[i+1]; //car number (2)
			if(array[i].equals("1.reģ.dat.")) result[3]=array[i+1]; //car year (3)
			if(array[i].equals("modelis")) { 							//car name (4)
				if(array[i+2].equals("Identifikācijas")) result[4]=array[i+1];
				if(array[i+3].equals("Identifikācijas")) result[4]=array[i+1] + " " + array[i+2]; 
				if(array[i+4].equals("Identifikācijas")) result[4]=array[i+1] + " " + array[i+2]+ " " + array[i+3];
				if(array[i+5].equals("Identifikācijas")) result[4]=array[i+1] + " " + array[i+2]+ " " + array[i+3]+ " " + array[i+4];
			}
			if(array[i-1].equals("numurs") && array[i].equals("(VIN)")) result[5]=array[i+1]; //vin (5)
			if(array[i].equals("Krāsa")) {								//car color (6)
				if(array[i+2].equals("Pilna")) result[6]=array[i+1];
				if(array[i+3].equals("Pilna")) result[6]=array[i+1] + " " + array[i+2];
			}
			if(array[i].equals("Pašmasa")) result[7]=array[i+1]; //car weight (7)
			if(array[i].equals("Nr.") && array[i-1].equals("apliecības")) result[8]=array[i+1]; // teh pases nr (8)
			if(array[i].equals("nosaukums") && array[i-1].equals("vai")) {			//client name (9)
				if(array[i+3].equals("Pers.")) result[9]=array[i+1] + " " + array[i+2];
				if(array[i+4].equals("Pers.")) result[9]=array[i+1] + " " + array[i+2]+ " " + array[i+3];
				if(array[i+5].equals("Pers.")) result[9]=array[i+1] + " " + array[i+2]+ " " + array[i+3] + " " + array[i+4];
				if(array[i+6].equals("Pers.")) result[9]=array[i+1] + " " + array[i+2]+ " " + array[i+3] + " " + array[i+4]+ " " +array[i+5];
			}
			if(array[i].equals("reģ.nr.") && array[i-1].equals("vai")) result[10]=array[i+1]; // client number (10)
			if(array[i].equals("persona)") && array[i-1].equals("pilnvarota")) result[11]=array[i+1] + " " + array[i+2]; //seller sign name(11)
			if(array[i].equals("______________________________(paraksts).")) result[12]=array[i-2]+ " " + array[i-1]; // client sign name (12)
		}
		if (result[2]==null) result[2]="Nav"; // if car number not found then "Nav"
		return result;
	}
		
	public static void main(String[] args) {
		String filepath = AutoFiller.getFilePath(); // pdf file path
		String text = PDFRead(filepath); // pdf data
		String[] stext = text.split("\\s+"); //split pdf data
		String[] data = new String[30]; // array for filtered data
		data = DataFilter(stext);
		data[1]= data[1].substring(0, data[1].length() - 1); // delete "," from date 
		data[13]=AutoFiller.getPPR(); // PPR from input
		data[14]=AutoFiller.getPrice(); //Price from input
		data[15]=AutoFiller.getCAddress(); // Client adress
		data[16]=AutoFiller.getBankNum(); // Client bank number
		data[17]=AutoFiller.getEngine(); // Engine size
		data[18]=AutoFiller.getPayMethod(); // pay method
		data[19]=AutoFiller.getBankName(); // client bank name
		data[20]="SIA “ ”"; // firm name
		data[21]=" "; // firm code
		data[22]=" "; // firm address
		data[23]=" ”"; // firm bank name
		data[24]=" "; // firm bank code
		data[25]=" "; // place
		if (data[8].equals("Izdota")) data[8]="";
		//remove spaces car name
		String[] scarname = data[4].split("\\s+");
		String data4="";
		for (int i=0; i<scarname.length; i++) data4 =data4+scarname[i]+"-";
		//wb name
		data[26]=DateConvert(data[1])+data[1].charAt(10)+data[1].charAt(11)+"-"+data[13]+"-"+data4+data[3].charAt(6)+data[3].charAt(7)+data[3].charAt(8)+data[3].charAt(9)+"g.xlsx";
		CreateWB(data);
		
		try {
			File dir =new File(System.getProperty("user.dir"));
			Desktop.getDesktop().open(new File(dir+ "\\" + data[26]));
		}
		catch (IOException e)
		{
			showMessageDialog(null, "Невозможно открыть файл!");
		}
		
		System.exit(0);
		/*
		 * - Data array content -
		 * 0 - ipasumtiesiba number
		 * 1 - date
		 * 2 - car number
		 * 3 - car year
		 * 4 - car name
		 * 5 - VIN
		 * 6 - car color
		 * 7 - pasmasa
		 * 8 - teh pases number
		 * 9 - client name
		 * 10 - client code
		 * 11 - seller sign name
		 * 12 - client sign name
		 * 13 - ppr
		 * 14 - price
		 * 15 - client address
		 * 16 - client bank number
		 * 17 - engine size
		 * 18 - pay method
		 * 19 - client bank name
		 * 20 - firm name
		 * 21 - firm code
		 * 22 - firm address
		 * 23 - firm bank name
		 * 24 - firm bank code
		 * 25 - place
		 * 26 - wb name
		 */
	}
}
