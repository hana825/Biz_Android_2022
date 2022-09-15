package com.callor.word;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.callor.word.model.WordVIewModelFactory;
import com.callor.word.model.WordVO;
import com.callor.word.model.WordViewModel;

/*
Activity
앱을 실행했을 때 화면에 보여지는 객체
 */
public class MainActivity extends AppCompatActivity {

    // 원래 ImageView 의 Size 를 보관해둘 변수 선언
    private int imageWidth = 0;
    private int imageHeight = 0;

    private WordViewModel viewModel;

    /*
    안드로이드 앱이 실행될때 화면을 만들어주는 Method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new WordVIewModelFactory()).get(WordViewModel.class);

        // viewModel Observer 를 등록하여 DB 데이터를 감시하도록 설정
        // 데이터를 추가를 감시하는 부분
        Observer<WordVO> wordObserver = (Observer<WordVO>) new WordVO(0, "Korea");

        // 추가된 데이터를 읽어서 View 하는 부분
        viewModel.getWord().observe(this, wordObserver);

        // activity_main.xml 에 설정된 btn_size 위젯을 사용하기 위한
        // 객체로 설정
        Button btn_size = findViewById(R.id.btn_size);

        // btb_size Button 을 클릭 또는 Touch 했을때
        // 할일을 지정하기(이벤트 핸들러 설정)

        // 무명클래스, 익명클래스 방식으로 이벤트 핸들러 설정하기
        btn_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Button Click",
                        Toast.LENGTH_SHORT).show();


                // ImageView 객체 선언
                ImageView imageView = findViewById(R.id.image);

                // ConstraintLayout 에 포함된
                // ImageView 의 layout 정보를 가져오기
                // import android.widget.ConstraintLayout;
                ConstraintLayout.LayoutParams params
                        = (ConstraintLayout.LayoutParams)
                        imageView.getLayoutParams();

                if(imageWidth == 0) {
                    imageWidth = params.width;
                    imageHeight = params.height;
                }

                if(imageWidth == params.width) {
                    // ImageView 의 width 와 height 를 변경하기
                    params.width = 1000; // metrics.widthPixels;
                    params.height = 1400; // metrics.heightPixels;
                } else {
                    params.width = imageWidth;
                    params.height = imageHeight;
                }

                // 변경된 정보를 적용하기
                imageView.setLayoutParams(params);

            }
        });

    }
}