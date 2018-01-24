package com.smartnsoft.smartrecyclerviewsample.wrappers;

import android.support.annotation.IntDef;

/**
 * The class description here.
 *
 * @author Adrien Vitti
 * @since 2018.01.22
 */

public final class WrapperType
{
  @IntDef({SimpleTextWrapper, SimpleImageWrapper, PersonWrapper})
  public @interface WrapperTypeIdentifier {}
  static final int SimpleTextWrapper = 0;
  static final int SimpleImageWrapper = 1;
  static final int PersonWrapper = 2;

}
