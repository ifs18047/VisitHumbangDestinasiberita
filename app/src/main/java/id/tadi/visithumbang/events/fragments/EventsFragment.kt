package id.tadi.visithumbang.events.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.FragmentEventsBinding
import id.tadi.visithumbang.events.utils.*
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EventsFragment : Fragment(){
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentEventsBinding
    private lateinit var events: ArrayList<Event>
    private lateinit var firstAdapter : EventPrimaryAdapter
    private lateinit var secondAdapter : EventSecondaryAdapter
    private lateinit var thirdAdapter: EventThirdAdapter
    private lateinit var rvSecondary : RecyclerView
    private lateinit var rvThird : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        with(binding){
            tvOngoingEventsAll.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fl_container, EventListFragment()).commit()
            }
        }
        setupUpcomingEvents()
    }

    private fun setupUpcomingEvents(){
        rvSecondary = binding.rvNearbyHotels
        events = Events.getDummyEvents()
        secondAdapter = EventSecondaryAdapter(events)
        rvSecondary.adapter = secondAdapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvSecondary.layoutManager = layoutManager
    }

}