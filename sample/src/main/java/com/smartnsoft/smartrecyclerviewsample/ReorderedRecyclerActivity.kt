package com.smartnsoft.smartrecyclerviewsample

import com.smartnsoft.recyclerview.adapter.SmartRecyclerAdapter

/**
 * An activity containing a simple way to use a ReorderRecyclerView
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */
class ReorderedRecyclerActivity : AbstractRecyclerActivity()
{

  override fun getLayoutId(): Int
  {
    return R.layout.reordered_recycler_activity
  }

  override fun createRecyclerAdapter(): SmartRecyclerAdapter
  {
    return SmartRecyclerAdapter(this, true).apply { setHasStableIds(true) }
  }
}