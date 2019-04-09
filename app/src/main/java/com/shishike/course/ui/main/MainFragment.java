package com.shishike.course.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shishike.course.base.BaseFragment;
import com.shishike.course.R;
import com.shishike.course.bean.SubjectBean;
import com.shishike.course.ui.main.adapter.SubjectAdapter;

import java.lang.reflect.Type;
import java.util.List;

public class MainFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private ListView listView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        Type listType = new TypeToken<List<SubjectBean>>(){}.getType();
        List<SubjectBean> subjectBeanList = new Gson().fromJson(testData(),listType);

        listView = rootView.findViewById(R.id.subject_list_view);
        listView.setAdapter(new SubjectAdapter(getActivity(),subjectBeanList));
        Log.d(TAG,subjectBeanList.toString());

        return rootView;
    }

    private String testData(){
        return "[{\"name\":\"测试\",\"icon\":\"icon1\",\"chapters\":[{\"name\":\"chapter1\",\"classes\":[{\"name\":\"classes1\",\"content\":\"content1\"}]}]},{\"name\":\"测试\",\"icon\":\"icon1\",\"chapters\":[{\"name\":\"chapter1\",\"classes\":[{\"name\":\"classes1\",\"content\":\"content1\"}]}]}]\n";
    }
}
