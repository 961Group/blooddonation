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
@Table(name = "patient", catalog = "blooddonationsystemdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Patient_1.findAll", query = "SELECT p FROM Patient_1 p"),
    @NamedQuery(name = "Patient_1.findByPatientID", query = "SELECT p FROM Patient_1 p WHERE p.patientID = :patientID"),
    @NamedQuery(name = "Patient_1.findByPatientFullName", query = "SELECT p FROM Patient_1 p WHERE p.patientFullName = :patientFullName"),
    @NamedQuery(name = "Patient_1.findByPatientInfo", query = "SELECT p FROM Patient_1 p WHERE p.patientInfo = :patientInfo"),
    @NamedQuery(name = "Patient_1.findByPatientBloodBank", query = "SELECT p FROM Patient_1 p WHERE p.patientBloodBank = :patientBloodBank"),
    @NamedQuery(name = "Patient_1.findByPatientAmount", query = "SELECT p FROM Patient_1 p WHERE p.patientAmount = :patientAmount"),
    @NamedQuery(name = "Patient_1.findByPatientBType", query = "SELECT p FROM Patient_1 p WHERE p.patientBType = :patientBType")})
public class Patient_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Patient_ID")
    private Integer patientID;
    @Column(name = "Patient_FullName")
    private String patientFullName;
    @Column(name = "Patient_Info")
    private String patientInfo;
    @Column(name = "Patient_BloodBank")
    private String patientBloodBank;
    @Column(name = "Patient_Amount")
    private Integer patientAmount;
    @Column(name = "Patient_BType")
    private String patientBType;

    public Patient_1() {
    }

    public Patient_1(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        Integer oldPatientID = this.patientID;
        this.patientID = patientID;
        changeSupport.firePropertyChange("patientID", oldPatientID, patientID);
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        String oldPatientFullName = this.patientFullName;
        this.patientFullName = patientFullName;
        changeSupport.firePropertyChange("patientFullName", oldPatientFullName, patientFullName);
    }

    public String getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(String patientInfo) {
        String oldPatientInfo = this.patientInfo;
        this.patientInfo = patientInfo;
        changeSupport.firePropertyChange("patientInfo", oldPatientInfo, patientInfo);
    }

    public String getPatientBloodBank() {
        return patientBloodBank;
    }

    public void setPatientBloodBank(String patientBloodBank) {
        String oldPatientBloodBank = this.patientBloodBank;
        this.patientBloodBank = patientBloodBank;
        changeSupport.firePropertyChange("patientBloodBank", oldPatientBloodBank, patientBloodBank);
    }

    public Integer getPatientAmount() {
        return patientAmount;
    }

    public void setPatientAmount(Integer patientAmount) {
        Integer oldPatientAmount = this.patientAmount;
        this.patientAmount = patientAmount;
        changeSupport.firePropertyChange("patientAmount", oldPatientAmount, patientAmount);
    }

    public String getPatientBType() {
        return patientBType;
    }

    public void setPatientBType(String patientBType) {
        String oldPatientBType = this.patientBType;
        this.patientBType = patientBType;
        changeSupport.firePropertyChange("patientBType", oldPatientBType, patientBType);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient_1)) {
            return false;
        }
        Patient_1 other = (Patient_1) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blooddonation.Patient_1[ patientID=" + patientID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
