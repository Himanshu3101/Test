package com.himanshu.test;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FormViewModel extends BaseObservable {
    private String name;
    private String age;

    public final ObservableField<String> errorAge = new ObservableField<>();
    public final ObservableField<String> errorName = new ObservableField<>();

    FormViewModel(){}

    private MutableLiveData<User> userMutableLiveData;
    LiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    @Bindable
    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull  String name) {
        this.name = name;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    @NonNull
    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR._all);
    }

    void onSubmitClicked(){
        User user = new User(getName(), getAge());
        userMutableLiveData.setValue(user);
    }

}
