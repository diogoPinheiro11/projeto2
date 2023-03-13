package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Destiny {
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
    @Column(name = "postal", insertable = false, updatable = false)
    private String postal;
    @ManyToOne
    @JoinColumn(name = "postal", referencedColumnName = "id", nullable = false)
    private PostalCode postalCodeByPostal;
    @OneToMany(mappedBy = "destinyByIdDestiny")
    private Collection<Orders> ordersById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destiny destiny = (Destiny) o;

        if (id != destiny.id) return false;
        if (!Objects.equals(name, destiny.name)) return false;
        if (!Objects.equals(phone, destiny.phone)) return false;
        if (!Objects.equals(street, destiny.street)) return false;
        if (!Objects.equals(door, destiny.door)) return false;
        return Objects.equals(postal, destiny.postal);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (door != null ? door.hashCode() : 0);
        result = 31 * result + (postal != null ? postal.hashCode() : 0);
        return result;
    }

    public PostalCode getPostalCodeByPostal() {
        return postalCodeByPostal;
    }

    public void setPostalCodeByPostal(PostalCode postalCodeByPostal) {
        this.postalCodeByPostal = postalCodeByPostal;
    }

    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }
}
