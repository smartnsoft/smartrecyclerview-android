package com.smartnsoft.smartrecyclerviewsample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;

import com.smartnsoft.recyclerview.adapter.DiffUtilSmartRecyclerAdapter;
import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter;
import com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper;

import com.smartnsoft.smartrecyclerviewsample.adapter.SampleDiffUtilSmartRecyclerAdapter;
import com.smartnsoft.smartrecyclerviewsample.wrappers.TextDiffUtilWrapper;

/**
 * An activity containing a RecyclerView with a DiffUtilSmartRecyclerAdapter
 */
public class DiffUtilRecyclerActivity
    extends SimpleRecyclerActivity
{

  @Override
  SmartRecyclerAdapter createRecyclerAdapter()
  {
    return new SampleDiffUtilSmartRecyclerAdapter(DiffUtilRecyclerActivity.this);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    final View shuffle = findViewById(R.id.shuffle);
    shuffle.setVisibility(View.VISIBLE);
    shuffle.setOnClickListener(new OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        final List<SmartRecyclerViewWrapper<?>> wrappers = createWrappers();
        ((DiffUtilSmartRecyclerAdapter) smartRecyclerAdapter).setWrappersForDiffUtil(wrappers);
      }
    });
  }

  @NonNull
  @Override
  protected List<SmartRecyclerViewWrapper<?>> createWrappers()
  {
    final List<SmartRecyclerViewWrapper<?>> wrappers = new ArrayList<>();
    final String[] personNames = getResources().getStringArray(R.array.personNames);
    final List<String> personList = Arrays.asList(personNames);

    final int maxName;
    if (smartRecyclerAdapter.getItemCount() != 0)
    {
      // This code will only be used via the shuffle button
      Collections.shuffle(personList);
      maxName = (int) Math.max(10, personList.size() - Math.random() * personList.size());
    }
    else
    {
      // Standard way to fill the list, will only be done once in this example
      maxName = personList.size();
    }

    for (int index = 0; index < maxName; index++)
    {
      wrappers.add(new TextDiffUtilWrapper(personList.get(index)));
    }
    return wrappers;
  }

  @NonNull
  @Override
  protected LayoutManager getLayoutManager()
  {
    return new GridLayoutManager(DiffUtilRecyclerActivity.this, 3);
  }

}