package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.InputStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InputStyleRepository : JpaRepository<InputStyle, Long> {
    
    fun findByAppId(appId: String): List<InputStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): InputStyle?
    
    fun findByInputType(inputType: String): List<InputStyle>
    
    fun findByAppIdAndInputType(appId: String, inputType: String): List<InputStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
