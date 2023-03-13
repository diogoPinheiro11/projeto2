package entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "stock_order", schema = "public", catalog = "vegetable-management-company")
public class StockOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_order")
    private int idOrder;
    @Basic
    @Column(name = "id_stock", insertable = false, updatable = false)
    private int idStock;
    @Basic
    @Column(name = "order_price")
    private double orderPrice;
    @Basic
    @Column(name = "order_qty")
    private BigInteger orderQty;
    @Basic
    @Column(name = "date")
    private Date date;
    @OneToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id", nullable = false)
    private Orders ordersByIdOrder;
    @ManyToOne
    @JoinColumn(name = "id_stock", referencedColumnName = "id", nullable = false)
    private Stock stockByIdStock;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigInteger getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigInteger orderQty) {
        this.orderQty = orderQty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockOrder that = (StockOrder) o;

        if (idOrder != that.idOrder) return false;
        if (idStock != that.idStock) return false;
        if (Double.compare(that.orderPrice, orderPrice) != 0) return false;
        if (!Objects.equals(orderQty, that.orderQty)) return false;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOrder;
        result = 31 * result + idStock;
        temp = Double.doubleToLongBits(orderPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (orderQty != null ? orderQty.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public Orders getOrdersByIdOrder() {
        return ordersByIdOrder;
    }

    public void setOrdersByIdOrder(Orders ordersByIdOrder) {
        this.ordersByIdOrder = ordersByIdOrder;
    }

    public Stock getStockByIdStock() {
        return stockByIdStock;
    }

    public void setStockByIdStock(Stock stockByIdStock) {
        this.stockByIdStock = stockByIdStock;
    }
}
