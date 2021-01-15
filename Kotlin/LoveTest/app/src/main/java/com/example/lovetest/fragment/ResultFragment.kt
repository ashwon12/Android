package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    var option = -1
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        option = arguments?.getInt("index") ?: -1

        return inflater.inflate(R.layout.fragment_result,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)

        btn_home.setOnClickListener { navController.navigate(R.id.action_resultFragment_to_mainFragment) }
    }

    fun setResult(option: Int) {
        when(option){
            1 -> {
                tv_main.text = "당신은 쉽게 체념해버리는 사람입니다."
                tv_sub.text ="떠난 애인을 쉽게 보내줄 것 입니다."
            }

            2 -> {
                tv_main.text="자신에게 집중해야 합니다."
                tv_sub.text="떠난 애인에게 집착하게 될 수 있습니다."
            }

            3-> {
                tv_main.text="침착하게 생각해야 합니다."
                tv_sub.text="You can do crazy things no matter what it takes."
            }

            4-> {
                tv_main.text="당신은 꽤 성숙합니다."
                tv_sub.text="이별을 쉽게 받아들일 수 있습니다."
            }
        }
    }

}