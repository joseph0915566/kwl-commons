package com.kwler.commons.db.scheduler.query.resource.nosql.mongo.model;

import com.kwler.commons.db.base.nosql.mongo.model.BaseObjectIdObject;
import org.mongodb.morphia.annotations.Entity;

import java.util.Map;

/**
 *
 * @author Joseph Siegar
 *
 */
@Entity(value = "resourceQuery", noClassnameStored = true)
public class ResourceQuery extends BaseObjectIdObject {

    private Map<String, String> resourceQueryParams;

    public Map<String, String> getResourceQueryParams() {
        return resourceQueryParams;
    }

    public void setResourceQueryParams(Map<String, String> resourceQueryParams) {
        this.resourceQueryParams = resourceQueryParams;
    }
}
