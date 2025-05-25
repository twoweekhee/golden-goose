package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.IconStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IconStyleRepository : JpaRepository<IconStyle, Long> {
    
    fun findByAppId(appId: String): List<IconStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): IconStyle?
    
    fun findByIconFamily(iconFamily: String): List<IconStyle>
    
    fun findByAppIdAndIconFamily(appId: String, iconFamily: String): List<IconStyle>
    
    fun findBySize(size: Int): List<IconStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
