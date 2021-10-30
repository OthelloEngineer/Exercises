public class Exceptions{ // used to call Exceptions
    public static void boundControl (int lowerbound, int upperbound) throws BoundControl{
        throw new BoundControl(lowerbound, upperbound);
    }
    public static void outOfRange (int lowerbound, int upperbound, int number) throws OutOfRange.LowerBoundError, OutOfRange.UpperBoundError {
        OutOfRange error = new OutOfRange(lowerbound, upperbound, number);
    }
}
class BoundControl extends Exception {

    BoundControl(int lowerbound, int upperbound){
        super(upperbound + " is lower than " + lowerbound + ". \n Your upperbound has to at least 2 integer values higher " +
                "than your lower bound");
    }

}

class OutOfRange{
                            // this is getting out of hand! Now there are two of them!
    OutOfRange(int lowerbound, int upperbound, int number) throws LowerBoundError, UpperBoundError {
        if (number <= upperbound) //spicy if statement without else cause exception stops the try block.
            throw new LowerBoundError(lowerbound, number);
        throw new UpperBoundError(upperbound, number);
    }
    static class LowerBoundError extends Exception{
        LowerBoundError(int lowerbound, int number){
            super("your number was: " + number + ". which was below your lowerbound of: " + lowerbound);
        }
    }

    static class UpperBoundError extends Exception{
        UpperBoundError(int upperbound, int number){
            super("your number was: " + number + ". which was above your upperbound of: " + upperbound);
        }
    }


}
