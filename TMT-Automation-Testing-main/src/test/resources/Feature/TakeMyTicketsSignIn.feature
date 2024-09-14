
Feature: Primary and Secondary Website Validation

 @SecondaryFlow@Sellticketsbookmyshowsecond@buyerandsellers
 Scenario: To verify user able sell their tickets using BookMyShow
  Given Select"Delhi" City
  Given Login to Secondary Portal
  And Select event name:"Cigarettes After Sex X's India Tour 2025: Gurugram" using "Second" flow
  When Navigate to Sell your tickets quickly and select platform type "BookMyShow" and using "Second" flow
  And Click on next page
  And Click on next page
  And Forwarding Tickets
  And Verifying Ticket
  And Price your Tickets based on  ticket count:"5" and ticket per ticket price:"100"
  And My Listings
  And Update List price per ticket:"200" and ticket count:"4"

 @SecondaryFlow@SellticketsPaytminsidersecond@buyerandseller
 Scenario: To verify user able to sell their tickets using Paytminsider
  Given Select"Bengaluru" City
  Given Login to Secondary Portal
  And Select event name:"Disco Garba - Vol 05 - Open Air - Dandiya Festival | Navratri 2024" using "Second" flow
  When Navigate to Sell your tickets quickly and select platform type "Paytm Insider" and using "Second" flow
  And Click on next page
  And Click on next page
  And Forwarding Tickets
  And Verifying Ticket
  And Price your Tickets based on  ticket count:"1" and ticket per ticket price:"1000"
  And My Listings
  And Update List price per ticket:"200" and ticket count:"1"

 @SecondaryFlow@SellticketsPaytminsiderFirst@buyerandseller@selva
 Scenario: To verify user able to sell their tickets using Paytminsider
  Given Select"Bengaluru" City
  Given Login to Secondary Portal
  And Select event name:"Disco Garba - Vol 05 - Open Air - Dandiya Festival | Navratri 2024" using "First" flow
  When Navigate to Sell your tickets quickly and select platform type "Paytm Insider" and using "First" flow
  And Click on next page
  And Click on next page
  And Forwarding Tickets
  And Verifying Ticket
  And Price your Tickets based on  ticket count:"1" and ticket per ticket price:"1000"
  And My Listings
  And Update List price per ticket:"200" and ticket count:"1"

 @SecondaryFlow@Buyingtickets@buyerandseller@selva
 Scenario: To verify user able to Buy new tickets in TMT platform
  Given Select"Bengaluru" City
  Given Login to Secondary Portal
  And Select event name:"Disco Garba - Vol 05 - Open Air - Dandiya Festival | Navratri 2024" using "First" flow
  And Buying ticket

 @Primaryflow@CreateEventflow@Smoke
 Scenario: To verify user able to create event details
  Given Updating details on Whats your event about page Visibility:"Public" and Eventtype:"Online"
  When Click on next page
And Updating details on Whenandwhere page for Eventtype:"Online" and location:"NA"
And Click on next page
And Uploading Main Event Image
And Image Selection
And Click on next page
And Add Event Description
And Click on next page
And Add Phone Number
And Click on next page
And Fetch OTP
And Lets Add tickets type as "Paid" and payer is "Me" and Available for sale:"Yes"
And Click on next page
And Get to know your Audience-Questiontype:"Email" and listtype "Email"
And Get to know your Audience-Questiontype:"New" and listtype "Dropdown"
And Click on next page
And Identity verificationtype:"Registered"
And Validate Event submitted confirmation


 @Primaryflow@CreateEventflow2@Smoke
 Scenario: To verify user able to create event details2
  Given Updating details on Whats your event about page Visibility:"Public" and Eventtype:"In person"
When Click on next page
And Updating details on Whenandwhere page for Eventtype:"In person" and location:"NotListed"
And Click on next page
And Click on next page
And Uploading Main Event Image
And Image Selection
And Click on next page
And Add Event Description
And Click on next page
And Add Phone Number
And Click on next page
And Fetch OTP
And Lets Add tickets type as "Paid" and payer is "Me" and Available for sale:"Yes"
And Click on next page
And Get to know your Audience-Questiontype:"New" and listtype "Dropdown"
And Click on next page
And Identity verificationtype:"Registered"
And Validate Event submitted confirmation


 @Primaryflow@CreateEventflow3@Selva
 Scenario: To verify user able to create event details3
  Given Updating details on Whats your event about page Visibility:"Private" and Eventtype:"In person"
When Click on next page
And Updating details on Whenandwhere page for Eventtype:"In person" and location:"Listed"
And Click on next page
And Uploading Main Event Image
And Image Selection
And Click on next page
And Add Event Description
And Click on next page
And Add Phone Number
And Click on next page
And Fetch OTP
And Lets Add tickets type as "Free" and payer is "NA" and Available for sale:"NA"
And Click on next page
And Get to know your Audience-Questiontype:"Email" and listtype "Email"
And Get to know your Audience-Questiontype:"New" and listtype "Dropdown"
And Click on next page
And Identity verificationtype:"Not-Registered"
And Validate Event submitted confirmation

