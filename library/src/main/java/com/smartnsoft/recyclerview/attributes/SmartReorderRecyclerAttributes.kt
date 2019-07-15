package com.smartnsoft.recyclerview.attributes

import android.view.MotionEvent
import android.view.View
import com.smartnsoft.recyclerview.recyclerview.SmartReorderRecyclerView

/**
 * Is responsible for creating a new {@link View}, which is able to represent the provided business object and be reordered.
 *
 * @author Adrien Vitti
 * @since 2019.07.15
 */
abstract class SmartReorderRecyclerAttributes<BusinessObjectType>(view: View)
  : SmartRecyclerAttributes<BusinessObjectType>(view)
{

  abstract fun getTriggerViewForReorder(): View?

  var draggingTouchListener: View.OnTouchListener? = null

  override fun update(businessObject: BusinessObjectType, isSelected: Boolean)
  {
    val triggerViewForReorder = getTriggerViewForReorder()
    if (draggingTouchListener == null)
    {
      triggerViewForReorder?.let { triggerView ->
        draggingTouchListener = View.OnTouchListener { _, event ->
          if (event.actionMasked == MotionEvent.ACTION_DOWN)
          {
            (itemView.parent as? SmartReorderRecyclerView)?.itemTouchHelper?.startDrag(this)
          }
          return@OnTouchListener true
        }
        triggerView.setOnTouchListener(draggingTouchListener)
      }
    }
    super.update(businessObject, isSelected)
  }

}