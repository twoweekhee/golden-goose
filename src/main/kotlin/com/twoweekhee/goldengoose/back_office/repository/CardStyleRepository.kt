package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.CardStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardStyleRepository : JpaRepository<CardStyle, Long> {
    
    fun findByAppId(appId: String): List<CardStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): CardStyle?
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
