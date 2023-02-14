package com.arnab.criculture.models.fixtures

import com.arnab.criculture.models.TeamDlData
import com.arnab.criculture.models.teams.TeamData

data class FixtureData(
    val draw_noresult: Any?,
    val elected: String?,
    val first_umpire_id: Int?,
    val follow_on: Boolean?,
    val id: Int,
    val last_period: Any?,
    val league_id: Int,
    val lineup: List<Lineup>,
    val live: Boolean?,
    val localteam: TeamData,
    val localteam_dl_data: TeamDlData?,
    val localteam_id: Int?,
    val man_of_match_id: Int?,
    val man_of_series_id: Int?,
    val note: String?,
    val referee_id: Int?,
    val resource: String?,
    val round: String?,
    val rpc_overs: Any?,
    val rpc_target: Any?,
    val season_id: Int,
    val second_umpire_id: Int?,
    val stage_id: Int?,
    val starting_at: String,
    val status: String?,
    val super_over: Boolean?,
    val toss_won_team_id: Int?,
    val total_overs_played: Int?,
    val tv_umpire_id: Int?,
    val type: String?,
    val venue_id: Int?,
    val visitorteam: TeamData,
    val visitorteam_dl_data: TeamDlData?,
    val visitorteam_id: Int,
    val weather_report: List<Any>,
    val winner_team_id: Int?
)