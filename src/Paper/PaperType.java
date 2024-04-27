package Paper;

public enum PaperType {
    REGULAR(3),
    GLOSSY(5),
    NEWSPAPER(1);

    private double price;

    PaperType(double price){
        this.price = price;
    }

    double getPrice(){
        return this.price;
    }
}
