package org.mannayakasha.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="meal")
public class Meal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne
    /*    @JoinTable(name = "users", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))*/
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time")
    private Date dateCreated;

    //@ManyToOne
    /*    @JoinTable(name = "ingestion", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingestion_id"))*/
    @OneToOne
    @JoinColumn(name="ingestion_id", referencedColumnName="id")
    private Ingestion ingestion;

    //@ManyToOne
    /*    @JoinTable(name = "food", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))*/
    @OneToOne
    @JoinColumn(name="food_id", referencedColumnName="id")
    private Food food;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Ingestion getIngestion() {
        return ingestion;
    }

    public void setIngestion(Ingestion ingestion) {
        this.ingestion = ingestion;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", user=" + user +
                ", dateCreated=" + dateCreated +
                ", ingestion=" + ingestion +
                ", food=" + food +
                '}';
    }
}
