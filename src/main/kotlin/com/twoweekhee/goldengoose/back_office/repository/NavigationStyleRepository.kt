package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.NavigationStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NavigationStyleRepository : JpaRepository<NavigationStyle, Long> {
    
    fun findByAppId(appId: String): List<NavigationStyle>
    
    fun findByAppIdAndNavTypeAndStyleName(appId: String, navType: String, styleName: String): NavigationStyle?
    
    fun findByNavType(navType: String): List<NavigationStyle>
    
    fun findByAppIdAndNavType(appId: String, navType: String): List<NavigationStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndNavTypeAndStyleName(appId: String, navType: String, styleName: String): Int
}
