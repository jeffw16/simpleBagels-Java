import java.util.*;

class BagelsRunner {
  public BagelsRunner() {
    // not much to do here
  }
  public void runBagels () {
    boolean eating = true;
    boolean samegame = true;
    while ( eating ) {
      Bagels b = new Bagels ( "" + ((int)(Math.random() * (999 - 100) + 100)) );
      samegame = true;
      while ( samegame ) {
      System.out.println ( "Try guessing: " );
      Scanner s = new Scanner ( System.in );
      String guess = s.nextLine();
      boolean correct = b.checkCombo ( guess );
      if ( correct ) {
        System.out.println ( "You're right!" );
        System.out.println ( "Want to play again? Y or N" );
        Scanner c = new Scanner ( System.in );
        char playAgainResponse = c.next().charAt(0);
        if ( playAgainResponse == 'N' || playAgainResponse == 'n' ) {
          eating = false;
          System.out.println ( "Bye!" );
        } else {
          System.out.println ( "Rebooting..." );
          samegame = false;
        }
      } else {
        System.out.println ( "No, but here are some clues:" );
        System.out.println ( b );
      }
      }
    }
  }
  public static void main ( String [] args ) {
      System.out.println ( "\n\n\n\n\n" );
      System.out.println ( "simpleBagels Java" );
      System.out.println ( "by Jeffrey Wang" );
      System.out.println ( "All guesses are 3-digit numbers from 100 to 999." );
      System.out.println ( "[Fermi] means your number is at the right position, [Pico] means the position is wrong, [Bagels] means the number is not within the guess." );
      BagelsRunner b = new BagelsRunner();
      b.runBagels();
  }
}
