package id.tadi.visithumbang.accommodations.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.FragmentAccomodationsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccomodationsFragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentAccomodationsBinding

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
        binding = FragmentAccomodationsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        binding.tvOngoingEventsAll.isClickable = true
        binding.tvOngoingEventsAll.setOnClickListener {
            Log.d("ngga", "nyambung")
            View.OnClickListener { Toast.makeText(activity, "Di klik", Toast.LENGTH_SHORT).show() }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_OngoingEventsAll -> {Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show()}
            else -> Toast.makeText(activity, "sdds", Toast.LENGTH_SHORT).show()
        }
    }
}