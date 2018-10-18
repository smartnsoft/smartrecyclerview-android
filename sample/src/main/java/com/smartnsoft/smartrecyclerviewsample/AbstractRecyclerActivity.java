package com.smartnsoft.smartrecyclerviewsample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;

import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter;
import com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper;

import com.smartnsoft.smartrecyclerviewsample.wrappers.SimpleImageWrapper;
import com.smartnsoft.smartrecyclerviewsample.wrappers.SimpleTextWrapper;

/**
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

public abstract class AbstractRecyclerActivity
    extends AppCompatActivity
{

  protected RecyclerView recyclerView;

  protected SmartRecyclerAdapter smartRecyclerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    recyclerView = findViewById(R.id.recyclerView);
    setupRecyclerView();
  }

  @LayoutRes
  abstract int getLayoutId();

  protected void setupRecyclerView()
  {
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(getLayoutManager());
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    smartRecyclerAdapter = createRecyclerAdapter();
    // The intentFilterCategory is used by Attributes if we want to send a LocalBroadcast for a specific Fragment
    final String intentFilterCategory = String.valueOf(System.identityHashCode(AbstractRecyclerActivity.this));
    smartRecyclerAdapter.setIntentFilterCategory(intentFilterCategory);

    recyclerView.setAdapter(smartRecyclerAdapter);
  }

  @NonNull
  protected LayoutManager getLayoutManager()
  {
    return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
  }

  abstract SmartRecyclerAdapter createRecyclerAdapter();

  @Override
  public final void onResume()
  {
    super.onResume();
    fillRecyclerViewIfEmpty();
  }

  protected void fillRecyclerViewIfEmpty()
  {
    if (smartRecyclerAdapter.getItemCount() == 0)
    {
      final List<SmartRecyclerViewWrapper<?>> wrappers = createWrappers();
      smartRecyclerAdapter.addAll(wrappers);
    }
  }

  @NonNull
  protected List<SmartRecyclerViewWrapper<?>> createWrappers()
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
    return wrappers;
  }

}