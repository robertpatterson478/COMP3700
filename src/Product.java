
public class Product {
	private int productID;
	private double taxRate, quantityRemaining, price;
	private boolean isMeasuredByWeight;
	private String providerName, providerInfo, productName;
	
	public Product(){
		
	}
	
	public Product(int productIDIn, double priceIn, double taxRateIn, double quantityRemainingIn, boolean isMeasuredByWeightIn, String productNameIn, String providerInfoIn, String providerNameIn){
		productID = productIDIn;
		price = priceIn;
		taxRate = taxRateIn;
		quantityRemaining = quantityRemainingIn;
		isMeasuredByWeight = isMeasuredByWeightIn;
		providerName = providerNameIn;
		providerInfo = providerInfoIn;
		productName = productNameIn;
		
		
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public double getQuantityRemaining() {
		return quantityRemaining;
	}
	public void setQuantityRemaining(double quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}
	public boolean isMeasuredByWeight() {
		return isMeasuredByWeight;
	}
	public void setMeasuredByWeight(boolean isMeasuredByWeight) {
		this.isMeasuredByWeight = isMeasuredByWeight;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderInfo() {
		return providerInfo;
	}
	public void setProviderInfo(String providerInfo) {
		this.providerInfo = providerInfo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
	

}
