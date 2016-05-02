/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blooddonation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Anon
 */
@Entity
@Table(name = "donor", catalog = "blooddonationsystemdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Donor_1.findAll", query = "SELECT d FROM Donor_1 d"),
    @NamedQuery(name = "Donor_1.findByDonorID", query = "SELECT d FROM Donor_1 d WHERE d.donorID = :donorID"),
    @NamedQuery(name = "Donor_1.findByDonorName", query = "SELECT d FROM Donor_1 d WHERE d.donorName = :donorName"),
    @NamedQuery(name = "Donor_1.findByDonorAmount", query = "SELECT d FROM Donor_1 d WHERE d.donorAmount = :donorAmount"),
    @NamedQuery(name = "Donor_1.findByDonorBloodBank", query = "SELECT d FROM Donor_1 d WHERE d.donorBloodBank = :donorBloodBank"),
    @NamedQuery(name = "Donor_1.findByDonorNumber", query = "SELECT d FROM Donor_1 d WHERE d.donorNumber = :donorNumber"),
    @NamedQuery(name = "Donor_1.findByDonorBType", query = "SELECT d FROM Donor_1 d WHERE d.donorBType = :donorBType")})
public class Donor_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Donor_ID")
    private Integer donorID;
    @Column(name = "Donor_Name")
    private String donorName;
    @Column(name = "Donor_Amount")
    private Integer donorAmount;
    @Column(name = "Donor_BloodBank")
    private String donorBloodBank;
    @Column(name = "Donor_Number")
    private Integer donorNumber;
    @Column(name = "Donor_BType")
    private String donorBType;

    public Donor_1() {
    }

    public Donor_1(Integer donorID) {
        this.donorID = donorID;
    }

    public Integer getDonorID() {
        return donorID;
    }

    public void setDonorID(Integer donorID) {
        Integer oldDonorID = this.donorID;
        this.donorID = donorID;
        changeSupport.firePropertyChange("donorID", oldDonorID, donorID);
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        String oldDonorName = this.donorName;
        this.donorName = donorName;
        changeSupport.firePropertyChange("donorName", oldDonorName, donorName);
    }

    public Integer getDonorAmount() {
        return donorAmount;
    }

    public void setDonorAmount(Integer donorAmount) {
        Integer oldDonorAmount = this.donorAmount;
        this.donorAmount = donorAmount;
        changeSupport.firePropertyChange("donorAmount", oldDonorAmount, donorAmount);
    }

    public String getDonorBloodBank() {
        return donorBloodBank;
    }

    public void setDonorBloodBank(String donorBloodBank) {
        String oldDonorBloodBank = this.donorBloodBank;
        this.donorBloodBank = donorBloodBank;
        changeSupport.firePropertyChange("donorBloodBank", oldDonorBloodBank, donorBloodBank);
    }

    public Integer getDonorNumber() {
        return donorNumber;
    }

    public void setDonorNumber(Integer donorNumber) {
        Integer oldDonorNumber = this.donorNumber;
        this.donorNumber = donorNumber;
        changeSupport.firePropertyChange("donorNumber", oldDonorNumber, donorNumber);
    }

    public String getDonorBType() {
        return donorBType;
    }

    public void setDonorBType(String donorBType) {
        String oldDonorBType = this.donorBType;
        this.donorBType = donorBType;
        changeSupport.firePropertyChange("donorBType", oldDonorBType, donorBType);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorID != null ? donorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor_1)) {
            return false;
        }
        Donor_1 other = (Donor_1) object;
        if ((this.donorID == null && other.donorID != null) || (this.donorID != null && !this.donorID.equals(other.donorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blooddonation.Donor_1[ donorID=" + donorID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
