package com.smartnsoft.smartrecyclerviewsample.adapter;

import java.util.List;

import android.content.Context;

import com.smartnsoft.recyclerview.adapter.DiffUtilSmartRecyclerAdapter;
import com.smartnsoft.recyclerview.attributes.SmartRecyclerAttributes;
import com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper;

/**
 * A simple implementation of the DiffUtilSmartRecyclerAdapter
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

public class SampleDiffUtilSmartRecyclerAdapter
    extends DiffUtilSmartRecyclerAdapter
{

  private static class TextDiffUtilCallback
      extends SmartDiffUtilCallback
  {

    public TextDiffUtilCallback(
        List<? extends SmartRecyclerViewWrapper<?>> oldWrappers,
        List<? extends SmartRecyclerViewWrapper<?>> newWrappers)
    {
      super(oldWrappers, newWrappers);
    }

    @Override
    protected Object getChangePayloadCustom(int oldItemPosition, int newItemPosition, Object oldBusinessObject,
        Object newBusinessObject)
    {
      return SmartDiffUtilCallback.ITEM_CHANGED_PAYLOAD;
    }
  }

  private SmartDiffUtilCallback smartDiffUtilCallback;

  public SampleDiffUtilSmartRecyclerAdapter(Context context)
  {
    super(context);
  }

  @Override
  public boolean onBindViewHolderCustom(SmartRecyclerAttributes holder, int position, Object payload)
  {
    return false;
  }

  @Override
  public <T extends SmartDiffUtilCallback> T getDiffUtilCallback(
      List<? extends SmartRecyclerViewWrapper<?>> oldWrappers,
      List<? extends SmartRecyclerViewWrapper<?>> newWrappers)
  {
    return (T) new TextDiffUtilCallback(oldWrappers, newWrappers);
  }
}
