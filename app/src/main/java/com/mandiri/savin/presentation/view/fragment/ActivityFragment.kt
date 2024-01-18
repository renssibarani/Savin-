package com.mandiri.savin.presentation.view.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieDrawable
import com.mandiri.savin.R
import com.mandiri.savin.adapter.ActivityAdapter
import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.databinding.FragmentActivityBinding
import com.mandiri.savin.presentation.base.BaseFragment
import com.mandiri.savin.presentation.view.viewmodel.ActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityFragment : BaseFragment<FragmentActivityBinding>() {
    private val viewModel: ActivityViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentActivityBinding {
        return FragmentActivityBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.apply {
            loading.observe(viewLifecycleOwner) {
                setLoading(it)
            }
        setActivityData()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.activityData.observe(viewLifecycleOwner) {
            setActivityData(it)
        }
    }

    private fun setActivityData(data: List<ActivityModel>) {
        binding.componentActivity.rvActivity.adapter = ActivityAdapter(data)
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