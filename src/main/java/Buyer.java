
import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "buyer")
public class Buyer {

private int ID;
private String buyername;
private long value;
private Date dateRegistered;
private String buyerPersonalIdentification;
private int [] transactions;

    public Buyer() {
    }


    @Id
    @Column(name = "buyer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Column(name = "date")
    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Column(name = "buyer_personal_identification")
    public String getBuyerPersonalIdentification() {
        return buyerPersonalIdentification;
    }

    public void setBuyerPersonalIdentification(String buyerPersonalIdentification) {
        this.buyerPersonalIdentification = buyerPersonalIdentification;
    }

    public int[] getTransactions() {
        return transactions;
    }

    public void setTransactions(int[] transactions) {
        this.transactions = transactions;
    }
}
