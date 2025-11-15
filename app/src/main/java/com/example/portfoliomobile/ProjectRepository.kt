package com.example.portfoliomobile

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ProjectRepository(
    private val dao: ProjectDao,
    private val api: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    // Single source of truth: DB Flow
    fun getProjectsFlow(): Flow<List<Project>> {
        return dao.getAllProjects().map { list ->
            list.map { entity ->
                Project(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description ?: "",
                    language = entity.language ?: ""
                )
            }
        }
    }

    suspend fun refreshProjectsFromNetwork(githubUser: String) {
        withContext(ioDispatcher) {
            val repos = api.listRepos(githubUser) // may throw - caller handles
            val entities = repos.map { it.toEntity() }
            // simple sync: clear & insert (or use replace)
            dao.insertAll(entities)
        }
    }
}
