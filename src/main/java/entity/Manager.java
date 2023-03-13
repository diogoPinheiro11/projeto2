package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Manager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "door")
    private int door;
    @Basic
    @Column(name = "postal", insertable = false, updatable = false)
    private String postal;
    @Basic
    @Column(name = "id_type", insertable = false, updatable = false)
    private int idType;
    @ManyToOne
    @JoinColumn(name = "postal", referencedColumnName = "id", nullable = true)
    private PostalCode postalCodeByPostal;
    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false)
    private Types typesByIdType;
    @OneToMany(mappedBy = "managerByIdManager")
    private Collection<Orders> ordersById;
    @OneToMany(mappedBy = "managerByIdManager")
    private Collection<Production> productionsById;
    @OneToMany(mappedBy = "managerByIdManager")
    private Collection<Storage> storagesById;
    @OneToMany(mappedBy = "managerByIdManager")
    private Collection<SupplySeeds> supplySeedsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (idType != manager.idType) return false;
        if (!Objects.equals(name, manager.name)) return false;
        if (!Objects.equals(phone, manager.phone)) return false;
        if (!Objects.equals(street, manager.street)) return false;
        if (door != manager.door) return false;
        return Objects.equals(postal, manager.postal);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + door;
        result = 31 * result + (postal != null ? postal.hashCode() : 0);
        result = 31 * result + idType;
        return result;
    }

    public PostalCode getPostalCodeByPostal() {
        return postalCodeByPostal;
    }

    public void setPostalCodeByPostal(PostalCode postalCodeByPostal) {
        this.postalCodeByPostal = postalCodeByPostal;
    }

    public Types getTypesByIdType() {
        return typesByIdType;
    }

    public void setTypesByIdType(Types typesByIdType) {
        this.typesByIdType = typesByIdType;
    }

    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }

    public Collection<Production> getProductionsById() {
        return productionsById;
    }

    public void setProductionsById(Collection<Production> productionsById) {
        this.productionsById = productionsById;
    }

    public Collection<Storage> getStoragesById() {
        return storagesById;
    }

    public void setStoragesById(Collection<Storage> storagesById) {
        this.storagesById = storagesById;
    }

    public Collection<SupplySeeds> getSupplySeedsById() {
        return supplySeedsById;
    }

    public void setSupplySeedsById(Collection<SupplySeeds> supplySeedsById) {
        this.supplySeedsById = supplySeedsById;
    }
}
