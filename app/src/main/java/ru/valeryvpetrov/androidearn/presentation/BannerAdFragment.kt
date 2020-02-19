package ru.valeryvpetrov.androidearn.presentation

import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.fragment_banner_ad.*
import ru.valeryvpetrov.androidearn.R
import ru.valeryvpetrov.androidearn.common.BaseFragment
import ru.valeryvpetrov.androidearn.logger.logD

class BannerAdFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_banner_ad

    override fun setupViews() {
        loadStandardBanner()
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
}