package com.smartnsoft.recyclerview.attributes

import android.view.MotionEvent
import android.view.View
import com.smartnsoft.recyclerview.recyclerview.SmartReorderRecyclerView

/**
 * This class is responsible for creating a new [View], which is able to represent the provided business object
 * and can also be reordered using a view as a trigger.
 * It is similar to a simple [SmartRecyclerAttributes] if the RecyclerView is not a [SmartReorderRecyclerView]
 *
 * @author Adrien Vitti
 * @since 2019.07.15
 */
abstract class SmartReorderRecyclerAttributes<BusinessObjectType>(view: View)
  : SmartRecyclerAttributes<BusinessObjectType>(view)
{

  /**
   * Specify which view can trigger the reordering when touching it.
   *
   * @return the view which will be used by the touch listener to move the view in the list
   */
  abstract fun getTriggerViewForReorder(): View?

  private var draggingTouchListener: View.OnTouchListener? = null

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