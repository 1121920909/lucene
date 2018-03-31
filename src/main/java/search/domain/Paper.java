package search.domain;

public class Paper {
    private String name;
    private String firstAuthor;
    private String otherAuthor;
    private String journal;
    private String tTime;
    private String fTime;
    private String area;
    private String keyWord;
    private String abtract;
    private String content;
    private String cite;
    private String cited;

    public Paper() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor;
    }

    public String getOtherAuthor() {
        return otherAuthor;
    }

    public void setOtherAuthor(String otherAuthor) {
        this.otherAuthor = otherAuthor;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String gettTime() {
        return tTime;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getAbtract() {
        return abtract;
    }

    public void setAbtract(String abtract) {
        this.abtract = abtract;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getCited() {
        return cited;
    }

    public void setCited(String cited) {
        this.cited = cited;
    }
}
