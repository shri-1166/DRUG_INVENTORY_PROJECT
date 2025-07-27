package drug.inventory.management_system.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name ="products")
@Data
public class Product {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String category;
	    private int quantity;
	    private double price;
	    private String description;
	    @Temporal(TemporalType.DATE)
	    private Date expiryDate;
	    @ManyToOne
	    @JoinColumn(name = "supplier_id")
	    private Supplier supplier;
	    private String imagePath;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate;
		}
		public Supplier getSupplier() {
			return supplier;
		}
		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		} 
	    
	    
	    
	    // Stores the file path of the .jpg image
	    
	    
// We use private for Product entity fields to ensure encapsulation, 
//protect data integrity, enable validation via Lombok's @Data-generated getters/setters, 
//align with JPA/Hibernate
//requirements, and enhance maintainability and security.
}
