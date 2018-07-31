package org.akshanhsgusain.testbuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private ArrayList<ModelClass> dataList= new ArrayList<>();
    private ArrayList<ModelClass> blankList=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.mainRecyclerView);
        mSearchView=findViewById(R.id.searchView);
        mSearchView.setOnQueryTextListener(this);
        initList();
        setAdapter();

    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
         adapter= new RecyclerViewAdapter(blankList,MainActivity.this);
        mRecyclerView.setAdapter(adapter);
    }

    private void initList() {
           ArrayList<ModelClass> temp= new ArrayList<>();
           temp.add(new ModelClass("India"));
         temp.add(new ModelClass("oreo"));
        temp.add(new ModelClass("pband j"));
        temp.add(new ModelClass("icecream sandwich"));
        temp.add(new ModelClass("Europe"));
        temp.add(new ModelClass("maldives"));
        dataList=temp;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
         newText= newText.toLowerCase();
         ArrayList<ModelClass> temp=new ArrayList<>();
             for (ModelClass m:dataList){
                  String name=m.getSingleItem().toLowerCase();
                    if(name.contains(newText))
                    {
                        temp.add(m);
                    }
             }
             adapter.setFilters(temp);
        return false;
    }
}
