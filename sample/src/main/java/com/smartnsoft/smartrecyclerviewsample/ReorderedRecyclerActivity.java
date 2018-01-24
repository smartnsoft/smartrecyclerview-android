package com.smartnsoft.smartrecyclerviewsample;

import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter;
import com.smartnsoft.recyclerview.adapter.SmartReorderAdapter;

/**
 * An activity containing a simple way to use a ReorderRecyclerView with a SmartReorderAdapter
 */
public final class ReorderedRecyclerActivity
    extends AbstractRecyclerActivity
{

  @Override
  int getLayoutId()
  {
    return R.layout.reordered_recycler_activity;
  }

  @Override
  SmartRecyclerAdapter createRecyclerAdapter()
  {
    final SmartReorderAdapter smartReorderAdapter = new SmartReorderAdapter(this);
    smartReorderAdapter.setHasStableIds(true);
    return smartReorderAdapter;
  }

}