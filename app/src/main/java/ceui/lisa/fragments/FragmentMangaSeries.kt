package ceui.lisa.fragments

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import ceui.lisa.R
import ceui.lisa.adapters.BaseAdapter
import ceui.lisa.adapters.MangaSeriesAdapter
import ceui.lisa.core.BaseRepo
import ceui.lisa.databinding.FragmentBaseListBinding
import ceui.lisa.model.ListMangaSeries
import ceui.lisa.models.MangaSeriesItem
import ceui.lisa.repo.MangaSeriesRepo
import ceui.lisa.utils.DensityUtil
import ceui.lisa.utils.Params
import ceui.lisa.view.LinearItemDecoration
import ceui.lisa.view.LinearItemDecorationNoLRTB

class FragmentMangaSeries : NetListFragment<FragmentBaseListBinding, ListMangaSeries, MangaSeriesItem>() {

    private var userID: Int = 0

    override fun initBundle(bundle: Bundle) {
        userID = bundle.getInt(Params.USER_ID)
    }

    companion object {
        @JvmStatic
        fun newInstance(userID: Int): FragmentMangaSeries {
            return FragmentMangaSeries().apply {
                arguments = Bundle().apply {
                    putInt(Params.USER_ID, userID)
                }
            }
        }
    }

    override fun adapter(): BaseAdapter<*, out ViewDataBinding> {
        return MangaSeriesAdapter(allItems, mContext)
    }

    override fun repository(): BaseRepo {
        return MangaSeriesRepo(userID)
    }

    override fun getToolbarTitle(): String {
        return getString(R.string.string_230)
    }

    override fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView.addItemDecoration(LinearItemDecorationNoLRTB(DensityUtil.dp2px(1.0f)))
    }
}