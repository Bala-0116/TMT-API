#Author: Balachandar FakeStoreAPI's Product Section
@all
Feature: FakeStore Shopping APIs

  Background: Pre-requisite where the inputs recieved from other files(Json)
    * def apibody = read('body.json')
    * def newbody = apibody.NewProduct[0]
    * def updatebody = apibody.UpdateProduct[0]
    * def newcart = apibody.NewCart[0]
    * def updatecart = apibody.UpdateCart[0]
    * def newuser = apibody.NewUser[0]
    * def updateuser = apibody.UpdateUser[0]
    * def loginbody = apibody.Login[0]


    #-------------------------------------------Products----------------------------------------------------#
  @allproducts
  Scenario: Getting all the product details
    Given url ProductUrl
    When method GET
    Then status 200

  @oneproduct
  Scenario: Getting a single product detail
    Given url ProductUrl + '/1'
    When method GET
    Then status 200


  @Limitresult
  Scenario: Limiting the view of existing products detail
    Given url ProductUrl + '?limit=5'
    When method GET
    Then status 200

  @Sortingresult
  Scenario: Sorting the results of product details from latest to old
    Given url ProductUrl + '?sort=desc'
    When method GET
    Then status 200

  @allcategories
  Scenario: Gettting all the categories
    Given url ProductUrl + '/categories'
    When method GET
    Then status 200

  @specific_categry
  Scenario: Getting product details in specific to required category
    Given url ProductUrl + '/category/jewelery'
    When method GET
    Then status 200

  @new
  Scenario: Adding a new product
    Given url ProductUrl
    And request newbody
    When method POST
    Then status 200
    And def NewUserID = response.id
    And print 'Welcome User', response

  @update
  Scenario: Updating an existing product
    Given url ProductUrl + '/21'
    And request updatebody
    When method PUT
    Then status 200

  @delete
  Scenario: removing a product from database
    Given url ProductUrl + '/6'
    When method DELETE
    Then status 200

    #---------------------------------------------Cart----------------------------------------------------#
  @allcarts
  Scenario: Getting all the cart details
    Given url CartUrl
    When method GET
    Then status 200

  @SingleCart
  Scenario: Getting a single cart detail
    Given url CartUrl + '/5'
    When method GET
    Then status 200

  @LimitedCart
  Scenario: Fetching only limited number of carts
    Given url CartUrl + '?limit=5'
    When method GET
    Then status 200

  @Sortingcart
  Scenario: sorting the carts from latest to Oldest
    Given url CartUrl + '?sort=desc'
    When method GET
    Then status 200

  @Daterange
  Scenario: filtering the cart details for a specific date range
    Given url CartUrl + '?startdate=2019-12-10&enddate=2020-10-10'
    When method GET
    Then status 200

  @getcart
  Scenario: Fetching a particular cart detail
    Given url CartUrl + '/user/2'
    When method GET
    Then status 200

  @newcart
  Scenario: Adding a new cart
    Given url CartUrl
    And request newcart
    When method POST
    Then status 200

  @updatecart
  Scenario: Updating the existing cart
    Given url CartUrl
    And request updatecart
    When method PUT
    Then status 200

  @deletecart
  Scenario: Removing the existing cart
    Given url CartUrl + '/6'
    When method DELETE
    Then status 200

    #----------------------------------------------------User-------------------------------------------------------#

  @alluser
  Scenario: Searching all the user details
    Given url UserUrl
    When method GET
    Then status 200

  @user
  Scenario: Getting a single user detail
    Given url UserUrl + '/1'
    When method GET
    Then status 200

  @limiteduser
  Scenario: getting a limited number of user details
    Given url UserUrl + '?limit=5'
    When method GET
    Then status 200

  @sortuserresult
  Scenario: Sorting the lastest users
    Given url UserUrl + '?sort=desc'
    When method GET
    Then status 200

  @newuser
  Scenario: Adding a new user
    Given url UserUrl
    And request newuser
    When method POST
    Then status 200

  @updateuser
  Scenario: Updating the existing user
    Given url UserUrl + '/7'
    And request updateuser
    When method PUT
    Then status 200

  @delete
  Scenario: Removing the existing user
    Given url UserUrl + '/6'
    When method DEL
    Then status 200

#-------------------------------------------------------Login---------------------------------------------------------#

  @login
  Scenario: Generating token for a new login user
    Given url LoginUrl
    And request loginbody
    When method GET
    Then status 200

















