package com.arnab.criculture.repository

import com.arnab.criculture.db.dao.ICricultureDao
import com.arnab.criculture.models.fixtures.UpcomingMatch
import com.arnab.criculture.models.teams.Team
import com.arnab.criculture.models.teams.TeamData
import com.arnab.criculture.network.SportMonksApi

class CricultureRepository(private val cricultureDao: ICricultureDao) {
    suspend fun getAllTeamsFromApi(): Team{
        return SportMonksApi.retrofitService.getAllTeams()
    }
    suspend fun getUpcomingMatchesFromApi(): UpcomingMatch{
        return SportMonksApi.retrofitService.getUpcomingMatches()
    }
    suspend fun addTeam(teamData: TeamData) {
        cricultureDao.addTeam(teamData)
    }
}