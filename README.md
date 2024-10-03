## Aufgabe 1

#### Wie kann diese Kommunikationsverbindung nun dennoch mit Hilfe einer zusätzlichen „Fabrik“-Klasse, welche die dazu notwendige Objekt-Erzeugung übernimmt, aufgebaut werden? In welchem Package sollte diese zusätzliche Klasse liegen?

Die "Fabrik"-Klasse enthält eine statische Methode zur erzeugung eines GermanTranslator Objekts.
In der Methode wird ein GermanTranslator Objekt erzeugt und das aktuelle Datum eingelesen, richtig Formatiert und mit der Methode setDate gesetzt.
Die Methode gibt das erzeugte Objekt zurück.

#### Welches Entwurfsmuster (engl.: design pattern) könnte für die Problematik der Objekt-Erzeugung verwendet werden? Was ist der software-technische Nutzen bei der Verwendung des Entwurfsmusters?

Hier sollte das Entwurfsmuster "Factory Method" benutzt werden.
Ein Vorteil ist die Entkopplung der Erzeugung von Objekten, wodurch der Code flexibler bleibt, da Anpassungen
nur an einer Stelle erfolgen müssen. Eine Einheitlichere Gestaltung der Objekterzeugung wird dadurch auch erleichtert.

#### Wie muss man den Source Code des Interface ggf. anpassen, um mögliche auftretende Kompilierfehler zu beseitigen?
Die Anpassung der Versionsnummer ist aktuell nicht möglich, das führt zwar nicht zu Kompilierfehlern, ist aber nicht so schön für die Versionskontrolle.

____
## Aufgabe 3

#### Was ist der Vorteil einer separaten Test-Klasse?
Durch die Separierung bleibt der Code übersichtlicher. Außerdem können mehrere Personen gleichzeitig an Tests schreiben, ohne den original Code zu verändern, wodurch die Integrität erhalten bleibt. Zuletzt werden die Test-Cases am Ende nicht dem Kunden mit übergeben.

#### Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?
Die Blackbox-Tests sollten möglichst alle Testcases betrachten, was bei größeren Programmen sehr viel Aufwand werden kann. Geht es zum Beispiel um Zahlenwerte, kann der Aufwand eingegrenzt werden. Sollen beispielsweise negative Zahlen nicht erlaubt sein, reicht es einige wenige negative Zahlen zu testen.

#### Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?

Die Methode display ist void und hat somit keinen Rückgabewert. Das Ergebnis der Methode wird auf dem Bildschirm ausgegeben. 
Dadurch kann die Test-Klasse die Ausgabe nicht überprüfen.