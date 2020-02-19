package ru.valeryvpetrov.androidearn.presentation

import android.util.DisplayMetrics
import android.view.Display
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.fragment_banner_ad.*
import ru.valeryvpetrov.androidearn.R
import ru.valeryvpetrov.androidearn.common.BaseFragment
import ru.valeryvpetrov.androidearn.logger.logD

class BannerAdFragment : BaseFragment() {

    private var initialLayoutComplete = false
    private lateinit var adaptiveBannerAdView: AdView

    override val layoutId = R.layout.fragment_banner_ad

    override fun setupViews() {
        loadStandardBanner()
        setupAdaptiveBanner()
    }

    private fun loadStandardBanner() {
        val adRequest = AdRequest.Builder().build()
        bannerStandardAdView.loadAd(adRequest)
        bannerStandardAdView.adListener = object : AdListener() {
            // Handle add related events
            // For more information see: https://developers.google.com/android/reference/com/google/android/gms/ads/AdListener

            override fun onAdLoaded() {
                super.onAdLoaded()
                logD("Add is loaded: $this")
            }
        }
    }

    private fun setupAdaptiveBanner() {
        adaptiveBannerAdView = AdView(requireContext())
        adaptiveBannerAdView.adUnitId = getString(R.string.test_banner_ad_unit_id)
        bannerAdaptiveContainer.addView(adaptiveBannerAdView)
        bannerAdaptiveContainer.viewTreeObserver.addOnGlobalLayoutListener {
            if (!initialLayoutComplete) {
                initialLayoutComplete = true
                loadAdaptiveBanner()
            }
        }
    }

    private fun loadAdaptiveBanner() {
        val adRequest = AdRequest.Builder().build()
        val adSize = calculateAdSize()
        adaptiveBannerAdView.adSize = adSize
        adaptiveBannerAdView.loadAd(adRequest)
    }

    private fun calculateAdSize(): AdSize {
        val display: Display = requireActivity().windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)

        val density = outMetrics.density
        var widthPixels = bannerAdaptiveContainer.width.toFloat()
        if (widthPixels == 0f) {
            widthPixels = outMetrics.widthPixels.toFloat()
        }

        val adWidth = (widthPixels / density).toInt()
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(requireContext(), adWidth)
    }
}