package com.amabb.done.dao;

import com.amabb.done.model.Imputation;

import java.util.List;

/**
 * Created by amayas on 25/09/16.
 */
public interface ImputationDAO {

    void saveImputation(Imputation imputation);
    List<Imputation> listAllImputations();

}
