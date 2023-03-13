package entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Seeds {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "seedsByIdSeeds")
    private Collection<Production> productionsById;
    @OneToOne(mappedBy = "seedsByIdSeeds")
    private SupplySeeds supplySeedsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seeds seeds = (Seeds) o;

        if (id != seeds.id) return false;
        if (!Objects.equals(description, seeds.description)) return false;
        return Objects.equals(type, seeds.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public Collection<Production> getProductionsById() {
        return productionsById;
    }

    public void setProductionsById(Collection<Production> productionsById) {
        this.productionsById = productionsById;
    }

    public SupplySeeds getSupplySeedsById() {
        return supplySeedsById;
    }

    public void setSupplySeedsById(SupplySeeds supplySeedsById) {
        this.supplySeedsById = supplySeedsById;
    }
}
