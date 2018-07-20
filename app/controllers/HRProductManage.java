
package controllers;

import java.util.Date;
import java.util.List;

import models.Product;
import models.SalesMen;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;
import play.data.*;
import play.*;
import play.mvc.Http;
import play.mvc.Result;
import util.AppConst;
import views.html.setInventory.*;

public class HRProductManage extends Controller{

	static Form<Product> ProductForm = Form.form(Product.class);
	static Form<SalesMen> salesManForm = Form.form(SalesMen.class);
	
	
	/*salesMan CRUD Start */
	
	public static Result createSalesMan() {
        return ok(insertSalesMan.render(salesManForm));
    }
	 public static Result saveSalesMan() {
		 Form<SalesMen> filledForm = salesManForm.bindFromRequest();
		 SalesMen salesMan = filledForm.get();
		 
		 SalesMen.create(salesMan);
	   	 flash("success", AppConst.SUCCESS_MESSAGE);
	     //return ok("");
	   	return redirect(controllers.routes.HRProductManage.salesMenList());
	 }
	
	 public static Result salesMenList(){
	    	List<SalesMen> sMen = SalesMen.all();
	     	return ok(salesMenList.render(sMen));
	    }

	 
	 public static Result salesManShow(Long id) {
		  SalesMen s = SalesMen.findById(id);
					
		  	if (s == null) {
				flash("error", AppConst.ERROR_MESSAGE_ID_NOT_FOUND);
//				return ok("");
				return redirect(controllers.routes.HRProductManage.salesMenList());
			} else
				return ok(salesManShow.render(s));
		}
	 
	 public static Result salesManEdit(Long id) {
		 SalesMen s = SalesMen.findById(id);
			
		  	if (s == null) {
				flash("error", AppConst.ERROR_MESSAGE_ID_NOT_FOUND);
				//return ok("");
				return redirect(controllers.routes.HRProductManage.show(id));
			}else
				return ok(salesManEdit.render(salesManForm.fill(s)));
		}
	 
	 
	 public static Result salesManupdate(){
			Form<SalesMen> filledForm = salesManForm.bindFromRequest();
			if (filledForm.hasErrors()) {
				return badRequest(salesManEdit.render(filledForm));
			} else {
			
				SalesMen s = filledForm.get();
			
			Long sId = s.id;
			
			SalesMen man = SalesMen.findById(sId);
			man.salesManName = s.salesManName;
			man.salesManAddress = s.salesManAddress;
			man.salesManContact = s.salesManContact;
			man.salesManTotalDue = s.salesManTotalDue;
			
			SalesMen.update(man);
			
			return ok(salesMenList.render(SalesMen.all()));
		}
			
		}
	 
	 public static Result deleteSalesMan(Long id){
		 SalesMen.delete(id);
		 flash("success", AppConst.SUCCESSFUL_DELETE_MESSAGE);
		 return ok(salesMenList.render(SalesMen.all()));
	 }
	
	 /* CRUD SalesMan END */
	
	public static Result create() {
        return ok(create.render(ProductForm));
    }
	 public static Result save() {
		 Form<Product> filledForm = ProductForm.bindFromRequest();
		 Product product = filledForm.get();
		 
		 Product.create(product);
	   	 flash("success", AppConst.SUCCESS_MESSAGE);
	     //return ok("");
	   	return redirect(controllers.routes.HRProductManage.list());
	 }

	 public static Result list(){
	    	List<Product> Products = Product.all();
	     	return ok(list.render(Products));
	    }

	 
	 public static Result show(Long id) {
			Product prod = Product.findById(id);
					
		  	if (prod == null) {
				flash("error", AppConst.ERROR_MESSAGE_ID_NOT_FOUND);
//				return ok("");
				return redirect(controllers.routes.HRProductManage.list());
			} else
				return ok(show.render(prod));
		}
	 
	 public static Result edit(Long id) {
		 Product prod = Product.findById(id);
			
		  	if (prod == null) {
				flash("error", AppConst.ERROR_MESSAGE_ID_NOT_FOUND);
				//return ok("");
				return redirect(controllers.routes.HRProductManage.show(id));
			}else
				return ok(edit.render(ProductForm.fill(prod)));
		}
	 
	 
	 public static Result update(){
			Form<Product> filledForm = ProductForm.bindFromRequest();
			if (filledForm.hasErrors()) {
				return badRequest(edit.render(filledForm));
			} else {
			
			Product p = filledForm.get();
			
			Long ProductId = p.id;
			
			Product prod = Product.findById(ProductId);
			prod.productName = p.productName;
			prod.productCode = p.productCode;
			prod.productPrice = p.productPrice;
			prod.productQty = p.productQty;
			
			Product.update(prod);
			
			return ok(list.render(Product.all()));
			}
			
		}
	 
	 public static Result delete(Long id){
		 Product.delete(id);
		 flash("success", AppConst.SUCCESSFUL_DELETE_MESSAGE);
		 return ok(list.render(Product.all()));
	 }
	 
	 
}


