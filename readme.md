In een hotel zijn niet alle verdiepingen toegelaten voor alle gebruikers.
Een gebruiker identificeert zich door zijn badge te scannen.
Als deze gebruiker niet naar een verdieping mag gaan dan
wordt de knop voor deze verdieping inactief gemaakt.

De badge geeft aan wat de mogelijkheden zijn in de lift.  
* Een gebruiker zonder badge mag de lift niet gebruiken.
* De lobby is vrij toegankelijk voor iedereen.
* De knop voor de huidige verdieping is nooit actief.
* Een gebruiker met badge mag altijd naar verdieping 0 (lobby) en 10 (restaurant).
* Een badge met een kamernummer: deze gebruiker mag naar verdieping 0, de verdieping van zijn eigen kamer, en naar het restaurant.
  * dus bvb: badge "405" heeft toegang tot 0, 4 en 10.
  * Noot: Er zijn enkel kamers op de verdiepingen 1 tot 9.
* Een badge voor personeel ("S" van STAFF) heeft toegang tot alle verdiepingen.   
* Er zijn verdiepingen (<0) waar enkel personeel toegelaten is.

Maak hiervoor een class **Elevator** met een functie **activeButtons**. 
Deze functie heeft 2 parameters: 
* **badge**
  * een String
  * als er geen badge gescanned wordt is dit null
* **currentLevel**
  * een getal
  * dit is een getal tussen -2 en 10.

De functie activeButtons geeft een array (of Collection) van getallen terug.
Deze getallen zijn de knoppen die actief zijn in de lift. 

Als een gebruiker op een verdieping is waar hij niet mag zijn dan moet er een alarm afgaan. 
Dat betekent: de functie activeButtons gooit een Exception.