# DiscountCalculator
Założenia:
* Rabat i cena produktu nie mogą być ujemne.
* Nazwa produktu nie może być null'em.
* Rabat przydzielany do danego produktu jest zaokrąglany do dwóch liczb po przecinku.
Wszelkie różnice, zostają dodane do ostatniego produktu.
* Wszelkie obliczenia związane z przyznawaniem rabatu dokonywane są w koszyku (ShoppingCart.class), po otrzymaniu listy produktów.

## Opis projektu:
wszelkie interakcje z użytkownikiem wykonywane są przy pomocy terminala. 

## Sposób użycia:
* Po uruchomieniu aplikacji (main.class) użytkownik proszony jest o podanie wysokości rabatu. Jeżeli wprowadzona wartość jest niepoprawna (nie jest liczbą), wtedy wartość rabatu ustawiana jest na 0. Jeżeli jest ujemna, zostaje rzucony wyjątek IllegalDiscountArgumentException.

* Następnie, użytkownik proszony jest o ręczne wprowadzenie kolejno pięciu produktów w formacie "nazwa_produktu, cena". Jeżeli dane produktu nie są podane w powyższym formacie, produkt nie zostaje dodany do koszyka. Jeżeli cena produktu jest niepoprawna (nie jest liczbą), zostaje ustawiona na 0. Jeżeli jest ujemna, zostaje rzucony wyjątek IllegalProductArgumentException.

* Możliwe jest wprowadzenie tylku kilku produktów. W tym celu należy pominąć wprowadzenie produktu naciskając 'Enter'.

* Po wprowadzeniu produktów zostaje wyświetlona lista produktów, wraz z ich nazwą, ceną i przyznanym rabatem.
