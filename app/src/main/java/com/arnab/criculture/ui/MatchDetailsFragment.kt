package com.arnab.criculture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arnab.criculture.R
import com.arnab.criculture.adapters.MatchDetailsRVAdapter
import com.arnab.criculture.databinding.FragmentMatchDetailsBinding
import com.arnab.criculture.models.fixtures.Batting
import com.bumptech.glide.Glide

private const val TAG = "MatchDetailsFragment"

class MatchDetailsFragment : Fragment() {
    lateinit var binding: FragmentMatchDetailsBinding
    lateinit var team1Name: String
    lateinit var team2Name: String
    lateinit var team1ImgPath: String
    lateinit var team2ImgPath: String
    var team1Runs: Int = 0
    var team2Runs: Int = 0
    var team1Wickets: Int = 0
    var team2Wickets: Int = 0
    var team1Overs: Float = 0.0F
    var team2Overs: Float = 0.0F
    lateinit var matchResult: String
    private lateinit var battingDetails: List<Batting>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            team1Name = it.getString("localTeamName", "")
            team2Name = it.getString("visitorTeamName", "")
            team1ImgPath = it.getString("localTeamImgPath", "")
            team2ImgPath = it.getString("visitorTeamImgPath", "")
            team1Runs = it.getInt("localTeamRuns", 0)
            team2Runs = it.getInt("visitorTeamRuns", 0)
            team1Wickets = it.getInt("localTeamWickets", 0)
            team2Wickets = it.getInt("visitorTeamWickets", 0)
            team1Overs = it.getFloat("localTeamOvers", 0.0F)
            team2Overs = it.getFloat("visitorTeamOvers", 0.0F)
            matchResult = it.getString("matchResult", "")
            battingDetails = it.getParcelableArray("battingDetails")!!.toList() as List<Batting>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchDetailsBinding.bind(view)

        /*val recyclerView: RecyclerView = binding.matchDetailsRV
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MatchDetailsRVAdapter(requireContext(), battingDetails)*/

        binding.team1Name.text = team1Name
        binding.team2Name.text = team2Name
        Glide.with(requireContext())
            .load(team1ImgPath)
            .into(binding.team1IV)
        Glide.with(requireContext())
            .load(team2ImgPath)
            .into(binding.team2IV)
        binding.team1RunsTV.text = "$team1Runs/$team1Wickets"
        binding.team2RunsTV.text = "$team2Runs/$team2Wickets"
        binding.team1OversTV.text = "Overs($team1Overs)"
        binding.team2OversTV.text = "Overs($team2Overs)"
        binding.matchResultTV.text = matchResult
        binding.layout.addView(
            LayoutInflater.from(requireContext()).inflate(R.layout.match_scoreboard_layout, null)
        )
    }
}