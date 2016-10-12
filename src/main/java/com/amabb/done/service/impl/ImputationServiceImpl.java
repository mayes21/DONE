package com.amabb.done.service.impl;

import com.amabb.done.dao.ImputationDAO;
import com.amabb.done.model.Imputation;
import com.amabb.done.service.ImputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amayas on 25/09/16.
 */

@Service("imputationService")
@Transactional
public class ImputationServiceImpl implements ImputationService{


    @Autowired
    ImputationDAO imputationDAO;

    @Override
    public void saveImputation(Imputation imputation) {
        imputationDAO.saveImputation(imputation);
    }

//    @Override
//    public void updateImputation(Imputation imputation) {
//
//    }

    @Override
    public List<Imputation> listAllImputations() {
        return imputationDAO.listAllImputations();
    }
}
