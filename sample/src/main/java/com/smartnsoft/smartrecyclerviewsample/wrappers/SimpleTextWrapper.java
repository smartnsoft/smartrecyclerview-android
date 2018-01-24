package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.content.Context;
import android.view.View;

import com.smartnsoft.smartrecyclerviewsample.R;

/**
 * A RecyclerViewWrapper with a simple String as business object
 *
 * @author Adrien Vitti
 * @since 2018.01.22
 */

public final class SimpleTextWrapper
    extends AbstractSmartRecyclerViewWrapper<String>
{

  public SimpleTextWrapper(String businessObject)
  {
    super(businessObject, WrapperType.SimpleTextWrapper, R.layout.simple_text_item);
  }

  @Override
  protected Object extractNewViewAttributes(Context context, View view, String businessObject)
  {
    return new SimpleTextAttributes(view);
  }

}
