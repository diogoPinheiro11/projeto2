package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Production {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "wanted_qty")
    private BigInteger wantedQty;
    @Basic
    @Column(name = "seeds_qty")
    private BigInteger seedsQty;
    @Basic
    @Column(name = "id_seeds", insertable = false, updatable = false)
    private int idSeeds;
    @Basic
    @Column(name = "id_manager", insertable = false, updatable = false)
    private int idManager;
    @ManyToOne
    @JoinColumn(name = "id_seeds", referencedColumnName = "id", nullable = false)
    private Seeds seedsByIdSeeds;
    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    private Manager managerByIdManager;
    @OneToMany(mappedBy = "productionByIdProduction")
    private Collection<Stock> stocksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigInteger getWantedQty() {
        return wantedQty;
    }

    public void setWantedQty(BigInteger wantedQty) {
        this.wantedQty = wantedQty;
    }

    public BigInteger getSeedsQty() {
        return seedsQty;
    }

    public void setSeedsQty(BigInteger seedsQty) {
        this.seedsQty = seedsQty;
    }

    public int getIdSeeds() {
        return idSeeds;
    }

    public void setIdSeeds(int idSeeds) {
        this.idSeeds = idSeeds;
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

        Production that = (Production) o;

        if (id != that.id) return false;
        if (idSeeds != that.idSeeds) return false;
        if (idManager != that.idManager) return false;
        if (!Objects.equals(state, that.state)) return false;
        if (!Objects.equals(wantedQty, that.wantedQty)) return false;
        return Objects.equals(seedsQty, that.seedsQty);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (wantedQty != null ? wantedQty.hashCode() : 0);
        result = 31 * result + (seedsQty != null ? seedsQty.hashCode() : 0);
        result = 31 * result + idSeeds;
        result = 31 * result + idManager;
        return result;
    }

    public Seeds getSeedsByIdSeeds() {
        return seedsByIdSeeds;
    }

    public void setSeedsByIdSeeds(Seeds seedsByIdSeeds) {
        this.seedsByIdSeeds = seedsByIdSeeds;
    }

    public Manager getManagerByIdManager() {
        return managerByIdManager;
    }

    public void setManagerByIdManager(Manager managerByIdManager) {
        this.managerByIdManager = managerByIdManager;
    }

    public Collection<Stock> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<Stock> stocksById) {
        this.stocksById = stocksById;
    }
}
