package com.mandiri.savin.presentation.view.fragment

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieDrawable
import com.mandiri.savin.R
import com.mandiri.savin.adapter.ActivityAdapter
import com.mandiri.savin.api.entity.ActivityModel
import com.mandiri.savin.databinding.FragmentHistoryBinding
import com.mandiri.savin.presentation.base.BaseFragment
import com.mandiri.savin.presentation.view.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {

    private val viewModel: HistoryViewModel by viewModels()
    private lateinit var activityAdapter: ActivityAdapter
    private lateinit var originalData: List<ActivityModel>

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.apply {
            loading.observe(viewLifecycleOwner) {
                setLoading(it)
            }
            setActivityData()
        }
        activityAdapter = ActivityAdapter(emptyList())
        binding.componentActivity.rvActivity.adapter = activityAdapter

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterData(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        observeViewModel()
    }

    private fun filterData(query: String) {
        val filteredList = originalData.filter {
            it.title.contains(query, ignoreCase = true) ||
                    it.date.contains(query, ignoreCase = true) ||
                    it.balance.contains(query, ignoreCase = true)
        }
        activityAdapter.filterList(filteredList)
    }

    private fun observeViewModel() {
        viewModel.activityData.observe(viewLifecycleOwner) {
            setActivityData(it)
        }
    }

    private fun setActivityData(data: List<ActivityModel>) {
        originalData = data
        activityAdapter.filterList(data)
    }

    private fun setLoading(isLoading: Boolean) {
        binding.loSplash.apply {
            visibility = if (isLoading) View.VISIBLE else View.GONE
            setAnimation(R.raw.lo_loadingnew)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }
}