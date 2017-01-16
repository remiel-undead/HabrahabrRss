package com.example.undead.habrahabrrss.repository;

import io.reactivex.Observable;

public interface UpdatableDataStorage {
    Observable<Void> updateCache();
}