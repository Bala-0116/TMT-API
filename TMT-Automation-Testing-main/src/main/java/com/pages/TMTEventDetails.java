
package com.pages;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMTEventDetails {
	WebDriver driver;

	public TMTEventDetails(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//textarea[contains(@name,'textarea-field')]")
	public WebElement txtEventName;

	@FindBy(xpath = "(//*[contains(@class,'flex flex-col w-full gap-2')]/descendant::div)[2]")
	public WebElement btnvisibilitypublic;

	@FindBy(xpath = "//*[normalize-space()='Online']")
	public WebElement btnEventtypeOnline;

	@FindBy(xpath = "//*[normalize-space()='Next']")
	public WebElement btnNexttab;

	@FindBy(xpath = "(//*[contains(@class,'datepicker-dropdown px-6 py-4 flex items-center justify-between')])[1]")
	public WebElement btnStartDate;

	@FindBy(xpath = "(//*[contains(@class,'calendar-icon')])[3]")
	public WebElement btnToDate;


	@FindBy(xpath = "//div[@class='react-datepicker__month-container']//div[not (contains (@class,' react-datepicker__day--outside-month')) and not (contains(@class,'react-datepicker__day--disabled'))]//div[(text()='3') and not (contains(@class,'outside'))]")
	public WebElement txtcurrentdate;

	@FindBy(xpath = "//div[@class='react-datepicker__current-month']")
	public WebElement txtcurrentmonthyear;

	@FindBy(xpath = "(//label[normalize-space(text()='Event Link')]/following::input)[1]")
	public WebElement txtEventLink;

	@FindBy(xpath = "(//input[contains(@class,'input-field label-16 w-full py-3 px-5')])[2]")
	public WebElement txtMeetingid;

	@FindBy(xpath = "(//input[contains(@class,'input-field label-16 w-full py-3 px-5')])[3]")
	public WebElement txtpassword;

	@FindBy(xpath = "//input[contains(@type,'file')]")
	public WebElement btnfileupload;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebElement btnimageframedone;


	@FindBy(xpath = "//*[contains(@class,'ql-editor ql-blank')]")
	public WebElement txtaddeventdesctption;

	@FindBy(xpath = "//input[contains(@name,'input-field')]")
	public WebElement txtphonenumber;

	@FindBy(xpath = "//button[contains(@class,'button text-cta flex items-center justify-center gap-2.5 rounded primary-black small')]")
	public WebElement btnAddtickets;

	@FindBy(xpath = "//div[@name='dropdown-field']")
	public WebElement btntickettype;

	@FindBy(xpath = "//input[contains(@name,'option_value_1')]")
	public WebElement txtaddticketdetailsname;

	@FindBy(xpath = "//input[contains(@name,'quantity')]")
	public WebElement txttickettypequantity;

	@FindBy(xpath = "//input[contains(@name,'price')]")
	public WebElement txttickettypeprice;

	@FindBy(xpath = "//input[@type='range']")
	public WebElement btnsliderange;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebElement btnotpsubmit;

	@FindBy(xpath = "//*[contains(@class,'label-16 text-grey-70 flex  justify-between')]")
	public WebElement btnAdvancesettings;

	@FindBy(xpath = "//*[contains(@class,'overflow-y-auto overflow-x-hidden flex flex-col gap-6')]/descendant::*[contains(text(),'Me')]")
	public WebElement btnAdvancesettingsmewillpay;

	@FindBy(xpath = "//*[contains(@class,'overflow-y-auto overflow-x-hidden flex flex-col gap-6')]/descendant::*[contains(text(),'Buyer')]")
	public WebElement btnAdvancesettingsBuyerwillpay;

	@FindBy(xpath = "//*[contains(@class,'overflow-y-auto overflow-x-hidden flex flex-col gap-6')]/descendant::*[contains(@name,'description')]")
	public WebElement btnAdvancesettingsdescription;

	@FindBy(xpath = "//*[contains(text(),'View breakup')]")
	public WebElement btnviewbreakup;

	@FindBy(xpath = "//*[contains(text(),'Okay, got it!')]")
	public WebElement btnokaygotit;

	@FindBy(xpath = "//*[contains(@class,'modal-footer flex')]//*[contains(text(),'Save')]")
	public WebElement btnsaveticketdetail;

	@FindBy(xpath = "//*[contains(@class,'toggle-select relative cursor-pointer')]")
	public WebElement btnavailableforsale;
	/////Add question section
	@FindBy(xpath = "//*[contains(@class,'form-container-wrapper flex flex-col items-center flex-1 gap-6 mt-9 pr-4')]/button[contains(@class,'button text-cta flex items-center justify-center gap-2.5 rounded tertiary regular')]")
	public WebElement btnAddquestion;

	@FindBy(xpath = "//*[contains(text(),'Email')]/parent::*[contains(@class,'flex flex-col gap-1')]/parent::*[contains(@class,'flex items-center justify-center gap-4')]/..")
	public WebElement btnaddquestionlist;

	@FindBy(xpath = "//input[contains(@name,'input-field')]")
	public WebElement txtinputfield;

	@FindBy(xpath = "//div[contains(@name,'dropdown-field')]")
	public WebElement lstquestiontype;

	@FindBy(xpath = "//div[contains(text(),'Email')]/.")
	public WebElement btnEmailoption;

	@FindBy(xpath = "//*[contains(text(),'Show question for specific ticket types')]/../../div[1]")
	public WebElement chkshowquestionforspecficticketstype;

	@FindBy(xpath = "//*[contains(text(),'Allow only specific Mail IDs to purchase tickets')]/../../div[1]")
	public WebElement chkAllowspecificMailIDspurchasetickets;

	@FindBy(xpath = "//*[contains(@class,'flex flex-col gap-2 pl-8 pt-2')]//div[contains(@class,'checkbox-select relative')]")
	public WebElement selectspecificticket;

	//*[contains(@class,'flex flex-col gap-2 pl-8 pt-2')]//div[contains(@class,'checkbox-select relative')]

	@FindBy(xpath = "//*[contains(text(),'Add Mail ID')]")
	public WebElement btnaddmailid;

	@FindBy(xpath = "//*[contains(text(),'Add option')]")
	public WebElement btnaddoption;

	@FindBy(xpath = "(//*[contains(@name,'input-field')])[2]")
	public WebElement txtinputvalueid;

	@FindBy(xpath = "(//*[contains(@name,'input-field')])[3]")
	public WebElement txtinputvalueid2;

	@FindBy(xpath = "(//*[contains(@name,'input-field')])[4]")
	public WebElement txtinputvalueid3;


	@FindBy(xpath = "//div[@class='flex items-center gap-3 flex-1']//*[name()='svg']")
	public WebElement btndeletefield;

	@FindBy(xpath = "(//*[contains(text(),'Save')])[3]")
	public WebElement btnsaveaddquestion;
	//Add new question
	@FindBy(xpath = "//input[contains(@placeholder,'Search or Add a question')]")
	public WebElement txtaddnewquestion;

	@FindBy(xpath = "//button[contains(@class,'button text-cta flex items-center justify-center gap-2.5 tertiary-text regular')]")
	public WebElement btnaskanewquestion;

	//a conditional sub-question
	@FindBy(xpath = "//*[contains(@class,'checkbox-wrapper flex gap-2 mb-8')]//div[contains(@class,'checkbox-select relative')]")
	public WebElement btncondtionalsubquestion1;

	@FindBy(xpath = "(//div[@name='dropdown-field'])[2]")
	public WebElement lstcondtionalsubquestiondropdown1;

	@FindBy(xpath = "(//*[contains(@placeholder,'Ask a question')])[2]")
	public WebElement txtcondtionalsubquestionquestion1;

	@FindBy(xpath = "(//div[contains(@name,'dropdown-field')])[3]")
	public WebElement lstdropdownfield1;

	@FindBy(xpath = "(//div[contains(text(),'Short Text')])[3]")
	public WebElement lstdropdownshorttext1;

	@FindBy(xpath = "(//*[contains(@class,'radio-select')])[1]")
	public WebElement btnradioRegistered;

	@FindBy(xpath = "(//*[contains(@class,'radio-select')])[2]")
	public WebElement btnradionotRegistered;

	@FindBy(xpath = "(//*[contains(text(),'Name')]/following::input[contains(@name,'input-field')])[1]")
	public WebElement txtnotregisteredname;


	@FindBy(xpath = "(//*[contains(text(),'Address')]/following::input[contains(@name,'input-field')])[1]")
	public WebElement txtnotRegisteredAddress;

	@FindBy(xpath = "(//*[contains(text(),'Aadhar number')]/following::input[contains(@name,'input-field')])[1]")
	public WebElement txtnotRegisteredAadharnumber;

	@FindBy(xpath = "//*[contains(@class,'checkbox-wrapper flex gap-2 ')]/div[1]")
	public WebElement chkAcknowledge;

	@FindBy(xpath = "//button[contains(@class,'button text-cta flex items-center justify-center gap-2.5 secondary regular  flex gap-2.5 w-full')]")
	public WebElement btnmainuploadaadhar;

	@FindBy(xpath = "(//input[contains(@type,'file')])[1]")
	public WebElement btnAaadharfrontend;

	@FindBy(xpath = "(//input[contains(@type,'file')])[2]")
	public WebElement btnAaadharbackendend;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement btnsubmit;

	@FindBy(xpath = "//button[contains(text(),'Publish event')]")
	public WebElement btnpublishevent;
	// event confirmation
	@FindBy(xpath = "//*[contains(text(),'Confirm')]")
	public WebElement btnconfirmevent;

	@FindBy(xpath = "//*[contains(text(),'Your event has been successfully submitted for review!')]")
	public WebElement lbleventsuccessfulmsg;

	@FindBy(xpath = "//*[contains(text(),'Our team will notify you by mail within 60 mins once the event is made live.')]")
	public WebElement lbleventsuccessfulintimationmsg;

	@FindBy(xpath = "//*[contains(text(),'Got it')]")
	public WebElement btngotit;
	//GST Registered flow

	@FindBy(xpath = "(//*[contains(text(),'Registered Company name/Organizer’s name')]/following::input[contains(@name,'input-field')])[1]")
	public WebElement txtregisteredname;

	@FindBy(xpath = "//*[contains(@name,'dropdown-field')]")
	public WebElement btnStatedropdown;

	@FindBy(xpath = "//*[contains(text(),'Chhattisgarh')]")
	public WebElement lstchattisgarh;

	@FindBy(xpath = "//*[contains(text(),'PAN number')]/following::input[contains(@name,'input-field') and (contains(@maxlength,'10'))]")
	public WebElement txtpannumber;

	@FindBy(xpath = "//*[contains(text(),'GSTIN number')]/following::input[contains(@name,'input-field') and (contains(@maxlength,'13'))]")
	public WebElement txtGSTRegisterednumber;

	@FindBy(xpath = "//*[contains(text(),'Upload GST Certificate')]")
	public WebElement btnuploadmainGSTcertificate;

	@FindBy(xpath = "//input[contains(@type,'file')]")
	public WebElement btnuploadgstfile;


	@FindBy(xpath = "//*[contains(text(),'Enter location manually')]")
	public WebElement btnEnterlocationManually;

	@FindBy(xpath = "//*[contains(@class,'flex flex-col items-start self-stretch')]")
	public WebElement btnMarinabrachtextsuggestion;
	//confirm venue address
	@FindBy(xpath = "(//input[@name='input-field'])[1]")
	public WebElement txtVenueName;
	@FindBy(xpath = "(//*[text()='Street line 1']/ancestor-or-self::*[contains(@class,'flex flex-col gap-7 overflow-auto pr-4')]//input)[2]")
	public WebElement txtstreetline1;
	@FindBy(xpath = "(//*[text()='Street line 2']/ancestor-or-self::*[contains(@class,'flex flex-col gap-7 overflow-auto pr-4')]//input)[3]")
	public WebElement txtstreetline2;
	@FindBy(xpath = "(//*[text()='City/town']/ancestor-or-self::*[contains(@class,'flex flex-col gap-7 overflow-auto pr-4')]//input)[4]")
	public WebElement txtcitytown;
	@FindBy(xpath = "(//*[contains(text(),'Create event')])[1]")
	public WebElement btncreateevent;
//Scecondary revamp

	@FindBy(xpath = "(//*[contains(@name,'dropdown-field')])[2]")
	public WebElement btnselectcity;
	@FindBy(xpath = "//*[contains(text(),'Login/Signup')]")
	public WebElement BtnLoginsignup;
	@FindBy(xpath = "//*[contains(text(),'Re-sell tickets')]")
	public WebElement BtnReselltickets;
	@FindBy(xpath = "(//*[contains(@class,'flex gap-6 items-center w-full p-2 md:p-[20px] bd-2 cursor-pointer hover')])[1]")
	public WebElement lstsuggestionitem;
	@FindBy(xpath = "(//*[contains(@class,'flex gap-6 items-center w-full p-2 md:px-5 md:py-5 cursor-pointer hover')])[1]")
	public WebElement lstsuggestionitem2;


	@FindBy(xpath = "(//*[contains(@placeholder,'Search by event')])[1]")
	public WebElement txtsrchbyeventlandingpage;

	@FindBy(xpath = "//*[contains(@placeholder,'Search by event')]")
	public WebElement txtsrchbyevent;
	@FindBy(xpath = "//*[contains(text(),'Sell tickets')]")
	public WebElement btnselltickets;
	@FindBy(xpath = "//*[contains(text(),'I’ve forwarded my tickets!')]")
	public WebElement btnforwdedmytickets;

	@FindBy(xpath = "(//*[contains(@name,'dropdown-field')])[2]")
	public WebElement lstticketcounttosell;

	@FindBy(xpath = "//*[contains(@name,'input-field') and (contains(@type,'number'))]")
	public WebElement txtpriceperticket;

	@FindBy(xpath = "//*[contains(@class,'checkbox-select relative')]")
	public WebElement chksellAckge;

	@FindBy(xpath = "//*[contains(text(),'List My Tickets')]")
	public WebElement btnlstmytickets;

	@FindBy(xpath = "//*[contains(text(),'View My Listings')]")
	public WebElement btnViewmylisting;

	@FindBy(xpath = "(//*[contains(text(),'Edit listing')])[1]")
	public WebElement btnEditlist;

	@FindBy(xpath = "//*[contains(@name,'input-field')]")
	public WebElement txtticketprice;

	@FindBy(xpath = "//*[contains(text(),'Update')]")
	public WebElement btnUpdateList;

	@FindBy(xpath = "//*[contains(text(),'Login/Signup')]")
	public WebElement btnsignin;

	//*[contains(text(),'Continue with Test Login')]

	@FindBy(xpath = "//*[contains(text(),'Continue with Test Login')]")
	public WebElement btncontinueTestlogin;

	@FindBy(xpath = "(//*[normalize-space(text())='Whatsapp number' or (contains(@name,'input-field')) and contains(@type,'number')])[2]")
	public WebElement txtwhatsappnumber;

	@FindBy(xpath = "(//*[contains(@class,'dropdown-selector h-full text-16') and contains(@name,'dropdown-field')])[2]")
	public WebElement btndropdownselectlist;
//buyer flow

	@FindBy(xpath = "//*[contains(@class,'w-full p-5 flex gap-3 rounded-[12px] items-center active')]")
	public WebElement btnselectticketselectioninevent;


    @FindBy(xpath = "(//*[contains(@class,'flex gap-3 justify-center items-center')])[1]")
	public WebElement btnselecttickettosell;


	@FindBy(xpath = "(//*[contains(@class,'button text-cta flex items-center justify-center gap-2.5 primary regular  w-full')])[1]")
	public WebElement btnwhatsappgetintouch;

	@FindBy(xpath = "//*[contains(@class,'checkbox-select relative')]")
	public WebElement btnakckgesaynotoscreenshot;

	@FindBy(xpath = "(//*[contains(text(),'Get in touch')])[2]")
	public WebElement btngetintouchafterackge;

	@FindBy(xpath = "//*[contains(text(),'Sell tickets now')]")
	public WebElement sellticketsnow;

	@FindBy(xpath = "//*[contains(@class,'toggle-select relative cursor-pointer')]")
	public WebElement btnticetsalert;

	@FindBy(xpath = "(//*[contains(@class,'dropdown-selector h-full text-16 w-full flex items-center justify-between px-5 py-3') and contains(@name,'dropdown-field')])[2]")
	public WebElement lstSortby;

	@FindBy(xpath = "(//*[normalize-space(text())='Mark as sold'])[2]")
	public WebElement btnmarkassold;

	@FindBy(xpath = "(//*[normalize-space(text())='Mark as sold'])[10]")
	public WebElement btnmarkassoldpopup;
















	
	


}
