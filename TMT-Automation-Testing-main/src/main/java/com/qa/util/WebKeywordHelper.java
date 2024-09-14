package com.qa.util;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.PageSize;
import com.pages.TMTEventDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.apache.poi.poifs.macros.Module.ModuleType.Document;


public class WebKeywordHelper {


	WebDriver driver = DriverFactory.getDriver();

	public static void selectDateandtime(WebDriver driver, String Datetype, String time, String value) throws InterruptedException {


		String initdateformat = time.split(":")[0];

		System.out.println("===============initdate" + initdateformat);

		int mm, dd, yyyy;

		try {
			mm = Integer.parseInt(time.split(";")[1].split(",")[0].trim().split("=")[1].trim());
			System.out.println("===============month" + mm);
		} catch (Exception e1) {

			mm = 0;
		}

		try {
			dd = Integer.parseInt(time.split(";")[1].split(",")[1].trim().split("=")[1].trim());
			System.out.println("===============ddd" + dd);
		} catch (Exception e) {
			dd = 0;
		}

		try {
			yyyy = Integer.parseInt(time.split(";")[1].split(",")[2].trim().split("=")[1].trim());
			System.out.println("===============year" + yyyy);
		} catch (Exception e) {
			yyyy = 0;
		}
//		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
//	       Date today = calendar.getTime();


		calendar.add(Calendar.DAY_OF_MONTH, dd);
		calendar.add(Calendar.YEAR, yyyy);
		calendar.add(Calendar.MONTH, mm);

		Date initdate = calendar.getTime();
		System.out.println("===============finalinti" + initdate);

		SimpleDateFormat Monthformat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
		String desiredMonth = Monthformat.format(calendar.getTime());
		System.out.println(desiredMonth + "==============Month");

		SimpleDateFormat dateformat = new SimpleDateFormat("dd");
		String desireddate = dateformat.format(calendar.getTime());
		System.out.println(desireddate + "==============Date");

		SimpleDateFormat yearformat = new SimpleDateFormat("yyyy");
		String desiredYear = yearformat.format(calendar.getTime());
		System.out.println(desiredYear + "==============year");

		System.out.println(desiredMonth);
		System.out.println(desireddate);
		System.out.println(desiredYear);

		desireddate = desireddate.replaceFirst("^0+(?!$)", "");

		while (true) {
			WebElement Currentmonth = driver.findElement(By.xpath("//*[contains(@class,'react-datepicker__current-month')]"));
			String currentMonthYear = Currentmonth.getText();
			System.out.println(currentMonthYear);


			// Split the current month and year
			String[] current = currentMonthYear.split(" ");
			String currentMonth = current[0];
			String currentYear = current[1];
			System.out.println(currentMonth);
			System.out.println(currentYear);


			if (currentMonth.equalsIgnoreCase(desiredMonth) && currentYear.equals(desiredYear)) {
				System.out.println("=========Loop IF==================");
				driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']//div[not (contains (@class,' react-datepicker__day--outside-month')) and not (contains(@class,'react-datepicker__day--disabled'))]//div[(text()='" + desireddate + "') and not (contains(@class,'outside'))]")).click();
				break;

			} else {
				try {
					System.out.println("=============LOOP ELSE==============");
					WebElement element = driver.findElement(By.xpath("//span[@class='react-datepicker__navigation-icon react-datepicker__navigation-icon--next']"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					System.out.println(currentMonth);
					System.out.println(currentYear);
					System.out.println(currentMonth);
					System.out.println(currentYear);

					if (currentMonth.equalsIgnoreCase(desiredMonth) && currentYear.equals(desiredYear)) {

						System.out.println("=========Loop IF==================");
						driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']//div[not (contains (@class,' react-datepicker__day--outside-month')) and not (contains(@class,'react-datepicker__day--disabled'))]//div[(text()='" + desireddate + "') and not (contains(@class,'outside'))]")).click();
						break;
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}

		System.out.println("=============LOOP Break out==============");
		Thread.sleep(1000);
		if (Datetype.equalsIgnoreCase("FromDate")) {
			driver.findElement(By.xpath("(//*[contains(@class,'calendar-icon')])[2]")).click();
		} else if (Datetype.equalsIgnoreCase("ToDate")) {
			driver.findElement(By.xpath("(//*[contains(@class,'calendar-icon')])[4]")).click();
		}


		WebElement Selectedtime = driver.findElement(By.xpath("//li[contains(@class,'react-datepicker__time-list-item') and (contains(text(),'" + value + "'))]"));
		Thread.sleep(1000);

		Selectedtime.click();

	}

	public static void EmailUtil() throws InterruptedException {
		try {
			ConfigReader configReader;
			configReader = new ConfigReader();
			Properties prop = configReader.init_prop();

			if (prop.getProperty("MailTrigger").equalsIgnoreCase("true")) {
				// Create object of Property file

				Properties props = new Properties();



				props.put("mail.smtp.host", "smtp.gmail.com");

				// set the port of socket factory
				props.put("mail.smtp.socketFactory.port", "465");

				// set socket factory
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

				// set the authentication to true
				props.put("mail.smtp.auth", "true");

				// set the port of SMTP server
				props.put("mail.smtp.port", "465");

				// This will handle the complete authentication
				Session session = Session.getDefaultInstance(props,

						new javax.mail.Authenticator() {

							protected PasswordAuthentication getPasswordAuthentication() {

								return new PasswordAuthentication("selvaautomationuser@gmail.com", "kormhrquuqoxpxhn");

							}

						});

				try {

					// Create object of MimeMessage class
					Message message = new MimeMessage(session);

					// Set the from address
					message.setFrom(new InternetAddress("no-reply_TakeMytickets@gmail.com"));
					String recipient = prop.getProperty("Email_Receipent");
//				String recipient = "selvamaniathiyappan@gmail.com,vaishnavijayakumar26@gmail.com";
					String[] recipientList = recipient.split(",");
					InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
					int counter = 0;
					for (String recipeient : recipientList) {
						recipientAddress[counter] = new InternetAddress(recipeient.trim());
						counter++;

					}

					message.setRecipients(Message.RecipientType.TO, recipientAddress);
					// Set the recipient address
//				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("selvaselvamani98@gmail.com"));

					// Add the subject link

					message.setSubject("TMT-Automation test Report");

					// Create object to add multimedia type content
					BodyPart messageBodyPart1 = new MimeBodyPart();

					// Set the body of email
					messageBodyPart1.setText("Please find attached test execution results,");

					// Create another object to add another content
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();
					MimeBodyPart messageBodyPart3 = new MimeBodyPart();
					MimeBodyPart messageBodyPart4 = new MimeBodyPart();
					String path = System.getProperty("user.dir");
					String filename = prop.getProperty("TestResults_path");
					System.out.println(filename);
					String finalpath1 = path + filename;
					String filename2 = prop.getProperty("TestResults_pathHTML");
					String finalpath2 = path + filename2;
					String Screenshotpath = prop.getProperty("TestResults_Screenshot");
					String finalpath3 = path + Screenshotpath;
					// Create data source and pass the filename
					DataSource source = new FileDataSource(finalpath1);
					DataSource source2 = new FileDataSource(finalpath2);
					DataSource source3 = new FileDataSource(finalpath3);

					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
					messageBodyPart3.setDataHandler(new DataHandler(source2));
//					messageBodyPart4.setDataHandler(new DataHandler(source3));

					// set the file
					messageBodyPart2.setFileName("Automation test Report.pdf");
					messageBodyPart3.setFileName("Automation test Report.html");
//					messageBodyPart4.setFileName("test_report_Screenshot.zip");

					// Create object of MimeMultipart class
					Multipart multipart = new MimeMultipart();
					BodyPart messageBodyPart5 = new MimeBodyPart();
					messageBodyPart5.setText("Hi Team, ");
					// add body part 1
					multipart.addBodyPart(messageBodyPart2);

					multipart.addBodyPart(messageBodyPart3);

					// add body part 2
					multipart.addBodyPart(messageBodyPart1);
//					multipart.addBodyPart(messageBodyPart4);

					// set the content
					message.setContent(multipart);
System.out.println("Selvaaaaaaaaaaaaaaaaaaaaaaamail trest");
					// finally send the email
					System.out.println("Preparing Email for sending Report selvaa");
					Transport.send(message);

					System.out.println("=====Email Sent to " + recipient + " Successfully=====");

				} catch (MessagingException e) {

					throw new RuntimeException(e);

				}

			} else {
				System.out.println("Mail trigger is currently disabled. if need to turn on pls set as true in  MailTrigger field under config property");
			}
		}
		catch (Exception e){
			System.out.println("Issue with Mail System. it might happen due to config issue Selllvaa" +e);
		}
	}



	public static void captureScreenshot(WebDriver driver, String screenshotName, String scenarioName) {
		try {

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./FinalReport/"+scenarioName+"/" + "Screenshots/" + screenshotName + ".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}




//	public static void PDFGenerator(String pdfPath) {
//
//		ConfigReader configReader;
//		configReader = new ConfigReader();
//		Properties prop = configReader.init_prop();
//		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
//			Document document = new Document(PageSize.A4);
//			Set<String> addedImages = new HashSet<>();
//			try {
//				PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(pdfPath)));
//				document.open();
////				File folder = new File("./screenshots/");
//				File folder = new File("./FinalReport/To verify user able to create event details3/Screenshots");
//
//
//				File[] listOfFiles = folder.listFiles();
//           System.out.println(listOfFiles+"Selvaaaaimagessssssssss");
//				for (File file : listOfFiles) {
//					if (file.isFile() && file.getName().endsWith(".png") && !addedImages.contains(file.getName())) {
//						Image img = Image.getInstance(file.getAbsolutePath());
//						img.scaleToFit(PageSize.A4.getWidth() - 20, PageSize.A4.getHeight() - 20);
//						img.setAlignment(Image.ALIGN_CENTER);
//						document.add(img);
//						addedImages.add(file.getName());
//					}
//				}
//				document.close();
//				Thread.sleep(5000);
//				System.out.println("Selva-Passsssssssssssssssssssssss");
//			} catch (Exception e) {
//				System.out.println("Selva-errr-rrrrrrrrrrrrrrrrrrrrrrrr");
//			}
//		}
//
//
//	}


		public static void ScreenshotCleaner(String folderPath) {
			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().endsWith(".png")) {
						if (file.delete()) {
							System.out.println("Deleted: " + file.getName());
						} else {
							System.out.println("Failed to delete: " + file.getName());
						}
					}
				}
			} else {
				System.out.println("The folder is empty or does not exist.");
			}
		}

		public  void zipDirectory(File dir, String zipDirName) {
			try {
				Properties prop ;
				ConfigReader configReader;
				configReader = new ConfigReader();
				prop = configReader.init_prop();
				if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true"))
					if (dir.exists() && dir.isDirectory()) {
						{
							FileOutputStream fos = new FileOutputStream(zipDirName);
							ZipOutputStream zos = new ZipOutputStream(fos);
							zipFile(dir, dir.getName(), zos);
							zos.close();
							fos.close();
						}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private  void zipFile(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
			if (fileToZip.isHidden()) {
				return;
			}
			if (fileToZip.isDirectory()) {
				if (fileName.endsWith("/")) {
					zos.putNextEntry(new ZipEntry(fileName));
					zos.closeEntry();
				} else {
					zos.putNextEntry(new ZipEntry(fileName + "/"));
					zos.closeEntry();
				}
				File[] children = fileToZip.listFiles();
				for (File childFile : children) {
					zipFile(childFile, fileName + "/" + childFile.getName(), zos);
				}
				return;
			}
			FileInputStream fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
			fis.close();
		}

	public void DeleteFolder() {

		Path folder = Paths.get("./FinalReport/");
		Path Staticfolder = Paths.get("./StaticReport/");
		String folderPath = "./FinalReport/";
		File folders = new File(folderPath);
		try {
			if (folders.exists() && folders.isDirectory()) {
			Files.walk(folder)
					.sorted(Comparator.reverseOrder())
					.map(Path::toFile)
					.forEach(File::delete);
			Files.walk(Staticfolder)
					.sorted(Comparator.reverseOrder())
					.map(Path::toFile)
					.forEach(File::delete);
				}
			System.out.println("Folder deleted successfully.");
		} catch (
				IOException e) {
			e.printStackTrace();
		}

	}
	}


	
	
	


