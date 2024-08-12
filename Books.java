/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.book.shop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author mustafa khan
 */
@Entity
@Table(name = "BOOKS", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findByBId", query = "SELECT b FROM Books b WHERE b.bId = :bId")
    , @NamedQuery(name = "Books.findByBName", query = "SELECT b FROM Books b WHERE b.bName = :bName")
    , @NamedQuery(name = "Books.findByBDescription", query = "SELECT b FROM Books b WHERE b.bDescription = :bDescription")})
public class Books implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "B_ID")
    private String bId;
    @Column(name = "B_NAME")
    private String bName;
    @Column(name = "B_DESCRIPTION")
    private String bDescription;

    public Books() {
    }

    public Books(String bId) {
        this.bId = bId;
    }

    public String getBId() {
        return bId;
    }

    public void setBId(String bId) {
        String oldBId = this.bId;
        this.bId = bId;
        changeSupport.firePropertyChange("BId", oldBId, bId);
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        String oldBName = this.bName;
        this.bName = bName;
        changeSupport.firePropertyChange("BName", oldBName, bName);
    }

    public String getBDescription() {
        return bDescription;
    }

    public void setBDescription(String bDescription) {
        String oldBDescription = this.bDescription;
        this.bDescription = bDescription;
        changeSupport.firePropertyChange("BDescription", oldBDescription, bDescription);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "e.book.shop.Books[ bId=" + bId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
