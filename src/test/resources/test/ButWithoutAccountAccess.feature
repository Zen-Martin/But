@Web
Feature: Re-Test Cases for But Website without account Access
  Background:
    Given I am on the homePage

  @severity=minor
  @bug_1837
  Scenario: The title is overlaid on the product image
    When Go to But plan site
    And Click on the differents links
    Then A *404-error* page is displayed

  @severity=critical
  @bug_1829
  Scenario: Indefinite loading
    When Click on *Aide & contact* located in the header
    And Click on the button *contactez-nous par email*
    And In the field *j'ai une question à propos de* select *commandes & livraison*
    And In the field *et plus particulièrement* select *Aide pour finaliser ma commande*
    And Enter in the text box and add a file larger than 9.8 Mb
    And Click on *Envoyer*
    Then Indefinite loading

  @severity=critical
  @bug_1833
  Scenario: Unloaded article images
    When In the navigation bar, put the cursor on the tab *Canapé*
    And Click on *Pouf*, and add the filter *pouf*
    And Add for the prices from 329 to 350 and apply
    Then The page of filtered "poofs" is displayed, the images of some articles are not displayed

  @severity=critical
  @bug_1848
  Scenario: No reaction from the "Voir pack" button
    When Go on specific article *Samsung Lave Linge*
    And Click on *Ajouter au panier*
    And Click on *Voir le pack*
    Then No reaction from the button

  @severity=critical
  @recommandation_1851
  Scenario: Make the remove from cart button more explicit
    And Add many articles in the cart
    When Click on *Terminer ma commande* of the last article
    And In the cart click on the cross on one of the articles
    Then Deleted is effective
    But No deletion notification is displayed.

  @severity=minor
  @bug_1856
  Scenario: The aside-to-top element remains visible
    When Scroll down to the section newsletter
    And Click on the button *Inscrivez-vous*
    And Scroll down, click on the aside-to-top icon to page go up
    Then The aside-to-top icon remains visible even though it is already on top

  @severity=minor
  @recommandation_1863
  Scenario: Display the field for the number in the case of choice of newsletter by sms
    And Click on the connection icon
    When Click on the button "M'inscrire"
    And Fill the differents fields of the form, check the box to receive the newsletter "Par SMS"
    Then Provide a field to insert the phone number directly at the selection of this choice
    But No field is displayed for the insertion of the phone number

  @severity=minor
  @recommandation_1864
  Scenario: Reset the fields after subscribing to the newsletter
    And Scroll down to the section "newsletter"
    When Click on the button "Inscrivez-vous"
    And Fill in the newsletter form
    And Click on *Je m'inscris*
    Then Redirect to the home page after registration / reset fields
    But Display of the subscription confirmation message

  @severity=critical
  @bug_1867
  Scenario: Information button not working
    When Click on *Se connecter* in the navigation bar
    And Click on the button to the right of the checkbox *Rester connecté(e)*
    Then No reaction

  @severity=critical
  @bug_1868
  Scenario: Unable to access the product recall pdf
    When Scroll down to the footer
    And Click on *Rappel produits*
    Then An XML code extract mentioning an access error is returned

  @severity=critical
  @bug_1872
  Scenario: Link to a server access error
    When Scroll down to the footer, and unroll the section *L'entreprise*
    And Click on *BUT Cuisines*
    Then An error page specifying a denial of access to the server

  @severity=minor
  @bug_1874
  Scenario:  The "print" button is not functional
    When Unroll the tab "canapé" and click on "canapé" in the list
    And Click on an article
    And Click on *imprimer* located under the link *ajouter à mes envies*
    Then No reaction, the button is not functional

  @severity=minor
  @bug_1882
  Scenario: Unloaded images
    When Go to But Blog Page
    And Scroll down to the section #LesIdéesBut
    Then The images are not loaded