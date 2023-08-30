package com.example.pgtabme.Fragment;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.view.MenuItemCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pgtabme.API.APIClient;
import com.example.pgtabme.API.APIInterface;
import com.example.pgtabme.Adapter.RecyclerAdapter;
import com.example.pgtabme.Model.DataModel;
import com.example.pgtabme.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_kashksayerlabani extends Fragment implements SearchView.OnQueryTextListener{

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerAdapter adapter;
    ArrayList<DataModel> dataModels = new ArrayList<>();

    public static Fragment newInstance() {

        Bundle args = new Bundle();
        Fragment_kashksayerlabani fragment = new Fragment_kashksayerlabani();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_kashksayerlabani, container, false);
        }
        if (dataModels != null) {
            dataModels.clear();
        }
        recyclerView = view.findViewById(R.id.recyclerview);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_light,android.R.color.holo_green_light,android.R.color.holo_orange_light
        );
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        Request();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (dataModels != null) {
                            dataModels.clear();
                        }
                        Request();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
    public void Request() {

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(linearLayoutManager);
//      adapter=new RecyclerAdapter(dataModels);
//        recyclerView.setAdapter(adapter);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<DataModel>> call = apiInterface.getkashksayerlabani();
        call.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                if (response.isSuccessful()) {

                    for (DataModel data : response.body()) {
                        String code = data.getCode();
                        String title = data.getTitle();
                        String description = data.getDescription();
                        String image_url = data.getImage_url();
                        String category = data.getCategory();

                        dataModels.add(new DataModel(code, title, description, image_url, category));
                        adapter = new RecyclerAdapter(dataModels, getContext());

                    }

                    recyclerView.setAdapter(adapter);

                }


            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Toast.makeText(getContext(), "سایت در حال بروزرسانی می باشد", Toast.LENGTH_SHORT).show();

            }
        });
        //      @Override
//           public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {

//
//            @Override
//            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
//                Toast.makeText(getContext(), "سایت در حال بروزرسانی می باشد", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.serach_action);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setLayoutParams(new ActionBar.LayoutParams(Gravity.LEFT));

        searchView.setOnQueryTextListener(this);


    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        boolean ischeck = false;
        String userinput = s.toLowerCase();
        ArrayList<DataModel> newList = new ArrayList<>();
        for (DataModel name : dataModels) {
            if (name.getTitle().toLowerCase().contains(userinput)) {
                newList.add(name);
                ischeck = true;
            }
        }

        if (ischeck != true) {
            Toast.makeText(getContext(), "محصولي با اين نام يافت نشد!!", Toast.LENGTH_SHORT).show();
        }
        adapter.UpdateList(newList);
        return true;
//
    }
}
