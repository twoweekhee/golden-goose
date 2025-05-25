package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.ImageStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageStyleRepository : JpaRepository<ImageStyle, Long> {
    
    fun findByAppId(appId: String): List<ImageStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): ImageStyle?
    
    fun findByResizeMode(resizeMode: String): List<ImageStyle>
    
    fun findByAspectRatio(aspectRatio: String): List<ImageStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
