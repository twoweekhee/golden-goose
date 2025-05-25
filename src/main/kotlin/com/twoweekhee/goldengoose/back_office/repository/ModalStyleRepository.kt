package com.twoweekhee.goldengoose.back_office.repository

import com.twoweekhee.goldengoose.back_office.entity.ModalStyle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModalStyleRepository : JpaRepository<ModalStyle, Long> {
    
    fun findByAppId(appId: String): List<ModalStyle>
    
    fun findByAppIdAndStyleName(appId: String, styleName: String): ModalStyle?
    
    fun findByModalType(modalType: String): List<ModalStyle>
    
    fun findByAppIdAndModalType(appId: String, modalType: String): List<ModalStyle>
    
    fun deleteByAppId(appId: String): Int
    
    fun deleteByAppIdAndStyleName(appId: String, styleName: String): Int
}
