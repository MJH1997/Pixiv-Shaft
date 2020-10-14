package ceui.lisa.adapters

import android.content.Context
import ceui.lisa.R
import ceui.lisa.databinding.RecyMangaSeriesBinding
import ceui.lisa.models.MangaSeriesItem
import ceui.lisa.utils.GlideUtil
import com.bumptech.glide.Glide

class MangaSeriesAdapter(
        targetList: MutableList<MangaSeriesItem>,
        context: Context
): BaseAdapter<MangaSeriesItem, RecyMangaSeriesBinding>(targetList, context) {

    override fun initLayout() {
        mLayoutID = R.layout.recy_manga_series
    }

    override fun bindData(target: MangaSeriesItem, bindView: ViewHolder<RecyMangaSeriesBinding>, position: Int) {
        bindView.baseBind.seriesTitle.text = "#" + target.title
        bindView.baseBind.seriesSize.text = "共" + target.series_work_count + "话"
        Glide.with(mContext)
                .load(GlideUtil.getArticle(target.cover_image_urls.medium))
                .into(bindView.baseBind.imageView)
    }
}