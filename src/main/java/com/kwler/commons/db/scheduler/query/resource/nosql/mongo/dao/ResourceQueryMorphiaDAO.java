package com.kwler.commons.db.scheduler.query.resource.nosql.mongo.dao;

import com.kwler.commons.db.base.nosql.mongo.dao.BaseObjectIdMorphiaDAO;
import com.kwler.commons.db.base.nosql.mongo.service.MorphiaService;
import com.kwler.commons.db.scheduler.query.resource.nosql.mongo.model.ResourceQuery;
import com.kwler.commons.json.JsonService;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Joseph Siegar
 *
 */
public class ResourceQueryMorphiaDAO  extends BaseObjectIdMorphiaDAO<ResourceQuery> implements ResourceQueryDAO {

    @Inject
    public ResourceQueryMorphiaDAO(MorphiaService morphiaService, JsonService jsonService) {
        super(morphiaService, jsonService);
    }

    @Override
    public List<ResourceQuery> getByTag(String tag){
        Datastore datastore = morphiaService.getDatastore();
        Query<ResourceQuery> query = datastore.createQuery(ResourceQuery.class)
                .field("tag").equal(tag);

        return query.asList();
    }

}
