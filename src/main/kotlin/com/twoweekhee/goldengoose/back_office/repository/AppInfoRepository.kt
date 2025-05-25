package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.AppInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppInfoRepository : JpaRepository<AppInfo, Long> {
    
    fun findByAppId(appId: String): AppInfo?
    
    fun existsByAppId(appId: String): Boolean
    
    fun findByAppName(appName: String): AppInfo?
    
    fun findByStatus(status: String): List<AppInfo>
    
    fun deleteByAppId(appId: String): Int
}
