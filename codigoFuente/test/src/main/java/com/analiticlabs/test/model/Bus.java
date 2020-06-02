/**
*
* Classname: Bus
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findById", query = "SELECT b FROM Bus b WHERE b.id = :id"),
    @NamedQuery(name = "Bus.findByType", query = "SELECT b FROM Bus b WHERE b.type = :type"),
    @NamedQuery(name = "Bus.findByMotor", query = "SELECT b FROM Bus b WHERE b.motor = :motor"),
    @NamedQuery(name = "Bus.findByBreaks", query = "SELECT b FROM Bus b WHERE b.breaks = :breaks")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "motor")
    private String motor;
    @Basic(optional = false)
    @Column(name = "breaks")
    private String breaks;
    @JoinColumn(name = "concessionaire_Id", referencedColumnName = "id")
    @ManyToOne
    private Concessionaire concessionaireId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busId")
    private List<Device> deviceList;

    public Bus() {
    }

    public Bus(Long id) {
        this.id = id;
    }

    public Bus(Long id, String type, String motor, String breaks) {
        this.id = id;
        this.type = type;
        this.motor = motor;
        this.breaks = breaks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getBreaks() {
        return breaks;
    }

    public void setBreaks(String breaks) {
        this.breaks = breaks;
    }

    public Concessionaire getConcessionaireId() {
        return concessionaireId;
    }

    public void setConcessionaireId(Concessionaire concessionaireId) {
        this.concessionaireId = concessionaireId;
    }

    @XmlTransient
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analiticlabs.test.model.Bus[ id=" + id + " ]";
    }
    
}
