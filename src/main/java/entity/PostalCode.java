package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "postal_code", schema = "public", catalog = "vegetable-management-company")
public class PostalCode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "postalCodeByPostal")
    private Collection<Destiny> destiniesById;
    @OneToMany(mappedBy = "postalCodeByPostal")
    private Collection<Manager> managersById;
    @OneToMany(mappedBy = "postalCodeByPostal")
    private Collection<Storage> storagesById;
    @OneToMany(mappedBy = "postalCodeByPostal")
    private Collection<Supply> suppliesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostalCode that = (PostalCode) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Destiny> getDestiniesById() {
        return destiniesById;
    }

    public void setDestiniesById(Collection<Destiny> destiniesById) {
        this.destiniesById = destiniesById;
    }

    public Collection<Manager> getManagersById() {
        return managersById;
    }

    public void setManagersById(Collection<Manager> managersById) {
        this.managersById = managersById;
    }

    public Collection<Storage> getStoragesById() {
        return storagesById;
    }

    public void setStoragesById(Collection<Storage> storagesById) {
        this.storagesById = storagesById;
    }

    public Collection<Supply> getSuppliesById() {
        return suppliesById;
    }

    public void setSuppliesById(Collection<Supply> suppliesById) {
        this.suppliesById = suppliesById;
    }
}
