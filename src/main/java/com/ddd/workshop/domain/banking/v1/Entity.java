package com.ddd.workshop.domain.banking.v1;

import lombok.Getter;

@Getter
public abstract class Entity<TIdentity> {

    private TIdentity id;

    public Entity(TIdentity id) {
        this.id = id;
    }

    abstract String getEntityType();

    @Override
    public String toString() {
        return getEntityType() + "{" +
                "id=" + id +
                '}';
    }
}
