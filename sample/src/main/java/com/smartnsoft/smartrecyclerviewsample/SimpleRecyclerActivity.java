package com.smartnsoft.smartrecyclerviewsample;

import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter;

/**
 * An activity containing a simple way to use a RecyclerView with a SmartRecyclerAdapter
 */
public class SimpleRecyclerActivity
    extends AbstractRecyclerActivity
{

  @Override
  int getLayoutId()
  {
    return R.layout.simple_recycler_activity;
  }

  @Override
  SmartRecyclerAdapter createRecyclerAdapter()
  {
    return new SmartRecyclerAdapter(this, true);
  }

}