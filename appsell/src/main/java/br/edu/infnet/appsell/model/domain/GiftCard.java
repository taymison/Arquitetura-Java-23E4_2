package br.edu.infnet.appsell.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "giftCards")
public class GiftCard extends Product {
    private boolean activatable;
    private String membership;

    public boolean isActivatable() {
        return activatable;
    }

    public void setActivatable(boolean activatable) {
        this.activatable = activatable;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), activatable, membership);
    }
}
