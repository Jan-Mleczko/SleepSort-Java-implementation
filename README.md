# Implementacja _sleep sort_ w Javie

```
C:\Users\Dell\Java> java SleepSort
Dlugosc tablicy liczb? 5
Liczba do tablicy? 2
Liczba do tablicy? 5
Liczba do tablicy? 1
Liczba do tablicy? 2
Liczba do tablicy? 4
Tablica PRZED sortowaniem:
  2,5,1,2,4

Sortowanie...

Tablica PO sortowaniu:
  1,2,2,4,5

C:\Users\Dell\Java> _
```

Jest to moja implementacja algorytmu sortowania tablic _sleep sort_ w języku programowania Java SE 8. Algorytm ten został wymyślony (nie przeze mnie) głównie jako żart i mimo, że działa ma wiele wad pozbawiających go sensu praktycznego. Za to opiera się on na wielowątkowości, zatem jego implementacja demonstruje zastosowanie wątków w Javie.

* Dane liczbowe do uporządkowania są wprowadzane z klawiatury.
* Rozwiązanie ma szansę działać niezależnie od systemu operacyjnego i istniejącego w nim systemu wątków dzięki wyborowi języka Java posiadającego wartswę pośrednią jaką jest JVM.
* Metoda dopisująca element do tablicy wyjściowej ma kwalifikator `synchronized` chroniący ją przed byciem wywołaną jednocześnie przez kilka wątków, co mogłoby zakłócić jej pracę.

## Instalacja

Do skompilowania i uruchomienia programu potrzebujesz mieć zainstalowany pakiet Java JDK. Pobierz wszystkie pliki źródłowe Java z repozytorium do jednego katalogu, wejdź do tego katalogu w wierszu polecenia i wydaj polecenia `javac SleepSort.java`, a potem `java SleepSort`. By uruchomić program jeszcze raz wystarczy powtórzyć drugie polecenie.

### Lista plików kodu źródłowego

* `SleepSort.java` - główny
* `SleepSortDocelowa.java`
* `SleepSortWpisywacz.java`

## Na czym polega _sleep sort_

Zaimplementowany algorytm działa następująco. Mamy wejściową tablicę liczb naturalnych oraz początkowo pustą tablicę wyjściową. Każdy element tablicy wejściowej jest dopisywany na koniec tablicy wyjściowej, ale w osobnym wątku i z opóźnieniem proporcjonalnym do jego wartości. Większe elementy zostaną dopisane z większym opóźnieniem, gdy mniejsze znajdą się już w tablicy wyjściowej wcześniej.

Korzystanie z wielowątkowości jest więc silnie zakorzenione w tym algorytmie.
