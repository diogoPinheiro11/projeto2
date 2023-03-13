package entity;

import jakarta.persistence.*;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_storage", insertable = false, updatable = false)
    private int idStorage;
    @Basic
    @Column(name = "id_destiny", insertable = false, updatable = false)
    private int idDestiny;
    @Basic
    @Column(name = "id_manager", insertable = false, updatable = false)
    private int idManager;
    @ManyToOne
    @JoinColumn(name = "id_storage", referencedColumnName = "id", nullable = false)
    private Storage storageByIdStorage;
    @ManyToOne
    @JoinColumn(name = "id_destiny", referencedColumnName = "id", nullable = false)
    private Destiny destinyByIdDestiny;
    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    private Manager managerByIdManager;
    @OneToOne(mappedBy = "ordersByIdOrder")
    private StockOrder stockOrderById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(int idStorage) {
        this.idStorage = idStorage;
    }

    public int getIdDestiny() {
        return idDestiny;
    }

    public void setIdDestiny(int idDestiny) {
        this.idDestiny = idDestiny;
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

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (idStorage != orders.idStorage) return false;
        if (idDestiny != orders.idDestiny) return false;
        return idManager == orders.idManager;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idStorage;
        result = 31 * result + idDestiny;
        result = 31 * result + idManager;
        return result;
    }

    public Storage getStorageByIdStorage() {
        return storageByIdStorage;
    }

    public void setStorageByIdStorage(Storage storageByIdStorage) {
        this.storageByIdStorage = storageByIdStorage;
    }

    public Destiny getDestinyByIdDestiny() {
        return destinyByIdDestiny;
    }

    public void setDestinyByIdDestiny(Destiny destinyByIdDestiny) {
        this.destinyByIdDestiny = destinyByIdDestiny;
    }

    public Manager getManagerByIdManager() {
        return managerByIdManager;
    }

    public void setManagerByIdManager(Manager managerByIdManager) {
        this.managerByIdManager = managerByIdManager;
    }

    public StockOrder getStockOrderById() {
        return stockOrderById;
    }

    public void setStockOrderById(StockOrder stockOrderById) {
        this.stockOrderById = stockOrderById;
    }
}
