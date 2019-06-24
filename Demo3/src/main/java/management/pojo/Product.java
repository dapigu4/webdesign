package management.pojo;

public class Product {
    private Integer id;
    private String productName;
    private String productSize;
    private Double productCost;
    private Double productSell;
    private Double productProfit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getProductSell() {
        return productSell;
    }

    public void setProductSell(Double productSell) {
        this.productSell = productSell;
    }

    public Double getProductProfit() {
        return productProfit;
    }

    public void setProductProfit(Double productProfit) {
        this.productProfit = productProfit;
    }
}
