package com.twoweekhee.goldengoose.back_office.service

import com.twoweekhee.goldengoose.back_office.entity.AppTheme
import com.twoweekhee.goldengoose.back_office.repository.AppThemeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AppThemeService(
    private val appThemeRepository: AppThemeRepository
) {
    
    fun createTheme(appTheme: AppTheme): AppTheme {
        if (appThemeRepository.existsByAppId(appTheme.appId)) {
            throw IllegalArgumentException("Theme for app ${appTheme.appId} already exists")
        }
        return appThemeRepository.save(appTheme)
    }
    
    @Transactional(readOnly = true)
    fun getThemeById(id: Long): AppTheme? {
        return appThemeRepository.findById(id).orElse(null)
    }
    
    @Transactional(readOnly = true)
    fun getThemeByAppId(appId: String): AppTheme? {
        return appThemeRepository.findByAppId(appId)
    }
    
    @Transactional(readOnly = true)
    fun getAllThemes(): List<AppTheme> {
        return appThemeRepository.findAll()
    }
    
    fun updateTheme(id: Long, appTheme: AppTheme): AppTheme? {
        return if (appThemeRepository.existsById(id)) {
            appThemeRepository.save(appTheme.copy(id = id))
        } else null
    }
    
    fun updateThemeByAppId(appId: String, appTheme: AppTheme): AppTheme? {
        return appThemeRepository.findByAppId(appId)?.let { existing ->
            appThemeRepository.save(appTheme.copy(id = existing.id))
        }
    }
    
    fun deleteTheme(id: Long): Boolean {
        return if (appThemeRepository.existsById(id)) {
            appThemeRepository.deleteById(id)
            true
        } else false
    }
    
    fun deleteThemeByAppId(appId: String): Boolean {
        return appThemeRepository.deleteByAppId(appId) > 0
    }
}
