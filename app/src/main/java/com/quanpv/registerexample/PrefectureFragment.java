package com.quanpv.registerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by QuanPV on 4/5/18.
 */

public class PrefectureFragment extends Fragment {

    private RecyclerView rcv_list;
    private List<Data> dataList;
    private Button btn_choose;
    private OnFragmentInteractionListener listener;

    public static PrefectureFragment newInstance(OnFragmentInteractionListener listener) {
        PrefectureFragment fragment = new PrefectureFragment();
        fragment.listener = listener;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prefecture, container, false);

        btn_choose = view.findViewById(R.id.btn_choose);
        rcv_list = view.findViewById(R.id.rcv_list);
        rcv_list.setNestedScrollingEnabled(false);
        createData();
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onFragmentInteraction("1234");
                }
            }
        });
        return view;
    }

    private void createData() {
        String[] contentList1 = new String[]{"北海道"};
        String[] contentList2 = new String[]{"青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県"};
        String[] contentList3 = new String[]{"茨城県", "栃木県", "群馬県", "埼玉県", "千葉県", "東京都", "神奈川県"};
        dataList = new ArrayList<>();
        Data data1 = new Data();
        data1.setTitle("北海道地方");
        data1.setContent(Arrays.asList(contentList1));
        dataList.add(data1);
        Data data2 = new Data();
        data2.setTitle("東北地方");
        data2.setContent(Arrays.asList(contentList2));
        dataList.add(data2);
        Data data3 = new Data();
        data3.setTitle("関東地方");
        data3.setContent(Arrays.asList(contentList3));
        dataList.add(data3);

        rcv_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_list.setAdapter(new ListAdapter(getContext(), dataList));

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String content);
    }

}
