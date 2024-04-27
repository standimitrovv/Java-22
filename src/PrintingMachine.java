import Exceptions.InsufficientPaperAmountException;

public class PrintingMachine {
    private int _maxPaperAmount;
    private int paperAmount;
    private boolean isPrintingColorful;

    PrintingMachine(int paperAmount, boolean isPrintingColorful){
        this.paperAmount = paperAmount;
        this._maxPaperAmount = paperAmount;
        this.isPrintingColorful = isPrintingColorful;
    }

    public void printPublication(Publication publication) throws InsufficientPaperAmountException{

        if(!hasEnoughPaper(publication.getPageCount())){
            throw new InsufficientPaperAmountException(getMaxPaperAmount());
        }

        System.out.println("Title: " + publication.getTitle());
        System.out.println("Length: " + publication.getPageCount());
        System.out.println("Price: "+ publication.getPrice());
        System.out.println("------------------------");

        setPaperAmount(getPaperAmount() - publication.getPageCount());
    }

    private boolean hasEnoughPaper(int pagesToPrint) {
        if(pagesToPrint > getPaperAmount()){
            return false;
        }

        return true;
    }

    private int getMaxPaperAmount(){
        return this._maxPaperAmount;
    }

    private int getPaperAmount(){
        return this.paperAmount;
    }

    private void setPaperAmount(int paperAmount){
        this.paperAmount = paperAmount;
    }
}
