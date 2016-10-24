#Aufgabenstellung Vorprüfungsleistung
####Lehrveranstaltung PM 40401 Mobile Computing
####Dozent: Hans Weghorn, DHBW
####Oktober 2016
###Unicode-Viewer
Entwickeln Sie eine Smartphone-App für Android, mit der UNICODE-Zeichen nach Eingabe ihrer
Hexadezimalcodierung dargestellt werden. Folgende Merkmale sind dabei minimal zu erfüllen:
* Die App muss voll funktionsfähig unter Android 5.0 sein.
* Die numerische Eingabe eines vierstelligen Hexcodes erfolgt ausschließlich über Tastendrücke
auf einem graphischen Ziffernfeld. Löschtasten zur Eingabekorrektur sind ebenfalls vorhanden.
* Für die oberen 8 Bit (Page-Auswahl) und die unteren 8 Bit (Code-Auswahl) stehen zusätzlich
GUI-Elemente zur Verfügung, mit denen diese Teilwerte getrennt voneinander komfortabel
inkrementiert und dekrementiert werden können.
* Der eingegebene 16 Bit-Code und das dazugehörige UNICODE-Zeichen werden angezeigt.
* Für die Ausgabe können folgende Einstellungen über das GUI festgelegt werden:
  - Fontgröße (z.B. 18pt)
  - Fonttyp (z.B. Arial, Times Roman, ...)
  - Fontstil (z.B. normal, kursiv, fett, ...)
  - Schriftfarbe
  - Hintergrundfarbe des Ausgabetextbereichs
* Es ist mindestens die HD-Displaygröße von 1280 x 720 Pixeln zu unterstützten.
* Das GUI wird automatisch für Hoch- oder Querformat ergonomisch und ansprechend angeordnet.
* Alle Eingaben sind bei Pausierung oder Beendigung der App zu speichern und als Voreinstellung
bei der nächsten Aktivierung auf dem Smartphone-Schirm zu verwenden.
* Die Applikation soll über eine Auswahl in der zweiten GUI-Ebende (also nicht Top-Level)
Folgendes ermöglichen:
  - Anzeige eines modalen "About-Dialogs" mit Name und Bild des/der Erstellers/in
  - Echte Beendigung des Konverters 
