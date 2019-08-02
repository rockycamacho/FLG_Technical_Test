package com.rockycamacho.diversify.test.presentation;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Lazy;

import javax.inject.Inject;

public class ViewModelFactory<VM extends ViewModel> implements ViewModelProvider.Factory {
    private Lazy<VM> viewModel;

    @Inject
    public ViewModelFactory(Lazy<VM> viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    @NonNull
    @SuppressWarnings("unchecked cast")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModel.get();
    }
}
