package Paper;

public class Paper {
    private PaperType type;
    private PaperSize size;
    private double price;

    public Paper(PaperType type, PaperSize size){
        this.type = type;
        this.size = size;
        this.price = type.getPrice() + size.getPrice();;
    }

    public double getPricePerSheet() {
        return this.price;
    }

    public PaperSize getSize() {
        return size;
    }

    public PaperType getType() {
        return type;
    }
}
