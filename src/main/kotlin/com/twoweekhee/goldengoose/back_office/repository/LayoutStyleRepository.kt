package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.LayoutStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LayoutStyleRepository : JpaRepository<LayoutStyle, Long> {
    
    fun findByAppId(appId: String): List<LayoutStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): LayoutStyle?
    
    fun findByLayoutType(layoutType: String): List<LayoutStyle>
    
    fun findByAppIdAndLayoutType(appId: String, layoutType: String): List<LayoutStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
