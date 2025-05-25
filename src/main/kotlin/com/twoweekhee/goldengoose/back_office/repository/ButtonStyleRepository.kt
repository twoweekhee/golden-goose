package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.ButtonStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ButtonStyleRepository : JpaRepository<ButtonStyle, Long> {
    
    fun findByAppId(appId: String): List<ButtonStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): ButtonStyle?
    
    fun findByButtonType(buttonType: String): List<ButtonStyle>
    
    fun findByAppIdAndButtonType(appId: String, buttonType: String): List<ButtonStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
