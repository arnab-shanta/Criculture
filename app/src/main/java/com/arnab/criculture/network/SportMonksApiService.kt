package com.arnab.criculture.network

import android.os.Build
import androidx.annotation.RequiresApi
import com.arnab.criculture.models.ranking.Ranking
import com.arnab.criculture.models.fixtures.FixtureWithLineUpandTeams
import com.arnab.criculture.models.teams.Team
import com.arnab.criculture.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

@RequiresApi(Build.VERSION_CODES.O)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

interface SportMonksApiService {
    @RequiresApi(Build.VERSION_CODES.O)
    @GET(Constants.ALL_TEAM_QUERY)
    suspend fun getAllTeams(): Team

    @RequiresApi(Build.VERSION_CODES.O)
    @GET(Constants.UPCOMING_MATCHES_QUERY)
    suspend fun getUpcomingMatches(): FixtureWithLineUpandTeams

    @RequiresApi(Build.VERSION_CODES.O)
    @GET(Constants.RECENT_MATCHES_QUERY)
    suspend fun getRecentMatches(): FixtureWithLineUpandTeams

    @RequiresApi(Build.VERSION_CODES.O)
    @GET("teams/{id}&api_token=${Constants.API_TOKEN}")
    suspend fun getTeamByID(@Path("id") id: Int): Team

    @GET(Constants.TEST_RANKING_MEN_QUERY)
    suspend fun getTestRankingMen(): Ranking

    @GET(Constants.ODI_RANKING_MEN_QUERY)
    suspend fun getOdiRankingMen(): Ranking

    @GET(Constants.T20_RANKING_MEN_QUERY)
    suspend fun getT20RankingMen(): Ranking

    @GET(Constants.ODI_RANKING_WOMEN_QUERY)
    suspend fun getOdiRankingWomen(): Ranking

    @GET(Constants.T20_RANKING_WOMEN_QUERY)
    suspend fun getT20RankingWomen(): Ranking

    @GET(Constants.T20_FIXTURE_QUERY)
    suspend fun getT20Fixture(): FixtureWithLineUpandTeams

    @GET(Constants.BIG_BASH_FIXTURE_QUERY)
    suspend fun getBBashFixture(): FixtureWithLineUpandTeams

    @GET(Constants.CSA_T20_FIXTURE_QUERY)
    suspend fun getCsaFixture(): FixtureWithLineUpandTeams

    @GET("players")
    suspend fun getPlayerCareer(
        @Query("PLAYER_ID") playerId: Int,
        @Query("include") career: String = "career",
        @Query("api_token") api_token: String = Constants.API_TOKEN
    )
}

@RequiresApi(Build.VERSION_CODES.O)
object SportMonksApi {
    val retrofitService: SportMonksApiService by lazy { retrofit.create(SportMonksApiService::class.java) }
}