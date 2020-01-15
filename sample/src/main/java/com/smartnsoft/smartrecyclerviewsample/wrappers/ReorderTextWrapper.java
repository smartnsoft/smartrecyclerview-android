package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.content.Context;
import android.view.View;

import com.smartnsoft.smartrecyclerviewsample.R;

/**
 * A RecyclerViewWrapper with a simple String as business object
 *
 * @author Adrien Vitti
 * @since 2019.07.15
 */

public final class ReorderTextWrapper
    extends AbstractSmartRecyclerViewWrapper<String>
{

  public ReorderTextWrapper(String businessObject)
  {
    super(businessObject, WrapperType.ReorderTextWrapper, R.layout.reorder_text_item);
  }

  @Override
  protected Object extractNewViewAttributes(Context context, View view, String businessObject)
  {
    return new ReorderTextAttributes(view);
  }

}
