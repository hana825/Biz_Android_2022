package com.callor.word.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

// WordViewModel 객체를 생성하고 관리하는 용도의 클래스
public class WordVIewModelFactory  implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Factory 오류");
        } catch (InstantiationException e) {
            throw new RuntimeException("Runtime 오류");
        }
    }
}
