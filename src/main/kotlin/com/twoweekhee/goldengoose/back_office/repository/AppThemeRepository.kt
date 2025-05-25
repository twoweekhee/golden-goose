package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.AppTheme
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppThemeRepository : JpaRepository<AppTheme, Long> {
    
    fun findByAppId(appId: String): AppTheme?
    
    fun existsByAppId(appId: String): Boolean
    
    fun deleteByAppId(appId: String): Int
}
