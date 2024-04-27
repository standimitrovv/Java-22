import Paper.Paper;

public class Publication {
    private String title;
    private int pageCount;
    private Paper paper;

    Publication(String title, int pageCount, Paper paper){
        this.title = title;
        this.pageCount = pageCount;
        this.paper = paper;
    }

    String getTitle(){
        return this.title;
    }

    int getPageCount(){
        return this.pageCount;
    }

    double getPrice(){
        return this.pageCount * this.paper.getPricePerSheet();
    }
}
