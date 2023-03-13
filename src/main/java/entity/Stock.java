package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "produced_qty")
    private BigInteger producedQty;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "id_production", insertable = false, updatable = false)
    private int idProduction;
    @Basic
    @Column(name = "id_product", insertable = false, updatable = false)
    private int idProduct;
    @Basic
    @Column(name = "id_storage", insertable = false, updatable = false)
    private int idStorage;
    @ManyToOne
    @JoinColumn(name = "id_production", referencedColumnName = "id", nullable = false)
    private Production productionByIdProduction;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product productByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_storage", referencedColumnName = "id", nullable = false)
    private Storage storageByIdStorage;
    @OneToMany(mappedBy = "stockByIdStock")
    private Collection<StockOrder> stockOrdersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getProducedQty() {
        return producedQty;
    }

    public void setProducedQty(BigInteger producedQty) {
        this.producedQty = producedQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(int idProduction) {
        this.idProduction = idProduction;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(int idStorage) {
        this.idStorage = idStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (idProduction != stock.idProduction) return false;
        if (idProduct != stock.idProduct) return false;
        if (idStorage != stock.idStorage) return false;
        if (!Objects.equals(producedQty, stock.producedQty)) return false;
        return Objects.equals(date, stock.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (producedQty != null ? producedQty.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idProduction;
        result = 31 * result + idProduct;
        result = 31 * result + idStorage;
        return result;
    }

    public Production getProductionByIdProduction() {
        return productionByIdProduction;
    }

    public void setProductionByIdProduction(Production productionByIdProduction) {
        this.productionByIdProduction = productionByIdProduction;
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }

    public Storage getStorageByIdStorage() {
        return storageByIdStorage;
    }

    public void setStorageByIdStorage(Storage storageByIdStorage) {
        this.storageByIdStorage = storageByIdStorage;
    }

    public Collection<StockOrder> getStockOrdersById() {
        return stockOrdersById;
    }

    public void setStockOrdersById(Collection<StockOrder> stockOrdersById) {
        this.stockOrdersById = stockOrdersById;
    }
}
