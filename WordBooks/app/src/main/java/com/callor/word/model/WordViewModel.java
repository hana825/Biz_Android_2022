package com.callor.word.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.callor.word.persistence.WordRepository;

// WordVO : 데이터를 담고, Table 을 생성하는 용도의 클래스
// WordViewModel : ViewModel 클래스로 데이터를 Observe 방시긍로 핸들링하기 위한 도구
public class WordViewModel extends ViewModel {

    private WordRepository wordRepository;

    public WordViewModel(Application application) {
        wordRepository = new WordRepository(application);
    }

    public LiveData<WordVO> selectAll() {
        return wordRepository.wordList();
    }

    public void insert(WordVO wordVO){
        wordRepository.insert(wordVO);
    }
}
