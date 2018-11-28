import java.util.Scanner;
public class Main {
    public static Boolean escaped = false;

    public static Boolean inFoyer = true;
    public static Boolean inLibrary = false;
    public static Boolean inConservatory = false;
    public static Boolean foyerDoorLocked = true;
    public static Boolean conservatoryDoorLocked = true;
    public static Boolean foyerDoorOpen = false;
    public static Boolean libraryDoorOpen = false;
    public static Boolean libraryDoorLocked = true;
    public static Boolean conservatoryDoorOpen = false;

    public static Boolean chestOpen = false;
    public static Boolean hasMatches = false;
    public static Boolean candlelit = false;

    public static Boolean hasPen = false;
    public static Boolean bookTitles = false;

    public static Boolean TrumpetPlayed = false;
    public static Boolean PianoPlayed = false;
    public static Boolean DrumPlayed = false;

    public static int turnsLeft = 30;
    public static Scanner scan;
    public static String output = "You find yourself in a large foyer. There is a door to the north. To the west is a bench against the wall. To the east is a chest on the floor. In the center of the room is a large candle. The candle is unlit.";

    public static void main(String[] args) {


        System.out.println("Welcome to The House. You have 30 moves to escape. There is a set of verbs and nouns that will allow you to leave in the format of verb (open, close, light, read, write, play, look, get), noun (door, room, bench, chest, candle, note, matches, shelves, book, pen, scroll, music, trumpet, piano, drum, lock), or to move, indicate direction (north, south, east, west). Good luck.\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            turnsLeft--;
        }
        if (escaped = true) {
            System.out.printf("\nCongratulations! You have completed the escape room challenge successfully in with "+turnsLeft+ " moves to spare.");
        }
        else {
            System.out.printf("\nYou have failed the escape room challenge. Try again!");
        }
    }

    public static void gameUsage() {
        if (inFoyer) {
            foyer();
        }
        if (inLibrary) {
            library();
        }
        else if (inConservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("%s You have %d moves left.\n>>", output, turnsLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There is a note on the bench.";
                break;

            case "read note":
                output = "May my light show you the way.";
                break;

            case "look chest":
                output = "the chest is closed.";
                break;

            case "open chest":
                chestOpen = true;
                output = "There are matches in the chest.";
                break;

            case "get matches":
                hasMatches = true;
                output = "You have a box of matches.";
                break;

            case "light candle":
                if (hasMatches) {
                    candlelit = true;
                    foyerDoorLocked = false;
                    output = "The candle is lit. You heard a metal grinding sound from the north.";
                }
                else {
                    output = "You don't have any matches.";
                }
                break;

            case "look door":
                if (!foyerDoorLocked) {
                    if (foyerDoorOpen) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!foyerDoorLocked) {
                    foyerDoorOpen = true;
                    output = "The north door is open.";
                }
                break;

            case "go north":
                if (foyerDoorOpen) {
                    inFoyer = false;
                    inLibrary = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are now in the library and cannot return to the foyer. In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
                }
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, turnsLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look shelf":
            case "look shleves":
                output = "There is a book titled 'The Autobiography of ...' with the rest of the title empty.";
                break;

            case "look book":
                output = "There is a book on the desk.";
                break;

            case "look scroll":
                output = "There is a scroll on the desk. Maybe you should read it?";
                break;

            case "look pen":
                output = "there is a pen on the desk.";
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                break;

            case "get pen":
                hasPen = true;
                output = "You have acquired the pen.";
                break;

            case "write book":
            case "write name":
                bookTitles = true;
                libraryDoorLocked = false;
                output = "You have completed the autobiography You heard a metal grinding sound from the north.";
                break;

            case "look door":
                if (!libraryDoorLocked) {
                    if (libraryDoorOpen) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!libraryDoorLocked) {
                    libraryDoorOpen = true;
                    output = "The north door is open.";
                }
                break;

            case "go north":
                if (libraryDoorOpen) {
                    inLibrary = false;
                    inConservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
                }
                break;

            default:
                output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
        }
    }

    public static void conservatory()  {
        System.out.printf("%s You have %d moves left.\n>>", output, turnsLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {
            case "read music":
                output = "Timbre, Tone, Time";
                break;

            case "play trumpet":
                if (!PianoPlayed && !DrumPlayed) {
                    TrumpetPlayed = true;
                    output = "Encore! Encore! sounds beautiful";
                }
                else {
                    TrumpetPlayed = false;
                    PianoPlayed = false;
                    DrumPlayed = false;
                    output = "Hmm... Something seems to be wrong with the trumpet. Maybe something is stuck inside.";
                }
                break;

            case "play piano":
                if (TrumpetPlayed && !DrumPlayed && !PianoPlayed) {
                    PianoPlayed = true;
                    output = "Encore! Encore! sounds beautiful";
                }
                else {
                    TrumpetPlayed = false;
                    PianoPlayed = false;
                    DrumPlayed = false;
                    output = "Hmm... Something seems to be wrong with the piano. It isn't playing correctly.";
                }
                break;

            case "play drum":
                if (TrumpetPlayed && PianoPlayed && !DrumPlayed) {
                    DrumPlayed = true;
                    output = "Encore! Encore! sounds beautiful";
                }
                else {
                    TrumpetPlayed = false;
                    PianoPlayed = false;
                    DrumPlayed = false;
                    output = "Hmm... Something seems to be wrong with the drum. Maybe its not tuned.";
                }
                break;

            case "open door":
                if (conservatoryDoorLocked & TrumpetPlayed & PianoPlayed & DrumPlayed) {
                    conservatoryDoorOpen = true;
                    output = "The north door is open.";
                }
                break;

            case "go north":
                if (conservatoryDoorOpen) {
                    inConservatory = false;
                    escaped = true;
                    output = " You have left the Conservatory!";
                }
                break;

            default:
                output = "In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
        }
    }
}