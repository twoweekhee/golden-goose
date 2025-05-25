package com.twoweekhee.goldengoose.back_office.service

import com.twoweekhee.goldengoose.back_office.entity.AppInfo
import com.twoweekhee.goldengoose.back_office.repository.AppInfoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AppInfoService(
    private val appInfoRepository: AppInfoRepository
) {
    
    fun createApp(appInfo: AppInfo): AppInfo {
        if (appInfoRepository.existsByAppId(appInfo.appId)) {
            throw IllegalArgumentException("App with ID ${appInfo.appId} already exists")
        }
        return appInfoRepository.save(appInfo)
    }
    
    @Transactional(readOnly = true)
    fun getAppById(id: Long): AppInfo? {
        return appInfoRepository.findById(id).orElse(null)
    }
    
    @Transactional(readOnly = true)
    fun getAppByAppId(appId: String): AppInfo? {
        return appInfoRepository.findByAppId(appId)
    }
    
    @Transactional(readOnly = true)
    fun getAllApps(): List<AppInfo> {
        return appInfoRepository.findAll()
    }
    
    @Transactional(readOnly = true)
    fun getAppsByStatus(status: String): List<AppInfo> {
        return appInfoRepository.findByStatus(status)
    }
    
    fun updateApp(id: Long, appInfo: AppInfo): AppInfo? {
        return if (appInfoRepository.existsById(id)) {
            appInfoRepository.save(appInfo.copy(id = id))
        } else null
    }
    
    fun deleteApp(id: Long): Boolean {
        return if (appInfoRepository.existsById(id)) {
            appInfoRepository.deleteById(id)
            true
        } else false
    }
    
    fun deleteAppByAppId(appId: String): Boolean {
        return appInfoRepository.deleteByAppId(appId) > 0
    }
    
    @Transactional(readOnly = true)
    fun existsByAppId(appId: String): Boolean {
        return appInfoRepository.existsByAppId(appId)
    }
}
