package Paper;

public enum PaperSize {
    A1(5),
    A2(4),
    A3(3),
    A4(2),
    A5(1);

    private double price;

    PaperSize(double price){
        this.price = price;
    }

    double getPrice(){
        return this.price;
    }
}
