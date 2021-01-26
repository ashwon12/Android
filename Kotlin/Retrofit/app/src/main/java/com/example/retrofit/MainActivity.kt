package com.example.retrofit

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.utils.Constans.TAG
import com.example.retrofit.utils.SEARCH_TYPE
import com.example.retrofit.utils.onMyTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_button_search.*

class MainActivity : AppCompatActivity() {

    private var currentSearchType: SEARCH_TYPE = SEARCH_TYPE.PHOTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_term_radio_group.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.photo_search_radio_btn -> {
                    Log.d(TAG, "사진 버튼 클릭!")
                    search_term_text_layout.hint = "사진검색"
                    search_term_text_layout.startIconDrawable =
                        resources.getDrawable(
                            R.drawable.ic_baseline_photo_library_24,
                            resources.newTheme()
                        )
                    this.currentSearchType = SEARCH_TYPE.PHOTO
                }

                R.id.user_search_radio_btn -> {
                    Log.d(TAG, "사용자검색 버튼 클릭!")
                    search_term_text_layout.hint = "사용자 검색"
                    search_term_text_layout.startIconDrawable =
                        resources.getDrawable(R.drawable.ic_person, resources.newTheme())
                    this.currentSearchType = SEARCH_TYPE.USER
                }
            }
        }


        // 텍스트가 변경이 되었을 때
        search_term_edit_text.onMyTextChanged {
            //입력된 글자가 하나라도 있으면 검색 버튼을 보여준다.
            if (it.toString().count() > 0) {
                frame_search_btn.visibility = View.VISIBLE
                search_term_text_layout.helperText = " "

                //스크롤뷰를 올린다.
                main_scrollview.scrollTo(0, 200)

            } else {
                frame_search_btn.visibility = View.INVISIBLE
            }

            if (it.toString().count() == 12) {
                Toast.makeText(this, "검색어는 12개까지만 입력가능합니다.", Toast.LENGTH_SHORT).show()
            }
        }

        //버튼 클릭시
        btn_search.setOnClickListener {
            Log.d(TAG, "검색 버튼 클릭됐음")
        }
    } //onCreate

    private fun handlesSearchButtonUI() {
        btn_progress.visibility = View.VISIBLE

        btn_search.text = " "

        Handler().postDelayed(
            {
                btn_progress.visibility = View.INVISIBLE
                btn_search.text = "검색"
            }, 1500
        )
    }
}