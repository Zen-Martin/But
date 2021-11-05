@Web
Feature: Re-Test Cases for Ikea Website without account Access
  Background:
    Given I am on the homePage
    And I connect to my account

  @severity=minor
  @bug_1824
  Scenario: Breadcrumb link not working
    When Click on the link *Accueil BUT* located in Ariadne's thread
    Then No redirection is made, the customer area page remains displayed

#  @severity=minor
#  @recommandation_1827
#  Scenario: Add a space between the product name and the quantity
#    When Choose an article and add to the cart
#    And Click on *Terminer ma commande*, and click on *Valider mon panier*
#    And Choose the mode *Retrait sur RDV*, and choose a day and time of collection
#    And Click on *Finaliser ma commande*
#    Then At the section *Mes produits*,the text *quantité* is stuck to the title of the product

#  @severity=critical
#  @recommandation_1853
#  Scenario: Make the shop change explicit
#    When Click on the "choisir mon magasin" link located next to the login
#    And Enter the postcode "77250" and click on the search icon
#    And Click on the shop "BUT MONTEREAU " then click on "voir la fiche de mon magasin"
#    And The "BUT MONTEREAU" shop has automatically become the default store default shop, which can be seen above the navigation bar.
#    And The shop icon has the name "Montereau"
#    And Click on the "Montereau" shop icon, then on the "changer de magasin" link
#    And Click on one of the red dots on the map and click on "voir la fiche" Change shop again
#    Then Allow the user to "consciously" validate their choice of store before
#    And put a pop up to notify that the shop has been changed
#    But The change of shop is done by clicking on the link "voir la fiche" of the shop.

#  @severity=minor
#  @bug_1871
#  Scenario: Text out of the frame of the button
#    When Go to "https://www.but.fr/produits/3663738229159/Chambre-Complete-140x200-cm-Avec-Armoire-188cm-Eleos.html"
#    And Click on "Ajouter au panier" and click on "Terminer ma commande"
#    And Validate the cart
#    And Click on the information icon to the right of the drop-down list "Je sélectionne mon mode de livraison"
#    Then The text "Livraison au pied de votre habitation ou en bas de votre immeuble" is beyond the scope of the button