package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Storage {
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
    private String door;
    @Basic
    @Column(name = "postal", insertable=false, updatable=false)
    private String postal;
    @Basic
    @Column(name = "id_manager", insertable=false, updatable=false)
    private int idManager;
    @OneToMany(mappedBy = "storageByIdStorage")
    private Collection<Orders> ordersById;
    @OneToMany(mappedBy = "storageByIdStorage")
    private Collection<Stock> stocksById;
    @ManyToOne
    @JoinColumn(name = "postal", referencedColumnName = "id", nullable = false)
    private PostalCode postalCodeByPostal;
    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    private Manager managerByIdManager;

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

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (id != storage.id) return false;
        if (idManager != storage.idManager) return false;
        if (name != null ? !name.equals(storage.name) : storage.name != null) return false;
        if (phone != null ? !phone.equals(storage.phone) : storage.phone != null) return false;
        if (street != null ? !street.equals(storage.street) : storage.street != null) return false;
        if (door != null ? !door.equals(storage.door) : storage.door != null) return false;
        if (postal != null ? !postal.equals(storage.postal) : storage.postal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (door != null ? door.hashCode() : 0);
        result = 31 * result + (postal != null ? postal.hashCode() : 0);
        result = 31 * result + idManager;
        return result;
    }

    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }

    public Collection<Stock> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<Stock> stocksById) {
        this.stocksById = stocksById;
    }

    public PostalCode getPostalCodeByPostal() {
        return postalCodeByPostal;
    }

    public void setPostalCodeByPostal(PostalCode postalCodeByPostal) {
        this.postalCodeByPostal = postalCodeByPostal;
    }

    public Manager getManagerByIdManager() {
        return managerByIdManager;
    }

    public void setManagerByIdManager(Manager managerByIdManager) {
        this.managerByIdManager = managerByIdManager;
    }
}
