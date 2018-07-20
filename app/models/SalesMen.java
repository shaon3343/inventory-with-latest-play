package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.avaje.ebean.Model;
/*import play.db.ebean.Model;
import play.db.ebean.Model.Finder;*/

@Entity
@Table(name="sales_man")
public class SalesMen extends Model {
	@Id
	public Long id;
	
	/*@OneToMany
	@JoinColumn(name="cust_receipt_id", referencedColumnName="receipt_id")
	public Receipts custReceiptId;*/
	/*@Column(name = "cust_receipt_id")
	public String custReceiptId;*/
	
	@Column(name = "sales_name")
	public String salesManName;
	
	@Column(name = "sales_address")
	public String salesManAddress;
	
	@Column(name = "sales_contact")
	public String salesManContact;
	
	@Column(name = "sales_tot_due")
	public float salesManTotalDue;
	
	private static Finder<Integer, SalesMen> find = new Finder<>(SalesMen.class);
	
	public static List<SalesMen> all() {
		return find.all();
	}

	public static SalesMen findById(int id){
		return find.byId(id);

	}
	public static SalesMen findById(Long id){
		return find.byId(Integer.parseInt(id+""));

	}
	 public static Map<String,String> getSalesMenAsMap() {
	        LinkedHashMap<String,String> salesMenList = new LinkedHashMap<String,String>();
	        for(SalesMen men: SalesMen.find.orderBy("salesManName").findList()) {
	        	salesMenList.put(men.id.toString(), men.salesManName);
	        }
	        
	        return salesMenList;
	    }

	public static void create(SalesMen salesMan) {
		salesMan.save();
		
	}
	
	public static void update(SalesMen salesMan) {
		salesMan.update();
		
	}
	
	public static void delete(Long id){
		delete(id);
	}
	
}
