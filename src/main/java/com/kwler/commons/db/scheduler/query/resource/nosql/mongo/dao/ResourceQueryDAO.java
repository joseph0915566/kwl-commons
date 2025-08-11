package com.kwler.commons.db.scheduler.query.resource.nosql.mongo.dao;


import com.kwler.commons.db.base.nosql.mongo.dao.BaseObjectIdDAO;
import com.kwler.commons.db.scheduler.query.resource.nosql.mongo.model.ResourceQuery;

import java.util.List;

/**
 *
 * @author Joseph Siegar
 *
 */
public interface ResourceQueryDAO  extends BaseObjectIdDAO<ResourceQuery> {
    List<ResourceQuery> getByTag(String tag);
}
