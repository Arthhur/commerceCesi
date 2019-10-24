package fr.cesi.commerce.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	
	private String nom = "" ;
	
	 @OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(joinColumns={@JoinColumn(name="category_ID", referencedColumnName="id")}
	    , inverseJoinColumns={@JoinColumn(name="product_ID", referencedColumnName="id")})
    private Collection<Product> products ;
	 
	public Category() {
	}

	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
