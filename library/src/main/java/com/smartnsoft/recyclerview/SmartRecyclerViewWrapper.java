// The MIT License (MIT)
//
// Copyright (c) 2017 Smart&Soft
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package com.smartnsoft.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.smartnsoft.droid4me.framework.SmartAdapters.ObjectEvent;
import com.smartnsoft.droid4me.framework.SmartAdapters.SimpleBusinessViewWrapper;

/**
 * Wraps a business object and its underlying Android {@link View} in a {@link RecyclerView}.
 *
 * @param <BusinessObjectClass> the business object class which is represented by the current wrapper
 * @author Jocelyn Girard, Ludovic Roland
 * @since 2014.04.16
 */
public abstract class SmartRecyclerViewWrapper<BusinessObjectClass>
    extends SimpleBusinessViewWrapper<BusinessObjectClass>
{

  public SmartRecyclerViewWrapper(BusinessObjectClass businessObject, int type, @LayoutRes int layoutResourceId)
  {
    super(businessObject, type, layoutResourceId);
  }

  @Override
  public final int getType(int position, BusinessObjectClass businessObjectClass)
  {
    return super.getType(position, businessObjectClass);
  }

  @Override
  @Deprecated
  public final boolean isEnabled(BusinessObjectClass businessObject)
  {
    return super.isEnabled(businessObject);
  }

  @Override
  @Deprecated
  public final boolean containsText(BusinessObjectClass businessObject, String lowerText)
  {
    return super.containsText(businessObject, lowerText);
  }

  @Override
  @Deprecated
  public final Intent computeIntent(Activity activity, Object viewAttributes, View view,
      BusinessObjectClass businessObject, ObjectEvent objectEvent, int position)
  {
    return super.computeIntent(activity, viewAttributes, view, businessObject, objectEvent, position);
  }

  @Override
  @Deprecated
  public final boolean onObjectEvent(Activity activity, Object viewAttributes, View view,
      BusinessObjectClass businessObject, ObjectEvent objectEvent, int position)
  {
    return super.onObjectEvent(activity, viewAttributes, view, businessObject, objectEvent, position);
  }

  @Override
  protected abstract Object extractNewViewAttributes(Activity activity, View view,
      BusinessObjectClass businessObjectClass);

  @Deprecated
  @Override
  protected void updateView(Activity activity, LayoutInflater layoutInflater, Object o, View view,
      BusinessObjectClass businessObjectClass, int i)
  {

  }

  public final int getType()
  {
    return getType(Integer.MIN_VALUE);
  }

  public int getSpanSize()
  {
    return 1;
  }
}
