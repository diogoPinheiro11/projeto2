package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "supply_seeds", schema = "public", catalog = "vegetable-management-company")
public class SupplySeeds {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_seeds")
    private int idSeeds;
    @Basic
    @Column(name = "id_supply", insertable=false, updatable=false)
    private Integer idSupply;
    @Basic
    @Column(name = "unit_price")
    private double unitPrice;
    @Basic
    @Column(name = "seeds_qty")
    private BigInteger seedsQty;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "id_manager", insertable=false, updatable=false)
    private int idManager;
    @OneToOne
    @JoinColumn(name = "id_seeds", referencedColumnName = "id", nullable = false)
    private Seeds seedsByIdSeeds;
    @ManyToOne
    @JoinColumn(name = "id_supply", referencedColumnName = "id")
    private Supply supplyByIdSupply;
    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    private Manager managerByIdManager;

    public int getIdSeeds() {
        return idSeeds;
    }

    public void setIdSeeds(int idSeeds) {
        this.idSeeds = idSeeds;
    }

    public Integer getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(Integer idSupply) {
        this.idSupply = idSupply;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getSeedsQty() {
        return seedsQty;
    }

    public void setSeedsQty(BigInteger seedsQty) {
        this.seedsQty = seedsQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

        SupplySeeds that = (SupplySeeds) o;

        if (idSeeds != that.idSeeds) return false;
        if (Double.compare(that.unitPrice, unitPrice) != 0) return false;
        if (idManager != that.idManager) return false;
        if (idSupply != null ? !idSupply.equals(that.idSupply) : that.idSupply != null) return false;
        if (seedsQty != null ? !seedsQty.equals(that.seedsQty) : that.seedsQty != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idSeeds;
        result = 31 * result + (idSupply != null ? idSupply.hashCode() : 0);
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (seedsQty != null ? seedsQty.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idManager;
        return result;
    }

    public Seeds getSeedsByIdSeeds() {
        return seedsByIdSeeds;
    }

    public void setSeedsByIdSeeds(Seeds seedsByIdSeeds) {
        this.seedsByIdSeeds = seedsByIdSeeds;
    }

    public Supply getSupplyByIdSupply() {
        return supplyByIdSupply;
    }

    public void setSupplyByIdSupply(Supply supplyByIdSupply) {
        this.supplyByIdSupply = supplyByIdSupply;
    }

    public Manager getManagerByIdManager() {
        return managerByIdManager;
    }

    public void setManagerByIdManager(Manager managerByIdManager) {
        this.managerByIdManager = managerByIdManager;
    }
}
