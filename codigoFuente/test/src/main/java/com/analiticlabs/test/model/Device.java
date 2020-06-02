/**
*
* Classname: Device
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.id = :id"),
    @NamedQuery(name = "Device.findByIp", query = "SELECT d FROM Device d WHERE d.ip = :ip"),
    @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "bus_Id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bus busId;
    @JsonIgnore
    @JoinColumn(name = "device_Type_Id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Devicetype deviceTypeId;

    public Device() {
    }

    public Device(Long id) {
        this.id = id;
    }

    public Device(Long id, String ip, String status) {
        this.id = id;
        this.ip = ip;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bus getBusId() {
        return busId;
    }

    public void setBusId(Bus busId) {
        this.busId = busId;
    }

    public Devicetype getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Devicetype deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
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
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.analiticlabs.test.model.Device[ id=" + id + " ]";
    }
    
}
