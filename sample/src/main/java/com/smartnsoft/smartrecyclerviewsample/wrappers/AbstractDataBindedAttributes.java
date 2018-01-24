package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.smartnsoft.recyclerview.attributes.SmartRecyclerAttributes;

import com.smartnsoft.smartrecyclerviewsample.BR;
import com.smartnsoft.smartrecyclerviewsample.databinding.PersonItemBinding;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.24
 */

abstract class AbstractDataBindedAttributes<T>
    extends SmartRecyclerAttributes<T>
{

  protected final ViewDataBinding dataBinding;

  public AbstractDataBindedAttributes(View view)
  {
    super(view);
    dataBinding = DataBindingUtil.getBinding(view);
  }

  @Override
  public void onBusinessObjectUpdated(T businessObject, boolean isSelected)
  {
    super.onBusinessObjectUpdated(businessObject, isSelected);
    dataBinding.setVariable(getVariableID(), businessObject);
  }

  protected abstract int getVariableID();

}
