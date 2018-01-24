package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.content.Context;
import android.view.View;

import com.smartnsoft.smartrecyclerviewsample.wrappers.WrapperType.WrapperTypeIdentifier;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.22
 */

abstract class AbstractSmartRecyclerViewWrapper<T>
    extends com.smartnsoft.recyclerview.wrapper.SmartRecyclerViewWrapper<T>
{

  AbstractSmartRecyclerViewWrapper(T businessObject, @WrapperTypeIdentifier int type, int layoutResourceId)
  {
    super(businessObject, type, layoutResourceId);
  }
}
