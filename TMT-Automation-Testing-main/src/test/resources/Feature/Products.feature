#Author: Balachandar FakeStoreAPI's Product Section
@all
Feature: FakeStore Shopping APIs

  Background: Pre-requisite where the inputs recieved from other files(Json)
    * def apibody = read('body.json')
    * def newbody = apibody.NewProduct[0]
    * def updatebody = apibody.UpdateProduct[0]
    * def newcart = apibody.NewCart[0]
    * def updatecart = apibody.UpdateCart[0]


    #-------------------------------------------Products----------------------------------------------------#
  @allproducts
  Scenario: Getting all the product details
    Given url 'https://fakestoreapi.com/products'
    When method GET
    Then status 200

  @oneproduct
  Scenario: Getting a single product detail
    Given url 'https://fakestoreapi.com/products/1'
    When method GET
    Then status 200


  @Limitresult
  Scenario: Limiting the view of existing products detail
    Given url 'https://fakestoreapi.com/products?limit=5'
    When method GET
    Then status 200

  @Sortingresult
  Scenario: Sorting the results of product details from latest to old
    Given url 'https://fakestoreapi.com/products?sort=desc'
    When method GET
    Then status 200

  @allcategories
  Scenario: Gettting all the categories
    Given url 'https://fakestoreapi.com/products/categories'
    When method GET
    Then status 200

  @specific_categry
  Scenario: Getting product details in specific to required category
    Given url 'https://fakestoreapi.com/products/category/jewelery'
    When method GET
    Then status 200

  @new
  Scenario: Adding a new product
    Given url 'https://fakestoreapi.com/products'
    And headers newbody
    When method POST
    Then status 200
    And def NewUserID = response.id
    And print 'Welcome User', response

  @update
  Scenario: Updating an existing product
    Given url 'https://fakestoreapi.com/products/21'
    And headers updatebody
    When method PUT
    Then status 200

  @delete
  Scenario: removing a product from database
    Given url 'https://fakestoreapi.com/products/6'
    When method DELETE
    Then status 200

    #---------------------------------------------Cart----------------------------------------------------#
  @allcarts
  Scenario: Getting all the cart details
    Given url 'https://fakestoreapi.com/carts'
    When method GET
    Then status 200

  @SingleCart
  Scenario:
    Given url 'https://fakestoreapi.com/carts/5'
    When method GET
    Then status 200

  @LimitedCart
  Scenario:
    Given url 'https://fakestoreapi.com/carts?limit=5'
    When method GET
    Then status 200

  @Sortingcart
  Scenario:
    Given url 'https://fakestoreapi.com/carts?sort=desc'
    When method GET
    Then status 200

  @Daterange
  Scenario:
    Given url 'https://fakestoreapi.com/carts?startdate=2019-12-10&enddate=2020-10-10'
    When method GET
    Then status 200

  @getcart
  Scenario:
    Given url 'https://fakestoreapi.com/carts/user/2'
    When method GET
    Then status 200

  @newcart
  Scenario:
    Given url 'https://fakestoreapi.com/carts'
    And headers newcart
    When method POST
    Then status 200

  @updatecart
  Scenario:
    Given url 'https://fakestoreapi.com/carts'
    And headers updatecart
    When method PUT
    Then status 200

  @deletecart
  Scenario:
    Given url 'https://fakestoreapi.com/carts/6'
    When method DELETE
    Then status 200




















