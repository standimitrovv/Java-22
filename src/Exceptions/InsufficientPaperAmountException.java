package Exceptions;

public class InsufficientPaperAmountException extends Exception{
    private int maxPaperAmount;

    public InsufficientPaperAmountException(int maxPaperAmount){
        this.maxPaperAmount = maxPaperAmount;
    }

    public String toString(){
        return "Insufficient amount of paper! The required amount is " + getMaxPaperAmount() +" sheets";
    }

    private int getMaxPaperAmount(){
        return this.maxPaperAmount;
    }
}
