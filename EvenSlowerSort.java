
public class EvenSlowerSort extends MiniJava {


  public static void slowSort(int[] array) {

    if (array.length == 0) {
      writeConsole("Das sortierte Array ist: {}");
    } else {
      int start, ende;
      start = 0;
      ende = array.length - 1;
      slowSorthelp(array, start, ende);
    }
  }


  public static int[] slowSorthelp(int[] array, int start, int ende) {

    if (start >= ende) { // schauen, ob Eingabe richtig und ob am Ende der Berechnung angelangt
      return array;
    }

    else {
      int mitte = (start + ende) / 2;

      slowSorthelp(array, start, mitte);
      slowSorthelp(array, mitte + 1, ende);

      if (array[ende] < array[mitte]) { // Tauschprozess
        int help = array[ende];
        array[ende] = array[mitte];
        array[mitte] = help;
      }
      slowSorthelp(array, start, ende - 1);
    }
    return array;
  }


  public static void evenSlowerSort(int[] array) {
    if (array.length == 0) {
      writeConsole("Das sortierte Array ist: {}");
    } else {
      int anfang = 0;
      int ende = array.length - 1;
      evenSlowerSorthelp(array, anfang, ende);
    }
  }


  public static int[] evenSlowerSorthelp(int[] array, int anfang1, int ende3) {


    if (anfang1 >= ende3) { // schauen, ob Eingabe richtig und ob am Ende der Berechnung angelangt
      return array;
    }

    else {

      int ende1 = anfang1 + ((ende3 - anfang1) / 3);
      int ende2 = ende1 + ((ende3 - anfang1) / 2);
      
      if (anfang1 < ende1) { //sortieren
        evenSlowerSorthelp(array, anfang1, ende1);
      }
      if (ende1 + 1 < ende2) { 
        evenSlowerSorthelp(array, ende1 + 1, ende2);
      }
      if (ende2 + 1 < ende3) {
        evenSlowerSorthelp(array, ende2 + 1, ende3);
      }

      if (array[ende2] < array[ende1]) { // kleines array und mittleres array
        int help = array[ende2];
        array[ende2] = array[ende1];
        array[ende1] = help;
      }
      if (array[ende3] < array[ende2]) { // mittleres array und großes array
        int help = array[ende3];
        array[ende3] = array[ende2];
        array[ende2] = help;
      }
      slowSorthelp(array, anfang1, ende3 - 1);
    }
    return array;
  }



  public static void print(int[] array) {
    String str = "{" + array[0];
    for (int i = 1; i < array.length; i++) {
      str += ", ";
      str += array[i];
    }
    str += "}";
    writeLineConsole(str);
  }


  public static void main(String[] args) {
    int x = readInt("Bitte geben Sie ein, wie viele Zahlen Ihr Array hat:"); // alle Zahlen eingeben

    while (x < 0) {
      x = readInt("Die Zahl muss größer oder gleich 0 sein");
    }

    int[] test = new int[x];
    for (int i = 0; i < x; i++) {
      test[i] = read("Bitte geben Sie Ihre " + (i + 1) + ". Zahl ein:");
    }


    evenSlowerSort(test);

    if (x > 0) {
      writeConsole("Das sortierte Array ist: ");
      print(test);
    }
  }
}
