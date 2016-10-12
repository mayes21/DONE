package com.amabb.done.dao.impl;

import com.amabb.done.dao.AbstractDAO;
import com.amabb.done.dao.ImputationDAO;
import com.amabb.done.model.Imputation;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by amayas on 25/09/16.
 */

@Repository("imputationDAO")
public class ImputationDAOImpl extends AbstractDAO<Integer, Imputation> implements ImputationDAO {

    @Override
    public void saveImputation(Imputation imputation) {
        persist(imputation);
    }

    @Override
    public List<Imputation> listAllImputations() {
        Criteria criteria = createEntityCriteria();
        return (List<Imputation>) criteria.list();
    }
}
