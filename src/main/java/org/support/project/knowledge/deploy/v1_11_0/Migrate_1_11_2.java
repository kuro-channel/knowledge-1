package org.support.project.knowledge.deploy.v1_11_0;

import org.support.project.knowledge.deploy.Migrate;
import org.support.project.knowledge.logic.AggregateLogic;
import org.support.project.ormapping.tool.dao.InitializeDao;

public class Migrate_1_11_2 implements Migrate {
    public static Migrate_1_11_2 get() {
        return org.support.project.di.Container.getComp(Migrate_1_11_2.class);
    }
    
    @Override
    public boolean doMigrate() throws Exception {
        InitializeDao initializeDao = InitializeDao.get();
        String[] sqlpaths = {
            "/org/support/project/knowledge/deploy/v1_11_0/migrate_v1_11_2.sql",
        };
        initializeDao.initializeDatabase(sqlpaths);
        
        AggregateLogic aggregateLogic = AggregateLogic.get();
        aggregateLogic.startAggregate();
        
        return true;
    }
    

}