package com.example.undead.habrahabrrss.repository;

import com.example.undead.habrahabrrss.model.RealmRssItem;
import com.example.undead.habrahabrrss.model.RssItem;
import com.example.undead.habrahabrrss.utils.MappingUtils;
import com.example.undead.habrahabrrss.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

public class CacheDataSource implements DataSource, WritableDataStorage {
    private final static String FIELD_FEED_TYPE = "feedType";
    private final static String DEFAULT_ERROR_MESSAGE = "Unable to execute the DB request.";
    private final static String EMPTY_ERROR_MESSAGE = "DB Request returns empty value.";

    @Override
    public Observable<List<RssItem>> getTopDay() {
        Realm realm = Realm.getDefaultInstance();
        List<RssItem> rssItemList = new ArrayList<>();
        RealmResults<RealmRssItem> realmRssItemListResults = realm
                .where(RealmRssItem.class)
                .equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_DAY)
                .findAll();
        if (!ObjectUtils.isEmpty(realmRssItemListResults)) {
            for (RealmRssItem realmRssItem : realmRssItemListResults) {
                rssItemList.add(MappingUtils.convertRealmToRssItem(realmRssItem));
            }
        }
        realm.close();
        return Observable.just(rssItemList);
    }

    @Override
    public Observable<List<RssItem>> getTopWeek() {
        Realm realm = Realm.getDefaultInstance();
        List<RssItem> rssItemList = new ArrayList<>();
        RealmResults<RealmRssItem> realmRssItemListResults = realm
                .where(RealmRssItem.class)
                .equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_WEEK)
                .findAll();
        if (!ObjectUtils.isEmpty(realmRssItemListResults)) {
            for (RealmRssItem realmRssItem : realmRssItemListResults) {
                rssItemList.add(MappingUtils.convertRealmToRssItem(realmRssItem));
            }
        }
        realm.close();
        return Observable.just(rssItemList);
    }

    @Override
    public Observable<List<RssItem>> getTopMonth() {
        Realm realm = Realm.getDefaultInstance();
        List<RssItem> rssItemList = new ArrayList<>();
        RealmResults<RealmRssItem> realmRssItemListResults = realm
                .where(RealmRssItem.class)
                .equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_MONTH)
                .findAll();
        if (!ObjectUtils.isEmpty(realmRssItemListResults)) {
            for (RealmRssItem realmRssItem : realmRssItemListResults) {
                rssItemList.add(MappingUtils.convertRealmToRssItem(realmRssItem));
            }
        }
        realm.close();
        return Observable.just(rssItemList);
    }

    @Override
    public Observable<List<RssItem>> getTopAll() {
        Realm realm = Realm.getDefaultInstance();
        List<RssItem> rssItemList = new ArrayList<>();
        RealmResults<RealmRssItem> realmRssItemListResults = realm
                .where(RealmRssItem.class)
                .equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_ALL)
                .findAll();
        if (!ObjectUtils.isEmpty(realmRssItemListResults)) {
            for (RealmRssItem realmRssItem : realmRssItemListResults) {
                rssItemList.add(MappingUtils.convertRealmToRssItem(realmRssItem));
            }
        }
        realm.close();
        return Observable.just(rssItemList);
    }

    @Override
    public void setTopDay(final List<RssItem> rssItemList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.where(RealmRssItem.class).equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_DAY).findAll().deleteAllFromRealm();
                for (RssItem rssItem : rssItemList) {
                    bgRealm.copyToRealm(new RealmRssItem(rssItem, MappingUtils.OPTION_DAY));
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
            }
        });
    }

    @Override
    public void setTopWeek(final List<RssItem> rssItemList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.where(RealmRssItem.class).equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_WEEK).findAll().deleteAllFromRealm();
                for (RssItem rssItem : rssItemList) {
                    bgRealm.copyToRealm(new RealmRssItem(rssItem, MappingUtils.OPTION_WEEK));
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
            }
        });
    }

    @Override
    public void setTopMonth(final List<RssItem> rssItemList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.where(RealmRssItem.class).equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_MONTH).findAll().deleteAllFromRealm();
                for (RssItem rssItem : rssItemList) {
                    bgRealm.copyToRealm(new RealmRssItem(rssItem, MappingUtils.OPTION_MONTH));
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
            }
        });
    }

    @Override
    public void setTopAll(final List<RssItem> rssItemList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.where(RealmRssItem.class).equalTo(FIELD_FEED_TYPE, MappingUtils.OPTION_ALL).findAll().deleteAllFromRealm();
                for (RssItem rssItem : rssItemList) {
                    bgRealm.copyToRealm(new RealmRssItem(rssItem, MappingUtils.OPTION_ALL));
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                realm.close();
            }
        });
    }
}
