package com.smartnsoft.smartrecyclerviewsample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter;
import com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper;

import com.smartnsoft.smartrecyclerviewsample.wrappers.SimpleImageWrapper;
import com.smartnsoft.smartrecyclerviewsample.wrappers.SimpleTextWrapper;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment
    extends Fragment
{

  private RecyclerView recyclerView;

  private SmartRecyclerAdapter smartRecyclerAdapter;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState)
  {
    final View view = inflater.inflate(R.layout.fragment_main, container, false);

    recyclerView = view.findViewById(R.id.recyclerView);
    setupRecyclerView();

    return view;
  }

  private void setupRecyclerView()
  {
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    smartRecyclerAdapter = new SmartRecyclerAdapter(getContext(), true);
    // The intentFilterCategory is used by Attributes if we want to send a LocalBroadcast for a specific Fragment
    final String intentFilterCategory = String.valueOf(System.identityHashCode(MainActivityFragment.this));
    smartRecyclerAdapter.setIntentFilterCategory(intentFilterCategory);

    recyclerView.setAdapter(smartRecyclerAdapter);
  }

  @Override
  public void onResume()
  {
    super.onResume();
    fillRecyclerViewIfEmpty();
  }

  private void fillRecyclerViewIfEmpty()
  {
    if (smartRecyclerAdapter.getItemCount() == 0)
    {
      final List<SmartRecyclerViewWrapper<?>> wrappers = new ArrayList<>();
      for (int index = 0; index < 60; index++)
      {
        if (index != 0 && index % 10 == 0)
        {
          final int businessObject;
          switch (index % 50)
          {
            case 10:
              businessObject = R.drawable.cheese_1;
              break;
            case 20:
              businessObject = R.drawable.cheese_2;
              break;
            case 30:
              businessObject = R.drawable.cheese_3;
              break;
            case 40:
              businessObject = R.drawable.cheese_4;
              break;
            default:
              businessObject = R.drawable.cheese_5;
              break;
          }
          wrappers.add(new SimpleImageWrapper(businessObject));
        }
        else
        {
          wrappers.add(new SimpleTextWrapper("String #" + index));
        }
      }
      smartRecyclerAdapter.addAll(wrappers);
    }
  }
}
