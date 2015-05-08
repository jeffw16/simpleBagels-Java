import java.util.*;

class Bagels {
  String bagel = "";
  String result = "";
  String guess = "";
  public Bagels ( String bagel ) {
    this.bagel = bagel;
  }
  public boolean checkCombo ( String guess ) {
    this.guess = guess;
    String result = "";
    String[] chunks = new String[bagel.length()];
    for ( int i = 0; i < chunks.length; i++ ) {
      chunks[i] = bagel.substring( i, i+1 );
    }
    for ( int j = 0; j < bagel.length(); j++ ) {
      if ( guess.substring( j, j+1 ).equals( chunks[j] ) ) {
        result += bagel.substring( j, j+1 );
      } else {
        boolean within = false;
        int k = 0;
        while ( !within && k < chunks.length ) {
          if ( guess.substring( j, j+1 ).equals( chunks[k] )) {
            result += "!";
            within = true;
          }
          k++;
        }
        if ( !within ) {
          result += "?";
        }
      }
    }
    this.result = result;
    if ( guess.equals ( this.result ) ) {
      return true;
    } else {
      return false;
    }
  }
  public String toString () {
    String ret = "";
    if ( this.guess != this.result ) {
      for ( int i = 0; i < this.result.length(); i++ ) {
        if ( this.result.charAt(i) == this.guess.charAt(i) ) {
          ret += "[Fermi]";
        } else if ( this.result.charAt(i) == '!' ) {
          ret += "[Pico]";
        }
      }
    }
    if ( ret == "" ) {
      ret += "[Bagels]";
    }
    return ret;
  }
}
