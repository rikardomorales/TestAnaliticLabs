/**
*
* Classname: Concessionaire
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Concessionaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concessionaire.findAll", query = "SELECT c FROM Concessionaire c"),
    @NamedQuery(name = "Concessionaire.findById", query = "SELECT c FROM Concessionaire c WHERE c.id = :id"),
    @NamedQuery(name = "Concessionaire.findByName", query = "SELECT c FROM Concessionaire c WHERE c.name = :name")})
public class Concessionaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "concessionaireId")
    private List<Bus> busList;

    public Concessionaire() {
    }

    public Concessionaire(Long id) {
        this.id = id;
    }

    public Concessionaire(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
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
        if (!(object instanceof Concessionaire)) {
            return false;
        }
        Concessionaire other = (Concessionaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analiticlabs.test.model.Concessionaire[ id=" + id + " ]";
    }
    
}
