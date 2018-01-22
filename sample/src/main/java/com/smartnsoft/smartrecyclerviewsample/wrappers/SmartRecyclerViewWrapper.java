package com.smartnsoft.smartrecyclerviewsample.wrappers;

import com.smartnsoft.smartrecyclerviewsample.wrappers.WrapperType.WrapperTypeIdentifier;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.22
 */

abstract class SmartRecyclerViewWrapper<T>
    extends com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper<T>
{

  SmartRecyclerViewWrapper(T businessObject, @WrapperTypeIdentifier int type, int layoutResourceId)
  {
    super(businessObject, type, layoutResourceId);
  }
}
