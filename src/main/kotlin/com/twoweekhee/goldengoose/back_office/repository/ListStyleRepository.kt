package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.ListStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ListStyleRepository : JpaRepository<ListStyle, Long> {
    
    fun findByAppId(appId: String): List<ListStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): ListStyle?
    
    fun findByListType(listType: String): List<ListStyle>
    
    fun findByAppIdAndListType(appId: String, listType: String): List<ListStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
