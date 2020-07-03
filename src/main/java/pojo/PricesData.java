package pojo;

public class PricesData {

    private String product;
    private int id;
    private String usd;
    private String eur;
    private String pnd;

    public PricesData(String product, int id, String usd, String eur, String pnd){
        this.setProduct(product);
        this.setId(id);
        this.setUsd(usd);
        this.setEur(eur);
        this.setPnd(pnd);
    }

    // region Getters
    public String getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public String getUsd() {
        return usd;
    }

    public String getEur() {
        return eur;
    }

    public String getPnd() {
        return pnd;
    }

    //endregion

    // region Setters
    public void setProduct(String product) {
        this.product = product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public void setPnd(String pnd) {
        this.pnd = pnd;
    }

    //endregion
}