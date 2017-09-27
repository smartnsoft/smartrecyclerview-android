package com.smartnsoft.recyclerview.wrapper;

import android.support.annotation.LayoutRes;

import com.smartnsoft.recyclerview.adapter.DiffUtilSmartRecyclerAdapter;

/**
 * A {@link SmartRecyclerViewWrapper} that implements the {@link SmartDiffUtil} interface in order to be used with the {@link DiffUtilSmartRecyclerAdapter}.
 *
 * @param <BusinessObjectClass> the business object class which is represented by the current wrapper
 * @author Ludovic Roland
 * @see SmartRecyclerViewWrapper
 * @since 2017.09.27
 */
public abstract class DiffUtilSmartRecyclerViewWrapper<BusinessObjectClass>
    extends SmartRecyclerViewWrapper<BusinessObjectClass>
    implements SmartDiffUtil
{

  protected DiffUtilSmartRecyclerViewWrapper(BusinessObjectClass businessObject, int type,
      @LayoutRes int layoutResourceId)
  {
    super(businessObject, type, layoutResourceId);
  }

}
