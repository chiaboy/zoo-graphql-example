package com.opi.zoo.graphql.datafetcher

import com.opi.zoo.rest.domain.Keeper
import com.opi.zoo.rest.repository.KeeperRepository
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class KeeperDataFetcher {
    // this data source could be swapped out for anything...
    @Autowired
    KeeperRepository keeperRepository

    List<Keeper> findAll() {
        keeperRepository.findAll()
    }

    List<Keeper> filterAll(DataFetchingEnvironment env) {
        Long id = env.getArgument('id')

        if (id != null) {
            return [keeperRepository.findOne(id)]
        }

        return keeperRepository.findAll()
    }
}
