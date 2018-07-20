package dummy;

import java.util.Date;
import java.util.List;

import models.Product;
public class DummyReceipt {
	public String customerName;
	public String customerAddress;
	public String customerContact;
	public String receiptId;
	public Date receiptDate;
	public float prevDue;
	public float dueNow;
	public float unitCost;
	public float totalPrice;
	public float amountPaid;
	public List<Product> prodList;
}

