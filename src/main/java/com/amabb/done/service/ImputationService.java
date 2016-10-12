package com.amabb.done.service;

import com.amabb.done.model.Imputation;

import java.util.List;

/**
 * Created by amayas on 25/09/16.
 */

public interface ImputationService {

    void saveImputation(Imputation imputation);
//    void updateImputation(Imputation imputation);

    List<Imputation> listAllImputations();

}
