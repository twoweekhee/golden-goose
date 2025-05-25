package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.TextStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TextStyleRepository : JpaRepository<TextStyle, Long> {
    
    fun findByAppId(appId: String): List<TextStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): TextStyle?
    
    fun findByFontFamily(fontFamily: String): List<TextStyle>
    
    fun findByAppIdAndFontFamily(appId: String, fontFamily: String): List<TextStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
