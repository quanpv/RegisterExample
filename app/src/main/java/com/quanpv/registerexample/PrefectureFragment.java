package com.quanpv.registerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by QuanPV on 4/5/18.
 */

public class PrefectureFragment extends Fragment {

    private RecyclerView rcv_list;
    private List<Data> dataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prefecture, container, false);

        rcv_list = view.findViewById(R.id.rcv_list);
        createData();

        return view;
    }

    private void createData() {
        String[] contentList1 = new String[]{"1月", "2月", "3月", "4月"};
        String[] contentList2 = new String[]{"グルメが充実", "絶景・景観が充実", "名所・観光地が充実", "フォトスポットが充実"};
        String[] contentList3 = new String[]{"都会・街中", "田舎・村里", "森林・林間"};
        dataList = new ArrayList<>();
        Data data1 = new Data();
        data1.setTitle("おすすめの月");
        data1.setContent(Arrays.asList(contentList1));
        dataList.add(data1);
        Data data2 = new Data();
        data2.setTitle("コーステーマ");
        data2.setContent(Arrays.asList(contentList2));
        dataList.add(data2);
        Data data3 = new Data();
        data3.setTitle("コースエリア");
        data3.setContent(Arrays.asList(contentList3));
        dataList.add(data3);

        rcv_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_list.setAdapter(new ListAdapter(getContext(), dataList));

    }

}
