package smell;
 
class LineItem {
    private int productId;
    private int imageId;
    private int quantity;
    private int unitPrice;
 
    public LineItem(int productId, int imageId, int quantity) {
        this.productId = productId;
        this.imageId = imageId;
        this.quantity = quantity;
    }
    
    public int getTotalPrice() {
    	return unitPrice * quantity;
    }

	@Override
	public String toString() {
		return "Begin line item \n Product = " + productId + "\n Image = " + imageId + "\n Quantity = " + quantity + "\n Total = "
				+ getTotalPrice() + "\n End line item";
	}
}
