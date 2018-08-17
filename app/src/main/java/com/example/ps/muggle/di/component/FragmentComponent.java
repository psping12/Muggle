package com.example.ps.muggle.di.component;

import android.app.Activity;

import com.example.ps.muggle.di.module.FragmentModule;
import com.example.ps.muggle.di.scope.FragmentScope;
import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

}
