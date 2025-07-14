package entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CountryManagement")
public class CountryClass {

	    @Id
	    private int country_id;

	    @Column(name = "country_name")
	    private String countryName;
	    
	    @Column(name="capital")
	    private String country_capital;
	    
	    @Column(name="pupulation")
	    private long popul;

	    public CountryClass() {}

		public int getCountry_id() {
			return country_id;
		}

		public void setCountry_id(int country_id) {
			this.country_id = country_id;
		}

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getCountry_capital() {
			return country_capital;
		}

		public void setCountry_capital(String country_capital) {
			this.country_capital = country_capital;
		}

		public long getPopul() {
			return popul;
		}

		public void setPopul(long popul) {
			this.popul =  popul;
		}

		public String toString() 
		{
			return "CountryClass [country_id=" + country_id + ", countryName=" + countryName + ", country_capital="
					+ country_capital + ", popul=" + popul + "]";
		}
}
