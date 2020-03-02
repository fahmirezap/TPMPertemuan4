package com.example.pahlawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PahlawanFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pahlawan, container, false);

        rvPahlawan =root.findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        list.addAll(DataPahlawan.getListData());
        recyclerView();

        return root;
    }

    private void recyclerView() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterPahlawan adapterPahlawan = new AdapterPahlawan(getContext());
        adapterPahlawan.setList(list);
        rvPahlawan.setAdapter(adapterPahlawan);

        adapterPahlawan.setOnItemClikCallback(new AdapterPahlawan.OnItemClikCallback() {
            @Override
            public void onItemCliked(ModelPahlawan pahlawan) {
                Toast.makeText(getContext(), pahlawan.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), DetailPahlawan.class);
                intent.putExtra(DetailPahlawan.DATA,pahlawan);
                startActivity(intent);
            }
        });

    }
}
